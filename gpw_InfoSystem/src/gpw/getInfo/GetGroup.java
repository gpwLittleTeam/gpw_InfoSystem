package gpw.getInfo;

import gpw.connection.LinkDB;
import gpw.object.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetGroup {
	public GetGroup(){
	}
	
	public List<Group> getAllGroups(){
		List<Group> result = new ArrayList<Group>();
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from group_dept";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Group tempGroup = null;
				String field2 = rs.getString("Group_no");
				String field3 = rs.getString("Group_name");
				String field4 = rs.getString("Group_jury");
				String field5 = rs.getString("Group_date");
				String field6 = rs.getString("Group_comm");
				tempGroup = new Group(field2, field3, field4, field5,
										field6);
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
	
	/*public List<Group> getGroupById(int id){
		List<Group> tempTablestrus = new ArrayList<Group>();
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from group_dept where Group_id='"+id+"'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Group tempGroup = null;
				String field2 = rs.getString("Group_no");
				String field3 = rs.getString("Group_name");
				String field4 = rs.getString("Group_jury");
				String field5 = rs.getString("Group_date");
				String field6 = rs.getString("Group_comm");
				tempGroup = new Group(field2, field3, field4, field5,
										field6);
				tempTablestrus.add(tempGroup);
			}
			
			return tempTablestrus;
		} catch (Exception ex) {
			System.out.println("GetGroup.java-getGroupById() wrong!");
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
	*/
	public List<Group> getGroupByName(String name){
		List<Group> tempTablestrus = new ArrayList<Group>();
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from group_dept where Group_name='"+name+"'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Group tempGroup = null;
				//String field1 = rs.getString("Group_id");
				String field2 = rs.getString("Group_no");
				String field3 = rs.getString("Group_name");
				String field4 = rs.getString("Group_jury");
				String field5 = rs.getString("Group_date");
				String field6 = rs.getString("Group_comm");
				tempGroup = new Group( field2, field3, field4, field5,
										field6);
				tempTablestrus.add(tempGroup);
			}
			
			return tempTablestrus;
		} catch (Exception ex) {
			System.out.println("GetGroup.java-getGroupByName() wrong!");
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
	
	public List<Group> getGroupByNo(String no){
		List<Group> tempTablestrus = new ArrayList<Group>();
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from group_dept where Group_no='"+no+"'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Group tempGroup = null;
				//String field1 = rs.getString("Group_id");
				String field2 = rs.getString("Group_no");
				String field3 = rs.getString("Group_name");
				String field4 = rs.getString("Group_jury");
				String field5 = rs.getString("Group_date");
				String field6 = rs.getString("Group_comm");
				tempGroup = new Group( field2, field3, field4, field5,
										field6);
				tempTablestrus.add(tempGroup);
			}
			
			return tempTablestrus;
		} catch (Exception ex) {
			System.out.println("GetGroup.java-getGroupByNo() wrong!");
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
	
	public List<Group> getGroupByJury(String juryNo){
		List<Group> tempTablestrus = new ArrayList<Group>();
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from group_dept where Group_jury='"+juryNo+"'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Group tempGroup = null;
				//String field1 = rs.getString("Group_id");
				String field2 = rs.getString("Group_no");
				String field3 = rs.getString("Group_name");
				String field4 = rs.getString("Group_jury");
				String field5 = rs.getString("Group_date");
				String field6 = rs.getString("Group_comm");
				tempGroup = new Group(field2, field3, field4, field5,
										field6);
				tempTablestrus.add(tempGroup);
			}
			
			return tempTablestrus;
		} catch (Exception ex) {
			System.out.println("GetGroup.java-getGroupByJury() wrong!");
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
	
//	public static void main(String args[]){
//		GetGroup test = new GetGroup();
//		System.out.println(test.getGroupByNo(no));
//	}
}
