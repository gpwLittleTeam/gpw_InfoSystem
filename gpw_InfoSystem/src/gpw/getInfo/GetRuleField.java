package gpw.getInfo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import gpw.connection.LinkDB;
import gpw.object.RuleField;

public class GetRuleField {
	public List<RuleField> getAllRuleField(){
		List<RuleField> result = new ArrayList<RuleField>();  
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from rule_field";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				RuleField objRuleField = null;
				String field1 = rs.getString("field_name");
				String field2 = rs.getString("field_chname");
				String field3 = rs.getString("field_type");
				String field4 = rs.getString("field_code");
				objRuleField = new RuleField(field1, field2, field3, field4);
				result.add(objRuleField);
			}
			return result;
		} catch (Exception ex) {
			System.out.println("GetRuleField.getAllRuleField() wrong!");
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
	
	public RuleField getRuleFieldByFieldName(String fieldName){
		RuleField result = null;  
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from rule_field where field_name = '" + fieldName + "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				String field1 = rs.getString("field_name");
				String field2 = rs.getString("field_chname");
				String field3 = rs.getString("field_type");
				String field4 = rs.getString("field_code");
				result = new RuleField(field1, field2, field3, field4);
			}
			return result;
		} catch (Exception ex) {
			System.out.println("GetRuleField.getRuleFieldByFieldName() wrong!");
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
