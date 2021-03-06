package gpw.getInfo;

import gpw.connection.LinkDB;
import gpw.object.RuleManagement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetRuleManagement {
	/**
	 * 返回数据库中所有的规则
	 * @return
	 */
	public List<RuleManagement> getAllRuleManagement(){
		List<RuleManagement> result = new ArrayList<RuleManagement>();  
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from rule_management";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				RuleManagement objRuleManagement = null;
				String field1 = rs.getString("rule_no");
				String field2 = rs.getString("rule_relation");
				String field3 = rs.getString("rule_value");
				String field4 = rs.getString("rule_percent");
				String field5 = rs.getString("rule_percentRelation");
				String field6 = rs.getString("rule_range");
				String field7 = rs.getString("rule_force");
				String field8 = rs.getString("rule_enabled");
				String field9 = rs.getString("rule_field");
				objRuleManagement = new RuleManagement(field1,field9,field2,field3,field4,field5,field6,field7,field8);
				result.add(objRuleManagement);
			}
			return result;
		} catch (Exception ex) {
			System.out.println("GetRuleManagement.getAllRuleManagement() wrong!");
			ex.printStackTrace();
			return null;
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException ex) {
				System.out.println("Close Error!!!!!!");//
				//ex.printStackTrace();
			}
		}
	}
	
	/**
	 * 得到满足该评审权限的规则
	 * @param JuryPower 评审权限代码 Code
	 * @return 规则List
	 */
	public List<RuleManagement> getAllRuleManagementByJuryPower(String JuryPower){
		List<RuleManagement> result = new ArrayList<RuleManagement>();  
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from rule_management where rule_range % " + JuryPower + " = 0";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				RuleManagement objRuleManagement = null;
				String field1 = rs.getString("rule_no");
				String field2 = rs.getString("rule_relation");
				String field3 = rs.getString("rule_value");
				String field4 = rs.getString("rule_percent");
				String field5 = rs.getString("rule_percentRelation");
				String field6 = rs.getString("rule_range");
				String field7 = rs.getString("rule_force");
				String field8 = rs.getString("rule_enabled");
				String field9 = rs.getString("rule_field");
				objRuleManagement = new RuleManagement(field1,field9,field2,field3,field4,field5,field6,field7,field8);
				result.add(objRuleManagement);
			}
			return result;
		} catch (Exception ex) {
			System.out.println("GetRuleManagement.getRuleManagementByJuryPower() wrong!");
			ex.printStackTrace();
			return null;
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException ex) {
				System.out.println("Close Error!!!!!!");//
				//ex.printStackTrace();
			}
		}
	}
	
	/**
	 * 得到满足该评审权限且启用的所有规则
	 * @param JuryPower JuryPower 评审权限代码 Code
	 * @return 规则List
	 */
	public List<RuleManagement> getEnabledRuleManagementByJuryPower(String JuryPower){
		List<RuleManagement> result = new ArrayList<RuleManagement>();  
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from rule_management where rule_range % " + JuryPower + " = 0 and rule_enabled = 1";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				RuleManagement objRuleManagement = null;
				String field1 = rs.getString("rule_no");
				String field2 = rs.getString("rule_relation");
				String field3 = rs.getString("rule_value");
				String field4 = rs.getString("rule_percent");
				String field5 = rs.getString("rule_percentRelation");
				String field6 = rs.getString("rule_range");
				String field7 = rs.getString("rule_force");
				String field8 = rs.getString("rule_enabled");
				String field9 = rs.getString("rule_field");
				objRuleManagement = new RuleManagement(field1,field9,field2,field3,field4,field5,field6,field7,field8);
				result.add(objRuleManagement);
			}
			return result;
		} catch (Exception ex) {
			System.out.println("GetRuleManagement.getRuleManagementByJuryPower() wrong!");
			ex.printStackTrace();
			return null;
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException ex) {
				System.out.println("Close Error!!!!!!");//
				//ex.printStackTrace();
			}
		}
	}
	
	/**
	 * 得到满足该评审权限下的所有强制要求使用的规则
	 * @param JuryPower 评审权限
	 * @return
	 */
	public List<RuleManagement> getForceRuleManagementByJuryPower(String JuryPower){
		List<RuleManagement> result = new ArrayList<RuleManagement>();  
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from rule_management where rule_range % " + JuryPower + " = 0 and rule_force = 1";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				RuleManagement objRuleManagement = null;
				String field1 = rs.getString("rule_no");
				String field2 = rs.getString("rule_relation");
				String field3 = rs.getString("rule_value");
				String field4 = rs.getString("rule_percent");
				String field5 = rs.getString("rule_percentRelation");
				String field6 = rs.getString("rule_range");
				String field7 = rs.getString("rule_force");
				String field8 = rs.getString("rule_enabled");
				String field9 = rs.getString("rule_field");
				objRuleManagement = new RuleManagement(field1,field9,field2,field3,field4,field5,field6,field7,field8);
				result.add(objRuleManagement);
			}
			return result;
		} catch (Exception ex) {
			System.out.println("GetRuleManagement.getForceRuleManagementByJuryPower() wrong!");
			ex.printStackTrace();
			return null;
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException ex) {
				System.out.println("Close Error!!!!!!");//
				//ex.printStackTrace();
			}
		}
	}
	
	public List<RuleManagement> getRuleManagementByRuleNo(List<String> ruleNo){
		List<RuleManagement> result = new ArrayList<RuleManagement>();  
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		List<String> sqlValue = new ArrayList<String>();
		//方式ruleNo为空，即information manager一个规则都没有选
		if(ruleNo == null){
			ruleNo = new ArrayList<String>();
		}
		for(int i=0;i<ruleNo.size();i++){
			sqlValue.add("select * from rule_management where rule_no = '" + ruleNo.get(i) + "'");
			//System.out.println(sqlValue.get(i));
		}
		try {
			stmt = conn.createStatement();
			for(int i=0;i<ruleNo.size();i++){
				rs = stmt.executeQuery(sqlValue.get(i));
				while (rs.next()) {
					RuleManagement objRuleManagement = null;
					String field1 = rs.getString("rule_no");
					String field2 = rs.getString("rule_relation");
					String field3 = rs.getString("rule_value");
					String field4 = rs.getString("rule_percent");
					String field5 = rs.getString("rule_percentRelation");
					String field6 = rs.getString("rule_range");
					String field7 = rs.getString("rule_force");
					String field8 = rs.getString("rule_enabled");
					String field9 = rs.getString("rule_field");
					objRuleManagement = new RuleManagement(field1,field9,field2,field3,field4,field5,field6,field7,field8);
					result.add(objRuleManagement);
				}
			}
			return result;
		} catch (Exception ex) {
			System.out.println("GetRuleManagement.GetRuleManagementByRuleNo(List<String>) wrong!");
			ex.printStackTrace();
			return null;
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException ex) {
				System.out.println("Close Error!!!!!!");//
				//ex.printStackTrace();
			}
		}
	}
	
	public RuleManagement getRuleManagementByRuleNo(String ruleNo){
		RuleManagement result = new RuleManagement();  
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue;
		sqlValue = "select * from rule_management where rule_no = '" + ruleNo + "'";
		try {
			stmt = conn.createStatement();
		
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				RuleManagement objRuleManagement = null;
				String field1 = rs.getString("rule_no");
				String field2 = rs.getString("rule_relation");
				String field3 = rs.getString("rule_value");
				String field4 = rs.getString("rule_percent");
				String field5 = rs.getString("rule_percentRelation");
				String field6 = rs.getString("rule_range");
				String field7 = rs.getString("rule_force");
				String field8 = rs.getString("rule_enabled");
				String field9 = rs.getString("rule_field");
				objRuleManagement = new RuleManagement(field1,field9,field2,field3,field4,field5,field6,field7,field8);
				result = objRuleManagement;
			}
			return result;
		} catch (Exception ex) {
			System.out.println("GetRuleManagement.GetRuleManagementByRuleNo(String) wrong!");
			ex.printStackTrace();
			return null;
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException ex) {
				System.out.println("Close Error!!!!!!");//
				//ex.printStackTrace();
			}
		}
	}
}
