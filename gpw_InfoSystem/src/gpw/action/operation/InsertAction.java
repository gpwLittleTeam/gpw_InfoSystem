package gpw.action.operation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javassist.compiler.ast.MethodDecl;
import net.sf.json.JSONObject;

import javax.jms.Session;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import gpw.action.jump.To_Gpwgl;
import gpw.algorithm.AuthCode;
import gpw.algorithm.ForCommittee;
import gpw.algorithm.ReviewGroup;
import gpw.getInfo.GetCounciltitle;
import gpw.getInfo.GetDegree;
import gpw.getInfo.GetEducation;
import gpw.getInfo.GetEngage;
import gpw.getInfo.GetGroup;
import gpw.getInfo.GetExpert;
import gpw.getInfo.GetGrouptitle;
import gpw.getInfo.GetJury;
import gpw.getInfo.GetJuryIdcode;
import gpw.getInfo.GetSeries;
import gpw.getInfo.GetSex;
import gpw.getInfo.GetSpecial;
import gpw.getInfo.GetTitle;
import gpw.getInfo.GetTitlegrade;
import gpw.getInfo.GetUserLogin;
import gpw.object.CodeModel;
import gpw.object.Expert;
import gpw.object.Group;
import gpw.object.Jury;
import gpw.object.Methods;
import gpw.object.RuleManagement;
import gpw.object.Sex;
import gpw.object.UserField;
import gpw.object.UserLogin;
import gpw.object.JuryIdcode;
import gpw.operateDatabase.Insert;
import gpw.operateDatabase.Update;

public class InsertAction extends ActionSupport {
	private String feedback; //给用户反馈
	private String message; //同feedback
	private Methods objMethods = new Methods();
	private Insert objInsert = new Insert();
	
	
	// 新建专家
	private Expert expert;
//	private String psdInsert;
	private GetJuryIdcode objGetJuryIdcode;
	private List<String> psdAndTime;

	// 跳转到InfoList.jsp必备对象
	// 初始化对象列表
	private GetExpert objGetObject;
	private List<Expert> expertList;
	// 初始化默认字段
	private String UserName;
	private List<String> chDefaultFieldList;
	private List<String> intDefaultFieldList;
	private UserField objUserField;

	// 文件上传
	// inputName为“file" 是JSP中的name="file"
	private File file;
	// 文件名必须是inputName + "FileName"
	private String fileFileName;
	// 文件类型必须是inputName + "ContentType"
	private String fileContentType;

	// 新建专业组
	private Group objGroup;
	private List<Group> objGroupList; // 显示列表
	private GetGroup objGetGroup;

	// 新建高评委
	private Jury objJury;
	private GetJury objGetJury;
	private List<Jury> listJury;

	// 新建用户
	private UserLogin objUserLogin;
	private List<UserLogin> listUserLogin;
	private GetUserLogin objGetUserLogin;

	// 新建的代码表
	private CodeModel objCodeModel;
	private String table;

	//新建历史任职
		//PYZ
	private List<String> leaderResult;
	private List<String> memberResult;
		//WYH
	private List<Expert> listViceDirector;  //选中的副主任委员
	private List<Expert> listCommittee;
	private List<Expert> listDirector;
	private String year;
	
	//验证码管理-新增专家
	//private JuryIdcode expertFromAuthCode;
	//private List<JuryIdcode> expertFromAuthCode;
	private String[] expert_name;
	private String[] expert_phone;
	
	//rule management
	private String ruleNo;
	private String conditionSelect;
	private String conditionSign; 
	private String conditionValue;
	private String percentageSign;
	private String percentageValue;
	private String range;
	private String force;
	private String enabled;
	
	
	public String execute() throws Exception {
		return SUCCESS;
	}
	
