package temp.struts2;

import com.opensymphony.xwork2.ActionSupport;

public class Success extends ActionSupport {
	@Override
	public String execute() throws Exception {	
		System.out.println("success");
		return SUCCESS;
	}
}
