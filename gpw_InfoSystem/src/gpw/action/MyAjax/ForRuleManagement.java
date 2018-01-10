package gpw.action.MyAjax;

import java.util.ArrayList;
import java.util.List;

import javax.json.JsonArray;

import net.sf.json.JSONArray;
import gpw.getInfo.GetSex;
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
		case "code_sex":
			GetSex objGetSex = new GetSex();
			List<Sex> listSex = objGetSex.getAllSexs();
			for(int i=0;i<listSex.size();i++){
				listCodeModel.add(listSex.get(i));
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
