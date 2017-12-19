package gpw.action.jump;

import gpw.getInfo.GetExpert;
import gpw.object.Expert;
import gpw.object.Methods;
import gpw.object.UserField;
import gpw.object.UserLogin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class To_Zjgl_infoList_gpw extends ActionSupport {
	private List<String> chDefaultFieldList;
	private List<String> intDefaultFieldList;
	private List<Expert> expertList;
	private UserField objUserField;
	private String UserName;
	private Methods objMethods;
	private UserLogin objUserLogin;

	@Override
	public String execute() throws Exception {
		//System.out.println("expertList.size() " + expertList.size());
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST); 
		//request.getSession().setAttribute("expertList", expertList);
		//初始化列表的成员 显示用户所在高评委的专家
		objUserLogin = (UserLogin)request.getSession().getAttribute("User"); 
		objMethods = new Methods();
		expertList = objMethods.initializeExpertListForGPWByJuryNo(objUserLogin.getUser_jury());
//		System.out.println("To_zjgl_infoList_gpw.java + field10:" + expertList.get(0).getExpert_Field10());
//		System.out.println("To_Zjgl_infoList_gpw:"+expertList.get(2).getExpert_Field4());

		//初始化user的默认字段
		objUserField = new UserField();
		UserName = objUserLogin.getUser_name();
		objMethods.initializeDefaultFieldList(UserName);
		
		return SUCCESS;
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

	public Methods getObjMethods() {
		return objMethods;
	}

	public void setObjMethods(Methods objMethods) {
		this.objMethods = objMethods;
	}

	public UserLogin getObjUserLogin() {
		return objUserLogin;
	}

	public void setObjUserLogin(UserLogin objUserLogin) {
		this.objUserLogin = objUserLogin;
	}

}
