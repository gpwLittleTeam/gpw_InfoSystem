package gpw.action.jump;

import java.util.List;

import gpw.getInfo.GetCode;
import gpw.getInfo.GetRuleField;
import gpw.getInfo.GetRuleManagement;
import gpw.object.CodeModel;
import gpw.object.Permission;
import gpw.object.RuleField;
import gpw.object.RuleManagement;

import com.opensymphony.xwork2.ActionSupport;

public class To_ruleManagement extends ActionSupport {
	List<RuleManagement> listRuleManagements;
	@Override
	public String execute() throws Exception {
		GetRuleManagement objGetRuleManagement = new GetRuleManagement();
		listRuleManagements = objGetRuleManagement.getAllRuleManagement();
		GetRuleField objGetRuleField = new GetRuleField();
		CodeModel objCodeModel = new CodeModel();
		
		RuleManagement tempRuleManagement;
		RuleField tempRuleField;
		String ruleContent = "";  //规则的自然语言
		
		
		for(int i=0;i<listRuleManagements.size();i++){
			tempRuleManagement = listRuleManagements.get(i);  //第i条 rule
			tempRuleField = objGetRuleField.getRuleFieldByFieldName(tempRuleManagement.getRule_field());
			
			/*将数据拼装成自然语言*/
			ruleContent = "抽取结果中";
			ruleContent += tempRuleField.getField_chname();
			
			//处理 = > <
			switch (tempRuleManagement.getRule_relation()) {
			case "=" : ruleContent += "为"; break;
			case ">" : ruleContent += "大于"; break;
			case "<" : ruleContent += "小于"; break;
			default: System.out.println("jump.To_ruleManagement.execute() switch{relation} wrong");break;
			}
			
			//判断是 类型1 还是类型3
			// 等于3 说明是数值型的
			if(tempRuleField.getField_type().equals("3")){
				ruleContent += tempRuleManagement.getRule_value() + tempRuleField.getField_code();
			} else if(tempRuleField.getField_type().equals("1")){
				String codeNameZH = objCodeModel.GetCodeNameByTableNameAndCode(tempRuleField.getField_code(), tempRuleManagement.getRule_value());
				ruleContent += codeNameZH;
			}
			
			ruleContent += "的专家人数需";
			
			//处理占比percent
			switch (tempRuleManagement.getRule_percentRelation()) {
			case "=" : ruleContent += "占"; break;
			case ">" : ruleContent += "大于"; break;
			case "<" : ruleContent += "小于"; break;
			default: System.out.println("jump.To_ruleManagement.execute() switch{percentRelation} wrong");break;
			}
			ruleContent += "总抽取专家人数的";
			ruleContent += tempRuleManagement.getRule_percent() + "%";
			
			//规则内容覆盖在rule_field中
			tempRuleManagement.setRule_field(ruleContent);
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
