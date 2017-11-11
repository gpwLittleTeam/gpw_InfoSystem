package gpw.getInfo;

import gpw.connection.LinkDB;
import gpw.object.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetGrouptitle {
	public GetGrouptitle(){
		
	}
	
	public List<Grouptitle> getAllGrouptitles(){
		List<Grouptitle> result = new ArrayList<Grouptitle>();
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from code_grouptitle";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Grouptitle temp = null;
				String field1 = rs.getString("code");
				String field2 = rs.getString("post");
				String field3 = rs.getString("comments");
				temp = new Grouptitle(field1, field2,field3);
				result.add(temp);
			}
			
			return result;
		} catch (Exception ex) {
			System.out.println("GetGrouptitle.java-getAllGrouptitles() wrong!");
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
	
	public List<Grouptitle> getGrouptitleByCode(String code){
		List<Grouptitle> result = new ArrayList<Grouptitle>();
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from code_grouptitle where code='" + code + "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Grouptitle temp = null;
				String field1 = rs.getString("code");
				String field2 = rs.getString("post");
				String field3 = rs.getString("comments");
				temp = new Grouptitle(field1, field2,field3);
				result.add(temp);
			}
			
			return result;
		} catch (Exception ex) {
			System.out.println("GetGrouptitle.java-getGrouptitleByCode(String) wrong!");
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
	
	public List<Grouptitle> getGrouptitleByPost(String post){
		List<Grouptitle> result = new ArrayList<Grouptitle>();
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from code_grouptitle where post = '" + post + "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Grouptitle temp = null;
				String field1 = rs.getString("code");
				String field2 = rs.getString("post");
				String field3 = rs.getString("comments");
				temp = new Grouptitle(field1, field2,field3);
				result.add(temp);
			}
			
			return result;
		} catch (Exception ex) {
			System.out.println("GetGrouptitle.java-getGrouptitleByPost(String) wrong!");
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
//		GetGrouptitle test = new GetGrouptitle();
//		System.out.println(test.getAllGrouptitles());
//	}
}