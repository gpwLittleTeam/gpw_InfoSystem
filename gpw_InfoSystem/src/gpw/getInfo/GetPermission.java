package gpw.getInfo;

import gpw.connection.LinkDB;
import gpw.object.Permission;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetPermission {
	public List<Permission> GetAllPermission(){
		List<Permission> result = new ArrayList<Permission>();
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from code_permission";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Permission temp = null;
				String field1 = rs.getString("code");
				String field2 = rs.getString("permission");
				String field3 = rs.getString("comments");
				temp = new Permission(field1, field2, field3);
				result.add(temp);
			}
			
			return result;
		} catch (Exception ex) {
			System.out.println("GetPermission.java-GetAllPermission() wrong!");
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
	
	public List<Permission> getPermissionByCode(String code){
		List<Permission> result = new ArrayList<Permission>();
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from code_permission where code='" + code + "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Permission temp = null;
				String field1 = rs.getString("code");
				String field2 = rs.getString("permission");
				String field3 = rs.getString("comments");
				temp = new Permission(field1, field2, field3);
				result.add(temp);
			}
			
			return result;
		} catch (Exception ex) {
			System.out.println("GetPermission.java-getPermissionByCode(String) wrong!");
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
	
	/**
	 * 通过评审权限名称获取该对象
	 * @param name 评审权限的中文名称
	 * @return 对象
	 */
	public List<Permission> getDegreeByName(String name){
		List<Permission> result = new ArrayList<Permission>();
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from code_permission where permission = '" + name + "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Permission temp = null;
				String field1 = rs.getString("code");
				String field2 = rs.getString("permission");
				String field3 = rs.getString("comments");
				temp = new Permission(field1, field2, field3);
				result.add(temp);
			}
			
			return result;
		} catch (Exception ex) {
			System.out.println("GetPermission.java-getDegreeByName(String) wrong!");
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
}
