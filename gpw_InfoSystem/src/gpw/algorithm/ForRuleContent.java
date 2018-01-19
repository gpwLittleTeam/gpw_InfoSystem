package gpw.algorithm;

import java.util.ArrayList;
import java.util.List;

import gpw.getInfo.GetRuleField;
import gpw.getInfo.GetRuleManagement;
import gpw.object.CodeModel;
import gpw.object.RuleField;
import gpw.object.RuleManagement;

public class ForRuleContent {
	
	/**
	 * 从数据库中获得当前所有的规则，并且组织成自然语言
	 * @return 所有的自然语言化的规则List
	 */
	public List<String> getRuleContent() {
		List<RuleManagement> listRuleManagements;
		List<String> allRuleContent = new ArrayList<String>();
		GetRuleManagement objGetRuleManagement = new GetRuleManagement();
		listRuleManagements = objGetRuleManagement.getAllRuleManagement();
		GetRuleField objGetRuleField = new GetRuleField();
		CodeModel objCodeModel = new CodeModel();
		
		RuleManagement tempRuleManagement;  //用于暂存每一条规则
		RuleField tempRuleField;
		String ruleContent = "";  //规则的自然语言
		
		
		for(int i=0;i<listRuleManagements.size();i++){
			tempRuleManagement = listRuleManagements.get(i);  //第i条 rule
			tempRuleField = objGetRuleField.getRuleFieldByFieldName(tempRuleManagement.getRule_field());
			
			/*将数据拼装成自然语言*/
			ruleContent = "抽取结果中,";
			ruleContent += tempRuleField.getField_chname();
			
			//处理 = > <
			switch (tempRuleManagement.getRule_relation()) {
			case "==" : ruleContent += "为"; break;
			case ">=" : ruleContent += "大于等于"; break;
			case "<=" : ruleContent += "小于等于"; break;
			default: System.out.println("algorithm.ForRuleContent.getRuleContent() switch{relation} wrong");break;
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
			System.out.println("tempRuleManagement.getRule_percentRelation():" + tempRuleManagement.getRule_percentRelation());
			switch (tempRuleManagement.getRule_percentRelation()) {
			case "==" : ruleContent += "占"; break;
			case ">=" : ruleContent += "大于等于"; break;
			case "<=" : ruleContent += "小于等于"; break;
			default: System.out.println("algorithm.ForRuleContent.getRuleContent() switch{percentRelation} wrong");break;
			}
			ruleContent += "总抽取专家人数的";
			ruleContent += tempRuleManagement.getRule_percent() + "%";
			allRuleContent.add(ruleContent);
		}
		return allRuleContent;
	}
	
	/***
	 * 从形参传入规则，并且组织成自然语言
	 * @param listRuleManagements 需要组成自然语言的规则 
	 * @return
	 */
	public List<String> getRuleContent(List<RuleManagement> listRuleManagements){
		List<String> allRuleContent = new ArrayList<String>();
		GetRuleField objGetRuleField = new GetRuleField();
		CodeModel objCodeModel = new CodeModel();
		
		RuleManagement tempRuleManagement;  //用于暂存每一条规则
		RuleField tempRuleField;
		String ruleContent = "";  //规则的自然语言
		
		
		for(int i=0;i<listRuleManagements.size();i++){
			tempRuleManagement = listRuleManagements.get(i);  //第i条 rule
			tempRuleField = objGetRuleField.getRuleFieldByFieldName(tempRuleManagement.getRule_field());
			
			/*将数据拼装成自然语言*/
			ruleContent = "抽取结果中,";
			ruleContent += tempRuleField.getField_chname();
			
			//处理 = > <
			switch (tempRuleManagement.getRule_relation()) {
			case "==" : ruleContent += "为"; break;
			case ">=" : ruleContent += "大于"; break;
			case "<=" : ruleContent += "小于"; break;
			default: System.out.println("algorithm.ForRuleContent.getRuleContent(List<RuleManagement>) switch{relation} wrong");break;
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
			case "==" : ruleContent += "占"; break;
			case ">=" : ruleContent += "大于"; break;
			case "<=" : ruleContent += "小于"; break;
			default: System.out.println("algorithm.ForRuleContent.getRuleContent(List<RuleManagement>) switch{percentRelation} wrong");break;
			}
			ruleContent += "总抽取专家人数的";
			ruleContent += tempRuleManagement.getRule_percent() + "%";
			allRuleContent.add(ruleContent);
		}
		return allRuleContent;
	}
}
