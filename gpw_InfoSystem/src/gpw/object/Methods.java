package gpw.object;

import gpw.getInfo.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;

public class Methods {
	//得到当前登陆用户
	public UserLogin getCurrentUser(){
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST); 
		UserLogin objUserLogin = (UserLogin) request.getSession().getAttribute("User");
		return objUserLogin;
	}
	
	// 设置Entry and InfoUpdate 页面的select和dataList中英字段，找到对应代码表
	public void setOpinionsOfSelect(List<String>[] arrayOfNameList, List<String>[] arrayOfCodeList, String juryNo) {
		Special objSpecial;
		Judge objJudge;
		Grouptitle objGrouptitle;
		Title objTitle;
		Engage objEngage;
		Counciltitle objCounciltitle;
		GetGroup objGetGroup;
		Titlegrade objTitlegrade;
		Series objSeries;
		Degree objDegree;
		Sex objSex;
		Education objEducation;
		Jury objJury;
		
		//规则 (i == id-1)
		for (int i = 0; i < arrayOfNameList.length; i++) {
			if (i == 9 || i == 11) { // 专业代码表|9=所学专业 /11=现从事专业
				objSpecial = new Special();
				arrayOfNameList[i] = objSpecial.getAllSpecialname();
				arrayOfCodeList[i] = objSpecial.getAllCode();
			} else if (i == 14) { // 是否|14=是否本单位
				objJudge = new Judge();
				arrayOfNameList[i] = objJudge.getAllJudge();
				arrayOfCodeList[i] = objJudge.getAllCode();
			} else if (i == 33) { // 学科组职务代码表 | 33=专业组职务
				objGrouptitle = new Grouptitle();
				arrayOfNameList[i] = objGrouptitle.getAllPost();
				arrayOfCodeList[i] = objGrouptitle.getAllCode();
			} else if (i == 16) { // 专业技术资格代码表 | 16=现有任职资格
				objTitle = new Title();
				arrayOfNameList[i] = objTitle.getAllTitlename();
				arrayOfCodeList[i] = objTitle.getAllCode();
			} else if (i == 20) { // 聘任情况 | 20=聘任情况
				objEngage = new Engage();
				arrayOfNameList[i] = objEngage.getAllEmploy();
				arrayOfCodeList[i] = objEngage.getAllCode();
			} else if (i == 22 || i == 31) { // 高评委职务代码表|| 22=高评委职务
				objCounciltitle = new Counciltitle();
				arrayOfNameList[i] = objCounciltitle.getAllName();
				arrayOfCodeList[i] = objCounciltitle.getAllCode();
			} else if (i == 32) { // 专业组名称|
				objGetGroup = new GetGroup();
				List<String> listOfGroupNo = new ArrayList<String>();
				List<String> listOfGroupName = new ArrayList<String>();
				List<Group> listOfGroup = objGetGroup.getGroupByJury(juryNo);

				for(int j=0;j<objGetGroup.getGroupByJury(juryNo).size();j++){
					listOfGroupNo.add(listOfGroup.get(j).getGroup_no());
					listOfGroupName.add(listOfGroup.get(j).getGroup_name());
				}
				arrayOfCodeList[i] = listOfGroupNo;
				arrayOfNameList[i] = listOfGroupName;
			} else if (i == 17) { // 资格级别
				objTitlegrade = new Titlegrade();
				arrayOfCodeList[i] = objTitlegrade.getAllCode();
				arrayOfNameList[i] = objTitlegrade.getAllTitlegrade();
			} else if (i == 18) { // 任职资格所属系列
				objSeries = new Series();
				arrayOfNameList[i] = objSeries.getAllSeries();
				arrayOfCodeList[i] = objSeries.getAllCode();
			} else if (i == 6) { // 所获学位
				objDegree = new Degree();
				arrayOfCodeList[i] = objDegree.getAllCode();
				arrayOfNameList[i] = objDegree.getAllDegree();
			} else if (i == 5) {// 最高学历
				objEducation = new Education();
				arrayOfCodeList[i] = objEducation.getAllCode();
				arrayOfNameList[i] = objEducation.getAllEducation();
			} else if (i == 2) { // 性别
				objSex = new Sex();
				arrayOfCodeList[i] = objSex.getAllCode();
				arrayOfNameList[i] = objSex.getAllSex();
			} else if(i == 30 || i == 21) { //datalist 30=所属高评委 | 21=曾属高评委
				objJury = new Jury();
				arrayOfNameList[i] = objJury.getAllJuryName();
				arrayOfCodeList[i] = objJury.getAllJuryNo();
			}
		}
	}
	
	// 设置Entry and InfoUpdate 页面的select和dataList中英字段，找到对应代码表
	public void setOpinionsOfSelectZjEntry(List<String>[] arrayOfNameList, List<String>[] arrayOfCodeList) {
		Special objSpecial;
		Judge objJudge;
		Grouptitle objGrouptitle;
		Title objTitle;
		Engage objEngage;
		Counciltitle objCounciltitle;
		Titlegrade objTitlegrade;
		Series objSeries;
		Degree objDegree;
		Sex objSex;
		Education objEducation;
		Jury objJury;
		
		//规则 (i == id-1)
		for (int i = 0; i < arrayOfNameList.length; i++) {
			if (i == 8 || i == 10) { // 专业代码表|9=所学专业 /11=现从事专业
				objSpecial = new Special();
				arrayOfNameList[i] = objSpecial.getAllSpecialname();
				arrayOfCodeList[i] = objSpecial.getAllCode();
			} else if (i == 13) { // 是否|14=是否本单位
				objJudge = new Judge();
				arrayOfNameList[i] = objJudge.getAllJudge();
				arrayOfCodeList[i] = objJudge.getAllCode();
			} else if (i == 30) { // 学科组职务代码表 | 33=专业组职务
				objGrouptitle = new Grouptitle();
				arrayOfNameList[i] = objGrouptitle.getAllPost();
				arrayOfCodeList[i] = objGrouptitle.getAllCode();
			} else if (i == 15) { // 专业技术资格代码表 | 16=现有任职资格
				objTitle = new Title();
				arrayOfNameList[i] = objTitle.getAllTitlename();
				arrayOfCodeList[i] = objTitle.getAllCode();
			} else if (i == 19) { // 聘任情况 | 20=聘任情况
				objEngage = new Engage();
				arrayOfNameList[i] = objEngage.getAllEmploy();
				arrayOfCodeList[i] = objEngage.getAllCode();
			} else if (i == 21 || i == 29) { // 高评委职务代码表|| 22=高评委职务
				objCounciltitle = new Counciltitle();
				arrayOfNameList[i] = objCounciltitle.getAllName();
				arrayOfCodeList[i] = objCounciltitle.getAllCode();
			} else if (i == 16) { // 资格级别
				objTitlegrade = new Titlegrade();
				arrayOfCodeList[i] = objTitlegrade.getAllCode();
				arrayOfNameList[i] = objTitlegrade.getAllTitlegrade();
			} else if (i == 17) { // 任职资格所属系列
				objSeries = new Series();
				arrayOfNameList[i] = objSeries.getAllSeries();
				arrayOfCodeList[i] = objSeries.getAllCode();
			} else if (i == 5) { // 所获学位
				objDegree = new Degree();
				arrayOfCodeList[i] = objDegree.getAllCode();
				arrayOfNameList[i] = objDegree.getAllDegree();
			} else if (i == 4) {// 最高学历
				objEducation = new Education();
				arrayOfCodeList[i] = objEducation.getAllCode();
				arrayOfNameList[i] = objEducation.getAllEducation();
			} else if (i == 1) { // 性别
				objSex = new Sex();
				arrayOfCodeList[i] = objSex.getAllCode();
				arrayOfNameList[i] = objSex.getAllSex();
			} else if(i == 20) { //datalist 30=所属高评委 | 21=曾属高评委
				objJury = new Jury();
				arrayOfNameList[i] = objJury.getAllJuryName();
				arrayOfCodeList[i] = objJury.getAllJuryNo();
			}
		}
	}
	
	//初始化专家列表for GPW
	public List<Expert> initializeExpertListForGPWByJuryNo(String juryNo) {
		GetExpert objGetExpert = new GetExpert();
		Jury objJury = new Jury(); 
		String juryName = objJury.getJuryNameByJuryNo(juryNo);
		List<Expert> expertList = objGetExpert.getExpertByJuryFromInfoView(juryName);
		
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST); 
		request.getSession().setAttribute("expertList", expertList);

		return expertList;
	}
	
	public List<Expert> initializeExpertListForGPWByJuryName(String juryName) {
		GetExpert objGetExpert = new GetExpert();

		List<Expert> expertList = objGetExpert.getExpertByJuryFromInfoView(juryName);
		
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST); 
		request.getSession().setAttribute("expertList", expertList);

		return expertList;
	}
	
	//初始化专家列表for GLY
	public List<Expert> initializeExpertListForGLY() {
		GetExpert	objGetExpert = new GetExpert();
		List<Expert> expertList = objGetExpert.getAllExpertsFromInfoView();
		
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST); 
		request.getSession().setAttribute("expertList", expertList);

		return expertList;
	}
	
	//初始化 默认字段 gpw and gly
	public void initializeDefaultFieldList(String UserName) {
		List<String> intDefaultFieldList;
		List<String> chDefaultFieldList;
		UserField objUserField;
		objUserField = new UserField();
	
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
		
		intDefaultFieldList = objUserField.getDefaultFieldNrByUserName(UserName);
		chDefaultFieldList = objUserField.getDefaultFieldChNameByUserName(UserName);
//		System.out.println("initializeDefaultFieldList  chDefaultFieldList:"+chDefaultFieldList);
//		System.out.println("initializeDefaultFieldList  intDefaultFieldList:"+intDefaultFieldList);
		request.getSession().setAttribute("chDefaultFieldList",chDefaultFieldList);
		request.getSession().setAttribute("intDefaultFieldList",intDefaultFieldList);
	}

	//返回当前的报错信息from “Error”
	public String getError(){
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
		return (String)request.getAttribute("Error");
	}
	
	//设置Session
	public void setSession(String name,Object value) {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
		request.getSession().setAttribute(name, value);
	}
	
	//删除session
	public void deleteSession(String name) {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
		request.getSession().removeAttribute(name);
	}
	
	public Object getSession(String name) {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
		return request.getSession().getAttribute(name);
	}
	
	public void clearSession(){
		UserLogin objUserLogin = this.getCurrentUser();
		Map session = ActionContext.getContext().getSession();
		session.clear();
		this.setSession("User", objUserLogin);
	}
/*	public static void main(String args[]){
		Methods temp = new Methods();
//		HttpServletRequest session = (HttpServletRequest) ActionContext.getContext().getSession();
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST); 
		temp.setSession("name", "this is name");
		System.out.println("name: " + request.getSession().getAttribute("name"));
		temp.deleteSession("name");
		System.out.println("name: " + request.getSession().getAttribute("name"));
	}*/
}