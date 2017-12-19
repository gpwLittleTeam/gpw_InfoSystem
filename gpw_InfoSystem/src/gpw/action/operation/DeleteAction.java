package gpw.action.operation;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;

import gpw.action.jump.To_Gpwgl;
import gpw.getInfo.GetCounciltitle;
import gpw.getInfo.GetDegree;
import gpw.getInfo.GetEducation;
import gpw.getInfo.GetEngage;
import gpw.getInfo.GetGroup;
import gpw.getInfo.GetExpert;
import gpw.getInfo.GetGrouptitle;
import gpw.getInfo.GetHistoryTitle;
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
import gpw.object.Historytitle;
import gpw.object.Jury;
import gpw.object.JuryIdcode;
import gpw.object.Methods;
import gpw.object.UserField;
import gpw.object.UserLogin;
import gpw.operateDatabase.Delete;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteAction extends ActionSupport {
	private Methods objMethods = new Methods();
	private UserLogin objUserLogin;
	private Delete objDelete = new Delete();
	private String feedback;

	private String chooseAll; // ignore
	private List<String> nrOfCheckbox; // 要删除的对象的编号
//	private List<String> Mcheckbox; //JuryIdcode的那个checkbox
	// 删除专家
	private List<Expert> expertList;
	private GetExpert objGetObject;
	private List<String> chDefaultFieldList;
	private List<String> intDefaultFieldList;
	private UserField objUserField;
	private String UserName;// 当前用户的ID
	// 删除照片
	private String contentType;
	private File[] photo;
	// 删除专业组
	private List<Group> objGroupList; // 显示列表
	private GetGroup objGetGroup;
	// 删除任职管理记录
	private List<Historytitle> listHistorytitle;
	private GetHistoryTitle objGetHistoryTitle;
	private int[] years; 
	// 删除用户
	private List<UserLogin> listUserLogin;
	private GetUserLogin objGetUserLogin;
	// 删除代码表
	private List<Group> listGroup;
	private String table;

	private List<CodeModel> listCodeModel;
	private CodeModel objCodeModel;
	
	//删除高评委
	private List<Jury> listJury;
	
	//删除juryidcode
	private JSONArray jsonarray;
	private JSONObject jsonobject;
	private List<JuryIdcode> juryIdcodes;
	private GetJuryIdcode getJuryIdcode;
	
 	public String execute() throws Exception {
		return SUCCESS;
	}

	// 删除专家
	public String deleteExpertByNumber() {
		objDelete = new Delete();
		// System.out.println("call deleteExpertByNumber()");
		objDelete.deleteExpertByNumber(nrOfCheckbox);

		// 删除照片
		contentType = ".bmp";
		photo = new File[nrOfCheckbox.size()];
		for (int i = 0; i < nrOfCheckbox.size(); i++) {
			photo[i] = new File("D:/MyEclipse_Workspace/.metadata/.me_tcat/webapps/gpw_InfoSystem/headPortrait/expert_"
					+ nrOfCheckbox.get(i) + contentType);
			if (photo[i].delete()) {
				System.out.println("the photo is deleted");
			} else {
				System.out.println("not found the photo");
			}
		}
		/*  */
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
		// 删除后 更新专家List
//		objMethods = new Methods();
//		objUserLogin = objMethods.getCurrentUser();
//		expertList = objMethods.initializeExpertListForGPWByJuryNo(objUserLogin.getUser_jury());
		// 初始化user的默认字段
		/*objUserField = new UserField();
		UserName = "zjut";
		intDefaultFieldList = objUserField.getDefaultFieldNrByUserName(UserName);
		chDefaultFieldList = objUserField.getDefaultFieldChNameByUserName(UserName);
		request.getSession().setAttribute("chDefaultFieldList", chDefaultFieldList);
		request.getSession().setAttribute("intDefaultFieldList", intDefaultFieldList);*/
		System.out.println("delete complete");
		return SUCCESS;
	}

	// 删除专业组
	public String deleteGroupByNumber() {
		objDelete = new Delete();
		objDelete.deleteGroupByNo(nrOfCheckbox);

		// 显示列表
		objGetGroup = new GetGroup();
		objGroupList = objGetGroup.getGroupByJury(objMethods.getCurrentUser().getUser_jury());

		//
		return SUCCESS;
	}
	
	//删除JuryIdcode
	public String deleteJuryIdcodeByNamePhone() {
		objDelete = new Delete();
		for(int i=0; i<nrOfCheckbox.size(); i++){
//			System.out.println(temp);
			jsonobject = JSONObject.fromObject(nrOfCheckbox.get(i));
			objDelete.deleteJuryIdcodeByNamePhone(jsonobject.getString("expert_name"),jsonobject.getString("expert_phone"));
		}
		//System.out.println(Mcheckbox);
		
		//getJuryIdcode = new GetJuryIdcode();
		//System.out.println(objUserLogin.getUser_jury());
		//juryIdcodes = getJuryIdcode.getJuryIdcodes(objMethods.getCurrentUser().getUser_jury());
		//
		return SUCCESS;
	}

	// 删除任职管理
	public String deleteHistoryByNumber() {
		List<String> expertNo = new ArrayList<String>();
		List<String> serveYear = new ArrayList<String>();
		for(int i=0;i<nrOfCheckbox.size();i++) {
			expertNo.add(nrOfCheckbox.get(i).split("&")[0]);
			serveYear.add(nrOfCheckbox.get(i).split("&")[1]);
			System.out.println("expertNo:"+expertNo);
			System.out.println("serveYear:"+serveYear);
		}
		objDelete.deleteHistoryTitleByNoAndYear(expertNo,serveYear);

		// 重新加载HistoryList
		String juryName = new Jury().getJuryNameByJuryNo(objMethods.getCurrentUser().getUser_jury());
		objGetHistoryTitle = new GetHistoryTitle();
		listHistorytitle = objGetHistoryTitle.getHistoryTitlesByExpertJuryInView(juryName);
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy");
        Date date = new Date();
        int formatDate = Integer.parseInt(format.format(date));
		int length = 80;
		years = new int[length];
		for(int i=0;i<length;i++) {
			years[i] = formatDate - i;
		}
		return SUCCESS;
	}

	// 删除用户
	public String deleteUserByName() {
//		System.out.println(nrOfCheckbox);
//		System.out.println(this.objUserLogin.getUser_name());
		objMethods = new Methods();
		objUserLogin = objMethods.getCurrentUser();
		if (nrOfCheckbox.indexOf(objUserLogin.getUser_name()) == -1) {
			if (objDelete.deleteUserLoginByName(nrOfCheckbox)) {
				feedback = "删除用户成功！";
			} else {
				feedback = "删除用户失败！";
			}
		} else {
			feedback = "不允许删除自己！";
		}
		return SUCCESS;
	}

	// 删除代码
	public String deleteCode() {
		boolean success = false;
		
		GetCounciltitle objGetCounciltitle; //高评委职务
		GetGrouptitle objGetGrouptitle; //学科组职务
		GetEngage objGetEngage;  //受聘
		GetDegree objGetDegree;  //学位
		GetEducation objGetEducation; //学历
		GetSex objGetSex;  //
		GetSpecial objGetSpecial; //专业代码表
		GetTitle objGetTitle; //专业技术资格
		GetSeries objGetSeries; //系列代码表
		GetTitlegrade objGetTitlegrade; //资格级别
		
		listCodeModel = new ArrayList<CodeModel>();
		switch (table) {
		case "sex":
			success = objDelete.deleteSex(nrOfCheckbox); 
			
			//reload
			objGetSex = new GetSex();
			for(int i=0;i<objGetSex.getAllSexs().size();i++) {
				objCodeModel = objGetSex.getAllSexs().get(i);
				listCodeModel.add(objCodeModel);
			}
			
			break;
		case "Counciltitle":
			success = objDelete.deleteCounciltitle(nrOfCheckbox);
			
			objGetCounciltitle = new GetCounciltitle();
			for(int i=0;i<objGetCounciltitle.getAllCounciltitles().size();i++) {
				objCodeModel = objGetCounciltitle.getAllCounciltitles().get(i);
				listCodeModel.add(objCodeModel);
			}
			
			break;
		case "Degree":
			success = objDelete.deleteDegree(nrOfCheckbox);
			
			objGetDegree = new GetDegree();
			for(int i=0;i<objGetDegree.getAllDegrees().size();i++) {
				objCodeModel = objGetDegree.getAllDegrees().get(i);
				listCodeModel.add(objCodeModel);
			}
			
			break;
		case "Education":
			success = objDelete.deleteEducation(nrOfCheckbox);
			
			objGetEducation = new GetEducation();
			for(int i=0;i<objGetEducation.getAllEducations().size();i++) {
				objCodeModel = objGetEducation.getAllEducations().get(i);
				listCodeModel.add(objCodeModel);
			}
			
			break;
		case "engage":
			success = objDelete.deleteEngage(nrOfCheckbox);
			
			objGetEngage = new GetEngage();
			for(int i=0;i<objGetEngage.getAllEngages().size();i++) {
				objCodeModel = objGetEngage.getAllEngages().get(i);
				listCodeModel.add(objCodeModel);
			}
			
			break;
		case "grouptitle":
			success = objDelete.deleteGrouptitle(nrOfCheckbox);
			
			objGetGrouptitle = new GetGrouptitle();
			for(int i=0;i<objGetGrouptitle.getAllGrouptitles().size();i++){
				objCodeModel = objGetGrouptitle.getAllGrouptitles().get(i);
				listCodeModel.add(objCodeModel);
			}
			
			break;
		case "series":
			success = objDelete.deleteSeries(nrOfCheckbox);
			
			objGetSeries = new GetSeries();
			for(int i=0;i<objGetSeries.getAllSeriess().size();i++){
				objCodeModel = objGetSeries.getAllSeriess().get(i);
				listCodeModel.add(objCodeModel);
			}
			
			break;
		case "special":
			success = objDelete.deleteSpecial(nrOfCheckbox);
			
			objGetSpecial = new GetSpecial();
			for(int i=0;i<objGetSpecial.getAllSpecials().size();i++){
				objCodeModel = objGetSpecial.getAllSpecials().get(i);
//				System.out.println(objCodeModel.getCodeName());
				listCodeModel.add(objCodeModel);
			}
			
			break;
		case "title":
			success = objDelete.deleteTitle(nrOfCheckbox);
			
			objGetTitle = new GetTitle();
			for(int i=0;i<objGetTitle.getAllTitles().size();i++){
				objCodeModel = objGetTitle.getAllTitles().get(i);
//				System.out.println(objCodeModel.getCodeName());
				listCodeModel.add(objCodeModel);
			}
			
			break;
		case "titlegrade":
			success = objDelete.deleteTitlegrade(nrOfCheckbox);
			
			objGetTitlegrade = new GetTitlegrade();
			for(int i=0;i<objGetTitlegrade.getAllTitlegrades().size();i++){
				objCodeModel = objGetTitlegrade.getAllTitlegrades().get(i);
				listCodeModel.add(objCodeModel);
			}
			
			break;
		default:
			System.err.println("Error! InsertAction.java createCodeForcommon()");
			break;
		}
		
		if(success) {
			feedback = "删除成功";
		} else {
			feedback = "删除失败";
		}
		return SUCCESS;
	}

	public String deleteCodeForGroup() {
		objDelete.deleteGroupByNo(nrOfCheckbox);

		// reload
		objGetGroup = new GetGroup();
		listGroup = objGetGroup.getAllGroups();

		return SUCCESS;
	}

	// 删除高评委
	public String deleteJury() throws Exception {
		if (objDelete.deleteJuryByNo(nrOfCheckbox)) {
			feedback = "删除高评委成功！";
		} else {
			feedback = "删除高评委失败！";
		}
		

		GetJury objGetJury = new GetJury();
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
			}
		}
		return SUCCESS;
	}

	// getter & setter

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

	public JSONObject getJsonobject() {
		return jsonobject;
	}

	public void setJsonobject(JSONObject jsonobject) {
		this.jsonobject = jsonobject;
	}

	public JSONArray getJsonarray() {
		return jsonarray;
	}

	public void setJsonarray(JSONArray jsonarray) {
		this.jsonarray = jsonarray;
	}

