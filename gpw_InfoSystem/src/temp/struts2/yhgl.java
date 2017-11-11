package temp.struts2;

import com.opensymphony.xwork2.ActionSupport;

public class yhgl extends ActionSupport {
	private String myName;
	public String getMyName() {
		return myName;
	}
	public void setMyName(String myName) {
		this.myName = myName;
	}

	
	public String execute() throws Exception {
		// TODO 自动生成的方法存根
		System.out.println("123");
		return SUCCESS;
	}
	
	public String save() throws Exception {
		System.out.println("save");
		return SUCCESS;
	}
	
	public String delete() throws Exception {
		System.out.println("delete");
		return SUCCESS;
	}
	
	public String reset() throws Exception {
		System.out.println("reset");
		return SUCCESS;
	}
}
