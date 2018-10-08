package gpw.action.MyAjax;

import java.util.ArrayList;
import java.util.List;

import javax.json.JsonArray;
import javax.swing.ListModel;

import net.sf.json.JSONArray;
import gpw.algorithm.ForRuleContent;
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
	//getCodeList
	private List<CodeModel> listCodeModel;
	private String fieldCode;
	private String jsonListCodeModel;
	//getPreview
	private String ruleField;
	private String ruleRelation;
	private String ruleValue;
	private String rulePrecent;
	private String rulePrecentRelation;
	private String ruleContent;
	/**
	 * 通过给定代码表名称'fieldName',得到该表的内容
	 * @return ajax返回对应代码表里的所有列
	 */
	public String getCodeList(){
		listCodeModel = new ArrayList<CodeModel>();
		//System.out.println("fieldName:" + fieldCode);
		
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
			
		case "code_title" :
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
	
	public String getPreView() {
		ForRuleContent objForRuleContent = new ForRuleContent();
		List<RuleManagement> listRuleManagements = new ArrayList<RuleManagement>();
		RuleManagement objRuleManagement = new RuleManagement();
		objRuleManagement.setRule_field(ruleField);
		objRuleManagement.setRule_relation(ruleRelation);
		objRuleManagement.setRule_value(ruleValue);
		objRuleManagement.setRule_percent(rulePrecent);
		objRuleManagement.setRule_percentRelation(rulePrecentRelation);
		
		listRuleManagements.add(objRuleManagement);
		
		ruleContent = objForRuleContent.getRuleContent(listRuleManagements).get(0);
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

	public String getRuleField() {
		return ruleField;
	}

	public void setRuleField(String ruleField) {
		this.ruleField = ruleField;
	}

	public String getRuleRelation() {
		return ruleRelation;
	}

	public void setRuleRelation(String ruleRelation) {
		this.ruleRelation = ruleRelation;
	}

	public String getRuleValue() {
		return ruleValue;
	}

	public void setRuleValue(String ruleValue) {
		this.ruleValue = ruleValue;
	}

	public String getRulePrecent() {
		return rulePrecent;
	}

	public void setRulePrecent(String rulePrecent) {
		this.rulePrecent = rulePrecent;
	}

	public String getRulePrecentRelation() {
		return rulePrecentRelation;
	}

	public void setRulePrecentRelation(String rulePrecentRelation) {
		this.rulePrecentRelation = rulePrecentRelation;
	}

	public String getRuleContent() {
		return ruleContent;
	}

	public void setRuleContent(String ruleContent) {
		this.ruleContent = ruleContent;
	}

}
