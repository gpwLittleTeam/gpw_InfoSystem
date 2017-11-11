package gpw.action.jump;

import gpw.getInfo.GetGroup;
import gpw.object.Group;

import com.opensymphony.xwork2.ActionSupport;

public class To_Zyzgl_xgzyz extends ActionSupport{
	private String groupNo;
	private Group objGroup;
	private GetGroup objGetGroup;
	
	@Override
	public String execute() throws Exception {
		System.out.println("To_Zyzgl_xgzyz.java"+groupNo);
		objGetGroup = new GetGroup();
		objGroup = objGetGroup.getGroupByNo(groupNo).get(0);
		System.out.println("objGroup.Group_name:"+objGroup.getGroup_name());
		return SUCCESS;
	}

	public String getGroupNo() {
		return groupNo;
	}

	public void setGroupNo(String groupNo) {
		this.groupNo = groupNo;
	}

	public Group getObjGroup() {
		return objGroup;
	}

	public void setObjGroup(Group objGroup) {
		this.objGroup = objGroup;
	}

	public GetGroup getObjGetGroup() {
		return objGetGroup;
	}

	public void setObjGetGroup(GetGroup objGetGroup) {
		this.objGetGroup = objGetGroup;
	}
}