	// 新建专家
	public String infoEntry() throws Exception {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
		// 传入数据库
		objInsert = new Insert();
		// System.out.println("System.out.println(expert.getExpert_Field31());"+expert.getExpert_Field31());
		Jury objJury;
		objJury = new Jury();
		System.out.println("first————" + expert.getExpert_Field31());
		if (expert.getExpert_Field31() != null || !expert.getExpert_Field31().equals("")) { // 对所属高评委值转换
			expert.setExpert_Field31(objJury.getJuryNoByJuryName(expert.getExpert_Field31())); // 现所属
			System.out.println("System.out.println(expert.getExpert_Field31());" + expert.getExpert_Field31());
		}
		if (expert.getExpert_Field31() != null || !expert.getExpert_Field31().equals("")) { // 对所属高评委值转换
			expert.setExpert_Field22(objJury.getJuryNoByJuryName(expert.getExpert_Field22())); // 曾属
			System.out.println("System.out.println(expert.setExpert_Field22());" + expert.getExpert_Field22());
		}
		// 显示专家
		objInsert.insertNewExpert(expert);
		// System.out.println(file);
		// 上传头像
		if (file != null) {
			String path = request.getRealPath("/headPortrait");
			System.out.println("path" + path);
			InputStream is = new FileInputStream(file);
			// fileFileName = "expert_"+expert.getExpert_Field1();
			// System.out.println("fileFileName: "+fileFileName);
			// String contentType =
			// fileFileName.substring(fileFileName.lastIndexOf(".")); //获取文件的后缀
			String contentType = ".bmp";
			// fileContentType = "image/jpeg";
			OutputStream os = new FileOutputStream(new File(path, "expert_" + expert.getExpert_Field1() + contentType));
			byte[] buffer = new byte[200];
			int len = 0;
			while ((len = is.read(buffer)) != -1) {
				os.write(buffer, 0, len);
			}
			os.close();
			is.close();
		} else {
			System.out.println("没有照片");
		}
		// 跳转到infoList.jsp
		// 初始化列表的成员 选择全部的成员
		objUserLogin = (UserLogin) request.getSession().getAttribute("User");
		objMethods = new Methods();
		expertList = objMethods.initializeExpertListForGPWByJuryNo(objUserLogin.getUser_jury());
		// System.out.println("To_Zjgl_infoList_gpw:"+expertList.get(3).getExpert_Field4());

		// 初始化user的默认字段
		objUserField = new UserField();
		UserName = objUserLogin.getUser_name();
		intDefaultFieldList = objUserField.getDefaultFieldNrByUserName(UserName);
		chDefaultFieldList = objUserField.getDefaultFieldChNameByUserName(UserName);
		request.getSession().setAttribute("chDefaultFieldList", chDefaultFieldList);
		request.getSession().setAttribute("intDefaultFieldList", intDefaultFieldList);

		message = "录入成功";
		return SUCCESS;
	}
	
