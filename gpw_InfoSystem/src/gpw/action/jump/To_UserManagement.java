package gpw.action.jump;

import java.util.List;

import gpw.getInfo.GetUserLogin;
import gpw.object.UserLogin;

import com.opensymphony.xwork2.ActionSupport;

public class To_UserManagement extends ActionSupport{
	private List<UserLogin> listUserLogin;
	private GetUserLogin objGetUserLogin;
	
	public String execute() throws Exception {
		objGetUserLogin = new GetUserLogin();
		listUserLogin = objGetUserLogin.getAllUserLogins();
		for(int i = 0; i<listUserLogin.size();i++){
			if(listUserLogin.get(i).getUser_type().equals("1")) {
				listUserLogin.get(i).setUser_type("高评委用户"); 
			} else if(listUserLogin.get(i).getUser_type().equals("2")){
				listUserLogin.get(i).setUser_type("管理员用户");
			}
		}
		return super.execute();
	}

	public List<UserLogin> getListUserLogin() {
		return listUserLogin;
	}

	public void setListUserLogin(List<UserLogin> listUserLogin) {
		this.listUserLogin = listUserLogin;
	}

	public GetUserLogin getObjGetUserLogin() {
		return objGetUserLogin;
	}

	public void setObjGetUserLogin(GetUserLogin objGetUserLogin) {
		this.objGetUserLogin = objGetUserLogin;
	}
}
