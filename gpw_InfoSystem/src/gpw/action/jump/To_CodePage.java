package gpw.action.jump;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import gpw.getInfo.*;
import gpw.object.CodeModel;
import gpw.object.Group;

public class To_CodePage extends ActionSupport{
	private String table; //目标代码表
	private List<CodeModel> listCodeModel;
	private CodeModel objCodeModel;
	//代码表
	private GetCounciltitle objGetCounciltitle; //高评委职务
	private GetGrouptitle objGetGrouptitle; //学科组职务
	private GetGroup objGetGroup;  //专业组
	private GetEngage objGetEngage;  //受聘
	private GetDegree objGetDegree;  //学位
	private GetEducation objGetEducation; //学历
	private GetSex objGetSex;  //
	private GetSpecial objGetSpecial; //专业代码表
	private GetTitle objGetTitle; //专业技术资格
	private GetSeries objGetSeries; //系列代码表
	private GetTitlegrade objGetTitlegrade; //资格级别
	//For Group
	private List<Group> listGroup;
	@Override
	public String execute() throws Exception {
//		System.out.println("To_CodePage.java table:" + table);
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
		System.out.println("UpdateAction.java  updateCode() 有问题");
		return super.execute();
	}

	public String toGroup() {
		objGetGroup = new GetGroup();
		listGroup = objGetGroup.getAllGroups();
		return SUCCESS;
	}
	
	
	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public GetCounciltitle getObjGetCounciltitle() {
		return objGetCounciltitle;
	}

	public void setObjGetCounciltitle(GetCounciltitle objGetCounciltitle) {
		this.objGetCounciltitle = objGetCounciltitle;
	}

	public GetGrouptitle getObjGetGrouptitle() {
		return objGetGrouptitle;
	}

	public void setObjGetGrouptitle(GetGrouptitle objGetGrouptitle) {
		this.objGetGrouptitle = objGetGrouptitle;
	}

	public GetGroup getObjGetGroup() {
		return objGetGroup;
	}

	public void setObjGetGroup(GetGroup objGetGroup) {
		this.objGetGroup = objGetGroup;
	}

	public GetEngage getObjGetEngage() {
		return objGetEngage;
	}

	public void setObjGetEngage(GetEngage objGetEngage) {
		this.objGetEngage = objGetEngage;
	}

	public GetDegree getObjGetDegree() {
		return objGetDegree;
	}

	public void setObjGetDegree(GetDegree objGetDegree) {
		this.objGetDegree = objGetDegree;
	}

	public GetEducation getObjGetEducation() {
		return objGetEducation;
	}

	public void setObjGetEducation(GetEducation objGetEducation) {
		this.objGetEducation = objGetEducation;
	}

	public GetSex getObjGetSex() {
		return objGetSex;
	}

	public void setObjGetSex(GetSex objGetSex) {
		this.objGetSex = objGetSex;
	}

	public GetSpecial getObjGetSpecial() {
		return objGetSpecial;
	}

	public void setObjGetSpecial(GetSpecial objGetSpecial) {
		this.objGetSpecial = objGetSpecial;
	}

	public GetTitle getObjGetTitle() {
		return objGetTitle;
	}

	public void setObjGetTitle(GetTitle objGetTitle) {
		this.objGetTitle = objGetTitle;
	}

	public GetSeries getObjGetSeries() {
		return objGetSeries;
	}

	public void setObjGetSeries(GetSeries objGetSeries) {
		this.objGetSeries = objGetSeries;
	}

	public GetTitlegrade getObjGetTitlegrade() {
		return objGetTitlegrade;
	}

	public void setObjGetTitlegrade(GetTitlegrade objGetTitlegrade) {
		this.objGetTitlegrade = objGetTitlegrade;
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

	public List<Group> getListGroup() {
		return listGroup;
	}

	public void setListGroup(List<Group> listGroup) {
		this.listGroup = listGroup;
	}
}
