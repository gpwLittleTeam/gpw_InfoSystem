package gpw.action.jump;

import java.util.ArrayList;
import java.util.List;

import freemarker.template.utility.Execute;
import gpw.algorithm.GenerateNo;
import gpw.getInfo.GetPermission;
import gpw.getInfo.GetRuleField;
import gpw.object.Permission;
import gpw.object.RuleField;
import gpw.object.RuleManagement;

import com.opensymphony.xwork2.ActionSupport;

public class To_ruleManagement_add extends ActionSupport{
	private List<RuleField> listRuleField;
	private List<Permission> listPermissions;
	private String ruleNo;
	@Override
	public String execute() throws Exception {
		GetRuleField objGetRuleField = new GetRuleField();
		listRuleField = objGetRuleField.getAllRuleField();
		
		GetPermission objGetPermission = new GetPermission();
		listPermissions = objGetPermission.GetAllPermission();
		
		GenerateNo objGenerateNo = new GenerateNo();
		ruleNo = objGenerateNo.generateRuleNo();
		
		return super.execute();
	}
	
	public List<RuleField> getListRuleField() {
		return listRuleField;
	}
	public void setListRuleField(List<RuleField> listRuleField) {
		this.listRuleField = listRuleField;
	}

	public List<Permission> getListPermissions() {
		return listPermissions;
	}

	public void setListPermissions(List<Permission> listPermissions) {
		this.listPermissions = listPermissions;
	}

	public String getRuleNo() {
		return ruleNo;
	}

	public void setRuleNo(String ruleNo) {
		this.ruleNo = ruleNo;
	}
}
