package gpw.action.jump;

import java.util.List;

import gpw.getInfo.GetJuryIdcode;
import gpw.object.JuryIdcode;
import gpw.object.Methods;

import com.opensymphony.xwork2.ActionSupport;

public class To_AuthCode_print extends ActionSupport {
	List<JuryIdcode> juryIdcodes;
	@Override
	public String execute() throws Exception {
		Methods objMethods = new Methods();
		GetJuryIdcode objGetJuryIdcode = new GetJuryIdcode();
		juryIdcodes = objGetJuryIdcode.getJuryIdcodes(objMethods.getCurrentUser().getUser_jury());
		return super.execute();
	}
	public List<JuryIdcode> getJuryIdcodes() {
		return juryIdcodes;
	}
	public void setJuryIdcodes(List<JuryIdcode> juryIdcodes) {
		this.juryIdcodes = juryIdcodes;
	}
}
