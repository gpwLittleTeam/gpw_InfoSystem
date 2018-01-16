package gpw.action.jump;

import gpw.action.MyAjax.ForRuleManagement;
import gpw.algorithm.ForRuleContent;
import gpw.getInfo.GetRuleManagement;
import gpw.object.Jury;
import gpw.object.Methods;
import gpw.object.RuleManagement;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class To_Pwcq_wyh_new extends ActionSupport{
	Methods objMethods = new Methods();
	
	//firstPage
	private int[] years;  //系统年份
	List<RuleManagement> listRuleManagements;  //自然语言规则显示
	
	public String firstPage() {
		//清理Session
		objMethods.clearSession();
		/*系统年份*/
		SimpleDateFormat format = new SimpleDateFormat("yyyy");
        Date date = new Date();
        int formatDate = Integer.parseInt(format.format(date));
		int length = 80;
		years = new int[length];
		for(int i=0;i<length;i++) {
			years[i] = formatDate - i;
		}
		/*系统年份 end*/
		/*规则*/
		//取得当前用户所在的高评委的评审权限
		String juryPower = new Jury().getJuryPowerByJuryNo(new Methods().getCurrentUser().getUser_jury()); 
		System.out.println("juryPower:"  + juryPower);
		GetRuleManagement objGetRuleManagement = new GetRuleManagement();
		listRuleManagements = objGetRuleManagement.getEnabledRuleManagementByJuryPower(juryPower);
		List<String> ruleContent = new ForRuleContent().getRuleContent(listRuleManagements);
		for(int i=0;i<listRuleManagements.size();i++){
			listRuleManagements.get(i).setRule_field(ruleContent.get(i));
		}
		/*规则 end*/
		return "firstPage";
	}

	public Methods getObjMethods() {
		return objMethods;
	}

	public void setObjMethods(Methods objMethods) {
		this.objMethods = objMethods;
	}

	public int[] getYears() {
		return years;
	}

	public void setYears(int[] years) {
		this.years = years;
	}

	public List<RuleManagement> getListRuleManagements() {
		return listRuleManagements;
	}

	public void setListRuleManagements(List<RuleManagement> listRuleManagements) {
		this.listRuleManagements = listRuleManagements;
	}

}
