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

public class To_Statistic3_gly extends ActionSupport {
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

	// 拟任职称分析图
	private String resultNumberOfMaster;
	private String resultNumberOfPhD;
	private String resultNumberOfSenior;
	private String resultNumberOfDSenior;
	private String resultNumberOfProfessor;
	private String resultNumberOfDProfessor;
	

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
		
		int[] numberOfMaster = new int[5];
		int[] numberOfPhD = new int[5];
		
		for (Expert expert: tempNumberOfMaster) {
			if(!expert.getExpert_Field32().equals("")) {
				switch(expert.getExpert_Field32()) {
				case "主任委员": numberOfMaster[0]++; break;
				case "副主任委员": numberOfMaster[1]++; break;
				case "委员": numberOfMaster[2]++; break;
				}
			}
			if(!expert.getExpert_Field34().equals("")) {
				switch(expert.getExpert_Field34()) {
				case "组长": numberOfMaster[3]++; break;
				case "组员": numberOfMaster[4]++; break;
				}
			}
		}
		
		for (Expert expert: tempNumberOfPhD) {
			if(!expert.getExpert_Field32().equals("")) {
				switch(expert.getExpert_Field32()) {
				case "主任委员": numberOfPhD[0]++; break;
				case "副主任委员": numberOfPhD[1]++; break;
				case "委员": numberOfPhD[2]++; break;
				}
			}
			if(!expert.getExpert_Field34().equals("")) {
				switch(expert.getExpert_Field34()) {
				case "组长": numberOfPhD[3]++; break;
				case "组员": numberOfPhD[4]++; break;
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
		
		int[] numberOfSenior = new int[5];
		int[] numberOfDSenior = new int[5];
		
		for (Expert expert: tempNumberOfSenior) {
			if(!expert.getExpert_Field32().equals("")) {
				switch(expert.getExpert_Field32()) {
				case "主任委员": numberOfSenior[0]++; break;
				case "副主任委员": numberOfSenior[1]++; break;
				case "委员": numberOfSenior[2]++; break;
				}
			}
			if(!expert.getExpert_Field34().equals("")) {
				switch(expert.getExpert_Field34()) {
				case "组长": numberOfSenior[3]++; break;
				case "组员": numberOfSenior[4]++; break;
				}
			}
		}
		
		for (Expert expert: tempNumberOfDSenior) {
			if(!expert.getExpert_Field32().equals("")) {
				switch(expert.getExpert_Field32()) {
				case "主任委员": numberOfDSenior[0]++; break;
				case "副主任委员": numberOfDSenior[1]++; break;
				case "委员": numberOfDSenior[2]++; break;
				}
			}
			if(!expert.getExpert_Field34().equals("")) {
				switch(expert.getExpert_Field34()) {
				case "组长": numberOfDSenior[3]++; break;
				case "组员": numberOfDSenior[4]++; break;
				}
			}
		}
		
		// 用于暂存高校教授副教授等专家信息
		List<Expert> tempNumberOfProfessor = new ArrayList<Expert>();
		List<Expert> tempNumberOfDProfessor = new ArrayList<Expert>();
		
		for (int i=0; i<expertList.size(); i++) {
			if (expertList.get(i).getExpert_Field17().equals("高校教授")) {
				tempNumberOfProfessor.add(expertList.get(i));
			} else if (expertList.get(i).getExpert_Field17().equals("高校计划副教授")) {
				tempNumberOfDProfessor.add(expertList.get(i));
			}
		}
		
		int[] numberOfProfessor = new int[5];
		int[] numberOfDProfessor = new int[5];
		
		for (Expert expert: tempNumberOfProfessor) {
			if(!expert.getExpert_Field32().equals("")) {
				switch(expert.getExpert_Field32()) {
				case "主任委员": numberOfProfessor[0]++; break;
				case "副主任委员": numberOfProfessor[1]++; break;
				case "委员": numberOfProfessor[2]++; break;
				}
			}
			if(!expert.getExpert_Field34().equals("")) {
				switch(expert.getExpert_Field34()) {
				case "组长": numberOfProfessor[3]++; break;
				case "组员": numberOfProfessor[4]++; break;
				}
			}
		}
		
		for (Expert expert: tempNumberOfDProfessor) {
			if(!expert.getExpert_Field32().equals("")) {
				switch(expert.getExpert_Field32()) {
				case "主任委员": numberOfDProfessor[0]++; break;
				case "副主任委员": numberOfDProfessor[1]++; break;
				case "委员": numberOfDProfessor[2]++; break;
				}
			}
			if(!expert.getExpert_Field34().equals("")) {
				switch(expert.getExpert_Field34()) {
				case "组长": numberOfDProfessor[3]++; break;
				case "组员": numberOfDProfessor[4]++; break;
				}
			}
		}
		
//		System.out.println(Arrays.toString(numberOfMaster));
//		System.out.println(Arrays.toString(numberOfPhD));
		resultNumberOfMaster = Arrays.toString(numberOfMaster);
		resultNumberOfPhD = Arrays.toString(numberOfPhD);
		resultNumberOfSenior = Arrays.toString(numberOfSenior);
		resultNumberOfDSenior = Arrays.toString(numberOfDSenior);
		resultNumberOfProfessor = Arrays.toString(numberOfProfessor);
		resultNumberOfDProfessor = Arrays.toString(numberOfDProfessor);
		request.getSession().setAttribute("resultNumberOfMaster", resultNumberOfMaster);
		request.getSession().setAttribute("resultNumberOfPhD", resultNumberOfPhD);
		request.getSession().setAttribute("resultNumberOfSenior", resultNumberOfSenior);
		request.getSession().setAttribute("resultNumberOfDSenior", resultNumberOfDSenior);
		request.getSession().setAttribute("resultNumberOfDirector", resultNumberOfProfessor);
		request.getSession().setAttribute("resultNumberOfDDirector", resultNumberOfDProfessor);
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

	public String getResultNumberOfProfessor() {
		return resultNumberOfProfessor;
	}

	public void setResultNumberOfProfessor(String resultNumberOfProfessor) {
		this.resultNumberOfProfessor = resultNumberOfProfessor;
	}

	public String getResultNumberOfDProfessor() {
		return resultNumberOfDProfessor;
	}

	public void setResultNumberOfDProfessor(String resultNumberOfDProfessor) {
		this.resultNumberOfDProfessor = resultNumberOfDProfessor;
	}
}
