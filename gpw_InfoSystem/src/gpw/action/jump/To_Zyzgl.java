package gpw.action.jump;

import java.util.List;

import gpw.getInfo.GetGroup;
import gpw.object.Group;
import gpw.object.Methods;

import com.opensymphony.xwork2.ActionSupport;

public class To_Zyzgl extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8282125613989451632L;
	private List<Group> objGroupList;
	private GetGroup objGetGroup;
	@Override
	public String execute() throws Exception {
		// TODO 自动生成的方法存根
		return super.execute();
	}
	
	public String loadPage() throws Exception {
		Methods objMethods = new Methods();
		objGetGroup = new GetGroup();
		objGroupList = objGetGroup.getGroupByJury(objMethods.getCurrentUser().getUser_jury()); 
		return SUCCESS;
	}
	
	public GetGroup getObjGetGroup() {
		return objGetGroup;
	}

	public void setObjGetGroup(GetGroup objGetGroup) {
		this.objGetGroup = objGetGroup;
	}

	public List<Group> getObjGroup() {
		return objGroupList;
	}

	public void setObjGroup(List<Group> objGroup) {
		this.objGroupList = objGroup;
	}

	public List<Group> getObjGroupList() {
		return objGroupList;
	}

	public void setObjGroupList(List<Group> objGroupList) {
		this.objGroupList = objGroupList;
	}
}
