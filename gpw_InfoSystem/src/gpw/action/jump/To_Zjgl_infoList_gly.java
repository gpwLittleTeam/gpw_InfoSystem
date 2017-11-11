package gpw.action.jump;

import gpw.getInfo.GetExpert;
import gpw.object.Expert;
import gpw.object.Jury;
import gpw.object.Methods;
import gpw.object.UserField;
import gpw.object.UserLogin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class To_Zjgl_infoList_gly extends ActionSupport{
	private Methods objMethods;
	private GetExpert objGetObject;
	private List<Expert> expertList;
//默认字段
	private List<String> chDefaultFieldList;
	private List<String> intDefaultFieldList;
	private UserField objUserField;
//查询高评委字段
	private Jury objJury;
	private List<String> listGpwName;
	private List<String> listGpwNo;
//当前用户
	private UserLogin objUserLogin;
	private String UserName;
	
	@Override
	public String execute() throws Exception {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST); 
		//初始化列表的成员 选择全部的成员
		objGetObject = new GetExpert();
		objMethods = new Methods();
		expertList = objMethods.initializeExpertListForGLY();

		//初始化user的默认字段
		objUserField = new UserField();
		objUserLogin = objMethods.getCurrentUser();
		UserName = objUserLogin.getUser_name();
//		System.out.println("UserName:" + UserName);
		objMethods.initializeDefaultFieldList(UserName);
		
		//高评委datalist
		objJury = new Jury();
		listGpwName = new ArrayList<String>();
		listGpwNo = new ArrayList<String>();
		listGpwNo = objJury.getAllJuryNo();
		listGpwName = objJury.getAllJuryName();
		
		return SUCCESS;
	}

	public GetExpert getObjGetObject() {
		return objGetObject;
	}

	public void setObjGetObject(GetExpert objGetObject) {
		this.objGetObject = objGetObject;
	}

	public List<Expert> getExpertList() {
		return expertList;
	}

	public void setExpertList(List<Expert> expertList) {
		this.expertList = expertList;
	}

	public List<String> getChDefaultFieldList() {
		return chDefaultFieldList;
	}

	public void setChDefaultFieldList(List<String> chDefaultFieldList) {
		this.chDefaultFieldList = chDefaultFieldList;
	}

	public List<String> getIntDefaultFieldList() {
		return intDefaultFieldList;
	}

	public void setIntDefaultFieldList(List<String> intDefaultFieldList) {
		this.intDefaultFieldList = intDefaultFieldList;
	}

	public UserField getObjUserField() {
		return objUserField;
	}

	public void setObjUserField(UserField objUserField) {
		this.objUserField = objUserField;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public Jury getObjJury() {
		return objJury;
	}

	public void setObjJury(Jury objJury) {
		this.objJury = objJury;
	}

	public Methods getObjMethods() {
		return objMethods;
	}

	public void setObjMethods(Methods objMethods) {
		this.objMethods = objMethods;
	}

	public List<String> getListGpwName() {
		return listGpwName;
	}

	public void setListGpwName(List<String> listGpwName) {
		this.listGpwName = listGpwName;
	}

	public List<String> getListGpwNo() {
		return listGpwNo;
	}

	public void setListGpwNo(List<String> listGpwNo) {
		this.listGpwNo = listGpwNo;
	}

	public UserLogin getObjUserLogin() {
		return objUserLogin;
	}

	public void setObjUserLogin(UserLogin objUserLogin) {
		this.objUserLogin = objUserLogin;
	}


}
