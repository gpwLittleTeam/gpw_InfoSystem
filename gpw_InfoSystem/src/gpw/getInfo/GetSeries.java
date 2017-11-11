package gpw.getInfo;

import gpw.connection.LinkDB;
import gpw.object.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetSeries {
	public GetSeries(){
		
	}
	
	public List<Series> getAllSeriess(){
		List<Series> result = new ArrayList<Series>();
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from code_series";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Series temp = null;
				String field1 = rs.getString("code");
				String field2 = rs.getString("series");
				String field3 = rs.getString("comments");
				temp = new Series(field1, field2,field3);
				result.add(temp);
			}
			
			return result;
		} catch (Exception ex) {
			System.out.println("GetSeries.java-getAllSeriess() wrong!");
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
	
	public List<Series> getSeriesByCode(String code){
		List<Series> result = new ArrayList<Series>();
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from code_series where code='" + code + "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Series temp = null;
				String field1 = rs.getString("code");
				String field2 = rs.getString("series");
				String field3 = rs.getString("comments");
				temp = new Series(field1, field2,field3);
				result.add(temp);
			}
			
			return result;
		} catch (Exception ex) {
			System.out.println("GetSeries.java-getSeriesByCode(String) wrong!");
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
	
	public List<Series> getSeriesBySeries(String series){
		List<Series> result = new ArrayList<Series>();
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from code_series where series = '" + series + "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Series temp = null;
				String field1 = rs.getString("code");
				String field2 = rs.getString("series");
				String field3 = rs.getString("comments");
				temp = new Series(field1, field2,field3);
				result.add(temp);
			}
			
			return result;
		} catch (Exception ex) {
			System.out.println("GetSeries.java-getSeriesBySeries(String) wrong!");
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
//		GetSeries test = new GetSeries();
//		System.out.println(test.getAllSeriess());
//	}
}