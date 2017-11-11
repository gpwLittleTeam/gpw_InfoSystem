package gpw.getInfo;

import gpw.connection.LinkDB;
import gpw.object.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetDegree {
	public GetDegree(){
		
	}
	
	public List<Degree> getAllDegrees(){
		List<Degree> result = new ArrayList<Degree>();
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from code_degree";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Degree temp = null;
				String field1 = rs.getString("code");
				String field2 = rs.getString("degree");
				String field3 = rs.getString("comments");
				temp = new Degree(field1, field2, field3);
				result.add(temp);
			}
			
			return result;
		} catch (Exception ex) {
			System.out.println("GetDegree.java-getAllDegrees() wrong!");
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
	
	public List<Degree> getDegreeByCode(String code){
		List<Degree> result = new ArrayList<Degree>();
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from code_degree where code='" + code + "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Degree temp = null;
				String field1 = rs.getString("code");
				String field2 = rs.getString("degree");
				String field3 = rs.getString("comments");
				temp = new Degree(field1, field2, field3);
				result.add(temp);
			}
			
			return result;
		} catch (Exception ex) {
			System.out.println("GetDegree.java-getDegreeByCode(String) wrong!");
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
	
	public List<Degree> getDegreeByDegree(String degree){
		List<Degree> result = new ArrayList<Degree>();
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from code_degree where degree = '" + degree + "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Degree temp = null;
				String field1 = rs.getString("code");
				String field2 = rs.getString("degree");
				String field3 = rs.getString("comments");
				temp = new Degree(field1, field2, field3);
				result.add(temp);
			}
			
			return result;
		} catch (Exception ex) {
			System.out.println("GetDegree.java-getDegreeByDegree(String) wrong!");
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
//		GetDegree test = new GetDegree();
//		System.out.println(test.getAllDegrees());
//	}
}