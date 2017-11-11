package gpw.action.jump;

import gpw.getInfo.GetJuryIdcode;
import gpw.object.JuryIdcode;
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
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST); 
		
		getJuryIdcode = new GetJuryIdcode();
		objUserLogin = (UserLogin)request.getSession().getAttribute("User");
		//System.out.println(objUserLogin.getUser_jury());
		juryIdcodes = getJuryIdcode.getJuryIdcodes(objUserLogin.getUser_jury());
		
//		System.out.println("To_zjgl_infoList_gpw.java + field10:" + expertList.get(0).getExpert_Field10());
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
