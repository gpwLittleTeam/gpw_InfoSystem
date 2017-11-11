package gpw.object;

import gpw.connection.LinkDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Engage extends CodeModel{
	public Engage(){
		super();
	}
	
	public Engage(String codeNo, String codeName, String codeComments) {
		super(codeNo, codeName, codeComments);
	}
	
	public List<String> getAllEmploy(){
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		List<String> result = new ArrayList<String>();
		String sqlValue = "select Employ from code_engage";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				result.add(rs.getString("Employ"));
			}
			return result;
		} catch (Exception ex) {
			System.out.println("get all Employ wrong!");
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
	
	public List<String> getAllCode(){
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		List<String> result = new ArrayList<String>();
		String sqlValue = "select code from code_engage";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				result.add(rs.getString("code"));
			}
			return result;
		} catch (Exception ex) {
			System.out.println("get all code wrong!");
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
	
	public List<String> getAllComments(){
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		List<String> result = new ArrayList<String>();
		String sqlValue = "select comments from code_engage";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				result.add(rs.getString("comments"));
			}
			return result;
		} catch (Exception ex) {
			System.out.println("get all comments wrong!");
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
	
	public String getEmployByCode(String code){
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String result = null;
		String sqlValue1 = "select Employ from code_engage where code ='" +code+ "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue1);
			while (rs.next()) {
				result = rs.getString("Employ");
			}
			return result;
		} catch (Exception ex) {
			System.out.println("get Employ by code wrong!");
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
	
	public String getCodeByEmploy(String Employ){
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String result = null;
		String sqlValue1 = "select code from code_engage where Employ ='" +Employ+ "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue1);
			while (rs.next()) {
				result = rs.getString("code");
			}
			return result;
		} catch (Exception ex) {
			System.out.println("get code by Employ wrong!");
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
	
	public String getCommentsByEmploy(String Employ){
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String result = null;
		String sqlValue1 = "select comments from code_engage where Employ ='" +Employ+ "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue1);
			while (rs.next()) {
				result = rs.getString("comments");
			}
			return result;
		} catch (Exception ex) {
			System.out.println("get comments by Employ wrong!");
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
	
	public String getCommentsByCode(String code){
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String result = null;
		String sqlValue1 = "select comments from code_engage where code ='" +code+ "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue1);
			while (rs.next()) {
				result = rs.getString("comments");
			}
			return result;
		} catch (Exception ex) {
			System.out.println("get comments by code wrong!");
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
