package gpw.action.jump;

import gpw.algorithm.Committee;
import gpw.object.Expert;
import gpw.object.Judge;
import gpw.object.Methods;
import gpw.object.Titlegrade;
import gpw.object.UserLogin;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.omg.CosNaming.IstringHelper;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class To_Pwcq_wyh extends ActionSupport{
	private int[] years;
	private Committee objCommittee = new Committee();
	private Methods objMethods = new Methods();
	private int listSize;  //展示列表的长度
	//firstPage
	private int viceNo;
	private int committeeNo;
	private String year;
	//thridPage
	private List<Expert> candidateViceDirector;
	private List<Expert> remainDirector;
	//secPage
	private List<Expert> listExpert;  //=candidateDirector
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
	private int result; //抽取结果是否符合规则 ， 0为符合规则
	private String ratioOfSenior;  //正高级比例
	private String ratioOfAge;  //45岁以下
	private String rationOfOutsider; //非本单位的人的比例
	
	public String firstPage() {
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
	}

	public String secPage() {
		directorListSize = 0;
		String juryNo = objMethods.getCurrentUser().getUser_jury();  //当前用户的所属高评委的Jury
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
	
	public String fourthPage() {
		int year = Integer.parseInt((String)objMethods.getSession("year"));
		String juryNo = objMethods.getCurrentUser().getUser_jury();  //当前用户的所属高评委的Jury
		remainViceDirector = (List<Expert>)objMethods.getSession("remainViceDirector");
		candidateCommittee = objCommittee.showCommittee(juryNo, remainViceDirector, year);
		objMethods.setSession("candidateCommittee", candidateCommittee);
		listSize = candidateCommittee.size();
		//加载已抽的结果
		listCommittee = (List<Expert>)objMethods.getSession("listCommittee");
		if (listCommittee != null)
			committeeListSize = listCommittee.size();
		
		return "fourthPage";
	}
	
	public String resultPage(){
		listViceDirector = (List<Expert>)objMethods.getSession("listViceDirector");
		listDirector = (List<Expert>)objMethods.getSession("listDirector");
		listCommittee = (List<Expert>)objMethods.getSession("listCommittee");
		result = (int)objMethods.getSession("result");
		System.out.println("result: " + result);
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
		candidateCommittee = objCommittee.showCommittee(juryNo, remainViceDirector, year);
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

	public Committee getObjCommittee() {
		return objCommittee;
	}

	public void setObjCommittee(Committee objCommittee) {
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

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

}
