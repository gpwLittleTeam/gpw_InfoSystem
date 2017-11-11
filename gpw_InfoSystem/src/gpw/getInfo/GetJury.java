package gpw.getInfo;

import gpw.connection.LinkDB;
import gpw.object.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetJury {
	public GetJury(){
		
	}
	
	public List<Jury> getAllJurys(){
		List<Jury> result = new ArrayList<Jury>();
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from jury_dept";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Jury tempGroup = null;
				String field1 = rs.getString("Jury_no");
				String field2 = rs.getString("Jury_name");
				String field3 = rs.getString("Jury_type");
				String field4 = rs.getString("Jury_power");
				String field5 = rs.getString("Jury_qualiname");
				String field6 = rs.getString("Jury_dept");
				String field7 = rs.getString("Jury_comments");
				String field8 = rs.getString("Jury_date");
				tempGroup = new Jury(field1, field2, field3, field4, field5,
										field6, field7, field8);
				result.add(tempGroup);
			}
			
			return result;
		} catch (Exception ex) {
			System.out.println("GetGroup.java-getAllGroups() wrong!");
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
	
/*	public static void main(String args[]){
		GetJury test = new GetJury();
		System.out.println(test.getJuryByNo("0101").get(0).getJury_comments());
	}
	*/
	public Jury getJuryByNo(String no){
		Jury result = new Jury();
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from jury_dept where Jury_no='"+no+"'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				String field1 = rs.getString("Jury_no");
				String field2 = rs.getString("Jury_name");
				String field3 = rs.getString("Jury_type");
				String field4 = rs.getString("Jury_power");
				String field5 = rs.getString("Jury_qualiname");
				String field6 = rs.getString("Jury_dept");
				String field7 = rs.getString("Jury_comments");
				String field8 = rs.getString("Jury_date");
				result = new Jury(field1, field2, field3, field4, field5,
										field6, field7, field8);
			}
			
			return result;
		} catch (Exception ex) {
			System.out.println("GetJury.java-getJuryByNo(String) wrong!");
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
	
	public List<Jury> getJuryByName(String name){
		List<Jury> result = new ArrayList<Jury>();
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from jury_dept where Jury_name='"+name+"'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Jury tempGroup = null;
				String field1 = rs.getString("Jury_no");
				String field2 = rs.getString("Jury_name");
				String field3 = rs.getString("Jury_type");
				String field4 = rs.getString("Jury_power");
				String field5 = rs.getString("Jury_qualiname");
				String field6 = rs.getString("Jury_dept");
				String field7 = rs.getString("Jury_comments");
				String field8 = rs.getString("Jury_date");
				tempGroup = new Jury(field1, field2, field3, field4, field5,
										field6, field7, field8);
				result.add(tempGroup);
			}
			
			return result;
		} catch (Exception ex) {
			System.out.println("GetJury.java-getJuryByName(String) wrong!");
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
	
	public List<Jury> getJuryByType(int type){
		List<Jury> result = new ArrayList<Jury>();
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from jury_dept where Jury_type='"+type+"'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Jury tempGroup = null;
				String field1 = rs.getString("Jury_no");
				String field2 = rs.getString("Jury_name");
				String field3 = rs.getString("Jury_type");
				String field4 = rs.getString("Jury_power");
				String field5 = rs.getString("Jury_qualiname");
				String field6 = rs.getString("Jury_dept");
				String field7 = rs.getString("Jury_comments");
				String field8 = rs.getString("Jury_date");
				tempGroup = new Jury(field1, field2, field3, field4, field5,
										field6, field7, field8);
				result.add(tempGroup);
			}
			
			return result;
		} catch (Exception ex) {
			System.out.println("GetJury.java-getJuryByType(int) wrong!");
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
	
	public List<Jury> getJuryByPower(int power){
		List<Jury> result = new ArrayList<Jury>();
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from jury_dept where Jury_power='"+power+"'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Jury tempGroup = null;
				String field1 = rs.getString("Jury_no");
				String field2 = rs.getString("Jury_name");
				String field3 = rs.getString("Jury_type");
				String field4 = rs.getString("Jury_power");
				String field5 = rs.getString("Jury_qualiname");
				String field6 = rs.getString("Jury_dept");
				String field7 = rs.getString("Jury_comments");
				String field8 = rs.getString("Jury_date");
				tempGroup = new Jury(field1, field2, field3, field4, field5,
										field6, field7, field8);
				result.add(tempGroup);
			}
			
			return result;
		} catch (Exception ex) {
			System.out.println("GetJury.java-getJuryByPower(int) wrong!");
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
