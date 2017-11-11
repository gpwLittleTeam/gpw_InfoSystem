package gpw.action.jump;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.xml.soap.SAAJResult;

import gpw.getInfo.GetHistoryTitle;
import gpw.object.Historytitle;
import gpw.object.Jury;
import gpw.object.Methods;
import gpw.object.Tablestru;

import com.opensymphony.xwork2.ActionSupport;

public class To_Rzgl extends ActionSupport{
	//任职管理  专家
	private GetHistoryTitle objGetHistoryTitle;
	private List<Historytitle>  listHistorytitle;
	//初始化 标题
	private Tablestru objTablestru;
	private String[] arrFields;
	//可选择年份
	private int[] years; 
	
	public String execute() throws Exception {
		String juryName = new Jury().getJuryNameByJuryNo(new Methods().getCurrentUser().getUser_jury());
		objGetHistoryTitle = new GetHistoryTitle();
		listHistorytitle = objGetHistoryTitle.getHistoryTitlesByExpertJuryInView(juryName);
		//系统年份
		SimpleDateFormat format = new SimpleDateFormat("yyyy");
        Date date = new Date();
        int formatDate = Integer.parseInt(format.format(date));
		int length = 80;
		years = new int[length];
		for(int i=0;i<length;i++) {
			years[i] = formatDate - i;
		}
//暂时不清楚要求 先在页面上写死，以下是从Tablestru表中读取列标题
//		arrFields = new String[6];
//		arrFields[0] = objTablestru.getChnameById("1");
//		arrFields[1] = objTablestru.getChnameById("2");
//		arrFields[2] = objTablestru.getChnameById("31");
//		arrFields[3] = objTablestru.getChnameById("33");
//		arrFields[4] = objTablestru.getChnameById("32");
//		arrFields[5] = objTablestru.getChnameById("24");
		
		return super.execute();
	}

	public GetHistoryTitle getObjGetHistoryTitle() {
		return objGetHistoryTitle;
	}

	public void setObjGetHistoryTitle(GetHistoryTitle objGetHistoryTitle) {
		this.objGetHistoryTitle = objGetHistoryTitle;
	}

	public List<Historytitle> getListHistorytitle() {
		return listHistorytitle;
	}

	public void setListHistorytitle(List<Historytitle> listHistorytitle) {
		this.listHistorytitle = listHistorytitle;
	}

	public Tablestru getObjTablestru() {
		return objTablestru;
	}

	public void setObjTablestru(Tablestru objTablestru) {
		this.objTablestru = objTablestru;
	}

	public String[] getArrFields() {
		return arrFields;
	}

	public void setArrFields(String[] arrFields) {
		this.arrFields = arrFields;
	}

	public int[] getYears() {
		return years;
	}

	public void setYears(int[] years) {
		this.years = years;
	}
}
