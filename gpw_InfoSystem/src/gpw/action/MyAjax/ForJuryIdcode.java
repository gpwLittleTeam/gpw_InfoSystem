package gpw.action.MyAjax;

import gpw.algorithm.AuthCode;
import gpw.getInfo.GetJuryIdcode;
import gpw.object.JuryIdcode;
import gpw.object.Methods;
import gpw.operateDatabase.Update;
import net.sf.json.JSONArray;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class ForJuryIdcode extends ActionSupport{
	private Methods objMethods = new Methods();
	private JSONArray jsonArray;
	private GetJuryIdcode getJuryIdcode = new GetJuryIdcode();
	private String juryNo = objMethods.getCurrentUser().getUser_jury();
	private String randomNum;
	private List<JuryIdcode> juryIdcodes;
	
	//input
	private String invalidTime; 
	private String expertName;
	private String expertPhone;

	//output
	private String newTime; //更新后的时间
	private String newAuthCode; //更新后的随机验证码
	private String resultString;  //返回到页面的结果
	
	//生成随机验证码
	public String showRandomNum() throws Exception {
		randomNum = getJuryIdcode.generateJuryIdcode(juryNo,expertName,expertPhone);
		//System.out.println("showrandomnum : " + expertName + "  "+expertPhone);
		randomNum = "[" + randomNum + "]";
		jsonArray = JSONArray.fromObject(randomNum);
		resultString = jsonArray.toString(); // JSON->String
//		System.out.println(resultString);
		return super.execute();
	}
	
	//读取专家
	public String showJuryIdcode() throws Exception {
		juryIdcodes = getJuryIdcode.getJuryIdcodes(juryNo);
		//System.out.println("showJuryIdcode: "+juryIdcodes);
		jsonArray = JSONArray.fromObject(juryIdcodes);
		resultString = jsonArray.toString(); // JSON->String
		//System.out.println(resultString);
		return super.execute();
	}

	public String updateInvalidTime() {
		//System.out.println("gpw.action.MyAjax.ForJuryIdcode.updateInvalidTime(String):" + invalidTime);
		Update objUpdate = new Update();
		AuthCode objRandAuthCode = new AuthCode();
		//System.out.println("expertName:" + expertName + "expertPhone:" + expertPhone);
		boolean isSuccess = objUpdate.updateJuryIdcodeByNamePhone(expertName,expertPhone,objRandAuthCode.getRandAuthCode(),invalidTime);
		
		
		//从数据库里再得到新的 验证码和时间
		GetJuryIdcode objGetJuryIdcode = new GetJuryIdcode();
		List<String> codeAndTme = objGetJuryIdcode.getCodeInfoByNamePhone(expertName, expertPhone);
		newAuthCode = codeAndTme.get(0);
		newTime = codeAndTme.get(1);
		
		//feedback
		if(isSuccess){
			resultString = "更新成功";
		}else {
			resultString = "更新失败";
		}
		return SUCCESS;
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

	public String getInvalidTime() {
		return invalidTime;
	}

	public void setInvalidTime(String invalidTime) {
		this.invalidTime = invalidTime;
	}

	public String getNewTime() {
		return newTime;
	}

	public void setNewTime(String newTime) {
		this.newTime = newTime;
	}

	public String getNewAuthCode() {
		return newAuthCode;
	}

	public void setNewAuthCode(String newAuthCode) {
		this.newAuthCode = newAuthCode;
	}
	
//	public static void main(String args[]) throws Exception{
//		ForJuryPSD test = new ForJuryPSD();
//		test.juryNo = "0102";
//		test.showRandomNum();
//	}
}
