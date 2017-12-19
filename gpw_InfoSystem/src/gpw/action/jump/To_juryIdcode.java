package gpw.action.jump;

import gpw.getInfo.GetJuryIdcode;
import gpw.object.JuryIdcode;
import gpw.object.Methods;
import gpw.object.UserLogin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class To_juryIdcode extends ActionSupport {
	private List<JuryIdcode> juryIdcodes;
	private GetJuryIdcode getJuryIdcode;
	
//	private String UserName;
//	private Methods objMethods;
	private UserLogin objUserLogin;

	@Override
	public String execute() throws Exception {
		Methods objMethods = new Methods();
		getJuryIdcode = new GetJuryIdcode();
		juryIdcodes = getJuryIdcode.getJuryIdcodes(objMethods.getCurrentUser().getUser_jury());
		for(int i=0;i<juryIdcodes.size();i++) {
			System.out.println("name:" + juryIdcodes.get(i).getExpert_name());
			System.out.println("state:" + juryIdcodes.get(i).getState());
		}
		//System.out.println("To_zjgl_infoList_gpw.java + field10:" + juryIdcodes.get(0).getCode_invalid_time());
//		System.out.println("To_Zjgl_infoList_gpw:"+expertList.get(2).getExpert_Field4());
		
		return super.execute();
	}

	public List<JuryIdcode> getJuryIdcodes() {
		return juryIdcodes;
	}

	public void setJuryIdcodes(List<JuryIdcode> juryIdcodes) {
		this.juryIdcodes = juryIdcodes;
	}

	public GetJuryIdcode getGetJuryIdcode() {
		return getJuryIdcode;
	}

	public void setGetJuryIdcode(GetJuryIdcode getJuryIdcode) {
		this.getJuryIdcode = getJuryIdcode;
	}

	public UserLogin getObjUserLogin() {
		return objUserLogin;
	}

	public void setObjUserLogin(UserLogin objUserLogin) {
		this.objUserLogin = objUserLogin;
	}

}