	/**
	 * 该函数在专家通过验证码录入自己个人信息后提交时调用
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String infoEntryZJ() throws Exception {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);

			// 传入数据库
			objInsert = new Insert();
			Jury objJury;
			objJury = new Jury();
//			System.out.println("first————" + expert.getExpert_Field31());
			if (expert.getExpert_Field31() != null || !expert.getExpert_Field31().equals("")) { // 对所属高评委值转换
				expert.setExpert_Field31(objJury.getJuryNoByJuryName(expert.getExpert_Field31())); // 现所属
				System.out.println("System.out.println(expert.getExpert_Field31());" + expert.getExpert_Field31());
			}
			if (expert.getExpert_Field31() != null || !expert.getExpert_Field31().equals("")) { // 对所属高评委值转换
				expert.setExpert_Field22(objJury.getJuryNoByJuryName(expert.getExpert_Field22())); // 曾属
				System.out.println("System.out.println(expert.setExpert_Field22());" + expert.getExpert_Field22());
			}
			
			
			// 专家信息写入数据库
			if(objInsert.insertNewExpert(expert))
			{
				Update objUpdate = new Update();
				Methods objMethods = new Methods();
				String expertName_enter = (String)objMethods.getSession("expertName_enter");
				String expertPhone_enter = (String)objMethods.getSession("expertPhone_enter");
				objUpdate.updateJuryIdcodeStatebyNamePhone(expertName_enter, expertPhone_enter, "已录入");
				message = "录入成功";
			} else {
				message = "录入失败";
			}
			
			// System.out.println(file);
			// 上传头像
			if (file != null) {
				String path = request.getRealPath("/headPortrait");
				System.out.println("path" + path);
				InputStream is = new FileInputStream(file);
				// fileFileName = "expert_"+expert.getExpert_Field1();
				// System.out.println("fileFileName: "+fileFileName);
				// String contentType =
				// fileFileName.substring(fileFileName.lastIndexOf(".")); //获取文件的后缀
				String contentType = ".bmp";
				// fileContentType = "image/jpeg";
				OutputStream os = new FileOutputStream(new File(path, "expert_" + expert.getExpert_Field1() + contentType));
				byte[] buffer = new byte[200];
				int len = 0;
				while ((len = is.read(buffer)) != -1) {
					os.write(buffer, 0, len);
				}
				os.close();
				is.close();
			} else {
				System.out.println("没有照片");
			}
		
		
		return SUCCESS;
	}

	// 新建专业组
	public String createGroup() {
		String juryNo = objMethods.getCurrentUser().getUser_jury();
		objGroup.setGroup_jury(juryNo);
		//
		objInsert = new Insert();
		objInsert.insertNewGroup(objGroup);
		//System.out.println("objGroup: " + objGroup.getGroup_name());
		// to_zyzgl.jsp
		objGetGroup = new GetGroup();
		objGroupList = objGetGroup.getGroupByJury(juryNo);
		return SUCCESS;
	}

	// 新建高评委
	public String createJury() throws Exception {
		objInsert = new Insert();
		
		if(objInsert.insertNewJury(objJury)){
			feedback="新建高评委成功！";
		}else {
			feedback="新建高评委失败！";
		}

		
		
		objGetJury = new GetJury();
		listJury = objGetJury.getAllJurys();

		// 评审权限  //因为数据库中没有评审权限对应的表 所以这里手动设置编号对应的名称
		for (int i = 0; i < listJury.size(); i++) {
			switch (listJury.get(i).getJury_power()) {
			case "1":
				listJury.get(i).setJury_power("正高职称");
				break;
			case "2":
				listJury.get(i).setJury_power("副高职称");
				break;
			case "3":
				listJury.get(i).setJury_power("正副合一");
				break;
			case "0":
				listJury.get(i).setJury_power("");
				break;
			}
		}
		return SUCCESS;
	}

	// 新建用户
	public String createUser() {
		//所属高评委名称-》编号
		objJury = new Jury();
		//System.out.println("objUserLogin.getUser_jury():"+objUserLogin.getUser_jury());
		objUserLogin.setUser_jury(objJury.getJuryNoByJuryName(objUserLogin.getUser_jury()));
		
		if(objInsert.insertNewUserLogin(objUserLogin)){
			feedback = "新建用户成功！";
		} else {
			feedback = "新建用户失败！";
		}

		return SUCCESS;
	}

	//新建代码
	public String createCodeForcommon() {
		boolean success = false;
		switch (table) {
		case "sex":
			success = objInsert.insertSex(objCodeModel);
			break;
		case "Counciltitle":
			success = objInsert.insertCounciltitle(objCodeModel);
			break;
		case "Degree":
			success = objInsert.insertDegree(objCodeModel);
			break;
		case "Education":
			success = objInsert.insertEducation(objCodeModel);
			break;
		case "engage":
			success = objInsert.insertEngage(objCodeModel);
			break;
		case "grouptitle":
			success = objInsert.insertGrouptitle(objCodeModel);
			break;
		case "series":
			success = objInsert.insertSeries(objCodeModel);
			break;
		case "special":
			success = objInsert.insertSpecial(objCodeModel);
			break;
		case "title":
			success = objInsert.insertTitle(objCodeModel);
			break;
		case "titlegrade":
			success = objInsert.insertTitlegrade(objCodeModel);
			break;
		default:
			System.err.println("Error! InsertAction.java createCodeForcommon()");
			break;
		}
		if(success)
			feedback = "新建代码成功！";
		else
			feedback = "新建代码失败!";
		return SUCCESS;
	}
	public String createCodeForGroup() {
		return SUCCESS;
	}

	//评议组抽取结果录入数据库
	public String addHistoryTitleForPYZ(){
		List<Expert> leaderExpert = (List<Expert>) objMethods.getSession("leaderExpert");
		List<Expert> memberExpert = (List<Expert>) objMethods.getSession("memberExpert");

		//当前年份
		SimpleDateFormat format = new SimpleDateFormat("yyyy");
        Date date = new Date();
        String formatDate = format.format(date);
		
//        System.out.println("leaderResult: " + leaderResult.get(0));
//        System.out.println("memberResult: " + memberResult.get(0));
//        System.out.println("addHistoryTitleForPYZ -> leaderExpert: " + leaderExpert.size());
        
        new ReviewGroup().insertResult(leaderExpert, memberExpert, formatDate);
		
		//删除session对象
/*		objMethods.deleteSession("leaderExpert");
		objMethods.deleteSession("memberExpert");*/
		
