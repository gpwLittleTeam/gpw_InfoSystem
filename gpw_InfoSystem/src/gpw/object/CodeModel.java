package gpw.object;

import gpw.connection.LinkDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CodeModel {
	private String codeNo;
	private String codeName;
	private String codeComments;
	
	public CodeModel() {	}
	
	public CodeModel(String codeNo, String codeName, String codeComments) {
		super();
		this.codeNo = codeNo;
		this.codeName = codeName;
		this.codeComments = codeComments;
	}
	
	public String GetCodeNameByTableNameAndCode(String name, String code){
		String result = "";
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String fieldName = name.replace("code_", "");  //
		String sqlValue = "select * from " + name + " where code = " + "'" + code + "'";
		//System.out.println("sqlValue：" + sqlValue);
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				result = rs.getString(fieldName); 
			}
			
			return result;
		} catch (Exception ex) {
			System.out.println("GetCode.java-GetCodeNameByTableNameAndCode() wrong!");
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
	
	public String getCodeNo() {
		return codeNo;
	}
	public void setCodeNo(String codeNo) {
		this.codeNo = codeNo;
	}
	public String getCodeName() {
		return codeName;
	}
	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}
	public String getCodeComments() {
		return codeComments;
	}
	public void setCodeComments(String codeComments) {
		this.codeComments = codeComments;
	}
}
