package gpw.object;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import gpw.connection.LinkDB;

public class UserLogin {
	//private String user_id;
	private String user_name;
	private String user_psd;
	private String user_enable;  //0禁用  1启用
	private String user_date;
	private String user_type;
	private String user_jury;
	private String user_dept;
	private String user_tel;
	
	public UserLogin(){
		
	}
	
	public UserLogin(String user_name, String user_psd, String user_enable,
					String user_date, String user_type, String user_jury, String user_dept,
					String user_tel){
		//this.user_id = user_id;
		this.user_name = user_name;
		this.user_psd = user_psd;
		this.user_enable = user_enable;
		this.user_date = user_date;
		this.user_type = user_type;
		this.user_jury = user_jury;
		this.user_dept = user_dept;
		this.user_tel = user_tel;
	}

//	public String getUser_id() {
//		return user_id;
//	}
//
//	public void setUser_id(String user_id) {
//		this.user_id = user_id;
//	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_psd() {
		return user_psd;
	}

	public void setUser_psd(String user_psd) {
		this.user_psd = user_psd;
	}

	public String getUser_enable() {
		return user_enable;
	}

	public void setUser_enable(String user_enable) {
		this.user_enable = user_enable;
	}

	public String getUser_date() {
		return user_date;
	}

	public void setUser_date(String user_date) {
		this.user_date = user_date;
	}

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

	public String getUser_jury() {
		return user_jury;
	}

	public void setUser_jury(String user_jury) {
		this.user_jury = user_jury;
	}

	public String getUser_dept() {
		return user_dept;
	}

	public void setUser_dept(String user_dept) {
		this.user_dept = user_dept;
	}

	public String getUser_tel() {
		return user_tel;
	}

	public void setUser_tel(String user_tel) {
		this.user_tel = user_tel;
	}
	
	
//	public String getIdByName(String name){
//		LinkDB link =  new LinkDB();
//		Connection conn = link.getConn();
//		Statement stmt = null;
//		ResultSet rs = null;
//		String result = null;
//		String sqlValue1 = "select user_id from user_login where user_name ='" +name+ "'";
//		try {
//			stmt = conn.createStatement();
//			rs = stmt.executeQuery(sqlValue1);
//			while (rs.next()) {
//				result = rs.getString("user_id");
//			}
//			return result;
//		} catch (Exception ex) {
//			System.out.println("get id by name wrong!");
//			ex.printStackTrace();
//			return null;
//		} finally {
//			try {
//				if (rs != null) {
//					rs.close();
//				}
//				if (stmt != null) {
//					stmt.close();
//				}
//				if (conn != null) {
//					conn.close();
//				}
//			} catch (SQLException ex) {
//				System.out.println("Close Error!!!!!!");//
//				ex.printStackTrace();
//			}
//		}
//	}
//	
	public String getPsdByName(String name){
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String result = null;
		String sqlValue1 = "select user_psd from user_login where user_name ='" +name+ "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue1);
			while (rs.next()) {
				result = rs.getString("user_psd");
			}
			return result;
		} catch (Exception ex) {
			System.out.println("get psd by name wrong!");
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
	
	public String getEnableByName(String name){
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String result = null;
		String sqlValue1 = "select user_enable from user_login where user_name ='" +name+ "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue1);
			while (rs.next()) {
				result = rs.getString("user_enable");
			}
			return result;
		} catch (Exception ex) {
			System.out.println("get enable by name wrong!");
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
	
	public String getDateByName(String name){
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String result = null;
		String sqlValue1 = "select user_date from user_login where user_name ='" +name+ "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue1);
			while (rs.next()) {
				result = rs.getString("user_date");
			}
			return result;
		} catch (Exception ex) {
			System.out.println("get date by name wrong!");
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
	
	public String getTypeByName(String name){
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String result = null;
		String sqlValue1 = "select user_type from user_login where user_name ='" +name+ "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue1);
			while (rs.next()) {
				result = rs.getString("user_type");
			}
			return result;
		} catch (Exception ex) {
			System.out.println("get type by name wrong!");
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
	
	public String getJuryByName(String name){
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String result = null;
		String sqlValue1 = "select user_jury from user_login where user_name ='" +name+ "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue1);
			while (rs.next()) {
				result = rs.getString("user_jury");
			}
			return result;
		} catch (Exception ex) {
			System.out.println("get jury by name wrong!");
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
	
	public String getDeptByName(String name){
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String result = null;
		String sqlValue1 = "select user_dept from user_login where user_name ='" +name+ "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue1);
			while (rs.next()) {
				result = rs.getString("user_dept");
			}
			return result;
		} catch (Exception ex) {
			System.out.println("get dept by name wrong!");
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
	
	public String getTelByName(String name){
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String result = null;
		String sqlValue1 = "select user_tel from user_login where user_name ='" +name+ "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue1);
			while (rs.next()) {
				result = rs.getString("user_tel");
			}
			return result;
		} catch (Exception ex) {
			System.out.println("get tel by name wrong!");
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
