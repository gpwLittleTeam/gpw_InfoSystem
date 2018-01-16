package gpw.action.jump;

import java.util.List;

import gpw.getInfo.GetPermission;
import gpw.getInfo.GetRuleManagement;
import gpw.object.Permission;

import com.opensymphony.xwork2.ActionSupport;

public class To_Gpwgl_xjgpw extends ActionSupport{
	List<Permission> listPermissions;
	public String execute() throws Exception {
		GetPermission objGetPermission = new GetPermission();
		listPermissions =  objGetPermission.GetAllPermission();
		return super.execute();
	}
	public List<Permission> getListPermissions() {
		return listPermissions;
	}
	public void setListPermissions(List<Permission> listPermissions) {
		this.listPermissions = listPermissions;
	}
}