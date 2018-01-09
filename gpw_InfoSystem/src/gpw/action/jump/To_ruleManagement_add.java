package gpw.action.jump;

import java.util.List;

import freemarker.template.utility.Execute;
import gpw.getInfo.GetRuleField;
import gpw.object.RuleField;
import gpw.object.RuleManagement;

import com.opensymphony.xwork2.ActionSupport;

public class To_ruleManagement_add extends ActionSupport{
	private List<RuleField> listRuleField;
	@Override
	public String execute() throws Exception {
		GetRuleField objGetRuleField = new GetRuleField();
		listRuleField = objGetRuleField.getAllRuleField();
		
		return super.execute();
	}
	
	public List<RuleField> getListRuleField() {
		return listRuleField;
	}
	public void setListRuleField(List<RuleField> listRuleField) {
		this.listRuleField = listRuleField;
	}
}
