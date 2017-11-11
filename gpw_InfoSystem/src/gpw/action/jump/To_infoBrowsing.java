package gpw.action.jump;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import gpw.getInfo.GetUserLogin;
import gpw.object.Expert;
import gpw.object.Tablestru;
import gpw.object.UserLogin;

import org.apache.struts2.ServletActionContext; //key   

import com.opensymphony.xwork2.ActionSupport;

public class To_infoBrowsing extends ActionSupport {
	private Tablestru objTabletru;
	private Expert objExperts;
	private List<String> chFieldName; // 中文字段名
	private List<String> enFieldName; // 英文字段名
	private String[] expert_Field; // 储存Expert_Field
	private String[] expert_Info;
	private String expert_no;
	private File photo; 
	private String photoName; // 专家头像名称
	private String contentType; //专家头像的后缀
	
	private UserLogin objUserLogin; //判断gly or gpw
	
	public String execute() throws Exception {
		System.out.println("call execute()");
		return SUCCESS;
	}

	public String InfoBrowsing() throws Exception {
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
		HttpServletRequest request = ServletActionContext.getRequest();
		for (int i = 0; i < chFieldName.size(); i++) {
			// System.out.println("11 :"+expert_Field[i]);
			request.setAttribute(expert_Field[i], chFieldName.get(i));
		}
		/* System.out.println("zjgl_infoBrowsing.jsp"); */
		// 显示该专家的信息
		objExperts = new Expert();
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
//		System.out.println("绝对路径 "+ request.getRealPath("/"));
		objUserLogin =(UserLogin) request.getSession().getAttribute("User");
		if(objUserLogin.getUser_type().equals("1")) {
			return "gpw";
		}else {
			return "gly";
		}
	}

	public Tablestru getObjTabletru() {
		return objTabletru;
	}

	public void setObjTabletru(Tablestru objTabletru) {
		this.objTabletru = objTabletru;
	}

	public Expert getObjExperts() {
		return objExperts;
	}

	public void setObjExperts(Expert objExperts) {
		this.objExperts = objExperts;
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

	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}
	
	public static void main(String[] args) {
		String contentType1 = ".bmp";
		String photoName1;
		//photo = new File("./WebRoot/headPortrait/expert_" + expert_num + contentType);  //test: expert_201403
		File photo1 = new File("WebRoot/headPortrait/test.jpg");
		
		System.out.println("photo.getName() :" + photo1.getPath());
		if(photo1.exists()) {
			photoName1 = "./headPortrait/" + photo1.getName();
			System.out.println("exists -- To_infoBrowsing -- photoName: "+photoName1);
		} else {
			//photoName = "./headPortrait/expert_" + expert_num + contentType;
			photoName1 = "./headPortrait/test.jpg";
			System.out.println("not exist  " + photoName1);
		}
	}

	public String getExpert_no() {
		return expert_no;
	}

	public void setExpert_no(String expert_no) {
		this.expert_no = expert_no;
	}
}
