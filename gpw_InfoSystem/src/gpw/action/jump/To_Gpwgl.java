package gpw.action.jump;

import java.util.List;

import gpw.getInfo.GetJury;
import gpw.object.Jury;

import com.opensymphony.xwork2.ActionSupport;

public class To_Gpwgl extends ActionSupport {
	private GetJury objGetJury;
	private List<Jury> listJury;

	@Override
	public String execute() throws Exception {
		objGetJury = new GetJury();
		listJury = objGetJury.getAllJurys();

		// 评审权限
		for (int i = 0; i < listJury.size(); i++) {
			switch (listJury.get(i).getJury_power()) {
			case "1":
				listJury.get(i).setJury_power("正高职称");
				break;
			case "2":
				listJury.get(i).setJury_power("副高职称");
				break;
			case "3":
				listJury.get(i).setJury_power("正副合一");
				break;
			case "0":
				listJury.get(i).setJury_power("");
				break;
			}
		}

		return super.execute();
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
