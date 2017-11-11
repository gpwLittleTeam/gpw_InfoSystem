package gpw.action.jump;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;

import gpw.getInfo.GetTableStru;
import gpw.object.Counciltitle;
import gpw.object.Group;
import gpw.object.Grouptitle;
import gpw.object.Jury;
import gpw.object.Methods;
import gpw.object.Tablestru;
import gpw.object.UserLogin;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class To_Cxtj_query extends ActionSupport{
	private Tablestru[] aTablestru;
	private GetTableStru objGetTableStru;
	private List<String>[] arrayOfNameList; //选项的中文字段
	private List<String>[] arrayOfCodeList; //code of the choices
	private String juryString; //若是高评委用户，设置他的所属高评委
	private UserLogin objUserLogin;
	private Methods objMethods;
	//select选项的对象
	private Counciltitle objCounciltitle;
	private Jury objJury;
	private Group objGroup;
	private Grouptitle objGrouptitle;
	
	@Override
	public String execute() throws Exception {
		// TODO 自动生成的方法存根
		return super.execute();
	}
	
	public String loadPage() throws Exception{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
		//设置查询的选项
		int arraySize = 9;
		objGetTableStru = new GetTableStru();
		aTablestru = new Tablestru[arraySize];
		aTablestru[0] = objGetTableStru.getTableStruById(1);//编号
		aTablestru[1] = objGetTableStru.getTableStruById(2);//姓名
		aTablestru[2] = objGetTableStru.getTableStruById(5);//出生年月
		aTablestru[3] = objGetTableStru.getTableStruById(14);//工作单位
		aTablestru[4] = objGetTableStru.getTableStruById(11); //参加工作时间
		aTablestru[5] = objGetTableStru.getTableStruById(31);//现任高评委名称
		aTablestru[6] = objGetTableStru.getTableStruById(32);//现任高评委职务
		aTablestru[7] = objGetTableStru.getTableStruById(33);//专业组名称
		aTablestru[8] = objGetTableStru.getTableStruById(34);//专业组职务
		
		request.getSession().setAttribute("aTablestru", aTablestru); //传给QueryAction
		//select的选项
		arrayOfNameList = new List[4];
		arrayOfCodeList = new List[4];
		objCounciltitle = new Counciltitle(); 
		objJury = new Jury();
		objGroup = new Group();
		objGrouptitle = new Grouptitle();
		
		arrayOfNameList[0] = objJury.getAllJuryName();
		arrayOfCodeList[0] = objJury.getAllJuryNo();
		arrayOfNameList[1] = objCounciltitle.getAllName();
		arrayOfCodeList[1] = objCounciltitle.getAllCode();
		arrayOfNameList[2] = objGroup.getAllGroupName();
		arrayOfCodeList[2] = objGroup.getAllGroupNo();
		arrayOfNameList[3] = objGrouptitle.getAllPost();
		arrayOfCodeList[3] = objGrouptitle.getAllCode();
		
		objMethods = new Methods();
		objUserLogin = objMethods.getCurrentUser();
		juryString = objJury.getJuryNameByJuryNo(objUserLogin.getUser_jury()); 
		//System.out.println("To_Cxtj_query.java : "+arrayOfNameList[1].get(1));
		
		return SUCCESS;
	}

	public Tablestru[] getaTablestru() {
		return aTablestru;
	}

	public void setaTablestru(Tablestru[] aTablestru) {
		this.aTablestru = aTablestru;
	}

	public GetTableStru getObjGetTableStru() {
		return objGetTableStru;
	}

	public void setObjGetTableStru(GetTableStru objGetTableStru) {
		this.objGetTableStru = objGetTableStru;
	}

	public List<String>[] getArrayOfNameList() {
		return arrayOfNameList;
	}

	public void setArrayOfNameList(List<String>[] arrayOfNameList) {
		this.arrayOfNameList = arrayOfNameList;
	}

	public List<String>[] getArrayOfCodeList() {
		return arrayOfCodeList;
	}

	public void setArrayOfCodeList(List<String>[] arrayOfCodeList) {
		this.arrayOfCodeList = arrayOfCodeList;
	}

	public Counciltitle getObjCounciltitle() {
		return objCounciltitle;
	}

	public void setObjCounciltitle(Counciltitle objCounciltitle) {
		this.objCounciltitle = objCounciltitle;
	}

	public String getJuryString() {
		return juryString;
	}

	public void setJuryString(String juryString) {
		this.juryString = juryString;
	}

	public UserLogin getObjUserLogin() {
		return objUserLogin;
	}

	public void setObjUserLogin(UserLogin objUserLogin) {
		this.objUserLogin = objUserLogin;
	}

	public Methods getObjMethods() {
		return objMethods;
	}

	public void setObjMethods(Methods objMethods) {
		this.objMethods = objMethods;
	}

	public Jury getObjJury() {
		return objJury;
	}

	public void setObjJury(Jury objJury) {
		this.objJury = objJury;
	}

	public Group getObjGroup() {
		return objGroup;
	}

	public void setObjGroup(Group objGroup) {
		this.objGroup = objGroup;
	}

	public Grouptitle getObjGrouptitle() {
		return objGrouptitle;
	}

	public void setObjGrouptitle(Grouptitle objGrouptitle) {
		this.objGrouptitle = objGrouptitle;
	}
}
