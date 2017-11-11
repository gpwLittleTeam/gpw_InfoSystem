package gpw.action.MyAjax;

import gpw.getInfo.GetJuryIdcode;
import gpw.object.JuryIdcode;
import gpw.object.Methods;
import net.sf.json.JSONArray;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class ForJuryIdcode extends ActionSupport{
	private Methods objMethods = new Methods();
	private JSONArray jsonArray;
	private GetJuryIdcode getJuryIdcode = new GetJuryIdcode();
	private String juryNo = objMethods.getCurrentUser().getUser_jury();
	private String resultString;
	private String randomNum;
	private List<JuryIdcode> juryIdcodes;
	
	private String expertName;
	private String expertPhone;
	
	public String showRandomNum() throws Exception {
		randomNum = getJuryIdcode.generateJuryIdcode(juryNo,expertName,expertPhone);
		//System.out.println("showrandomnum : " + expertName + "  "+expertPhone);
		randomNum = "[" + randomNum + "]";
		jsonArray = JSONArray.fromObject(randomNum);
		resultString = jsonArray.toString(); // JSON->String
//		System.out.println(resultString);
		return super.execute();
	}
	
	public String showJuryIdcode() throws Exception {
		juryIdcodes = getJuryIdcode.getJuryIdcodes(juryNo);
		//System.out.println("showJuryIdcode: "+juryIdcodes);
		jsonArray = JSONArray.fromObject(juryIdcodes);
		resultString = jsonArray.toString(); // JSON->String
		//System.out.println(resultString);
		return super.execute();
	}


	public List<JuryIdcode> getJuryIdcodes() {
		return juryIdcodes;
	}

	public void setJuryIdcodes(List<JuryIdcode> juryIdcodes) {
		this.juryIdcodes = juryIdcodes;
	}

	public Methods getObjMethods() {
		return objMethods;
	}

	public void setObjMethods(Methods objMethods) {
		this.objMethods = objMethods;
	}

	public JSONArray getJsonArray() {
		return jsonArray;
	}

	public void setJsonArray(JSONArray jsonArray) {
		this.jsonArray = jsonArray;
	}

	public GetJuryIdcode getGetJuryIdcode() {
		return getJuryIdcode;
	}

	public void setGetJuryIdcode(GetJuryIdcode getJuryIdcode) {
		this.getJuryIdcode = getJuryIdcode;
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

	public String getJuryNo() {
		return juryNo;
	}

	public void setJuryNo(String juryNo) {
		this.juryNo = juryNo;
	}

	public String getResultString() {
		return resultString;
	}

	public void setResultString(String resultString) {
		this.resultString = resultString;
	}

	public String getRandomNum() {
		return randomNum;
	}

	public void setRandomNum(String randomNum) {
		this.randomNum = randomNum;
	}
	
//	public static void main(String args[]) throws Exception{
//		ForJuryPSD test = new ForJuryPSD();
//		test.juryNo = "0102";
//		test.showRandomNum();
//	}
}
