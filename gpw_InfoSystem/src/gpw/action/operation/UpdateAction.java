package gpw.action.operation;

import gpw.action.jump.To_infoBrowsing;
import gpw.algorithm.AuthCode;
import gpw.getInfo.GetCounciltitle;
import gpw.getInfo.GetDegree;
import gpw.getInfo.GetEducation;
import gpw.getInfo.GetEngage;
import gpw.getInfo.GetGroup;
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
import gpw.object.JuryIdcode;
import gpw.object.Methods;
import gpw.object.Sex;
import gpw.object.Tablestru;
import gpw.object.UserField;
import gpw.object.UserLogin;
import gpw.operateDatabase.Delete;
import gpw.operateDatabase.Insert;
import gpw.operateDatabase.Update;
import net.sf.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateAction extends ActionSupport {
	private Methods objMethods = new Methods();
	private Update objUpdate = new Update();
	private UserLogin currentUser;  //当前登入的用户
	private GetUserLogin objGetUserLogin;
	private String feedback;
	
	//重生效JuryIdcode
//	private List<String> Mcheckbox; //JuryIdcode的那个checkbox
	private JSONObject jsonobject;
	private List<JuryIdcode> juryIdcodes;
	private GetJuryIdcode getJuryIdcode;
	
	// 设置默认字段
	private List<String> chosenField;
	private List<Expert> expertList;
	private List<String> chDefaultFieldList;
	private List<String> intDefaultFieldList;
	private UserField objUserField;
	private UserLogin obj; // 当前的用户
	// update Group
	private Group objGroup;
	private List<Group> objGroupList; // 显示列表
	private GetGroup objGetGroup;

	// 修改密码
	private String oldpsw;
	private String newpsw;
	private String errorMassage;

	// 用户管理
	private List<String> user_enable;
	private List<UserLogin> listUserLogin;
	private List<String> user_name;
	//高评委管理
	private Jury objJury;
	private List<Jury> listJury;
	private GetJury objGetJury;
	
	//For gly 信息浏览
	private List<String>listGpwName;
	private List<String>listGpwNo;
	
	//重置密码
	private String[] nrOfCheckbox;
	
	//更新专家
	private Expert expert;
	private File file;
	private String fileFileName;
	private String fileContentType;
	private UserLogin objUserLogin;
	//to_browsing
	private Tablestru objTabletru;
	private List<String> chFieldName; // 中文字段名
	private List<String> enFieldName; // 英文字段名
	private String[] expert_Field; // 储存Expert_Field
	private String[] expert_Info;
	private Expert objExperts;
	private File photo; 
	private String photoName; // 专家头像名称
	private String contentType; //专家头像的后缀
	//更新代码表
	private CodeModel objCodeModel;
	private String table;
	private List<CodeModel> listCodeModel;
	
	
	public String execute() throws Exception {
		System.out.println("call UpdateAction.java execute()");
		return super.execute();
	}

	public String setDefaultFieldForGPW() {
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(StrutsStatics.HTTP_REQUEST);
//		expertList = (List<Expert>) request.getSession().getAttribute("expertList");
		currentUser = (UserLogin) request.getSession().getAttribute("User");  //from Login.java
		// 设置默认字段
		objUpdate = new Update();
		String name = currentUser.getUser_name();
		objUpdate.setDefaultFieldUpdate(name, chosenField);
		// 从数据库重新获取更新过的默认字段
		objUserField = new UserField();
		intDefaultFieldList = objUserField.getDefaultFieldNrByUserName(name);
		chDefaultFieldList = objUserField.getDefaultFieldChNameByUserName(name);
		request.getSession().setAttribute("chDefaultFieldList",
				chDefaultFieldList);
		request.getSession().setAttribute("intDefaultFieldList",
				intDefaultFieldList);

		return "gpw";
	}
	
	public String setDefaultFieldForGLY() {
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(StrutsStatics.HTTP_REQUEST);
//		expertList = (List<Expert>) request.getSession().getAttribute("expertList");
		currentUser = objMethods.getCurrentUser();
		// 设置默认字段
		//System.out.println("objUserLogin.getUser_name()" + objUserLogin);
		objUpdate = new Update();
		String name = currentUser.getUser_name();
		objUpdate.setDefaultFieldUpdate(name, chosenField);
		// 从数据库重新获取更新过的默认字段
		objUserField = new UserField();
		objMethods.initializeDefaultFieldList(name);
		
		//Jury datalist
		objJury = new Jury();
		listGpwName = new ArrayList<String>();
		listGpwNo = new ArrayList<String>();
		listGpwNo = objJury.getAllJuryNo();
		listGpwName = objJury.getAllJuryName();
		
		return "gly";
	}

	public String updateGroup() throws Exception {
		String juryNo = objMethods.getCurrentUser().getUser_jury();
		objUpdate = new Update();
		// update ---只更改时间和备注
		objUpdate.updateGroup(objGroup);
		// load list
		objGetGroup = new GetGroup();
		objGroupList = objGetGroup.getGroupByJury(juryNo);
		// System.out.println("To_zygl.java  updateGroup() -> objGroup.getGroup_name(): "+objGroup.getGroup_name()
		// + "  objGroup.getGroup_no():" + objGroup.getGroup_no());

		return SUCCESS;
	}

	//修改密码
	public String updatePsw() throws Exception {
		System.out.println("To_Xgmm.java  oldpsw: " + oldpsw);
		System.out.println("To_Xgmm.java  newpsw: " + newpsw);

		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(StrutsStatics.HTTP_REQUEST);
		currentUser = (UserLogin) request.getSession().getAttribute("User");

		objGetUserLogin = new GetUserLogin();
//		System.out.println("密码："+ currentUser.getPsdByName(currentUser.getUser_name()));
		if (oldpsw.equals(currentUser.getPsdByName(currentUser.getUser_name()))) {
			System.out.println("原密码输入正确");
			if (newpsw.equals(currentUser.getPsdByName(currentUser.getUser_name()))) {
				errorMassage = "新密码不能和原密码相同";
				return ERROR;
			} else {
				objUpdate = new Update();
				objUpdate.updatePsdByName(currentUser.getUser_name(), newpsw);
				System.out.println("密码修改成功");
				return SUCCESS;
			}
		} else {
			errorMassage = "原密码输入错误，请重新输入";
			return ERROR;
		}
	}

	//gly用户管理保存禁用/启用
	public String updateEnable() throws Exception {
		System.out.println("UpdateAction.java ->  updateEnable() 需要优化");
		objGetUserLogin = new GetUserLogin();
//		System.out.println("user_name " + user_name);
		objUpdate.updateEnableByUserName(user_name,user_enable);  //直接传入数组，只更新enable
		feedback = "用户状态更新成功";
		return SUCCESS;
	}
	
	//修改高评委
	public String updateJury() throws Exception {
		objUpdate = new Update();
		objUpdate.updateJury(objJury);
		objGetJury = new GetJury();
		listJury = objGetJury.getAllJurys();
		
		// 评审权限
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
	
	//重生效JuryIdcode
	public String updateJuryIdcodeByNamePhone() throws Exception {
		objUpdate = new Update();
		AuthCode objRandAuthCode = new AuthCode();
		for(int i=0; i<nrOfCheckbox.length; i++){
			jsonobject = JSONObject.fromObject(nrOfCheckbox[i]);
			
			objUpdate.updateJuryIdcodeByNamePhone(jsonobject.getString("expert_name"),jsonobject.getString("expert_phone"), 
					objRandAuthCode.getRandAuthCode(), objRandAuthCode.getValidDate());
		}
		
		//getJuryIdcode = new GetJuryIdcode();
		//System.out.println(objUserLogin.getUser_jury());
		//juryIdcodes = getJuryIdcode.getJuryIdcodes(objMethods.getCurrentUser().getUser_jury());
		
		return SUCCESS;
	}

	//重置密码
	public String resetPsw() throws Exception {
		for(int i=0;i<nrOfCheckbox.length;i++) {
			objUpdate.updatePsdByName(nrOfCheckbox[i], nrOfCheckbox[i]);
		}
		objGetUserLogin = new GetUserLogin();
		listUserLogin = objGetUserLogin.getAllUserLogins();
		feedback = "重置成功，重置后密码为该用户的用户名";
		return SUCCESS;
	}
	
	//更新专家
	public String updateExpert() throws Exception {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
		//传入数据库
		Jury objJury;
		objJury = new Jury();
		System.out.println("first————"+expert.getExpert_Field31());
		if(expert.getExpert_Field31() != null || !expert.getExpert_Field31().equals("")) {  //对所属高评委值转换
			expert.setExpert_Field31(objJury.getJuryNoByJuryName(expert.getExpert_Field31()));	//现所属
//			System.out.println("System.out.println(expert.getExpert_Field31());"+expert.getExpert_Field31());
		}
		if(expert.getExpert_Field22() != null || !expert.getExpert_Field22().equals("")) {  //对所属高评委值转换
			expert.setExpert_Field22(objJury.getJuryNoByJuryName(expert.getExpert_Field22()));  //曾属
//			System.out.println("System.out.println(expert.setExpert_Field22());"+expert.getExpert_Field22());
		}
	//显示专家 
		objUpdate.updateExpertInfoByNo(expert);
//		System.out.println(file);
		//上传头像
		if(file != null) {
			String path = request.getRealPath("/headPortrait");
			System.out.println("path"+path);
			InputStream is = new FileInputStream(file);
	//		fileFileName = "expert_"+expert.getExpert_Field1();
	//		System.out.println("fileFileName: "+fileFileName);
	//		String contentType = fileFileName.substring(fileFileName.lastIndexOf(".")); //获取文件的后缀
			String contentType = ".bmp";
	//		fileContentType = "image/jpeg";
			OutputStream os = new FileOutputStream(new File(path,"expert_"+expert.getExpert_Field1()+contentType));
			byte[] buffer = new byte[200];
			int len = 0;
			while((len=is.read(buffer))!=-1) {
				os.write(buffer,0,len);
			}
			os.close();
			is.close();
		} else {
			System.out.println("没有照片");
		}
		//跳转到infoList.jsp
		//初始化列表的成员 选择全部的成员
		objUserLogin = (UserLogin)request.getSession().getAttribute("User");
		expertList = objMethods.initializeExpertListForGPWByJuryNo(objUserLogin.getUser_jury());
//		System.out.println("To_Zjgl_infoList_gpw:"+expertList.get(3).getExpert_Field4());
		
		//初始化user的默认字段
		objUserField = new UserField();
		String UserName = objUserLogin.getUser_name();
		intDefaultFieldList = objUserField.getDefaultFieldNrByUserName(UserName);
		chDefaultFieldList = objUserField.getDefaultFieldChNameByUserName(UserName);
		request.getSession().setAttribute("chDefaultFieldList",chDefaultFieldList);
		request.getSession().setAttribute("intDefaultFieldList",intDefaultFieldList);
		
		//to_browsing
		objTabletru = new Tablestru();
		chFieldName = objTabletru.getChNameByOrder();
		enFieldName = objTabletru.getEnNameByOrder();
		expert_Field = new String[chFieldName.size()];
		// System.out.println(chFieldName.get(0));
		// System.out.println(enFieldName.get(0));

		// 显示字段  因为order所以不能直接传对象
		for (int i = 0; i < chFieldName.size(); i++) {
			expert_Field[i] = "Expert_Field" + (i + 1);
		}

		for (int i = 0; i < chFieldName.size(); i++) {
			// System.out.println("11 :"+expert_Field[i]);
			request.setAttribute(expert_Field[i], chFieldName.get(i));
		}
		/* System.out.println("zjgl_infoBrowsing.jsp"); */
		// 显示该专家的信息
		objExperts = new Expert();
		String expert_no = expert.getExpert_Field1();
		expert_Info = new String[chFieldName.size()];
		System.out.println("To_infoBrowsing.java expert_no:"+expert_no);
		objExperts.setExpert_Field1(expert_no);
		for (int i = 0; i < 35; i++) {
			// System.out.println(i);
			expert_Info[i] = objExperts.getExpertInfoByOrder(1 + i + "");
		}
		
		//显示专家头像
		//System.out.println(System.getProperty("user.dir"));
		contentType = ".bmp";
		String path = request.getRealPath("/headPortrait");
		//photo = new File("./WebRoot/headPortrait/expert_" + expert_num + contentType);  //test: expert_201403
		photo = new File(path+"/expert_" + expert_no + contentType);
		//System.out.println("photo.getName() :" + photo.getAbsolutePath());
		if(photo.exists()) {
			photoName = "./headPortrait/" + photo.getName();
		//	System.out.println("exists -- To_infoBrowsing -- photoName: "+photoName);
		} else {
			photoName = "./headPortrait/wutouxiang.bmp";
		//	System.out.println("not exist  " + photoName);
		}
//		System.out.println("objExpert : "+objExpert.getExpert_Field10());
		
		
		
		
		return SUCCESS;
}

	//更新代码表
	public String updateCode() throws Exception {
		System.out.println(table);
		//System.out.println(objCodeModel.getCodeName());
		if(objUpdate.updateCode(objCodeModel, table)){
			feedback = "更新操作成功";
		} else {
			feedback = "更新操作失败";
		}
		
		GetSex objGetSex;
		GetCounciltitle objGetCounciltitle;
		GetDegree objGetDegree;
		GetEducation objGetEducation;
		GetEngage objGetEngage;
		GetGrouptitle objGetGrouptitle;
		GetSeries objGetSeries;
		GetSpecial objGetSpecial;
		GetTitle objGetTitle;
		GetTitlegrade objGetTitlegrade;
		Sex objSex = new Sex();
		listCodeModel = new ArrayList<CodeModel>();
		
		switch (table) {
		case "sex":
			objGetSex = new GetSex();
			for(int i=0;i<objGetSex.getAllSexs().size();i++) {
				objCodeModel = objGetSex.getAllSexs().get(i);
				listCodeModel.add(objCodeModel);
			}
			break;
		case "Counciltitle":
			objGetCounciltitle = new GetCounciltitle();
			for(int i=0;i<objGetCounciltitle.getAllCounciltitles().size();i++) {
				objCodeModel = objGetCounciltitle.getAllCounciltitles().get(i);
				listCodeModel.add(objCodeModel);
			}
			break;
		case "Degree":
			objGetDegree = new GetDegree();
			for(int i=0;i<objGetDegree.getAllDegrees().size();i++) {
				objCodeModel = objGetDegree.getAllDegrees().get(i);
				listCodeModel.add(objCodeModel);
			}
			break;
		case "Education":
			objGetEducation = new GetEducation();
			for(int i=0;i<objGetEducation.getAllEducations().size();i++) {
				objCodeModel = objGetEducation.getAllEducations().get(i);
				listCodeModel.add(objCodeModel);
			}
			break;
		case "engage":
			objGetEngage = new GetEngage();
			for(int i=0;i<objGetEngage.getAllEngages().size();i++) {
				objCodeModel = objGetEngage.getAllEngages().get(i);
				listCodeModel.add(objCodeModel);
			}
			break;
		case "grouptitle":
			objGetGrouptitle = new GetGrouptitle();
			for(int i=0;i<objGetGrouptitle.getAllGrouptitles().size();i++){
				objCodeModel = objGetGrouptitle.getAllGrouptitles().get(i);
				listCodeModel.add(objCodeModel);
			}
			break;
		case "series":
			objGetSeries = new GetSeries();
			for(int i=0;i<objGetSeries.getAllSeriess().size();i++){
				objCodeModel = objGetSeries.getAllSeriess().get(i);
				listCodeModel.add(objCodeModel);
			}
			break;
		case "special":
			objGetSpecial = new GetSpecial();
			for(int i=0;i<objGetSpecial.getAllSpecials().size();i++){
				objCodeModel = objGetSpecial.getAllSpecials().get(i);
//				System.out.println(objCodeModel.getCodeName());
				listCodeModel.add(objCodeModel);
			}
			break;
		case "title":
			objGetTitle = new GetTitle();
			for(int i=0;i<objGetTitle.getAllTitles().size();i++){
				objCodeModel = objGetTitle.getAllTitles().get(i);
//				System.out.println(objCodeModel.getCodeName());
				listCodeModel.add(objCodeModel);
			}
			break;
		case "titlegrade":
			objGetTitlegrade = new GetTitlegrade();
			for(int i=0;i<objGetTitlegrade.getAllTitlegrades().size();i++){
				objCodeModel = objGetTitlegrade.getAllTitlegrades().get(i);
				listCodeModel.add(objCodeModel);
			}
			break;
		default:
			System.err.println("Error! To_CodePage.java execute");
			break;
		}

		return SUCCESS;
	}
	
	
//	public List<String> getMcheckbox() {
//		return Mcheckbox;
//	}
//
//	public void setMcheckbox(List<String> mcheckbox) {
//		Mcheckbox = mcheckbox;
//	}

	public JSONObject getJsonobject() {
		return jsonobject;
	}

	public void setJsonobject(JSONObject jsonobject) {
		this.jsonobject = jsonobject;
	}

	public List<JuryIdcode> getJuryIdcodes() {
		return juryIdcodes;
	}

	public void setJuryIdcodes(List<JuryIdcode> juryIdcodes) {
		this.juryIdcodes = juryIdcodes;
	}

	public GetJuryIdcode getGetJuryIdcode() {
		return getJuryIdcode;
	}

	public void setGetJuryIdcode(GetJuryIdcode getJuryIdcode) {
		this.getJuryIdcode = getJuryIdcode;
	}

	//the following is get/set method 
	public List<String> getChosenField() {
		return chosenField;
	}

	public void setChosenField(List<String> chosenField) {
		this.chosenField = chosenField;
	}

	public List<Expert> getExpertList() {
		return expertList;
	}

	public void setExpertList(List<Expert> expertList) {
		this.expertList = expertList;
	}

	public Update getObjUpdate() {
		return objUpdate;
	}

	public void setObjUpdate(Update objUpdate) {
		this.objUpdate = objUpdate;
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

	
	//get set
	public UserField getObjUserField() {
		return objUserField;
	}

	public void setObjUserField(UserField objUserField) {
		this.objUserField = objUserField;
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

	public String getOldpsw() {
		return oldpsw;
	}

	public void setOldpsw(String oldpsw) {
		this.oldpsw = oldpsw;
	}

	public String getNewpsw() {
		return newpsw;
	}
	public void setNewpsw(String newpsw) {
		this.newpsw = newpsw;
	}

	public UserLogin getObjUserLogin() {
		return currentUser;
	}


	public UserLogin getCurrentUser() {
		return currentUser;
	}


	public void setCurrentUser(UserLogin currentUser) {
		this.currentUser = currentUser;
	}


	public GetUserLogin getObjGetUserLogin() {
		return objGetUserLogin;
	}


	public void setObjGetUserLogin(GetUserLogin objGetUserLogin) {
		this.objGetUserLogin = objGetUserLogin;
	}


	public UserLogin getObj() {
		return obj;
	}


	public void setObj(UserLogin obj) {
		this.obj = obj;
	}


	public String getErrorMassage() {
		return errorMassage;
	}


	public void setErrorMassage(String errorMassage) {
		this.errorMassage = errorMassage;
	}


	public List<UserLogin> getListUserLogin() {
		return listUserLogin;
	}


	public void setListUserLogin(List<UserLogin> listUserLogin) {
		this.listUserLogin = listUserLogin;
	}

	public Jury getObjJury() {
		return objJury;
	}


	public void setObjJury(Jury objJury) {
		this.objJury = objJury;
	}


	public List<Jury> getListJury() {
		return listJury;
	}


	public void setListJury(List<Jury> listJury) {
		this.listJury = listJury;
	}


	public GetJury getObjGetJury() {
		return objGetJury;
	}


	public void setObjGetJury(GetJury objGetJury) {
		this.objGetJury = objGetJury;
	}


	public Methods getObjMethods() {
		return objMethods;
	}


	public void setObjMethods(Methods objMethods) {
		this.objMethods = objMethods;
	}


	public List<String> getListGpwName() {
		return listGpwName;
	}


	public void setListGpwName(List<String> listGpwName) {
		this.listGpwName = listGpwName;
	}


	public List<String> getListGpwNo() {
		return listGpwNo;
	}


	public void setListGpwNo(List<String> listGpwNo) {
		this.listGpwNo = listGpwNo;
	}


	public List<String> getUser_enable() {
		return user_enable;
	}


	public void setUser_enable(List<String> user_enable) {
		this.user_enable = user_enable;
	}

	public List<String> getUser_name() {
		return user_name;
	}


	public void setUser_name(List<String> user_name) {
		this.user_name = user_name;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public String[] getNrOfCheckbox() {
		return nrOfCheckbox;
	}

	public void setNrOfCheckbox(String[] nrOfCheckbox) {
		this.nrOfCheckbox = nrOfCheckbox;
	}

	public Expert getExpert() {
		return expert;
	}

	public void setExpert(Expert expert) {
		this.expert = expert;
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

	public Tablestru getObjTabletru() {
		return objTabletru;
	}

	public void setObjTabletru(Tablestru objTabletru) {
		this.objTabletru = objTabletru;
	}

	public List<String> getChFieldName() {
		return chFieldName;
	}

	public void setChFieldName(List<String> chFieldName) {
		this.chFieldName = chFieldName;
	}

	public List<String> getEnFieldName() {
		return enFieldName;
	}

	public void setEnFieldName(List<String> enFieldName) {
		this.enFieldName = enFieldName;
	}

	public String[] getExpert_Field() {
		return expert_Field;
	}

	public void setExpert_Field(String[] expert_Field) {
		this.expert_Field = expert_Field;
	}

	public String[] getExpert_Info() {
		return expert_Info;
	}

	public void setExpert_Info(String[] expert_Info) {
		this.expert_Info = expert_Info;
	}

	public Expert getObjExperts() {
		return objExperts;
	}

	public void setObjExperts(Expert objExperts) {
		this.objExperts = objExperts;
	}

	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}

	public String getPhotoName() {
		return photoName;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public void setObjUserLogin(UserLogin objUserLogin) {
		this.objUserLogin = objUserLogin;
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

	public List<CodeModel> getListCodeModel() {
		return listCodeModel;
	}

	public void setListCodeModel(List<CodeModel> listCodeModel) {
		this.listCodeModel = listCodeModel;
	}


}
