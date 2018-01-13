package gpw.getInfo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import gpw.connection.LinkDB;
import gpw.object.CodeModel;
import gpw.object.Education;

/**
 * 用于得到给定的表的信息
 */
public class GetCode {
	public GetCode() {
		// TODO 自动生成的构造函数存根
	}
	
	public List<CodeModel> GetCodeByTableName(String name){
		List<CodeModel> result = new ArrayList<CodeModel>();
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String fieldName = name.replace("code_", "");  //
		String sqlValue = "select * from " + name;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				CodeModel temp = null;
				String field1 = rs.getString("code"); 
				String field2 = rs.getString(fieldName); 
				String field3 = rs.getString("comments"); 
				temp = new CodeModel(field1, field2, field3);
				result.add(temp);
			}
			
			return result;
		} catch (Exception ex) {
			System.out.println("GetCode.java-GetCodeByTableName() wrong!");
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
