package gpw.action.operation;

import gpw.getInfo.GetUserLogin;
import gpw.object.Jury;
import gpw.object.Methods;
import gpw.object.UserLogin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Login extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7764944302646929741L;
	// private Map session;
	private String account;
	private String psw;
	private GetUserLogin objGetUserLogin;
	private UserLogin objUserLogin;
	private String message;

	public String execute() {
		objUserLogin = new UserLogin();
		// System.out.println("objUserLogin.getPsdByName(account):"+objUserLogin.getPsdByName(account));
		if(account == null && psw == null) {
			System.out.println("未登入");
			return "unlogin";
		}
		if (psw.equals(objUserLogin.getPsdByName(account))) {
			objGetUserLogin = new GetUserLogin();
			objUserLogin = objGetUserLogin.getUserLoginByUserName(account);  //获得登录用户的全部信息
			
			if(objUserLogin.getUser_enable().equals("1")) {  //判断账户是否启用
				HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
						.get(StrutsStatics.HTTP_REQUEST);
				request.getSession().setAttribute("User", objUserLogin);
				
				//根据用户名找到对应高评委名称
				Methods objMethods = new Methods();
				Jury objJury = new Jury();
				if (objUserLogin.getUser_type().equals("1")) {// 高评委
					objMethods.setSession("currentJuryName", "高评委用户：" + objJury.getJuryNameByJuryNo(objUserLogin.getUser_jury())); 
					return "gpw";
				}else {
					// 2==管理员
					objMethods.setSession("currentJuryName", "管理员用户");
					return "gly";
				}
			} else {  //账户出于禁用状态
				message = "该账户已被禁用";
				return ERROR;
			}
		} else {
			Methods objMethods = new Methods();
			String error = objMethods.getError();
			if (error != null && error.equals("NoConnect")) {
				message = "连接服务器失败";
				return ERROR;
			}
			message = "用户名或密码错误，请重新输入";
			return ERROR;
		}
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPsw() {
		return psw;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}

	public UserLogin getObjUserLogin() {
		return objUserLogin;
	}

	public void setObjUserLogin(UserLogin objUserLogin) {
		this.objUserLogin = objUserLogin;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
