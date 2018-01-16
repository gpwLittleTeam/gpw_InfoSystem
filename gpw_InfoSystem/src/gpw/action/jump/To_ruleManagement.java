package gpw.action.jump;

import java.util.List;

import gpw.getInfo.GetCode;
import gpw.getInfo.GetRuleField;
import gpw.getInfo.GetRuleManagement;
import gpw.object.CodeModel;
import gpw.object.Permission;
import gpw.object.RuleField;
import gpw.object.RuleManagement;
import gpw.algorithm.*;

import com.opensymphony.xwork2.ActionSupport;

public class To_ruleManagement extends ActionSupport {
	List<RuleManagement> listRuleManagements;
	@Override
	public String execute() throws Exception {
		GetRuleManagement objGetRuleManagement = new GetRuleManagement();
		listRuleManagements = objGetRuleManagement.getAllRuleManagement();
		List<String> ruleContent = new ForRuleContent().getRuleContent(); 
		RuleManagement tempRuleManagement;
		
		for(int i=0;i<listRuleManagements.size();i++){
			tempRuleManagement = listRuleManagements.get(i);  //第i条 rule
			
			//规则内容覆盖在rule_field中
			tempRuleManagement.setRule_field(ruleContent.get(i));
			/*将数据拼装成自然语言 end*/
			
			/*评审权限转换*/
			if(tempRuleManagement.getRule_range().equals("0")){
				tempRuleManagement.setRule_range("所有的高评委");  
			} else {
				tempRuleManagement.setRule_range(new Permission().GetPermissionByCode(tempRuleManagement.getRule_range()) + "的高评委");
			}
			/*评审权限转换 end*/
		}
		
		return super.execute();
	}
	public List<RuleManagement> getListRuleManagements() {
		return listRuleManagements;
	}
	public void setListRuleManagements(List<RuleManagement> listRuleManagements) {
		this.listRuleManagements = listRuleManagements;
	}
}
