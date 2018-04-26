package gpw.action.jump;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import gpw.getInfo.GetExpert;
import gpw.object.Expert;
import gpw.object.Methods;
import gpw.object.UserLogin;

public class To_Statistic4_gly extends ActionSupport {
	private List<Expert> expertList;
	private String UserName;
	private Methods objMethods;
	private UserLogin objUserLogin;
	private GetExpert objGetObject;

	public GetExpert getObjGetObject() {
		return objGetObject;
	}

	public void setObjGetObject(GetExpert objGetObject) {
		this.objGetObject = objGetObject;
	}

	// 现有任职资格分析图
	private String resultNumberOfMaster;
	private String resultNumberOfPhD;
	private String resultNumberOfSenior;
	private String resultNumberOfDSenior;
	private String resultNumberOfDirector;
	private String resultNumberOfDDirector;

	@Override
	public String execute() throws Exception {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST); 
		//初始化列表的成员 选择全部的成员
		objGetObject = new GetExpert();
		objMethods = new Methods();
		expertList = objMethods.initializeExpertListForGLY();
		
		// 用于暂存硕士博士专家信息
		List<Expert> tempNumberOfMaster = new ArrayList<Expert>();
		List<Expert> tempNumberOfPhD = new ArrayList<Expert>();
		
		for (int i=0; i<expertList.size(); i++) {
			if (expertList.get(i).getExpert_Field7().equals("硕士")) {
				tempNumberOfMaster.add(expertList.get(i));
			} else if (expertList.get(i).getExpert_Field7().equals("博士") || 
					expertList.get(i).getExpert_Field7().equals("副博士") || 
					expertList.get(i).getExpert_Field7().equals("名誉博士")) {
				tempNumberOfPhD.add(expertList.get(i));
			}
		}
		
		int[] numberOfMaster = new int[8];
		int[] numberOfPhD = new int[8];
		
		for (Expert expert: tempNumberOfMaster) {
			if(!expert.getExpert_Field17().equals("")) {
				switch(expert.getExpert_Field17()) {
				case "高校教授": numberOfMaster[0]++; break;
				case "高校助教": numberOfMaster[1]++; break;
				case "高校计划副教授": numberOfMaster[2]++; break;
				case "中专高级讲师": numberOfMaster[3]++; break;
				case "技工学校教师": numberOfMaster[4]++; break;
				case "技校高级讲师": numberOfMaster[5]++; break;
				case "中学教师": numberOfMaster[6]++; break;
				case "中学二级教师": numberOfMaster[7]++; break;
				}
			}
		}
		
		for (Expert expert: tempNumberOfPhD) {
			if(!expert.getExpert_Field17().equals("")) {
				switch(expert.getExpert_Field17()) {
				case "高校教授": numberOfPhD[0]++; break;
				case "高校助教": numberOfPhD[1]++; break;
				case "高校计划副教授": numberOfPhD[2]++; break;
				case "中专高级讲师": numberOfPhD[3]++; break;
				case "技工学校教师": numberOfPhD[4]++; break;
				case "技校高级讲师": numberOfPhD[5]++; break;
				case "中学教师": numberOfPhD[6]++; break;
				case "中学二级教师": numberOfPhD[7]++; break;
				}
			}
		}
		
		// 用于暂存正高级副高级专家信息
		List<Expert> tempNumberOfSenior = new ArrayList<Expert>();
		List<Expert> tempNumberOfDSenior = new ArrayList<Expert>();
		
		for (int i=0; i<expertList.size(); i++) {
			if (expertList.get(i).getExpert_Field18().equals("正高级")) {
				tempNumberOfSenior.add(expertList.get(i));
			} else if (expertList.get(i).getExpert_Field18().equals("副高级")) {
				tempNumberOfDSenior.add(expertList.get(i));
			}
		}
		
		int[] numberOfSenior = new int[8];
		int[] numberOfDSenior = new int[8];
		
		for (Expert expert: tempNumberOfSenior) {
			if(!expert.getExpert_Field17().equals("")) {
				switch(expert.getExpert_Field17()) {
				case "高校教授": numberOfSenior[0]++; break;
				case "高校助教": numberOfSenior[1]++; break;
				case "高校计划副教授": numberOfSenior[2]++; break;
				case "中专高级讲师": numberOfSenior[3]++; break;
				case "技工学校教师": numberOfSenior[4]++; break;
				case "技校高级讲师": numberOfSenior[5]++; break;
				case "中学教师": numberOfSenior[6]++; break;
				case "中学二级教师": numberOfSenior[7]++; break;
				}
			}
		}
		
		for (Expert expert: tempNumberOfDSenior) {
			if(!expert.getExpert_Field17().equals("")) {
				switch(expert.getExpert_Field17()) {
				case "高校教授": numberOfDSenior[0]++; break;
				case "高校助教": numberOfDSenior[1]++; break;
				case "高校计划副教授": numberOfDSenior[2]++; break;
				case "中专高级讲师": numberOfDSenior[3]++; break;
				case "技工学校教师": numberOfDSenior[4]++; break;
				case "技校高级讲师": numberOfDSenior[5]++; break;
				case "中学教师": numberOfDSenior[6]++; break;
				case "中学二级教师": numberOfDSenior[7]++; break;
				}
			}
		}

