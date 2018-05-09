package gpw.action.jump;

import java.util.ArrayList;
import java.util.List;

import gpw.algorithm.ReviewGroup;
import gpw.getInfo.GetExpert;
import gpw.getInfo.GetGroup;
import gpw.object.Expert;
import gpw.object.Group;
import gpw.object.Methods;
import gpw.object.UserLogin;

import com.opensymphony.xwork2.ActionSupport;

public class To_Pwcq_pyz extends ActionSupport{
	private Methods objMethods;
	private GetGroup objGetGroup;
	private List<Group> listGroup;
	private ReviewGroup objReviewGroup;
	private UserLogin objUserLogin;
	private List<Expert>[] arrayofExpertList; //
	private List<Integer> noOfGroupMembers;
	private List<Expert> membersOfGroup;
	
	//print
	private List<List<Expert>> groupMembersList;
	private List<Expert> groupLeaderList;
	private List<Expert> leaderExpert;
	private List<Expert> memberExpert;
	private String[] resultNumber;
	private String[] groupName;

	@Override
	public String execute() throws Exception {
		//清理Session
		objMethods = new Methods();
		objMethods.clearSession();
		//
		objGetGroup = new GetGroup();
		objReviewGroup = new ReviewGroup();
		objMethods = new Methods();
		
		objUserLogin = objMethods.getCurrentUser();
		//专业组列表
		listGroup = objReviewGroup.showReviewGroup(objUserLogin.getUser_jury());
		noOfGroupMembers = new ArrayList<Integer>();
		for(int i=0;i<listGroup.size();i++) {
			membersOfGroup = objReviewGroup.showExpertsOfChoosenGroup(listGroup.get(i).getGroup_no());
			noOfGroupMembers.add(membersOfGroup.size());
			System.out.println("noOfGroupMembers : " + noOfGroupMembers.get(i));
		}
		
		return super.execute();
	}

	public String printResult() {
		Methods objMethods = new Methods();
		if(objMethods.getSession("groupMembersList") != null){
			groupMembersList = (List<List<Expert>>)objMethods.getSession("groupMembersList");
			groupLeaderList = (List<Expert>)objMethods.getSession("groupLeaderList");
			System.out.println("groupName: " + groupName.length);
			System.out.println("resultNumber: " + resultNumber.length);
		}
		
		return SUCCESS;
	}
	public Methods getObjMethods() {
		return objMethods;
	}

	public void setObjMethods(Methods objMethods) {
		this.objMethods = objMethods;
	}

	public GetGroup getObjGetGroup() {
		return objGetGroup;
	}

	public void setObjGetGroup(GetGroup objGetGroup) {
		this.objGetGroup = objGetGroup;
	}

	public List<Group> getListGroup() {
		return listGroup;
	}

	public void setListGroup(List<Group> listGroup) {
		this.listGroup = listGroup;
	}

	public ReviewGroup getObjReviewGroup() {
		return objReviewGroup;
	}

	public void setObjReviewGroup(ReviewGroup objReviewGroup) {
		this.objReviewGroup = objReviewGroup;
	}

	public UserLogin getObjUserLogin() {
		return objUserLogin;
	}

	public void setObjUserLogin(UserLogin objUserLogin) {
		this.objUserLogin = objUserLogin;
	}

	public List<Expert>[] getArrayofExpertList() {
		return arrayofExpertList;
	}

	public void setArrayofExpertList(List<Expert>[] arrayofExpertList) {
		this.arrayofExpertList = arrayofExpertList;
	}

	public List<Integer> getNoOfGroupMembers() {
		return noOfGroupMembers;
	}

	public void setNoOfGroupMembers(List<Integer> noOfGroupMembers) {
		this.noOfGroupMembers = noOfGroupMembers;
	}

	public List<Expert> getMembersOfGroup() {
		return membersOfGroup;
	}

	public void setMembersOfGroup(List<Expert> membersOfGroup) {
		this.membersOfGroup = membersOfGroup;
	}

	public List<Expert> getLeaderExpert() {
		return leaderExpert;
	}

	public void setLeaderExpert(List<Expert> leaderExpert) {
		this.leaderExpert = leaderExpert;
	}

	public List<Expert> getMemberExpert() {
		return memberExpert;
	}

	public void setMemberExpert(List<Expert> memberExpert) {
		this.memberExpert = memberExpert;
	}

	public String[] getGroupName() {
		return groupName;
	}

	public void setGroupName(String[] groupName) {
		this.groupName = groupName;
	}

	public String[] getResultNumber() {
		return resultNumber;
	}

	public void setResultNumber(String[] resultNumber) {
		this.resultNumber = resultNumber;
	}

	public List<List<Expert>> getGroupMembersList() {
		return groupMembersList;
	}

	public void setGroupMembersList(List<List<Expert>> groupMembersList) {
		this.groupMembersList = groupMembersList;
	}

	public List<Expert> getGroupLeaderList() {
		return groupLeaderList;
	}

	public void setGroupLeaderList(List<Expert> groupLeaderList) {
		this.groupLeaderList = groupLeaderList;
	}

}
