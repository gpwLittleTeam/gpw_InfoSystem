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
}
