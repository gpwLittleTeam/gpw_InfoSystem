package gpw.action.jump;

import java.util.List;

import gpw.getInfo.GetJury;
import gpw.getInfo.GetPermission;
import gpw.object.Jury;
import gpw.object.Permission;

import com.opensymphony.xwork2.ActionSupport;

public class To_Gpwgl_xggpw extends ActionSupport {
	private Jury objJury;
	private String jury_no;
	private GetJury objGetJury;
	private List<Permission> listPermissions;
	@Override
	public String execute() throws Exception {
		objGetJury = new GetJury();
		objJury = objGetJury.getJuryByNo(jury_no);
		//System.out.println("To_Gpwgl_xggpw  objJury :" + objJury.getJury_name());
		GetPermission objGetPermission = new GetPermission();
		listPermissions = objGetPermission.GetAllPermission(); 
		return super.execute();
	}

	public Jury getObjJury() {
		return objJury;
	}

	public void setObjJury(Jury objJury) {
		this.objJury = objJury;
	}

	public String getJury_no() {
		return jury_no;
	}

	public void setJury_no(String jury_no) {
		this.jury_no = jury_no;
	}

	public GetJury getObjGetJury() {
		return objGetJury;
	}

	public void setObjGetJury(GetJury objGetJury) {
		this.objGetJury = objGetJury;
	}

	public List<Permission> getListPermissions() {
		return listPermissions;
	}

	public void setListPermissions(List<Permission> listPermissions) {
		this.listPermissions = listPermissions;
	}
}
