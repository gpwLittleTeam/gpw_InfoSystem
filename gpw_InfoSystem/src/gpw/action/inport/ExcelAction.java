package gpw.action.inport;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.opensymphony.xwork2.ActionSupport;

import gpw.algorithm.AuthCode;
import gpw.getInfo.GetJuryIdcode;
import gpw.object.ExcelWorkSheet;
import gpw.object.JuryIdcode;
import gpw.object.Methods;
import gpw.operateDatabase.Insert;

public class ExcelAction extends ActionSupport {

	private File excelFile; // 与jsp页面的file标签的name属性一样
	private String excelFileFileName; // File对象的名称+FileName，一定要这样写，不然名称获取不到
	private ExcelWorkSheet<JuryIdcode> excelWorkSheet;

	private List<JuryIdcode> juryIdcodes;
	private GetJuryIdcode getJuryIdcode;
	private Methods objMethods = new Methods();
	private Insert insert;
	
	public String execute() throws Exception {
		//System.out.println("gpw.action.inport.ExcelAction.execute()");
		Workbook workbook = createWorkbook(new FileInputStream(excelFile));
		Sheet sheet = workbook.getSheetAt(0); // 得到第一个sheet
		excelWorkSheet = new ExcelWorkSheet<JuryIdcode>();
		Row firstRow = sheet.getRow(0); // 得到第一行，也就是列名
		Iterator<Cell> iterator = firstRow.cellIterator(); // 得到第一行的迭代器
		List<String> cellNames = new ArrayList<String>(); // 列名的集合

		// 将列名取出来
		while (iterator.hasNext()) {
			cellNames.add(iterator.next().getStringCellValue());
		}
		excelWorkSheet.setColumns(cellNames);
		JuryIdcode objJuryIdcode = null;
		AuthCode objAuthCode = new AuthCode();
		// 遍历各列数据，并将其取出来放到excelWorkSheet中
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			Row row = sheet.getRow(i);
			objJuryIdcode = new JuryIdcode();
			objJuryIdcode.setJuryNo(objMethods.getCurrentUser().getUser_jury());
			objJuryIdcode.setExpert_name(row.getCell(0).getStringCellValue());
			row.getCell(1).setCellType(HSSFCell.CELL_TYPE_STRING); // 设置cell格式为文本格式
			objJuryIdcode.setExpert_phone(row.getCell(1).getStringCellValue());
			objJuryIdcode.setId_code(objAuthCode.getRandAuthCode());
			objJuryIdcode.setCode_invalid_time(objAuthCode.getValidDate().toString());
			objJuryIdcode.setState("未录入");
			excelWorkSheet.getData().add(objJuryIdcode);
		}
		insert = new Insert();
		insert.insertJuryIdcodes(excelWorkSheet.getData());
		
//		// JuryIdcode rec = excelWorkSheet.getData().get(j);
//		getJuryIdcode = new GetJuryIdcode();
//		// System.out.println(objUserLogin.getUser_jury());
//		juryIdcodes = getJuryIdcode.getJuryIdcodes(objMethods.getCurrentUser()
//				.getUser_jury());
		return SUCCESS;
	}
	
	// 判断文件类型创建Workbook对象
	public Workbook createWorkbook(InputStream is) throws IOException {
		if (excelFileFileName.toLowerCase().endsWith("xls")) {
			return new HSSFWorkbook(is);
		}
		if (excelFileFileName.toLowerCase().endsWith("xlsx")) {
			return new XSSFWorkbook(is);
		}
		return null;
	}

	

	public List<JuryIdcode> getJuryIdcodes() {
		return juryIdcodes;
	}

	public void setJuryIdcodes(List<JuryIdcode> juryIdcodes) {
		this.juryIdcodes = juryIdcodes;
	}

	public GetJuryIdcode getGetJuryIdcode() {
		return getJuryIdcode;
	}

	public void setGetJuryIdcode(GetJuryIdcode getJuryIdcode) {
		this.getJuryIdcode = getJuryIdcode;
	}

	public Methods getObjMethods() {
		return objMethods;
	}

	public void setObjMethods(Methods objMethods) {
		this.objMethods = objMethods;
	}

	public File getExcelFile() {
		return excelFile;
	}

	public void setExcelFile(File excelFile) {
		this.excelFile = excelFile;
	}

	public String getExcelFileFileName() {
		return excelFileFileName;
	}

	public void setExcelFileFileName(String excelFileFileName) {
		this.excelFileFileName = excelFileFileName;
	}

	public ExcelWorkSheet<JuryIdcode> getExcelWorkSheet() {
		return excelWorkSheet;
	}

	public void setExcelWorkSheet(ExcelWorkSheet<JuryIdcode> excelWorkSheet) {
		this.excelWorkSheet = excelWorkSheet;
	}

}
