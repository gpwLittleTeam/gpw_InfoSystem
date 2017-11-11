package gpw.action.jump;

import java.util.ArrayList;
import java.util.List;

import gpw.getInfo.GetCounciltitle;
import gpw.getInfo.GetDegree;
import gpw.getInfo.GetEducation;
import gpw.getInfo.GetEngage;
import gpw.getInfo.GetGrouptitle;
import gpw.getInfo.GetSeries;
import gpw.getInfo.GetSex;
import gpw.getInfo.GetSpecial;
import gpw.getInfo.GetTitle;
import gpw.getInfo.GetTitlegrade;
import gpw.object.CodeModel;
import gpw.object.Sex;

import com.opensymphony.xwork2.ActionSupport;

public class To_CodeUpdate extends ActionSupport {
	private String codeNo;
	private CodeModel objCodeModel;
	private String table; // 代码表名
	private List<CodeModel> listCodeModel;

	@Override
	public String execute() throws Exception {
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
		listCodeModel = new ArrayList<CodeModel>();

		System.out.println("codeNo:" + codeNo);

		switch (table) {
		case "sex":
			objGetSex = new GetSex();
			objCodeModel = objGetSex.getSexByCode(codeNo).get(0);
			break;
		case "Counciltitle":
			objGetCounciltitle = new GetCounciltitle();
			objCodeModel = objGetCounciltitle.getCounciltitleByCode(codeNo).get(0);
			break;
		case "Degree":
			objGetDegree = new GetDegree();
			objCodeModel = objGetDegree.getDegreeByCode(codeNo).get(0);
			break;
		case "Education":
			objGetEducation = new GetEducation();
			objCodeModel = objGetEducation.getEducationByCode(codeNo).get(0);
			break;
		case "engage":
			objGetEngage = new GetEngage();
			objCodeModel = objGetEngage.getEngageByCode(codeNo).get(0);
			break;
		case "grouptitle":
			objGetGrouptitle = new GetGrouptitle();
			objCodeModel = objGetGrouptitle.getGrouptitleByCode(codeNo).get(0);
			break;
		case "series":
			objGetSeries = new GetSeries();
			objCodeModel = objGetSeries.getSeriesByCode(codeNo).get(0);
			break;
		case "special":
			objGetSpecial = new GetSpecial();
			objCodeModel = objGetSpecial.getSpecialByCode(codeNo).get(0);
			break;
		case "title":
			objGetTitle = new GetTitle();
			objCodeModel = objGetTitle.getTitleByCode(codeNo).get(0);
			break;
		case "titlegrade":
			objGetTitlegrade = new GetTitlegrade();
			objCodeModel = objGetTitlegrade.getTitlegradeByCode(codeNo).get(0);
			break;
		default:
			System.err.println("Error! To_CodePage.java execute");
			break;
		}

		return SUCCESS;
	}

	public String getCodeNo() {
		return codeNo;
	}

	public void setCodeNo(String codeNo) {
		this.codeNo = codeNo;
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
