package gpw.action.jump;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.StrutsStatics;

import gpw.getInfo.GetExpert;
import gpw.getInfo.GetTableStru;
import gpw.object.Expert;
import gpw.object.Jury;
import gpw.object.Methods;
import gpw.object.Tablestru;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class To_Zjgl_InfoUpdate extends ActionSupport {
	// TableStru表实例化 显示左侧字段
	private GetTableStru objGetTableStru;
	private Tablestru[] aTablestrus;
	// select
	private List<String>[] arrayOfNameList; // 选项的中文字段
	private List<String>[] arrayOfCodeList;
	// code表对象
	private Methods objMethods;
	private Jury objJury; 
	// 专家个人信息
	private Expert objExpert;
	private String expert_no; // 展示的专家的number
	private String[] inputValue;
	private GetExpert objGetExpert;
	//头像
	private File photo; 
	private String photoName; // 专家头像名称
	private String contentType; //专家头像的后缀

	
	
	public String execute() throws Exception {
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(StrutsStatics.HTTP_REQUEST);

		// TableStru对象数组
		objGetTableStru = new GetTableStru();
		aTablestrus = (Tablestru[]) objGetTableStru.getAllTableStrus().toArray(
				new Tablestru[objGetTableStru.getAllTableStrus().size()]);

		// 对象的备注属性——null问题
		for (int i = 0; i < aTablestrus.length; i++) {
			// System.out.println("aTablestrus[i].getField_remark()  i="+i+" -> "+aTablestrus[i].getField_remark());
			if (aTablestrus[i].getField_remark() == null) {
				aTablestrus[i].setField_remark(" ");
			}
		}
		request.getSession().setAttribute("aTablestrus", aTablestrus);
		
		//设置select的value和显示字段
		int size = aTablestrus.length;
		arrayOfNameList = new ArrayList[size];
		arrayOfCodeList = new ArrayList[size];
		objMethods = new Methods();
		objMethods.setOpinionsOfSelect(arrayOfNameList, arrayOfCodeList,objMethods.getCurrentUser().getUser_jury());
		request.getSession().setAttribute("arrayOfCodeList", arrayOfCodeList);
		request.getSession().setAttribute("arrayOfNameList", arrayOfNameList);	
		
		//获取展示的专家的信息
		objGetExpert = new GetExpert();
		objJury = new Jury();
		objExpert = objGetExpert.getExpert(expert_no);
		objExpert.setExpert_Field22(objJury.getJuryNameByJuryNo(objExpert.getExpert_Field22()));  //从no再转化为name 
		objExpert.setExpert_Field31(objJury.getJuryNameByJuryNo(objExpert.getExpert_Field31()));  //从no再转化为name 		
		
		//头像
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
		
		return SUCCESS;
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

	public Methods getObjMethods() {
		return objMethods;
	}

	public void setObjMethods(Methods objMethods) {
		this.objMethods = objMethods;
	}

	public Expert getObjExpert() {
		return objExpert;
	}

	public void setObjExpert(Expert objExpert) {
		this.objExpert = objExpert;
	}

	public String getExpert_no() {
		return expert_no;
	}

	public void setExpert_no(String expert_no) {
		this.expert_no = expert_no;
	}

	public GetExpert getObjGetExpert() {
		return objGetExpert;
	}

	public void setObjGetExpert(GetExpert objGetExpert) {
		this.objGetExpert = objGetExpert;
	}

	public String[] getInputValue() {
		return inputValue;
	}

	public void setInputValue(String[] inputValue) {
		this.inputValue = inputValue;
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
}