		// 用于暂存曾属主任委员副主任委员专家信息
		List<Expert> tempNumberOfDirector = new ArrayList<Expert>();
		List<Expert> tempNumberOfDDirector = new ArrayList<Expert>();
		
		for (int i=0; i<expertList.size(); i++) {
			if (expertList.get(i).getExpert_Field23().equals("主任委员")) {
				tempNumberOfDirector.add(expertList.get(i));
			} else if (expertList.get(i).getExpert_Field23().equals("副主任委员")) {
				tempNumberOfDDirector.add(expertList.get(i));
			}
		}
		
		int[] numberOfDirector = new int[8];
		int[] numberOfDDirector = new int[8];
		
		for (Expert expert: tempNumberOfDirector) {
			if(!expert.getExpert_Field17().equals("")) {
				switch(expert.getExpert_Field17()) {
				case "高校教授": numberOfDirector[0]++; break;
				case "高校助教": numberOfDirector[1]++; break;
				case "高校计划副教授": numberOfDirector[2]++; break;
				case "中专高级讲师": numberOfDirector[3]++; break;
				case "技工学校教师": numberOfDirector[4]++; break;
				case "技校高级讲师": numberOfDirector[5]++; break;
				case "中学教师": numberOfDirector[6]++; break;
				case "中学二级教师": numberOfDirector[7]++; break;
				}
			}
		}
		
		for (Expert expert: tempNumberOfDDirector) {
			if(!expert.getExpert_Field17().equals("")) {
				switch(expert.getExpert_Field17()) {
				case "高校教授": numberOfDDirector[0]++; break;
				case "高校助教": numberOfDDirector[1]++; break;
				case "高校计划副教授": numberOfDDirector[2]++; break;
				case "中专高级讲师": numberOfDDirector[3]++; break;
				case "技工学校教师": numberOfDDirector[4]++; break;
				case "技校高级讲师": numberOfDDirector[5]++; break;
				case "中学教师": numberOfDDirector[6]++; break;
				case "中学二级教师": numberOfDDirector[7]++; break;
				}
			}
		}
				
//		System.out.println(Arrays.toString(numberOfMaster));
//		System.out.println(Arrays.toString(numberOfPhD));
		resultNumberOfMaster = Arrays.toString(numberOfMaster);
		resultNumberOfPhD = Arrays.toString(numberOfPhD);
		resultNumberOfSenior = Arrays.toString(numberOfSenior);
		resultNumberOfDSenior = Arrays.toString(numberOfDSenior);
		resultNumberOfDirector = Arrays.toString(numberOfDirector);
		resultNumberOfDDirector = Arrays.toString(numberOfDDirector);
		request.getSession().setAttribute("resultNumberOfMaster", resultNumberOfMaster);
		request.getSession().setAttribute("resultNumberOfPhD", resultNumberOfPhD);
		request.getSession().setAttribute("resultNumberOfSenior", resultNumberOfSenior);
		request.getSession().setAttribute("resultNumberOfDSenior", resultNumberOfDSenior);
		request.getSession().setAttribute("resultNumberOfDirector", resultNumberOfDirector);
		request.getSession().setAttribute("resultNumberOfDDirector", resultNumberOfDDirector);
		return SUCCESS;
	}

//	public static void main(String args[]) throws ParseException {
//		Date d = new Date();
//		System.out.println(d);
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		String test = "1996-08-11";
//		Date birthDay = sdf.parse(test);
//		System.out.println(birthDay);
//		System.out.println((d.getTime() / 86400000 - birthDay.getTime() / 86400000) / 365);
//	}
	
	public List<Expert> getExpertList() {
		return expertList;
	}

	public void setExpertList(List<Expert> expertList) {
		this.expertList = expertList;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
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

	public String getResultNumberOfMaster() {
		return resultNumberOfMaster;
	}

	public void setResultNumberOfMaster(String resultNumberOfMaster) {
		this.resultNumberOfMaster = resultNumberOfMaster;
	}

	public String getResultNumberOfPhD() {
		return resultNumberOfPhD;
	}

	public void setResultNumberOfPhD(String resultNumberOfPhD) {
		this.resultNumberOfPhD = resultNumberOfPhD;
	}

	public String getResultNumberOfSenior() {
		return resultNumberOfSenior;
	}

	public void setResultNumberOfSenior(String resultNumberOfSenior) {
		this.resultNumberOfSenior = resultNumberOfSenior;
	}

	public String getResultNumberOfDSenior() {
		return resultNumberOfDSenior;
	}

	public void setResultNumberOfDSenior(String resultNumberOfDSenior) {
		this.resultNumberOfDSenior = resultNumberOfDSenior;
	}

	public String getResultNumberOfDirector() {
		return resultNumberOfDirector;
	}

	public void setResultNumberOfDirector(String resultNumberOfDirector) {
		this.resultNumberOfDirector = resultNumberOfDirector;
	}

	public String getResultNumberOfDDirector() {
		return resultNumberOfDDirector;
	}

	public void setResultNumberOfDDirector(String resultNumberOfDDirector) {
		this.resultNumberOfDDirector = resultNumberOfDDirector;
	}
}
