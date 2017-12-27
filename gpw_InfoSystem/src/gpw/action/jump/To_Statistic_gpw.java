package gpw.action.jump;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import gpw.object.Expert;
import gpw.object.Methods;
import gpw.object.UserLogin;

public class To_Statistic_gpw extends ActionSupport {
	private List<Expert> expertList;
	private String UserName;
	private Methods objMethods;
	private UserLogin objUserLogin;

	@Override
	public String execute() throws Exception {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST); 
		//初始化列表的成员 显示用户所在高评委的专家
		objUserLogin = (UserLogin)request.getSession().getAttribute("User"); 
		objMethods = new Methods();
		expertList = objMethods.initializeExpertListForGPWByJuryNo(objUserLogin.getUser_jury());
//		System.out.println("To_Statistic_gpw.java:" + objUserLogin.getUser_jury());

		return SUCCESS;
	}

	public List<Expert> getExpertList() {
		return expertList;
	}

	public void setExpertList(List<Expert> expertList) {
		this.expertList = expertList;
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
