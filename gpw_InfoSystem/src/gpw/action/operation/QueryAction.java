package gpw.action.operation;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;

import gpw.object.Expert;
import gpw.object.Historytitle;
import gpw.object.Jury;
import gpw.object.Methods;
import gpw.object.Tablestru;
import gpw.object.UserField;
import gpw.object.UserLogin;
import gpw.getInfo.GetExpert;
import gpw.getInfo.GetHistoryTitle;
import gpw.getInfo.GetJury;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class QueryAction extends ActionSupport {
	private Methods objMethods = new Methods();
	private String theValue; // 查询的值
	private String QueryItem;// 查询的项

	// gly查询
	private String juryName;
	private Jury objJury;
	private List<String> listGpwName;
	private List<String> listGpwNo;
	// to_expertsList
	private GetExpert objGetObject;
	private List<Expert> expertList;

	private String UserName;
	private List<String> chDefaultFieldList;
	private List<String> intDefaultFieldList;
	private UserField objUserField;

	// 综合查询
	private String[] theField;
	private Tablestru[] aTablestru;
	private List<String> enFieldList; // 用户输入的查询的英文字段
	private List<String> valueList; // 查询字段的值

	// 任职管理
	private String selectedYear;
	private GetHistoryTitle objGetHistoryTitle;
	private List<Historytitle> listHistorytitle;
	private int[] years;

	// 高评委管理
	private GetJury objGetJury;
	private List<Jury> listJury;

	// 当前用户
	private UserLogin objUserLogin;

	@Override
	public String execute() throws Exception {
		System.out.println("call Query.java execute()");
		return SUCCESS;
	}
	
	//简单查询
	public String forZjglInfoList_gpw() {
		objGetObject = new GetExpert();
		
		objUserLogin = objMethods.getCurrentUser();
		objJury = new Jury();

		// JuryNo -> JuryName
		String jury = objJury.getJuryNameByJuryNo(objUserLogin.getUser_jury());

		// System.out.println("查询值："+theValue);
		if (QueryItem.equals("name")) {
			expertList = objGetObject.getExpertByNameAndJuryFromInfoView(theValue, jury);
		} else if (QueryItem.equals("majorGroup")) {
			expertList = objGetObject.getExpertByGroupAndJuryFromInfoView(theValue, jury);
		} else if (QueryItem.equals("workplace")) {
			expertList = objGetObject.getExpertByWorkplaceAndJuryFromInfoView(theValue, jury);
		} else if (QueryItem.equals("number")) {
			expertList = objGetObject.getExpertByNumberAndJuryFromInfoView(theValue, jury);
		} else {
			expertList = objGetObject.getExpertByJuryFromInfoView(jury);
		}
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
		request.getSession().setAttribute("expertList", expertList);
		return SUCCESS;
	}

	public String forZjglInfoList_gly() {
		objGetObject = new GetExpert();
		//System.out.println("查询值：" + theValue);
		objJury = new Jury();
		if (juryName == null || juryName.equals("")) {
			if (QueryItem.equals("name")) {
				expertList = objGetObject.getExpertByNameFromInfoView(theValue);
			} else if (QueryItem.equals("majorGroup")) {
				expertList = objGetObject.getExpertByGroupFromInfoView(theValue);
			} else if (QueryItem.equals("workplace")) {
				expertList = objGetObject.getExpertByWorkplaceFromInfoView(theValue);
			} else if (QueryItem.equals("number")) {
				expertList.add(objGetObject.getExpertByNumberFromInfoView(theValue));
			} else {
				expertList = objGetObject.getAllExpertsFromInfoView();
			}
		} else {
			// System.out.println("ChjuryName: " + juryName);
			// juryName = objJury.getJuryNoByJuryName(juryName);
			// System.out.println("EnjuryName: " + juryName);
			if (QueryItem.equals("name")) {
				expertList = objGetObject.getExpertByNameAndJuryFromInfoView(theValue, juryName);
			} else if (QueryItem.equals("majorGroup")) {
				expertList = objGetObject.getExpertByGroupAndJuryFromInfoView(theValue, juryName);
			} else if (QueryItem.equals("workplace")) {
				expertList = objGetObject.getExpertByWorkplaceAndJuryFromInfoView(theValue, juryName);
			} else if (QueryItem.equals("number")) {
				expertList = objGetObject.getExpertByNumberAndJuryFromInfoView(theValue, juryName);
			} else {
				expertList = objGetObject.getExpertByJuryFromInfoView(juryName);
			}
		}
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
		request.getSession().setAttribute("expertList", expertList);

		// 高评委datalist
		objJury = new Jury();
		listGpwName = new ArrayList<String>();
		listGpwNo = new ArrayList<String>();
		listGpwNo = objJury.getAllJuryNo();
		listGpwName = objJury.getAllJuryName();

		// System.out.println("QueryAction.java forZjglInfoList_gly expertList.size(): "
		// + expertList.size());
		return SUCCESS;
	}

	// 查询方法错误输入会报错
	// 信息查询
	public String forCxtjQuery() throws UnsupportedEncodingException {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
		
		int nrOfProperties = 35;
		enFieldList = new ArrayList<String>();
		valueList = new ArrayList<String>();
		aTablestru = (Tablestru[]) request.getSession().getAttribute("aTablestru");
		for (int i = 0; i < 9; i++) {
			if (!theField[i].equals("0") && !theField[i].equals("")) {
				theField[i] = new String(theField[i].getBytes("ISO-8859-1"), "utf-8"); // 不知道为什么会变成ISO-8859-1
				/*if (i == 5) { // 所属高评委名称 -> 高评委代码
					objJury = new Jury();
					theField[i] = objJury.getJuryNoByJuryName(theField[i]);
				}*/
				valueList.add(theField[i]);
				// System.out.println(i +" = "+ aTablestru[i].getField_name() +
				// "=====  theField[i]"+theField[i]);
				enFieldList.add(aTablestru[i].getField_name());
			}
		}
		objGetObject = new GetExpert();
		expertList = objGetObject.searchExpertFromInfoView(enFieldList, valueList); // 查询语句
		// System.out.println("QueryAction.java  expertList.size: " +
		// expertList.size());
		request.getSession().setAttribute("expertList", expertList);

		// to_infoList 加载默认字段
		objUserLogin = objMethods.getCurrentUser();
		objUserField = new UserField();
		UserName = objUserLogin.getUser_name();
		objMethods.initializeDefaultFieldList(UserName);

		if (objUserLogin.getUser_type().equals("1"))
			return "gpw";
		else
			objJury = new Jury();
		listGpwName = objJury.getAllJuryName();
		listGpwNo = objJury.getAllJuryNo();
		return "gly";
	}

	// 任职管理查询
	public String forRzglQuery() {
		// 系统年份
		SimpleDateFormat format = new SimpleDateFormat("yyyy");
		Date date = new Date();
		int formatDate = Integer.parseInt(format.format(date));
		int length = 80;
		years = new int[length];
		for (int i = 0; i < length; i++) {
			years[i] = formatDate - i;
		}
		
		//查询
		objGetHistoryTitle = new GetHistoryTitle();
		String juryName = new Jury().getJuryNameByJuryNo(new Methods().getCurrentUser().getUser_jury());
		// System.out.println("QueryAction: selectedYear"+ selectedYear);
		if (selectedYear.equals("0")) {
			listHistorytitle = objGetHistoryTitle.getHistoryTitlesByExpertJuryInView(juryName);
		} else {
			listHistorytitle = objGetHistoryTitle.getHistoryTitlesByServeyearAndJuryNoInView(selectedYear,juryName);
		}
		return SUCCESS;
	}

	// 高评委管理查询 gly
	public String forGpwQuery() {
		objGetJury = new GetJury();
		System.out.println("forGpwQuery -> QueryItem：" + QueryItem);
		// if(QueryItem.equals("jury_no")){
		// listJury =objGetJury.getJuryByNo(theValue);
		// } else if(Q)
		switch (QueryItem) {
		case "jury_no":
			listJury = new ArrayList<Jury>();
			listJury.add(objGetJury.getJuryByNo(theValue));
			break;
		case "jury_name":
			listJury = objGetJury.getJuryByName(theValue);
			break;
		case "all":
			listJury = objGetJury.getAllJurys();
		default:
			System.out.println("没有找到对应的查询项QueryItem");
			break;
		}
		return SUCCESS;
	}

	// get/set方法
	public String getTheValue() {
		return theValue;
	}

	public void setTheValue(String theValue) {
		this.theValue = theValue;
	}

	public String getQueryItem() {
		return QueryItem;
	}

	public void setQueryItem(String queryItem) {
		QueryItem = queryItem;
	}

	public GetExpert getObjGetObject() {
		return objGetObject;
	}

	public void setObjGetObject(GetExpert objGetObject) {
		this.objGetObject = objGetObject;
	}

	public List<Expert> getExpertList() {
		return expertList;
	}

	public void setExpertList(List<Expert> expertList) {
		this.expertList = expertList;
	}

	public String[] getTheField() {
		return theField;
	}

	public void setTheField(String[] theField) {
		this.theField = theField;
	}

	public Tablestru[] getaTablestru() {
		return aTablestru;
	}

	public void setaTablestru(Tablestru[] aTablestru) {
		this.aTablestru = aTablestru;
	}

	public List<String> getEnFieldList() {
		return enFieldList;
	}

	public void setEnFieldList(List<String> enFieldList) {
		this.enFieldList = enFieldList;
	}

	public List<String> getValueList() {
		return valueList;
	}

	public void setValueList(List<String> valueList) {
		this.valueList = valueList;
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

	public String getSelectedYear() {
		return selectedYear;
	}

	public void setSelectedYear(String selectedYear) {
		this.selectedYear = selectedYear;
	}

	public GetHistoryTitle getObjGetHistoryTitle() {
		return objGetHistoryTitle;
	}

	public void setObjGetHistoryTitle(GetHistoryTitle objGetHistoryTitle) {
		this.objGetHistoryTitle = objGetHistoryTitle;
	}

	public List<Historytitle> getListHistorytitles() {
		return listHistorytitle;
	}

	public void setListHistorytitles(List<Historytitle> listHistorytitles) {
		this.listHistorytitle = listHistorytitles;
	}

	public List<Historytitle> getListHistorytitle() {
		return listHistorytitle;
	}

	public void setListHistorytitle(List<Historytitle> listHistorytitle) {
		this.listHistorytitle = listHistorytitle;
	}

	public int[] getYears() {
		return years;
	}

	public void setYears(int[] years) {
		this.years = years;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public UserLogin getObjUserLogin() {
		return objUserLogin;
	}

	public void setObjUserLogin(UserLogin objUserLogin) {
		this.objUserLogin = objUserLogin;
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

	public String getJuryName() {
		return juryName;
	}

	public void setJuryName(String juryName) {
		this.juryName = juryName;
	}

	public Jury getObjJury() {
		return objJury;
	}

	public void setObjJury(Jury objJury) {
		this.objJury = objJury;
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

}
