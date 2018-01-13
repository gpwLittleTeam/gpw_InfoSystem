package gpw.object;

import gpw.connection.LinkDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Permission extends CodeModel{
	public Permission() {
		super();
	}
	
	public Permission(String codeNo, String codeName, String codeComments) {
		super(codeNo, codeName, codeComments);
	}
	
	public String GetPermissionByCode(String code){
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String result = null;
		String sqlValue1 = "select permission from code_permission where code ='" + code + "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue1);
			while (rs.next()) {
				result = rs.getString("permission");
			}
			return result;
		} catch (Exception ex) {
			System.out.println("Permission.java->GetPermissionByCode(String) wrong!");
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
