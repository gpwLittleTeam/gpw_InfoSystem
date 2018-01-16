package gpw.action.jump;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;

import gpw.getInfo.GetJury;
import gpw.getInfo.GetPermission;
import gpw.object.Jury;
import gpw.object.Permission;

import com.opensymphony.xwork2.ActionSupport;

public class To_Gpwgl extends ActionSupport {
	private GetJury objGetJury;
	private List<Jury> listJury;

	@Override
	public String execute() throws Exception {
		objGetJury = new GetJury();
		listJury = objGetJury.getAllJurys();
		GetPermission objGetPermission = new GetPermission();
		List<Permission> listPermissions = objGetPermission.GetAllPermission();
		//用字典便于查找
		HashMap<String, String> permissionMap= new HashMap<String, String>();
		for(int i=0;i<listPermissions.size();i++){
			permissionMap.put(listPermissions.get(i).getCodeNo(), listPermissions.get(i).getCodeName());
		}
		// 评审权限
		for (int i = 0; i < listJury.size(); i++) {
			listJury.get(i).setJury_power(permissionMap.get(listJury.get(i).getJury_power()));
		}

		return super.execute();
	}
	
	private String getPermissionByCode(String code, List<Permission> listPermissions) {
		String name = "";
		return name;
	}

	public GetJury getObjGetJury() {
		return objGetJury;
	}

	public void setObjGetJury(GetJury objGetJury) {
		this.objGetJury = objGetJury;
	}

	public List<Jury> getListJury() {
		return listJury;
	}

	public void setListJury(List<Jury> listJury) {
		this.listJury = listJury;
	}
}
