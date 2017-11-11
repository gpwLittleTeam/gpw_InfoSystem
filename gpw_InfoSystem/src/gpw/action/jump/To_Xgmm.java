package gpw.action.jump;

import gpw.object.UserLogin;

import com.opensymphony.xwork2.ActionSupport;

public class To_Xgmm extends ActionSupport{
	private String account;
	private String oldpsw;
	private String newpsw;
	
	private UserLogin objUserLogin;
	//无用类 可删
	public String execute() throws Exception {
		System.out.println("To_Xgmm.java  account: " + account);
		System.out.println("To_Xgmm.java  oldpsw: " + oldpsw);
		System.out.println("To_Xgmm.java  newpsw: " + newpsw);
		
		return SUCCESS;
		
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getOldpsw() {
		return oldpsw;
	}

	public void setOldpsw(String oldpsw) {
		this.oldpsw = oldpsw;
	}

	public String getNewpsw() {
		return newpsw;
	}

	public void setNewpsw(String newpsw) {
		this.newpsw = newpsw;
	}

	public UserLogin getObjUserLogin() {
		return objUserLogin;
	}

	public void setObjUserLogin(UserLogin objUserLogin) {
		this.objUserLogin = objUserLogin;
	}
}