		return "pyz";
	}

	//验证码管理-新增专家
	public String addJuryIdcode(){
		String juryNo = objMethods.getCurrentUser().getUser_jury();
		int size = expert_name.length;
		List<JuryIdcode> listExpertFromAuthCode = new ArrayList<JuryIdcode>();
		AuthCode objAuthCode = new AuthCode();
		for(int i=0;i<size;i++){
			JuryIdcode expertFromAuthCode = new JuryIdcode();
			expertFromAuthCode.setExpert_name(expert_name[i]);
			expertFromAuthCode.setExpert_phone(expert_phone[i]);
			expertFromAuthCode.setJuryNo(juryNo);
			expertFromAuthCode.setState("未录入");
			expertFromAuthCode.setId_code(objAuthCode.getRandAuthCode());
			expertFromAuthCode.setCode_invalid_time(objAuthCode.getValidDate().toString());
			//System.out.println("objAuthCode.getValidDate().toString(): "+objAuthCode.getValidDate().toString());
			listExpertFromAuthCode.add(expertFromAuthCode);
		}
		//System.out.println("expertFromAuthCode<2> : " + expertFromAuthCode.get(1));
		objInsert.insertJuryIdcodes(listExpertFromAuthCode);
		return SUCCESS;
	}
	
	/**
	 * 规则添加
	 * @return
	 */
	public String addRule() {
		
		RuleManagement objManagement = new RuleManagement(ruleNo,conditionSelect,conditionSign,conditionValue,percentageValue,percentageSign,range,force,enabled);
		objInsert.insertRuleManagement(objManagement);
		return SUCCESS;
	}
	
	
	//getter&setter
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getPsdAndTime() {
		return psdAndTime;
	}

	public void setPsdAndTime(List<String> psdAndTime) {
		this.psdAndTime = psdAndTime;
	}
