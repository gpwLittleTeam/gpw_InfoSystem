package gpw.action.jump;

import java.util.List;

import gpw.getInfo.GetGroup;
import gpw.object.Expert;
import gpw.object.Group;
import gpw.object.Jury;

import com.opensymphony.xwork2.ActionSupport;

public class To_CodeAdd extends ActionSupport{
	private String table; //目标代码表
	private List<String> listGpwName;
	private Jury objJury;
	@Override
	public String execute() throws Exception {
		// TODO 自动生成的方法存根
		return super.execute();
	}
	
	public String forCommon() throws Exception {
		
		return SUCCESS;
	}

	public String forGroup() throws Exception {
		objJury = new Jury();
		listGpwName = objJury.getAllJuryName();
		return SUCCESS;
	}

	
	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}
}
