package gpw.getInfo;

import gpw.connection.LinkDB;
import gpw.object.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetCounciltitle {
	public GetCounciltitle(){
		
	}
	
	public List<Counciltitle> getAllCounciltitles(){
		List<Counciltitle> result = new ArrayList<Counciltitle>();
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from code_counciltitle";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Counciltitle temp = null;
				String field1 = rs.getString("code");
				String field2 = rs.getString("name");
				String field3 = rs.getString("comments");
				temp = new Counciltitle(field1, field2, field3);
				result.add(temp);
			}
			
			return result;
		} catch (Exception ex) {
			System.out.println("GetCounciltitle.java-getAllCounciltitles() wrong!");
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
	
	public List<Counciltitle> getCounciltitleByCode(String code){
		List<Counciltitle> result = new ArrayList<Counciltitle>();
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from code_counciltitle where code='" + code + "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Counciltitle temp = null;
				String field1 = rs.getString("code");
				String field2 = rs.getString("name");
				String field3 = rs.getString("comments");
				temp = new Counciltitle(field1, field2, field3);
				result.add(temp);
			}
			
			return result;
		} catch (Exception ex) {
			System.out.println("GetCounciltitle.java-getCounciltitleByCode(String) wrong!");
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
	
	public List<Counciltitle> getCounciltitleByName(String name){
		List<Counciltitle> result = new ArrayList<Counciltitle>();
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from code_counciltitle where name = '" + name + "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Counciltitle temp = null;
				String field1 = rs.getString("code");
				String field2 = rs.getString("name");
				String field3 = rs.getString("comments");
				temp = new Counciltitle(field1, field2, field3);
				result.add(temp);
			}
			
			return result;
		} catch (Exception ex) {
			System.out.println("GetCounciltitle.java-getCounciltitleByName(String) wrong!");
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
//		GetCounciltitle test = new GetCounciltitle();
//		System.out.println(test.getAllCounciltitles());
//	}
}