package gpw.object;

import gpw.connection.LinkDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
//专业组CODE
public class Group extends CodeModel{
	private String Group_no;
	private String Group_name;
	private String Group_jury;
	private String Group_date;
	private String Group_comm;
	
	public Group(){
	}
	
	public Group(String Group_no, String Group_name,
			String Group_jury, String Group_date, String Group_comm){
		this.Group_no = Group_no;
		this.Group_name = Group_name;
		this.Group_jury = Group_jury;
		this.Group_date = Group_date;
		this.Group_comm = Group_comm;
	}

	public String getGroup_no() {
		return Group_no;
	}

	public void setGroup_no(String group_no) {
		Group_no = group_no;
	}

	public String getGroup_name() {
		return Group_name;
	}

	public void setGroup_name(String group_name) {
		Group_name = group_name;
	}

	public String getGroup_jury() {
		return Group_jury;
	}

	public void setGroup_jury(String group_jury) {
		Group_jury = group_jury;
	}

	public String getGroup_date() {
		return Group_date;
	}

	public void setGroup_date(String group_date) {
		Group_date = group_date;
	}

	public String getGroup_comm() {
		return Group_comm;
	}

	public void setGroup_comm(String group_comm) {
		Group_comm = group_comm;
	}
	
	public List<String> getAllGroupNo(){
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		List<String> result = new ArrayList<String>();
		String sqlValue = "select Group_no from group_dept";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				result.add(rs.getString("Group_no"));
			}
			return result;
		} catch (Exception ex) {
			System.out.println("get all group_no wrong!");
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
				ex.printStackTrace();
			}
		}
	}
	
	public List<String> getAllGroupName(){
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		List<String> result = new ArrayList<String>();
		String sqlValue = "select Group_name from group_dept";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				result.add(rs.getString("Group_name"));
			}
			return result;
		} catch (Exception ex) {
			System.out.println("get all group_name wrong!");
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
				ex.printStackTrace();
			}
		}
	}
	
	public List<String> getAllGroupJury(){
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		List<String> result = new ArrayList<String>();
		String sqlValue = "select Group_jury from group_dept";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				result.add(rs.getString("Group_jury"));
			}
			return result;
		} catch (Exception ex) {
			System.out.println("get all group_jury wrong!");
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
				ex.printStackTrace();
			}
		}
	}
	
	public List<String> getAllGroupDate(){
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		List<String> result = new ArrayList<String>();
		String sqlValue = "select Group_date from group_dept";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				result.add(rs.getString("Group_date"));
			}
			return result;
		} catch (Exception ex) {
			System.out.println("get all group_date wrong!");
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
				ex.printStackTrace();
			}
		}
	}
	
	public List<String> getAllGroupComm(){
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		List<String> result = new ArrayList<String>();
		String sqlValue = "select Group_comm from group_dept";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				result.add(rs.getString("Group_comm"));
			}
			return result;
		} catch (Exception ex) {
			System.out.println("get all group_comm wrong!");
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
				ex.printStackTrace();
			}
		}
	}
	
	public String getGroupNameByGroupNo(String groupNo){
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String result = null;
		String sqlValue1 = "select Group_name from group_dept where Group_no ='" +groupNo+ "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue1);
			while (rs.next()) {
				result = rs.getString("Group_name");
			}
			return result;
		} catch (Exception ex) {
			System.out.println("get group_name by group_no wrong!");
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
				ex.printStackTrace();
			}
		}
	}
	
	public String getGroupJuryByGroupNo(String groupNo){
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String result = null;
		String sqlValue1 = "select Group_jury from group_dept where Group_no ='" +groupNo+ "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue1);
			while (rs.next()) {
				result = rs.getString("Group_jury");
			}
			return result;
		} catch (Exception ex) {
			System.out.println("get Group_jury by group_no wrong!");
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
				ex.printStackTrace();
			}
		}
	}
	
	public String getGroupDateByGroupNo(String groupNo){
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String result = null;
		String sqlValue1 = "select Group_date from group_dept where Group_no ='" +groupNo+ "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue1);
			while (rs.next()) {
				result = rs.getString("Group_date");
			}
			return result;
		} catch (Exception ex) {
			System.out.println("get Group_date by group_no wrong!");
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
				ex.printStackTrace();
			}
		}
	}
	
	public String getGroupCommByGroupNo(String groupNo){
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String result = null;
		String sqlValue1 = "select Group_comm from group_dept where Group_no ='" +groupNo+ "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue1);
			while (rs.next()) {
				result = rs.getString("Group_comm");
			}
			return result;
		} catch (Exception ex) {
			System.out.println("get group_name by group_no wrong!");
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
				ex.printStackTrace();
			}
		}
	}
	
	public String getGroupNameByGroupName(String groupName){
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String result = null;
		String sqlValue1 = "select Group_name from group_dept where Group_name ='" +groupName+ "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue1);
			while (rs.next()) {
				result = rs.getString("Group_name");
			}
			return result;
		} catch (Exception ex) {
			System.out.println("get group_name by Group_name wrong!");
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
				ex.printStackTrace();
			}
		}
	}
	
	public String getGroupJuryByGroupName(String groupName){
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String result = null;
		String sqlValue1 = "select Group_jury from group_dept where Group_name ='" +groupName+ "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue1);
			while (rs.next()) {
				result = rs.getString("Group_jury");
			}
			return result;
		} catch (Exception ex) {
			System.out.println("get Group_jury by Group_name wrong!");
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
				ex.printStackTrace();
			}
		}
	}
	
	public String getGroupDateByGroupName(String groupName){
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String result = null;
		String sqlValue1 = "select Group_date from group_dept where Group_name ='" +groupName+ "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue1);
			while (rs.next()) {
				result = rs.getString("Group_date");
			}
			return result;
		} catch (Exception ex) {
			System.out.println("get Group_date by Group_name wrong!");
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
				ex.printStackTrace();
			}
		}
	}
	
	public String getGroupCommByGroupName(String groupName){
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String result = null;
		String sqlValue1 = "select Group_comm from group_dept where Group_name ='" +groupName+ "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue1);
			while (rs.next()) {
				result = rs.getString("Group_comm");
			}
			return result;
		} catch (Exception ex) {
			System.out.println("get group_name by Group_name wrong!");
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
				ex.printStackTrace();
			}
		}
	}
	
	public String getGroupNoByGroupName(String groupName){
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String result = null;
		String sqlValue1 = "select Group_no from group_dept where Group_name ='" +groupName+ "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue1);
			while (rs.next()) {
				result = rs.getString("Group_no");
			}
			return result;
		} catch (Exception ex) {
			System.out.println("get group_name by group_no wrong!");
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
				ex.printStackTrace();
			}
		}
	}
}