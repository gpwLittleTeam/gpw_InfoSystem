package gpw.action.jump;

import gpw.algorithm.ForCommittee;
import gpw.algorithm.ForRuleContent;
import gpw.getInfo.GetJury;
import gpw.getInfo.GetRuleManagement;
import gpw.object.Expert;
import gpw.object.Judge;
import gpw.object.Jury;
import gpw.object.Methods;
import gpw.object.RuleManagement;
import gpw.object.Titlegrade;
import gpw.object.UserLogin;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.dom4j.rule.Rule;
import org.omg.CosNaming.IstringHelper;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class To_Pwcq_wyh extends ActionSupport{
	private int[] years;
	private ForCommittee objCommittee = new ForCommittee();
	private Methods objMethods = new Methods();
	private int listSize;  //展示列表的长度
	private List<String> ruleCheckbox;  //用户使用的可选的规则
	//firstPage
	private List<RuleManagement> listRuleManagements;
	private int viceNo;
	private int committeeNo;
	private String year;
	//secPage
	private List<Expert> listExpert;  //=candidateDirector
	//thridPage
	private List<Expert> candidateViceDirector;
	private List<Expert> remainDirector;
	//fourthPage
	private List<Expert> remainViceDirector;  //没有被选中的主任委员加副主任委员
	private List<Expert> candidateCommittee;
	//resultPage
	private List<Expert> listViceDirector;  //选中的副主任委员
	private List<Expert> listCommittee;
	private List<Expert> listDirector;
	private int viceDirectorListSize;
	private int committeeListSize;
	private int directorListSize;
	private String result; //抽取结果是否符合规则 ， 0为符合规则
	private String ratioOfSenior;  //正高级比例
	private String ratioOfAge;  //45岁以下
	private String rationOfOutsider; //非本单位的人的比例
	private String feedback;
	
	public String firstPage() {
		/*[旧]*/
		/*
		//清理Session
		objMethods.clearSession();
		//系统年份
		SimpleDateFormat format = new SimpleDateFormat("yyyy");
        Date date = new Date();
        int formatDate = Integer.parseInt(format.format(date));
		int length = 80;
		years = new int[length];
		for(int i=0;i<length;i++) {
			years[i] = formatDate - i;
		}
		return "firstPage";
		*/
		/*[旧] end*/
		//清理Session
		objMethods.clearSession();
		/*系统年份*/
		SimpleDateFormat format = new SimpleDateFormat("yyyy");
        Date date = new Date();
        int formatDate = Integer.parseInt(format.format(date));
		int length = 80;
		years = new int[length];
		for(int i=0;i<length;i++) {
			years[i] = formatDate - i;
		}
		/*系统年份 end*/
		/*规则*/
		//取得当前用户所在的高评委的评审权限
		String juryPower = new Jury().getJuryPowerByJuryNo(new Methods().getCurrentUser().getUser_jury()); 
		System.out.println("juryPower:"  + juryPower);
		GetRuleManagement objGetRuleManagement = new GetRuleManagement();
		listRuleManagements = objGetRuleManagement.getEnabledRuleManagementByJuryPower(juryPower);
		List<String> ruleContent = new ForRuleContent().getRuleContent(listRuleManagements);
		for(int i=0;i<listRuleManagements.size();i++){
			listRuleManagements.get(i).setRule_field(ruleContent.get(i));
		}
		/*规则 end*/
		return "firstPage";
	}

	public String secPage() {
		String juryNo = objMethods.getCurrentUser().getUser_jury();  //当前用户的所属高评委的JuryNo
		GetRuleManagement objGetRuleManagement = new GetRuleManagement();
		GetJury objGetJury = new GetJury();
		Jury objJury = objGetJury.getJuryByNo(juryNo); //获取该高评委
		/*获取规则*/
		List<RuleManagement> rules = objGetRuleManagement.getRuleManagementByRuleNo(ruleCheckbox);;  //选择的规则
		rules.addAll(objGetRuleManagement.getForceRuleManagementByJuryPower(objJury.getJury_power()));//使用的规则 = 强制的规则 + 选择的规则
		//System.out.println("rules.size()" + rules.size());
		objMethods.setSession("rules", rules);//储存使用的规则至session
		/*获取规则 end*/
		directorListSize = 0;
		listExpert = objCommittee.showDirectors(juryNo);  //所有参与抽取的Expert
		listSize = listExpert.size();
		//用于返回上级
		objMethods.setSession("viceNo", viceNo);
		objMethods.setSession("committeeNo", committeeNo);
		objMethods.setSession("year", year);
//		System.out.println("year:"+year);
		//加载已抽的结果
		listDirector = (List<Expert>)objMethods.getSession("listDirector");
//		System.out.println("listDirector:"+listDirector);
		if(listDirector != null) {
			directorListSize = listDirector.size();
		}
		//
		
		return "secPage";
	}
	
	public String thridPage() {
		String juryNo = objMethods.getCurrentUser().getUser_jury();  //当前用户的所属高评委的Jury
		remainDirector = (List<Expert>) objMethods.getSession("remainDirector");//抽完主任委员剩下的人
		candidateViceDirector = objCommittee.showViceDirectors(juryNo, remainDirector);  //副主任委员候选人
		listSize = candidateViceDirector.size();
		//加载已抽的结果
		listViceDirector = (List<Expert>)objMethods.getSession("listViceDirector");
		if(listViceDirector != null){
			viceDirectorListSize = listViceDirector.size(); 
		}
		
		return "thridPage";
	}
	
	
	/**
	 * [旧]委员抽取候选人结合了上一年的评委会的1/2
	 * @return
	 */
	/* 旧版
	public String fourthPage() {
		int year = Integer.parseInt((String)objMethods.getSession("year"));
		String juryNo = objMethods.getCurrentUser().getUser_jury();  //当前用户的所属高评委的Jury
		remainViceDirector = (List<Expert>)objMethods.getSession("remainViceDirector");
		//
		candidateCommittee = objCommittee.showCommittee(juryNo, remainViceDirector, year);
		objMethods.setSession("candidateCommittee", candidateCommittee);
		listSize = candidateCommittee.size();
		//加载已抽的结果
		listCommittee = (List<Expert>)objMethods.getSession("listCommittee");
		if (listCommittee != null)
			committeeListSize = listCommittee.size();
		
		return "fourthPage";
	}
	*/
	
	/**
	 * [新]根据规则库的委员抽取
	 * @return
	 */
	public String fourthPage() {
		String juryNo = objMethods.getCurrentUser().getUser_jury();  //当前用户的所属高评委的Jury
		remainViceDirector = (List<Expert>)objMethods.getSession("remainViceDirector");
		//
		candidateCommittee = objCommittee.showCommittee(juryNo, remainViceDirector);
		objMethods.setSession("candidateCommittee", candidateCommittee);
		listSize = candidateCommittee.size();  //用于页面布局
		//加载已抽的结果,页面来回跳转的时候用
		listCommittee = (List<Expert>)objMethods.getSession("listCommittee");
		if (listCommittee != null)
			committeeListSize = listCommittee.size();
		
		return "fourthPage";
	}
	
	public String resultPage(){
		listViceDirector = (List<Expert>)objMethods.getSession("listViceDirector");
		listDirector = (List<Expert>)objMethods.getSession("listDirector");
		listCommittee = (List<Expert>)objMethods.getSession("listCommittee");
		result = (String)objMethods.getSession("result");
		System.out.println("result: " + result);
		//抽取不满足规则的提示
		if(result != "0") {
			ForRuleContent objContent = new ForRuleContent();
			GetRuleManagement objGetRuleManagement = new GetRuleManagement();
			List<RuleManagement> listRuleManagements = new ArrayList<RuleManagement>();
			listRuleManagements.add(objGetRuleManagement.getRuleManagementByRuleNo(result));
			feedback = objContent.getRuleContent(listRuleManagements).get(0); 
		}
		//人数统计
		directorListSize = listDirector.size();
		viceDirectorListSize = listViceDirector.size();
		committeeListSize = listCommittee.size();
		//比例统计
		int nrOfSenior = 0; //正高级人数
		int nrOfAgeLessThan45 = 0;//年龄小于45
		int nrOfOutsider = 0;
		Titlegrade objTitlegrade = new Titlegrade();
		Judge objJudge = new Judge();
		String nameOfSenior = objTitlegrade.getTitlegradeByCode("1"); //"正高级"
		String nameOfJudge = objJudge.getJudgeByCode("0");  //"否"
		
		//精确两位小数
		DecimalFormat decimalFormat=new DecimalFormat("0.00");
		
		SimpleDateFormat dateFromat = new SimpleDateFormat("yyyy");
		Date date = new Date();
		int year = Integer.parseInt(dateFromat.format(date));//当前年份
		int age;
//		System.out.println("nameOfSenior:"+nameOfSenior);
		for (int i=0;i<directorListSize;i++){
			//正高级
			if(listDirector.get(i).getExpert_Field18().equals(nameOfSenior)){
				nrOfSenior++;
			}
			//45岁以下
			age = year - Integer.parseInt(listDirector.get(i).getExpert_Field5().substring(0, 4));
			if(age <= 45){
				nrOfAgeLessThan45++;
			}
			//非本单位
			if(listDirector.get(i).getExpert_Field15() != null && listDirector.get(i).getExpert_Field15().equals(nameOfJudge)){
				nrOfOutsider++;
			}
		}
		for (int i=0;i<viceDirectorListSize;i++){
			if(listViceDirector.get(i).getExpert_Field18().equals(nameOfSenior)){
				nrOfSenior++;
			}
			
			age = year - Integer.parseInt(listViceDirector.get(i).getExpert_Field5().substring(0, 4));
			if(age <= 45){
				nrOfAgeLessThan45++;
			}
			if(listViceDirector.get(i).getExpert_Field15() != null && listViceDirector.get(i).getExpert_Field15().equals(nameOfJudge)){
				nrOfOutsider++;
			}
		}
		for (int i=0;i<committeeListSize;i++){
			if(listCommittee.get(i).getExpert_Field18().equals(nameOfSenior)){
				nrOfSenior++;
			}
			
			age = year - Integer.parseInt(listCommittee.get(i).getExpert_Field5().substring(0, 4));
			if(age <= 45){
				nrOfAgeLessThan45++;
			}
			if(listCommittee.get(i).getExpert_Field15() != null &&listCommittee.get(i).getExpert_Field15().equals(nameOfJudge)){
				nrOfOutsider++;
			}
		}
		int total = directorListSize+viceDirectorListSize+committeeListSize;
		ratioOfSenior = decimalFormat.format((float)nrOfSenior / total * 100);//正高级比例
		ratioOfAge =  decimalFormat.format((float)nrOfAgeLessThan45 / total * 100);//年龄低于45岁的比例
		rationOfOutsider = decimalFormat.format((float)nrOfOutsider / total * 100); ////外单位的比例
		//rationOfOutsider =  //非本单位的人的比例

		objMethods.setSession("ratioOfSenior", ratioOfSenior);
		objMethods.setSession("ratioOfAge", ratioOfAge);
		objMethods.setSession("rationOfOutsider", rationOfOutsider);
		return "result";
	}
	
	public String finalPage() {
		listViceDirector = (List<Expert>)objMethods.getSession("listViceDirector");
		listDirector = (List<Expert>)objMethods.getSession("listDirector");
		listCommittee = (List<Expert>)objMethods.getSession("listCommittee");
		
		if(listDirector != null)
			directorListSize = listDirector.size();
		else 
			directorListSize = 0;
		
		if(listViceDirector != null)
			viceDirectorListSize = listViceDirector.size();
		else 
			viceDirectorListSize = 0;
		
		if(listCommittee != null)
			committeeListSize = listCommittee.size();
		else 
			committeeListSize = 0;
		
		return "final";
	}
	
	public String finalPagePrint() {
		finalPage();
		
		return "final_print";
	}
	
	public String backFirst() {
		viceNo = (int)objMethods.getSession("viceNo");
		committeeNo = (int)objMethods.getSession("committeeNo");
		year = (String)objMethods.getSession("year");
		//系统年份
		SimpleDateFormat format = new SimpleDateFormat("yyyy");
        Date date = new Date();
        int formatDate = Integer.parseInt(format.format(date));
		int length = 80;
		years = new int[length];
		for(int i=0;i<length;i++) {
			years[i] = formatDate - i;
		}
		return "backFirst";
	}
	
	public String backSec() {
		String juryNo = objMethods.getCurrentUser().getUser_jury();  
		listDirector = (List<Expert>)objMethods.getSession("listDirector");

		directorListSize = listDirector.size();
		listExpert = objCommittee.showDirectors(juryNo);  //所有参与抽取的Expert
		listSize = listExpert.size();
		
		return "backSec";
	}
	
	public String backThird() {
		String juryNo = objMethods.getCurrentUser().getUser_jury();
		remainDirector = (List<Expert>) objMethods.getSession("remainDirector");
		candidateViceDirector = objCommittee.showViceDirectors(juryNo, remainDirector);  //副主任委员候选人
		listSize = candidateViceDirector.size();//候选人
		
		listViceDirector = (List<Expert>)objMethods.getSession("listViceDirector");
		if(listViceDirector != null){
			viceDirectorListSize = listViceDirector.size(); 
		}
		return "backThird";
	}
	
	public String backFourth() {
		//候选委员
		int year = Integer.parseInt((String)objMethods.getSession("year"));
		String juryNo = objMethods.getCurrentUser().getUser_jury();  //当前用户的所属高评委的Jury
		remainViceDirector = (List<Expert>)objMethods.getSession("remainViceDirector");
		candidateCommittee = objCommittee.showCommittee(juryNo, remainViceDirector);
		listSize = candidateCommittee.size();
		
		//抽取结果
		listCommittee = (List<Expert>)objMethods.getSession("listCommittee");
		if (listCommittee != null){
			committeeListSize = listCommittee.size();
			System.out.println("committeeListSize" + committeeListSize);
		}
		return "backFourth";
	}
	
	public String backResult() {
		listViceDirector = (List<Expert>)objMethods.getSession("listViceDirector");
		listDirector = (List<Expert>)objMethods.getSession("listDirector");
		listCommittee = (List<Expert>)objMethods.getSession("listCommittee");
		
		//人数统计
		directorListSize = listDirector.size();
		viceDirectorListSize = listViceDirector.size();
		committeeListSize = listCommittee.size();
		
		
/*		ratioOfSenior = (String)objMethods.getSession("ratioOfSenior");
		ratioOfAge = (String)objMethods.getSession("ratioOfAge");*/
		
		return "backResult";
	}
/*	public String fourthPage() {
		objCommittee = new Committee();
		String juryNo = objMethods.getCurrentUser().getUser_jury();  //当前用户的所属高评委的Jury
		remainViceDirector = (List<Expert>) objMethods.getSession("remainViceDirector");//抽完副主任委员剩下的人
//		System.out.println("thridPage().remainDirector.size()" + remainDirector.size());
		remainDirector = objCommittee.showViceDirectors(juryNo, remainDirector);  //组长员候选人
		listSize = remainDirector.size();
		//listExpert = objCommittee.showViceDirectors(juryNo,); 
		
		objMethods.setSession("remainDirector", remainDirector);
		
		return "thridPage";
	}*/
	
	
	public int[] getYears() {
		return years;
	}

	public void setYears(int[] years) {
		this.years = years;
	}

	public int getDeputyNo() {
		return viceNo;
	}

	public void setDeputyNo(int deputyNo) {
		this.viceNo = deputyNo;
	}

	public int getCommitteeNo() {
		return committeeNo;
	}

	public void setCommitteeNo(int committeeNo) {
		this.committeeNo = committeeNo;
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

	public List<Expert> getListExpert() {
		return listExpert;
	}

	public void setListExpert(List<Expert> listExpert) {
		this.listExpert = listExpert;
	}

	public int getListSize() {
		return listSize;
	}

	public void setListSize(int listSize) {
		this.listSize = listSize;
	}

	public List<Expert> getRemainDirector() {
		return remainDirector;
	}

	public void setRemainDirector(List<Expert> remainDirector) {
		this.remainDirector = remainDirector;
	}

	public List<Expert> getListViceDirector() {
		return listViceDirector;
	}

	public void setListViceDirector(List<Expert> listViceDirector) {
		this.listViceDirector = listViceDirector;
	}

	public int getViceNo() {
		return viceNo;
	}

	public void setViceNo(int viceNo) {
		this.viceNo = viceNo;
	}

	public List<Expert> getCandidateViceDirector() {
		return candidateViceDirector;
	}

	public void setCandidateViceDirector(List<Expert> candidateViceDirector) {
		this.candidateViceDirector = candidateViceDirector;
	}

	public List<Expert> getListDirector() {
		return listDirector;
	}

	public void setListDirector(List<Expert> listDirector) {
		this.listDirector = listDirector;
	}

	public List<Expert> getRemainViceDirector() {
		return remainViceDirector;
	}

	public void setRemainViceDirector(List<Expert> remainViceDirector) {
		this.remainViceDirector = remainViceDirector;
	}

	public List<Expert> getCandidateCommittee() {
		return candidateCommittee;
	}

	public void setCandidateCommittee(List<Expert> candidateCommittee) {
		this.candidateCommittee = candidateCommittee;
	}

	public List<Expert> getListCommittee() {
		return listCommittee;
	}

	public void setListCommittee(List<Expert> listCommittee) {
		this.listCommittee = listCommittee;
	}

	public int getViceDirectorListSize() {
		return viceDirectorListSize;
	}

	public void setViceDirectorListSize(int viceDirectorListSize) {
		this.viceDirectorListSize = viceDirectorListSize;
	}

	public int getCommitteeListSize() {
		return committeeListSize;
	}

	public void setCommitteeListSize(int committeeListSize) {
		this.committeeListSize = committeeListSize;
	}

	public int getDirectorListSize() {
		return directorListSize;
	}

	public void setDirectorListSize(int directorListSize) {
		this.directorListSize = directorListSize;
	}

	public String getRatioOfSenior() {
		return ratioOfSenior;
	}

	public void setRatioOfSenior(String ratioOfSenior) {
		this.ratioOfSenior = ratioOfSenior;
	}

	public String getRatioOfAge() {
		return ratioOfAge;
	}

	public void setRatioOfAge(String ratioOfAge) {
		this.ratioOfAge = ratioOfAge;
	}

	public String getRationOfOutsider() {
		return rationOfOutsider;
	}

	public void setRationOfOutsider(String rationOfOutsider) {
		this.rationOfOutsider = rationOfOutsider;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public List<String> getRuleCheckbox() {
		return ruleCheckbox;
	}

	public void setRuleCheckbox(List<String> ruleCheckbox) {
		this.ruleCheckbox = ruleCheckbox;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public List<RuleManagement> getListRuleManagements() {
		return listRuleManagements;
	}

	public void setListRuleManagements(List<RuleManagement> listRuleManagements) {
		this.listRuleManagements = listRuleManagements;
	}

}
