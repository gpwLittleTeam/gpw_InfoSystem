package gpw.action.jump;

import gpw.getInfo.GetJury;
import gpw.object.Jury;

import com.opensymphony.xwork2.ActionSupport;

public class To_Gpwgl_xggpw extends ActionSupport {
	private Jury objJury;
	private String jury_no;
	private GetJury objGetJury;
	@Override
	public String execute() throws Exception {
		//System.out.println("To_Gpwgl_xggpw :" + objJury);
		//System.out.println("To_Gpwgl_xggpw :" + jury_no);
		objGetJury = new GetJury();
		objJury = objGetJury.getJuryByNo(jury_no);
		//System.out.println("To_Gpwgl_xggpw  objJury :" + objJury.getJury_name());
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
}
