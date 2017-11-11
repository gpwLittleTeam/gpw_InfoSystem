package gpw.getInfo;

import gpw.connection.LinkDB;
import gpw.object.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetUserField {
	public GetUserField(){
		
	}
	
	public List<UserField> getAllUserFields(){
		List<UserField> result = new ArrayList<UserField>();
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from user_field";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				UserField tempUserField = null;
				String id = rs.getString("user_id");
				String field1 = rs.getString("Expert_Field1");
				String field2 = rs.getString("Expert_Field2");
				String field3 = rs.getString("Expert_Field3");
				String field4 = rs.getString("Expert_Field4");
				String field5 = rs.getString("Expert_Field5");
				String field6 = rs.getString("Expert_Field6");
				String field7 = rs.getString("Expert_Field7");
				String field8 = rs.getString("Expert_Field8");
				String field9 = rs.getString("Expert_Field9");
				String field10 = rs.getString("Expert_Field10");
				String field11 = rs.getString("Expert_Field11");
				String field12 = rs.getString("Expert_Field12");
				String field13 = rs.getString("Expert_Field13");
				String field14 = rs.getString("Expert_Field14");
				String field15 = rs.getString("Expert_Field15");
				String field16 = rs.getString("Expert_Field16");
				String field17 = rs.getString("Expert_Field17");
				String field18 = rs.getString("Expert_Field18");
				String field19 = rs.getString("Expert_Field19");
				String field20 = rs.getString("Expert_Field20");
				String field21 = rs.getString("Expert_Field21");
				String field22 = rs.getString("Expert_Field22");
				String field23 = rs.getString("Expert_Field23");
				String field24 = rs.getString("Expert_Field24");
				String field25 = rs.getString("Expert_Field25");
				String field26 = rs.getString("Expert_Field26");
				String field27 = rs.getString("Expert_Field27");
				String field28 = rs.getString("Expert_Field28");
				String field29 = rs.getString("Expert_Field29");
				String field30 = rs.getString("Expert_Field30");
				String field31 = rs.getString("Expert_Field31");
				String field32 = rs.getString("Expert_Field32");
				String field33 = rs.getString("Expert_Field33");
				String field34 = rs.getString("Expert_Field34");
				String field35 = rs.getString("Expert_Field35");
				tempUserField = new UserField(id,field1, field2, field3, field4, field5,
										field6, field7, field8, field9, field10,
										field11, field12, field13, field14, field15,
										field16, field17, field18, field19, field20,
										field21, field22, field23, field24, field25, 
										field26, field27, field28, field29, field30, 
										field31, field32, field33, field34, field35);
				result.add(tempUserField);
			}
			
			return result;
		} catch (Exception ex) {
			System.out.println("GetUserField.java-getAllUserFields() wrong!");
			//ex.printStackTrace();
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
	
	public List<UserField> getUserFieldsById(int userId){
		List<UserField> result = new ArrayList<UserField>();
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from user_field where user_id='"+userId+"'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				UserField tempUserField = null;
				String id = rs.getString("user_id");
				String field1 = rs.getString("Expert_Field1");
				String field2 = rs.getString("Expert_Field2");
				String field3 = rs.getString("Expert_Field3");
				String field4 = rs.getString("Expert_Field4");
				String field5 = rs.getString("Expert_Field5");
				String field6 = rs.getString("Expert_Field6");
				String field7 = rs.getString("Expert_Field7");
				String field8 = rs.getString("Expert_Field8");
				String field9 = rs.getString("Expert_Field9");
				String field10 = rs.getString("Expert_Field10");
				String field11 = rs.getString("Expert_Field11");
				String field12 = rs.getString("Expert_Field12");
				String field13 = rs.getString("Expert_Field13");
				String field14 = rs.getString("Expert_Field14");
				String field15 = rs.getString("Expert_Field15");
				String field16 = rs.getString("Expert_Field16");
				String field17 = rs.getString("Expert_Field17");
				String field18 = rs.getString("Expert_Field18");
				String field19 = rs.getString("Expert_Field19");
				String field20 = rs.getString("Expert_Field20");
				String field21 = rs.getString("Expert_Field21");
				String field22 = rs.getString("Expert_Field22");
				String field23 = rs.getString("Expert_Field23");
				String field24 = rs.getString("Expert_Field24");
				String field25 = rs.getString("Expert_Field25");
				String field26 = rs.getString("Expert_Field26");
				String field27 = rs.getString("Expert_Field27");
				String field28 = rs.getString("Expert_Field28");
				String field29 = rs.getString("Expert_Field29");
				String field30 = rs.getString("Expert_Field30");
				String field31 = rs.getString("Expert_Field31");
				String field32 = rs.getString("Expert_Field32");
				String field33 = rs.getString("Expert_Field33");
				String field34 = rs.getString("Expert_Field34");
				String field35 = rs.getString("Expert_Field35");
				tempUserField = new UserField(id,field1, field2, field3, field4, field5,
										field6, field7, field8, field9, field10,
										field11, field12, field13, field14, field15,
										field16, field17, field18, field19, field20,
										field21, field22, field23, field24, field25, 
										field26, field27, field28, field29, field30, 
										field31, field32, field33, field34, field35);
				result.add(tempUserField);
			}
			
			return result;
		} catch (Exception ex) {
			System.out.println("GetUserField.java-getUserFieldsById(int userId) wrong!");
			//ex.printStackTrace();
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
