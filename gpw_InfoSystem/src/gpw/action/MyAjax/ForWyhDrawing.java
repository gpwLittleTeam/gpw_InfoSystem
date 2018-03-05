package gpw.action.MyAjax;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import gpw.algorithm.ForCommittee;
import gpw.object.Expert;
import gpw.object.Methods;
import gpw.object.RuleManagement;
import gpw.object.UserLogin;

import com.opensymphony.xwork2.ActionSupport;

public class ForWyhDrawing extends ActionSupport{
	private ForCommittee objCommittee = new ForCommittee();
	private Methods objMethods = new Methods();
	private UserLogin objUserLogin;
	private String juryNo = objMethods.getCurrentUser().getUser_jury();
	//Json
	private JSONArray jsonArray;
	//抽取主任委员
	private List<Expert> listDirector; //
	private List<Expert> remainDirector;
	private String jsonListDirector;
	private int viceNo;
	private int committeeNo;
	private boolean nextStep;
	//抽取副主任委员
	private List<Expert> listViceDirector; //用于储存选中的副主任委员
	private List<Expert> remainViceDirector;
	private String jsonListViceDirector;
	//抽取委员
	private List<Expert> listCommittee;	
	private List<Expert> remainCommittee;
	private String jsonListCommittee;
	//插入抽取结果
	private String feedback;
	private String year;
	
	//校验抽取的人数
	public String verifyNo() {
		System.out.println("committeeNo: "+committeeNo);
		nextStep = false;
		//判断拟任主任委员的人数是否小于1
		ForCommittee objCommittee = new ForCommittee();
		List<Expert> expertsToExtract = objCommittee.showDirectors(juryNo); 
		int maxViceDirectorNr = objCommittee.selectMaxViceDirectorNumber(juryNo); //可抽取的最大的副主任委员数
		int maxCommiteeNr = objCommittee.selectMaxCommitteeNumber(juryNo, viceNo);
		if(expertsToExtract.size() <= 0) {
			feedback = "没有拟任主任委员的专家";
			
		}
		else if(committeeNo <= 0) {
			feedback = "抽取委员人数必须大于1";
		} else if(viceNo <=  0){
			feedback = "抽取副主任委员人数必须大于1";
		} else if(maxViceDirectorNr < viceNo){
			feedback = "可抽取副主任委员人数只有"+maxViceDirectorNr+"位";
		} else if(maxCommiteeNr < committeeNo){
			feedback = "可抽取的委员人数只有" + maxCommiteeNr + "位";
		} else {//成功进入下一步
			nextStep = true; 			
		}
		return SUCCESS;
	}
	
	public String drawDirector(){
		listDirector = new ArrayList<Expert>();
		remainDirector = objCommittee.extractDirector(juryNo, listDirector);
	//	System.out.println("listdirector.size():"+listDirector.size());
	//	objMethods.setSession("listDirector", listDirector);   //是否要set 暂注释
		
		objMethods.setSession("remainDirector", remainDirector);
		objMethods.setSession("listDirector", listDirector);
		//重抽之后，副教授和委员的抽取结果都要清除
		objMethods.deleteSession("listViceDirector");  
		objMethods.deleteSession("listCommittee");
		
		jsonArray = JSONArray.fromObject(listDirector);
		jsonListDirector = jsonArray.toString();
		return SUCCESS;
	}

	public String drawViceDirector() {
		listViceDirector = new ArrayList<Expert>();//用于储存选中的副主任委员
		remainDirector = (List<Expert>)objMethods.getSession("remainDirector");  //抽完主任委员之后剩余的副主任委员候选人
		viceNo =(int)objMethods.getSession("viceNo");
		remainViceDirector = objCommittee.extractViceDirector(juryNo, remainDirector, listViceDirector, viceNo);  //抽完副主任委员后的人储存在remainViceDirectors
		
		objMethods.setSession("remainViceDirector", remainViceDirector);
		objMethods.setSession("listViceDirector", listViceDirector);
		//重抽之后，委员的抽取结果都要清除
		objMethods.deleteSession("listCommittee");
		
		jsonArray = JSONArray.fromObject(listViceDirector);
		jsonListViceDirector = jsonArray.toString();
		
		return SUCCESS;
	}

	public String drawingCommittee() throws ParseException {
		String result = "0";  //判断是否符合规则，0为符合规则
		int loopCount = 0;  //循环次数判断
		int maxCount = 100; //最大次数
		listDirector = (List<Expert>)objMethods.getSession("listDirector");
		listViceDirector = (List<Expert>)objMethods.getSession("listViceDirector");
		committeeNo = (int)objMethods.getSession("committeeNo");
		//System.out.println("drawingCommittee() . remainViceDirector.size() :"+remainViceDirector.size());
		//循环maxCount次
		do{
			listCommittee = new ArrayList<Expert>();
			//listCommittee = objCommittee.extractCommittee(juryNo, committeeNo);  //抽取委员
			objCommittee.extractCommittee(juryNo,listCommittee ,committeeNo);  //抽取委员
			//把主任委员，副主任委员，委员合并到一个totalExpert中
			ArrayList<Expert> totalExpert = new ArrayList<Expert>();
			totalExpert.addAll(listDirector);
			totalExpert.addAll(listViceDirector);
			totalExpert.addAll(listCommittee);
			//判断是否符合规则
			result = objCommittee.check(totalExpert, (List<RuleManagement>)objMethods.getSession("rules"));
			loopCount++;
			System.out.println("MyAjax.ForWyhDrawing.drawingCommittee() result of check : " + result);
			System.out.println("循环次数：" + loopCount);
		} while(!result.equals("0") && loopCount < maxCount);
		objMethods.setSession("result", result);
		objMethods.setSession("listCommittee",listCommittee);
		jsonArray = JSONArray.fromObject(listCommittee);
		jsonListCommittee = jsonArray.toString();

		return SUCCESS;
	}
	
