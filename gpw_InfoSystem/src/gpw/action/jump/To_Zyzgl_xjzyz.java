package gpw.action.jump;

import gpw.algorithm.GenerateNo;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class To_Zyzgl_xjzyz extends ActionSupport{
	private String GroupNo;  //自动生成专业组编号
	private GenerateNo objGenerateNo;
	
	@Override
	public String execute() throws Exception {
		//GroupNo = new Random().nextInt(10000);
		
		HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
		
		String user_jury;  //用户的juryNo
		//user_jury = request.getSession().getAttribute("");
		user_jury = "1022";
		System.out.println("To_Zyzgl_xjzyz->user_jury: "+user_jury);
		objGenerateNo = new GenerateNo(); 
		GroupNo = objGenerateNo.generateGroupNo(user_jury);
		return super.execute();
	}
	
	public String getGroupNo() {
		return GroupNo;
	}
	public void setGroupNo(String groupNo) {
		GroupNo = groupNo;
	}
	public GenerateNo getObjGenerateNo() {
		return objGenerateNo;
	}
	public void setObjGenerateNo(GenerateNo objGenerateNo) {
		this.objGenerateNo = objGenerateNo;
	}
}
