package gpw.object;

import gpw.connection.LinkDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Title extends CodeModel{
	public Title(){
		super();
	}
	
	public Title(String codeNo, String codeName, String codeComments) {
		super(codeNo, codeName, codeComments);
	}
	
	public List<String> getAllTitlename(){
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		List<String> result = new ArrayList<String>();
		String sqlValue = "select Titlename from code_title";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				result.add(rs.getString("Titlename"));
			}
			return result;
		} catch (Exception ex) {
			System.out.println("get all Titlename wrong!");
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
		String sqlValue = "select code from code_title";
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
		String sqlValue = "select comments from code_title";
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
	
	public String getTitlenameByCode(String code){
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String result = null;
		String sqlValue1 = "select Titlename from code_title where code ='" +code+ "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue1);
			while (rs.next()) {
				result = rs.getString("Titlename");
			}
			return result;
		} catch (Exception ex) {
			System.out.println("get Titlename by code wrong!");
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
	
	public String getCodeByTitlename(String Titlename){
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String result = null;
		String sqlValue1 = "select code from code_title where Titlename ='" +Titlename+ "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue1);
			while (rs.next()) {
				result = rs.getString("code");
			}
			return result;
		} catch (Exception ex) {
			System.out.println("get code by Titlename wrong!");
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
	
	public String getCommentsByTitlename(String Titlename){
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String result = null;
		String sqlValue1 = "select comments from code_title where Titlename ='" +Titlename+ "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue1);
			while (rs.next()) {
				result = rs.getString("comments");
			}
			return result;
		} catch (Exception ex) {
			System.out.println("get comments by Titlename wrong!");
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
		String sqlValue1 = "select comments from code_title where code ='" +code+ "'";
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
