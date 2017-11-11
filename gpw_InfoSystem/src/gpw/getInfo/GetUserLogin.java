package gpw.getInfo;

import gpw.connection.LinkDB;
import gpw.object.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetUserLogin {
	public GetUserLogin(){
		
	}
	
	public List<UserLogin> getAllUserLogins(){
		List<UserLogin> result = new ArrayList<UserLogin>();
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from user_login";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				UserLogin tempUserLogin = null;
				//String field1 = rs.getString("user_id");
				String field2 = rs.getString("user_name");
				String field3 = rs.getString("user_psd");
				String field4 = rs.getString("user_enable");
				String field5 = rs.getString("user_date");
				String field6 = rs.getString("user_type");
				String field7 = rs.getString("user_jury");
				String field8 = rs.getString("user_dept");
				String field9 = rs.getString("user_tel");
				tempUserLogin = new UserLogin(field2,field3,field4,field5,
											field6,field7,field8,field9);
				result.add(tempUserLogin);
			}
			
			return result;
		} catch (Exception ex) {
			System.out.println("GetUserLogin.java-getAllUserLogins() wrong!");
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
	
	public UserLogin getUserLoginById(int id){
		UserLogin result = null;
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from user_login where user_id='"+id+"'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				//String field1 = rs.getString("user_id");
				String field2 = rs.getString("user_name");
				String field3 = rs.getString("user_psd");
				String field4 = rs.getString("user_enable");
				String field5 = rs.getString("user_date");
				String field6 = rs.getString("user_type");
				String field7 = rs.getString("user_jury");
				String field8 = rs.getString("user_dept");
				String field9 = rs.getString("user_tel");
				result = new UserLogin(field2,field3,field4,field5,
											field6,field7,field8,field9);
			}
			
			return result;
		} catch (Exception ex) {
			System.out.println("GetUserLogin.java-getUserLoginById(int id) wrong!");
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
	
	public UserLogin getUserLoginByUserName(String name){
		UserLogin result = null;
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from user_login where user_name='"+name+"'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				//String field1 = rs.getString("user_id");
				String field2 = rs.getString("user_name");
				String field3 = rs.getString("user_psd");
				String field4 = rs.getString("user_enable");
				String field5 = rs.getString("user_date");
				String field6 = rs.getString("user_type");
				String field7 = rs.getString("user_jury");
				String field8 = rs.getString("user_dept");
				String field9 = rs.getString("user_tel");
				result = new UserLogin(field2,field3,field4,field5,
											field6,field7,field8,field9);
			}
			
			return result;
		} catch (Exception ex) {
			System.out.println("GetUserLogin.java-getUserLoginByUserName(String name) wrong!");
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
	
	public List<UserLogin> getUserLoginByEnable(int enable){
		List<UserLogin> result = new ArrayList<UserLogin>();
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from user_login where user_enable='"+enable+"'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				UserLogin tempUserLogin = null;
				//String field1 = rs.getString("user_id");
				String field2 = rs.getString("user_name");
				String field3 = rs.getString("user_psd");
				String field4 = rs.getString("user_enable");
				String field5 = rs.getString("user_date");
				String field6 = rs.getString("user_type");
				String field7 = rs.getString("user_jury");
				String field8 = rs.getString("user_dept");
				String field9 = rs.getString("user_tel");
				tempUserLogin = new UserLogin(field2,field3,field4,field5,
											field6,field7,field8,field9);
				result.add(tempUserLogin);
			}
			
			return result;
		} catch (Exception ex) {
			System.out.println("GetUserLogin.java-getUserLoginByEnable(int enable) wrong!");
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
	
	public List<UserLogin> getUserLoginByType(int type){
		List<UserLogin> result = new ArrayList<UserLogin>();
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from user_login where user_type='"+type+"'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				UserLogin tempUserLogin = null;
				//String field1 = rs.getString("user_id");
				String field2 = rs.getString("user_name");
				String field3 = rs.getString("user_psd");
				String field4 = rs.getString("user_enable");
				String field5 = rs.getString("user_date");
				String field6 = rs.getString("user_type");
				String field7 = rs.getString("user_jury");
				String field8 = rs.getString("user_dept");
				String field9 = rs.getString("user_tel");
				tempUserLogin = new UserLogin(field2,field3,field4,field5,
											field6,field7,field8,field9);
				result.add(tempUserLogin);
			}
			
			return result;
		} catch (Exception ex) {
			System.out.println("GetUserLogin.java-getUserLoginByType(int type) wrong!");
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
	
	public List<UserLogin> getUserLoginByUserJury(String userJury){
		List<UserLogin> result = new ArrayList<UserLogin>();
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from user_login where user_jury='"+userJury+"'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				UserLogin tempUserLogin = null;
				//String field1 = rs.getString("user_id");
				String field2 = rs.getString("user_name");
				String field3 = rs.getString("user_psd");
				String field4 = rs.getString("user_enable");
				String field5 = rs.getString("user_date");
				String field6 = rs.getString("user_type");
				String field7 = rs.getString("user_jury");
				String field8 = rs.getString("user_dept");
				String field9 = rs.getString("user_tel");
				tempUserLogin = new UserLogin(field2,field3,field4,field5,
											field6,field7,field8,field9);
				result.add(tempUserLogin);
			}
			
			return result;
		} catch (Exception ex) {
			System.out.println("GetUserLogin.java-getUserLoginByUserJury(int userJury) wrong!");
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
	
	public List<UserLogin> getUserLoginByUserDept(String userDept){
		List<UserLogin> result = new ArrayList<UserLogin>();
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from user_login where user_dept='"+userDept+"'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				UserLogin tempUserLogin = null;
				//String field1 = rs.getString("user_id");
				String field2 = rs.getString("user_name");
				String field3 = rs.getString("user_psd");
				String field4 = rs.getString("user_enable");
				String field5 = rs.getString("user_date");
				String field6 = rs.getString("user_type");
				String field7 = rs.getString("user_jury");
				String field8 = rs.getString("user_dept");
				String field9 = rs.getString("user_tel");
				tempUserLogin = new UserLogin(field2,field3,field4,field5,
											field6,field7,field8,field9);
				result.add(tempUserLogin);
			}
			
			return result;
		} catch (Exception ex) {
			System.out.println("GetUserLogin.java-getUserLoginByUserDept(String userDept) wrong!");
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
	
	public List<UserLogin> getUserLoginByUserTel(String userTel){
		List<UserLogin> result = new ArrayList<UserLogin>();
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from user_login where user_tel='"+userTel+"'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				UserLogin tempUserLogin = null;
				//String field1 = rs.getString("user_id");
				String field2 = rs.getString("user_name");
				String field3 = rs.getString("user_psd");
				String field4 = rs.getString("user_enable");
				String field5 = rs.getString("user_date");
				String field6 = rs.getString("user_type");
				String field7 = rs.getString("user_jury");
				String field8 = rs.getString("user_dept");
				String field9 = rs.getString("user_tel");
				tempUserLogin = new UserLogin(field2,field3,field4,field5,
											field6,field7,field8,field9);
				result.add(tempUserLogin);
			}
			
			return result;
		} catch (Exception ex) {
			System.out.println("GetUserLogin.java-getUserLoginByUserTel(String userTel) wrong!");
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
	
//	public static void main(String args[]){
//		GetUserLogin test = new GetUserLogin();
//		System.out.println(test.getAllUserLogins().get(0).getUser_dept());
//	}
}
