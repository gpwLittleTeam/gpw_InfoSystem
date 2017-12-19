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
	private List<Expert> leadExpert;
	private List<Expert> memberExpert;
	private List<Integer> noOfGroupMembers;
	private List<Expert> membersOfGroup;

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

	public List<Expert> getLeadExpert() {
		return leadExpert;
	}

	public void setLeadExpert(List<Expert> leadExpert) {
		this.leadExpert = leadExpert;
	}

	public List<Expert> getMemberExpert() {
		return memberExpert;
	}

	public void setMemberExpert(List<Expert> memberExpert) {
		this.memberExpert = memberExpert;
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

}
