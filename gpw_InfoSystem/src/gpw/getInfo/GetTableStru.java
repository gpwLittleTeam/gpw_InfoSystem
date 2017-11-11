package gpw.getInfo;

import gpw.connection.LinkDB;
import gpw.object.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetTableStru {
	public GetTableStru(){
		
	}
	
	public List<Tablestru> getAllTableStrus(){
		List<Tablestru> tempTablestrus = new ArrayList<Tablestru>();
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from systable_stru";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Tablestru tempTablestru = null;
				String field1 = rs.getString("Field_id");
				String field2 = rs.getString("Table_name");
				String field3 = rs.getString("Field_name");
				String field4 = rs.getString("Field_chname");
				String field5 = rs.getString("Field_type");
				String field6 = rs.getString("Field_width");
				String field7 = rs.getString("Field_order");
				String field8 = rs.getString("Field_code");
				String field9 = rs.getString("Field_default");
				String field10 = rs.getString("Field_enable");
				String field11 = rs.getString("Field_null");
				String field12 = rs.getString("Field_remarik");
				tempTablestru = new Tablestru(field1, field2, field3, field4, field5,
										field6, field7, field8, field9, field10,
										field11, field12);
				tempTablestrus.add(tempTablestru);
			}
			
			return tempTablestrus;
		} catch (Exception ex) {
			System.out.println("TableStru.java-getAllTableStrus() wrong!");
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
	
	public List<Tablestru> getAllTableStrus_zjEntry(){
		List<Tablestru> tempTablestrus = new ArrayList<Tablestru>();
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from systable_stru where (Field_id>=2 and Field_id<=30) or Field_id=32 or (Field_id>=34 and Field_id<=35) ";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Tablestru tempTablestru = null;
				String field1 = rs.getString("Field_id");
				String field2 = rs.getString("Table_name");
				String field3 = rs.getString("Field_name");
				String field4 = rs.getString("Field_chname");
				String field5 = rs.getString("Field_type");
				String field6 = rs.getString("Field_width");
				String field7 = rs.getString("Field_order");
				String field8 = rs.getString("Field_code");
				String field9 = rs.getString("Field_default");
				String field10 = rs.getString("Field_enable");
				String field11 = rs.getString("Field_null");
				String field12 = rs.getString("Field_remarik");
				tempTablestru = new Tablestru(field1, field2, field3, field4, field5,
										field6, field7, field8, field9, field10,
										field11, field12);
				tempTablestrus.add(tempTablestru);
			}
			
			return tempTablestrus;
		} catch (Exception ex) {
			System.out.println("TableStru.java-getAllTableStrus_zjEntry() wrong!");
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

	public Tablestru getTableStruById(int id){
		Tablestru tempTablestru = null;
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from systable_stru where Field_id ='" +id+"'" ;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				String field1 = rs.getString("Field_id");
				String field2 = rs.getString("Table_name");
				String field3 = rs.getString("Field_name");
				String field4 = rs.getString("Field_chname");
				String field5 = rs.getString("Field_type");
				String field6 = rs.getString("Field_width");
				String field7 = rs.getString("Field_order");
				String field8 = rs.getString("Field_code");
				String field9 = rs.getString("Field_default");
				String field10 = rs.getString("Field_enable");
				String field11 = rs.getString("Field_null");
				String field12 = rs.getString("Field_remarik");
				tempTablestru = new Tablestru(field1, field2, field3, field4, field5,
										field6, field7, field8, field9, field10,
										field11, field12);
			}
			
			return tempTablestru;
		} catch (Exception ex) {
			System.out.println("TableStru.java-getTableStruById() wrong!");
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
	
	public Tablestru getTableStruByEnName(String enname){
		Tablestru tempTablestru = null;
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from systable_stru where Field_name ='" +enname+"'" ;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				String field1 = rs.getString("Field_id");
				String field2 = rs.getString("Table_name");
				String field3 = rs.getString("Field_name");
				String field4 = rs.getString("Field_chname");
				String field5 = rs.getString("Field_type");
				String field6 = rs.getString("Field_width");
				String field7 = rs.getString("Field_order");
				String field8 = rs.getString("Field_code");
				String field9 = rs.getString("Field_default");
				String field10 = rs.getString("Field_enable");
				String field11 = rs.getString("Field_null");
				String field12 = rs.getString("Field_remarik");
				tempTablestru = new Tablestru(field1, field2, field3, field4, field5,
										field6, field7, field8, field9, field10,
										field11, field12);
			}
			
			return tempTablestru;
		} catch (Exception ex) {
			System.out.println("TableStru.java-getTableStruByEnName() wrong!");
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

	public Tablestru getTableStruByChName(String chname){
		Tablestru tempTablestru = null;
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from systable_stru where Field_chname ='" +chname+"'" ;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				String field1 = rs.getString("Field_id");
				System.out.println(field1);
				String field2 = rs.getString("Table_name");
				String field3 = rs.getString("Field_name");
				String field4 = rs.getString("Field_chname");
				String field5 = rs.getString("Field_type");
				String field6 = rs.getString("Field_width");
				String field7 = rs.getString("Field_order");
				String field8 = rs.getString("Field_code");
				String field9 = rs.getString("Field_default");
				String field10 = rs.getString("Field_enable");
				String field11 = rs.getString("Field_null");
				String field12 = rs.getString("Field_remarik");
				tempTablestru = new Tablestru(field1, field2, field3, field4, field5,
										field6, field7, field8, field9, field10,
										field11, field12);
			}
			
			return tempTablestru;
		} catch (Exception ex) {
			System.out.println("TableStru.java-getTableStruByChName() wrong!");
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

	
	public static void main(String args[]){
		GetTableStru test = new GetTableStru();
		Tablestru temp = test.getTableStruByChName("身份证号");
		System.out.println(temp.getField_name());
	}
	
}
