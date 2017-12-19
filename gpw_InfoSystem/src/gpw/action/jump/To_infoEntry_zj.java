package gpw.action.jump;

import gpw.getInfo.GenerateNo;
import gpw.getInfo.GetJuryIdcode;
/*
 * 之前一个个返回tableStru的值
 * 现在应该把这些整合成一个List<TableStru>
 * 然后传给前端
 * 前段就只需接受一个对象 即可 类似List<Experts>
 * */
//import gpw.getInfo.GenerateNo;
import gpw.getInfo.GetTableStru;
import gpw.object.*;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.activation.FileDataSource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class To_infoEntry_zj extends ActionSupport {
	// TableStru表实例化
	private GetTableStru objGetTableStru;
	private Tablestru[] aTablestrus;
	// select
	private List<String>[] arrayOfNameList; // 选项的中文字段
	private List<String>[] arrayOfCodeList;
	// code表对象
	private Jury objJury;
	// 自动生成编码
	private String ExpertNo;
	private GenerateNo objGenerateNo;
	// private UserLogin objUserLogin;
	// 专家所属高评委
	// private String juryName;

	private String expertName;
	private String expertPhone;
	private String expertIdcode;
	private GetJuryIdcode objGetJuryIdcode;
	private List<String> codeInfo;
	private String juryNo;
	private String juryName;
	private String message;

	public String loadFields() throws Exception {
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(StrutsStatics.HTTP_REQUEST);
		Methods objMethods = new Methods();
		// objUserLogin = (UserLogin)request.getSession().getAttribute("User");
		// System.err.println("session User:"+objUserLogin);
		// System.out.println(expertName + " " + expertPhone);

		// 验证姓名号码验证码
		objGetJuryIdcode = new GetJuryIdcode();
		// get(0) 验证码;get(1) 失效时间
		codeInfo = objGetJuryIdcode.getCodeInfoByNamePhone(expertName,
				expertPhone);
		// 日期处理
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		if (!codeInfo.isEmpty()) {
			//true=有效,false=已失效
			boolean isValid = (sdf.parse(codeInfo.get(1)).getTime() - now.getTime()) > 0;
			// 如果验证码正确，验证码未超时且从未提交过
			if (codeInfo.get(0).equals(expertIdcode)) {
				if(isValid) {
					boolean unSubmit = !(codeInfo.get(2).equals("已录入"));
					if(unSubmit) {
						// 得到对应的juryNo
						juryNo = objGetJuryIdcode.getJuryNo(expertIdcode, expertName,
								expertPhone);

						// TableStru对象数组
						objGetTableStru = new GetTableStru();
						aTablestrus = (Tablestru[]) objGetTableStru.getAllTableStrus().toArray(
										new Tablestru[objGetTableStru
												.getAllTableStrus().size()]);
						// 对象的备注属性——null问题
						for (int i = 0; i < aTablestrus.length; i++) {
							// System.out.println("aTablestrus[i].getField_remark()  i="+i+" -> "+aTablestrus[i].getField_remark());
							if (aTablestrus[i].getField_remark() == null) {
								aTablestrus[i].setField_remark(" ");
							}
						}
						request.getSession().setAttribute("aTablestrus", aTablestrus);

						int size = aTablestrus.length;
						// 设置select中英字段
						arrayOfNameList = new List[size];
						arrayOfCodeList = new List[size];
						objMethods.setOpinionsOfSelect(arrayOfNameList,
								arrayOfCodeList, juryNo);
						request.getSession().setAttribute("arrayOfCodeList",
								arrayOfCodeList);
						request.getSession().setAttribute("arrayOfNameList",
								arrayOfNameList);

						// gpw用户 所属高评委字段写死
						objJury = new Jury();
						juryName = objJury.getJuryNameByJuryNo(juryNo);
						// System.out.println("juryName:" + juryName);

						// 自动生成编码
						objGenerateNo = new GenerateNo();
						ExpertNo = objGenerateNo.generateExpertNo(juryNo);
						//System.out.println(ExpertNo);
						objMethods.setSession("expertName_enter", expertName);
						objMethods.setSession("expertPhone_enter", expertPhone);
						return SUCCESS;
					} else{
						message = "该专家的信息已经录入";
						return ERROR;
					}
				} else {
					message = "验证码超时";
					return ERROR;
				}
			} else {
				message = "验证码错误";
				return ERROR;
			}
		} else {
			String error = objMethods.getError();
			if (error != null && error.equals("NoConnect")) {
				message = "连接服务器失败";
				return ERROR;
			} else {
				message = "专家姓名或手机号码输入错误";
				return ERROR;	
			}
		}
	}

	public String getExpertNo() {
		return ExpertNo;
	}

	public void setExpertNo(String expertNo) {
		ExpertNo = expertNo;
	}

	public GenerateNo getObjGenerateNo() {
		return objGenerateNo;
	}

	public void setObjGenerateNo(GenerateNo objGenerateNo) {
		this.objGenerateNo = objGenerateNo;
	}

	public GetJuryIdcode getObjGetJuryIdcode() {
		return objGetJuryIdcode;
	}

	public void setObjGetJuryIdcode(GetJuryIdcode objGetJuryIdcode) {
		this.objGetJuryIdcode = objGetJuryIdcode;
	}

	public String getJuryNo() {
		return juryNo;
	}

	public void setJuryNo(String juryNo) {
		this.juryNo = juryNo;
	}

	public String getJuryName() {
		return juryName;
	}

	public void setJuryName(String juryName) {
		this.juryName = juryName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getExpertName() {
		return expertName;
	}

	public void setExpertName(String expertName) {
		this.expertName = expertName;
	}

	public String getExpertPhone() {
		return expertPhone;
	}

	public void setExpertPhone(String expertPhone) {
		this.expertPhone = expertPhone;
	}

	public String getExpertIdcode() {
		return expertIdcode;
	}

	public void setExpertIdcode(String expertIdcode) {
		this.expertIdcode = expertIdcode;
	}

	public String execute() throws Exception {
		System.out.println("Zjgl_infoEntry execute()");
		return super.execute();
	}

	public GetTableStru getObjGetTableStru() {
		return objGetTableStru;
	}

	public void setObjGetTableStru(GetTableStru objGetTableStru) {
		this.objGetTableStru = objGetTableStru;
	}

	public Tablestru[] getaTablestrus() {
		return aTablestrus;
	}

	public void setaTablestrus(Tablestru[] aTablestrus) {
		this.aTablestrus = aTablestrus;
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

	public Jury getObjJury() {
		return objJury;
	}

	public void setObjJury(Jury objJury) {
		this.objJury = objJury;
	}

	public List<String> getCodeInfo() {
		return codeInfo;
	}

	public void setCodeInfo(List<String> codeInfo) {
		this.codeInfo = codeInfo;
	}

	// public String getExpertNo() {
	// return ExpertNo;
	// }
	//
	// public void setExpertNo(String expertNo) {
	// ExpertNo = expertNo;
	// }

	// public GenerateNo getObjGenerateNo() {
	// return objGenerateNo;
	// }
	//
	// public void setObjGenerateNo(GenerateNo objGenerateNo) {
	// this.objGenerateNo = objGenerateNo;
	// }

	// public UserLogin getObjUserLogin() {
	// return objUserLogin;
	// }
	//
	// public void setObjUserLogin(UserLogin objUserLogin) {
	// this.objUserLogin = objUserLogin;
	// }

	// public String getJuryName() {
	// return juryName;
	// }
	//
	// public void setJuryName(String juryName) {
	// this.juryName = juryName;
	// }

	/*
	 * public static void main(String[] args) { Tablestru[] aTablestrus;
	 * GetTableStru objGetTableStru1; objGetTableStru1 = new GetTableStru();
	 * aTablestrus = (Tablestru[])
	 * objGetTableStru1.getAllTableStrus().toArray(new Tablestru[
	 * objGetTableStru1.getAllTableStrus().size()]);
	 * System.out.println("To_Zjgl_infoEntry+aTablestrus:"+aTablestrus[1]); }
	 */

	// 设置 input-width
	/*
	 * width = new String [fieldList.size()]; for(int i=0;i<fieldList.size();
	 * i++) { width[i] = objTablestru.getWidthById((i+1)+""); //width[i] =
	 * Integer.parseInt(objTablestru.getWidthById((i+1)+""))*15 + ""; } //
	 * System.out.println(width[3]); request.getSession().setAttribute("width",
	 * width);
	 */
	// 设置必填项
	/*
	 * isRequired = new String[fieldList.size()]; for(int
	 * i=0;i<fieldList.size();i++) {
	 * if(objTablestru.getNullById(""+(i+1)).equals("0")) { isRequired[0] =
	 * "required"; } else{ isRequired[0] = "required=false"; } }
	 */

	// objTablestru = new Tablestru();
	// fieldList = objTablestru.getChnameListById();
	// fieldName = new String[fieldList.size()];
	// remariksName = new String[fieldList.size()];
	// //设置显示字段名
	// for (int i = 0; i < fieldList.size(); i++) {
	// fieldName[i] = fieldList.get(i);
	// }
	// request.getSession().setAttribute("fieldName", fieldName);
	//
	// //设置备注
	// for (int i = 0; i < fieldList.size(); i++) {
	// //System.out.println("To_infoEntry.java: fieldName:" +fieldName[i] );
	// remariksName[i] = objTablestru.getRemarikByChname(fieldName[i]);
	// // System.out.println(i+":"+remariksName[i]);
	// String temp = null;
	// if(remariksName[i] == null) {
	// remariksName[i] = "";
	// //System.out.println(i+":"+remariksName[i]);
	// }
	// }
	// request.getSession().setAttribute("remariksName", remariksName);
	//
	//
	// 设置type
	// System.out.println("To_Zjgl_infoEntry 45");
	// type = new String[size];

	/*
	 * String[] temp = new String[size]; for (int i = 0; i < size; i++) {
	 * temp[i] = aTablestrus[i].getField_type(); //
	 * System.out.println("To_Zjgl_infoEntry :" + i +"temp[i]:"+temp[i]); switch
	 * (temp[i]) { case "char": // System.out.println("char"); type[i] = "text";
	 * break; case "datetime": // System.out.println("datetime"); type[i] =
	 * "date"; break; case "int": // System.out.println("int"); type[i] =
	 * "number"; break; case "select": //从expert_field8开始判断 //type[i]从i=0开始 所以要
	 * type[i] = "select"; if(i==9 || i== 11) { // 专业代码表|9=所学专业 /11=现从事专业
	 * objSpecial = new Special(); arrayOfNameList[i] =
	 * objSpecial.getAllSpecialname(); arrayOfCodeList[i] =
	 * objSpecial.getAllCode(); } else if(i==14) { //是否|14=是否本单位 objJudge = new
	 * Judge(); arrayOfNameList[i] = objJudge.getAllJudge(); arrayOfCodeList[i]
	 * = objJudge.getAllCode(); } else if(i==33) { //学科组职务代码表 | 33=专业组职务
	 * objGrouptitle = new Grouptitle(); arrayOfNameList[i] =
	 * objGrouptitle.getAllPost(); arrayOfCodeList[i] =
	 * objGrouptitle.getAllCode(); } else if(i==16) { //专业技术资格代码表 | 16=现有任职资格
	 * objTitle = new Title(); arrayOfNameList[i] = objTitle.getAllTitlename();
	 * arrayOfCodeList[i] = objTitle.getAllCode(); } else if(i==20) { //聘任情况 |
	 * 20=聘任情况 objEngage = new Engage(); arrayOfNameList[i] =
	 * objEngage.getAllEmploy(); arrayOfCodeList[i] = objEngage.getAllCode(); }
	 * else if(i==22 ||i==31) { //高评委职务代码表|| 22=高评委职务 objCounciltitle = new
	 * Counciltitle(); arrayOfNameList[i] = objCounciltitle.getAllName();
	 * arrayOfCodeList[i] = objCounciltitle.getAllCode(); } else if(i==32) {
	 * //专业组名称| objGroup = new Group(); arrayOfCodeList[i] =
	 * objGroup.getAllGroupNo(); arrayOfNameList[i] =
	 * objGroup.getAllGroupName(); } else { //没有对应代码表 | 17=资格级别 18=任职资格所属系列
	 * arrayOfNameList[i] = Arrays.asList("选项一","选项二"); arrayOfCodeList[i] =
	 * Arrays.asList("0101","0202"); } break; default:
	 * System.out.println("default"); break; } // System.out.println(type[i]); }
	 */
}
