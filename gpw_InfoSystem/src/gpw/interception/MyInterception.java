package gpw.interception;

import gpw.object.UserLogin;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class MyInterception extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO 自动生成的方法存根
		UserLogin objUserLogin = (UserLogin)ActionContext.getContext().getSession().get("User");
		//System.out.println("call MyInterception.java  intercept()");
		if(objUserLogin != null) {
			return arg0.invoke();
		} else {
			return "logined";
		}
	}
}