//	public List<String> getMcheckbox() {
//		return Mcheckbox;
//	}
//
//	public void setMcheckbox(List<String> mcheckbox) {
//		Mcheckbox = mcheckbox;
//	}

	public Delete getObjDelete() {
		return objDelete;
	}

	public void setObjDelete(Delete objDelete) {
		this.objDelete = objDelete;
	}

	public List<Expert> getExpertList() {
		return expertList;
	}

	public void setExpertList(List<Expert> expertList) {
		this.expertList = expertList;
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

	public UserField getObjUserField() {
		return objUserField;
	}

	public void setObjUserField(UserField objUserField) {
		this.objUserField = objUserField;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public File[] getPhoto() {
		return photo;
	}

	public void setPhoto(File[] photo) {
		this.photo = photo;
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

	public String getChooseAll() {
		return chooseAll;
	}

	public void setChooseAll(String chooseAll) {
		this.chooseAll = chooseAll;
	}

	public List<Historytitle> getListHistorytitle() {
		return listHistorytitle;
	}

	public void setListHistorytitle(List<Historytitle> listHistorytitle) {
		this.listHistorytitle = listHistorytitle;
	}

	public GetHistoryTitle getObjGetHistoryTitle() {
		return objGetHistoryTitle;
	}

	public void setObjGetHistoryTitle(GetHistoryTitle objGetHistoryTitle) {
		this.objGetHistoryTitle = objGetHistoryTitle;
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

	public List<Group> getListGroup() {
		return listGroup;
	}

	public void setListGroup(List<Group> listGroup) {
		this.listGroup = listGroup;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public List<String> getNrOfCheckbox() {
		return nrOfCheckbox;
	}

	public void setNrOfCheckbox(List<String> nrOfCheckbox) {
		this.nrOfCheckbox = nrOfCheckbox;
	}

	public List<Jury> getListJury() {
		return listJury;
	}

	public void setListJury(List<Jury> listJury) {
		this.listJury = listJury;
	}

	public int[] getYears() {
		return years;
	}

	public void setYears(int[] years) {
		this.years = years;
	}

	public List<CodeModel> getListCodeModel() {
		return listCodeModel;
	}

	public void setListCodeModel(List<CodeModel> listCodeModel) {
		this.listCodeModel = listCodeModel;
	}

	public CodeModel getObjCodeModel() {
		return objCodeModel;
	}

	public void setObjCodeModel(CodeModel objCodeModel) {
		this.objCodeModel = objCodeModel;
	}
}
