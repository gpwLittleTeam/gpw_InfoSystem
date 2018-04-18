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

import gpw.object.Expert;
import gpw.object.Methods;
import gpw.object.UserLogin;

public class To_Statistic3_gpw extends ActionSupport {
	private List<Expert> expertList;
	private String UserName;
	private Methods objMethods;
	private UserLogin objUserLogin;

	// 年龄分析图
	private String resultNumberOfMaster;
	private String resultNumberOfPhD;
	private String resultNumberOfSenior;
	private String resultNumberOfDSenior;
	private String resultNumberOfDirector;
	private String resultNumberOfDDirector;

	@Override
	public String execute() throws Exception {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST); 
		//初始化列表的成员 显示用户所在高评委的专家
		objUserLogin = (UserLogin)request.getSession().getAttribute("User"); 
		objMethods = new Methods();
		expertList = objMethods.initializeExpertListForGPWByJuryNo(objUserLogin.getUser_jury());
//		System.out.println("To_Statistic_gpw.java:" + objUserLogin.getUser_jury());

		Date d = new Date();	//当前日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date birthDay;			//专家出生日期
		
		// 用于暂存硕士博士专家信息
		List<Expert> tempNumberOfMaster = new ArrayList<Expert>();
		List<Expert> tempNumberOfPhD = new ArrayList<Expert>();
		
		for (int i=0; i<expertList.size(); i++) {
			if (expertList.get(i).getExpert_Field7().equals("硕士")) {
				tempNumberOfMaster.add(expertList.get(i));
			} else if (expertList.get(i).getExpert_Field7().equals("博士")) {
				tempNumberOfPhD.add(expertList.get(i));
			}
		}
		
		int[] numberOfMaster = new int[8];
		int[] numberOfPhD = new int[8];
		
		for (Expert expert: tempNumberOfMaster) {
			birthDay = sdf.parse(expert.getExpert_Field5());
			int year = (int) ((d.getTime() / 86400000 - birthDay.getTime() / 86400000) / 365);
			if (25<=year && year<30) {
				numberOfMaster[0]++;
			} else if (30<=year && year<35) {
				numberOfMaster[1]++;
			} else if (35<=year && year<40) {
				numberOfMaster[2]++;
			} else if (40<=year && year<45) {
				numberOfMaster[3]++;
			} else if (45<=year && year<50) {
				numberOfMaster[4]++;
			} else if (50<=year && year<55) {
				numberOfMaster[5]++;
			} else if (55<=year && year<60) {
				numberOfMaster[6]++;
			} else if (60<=year) {
				numberOfMaster[7]++;
			}
		}
		
		for (Expert expert: tempNumberOfPhD) {
			birthDay = sdf.parse(expert.getExpert_Field5());
			int year = (int) ((d.getTime() / 86400000 - birthDay.getTime() / 86400000) / 365);
			if (25<=year && year<30) {
				numberOfPhD[0]++;
			} else if (30<=year && year<35) {
				numberOfPhD[1]++;
			} else if (35<=year && year<40) {
				numberOfPhD[2]++;
			} else if (40<=year && year<45) {
				numberOfPhD[3]++;
			} else if (45<=year && year<50) {
				numberOfPhD[4]++;
			} else if (50<=year && year<55) {
				numberOfPhD[5]++;
			} else if (55<=year && year<60) {
				numberOfPhD[6]++;
			} else if (60<=year) {
				numberOfPhD[7]++;
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
			birthDay = sdf.parse(expert.getExpert_Field5());
			int year = (int) ((d.getTime() / 86400000 - birthDay.getTime() / 86400000) / 365);
			if (25<=year && year<30) {
				numberOfSenior[0]++;
			} else if (30<=year && year<35) {
				numberOfSenior[1]++;
			} else if (35<=year && year<40) {
				numberOfSenior[2]++;
			} else if (40<=year && year<45) {
				numberOfSenior[3]++;
			} else if (45<=year && year<50) {
				numberOfSenior[4]++;
			} else if (50<=year && year<55) {
				numberOfSenior[5]++;
			} else if (55<=year && year<60) {
				numberOfSenior[6]++;
			} else if (60<=year) {
				numberOfSenior[7]++;
			}
		}
		
		for (Expert expert: tempNumberOfDSenior) {
			birthDay = sdf.parse(expert.getExpert_Field5());
			int year = (int) ((d.getTime() / 86400000 - birthDay.getTime() / 86400000) / 365);
			if (25<=year && year<30) {
				numberOfDSenior[0]++;
			} else if (30<=year && year<35) {
				numberOfDSenior[1]++;
			} else if (35<=year && year<40) {
				numberOfDSenior[2]++;
			} else if (40<=year && year<45) {
				numberOfDSenior[3]++;
			} else if (45<=year && year<50) {
				numberOfDSenior[4]++;
			} else if (50<=year && year<55) {
				numberOfDSenior[5]++;
			} else if (55<=year && year<60) {
				numberOfDSenior[6]++;
			} else if (60<=year) {
				numberOfDSenior[7]++;
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
			birthDay = sdf.parse(expert.getExpert_Field5());
			int year = (int) ((d.getTime() / 86400000 - birthDay.getTime() / 86400000) / 365);
			if (25<=year && year<30) {
				numberOfDirector[0]++;
			} else if (30<=year && year<35) {
				numberOfDirector[1]++;
			} else if (35<=year && year<40) {
				numberOfDirector[2]++;
			} else if (40<=year && year<45) {
				numberOfDirector[3]++;
			} else if (45<=year && year<50) {
				numberOfDirector[4]++;
			} else if (50<=year && year<55) {
				numberOfDirector[5]++;
			} else if (55<=year && year<60) {
				numberOfDirector[6]++;
			} else if (60<=year) {
				numberOfDirector[7]++;
			}
		}
		
		for (Expert expert: tempNumberOfDDirector) {
			birthDay = sdf.parse(expert.getExpert_Field5());
			int year = (int) ((d.getTime() / 86400000 - birthDay.getTime() / 86400000) / 365);
			if (25<=year && year<30) {
				numberOfDDirector[0]++;
			} else if (30<=year && year<35) {
				numberOfDDirector[1]++;
			} else if (35<=year && year<40) {
				numberOfDDirector[2]++;
			} else if (40<=year && year<45) {
				numberOfDDirector[3]++;
			} else if (45<=year && year<50) {
				numberOfDDirector[4]++;
			} else if (50<=year && year<55) {
				numberOfDDirector[5]++;
			} else if (55<=year && year<60) {
				numberOfDDirector[6]++;
			} else if (60<=year) {
				numberOfDDirector[7]++;
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
