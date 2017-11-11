package gpw.action.export;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import gpw.getInfo.GetExpert;
import gpw.getInfo.GetTableStru;
import gpw.object.Expert;
import gpw.object.Methods;
import gpw.object.Tablestru;

public class ExcelAction extends ActionSupport{
	private List<Expert> expertList;
	private GetExpert objGetExpert;
	private GetTableStru objGetTableStru; //表格中的标题
	private List<Tablestru> titleList;
	private Methods objMethod;
	
	private String fileName="专家信息表";
	private String filePath=File.separator + "excelTemplate" + File.separator;
	
	public String initForGLY() throws Exception {
		
		objGetExpert = new GetExpert();
		objGetTableStru = new GetTableStru();
		
		HttpServletResponse response = ServletActionContext.getResponse();
		
		expertList = objGetExpert.getAllExpertsFromInfoView();
		//System.out.println(expertList);
		titleList = objGetTableStru.getAllTableStrus();
		
		HSSFWorkbook workbook = exportExcel(expertList, titleList);
		if(workbook != null){
			this.printExcel(workbook,response,"Excel.xls");
		}
		return SUCCESS;
	}
	
public String initForGPW() throws Exception {
		
		objGetExpert = new GetExpert();
		objGetTableStru = new GetTableStru();
		objMethod = new Methods();
		
		HttpServletResponse response = ServletActionContext.getResponse();
		
		expertList = objGetExpert.getExpertsFromAJury(objMethod.getCurrentUser().getUser_jury());
		//System.out.println(expertList);
		titleList = objGetTableStru.getAllTableStrus();
		
		HSSFWorkbook workbook = exportExcel(expertList, titleList);
		if(workbook != null){
			this.printExcel(workbook,response,"Excel.xls");
		}
		return SUCCESS;
	}
	
	//导出excel
	private void printExcel(HSSFWorkbook workbook, HttpServletResponse response, String string) throws IOException{
		
		OutputStream out = response.getOutputStream();
		response.setHeader("Content-disposition", "attachment;filename=" + "ExpertInfo.xls");
		response.setContentType("application/msexcel);charset=UTF-8");
		workbook.write(out);
		out.flush();
		out.close();
	}
	
	private void setSheetColumnWidth(HSSFSheet sheet){
		for(int i=0; i<35; i++){
			sheet.setColumnWidth((short) i, (short) 3000);
		}
	}
	
	private HSSFCellStyle createTitleStyle(HSSFWorkbook wb){
		HSSFFont boldFont = wb.createFont();
		boldFont.setFontHeight((short) 200);
		HSSFCellStyle style = wb.createCellStyle();
		style.setFont(boldFont);
		style.setDataFormat(HSSFDataFormat.getBuiltinFormat("###,##0.00"));
		return style;
	}
	
	private void createCell(HSSFRow row, int column, HSSFCellStyle style, int cellType, String value){
		HSSFCell cell = row.createCell((short) column);
		if (style != null){
			cell.setCellStyle(style);
		}
		switch (cellType){
			case HSSFCell.CELL_TYPE_BLANK:{}
				break;
			case HSSFCell.CELL_TYPE_STRING:{cell.setCellValue(value);}
				break;
			case HSSFCell.CELL_TYPE_NUMERIC:{
				cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
				cell.setCellValue(Double.parseDouble(value));
			}
				break;
			default:
				break;
		}
	}
	
	public HSSFWorkbook exportExcel(List<Expert> dataList, List<Tablestru> titleList) throws Exception{
		HSSFWorkbook workbook = null;
		try{
			//创建工作薄
			workbook = new HSSFWorkbook();
			//创建工作表
			HSSFSheet sheet = workbook.createSheet("Excel");
			//设置列宽
			this.setSheetColumnWidth(sheet);
			//获取样式
			HSSFCellStyle style = this.createTitleStyle(workbook);
			
			
			if (dataList != null && dataList.size() > 0){
				//创建第一行标题
				HSSFRow row = sheet.createRow((short) 0);
				for(int i=0; i<titleList.size(); i++){
					String tempI = "" + (i+1);
					//System.out.println("124: tempI:" + tempI + "chname:" + titleList.get(i).getChnameById(tempI));
					this.createCell(row, i, style, HSSFCell.CELL_TYPE_STRING, titleList.get(i).getChnameById(tempI));
				}
				
				//填充数据
				for(int i=0; i<dataList.size(); i++){
					Expert model = (Expert)dataList.get(i);
					HSSFRow row1 = sheet.createRow((short)(i+1));
					for(int j=0; j<titleList.size(); j++){
						if(model.getExpert(j) != null){
							this.createCell(row1, j, style, HSSFCell.CELL_TYPE_STRING, model.getExpert(j+1));
						}
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return workbook;
	}
	
}
