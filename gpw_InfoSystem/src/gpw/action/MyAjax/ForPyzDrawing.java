package gpw.action.MyAjax;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import gpw.algorithm.ReviewGroup;
import gpw.getInfo.GetExpert;
import gpw.getInfo.GetGroup;
import gpw.object.Expert;
import gpw.object.Methods;

import com.opensymphony.xwork2.ActionSupport;

public class ForPyzDrawing extends ActionSupport {
	// showGroupMember
	private String groupNo;
	private ReviewGroup objReviewGroup = new ReviewGroup();
	private List<Expert> membersOfGroup;
	private GetExpert objGetExpert;
	private GetGroup objGetGroup;
	private JSONArray jsonArray;
	private String feedback;
	private String resultString;
	private String theErrors;
	// drawGroupmember
	private int numberChoosen;
	private List<Expert> leaderExpert;
	private List<Expert> memberExpert;
	private String leaderResult;
	private String memberResult;

	public String showGroupMember() throws Exception {
		membersOfGroup = objReviewGroup.showExpertsOfChoosenGroup(groupNo);
		jsonArray = JSONArray.fromObject(membersOfGroup);
		resultString = jsonArray.toString(); // JSON->String

		return super.execute();
	}

	public String drawGroupMemeber() throws Exception {
		// System.out.println("groupNo : " + groupNo);
		// System.out.println("numberChoosen : " + numberChoosen);
		leaderExpert = new ArrayList<Expert>();
		memberExpert = new ArrayList<Expert>();
		objReviewGroup.randomFunction(groupNo, numberChoosen, leaderExpert, memberExpert);
		theErrors = new Methods().getError();
//		System.out.println("errors: " + theErrors);
		
		if (theErrors != null) {
			System.out.println("theErrors != null");
		} else{
			jsonArray = JSONArray.fromObject(leaderExpert);
			leaderResult = jsonArray.toString();
			jsonArray = JSONArray.fromObject(memberExpert);
			memberResult = jsonArray.toString();
			Methods objMethods = new Methods();
			System.out.println("ForPYZDrawMemeber ->leaderExpert: " + leaderExpert.get(0).getExpert_Field1());
			if((List<Expert>)objMethods.getSession("leaderExpert") != null)
				leaderExpert.addAll((List<Expert>)objMethods.getSession("leaderExpert"));
			if((List<Expert>)objMethods.getSession("memberExpert") != null)
				memberExpert.addAll((List<Expert>)objMethods.getSession("memberExpert"));
			objMethods.setSession("leaderExpert", leaderExpert);
			objMethods.setSession("memberExpert", memberExpert);
			
/*			//储存多次抽取的结果
			List<Expert> resultOfLeaderExpert = (List<Expert>)objMethods.getSession("resultOfLeaderExpert");
			List<Expert> resultOfMemberExpert = (List<Expert>)objMethods.getSession("resultOfMemberExpert");
			
			if(resultOfLeaderExpert !=null) {
				resultOfLeaderExpert.addAll(leaderExpert); //此次抽取的结果保存
				objMethods.setSession("resultOfLeaderExpert", resultOfLeaderExpert);
			} else {
				resultOfLeaderExpert = new ArrayList<Expert>();
			}
			if(resultOfMemberExpert != null){
				resultOfMemberExpert.addAll(memberExpert);
				objMethods.setSession("resultOfMemberExpert", resultOfMemberExpert);
			} else {
				resultOfMemberExpert = new ArrayList<Expert>();
			}*/
		}
		 
		return super.execute();
	}

	public String addHistoryTitleForPYZ(){
		Methods objMethods = new Methods();
		List<Expert> leaderExpert = (List<Expert>) objMethods.getSession("leaderExpert");
		List<Expert> memberExpert = (List<Expert>) objMethods.getSession("memberExpert");

		//当前年份
		SimpleDateFormat format = new SimpleDateFormat("yyyy");
        Date date = new Date();
        String formatDate = format.format(date);
		
//        System.out.println("leaderResult: " + leaderResult.get(0));
//        System.out.println("memberResult: " + memberResult.get(0));
//        System.out.println("addHistoryTitleForPYZ -> leaderExpert: " + leaderExpert.size());
        if(leaderExpert !=null || memberExpert != null) {
        	if(new ReviewGroup().insertResult(leaderExpert, memberExpert, formatDate)){
            	feedback = "抽取结果以保存到\"任职管理\"";
            } else {
            	feedback = "抽取结果保存失败";
            }
        } else {
        	feedback = "请抽取之后再保存";
        }
        
		
		//删除session对象
/*		objMethods.deleteSession("leaderExpert");
		objMethods.deleteSession("memberExpert");*/
		
		return SUCCESS;
	}
	
	//getter & setter
	public String getGroupNo() {
		return groupNo;
	}

	public void setGroupNo(String groupNo) {
		this.groupNo = groupNo;
	}

	public ReviewGroup getObjReviewGroup() {
		return objReviewGroup;
	}

	public void setObjReviewGroup(ReviewGroup objReviewGroup) {
		this.objReviewGroup = objReviewGroup;
	}

	public List<Expert> getMembersOfGroup() {
		return membersOfGroup;
	}

	public void setMembersOfGroup(List<Expert> membersOfGroup) {
		this.membersOfGroup = membersOfGroup;
	}

	public GetExpert getObjGetExpert() {
		return objGetExpert;
	}

	public void setObjGetExpert(GetExpert objGetExpert) {
		this.objGetExpert = objGetExpert;
	}

	public GetGroup getObjGetGroup() {
		return objGetGroup;
	}

	public void setObjGetGroup(GetGroup objGetGroup) {
		this.objGetGroup = objGetGroup;
	}

	public JSONArray getJsonArray() {
		return jsonArray;
	}

	public void setJsonArray(JSONArray jsonArray) {
		this.jsonArray = jsonArray;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public String getResultString() {
		return resultString;
	}

	public void setResultString(String resultString) {
		this.resultString = resultString;
	}

	public int getNumberChoosen() {
		return numberChoosen;
	}

	public void setNumberChoosen(int numberChoosen) {
		this.numberChoosen = numberChoosen;
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

	public String getLeaderResult() {
		return leaderResult;
	}

	public void setLeaderResult(String leaderResult) {
		this.leaderResult = leaderResult;
	}

	public String getMemberResult() {
		return memberResult;
	}

	public void setMemberResult(String memberResult) {
		this.memberResult = memberResult;
	}

	public String getTheErrors() {
		return theErrors;
	}

	public void setTheErrors(String theErrors) {
		this.theErrors = theErrors;
	}

}
