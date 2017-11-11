package gpw.action.operation;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SignOut extends ActionSupport{
	@Override
	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		session.clear();
		System.out.println("session clear");
		return super.execute();
	}
}