//	public String getPsdInsert() {
//		return psdInsert;
//	}
//
//	public void setPsdInsert(String psdInsert) {
//		this.psdInsert = psdInsert;
//	}
	
	public GetJuryIdcode getObjGetJuryIdcode() {
		return objGetJuryIdcode;
	}

	public void setObjGetJuryIdcode(GetJuryIdcode objGetJuryIdcode) {
		this.objGetJuryIdcode = objGetJuryIdcode;
	}
	public Expert getExpert() {
		return expert;
	}

	public void setExpert(Expert expert) {
		this.expert = expert;
	}

	public Insert getObjInsert() {
		return objInsert;
	}

	public void setObjInsert(Insert objInsert) {
		this.objInsert = objInsert;
	}

	public GetExpert getObjGetObject() {
		return objGetObject;
	}

	public void setObjGetObject(GetExpert objGetObject) {
		this.objGetObject = objGetObject;
	}

	public List<String> getChDefaultFieldList() {
		return chDefaultFieldList;
	}

	public void setChDefaultFieldList(List<String> chDefaultFieldList) {
		this.chDefaultFieldList = chDefaultFieldList;
	}

	public List<String> getIntDefaultFieldList() {
		return intDefaultFieldList;
	}

	public void setIntDefaultFieldList(List<String> intDefaultFieldList) {
		this.intDefaultFieldList = intDefaultFieldList;
	}

	public List<Expert> getExpertList() {
		return expertList;
	}

	public void setExpertList(List<Expert> expertList) {
		this.expertList = expertList;
	}

	public UserField getObjUserField() {
		return objUserField;
	}

	public void setObjUserField(UserField objUserField) {
		this.objUserField = objUserField;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public Group getObjGroup() {
		return objGroup;
	}

	public void setObjGroup(Group objGroup) {
		this.objGroup = objGroup;
	}

	public List<Group> getObjGroupList() {
		return objGroupList;
	}

	public void setObjGroupList(List<Group> objGroupList) {
		this.objGroupList = objGroupList;
	}

	public GetGroup getObjGetGroup() {
		return objGetGroup;
	}

	public void setObjGetGroup(GetGroup objGetGroup) {
		this.objGetGroup = objGetGroup;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public Jury getObjJury() {
		return objJury;
	}

	public void setObjJury(Jury objJury) {
		this.objJury = objJury;
	}

	public GetJury getObjGetJury() {
		return objGetJury;
	}

	public void setObjGetJury(GetJury objGetJury) {
		this.objGetJury = objGetJury;
	}

	public List<Jury> getListJury() {
		return listJury;
	}

	public void setListJury(List<Jury> listJury) {
		this.listJury = listJury;
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

	public List<UserLogin> getListUserLogin() {
		return listUserLogin;
	}

	public void setListUserLogin(List<UserLogin> listUserLogin) {
		this.listUserLogin = listUserLogin;
	}

	public GetUserLogin getObjGetUserLogin() {
		return objGetUserLogin;
	}

	public void setObjGetUserLogin(GetUserLogin objGetUserLogin) {
		this.objGetUserLogin = objGetUserLogin;
	}

	public CodeModel getObjCodeModel() {
		return objCodeModel;
	}

	public void setObjCodeModel(CodeModel objCodeModel) {
		this.objCodeModel = objCodeModel;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public List<String> getLeaderResult() {
		return leaderResult;
	}

	public void setLeaderResult(List<String> leaderResult) {
		this.leaderResult = leaderResult;
	}

	public List<String> getMemberResult() {
		return memberResult;
	}

	public void setMemberResult(List<String> memberResult) {
		this.memberResult = memberResult;
	}

	public List<Expert> getListViceDirector() {
		return listViceDirector;
	}

	public void setListViceDirector(List<Expert> listViceDirector) {
		this.listViceDirector = listViceDirector;
	}

	public List<Expert> getListCommittee() {
		return listCommittee;
	}

	public void setListCommittee(List<Expert> listCommittee) {
		this.listCommittee = listCommittee;
	}

	public List<Expert> getListDirector() {
		return listDirector;
	}

	public void setListDirector(List<Expert> listDirector) {
		this.listDirector = listDirector;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String[] getExpert_name() {
		return expert_name;
	}

	public void setExpert_name(String[] expert_name) {
		this.expert_name = expert_name;
	}

	public String[] getExpert_phone() {
		return expert_phone;
	}

	public void setExpert_phone(String[] expert_phone) {
		this.expert_phone = expert_phone;
	}

	public String getConditionSelect() {
		return conditionSelect;
	}

	public void setConditionSelect(String conditionSelect) {
		this.conditionSelect = conditionSelect;
	}

	public String getConditionSign() {
		return conditionSign;
	}

	public void setConditionSign(String conditionSign) {
		this.conditionSign = conditionSign;
	}

	public String getConditionValue() {
		return conditionValue;
	}

	public void setConditionValue(String conditionValue) {
		this.conditionValue = conditionValue;
	}

	public String getPercentageSign() {
		return percentageSign;
	}

	public void setPercentageSign(String percentageSign) {
		this.percentageSign = percentageSign;
	}

	public String getPercentageValue() {
		return percentageValue;
	}

	public void setPercentageValue(String percentageValue) {
		this.percentageValue = percentageValue;
	}

	public String getRange() {
		return range;
	}

	public void setRange(String range) {
		this.range = range;
	}

	public String getForce() {
		return force;
	}

	public void setForce(String force) {
		this.force = force;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getRuleNo() {
		return ruleNo;
	}

	public void setRuleNo(String ruleNo) {
		this.ruleNo = ruleNo;
	}

}