	//委员会抽取结果录入数据库
	public String addHistoryTitleForWYH() {
		listViceDirector = (List<Expert>)objMethods.getSession("listViceDirector");
		listDirector = (List<Expert>)objMethods.getSession("listDirector");
		listCommittee = (List<Expert>)objMethods.getSession("listCommittee");
		//提取个专家的No
		List<String> directorId = new ArrayList<String>();
		List<String> viceDirectorId = new ArrayList<String>();
		List<String> committeeId = new ArrayList<String>();
		for(int i=0;i<listDirector.size();i++){
			directorId.add(listDirector.get(i).getExpert_Field1());
		}
		for(int i=0;i<listViceDirector.size();i++){
			viceDirectorId.add(listViceDirector.get(i).getExpert_Field1());
		}
		for(int i=0;i<listCommittee.size();i++){
			committeeId.add(listCommittee.get(i).getExpert_Field1());
		}
		
		year = (String)objMethods.getSession("year");
		ForCommittee objCommittee = new ForCommittee();
		objCommittee.insertResult(directorId, viceDirectorId, committeeId, year);
		String error = objMethods.getError();
		if(error != null) {
			switch(error){
			case "NoExpertsToInsertResult": feedback = "保存失败！存在未抽取项"; break;
			default : feedback = "保存失败！"; break;
			}
		} else {
			feedback = "保存成功！";
		}
		return SUCCESS;
	}

	
	public ForCommittee getObjCommittee() {
		return objCommittee;
	}

	public void setObjCommittee(ForCommittee objCommittee) {
		this.objCommittee = objCommittee;
	}

	public Methods getObjMethods() {
		return objMethods;
	}

	public void setObjMethods(Methods objMethods) {
		this.objMethods = objMethods;
	}

	public UserLogin getObjUserLogin() {
		return objUserLogin;
	}

	public void setObjUserLogin(UserLogin objUserLogin) {
		this.objUserLogin = objUserLogin;
	}

	public String getJuryNo() {
		return juryNo;
	}

	public void setJuryNo(String juryNo) {
		this.juryNo = juryNo;
	}

	public JSONArray getJsonArray() {
		return jsonArray;
	}

	public void setJsonArray(JSONArray jsonArray) {
		this.jsonArray = jsonArray;
	}

	public List<Expert> getListDirector() {
		return listDirector;
	}

	public void setListDirector(List<Expert> listDirector) {
		this.listDirector = listDirector;
	}

	public List<Expert> getRemainDirector() {
		return remainDirector;
	}

	public void setRemainDirector(List<Expert> remainDirector) {
		this.remainDirector = remainDirector;
	}

	public String getJsonListDirector() {
		return jsonListDirector;
	}

	public void setJsonListDirector(String jsonListDirector) {
		this.jsonListDirector = jsonListDirector;
	}

	public List<Expert> getListViceDirector() {
		return listViceDirector;
	}

	public void setListViceDirector(List<Expert> listViceDirector) {
		this.listViceDirector = listViceDirector;
	}

	public List<Expert> getRemainViceDirector() {
		return remainViceDirector;
	}

	public void setRemainViceDirector(List<Expert> remainViceDirector) {
		this.remainViceDirector = remainViceDirector;
	}

	public String getJsonListViceDirector() {
		return jsonListViceDirector;
	}

	public void setJsonListViceDirector(String jsonListViceDirector) {
		this.jsonListViceDirector = jsonListViceDirector;
	}

	public List<Expert> getListCommittee() {
		return listCommittee;
	}

	public void setListCommittee(List<Expert> listCommittee) {
		this.listCommittee = listCommittee;
	}

	public List<Expert> getRemainCommittee() {
		return remainCommittee;
	}

	public void setRemainCommittee(List<Expert> remainCommittee) {
		this.remainCommittee = remainCommittee;
	}

	public String getJsonListCommittee() {
		return jsonListCommittee;
	}

	public void setJsonListCommittee(String jsonListCommittee) {
		this.jsonListCommittee = jsonListCommittee;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public int getViceNo() {
		return viceNo;
	}

	public void setViceNo(int viceNo) {
		this.viceNo = viceNo;
	}

	public int getCommitteeNo() {
		return committeeNo;
	}

	public void setCommitteeNo(int committeeNo) {
		this.committeeNo = committeeNo;
	}

	public boolean isNextStep() {
		return nextStep;
	}

	public void setNextStep(boolean nextStep) {
		this.nextStep = nextStep;
	}

}

//比如 
	
