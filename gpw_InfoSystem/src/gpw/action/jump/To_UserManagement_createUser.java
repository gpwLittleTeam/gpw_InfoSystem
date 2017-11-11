package gpw.action.jump;

import gpw.getInfo.GetJury;
import gpw.object.Jury;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class To_UserManagement_createUser extends ActionSupport {
	private GetJury objGetJury;
	private List<Jury> JuryList;
	
	public String execute() throws Exception {
		System.out.println("call To_UserManagement_createUser.java");
		objGetJury = new GetJury();
		JuryList = objGetJury.getAllJurys();
		System.out.println("JuryList  : "+JuryList .get(0));
		return super.execute();
	}

	public GetJury getObjGetJury() {
		return objGetJury;
	}

	public void setObjGetJury(GetJury objGetJury) {
		this.objGetJury = objGetJury;
	}

	public List<Jury> getJuryList() {
		return JuryList;
	}

	public void setJuryList(List<Jury> juryList) {
		JuryList = juryList;
	}

}
