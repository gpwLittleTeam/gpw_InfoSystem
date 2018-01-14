package gpw.action.MyAjax;

import java.util.ArrayList;
import java.util.List;

import javax.json.JsonArray;
import javax.swing.ListModel;

import net.sf.json.JSONArray;
import gpw.getInfo.GetCounciltitle;
import gpw.getInfo.GetDegree;
import gpw.getInfo.GetEducation;
import gpw.getInfo.GetEngage;
import gpw.getInfo.GetGrouptitle;
import gpw.getInfo.GetSeries;
import gpw.getInfo.GetSex;
import gpw.getInfo.GetSpecial;
import gpw.getInfo.GetTitle;
import gpw.getInfo.GetTitlegrade;
import gpw.object.*;

import com.opensymphony.xwork2.ActionSupport;

public class ForRuleManagement extends ActionSupport{
	private List<CodeModel> listCodeModel;
	private String fieldCode;
	private String jsonListCodeModel;
	/**
	 * 通过给定代码表名称'fieldName',得到该表的内容
	 * @return ajax返回对应代码表里的所有列
	 */
	public String getCodeList(){
		listCodeModel = new ArrayList<CodeModel>();
		System.out.println("fieldName:" + fieldCode);
		
		switch (fieldCode) {
		case "code_counciltitle" :
			GetCounciltitle objCounciltitle = new GetCounciltitle();
			List<Counciltitle> listCounciltitles = objCounciltitle.getAllCounciltitles();
			for(int i=0;i<listCounciltitles.size();i++){
				listCodeModel.add(listCounciltitles.get(i));
			}
			break;
		case "code_degree" :
			GetDegree objDegree = new GetDegree();
			List<Degree> listDegrees =  objDegree.getAllDegrees();
			for(int i=0;i<listDegrees.size();i++){
				listCodeModel.add(listDegrees.get(i));
			}
			break;
		case "code_education" :
			GetEducation objEducation = new GetEducation();
			List<Education> listEducations = objEducation.getAllEducations();
			for(int i=0;i<listEducations.size();i++){
				listCodeModel.add(listEducations.get(i));
			}
			break;
		case "code_engage" :
			GetEngage  objEngage = new GetEngage();
			List<Engage> listEngages = objEngage.getAllEngages();
			for(int i=0;i<listEngages.size();i++){
				listCodeModel.add(listEngages.get(i));
			}
			break;
		case "code_grouptitle" :
			GetGrouptitle objGetGrouptitle = new GetGrouptitle();
			List<Grouptitle> listGrouptitles = objGetGrouptitle.getAllGrouptitles();
			for(int i=0;i<listGrouptitles.size();i++){
				listCodeModel.add(listGrouptitles.get(i));
			}
			break;
		case "code_series" :
			GetSeries objGetSeries = new GetSeries();
			List<Series> listSeries = objGetSeries.getAllSeries();
			for(int i=0;i<listSeries.size();i++){
				listCodeModel.add(listSeries.get(i));
			}
			break;
		case "code_sex":
			GetSex objGetSex = new GetSex();
			List<Sex> listSex = objGetSex.getAllSexs();
			for(int i=0;i<listSex.size();i++){
				listCodeModel.add(listSex.get(i));
			}
			break;
		case "code_special":
			GetSpecial objGetSpecial = new GetSpecial();
			List<Special> listSpecials = objGetSpecial.getAllSpecials();
			for(int i=0;i<listSpecials.size();i++){
				listCodeModel.add(listSpecials.get(i));
			}
			break;
			
		case "code_ title" :
			GetTitle objGetTitle = new GetTitle();
			List<Title> listTitles = objGetTitle.getAllTitles();
			for(int i=0;i<listTitles.size();i++){
				listCodeModel.add(listTitles.get(i));
			}
			break;
		case "code_titlegrade" :
			GetTitlegrade objGetTitlegrade = new GetTitlegrade();
			List<Titlegrade> listTitlegrades = objGetTitlegrade.getAllTitlegrades();
			for(int i=0;i<listTitlegrades.size();i++){
				listCodeModel.add(listTitlegrades.get(i));
			}
			break;
		default:
			System.out.println("ForRuleManagement.getCodeList(String) go wrong!");
			break;
		}
		
		JSONArray jsonArray = JSONArray.fromObject(listCodeModel);
		jsonListCodeModel = jsonArray.toString();
		return SUCCESS;
	}
	public List<CodeModel> getListCodeModel() {
		return listCodeModel;
	}
	public void setListCodeModel(List<CodeModel> listCodeModel) {
		this.listCodeModel = listCodeModel;
	}
	public String getFieldCode() {
		return fieldCode;
	}
	public void setFieldCode(String fieldCode) {
		this.fieldCode = fieldCode;
	}
	public String getJsonListCodeModel() {
		return jsonListCodeModel;
	}
	public void setJsonListCodeModel(String jsonListCodeModel) {
		this.jsonListCodeModel = jsonListCodeModel;
	}

}
