package gpw.getInfo;

import gpw.connection.LinkDB;
import gpw.object.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetExpert {
	public GetExpert() {
		// System.out.println("GetObject");
	}

	public Expert getExpert(String number) {
		Expert tempExpert = null;
		LinkDB link = new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from expert_baseinfo where Expert_Field1 = '" + number + "'";
		//System.out.println("GetObject.java line 19");
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				// String id = rs.getString("Expert_id");
				String field1 = rs.getString("Expert_Field1");
				String field2 = rs.getString("Expert_Field2");
				String field3 = rs.getString("Expert_Field3");
				String field4 = rs.getString("Expert_Field4");
				String field5 = rs.getString("Expert_Field5");
				String field6 = rs.getString("Expert_Field6");
				String field7 = rs.getString("Expert_Field7");
				String field8 = rs.getString("Expert_Field8");
				String field9 = rs.getString("Expert_Field9");
				String field10 = rs.getString("Expert_Field10");
				String field11 = rs.getString("Expert_Field11");
				String field12 = rs.getString("Expert_Field12");
				String field13 = rs.getString("Expert_Field13");
				String field14 = rs.getString("Expert_Field14");
				String field15 = rs.getString("Expert_Field15");
				String field16 = rs.getString("Expert_Field16");
				String field17 = rs.getString("Expert_Field17");
				String field18 = rs.getString("Expert_Field18");
				String field19 = rs.getString("Expert_Field19");
				String field20 = rs.getString("Expert_Field20");
				String field21 = rs.getString("Expert_Field21");
				String field22 = rs.getString("Expert_Field22");
				String field23 = rs.getString("Expert_Field23");
				String field24 = rs.getString("Expert_Field24");
				String field25 = rs.getString("Expert_Field25");
				String field26 = rs.getString("Expert_Field26");
				String field27 = rs.getString("Expert_Field27");
				String field28 = rs.getString("Expert_Field28");
				String field29 = rs.getString("Expert_Field29");
				String field30 = rs.getString("Expert_Field30");
				String field31 = rs.getString("Expert_Field31");
				String field32 = rs.getString("Expert_Field32");
				String field33 = rs.getString("Expert_Field33");
				String field34 = rs.getString("Expert_Field34");
				String field35 = rs.getString("Expert_Field35");
				tempExpert = new Expert(field1, field2, field3, field4, field5, field6, field7, field8, field9,
						field10, field11, field12, field13, field14, field15, field16, field17, field18, field19,
						field20, field21, field22, field23, field24, field25, field26, field27, field28, field29,
						field30, field31, field32, field33, field34, field35);
			}
			return tempExpert;
		} catch (Exception ex) {
			System.out.println("GetExpert.java-getExpert(String):Expert Wrong!");
			// ex.printStackTrace();
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
				// ex.printStackTrace();
			}
		}
	}

	// 返回所有的Expert
	public List<Expert> getAllExpertsFromInfoView() {
		List<Expert> tempExperts = new ArrayList<Expert>();
		LinkDB link = new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from infolistview";

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Expert tempExpert = null;
				// String id = rs.getString("Expert_id");
				String field1 = rs.getString("Expert_Field1");
				String field2 = rs.getString("Expert_Field2");
				String field3 = rs.getString("Expert_Field3");
				String field4 = rs.getString("Expert_Field4");
				String field5 = rs.getString("Expert_Field5");
				String field6 = rs.getString("Expert_Field6");
				String field7 = rs.getString("Expert_Field7");
				String field8 = rs.getString("Expert_Field8");
				String field9 = rs.getString("Expert_Field9");
				String field10 = rs.getString("Expert_Field10");
				String field11 = rs.getString("Expert_Field11");
				String field12 = rs.getString("Expert_Field12");
				String field13 = rs.getString("Expert_Field13");
				String field14 = rs.getString("Expert_Field14");
				String field15 = rs.getString("Expert_Field15");
				String field16 = rs.getString("Expert_Field16");
				String field17 = rs.getString("Expert_Field17");
				String field18 = rs.getString("Expert_Field18");
				String field19 = rs.getString("Expert_Field19");
				String field20 = rs.getString("Expert_Field20");
				String field21 = rs.getString("Expert_Field21");
				String field22 = rs.getString("Expert_Field22");
				String field23 = rs.getString("Expert_Field23");
				String field24 = rs.getString("Expert_Field24");
				String field25 = rs.getString("Expert_Field25");
				String field26 = rs.getString("Expert_Field26");
				String field27 = rs.getString("Expert_Field27");
				String field28 = rs.getString("Expert_Field28");
				String field29 = rs.getString("Expert_Field29");
				String field30 = rs.getString("Expert_Field30");
				String field31 = rs.getString("Expert_Field31");
				String field32 = rs.getString("Expert_Field32");
				String field33 = rs.getString("Expert_Field33");
				String field34 = rs.getString("Expert_Field34");
				String field35 = rs.getString("Expert_Field35");
				// System.out.println("GetObject.java + field10:"+field10);
				tempExpert = new Expert(field1, field2, field3, field4, field5, field6, field7, field8, field9,
						field10, field11, field12, field13, field14, field15, field16, field17, field18, field19,
						field20, field21, field22, field23, field24, field25, field26, field27, field28, field29,
						field30, field31, field32, field33, field34, field35);
				tempExperts.add(tempExpert);
			}

			return tempExperts;
		} catch (Exception ex) {
			System.out.println("GetExpert.java-getAllExperts():List<Expert> wrong!");
			// ex.printStackTrace();
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
				// ex.printStackTrace();
			}
		}
	}

	public List<Expert> getExpertsFromAJury(String juryNo) {
		List<Expert> tempExperts = new ArrayList<Expert>();
		GetJury objGetJury = new GetJury();
		LinkDB link = new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from infolistview where Expert_Field31='" + objGetJury.getJuryByNo(juryNo).getJury_name() + "'";
		System.out.println(sqlValue);
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Expert tempExpert = null;
				// String id = rs.getString("Expert_id");
				String field1 = rs.getString("Expert_Field1");
				String field2 = rs.getString("Expert_Field2");
				String field3 = rs.getString("Expert_Field3");
				String field4 = rs.getString("Expert_Field4");
				String field5 = rs.getString("Expert_Field5");
				String field6 = rs.getString("Expert_Field6");
				String field7 = rs.getString("Expert_Field7");
				String field8 = rs.getString("Expert_Field8");
				String field9 = rs.getString("Expert_Field9");
				String field10 = rs.getString("Expert_Field10");
				String field11 = rs.getString("Expert_Field11");
				String field12 = rs.getString("Expert_Field12");
				String field13 = rs.getString("Expert_Field13");
				String field14 = rs.getString("Expert_Field14");
				String field15 = rs.getString("Expert_Field15");
				String field16 = rs.getString("Expert_Field16");
				String field17 = rs.getString("Expert_Field17");
				String field18 = rs.getString("Expert_Field18");
				String field19 = rs.getString("Expert_Field19");
				String field20 = rs.getString("Expert_Field20");
				String field21 = rs.getString("Expert_Field21");
				String field22 = rs.getString("Expert_Field22");
				String field23 = rs.getString("Expert_Field23");
				String field24 = rs.getString("Expert_Field24");
				String field25 = rs.getString("Expert_Field25");
				String field26 = rs.getString("Expert_Field26");
				String field27 = rs.getString("Expert_Field27");
				String field28 = rs.getString("Expert_Field28");
				String field29 = rs.getString("Expert_Field29");
				String field30 = rs.getString("Expert_Field30");
				String field31 = rs.getString("Expert_Field31");
				String field32 = rs.getString("Expert_Field32");
				String field33 = rs.getString("Expert_Field33");
				String field34 = rs.getString("Expert_Field34");
				String field35 = rs.getString("Expert_Field35");
				// System.out.println("GetObject.java + field10:"+field10);
				tempExpert = new Expert(field1, field2, field3, field4, field5, field6, field7, field8, field9,
						field10, field11, field12, field13, field14, field15, field16, field17, field18, field19,
						field20, field21, field22, field23, field24, field25, field26, field27, field28, field29,
						field30, field31, field32, field33, field34, field35);
				tempExperts.add(tempExpert);
			}

			return tempExperts;
		} catch (Exception ex) {
			System.out.println("GetExpert.java-getExpertsFromAJury(String):List<Expert> wrong!");
			// ex.printStackTrace();
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
				// ex.printStackTrace();
			}
		}
	}

	// public static void main(String args[]){
	// GetExpert test = new GetExpert();
	// System.out.println(test.getExpertsFromAJury("0101"));
	// }
	//
	// 通过名字检索
	public List<Expert> getExpertByName(String name) {
		// 建立连接
		List<Expert> tempExperts = new ArrayList<Expert>();
		LinkDB link = new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;

		String sqlValue = "select * from expert_baseinfo where Expert_Field2 = '" + name + "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Expert tempExpert = null;
				// String id = rs.getString("Expert_id");
				String field1 = rs.getString("Expert_Field1");
				String field2 = rs.getString("Expert_Field2");
				String field3 = rs.getString("Expert_Field3");
				String field4 = rs.getString("Expert_Field4");
				String field5 = rs.getString("Expert_Field5");
				String field6 = rs.getString("Expert_Field6");
				String field7 = rs.getString("Expert_Field7");
				String field8 = rs.getString("Expert_Field8");
				String field9 = rs.getString("Expert_Field9");
				String field10 = rs.getString("Expert_Field10");
				String field11 = rs.getString("Expert_Field11");
				String field12 = rs.getString("Expert_Field12");
				String field13 = rs.getString("Expert_Field13");
				String field14 = rs.getString("Expert_Field14");
				String field15 = rs.getString("Expert_Field15");
				String field16 = rs.getString("Expert_Field16");
				String field17 = rs.getString("Expert_Field17");
				String field18 = rs.getString("Expert_Field18");
				String field19 = rs.getString("Expert_Field19");
				String field20 = rs.getString("Expert_Field20");
				String field21 = rs.getString("Expert_Field21");
				String field22 = rs.getString("Expert_Field22");
				String field23 = rs.getString("Expert_Field23");
				String field24 = rs.getString("Expert_Field24");
				String field25 = rs.getString("Expert_Field25");
				String field26 = rs.getString("Expert_Field26");
				String field27 = rs.getString("Expert_Field27");
				String field28 = rs.getString("Expert_Field28");
				String field29 = rs.getString("Expert_Field29");
				String field30 = rs.getString("Expert_Field30");
				String field31 = rs.getString("Expert_Field31");
				String field32 = rs.getString("Expert_Field32");
				String field33 = rs.getString("Expert_Field33");
				String field34 = rs.getString("Expert_Field34");
				String field35 = rs.getString("Expert_Field35");
				tempExpert = new Expert(field1, field2, field3, field4, field5, field6, field7, field8, field9,
						field10, field11, field12, field13, field14, field15, field16, field17, field18, field19,
						field20, field21, field22, field23, field24, field25, field26, field27, field28, field29,
						field30, field31, field32, field33, field34, field35);
				tempExperts.add(tempExpert);
			}
			return tempExperts;
		} catch (Exception ex) {
			System.out.println("GetExpert.java-getExpertByName(String):List<Expert> Wrong!");
			// ex.printStackTrace();
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
				// ex.printStackTrace();
			}
		}
	}

	public List<Expert> getExpertByNameFromInfoView(String name) {
		// 建立连接
		List<Expert> tempExperts = new ArrayList<Expert>();
		LinkDB link = new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;

		String sqlValue = "select * from infolistview where Expert_Field2 = '" + name + "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Expert tempExpert = null;
				// String id = rs.getString("Expert_id");
				String field1 = rs.getString("Expert_Field1");
				String field2 = rs.getString("Expert_Field2");
				String field3 = rs.getString("Expert_Field3");
				String field4 = rs.getString("Expert_Field4");
				String field5 = rs.getString("Expert_Field5");
				String field6 = rs.getString("Expert_Field6");
				String field7 = rs.getString("Expert_Field7");
				String field8 = rs.getString("Expert_Field8");
				String field9 = rs.getString("Expert_Field9");
				String field10 = rs.getString("Expert_Field10");
				String field11 = rs.getString("Expert_Field11");
				String field12 = rs.getString("Expert_Field12");
				String field13 = rs.getString("Expert_Field13");
				String field14 = rs.getString("Expert_Field14");
				String field15 = rs.getString("Expert_Field15");
				String field16 = rs.getString("Expert_Field16");
				String field17 = rs.getString("Expert_Field17");
				String field18 = rs.getString("Expert_Field18");
				String field19 = rs.getString("Expert_Field19");
				String field20 = rs.getString("Expert_Field20");
				String field21 = rs.getString("Expert_Field21");
				String field22 = rs.getString("Expert_Field22");
				String field23 = rs.getString("Expert_Field23");
				String field24 = rs.getString("Expert_Field24");
				String field25 = rs.getString("Expert_Field25");
				String field26 = rs.getString("Expert_Field26");
				String field27 = rs.getString("Expert_Field27");
				String field28 = rs.getString("Expert_Field28");
				String field29 = rs.getString("Expert_Field29");
				String field30 = rs.getString("Expert_Field30");
				String field31 = rs.getString("Expert_Field31");
				String field32 = rs.getString("Expert_Field32");
				String field33 = rs.getString("Expert_Field33");
				String field34 = rs.getString("Expert_Field34");
				String field35 = rs.getString("Expert_Field35");
				tempExpert = new Expert(field1, field2, field3, field4, field5, field6, field7, field8, field9,
						field10, field11, field12, field13, field14, field15, field16, field17, field18, field19,
						field20, field21, field22, field23, field24, field25, field26, field27, field28, field29,
						field30, field31, field32, field33, field34, field35);
				tempExperts.add(tempExpert);
			}
			return tempExperts;
		} catch (Exception ex) {
			System.out.println("GetExpert.java-getExpertByNameFromInfoView(String):List<Expert> Wrong!");
			// ex.printStackTrace();
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
				// ex.printStackTrace();
			}
		}
	}

	// 通过专业组检索
	public List<Expert> getExpertByGroup(String group) {

		// 建立连接
		List<Expert> tempExperts = new ArrayList<Expert>();
		LinkDB link = new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		// 改
		String sqlValue = "select * from expert_baseinfo where Expert_Field33 = '" + group + "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Expert tempExpert = null;
				// String id = rs.getString("Expert_id");
				String field1 = rs.getString("Expert_Field1");
				String field2 = rs.getString("Expert_Field2");
				String field3 = rs.getString("Expert_Field3");
				String field4 = rs.getString("Expert_Field4");
				String field5 = rs.getString("Expert_Field5");
				String field6 = rs.getString("Expert_Field6");
				String field7 = rs.getString("Expert_Field7");
				String field8 = rs.getString("Expert_Field8");
				String field9 = rs.getString("Expert_Field9");
				String field10 = rs.getString("Expert_Field10");
				String field11 = rs.getString("Expert_Field11");
				String field12 = rs.getString("Expert_Field12");
				String field13 = rs.getString("Expert_Field13");
				String field14 = rs.getString("Expert_Field14");
				String field15 = rs.getString("Expert_Field15");
				String field16 = rs.getString("Expert_Field16");
				String field17 = rs.getString("Expert_Field17");
				String field18 = rs.getString("Expert_Field18");
				String field19 = rs.getString("Expert_Field19");
				String field20 = rs.getString("Expert_Field20");
				String field21 = rs.getString("Expert_Field21");
				String field22 = rs.getString("Expert_Field22");
				String field23 = rs.getString("Expert_Field23");
				String field24 = rs.getString("Expert_Field24");
				String field25 = rs.getString("Expert_Field25");
				String field26 = rs.getString("Expert_Field26");
				String field27 = rs.getString("Expert_Field27");
				String field28 = rs.getString("Expert_Field28");
				String field29 = rs.getString("Expert_Field29");
				String field30 = rs.getString("Expert_Field30");
				String field31 = rs.getString("Expert_Field31");
				String field32 = rs.getString("Expert_Field32");
				String field33 = rs.getString("Expert_Field33");
				String field34 = rs.getString("Expert_Field34");
				String field35 = rs.getString("Expert_Field35");
				tempExpert = new Expert(field1, field2, field3, field4, field5, field6, field7, field8, field9,
						field10, field11, field12, field13, field14, field15, field16, field17, field18, field19,
						field20, field21, field22, field23, field24, field25, field26, field27, field28, field29,
						field30, field31, field32, field33, field34, field35);
				tempExperts.add(tempExpert);
			}
			return tempExperts;
		} catch (Exception ex) {
			System.out.println("GetExpert.java-getExpertByGroup(String):List<Expert> Wrong!");
			// ex.printStackTrace();
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
				// ex.printStackTrace();
			}
		}
	}

	public List<Expert> getExpertByGroupFromInfoView(String group) {

		// 建立连接
		List<Expert> tempExperts = new ArrayList<Expert>();
		LinkDB link = new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		// 改
		String sqlValue = "select * from infolistview where Expert_Field33 = '" + group + "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Expert tempExpert = null;
				// String id = rs.getString("Expert_id");
				String field1 = rs.getString("Expert_Field1");
				String field2 = rs.getString("Expert_Field2");
				String field3 = rs.getString("Expert_Field3");
				String field4 = rs.getString("Expert_Field4");
				String field5 = rs.getString("Expert_Field5");
				String field6 = rs.getString("Expert_Field6");
				String field7 = rs.getString("Expert_Field7");
				String field8 = rs.getString("Expert_Field8");
				String field9 = rs.getString("Expert_Field9");
				String field10 = rs.getString("Expert_Field10");
				String field11 = rs.getString("Expert_Field11");
				String field12 = rs.getString("Expert_Field12");
				String field13 = rs.getString("Expert_Field13");
				String field14 = rs.getString("Expert_Field14");
				String field15 = rs.getString("Expert_Field15");
				String field16 = rs.getString("Expert_Field16");
				String field17 = rs.getString("Expert_Field17");
				String field18 = rs.getString("Expert_Field18");
				String field19 = rs.getString("Expert_Field19");
				String field20 = rs.getString("Expert_Field20");
				String field21 = rs.getString("Expert_Field21");
				String field22 = rs.getString("Expert_Field22");
				String field23 = rs.getString("Expert_Field23");
				String field24 = rs.getString("Expert_Field24");
				String field25 = rs.getString("Expert_Field25");
				String field26 = rs.getString("Expert_Field26");
				String field27 = rs.getString("Expert_Field27");
				String field28 = rs.getString("Expert_Field28");
				String field29 = rs.getString("Expert_Field29");
				String field30 = rs.getString("Expert_Field30");
				String field31 = rs.getString("Expert_Field31");
				String field32 = rs.getString("Expert_Field32");
				String field33 = rs.getString("Expert_Field33");
				String field34 = rs.getString("Expert_Field34");
				String field35 = rs.getString("Expert_Field35");
				tempExpert = new Expert(field1, field2, field3, field4, field5, field6, field7, field8, field9,
						field10, field11, field12, field13, field14, field15, field16, field17, field18, field19,
						field20, field21, field22, field23, field24, field25, field26, field27, field28, field29,
						field30, field31, field32, field33, field34, field35);
				tempExperts.add(tempExpert);
			}
			return tempExperts;
		} catch (Exception ex) {
			System.out.println("GetExpert.java-getExpertByGroupFromInfoView(String):List<Expert> Wrong!");
			// ex.printStackTrace();
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
				// ex.printStackTrace();
			}
		}
	}

	// 通过工作单位检索
	public List<Expert> getExpertByWorkplace(String jury) {

		// 建立连接
		List<Expert> tempExperts = new ArrayList<Expert>();
		LinkDB link = new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;

		String sqlValue = "select * from expert_baseinfo where Expert_Field14 = '" + jury + "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Expert tempExpert = null;
				// String id = rs.getString("Expert_id");
				String field1 = rs.getString("Expert_Field1");
				String field2 = rs.getString("Expert_Field2");
				String field3 = rs.getString("Expert_Field3");
				String field4 = rs.getString("Expert_Field4");
				String field5 = rs.getString("Expert_Field5");
				String field6 = rs.getString("Expert_Field6");
				String field7 = rs.getString("Expert_Field7");
				String field8 = rs.getString("Expert_Field8");
				String field9 = rs.getString("Expert_Field9");
				String field10 = rs.getString("Expert_Field10");
				String field11 = rs.getString("Expert_Field11");
				String field12 = rs.getString("Expert_Field12");
				String field13 = rs.getString("Expert_Field13");
				String field14 = rs.getString("Expert_Field14");
				String field15 = rs.getString("Expert_Field15");
				String field16 = rs.getString("Expert_Field16");
				String field17 = rs.getString("Expert_Field17");
				String field18 = rs.getString("Expert_Field18");
				String field19 = rs.getString("Expert_Field19");
				String field20 = rs.getString("Expert_Field20");
				String field21 = rs.getString("Expert_Field21");
				String field22 = rs.getString("Expert_Field22");
				String field23 = rs.getString("Expert_Field23");
				String field24 = rs.getString("Expert_Field24");
				String field25 = rs.getString("Expert_Field25");
				String field26 = rs.getString("Expert_Field26");
				String field27 = rs.getString("Expert_Field27");
				String field28 = rs.getString("Expert_Field28");
				String field29 = rs.getString("Expert_Field29");
				String field30 = rs.getString("Expert_Field30");
				String field31 = rs.getString("Expert_Field31");
				String field32 = rs.getString("Expert_Field32");
				String field33 = rs.getString("Expert_Field33");
				String field34 = rs.getString("Expert_Field34");
				String field35 = rs.getString("Expert_Field35");
				tempExpert = new Expert(field1, field2, field3, field4, field5, field6, field7, field8, field9,
						field10, field11, field12, field13, field14, field15, field16, field17, field18, field19,
						field20, field21, field22, field23, field24, field25, field26, field27, field28, field29,
						field30, field31, field32, field33, field34, field35);
				tempExperts.add(tempExpert);
			}
			return tempExperts;
		} catch (Exception ex) {
			System.out.println("GetExpert.java-getExpertByWorkplace(String):List<String> Wrong!");
			// ex.printStackTrace();
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
				// ex.printStackTrace();
			}
		}
	}

	public List<Expert> getExpertByWorkplaceFromInfoView(String jury) {

		// 建立连接
		List<Expert> tempExperts = new ArrayList<Expert>();
		LinkDB link = new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;

		String sqlValue = "select * from infolistview where Expert_Field14 = '" + jury + "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Expert tempExpert = null;
				// String id = rs.getString("Expert_id");
				String field1 = rs.getString("Expert_Field1");
				String field2 = rs.getString("Expert_Field2");
				String field3 = rs.getString("Expert_Field3");
				String field4 = rs.getString("Expert_Field4");
				String field5 = rs.getString("Expert_Field5");
				String field6 = rs.getString("Expert_Field6");
				String field7 = rs.getString("Expert_Field7");
				String field8 = rs.getString("Expert_Field8");
				String field9 = rs.getString("Expert_Field9");
				String field10 = rs.getString("Expert_Field10");
				String field11 = rs.getString("Expert_Field11");
				String field12 = rs.getString("Expert_Field12");
				String field13 = rs.getString("Expert_Field13");
				String field14 = rs.getString("Expert_Field14");
				String field15 = rs.getString("Expert_Field15");
				String field16 = rs.getString("Expert_Field16");
				String field17 = rs.getString("Expert_Field17");
				String field18 = rs.getString("Expert_Field18");
				String field19 = rs.getString("Expert_Field19");
				String field20 = rs.getString("Expert_Field20");
				String field21 = rs.getString("Expert_Field21");
				String field22 = rs.getString("Expert_Field22");
				String field23 = rs.getString("Expert_Field23");
				String field24 = rs.getString("Expert_Field24");
				String field25 = rs.getString("Expert_Field25");
				String field26 = rs.getString("Expert_Field26");
				String field27 = rs.getString("Expert_Field27");
				String field28 = rs.getString("Expert_Field28");
				String field29 = rs.getString("Expert_Field29");
				String field30 = rs.getString("Expert_Field30");
				String field31 = rs.getString("Expert_Field31");
				String field32 = rs.getString("Expert_Field32");
				String field33 = rs.getString("Expert_Field33");
				String field34 = rs.getString("Expert_Field34");
				String field35 = rs.getString("Expert_Field35");
				tempExpert = new Expert(field1, field2, field3, field4, field5, field6, field7, field8, field9,
						field10, field11, field12, field13, field14, field15, field16, field17, field18, field19,
						field20, field21, field22, field23, field24, field25, field26, field27, field28, field29,
						field30, field31, field32, field33, field34, field35);
				tempExperts.add(tempExpert);
			}
			return tempExperts;
		} catch (Exception ex) {
			System.out.println("GetExpert.java-getExpertByWorkplace(String):List<String> Wrong!");
			// ex.printStackTrace();
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
				// ex.printStackTrace();
			}
		}
	}

	// 通过编号检索
	public Expert getExpertByNumber(String number) {

		// 建立连接
		LinkDB link = new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;

		String sqlValue = "select * from expert_baseinfo where Expert_Field1 = '" + number + "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			Expert tempExpert = null;
			while (rs.next()) {
				// String id = rs.getString("Expert_id");
				String field1 = rs.getString("Expert_Field1");
				String field2 = rs.getString("Expert_Field2");
				String field3 = rs.getString("Expert_Field3");
				String field4 = rs.getString("Expert_Field4");
				String field5 = rs.getString("Expert_Field5");
				String field6 = rs.getString("Expert_Field6");
				String field7 = rs.getString("Expert_Field7");
				String field8 = rs.getString("Expert_Field8");
				String field9 = rs.getString("Expert_Field9");
				String field10 = rs.getString("Expert_Field10");
				String field11 = rs.getString("Expert_Field11");
				String field12 = rs.getString("Expert_Field12");
				String field13 = rs.getString("Expert_Field13");
				String field14 = rs.getString("Expert_Field14");
				String field15 = rs.getString("Expert_Field15");
				String field16 = rs.getString("Expert_Field16");
				String field17 = rs.getString("Expert_Field17");
				String field18 = rs.getString("Expert_Field18");
				String field19 = rs.getString("Expert_Field19");
				String field20 = rs.getString("Expert_Field20");
				String field21 = rs.getString("Expert_Field21");
				String field22 = rs.getString("Expert_Field22");
				String field23 = rs.getString("Expert_Field23");
				String field24 = rs.getString("Expert_Field24");
				String field25 = rs.getString("Expert_Field25");
				String field26 = rs.getString("Expert_Field26");
				String field27 = rs.getString("Expert_Field27");
				String field28 = rs.getString("Expert_Field28");
				String field29 = rs.getString("Expert_Field29");
				String field30 = rs.getString("Expert_Field30");
				String field31 = rs.getString("Expert_Field31");
				String field32 = rs.getString("Expert_Field32");
				String field33 = rs.getString("Expert_Field33");
				String field34 = rs.getString("Expert_Field34");
				String field35 = rs.getString("Expert_Field35");
				tempExpert = new Expert(field1, field2, field3, field4, field5, field6, field7, field8, field9,
						field10, field11, field12, field13, field14, field15, field16, field17, field18, field19,
						field20, field21, field22, field23, field24, field25, field26, field27, field28, field29,
						field30, field31, field32, field33, field34, field35);
				
			}
			return tempExpert;
		} catch (Exception ex) {
			System.out.println("GetExpert.java-getExpertByNumber(String):List<Expert> Wrong!");
			// ex.printStackTrace();
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
				// ex.printStackTrace();
			}
		}
	}

	public Expert getExpertByNumberFromInfoView(String number) {

		// 建立连接
		LinkDB link = new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;

		String sqlValue = "select * from infolistview where Expert_Field1 = '" + number + "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			Expert tempExpert = null;
			while (rs.next()) {
				// String id = rs.getString("Expert_id");
				String field1 = rs.getString("Expert_Field1");
				String field2 = rs.getString("Expert_Field2");
				String field3 = rs.getString("Expert_Field3");
				String field4 = rs.getString("Expert_Field4");
				String field5 = rs.getString("Expert_Field5");
				String field6 = rs.getString("Expert_Field6");
				String field7 = rs.getString("Expert_Field7");
				String field8 = rs.getString("Expert_Field8");
				String field9 = rs.getString("Expert_Field9");
				String field10 = rs.getString("Expert_Field10");
				String field11 = rs.getString("Expert_Field11");
				String field12 = rs.getString("Expert_Field12");
				String field13 = rs.getString("Expert_Field13");
				String field14 = rs.getString("Expert_Field14");
				String field15 = rs.getString("Expert_Field15");
				String field16 = rs.getString("Expert_Field16");
				String field17 = rs.getString("Expert_Field17");
				String field18 = rs.getString("Expert_Field18");
				String field19 = rs.getString("Expert_Field19");
				String field20 = rs.getString("Expert_Field20");
				String field21 = rs.getString("Expert_Field21");
				String field22 = rs.getString("Expert_Field22");
				String field23 = rs.getString("Expert_Field23");
				String field24 = rs.getString("Expert_Field24");
				String field25 = rs.getString("Expert_Field25");
				String field26 = rs.getString("Expert_Field26");
				String field27 = rs.getString("Expert_Field27");
				String field28 = rs.getString("Expert_Field28");
				String field29 = rs.getString("Expert_Field29");
				String field30 = rs.getString("Expert_Field30");
				String field31 = rs.getString("Expert_Field31");
				String field32 = rs.getString("Expert_Field32");
				String field33 = rs.getString("Expert_Field33");
				String field34 = rs.getString("Expert_Field34");
				String field35 = rs.getString("Expert_Field35");
				tempExpert = new Expert(field1, field2, field3, field4, field5, field6, field7, field8, field9,
						field10, field11, field12, field13, field14, field15, field16, field17, field18, field19,
						field20, field21, field22, field23, field24, field25, field26, field27, field28, field29,
						field30, field31, field32, field33, field34, field35);
				
			}
			return tempExpert;
		} catch (Exception ex) {
			System.out.println("GetExpert.java-getExpertByNumber(String):List<Expert> Wrong!");
			// ex.printStackTrace();
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
				// ex.printStackTrace();
			}
		}
	}

	// 根据所在高评委查询所有专家
	public List<Expert> getExpertByJury(String jury) {
		// 建立连接
		List<Expert> tempExperts = new ArrayList<Expert>();
		LinkDB link = new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;

		String sqlValue = "select * from expert_baseinfo where Expert_Field31 = '" + jury + "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Expert tempExpert = null;
				// String id = rs.getString("Expert_id");
				String field1 = rs.getString("Expert_Field1");
				String field2 = rs.getString("Expert_Field2");
				String field3 = rs.getString("Expert_Field3");
				String field4 = rs.getString("Expert_Field4");
				String field5 = rs.getString("Expert_Field5");
				String field6 = rs.getString("Expert_Field6");
				String field7 = rs.getString("Expert_Field7");
				String field8 = rs.getString("Expert_Field8");
				String field9 = rs.getString("Expert_Field9");
				String field10 = rs.getString("Expert_Field10");
				String field11 = rs.getString("Expert_Field11");
				String field12 = rs.getString("Expert_Field12");
				String field13 = rs.getString("Expert_Field13");
				String field14 = rs.getString("Expert_Field14");
				String field15 = rs.getString("Expert_Field15");
				String field16 = rs.getString("Expert_Field16");
				String field17 = rs.getString("Expert_Field17");
				String field18 = rs.getString("Expert_Field18");
				String field19 = rs.getString("Expert_Field19");
				String field20 = rs.getString("Expert_Field20");
				String field21 = rs.getString("Expert_Field21");
				String field22 = rs.getString("Expert_Field22");
				String field23 = rs.getString("Expert_Field23");
				String field24 = rs.getString("Expert_Field24");
				String field25 = rs.getString("Expert_Field25");
				String field26 = rs.getString("Expert_Field26");
				String field27 = rs.getString("Expert_Field27");
				String field28 = rs.getString("Expert_Field28");
				String field29 = rs.getString("Expert_Field29");
				String field30 = rs.getString("Expert_Field30");
				String field31 = rs.getString("Expert_Field31");
				String field32 = rs.getString("Expert_Field32");
				String field33 = rs.getString("Expert_Field33");
				String field34 = rs.getString("Expert_Field34");
				String field35 = rs.getString("Expert_Field35");
				tempExpert = new Expert(field1, field2, field3, field4, field5, field6, field7, field8, field9,
						field10, field11, field12, field13, field14, field15, field16, field17, field18, field19,
						field20, field21, field22, field23, field24, field25, field26, field27, field28, field29,
						field30, field31, field32, field33, field34, field35);
				tempExperts.add(tempExpert);
			}
			return tempExperts;
		} catch (Exception ex) {
			System.out.println("GetExpert.java-getExpertByJury(String):List<Expert> Wrong!");
			// ex.printStackTrace();
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
				// ex.printStackTrace();
			}
		}
	}

	public List<Expert> getExpertByJuryFromInfoView(String jury) {
		// 建立连接
		List<Expert> tempExperts = new ArrayList<Expert>();
		LinkDB link = new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;

		String sqlValue = "select * from infolistview where Expert_Field31 = '" + jury + "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Expert tempExpert = null;
				// String id = rs.getString("Expert_id");
				String field1 = rs.getString("Expert_Field1");
				String field2 = rs.getString("Expert_Field2");
				String field3 = rs.getString("Expert_Field3");
				String field4 = rs.getString("Expert_Field4");
				String field5 = rs.getString("Expert_Field5");
				String field6 = rs.getString("Expert_Field6");
				String field7 = rs.getString("Expert_Field7");
				String field8 = rs.getString("Expert_Field8");
				String field9 = rs.getString("Expert_Field9");
				String field10 = rs.getString("Expert_Field10");
				String field11 = rs.getString("Expert_Field11");
				String field12 = rs.getString("Expert_Field12");
				String field13 = rs.getString("Expert_Field13");
				String field14 = rs.getString("Expert_Field14");
				String field15 = rs.getString("Expert_Field15");
				String field16 = rs.getString("Expert_Field16");
				String field17 = rs.getString("Expert_Field17");
				String field18 = rs.getString("Expert_Field18");
				String field19 = rs.getString("Expert_Field19");
				String field20 = rs.getString("Expert_Field20");
				String field21 = rs.getString("Expert_Field21");
				String field22 = rs.getString("Expert_Field22");
				String field23 = rs.getString("Expert_Field23");
				String field24 = rs.getString("Expert_Field24");
				String field25 = rs.getString("Expert_Field25");
				String field26 = rs.getString("Expert_Field26");
				String field27 = rs.getString("Expert_Field27");
				String field28 = rs.getString("Expert_Field28");
				String field29 = rs.getString("Expert_Field29");
				String field30 = rs.getString("Expert_Field30");
				String field31 = rs.getString("Expert_Field31");
				String field32 = rs.getString("Expert_Field32");
				String field33 = rs.getString("Expert_Field33");
				String field34 = rs.getString("Expert_Field34");
				String field35 = rs.getString("Expert_Field35");
				tempExpert = new Expert(field1, field2, field3, field4, field5, field6, field7, field8, field9,
						field10, field11, field12, field13, field14, field15, field16, field17, field18, field19,
						field20, field21, field22, field23, field24, field25, field26, field27, field28, field29,
						field30, field31, field32, field33, field34, field35);
				tempExperts.add(tempExpert);
			}
			return tempExperts;
		} catch (Exception ex) {
			System.out.println("GetExpert.java-getExpertByJuryFromInfoView(String):List<Expert> Wrong!");
			// ex.printStackTrace();
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
				// ex.printStackTrace();
			}
		}
	}

	public static void main(String args[]) {
		List<Integer> test = new ArrayList<Integer>();
		test.add(1);
		test.add(2);
		for(int i : test){
			test.remove(i);
		}
		for(int i : test){
			System.out.println(test.get(i));
		}
	}

	public List<Expert> getExpertByNumberAndJury(String number, String jury) {
		List<Expert> tempExperts = new ArrayList<Expert>();
		LinkDB link = new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;

		String sqlValue = "select * from expert_baseinfo where Expert_Field1 = '" + number + "' and"
				+ " Expert_Field31 = '" + jury + "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Expert tempExpert = null;
				// String id = rs.getString("Expert_id");
				String field1 = rs.getString("Expert_Field1");
				String field2 = rs.getString("Expert_Field2");
				String field3 = rs.getString("Expert_Field3");
				String field4 = rs.getString("Expert_Field4");
				String field5 = rs.getString("Expert_Field5");
				String field6 = rs.getString("Expert_Field6");
				String field7 = rs.getString("Expert_Field7");
				String field8 = rs.getString("Expert_Field8");
				String field9 = rs.getString("Expert_Field9");
				String field10 = rs.getString("Expert_Field10");
				String field11 = rs.getString("Expert_Field11");
				String field12 = rs.getString("Expert_Field12");
				String field13 = rs.getString("Expert_Field13");
				String field14 = rs.getString("Expert_Field14");
				String field15 = rs.getString("Expert_Field15");
				String field16 = rs.getString("Expert_Field16");
				String field17 = rs.getString("Expert_Field17");
				String field18 = rs.getString("Expert_Field18");
				String field19 = rs.getString("Expert_Field19");
				String field20 = rs.getString("Expert_Field20");
				String field21 = rs.getString("Expert_Field21");
				String field22 = rs.getString("Expert_Field22");
				String field23 = rs.getString("Expert_Field23");
				String field24 = rs.getString("Expert_Field24");
				String field25 = rs.getString("Expert_Field25");
				String field26 = rs.getString("Expert_Field26");
				String field27 = rs.getString("Expert_Field27");
				String field28 = rs.getString("Expert_Field28");
				String field29 = rs.getString("Expert_Field29");
				String field30 = rs.getString("Expert_Field30");
				String field31 = rs.getString("Expert_Field31");
				String field32 = rs.getString("Expert_Field32");
				String field33 = rs.getString("Expert_Field33");
				String field34 = rs.getString("Expert_Field34");
				String field35 = rs.getString("Expert_Field35");
				tempExpert = new Expert(field1, field2, field3, field4, field5, field6, field7, field8, field9,
						field10, field11, field12, field13, field14, field15, field16, field17, field18, field19,
						field20, field21, field22, field23, field24, field25, field26, field27, field28, field29,
						field30, field31, field32, field33, field34, field35);
				tempExperts.add(tempExpert);
			}
			return tempExperts;
		} catch (Exception ex) {
			System.out.println("GetExpert.java-getExpertByNumberAndJury(String, String):List<Expert> Wrong!");
			// ex.printStackTrace();
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
				// ex.printStackTrace();
			}
		}
	}

	public List<Expert> getExpertByNumberAndJuryFromInfoView(String number, String jury) {
		List<Expert> tempExperts = new ArrayList<Expert>();
		LinkDB link = new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;

		String sqlValue = "select * from infolistview where Expert_Field1 = '" + number + "' and"
				+ " Expert_Field31 = '" + jury + "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Expert tempExpert = null;
				// String id = rs.getString("Expert_id");
				String field1 = rs.getString("Expert_Field1");
				String field2 = rs.getString("Expert_Field2");
				String field3 = rs.getString("Expert_Field3");
				String field4 = rs.getString("Expert_Field4");
				String field5 = rs.getString("Expert_Field5");
				String field6 = rs.getString("Expert_Field6");
				String field7 = rs.getString("Expert_Field7");
				String field8 = rs.getString("Expert_Field8");
				String field9 = rs.getString("Expert_Field9");
				String field10 = rs.getString("Expert_Field10");
				String field11 = rs.getString("Expert_Field11");
				String field12 = rs.getString("Expert_Field12");
				String field13 = rs.getString("Expert_Field13");
				String field14 = rs.getString("Expert_Field14");
				String field15 = rs.getString("Expert_Field15");
				String field16 = rs.getString("Expert_Field16");
				String field17 = rs.getString("Expert_Field17");
				String field18 = rs.getString("Expert_Field18");
				String field19 = rs.getString("Expert_Field19");
				String field20 = rs.getString("Expert_Field20");
				String field21 = rs.getString("Expert_Field21");
				String field22 = rs.getString("Expert_Field22");
				String field23 = rs.getString("Expert_Field23");
				String field24 = rs.getString("Expert_Field24");
				String field25 = rs.getString("Expert_Field25");
				String field26 = rs.getString("Expert_Field26");
				String field27 = rs.getString("Expert_Field27");
				String field28 = rs.getString("Expert_Field28");
				String field29 = rs.getString("Expert_Field29");
				String field30 = rs.getString("Expert_Field30");
				String field31 = rs.getString("Expert_Field31");
				String field32 = rs.getString("Expert_Field32");
				String field33 = rs.getString("Expert_Field33");
				String field34 = rs.getString("Expert_Field34");
				String field35 = rs.getString("Expert_Field35");
				tempExpert = new Expert(field1, field2, field3, field4, field5, field6, field7, field8, field9,
						field10, field11, field12, field13, field14, field15, field16, field17, field18, field19,
						field20, field21, field22, field23, field24, field25, field26, field27, field28, field29,
						field30, field31, field32, field33, field34, field35);
				tempExperts.add(tempExpert);
			}
			return tempExperts;
		} catch (Exception ex) {
			System.out
					.println("GetExpert.java-getExpertByNumberAndJuryFromInfoView(String, String):List<Expert> Wrong!");
			// ex.printStackTrace();
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
				// ex.printStackTrace();
			}
		}
	}

	// 根据专家姓名和所在高评委查询专家
	public List<Expert> getExpertByNameAndJury(String name, String jury) {
		// 建立连接
		List<Expert> tempExperts = new ArrayList<Expert>();
		LinkDB link = new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;

		String sqlValue = "select * from expert_baseinfo where Expert_Field2 = '" + name + "' and"
				+ " Expert_Field31 = '" + jury + "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Expert tempExpert = null;
				// String id = rs.getString("Expert_id");
				String field1 = rs.getString("Expert_Field1");
				String field2 = rs.getString("Expert_Field2");
				String field3 = rs.getString("Expert_Field3");
				String field4 = rs.getString("Expert_Field4");
				String field5 = rs.getString("Expert_Field5");
				String field6 = rs.getString("Expert_Field6");
				String field7 = rs.getString("Expert_Field7");
				String field8 = rs.getString("Expert_Field8");
				String field9 = rs.getString("Expert_Field9");
				String field10 = rs.getString("Expert_Field10");
				String field11 = rs.getString("Expert_Field11");
				String field12 = rs.getString("Expert_Field12");
				String field13 = rs.getString("Expert_Field13");
				String field14 = rs.getString("Expert_Field14");
				String field15 = rs.getString("Expert_Field15");
				String field16 = rs.getString("Expert_Field16");
				String field17 = rs.getString("Expert_Field17");
				String field18 = rs.getString("Expert_Field18");
				String field19 = rs.getString("Expert_Field19");
				String field20 = rs.getString("Expert_Field20");
				String field21 = rs.getString("Expert_Field21");
				String field22 = rs.getString("Expert_Field22");
				String field23 = rs.getString("Expert_Field23");
				String field24 = rs.getString("Expert_Field24");
				String field25 = rs.getString("Expert_Field25");
				String field26 = rs.getString("Expert_Field26");
				String field27 = rs.getString("Expert_Field27");
				String field28 = rs.getString("Expert_Field28");
				String field29 = rs.getString("Expert_Field29");
				String field30 = rs.getString("Expert_Field30");
				String field31 = rs.getString("Expert_Field31");
				String field32 = rs.getString("Expert_Field32");
				String field33 = rs.getString("Expert_Field33");
				String field34 = rs.getString("Expert_Field34");
				String field35 = rs.getString("Expert_Field35");
				tempExpert = new Expert(field1, field2, field3, field4, field5, field6, field7, field8, field9,
						field10, field11, field12, field13, field14, field15, field16, field17, field18, field19,
						field20, field21, field22, field23, field24, field25, field26, field27, field28, field29,
						field30, field31, field32, field33, field34, field35);
				tempExperts.add(tempExpert);
			}
			return tempExperts;
		} catch (Exception ex) {
			System.out.println("GetExpert.java-getExpertByNameAndJury(String,String):List<Expert> Wrong!");
			// ex.printStackTrace();
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
				// ex.printStackTrace();
			}
		}
	}

	public List<Expert> getExpertByNameAndJuryFromInfoView(String name, String jury) {
		// 建立连接
		List<Expert> tempExperts = new ArrayList<Expert>();
		LinkDB link = new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;

		String sqlValue = "select * from infolistview where Expert_Field2 = '" + name + "' and" + " Expert_Field31 = '"
				+ jury + "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Expert tempExpert = null;
				// String id = rs.getString("Expert_id");
				String field1 = rs.getString("Expert_Field1");
				String field2 = rs.getString("Expert_Field2");
				String field3 = rs.getString("Expert_Field3");
				String field4 = rs.getString("Expert_Field4");
				String field5 = rs.getString("Expert_Field5");
				String field6 = rs.getString("Expert_Field6");
				String field7 = rs.getString("Expert_Field7");
				String field8 = rs.getString("Expert_Field8");
				String field9 = rs.getString("Expert_Field9");
				String field10 = rs.getString("Expert_Field10");
				String field11 = rs.getString("Expert_Field11");
				String field12 = rs.getString("Expert_Field12");
				String field13 = rs.getString("Expert_Field13");
				String field14 = rs.getString("Expert_Field14");
				String field15 = rs.getString("Expert_Field15");
				String field16 = rs.getString("Expert_Field16");
				String field17 = rs.getString("Expert_Field17");
				String field18 = rs.getString("Expert_Field18");
				String field19 = rs.getString("Expert_Field19");
				String field20 = rs.getString("Expert_Field20");
				String field21 = rs.getString("Expert_Field21");
				String field22 = rs.getString("Expert_Field22");
				String field23 = rs.getString("Expert_Field23");
				String field24 = rs.getString("Expert_Field24");
				String field25 = rs.getString("Expert_Field25");
				String field26 = rs.getString("Expert_Field26");
				String field27 = rs.getString("Expert_Field27");
				String field28 = rs.getString("Expert_Field28");
				String field29 = rs.getString("Expert_Field29");
				String field30 = rs.getString("Expert_Field30");
				String field31 = rs.getString("Expert_Field31");
				String field32 = rs.getString("Expert_Field32");
				String field33 = rs.getString("Expert_Field33");
				String field34 = rs.getString("Expert_Field34");
				String field35 = rs.getString("Expert_Field35");
				tempExpert = new Expert(field1, field2, field3, field4, field5, field6, field7, field8, field9,
						field10, field11, field12, field13, field14, field15, field16, field17, field18, field19,
						field20, field21, field22, field23, field24, field25, field26, field27, field28, field29,
						field30, field31, field32, field33, field34, field35);
				tempExperts.add(tempExpert);
			}
			return tempExperts;
		} catch (Exception ex) {
			System.out.println("GetExpert.java-getExpertByNameAndJury(String,String):List<Expert> Wrong!");
			// ex.printStackTrace();
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
				// ex.printStackTrace();
			}
		}
	}

	// 根据专家所在专业组和所在高评委查询专家
	public List<Expert> getExpertByGroupAndJury(String group, String jury) {
		// 建立连接
		List<Expert> tempExperts = new ArrayList<Expert>();
		LinkDB link = new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;

		String sqlValue = "select * from expert_baseinfo where Expert_Field33 = '" + group + "'"
				+ " and Expert_Field31 = '" + jury + "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Expert tempExpert = null;
				// String id = rs.getString("Expert_id");
				String field1 = rs.getString("Expert_Field1");
				String field2 = rs.getString("Expert_Field2");
				String field3 = rs.getString("Expert_Field3");
				String field4 = rs.getString("Expert_Field4");
				String field5 = rs.getString("Expert_Field5");
				String field6 = rs.getString("Expert_Field6");
				String field7 = rs.getString("Expert_Field7");
				String field8 = rs.getString("Expert_Field8");
				String field9 = rs.getString("Expert_Field9");
				String field10 = rs.getString("Expert_Field10");
				String field11 = rs.getString("Expert_Field11");
				String field12 = rs.getString("Expert_Field12");
				String field13 = rs.getString("Expert_Field13");
				String field14 = rs.getString("Expert_Field14");
				String field15 = rs.getString("Expert_Field15");
				String field16 = rs.getString("Expert_Field16");
				String field17 = rs.getString("Expert_Field17");
				String field18 = rs.getString("Expert_Field18");
				String field19 = rs.getString("Expert_Field19");
				String field20 = rs.getString("Expert_Field20");
				String field21 = rs.getString("Expert_Field21");
				String field22 = rs.getString("Expert_Field22");
				String field23 = rs.getString("Expert_Field23");
				String field24 = rs.getString("Expert_Field24");
				String field25 = rs.getString("Expert_Field25");
				String field26 = rs.getString("Expert_Field26");
				String field27 = rs.getString("Expert_Field27");
				String field28 = rs.getString("Expert_Field28");
				String field29 = rs.getString("Expert_Field29");
				String field30 = rs.getString("Expert_Field30");
				String field31 = rs.getString("Expert_Field31");
				String field32 = rs.getString("Expert_Field32");
				String field33 = rs.getString("Expert_Field33");
				String field34 = rs.getString("Expert_Field34");
				String field35 = rs.getString("Expert_Field35");
				tempExpert = new Expert(field1, field2, field3, field4, field5, field6, field7, field8, field9,
						field10, field11, field12, field13, field14, field15, field16, field17, field18, field19,
						field20, field21, field22, field23, field24, field25, field26, field27, field28, field29,
						field30, field31, field32, field33, field34, field35);
				tempExperts.add(tempExpert);
			}
			return tempExperts;
		} catch (Exception ex) {
			System.out.println("GetExpert.java-getExpertByGroupAndJury(String,String):List<Expert> Wrong!");
			// ex.printStackTrace();
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
				// ex.printStackTrace();
			}
		}
	}

	public List<Expert> getExpertByGroupAndJuryFromInfoView(String group, String jury) {
		// 建立连接
		List<Expert> tempExperts = new ArrayList<Expert>();
		LinkDB link = new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;

		String sqlValue = "select * from infolistview where Expert_Field33 = '" + group + "'"
				+ " and Expert_Field31 = '" + jury + "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Expert tempExpert = null;
				// String id = rs.getString("Expert_id");
				String field1 = rs.getString("Expert_Field1");
				String field2 = rs.getString("Expert_Field2");
				String field3 = rs.getString("Expert_Field3");
				String field4 = rs.getString("Expert_Field4");
				String field5 = rs.getString("Expert_Field5");
				String field6 = rs.getString("Expert_Field6");
				String field7 = rs.getString("Expert_Field7");
				String field8 = rs.getString("Expert_Field8");
				String field9 = rs.getString("Expert_Field9");
				String field10 = rs.getString("Expert_Field10");
				String field11 = rs.getString("Expert_Field11");
				String field12 = rs.getString("Expert_Field12");
				String field13 = rs.getString("Expert_Field13");
				String field14 = rs.getString("Expert_Field14");
				String field15 = rs.getString("Expert_Field15");
				String field16 = rs.getString("Expert_Field16");
				String field17 = rs.getString("Expert_Field17");
				String field18 = rs.getString("Expert_Field18");
				String field19 = rs.getString("Expert_Field19");
				String field20 = rs.getString("Expert_Field20");
				String field21 = rs.getString("Expert_Field21");
				String field22 = rs.getString("Expert_Field22");
				String field23 = rs.getString("Expert_Field23");
				String field24 = rs.getString("Expert_Field24");
				String field25 = rs.getString("Expert_Field25");
				String field26 = rs.getString("Expert_Field26");
				String field27 = rs.getString("Expert_Field27");
				String field28 = rs.getString("Expert_Field28");
				String field29 = rs.getString("Expert_Field29");
				String field30 = rs.getString("Expert_Field30");
				String field31 = rs.getString("Expert_Field31");
				String field32 = rs.getString("Expert_Field32");
				String field33 = rs.getString("Expert_Field33");
				String field34 = rs.getString("Expert_Field34");
				String field35 = rs.getString("Expert_Field35");
				tempExpert = new Expert(field1, field2, field3, field4, field5, field6, field7, field8, field9,
						field10, field11, field12, field13, field14, field15, field16, field17, field18, field19,
						field20, field21, field22, field23, field24, field25, field26, field27, field28, field29,
						field30, field31, field32, field33, field34, field35);
				tempExperts.add(tempExpert);
			}
			return tempExperts;
		} catch (Exception ex) {
			System.out.println("GetExpert.java-getExpertByGroupAndJury(String,String):List<Expert> Wrong!");
			// ex.printStackTrace();
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
				// ex.printStackTrace();
			}
		}
	}

	// 根据专家所在工作单位和专业组查询专家
	public List<Expert> getExpertByWorkplaceAndJury(String workplace, String jury) {
		// 建立连接
		List<Expert> tempExperts = new ArrayList<Expert>();
		LinkDB link = new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;

		String sqlValue = "select * from expert_baseinfo where Expert_Field14 = '" + workplace + "'"
				+ " and Expert_Field31 = '" + jury + "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Expert tempExpert = null;
				// String id = rs.getString("Expert_id");
				String field1 = rs.getString("Expert_Field1");
				String field2 = rs.getString("Expert_Field2");
				String field3 = rs.getString("Expert_Field3");
				String field4 = rs.getString("Expert_Field4");
				String field5 = rs.getString("Expert_Field5");
				String field6 = rs.getString("Expert_Field6");
				String field7 = rs.getString("Expert_Field7");
				String field8 = rs.getString("Expert_Field8");
				String field9 = rs.getString("Expert_Field9");
				String field10 = rs.getString("Expert_Field10");
				String field11 = rs.getString("Expert_Field11");
				String field12 = rs.getString("Expert_Field12");
				String field13 = rs.getString("Expert_Field13");
				String field14 = rs.getString("Expert_Field14");
				String field15 = rs.getString("Expert_Field15");
				String field16 = rs.getString("Expert_Field16");
				String field17 = rs.getString("Expert_Field17");
				String field18 = rs.getString("Expert_Field18");
				String field19 = rs.getString("Expert_Field19");
				String field20 = rs.getString("Expert_Field20");
				String field21 = rs.getString("Expert_Field21");
				String field22 = rs.getString("Expert_Field22");
				String field23 = rs.getString("Expert_Field23");
				String field24 = rs.getString("Expert_Field24");
				String field25 = rs.getString("Expert_Field25");
				String field26 = rs.getString("Expert_Field26");
				String field27 = rs.getString("Expert_Field27");
				String field28 = rs.getString("Expert_Field28");
				String field29 = rs.getString("Expert_Field29");
				String field30 = rs.getString("Expert_Field30");
				String field31 = rs.getString("Expert_Field31");
				String field32 = rs.getString("Expert_Field32");
				String field33 = rs.getString("Expert_Field33");
				String field34 = rs.getString("Expert_Field34");
				String field35 = rs.getString("Expert_Field35");
				tempExpert = new Expert(field1, field2, field3, field4, field5, field6, field7, field8, field9,
						field10, field11, field12, field13, field14, field15, field16, field17, field18, field19,
						field20, field21, field22, field23, field24, field25, field26, field27, field28, field29,
						field30, field31, field32, field33, field34, field35);
				tempExperts.add(tempExpert);
			}
			return tempExperts;
		} catch (Exception ex) {
			System.out.println("GetExpert.java-GetExpertByWorkplaceAndJury(String,String):List<Expert> Wrong!");
			// ex.printStackTrace();
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
				// ex.printStackTrace();
			}
		}
	}

	public List<Expert> getExpertByWorkplaceAndJuryFromInfoView(String workplace, String jury) {
		// 建立连接
		List<Expert> tempExperts = new ArrayList<Expert>();
		LinkDB link = new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;

		String sqlValue = "select * from infolistview where Expert_Field14 = '" + workplace + "'"
				+ " and Expert_Field31 = '" + jury + "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Expert tempExpert = null;
				// String id = rs.getString("Expert_id");
				String field1 = rs.getString("Expert_Field1");
				String field2 = rs.getString("Expert_Field2");
				String field3 = rs.getString("Expert_Field3");
				String field4 = rs.getString("Expert_Field4");
				String field5 = rs.getString("Expert_Field5");
				String field6 = rs.getString("Expert_Field6");
				String field7 = rs.getString("Expert_Field7");
				String field8 = rs.getString("Expert_Field8");
				String field9 = rs.getString("Expert_Field9");
				String field10 = rs.getString("Expert_Field10");
				String field11 = rs.getString("Expert_Field11");
				String field12 = rs.getString("Expert_Field12");
				String field13 = rs.getString("Expert_Field13");
				String field14 = rs.getString("Expert_Field14");
				String field15 = rs.getString("Expert_Field15");
				String field16 = rs.getString("Expert_Field16");
				String field17 = rs.getString("Expert_Field17");
				String field18 = rs.getString("Expert_Field18");
				String field19 = rs.getString("Expert_Field19");
				String field20 = rs.getString("Expert_Field20");
				String field21 = rs.getString("Expert_Field21");
				String field22 = rs.getString("Expert_Field22");
				String field23 = rs.getString("Expert_Field23");
				String field24 = rs.getString("Expert_Field24");
				String field25 = rs.getString("Expert_Field25");
				String field26 = rs.getString("Expert_Field26");
				String field27 = rs.getString("Expert_Field27");
				String field28 = rs.getString("Expert_Field28");
				String field29 = rs.getString("Expert_Field29");
				String field30 = rs.getString("Expert_Field30");
				String field31 = rs.getString("Expert_Field31");
				String field32 = rs.getString("Expert_Field32");
				String field33 = rs.getString("Expert_Field33");
				String field34 = rs.getString("Expert_Field34");
				String field35 = rs.getString("Expert_Field35");
				tempExpert = new Expert(field1, field2, field3, field4, field5, field6, field7, field8, field9,
						field10, field11, field12, field13, field14, field15, field16, field17, field18, field19,
						field20, field21, field22, field23, field24, field25, field26, field27, field28, field29,
						field30, field31, field32, field33, field34, field35);
				tempExperts.add(tempExpert);
			}
			return tempExperts;
		} catch (Exception ex) {
			System.out
					.println("GetExpert.java-GetExpertByWorkplaceAndJuryFromInfoView(String,String):List<Expert> Wrong!");
			// ex.printStackTrace();
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
				// ex.printStackTrace();
			}
		}
	}

	// 综合查询
	public List<Expert> searchExpertWithChField(List<String> chField, List<String> value) {
		List<Expert> tempExperts = new ArrayList<Expert>();
		LinkDB link = new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;

		String sqlValue = "select * from expert_baseinfo where ";
		for (int i = 0; i < chField.size(); i++) {
			sqlValue += chField.get(i) + "='" + value.get(i) + "' and ";
		}
		sqlValue = sqlValue.substring(0, sqlValue.length() - 5);
		System.out.println(sqlValue);
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Expert tempExpert = null;
				// String id = rs.getString("Expert_id");
				String field1 = rs.getString("Expert_Field1");
				String field2 = rs.getString("Expert_Field2");
				String field3 = rs.getString("Expert_Field3");
				String field4 = rs.getString("Expert_Field4");
				String field5 = rs.getString("Expert_Field5");
				String field6 = rs.getString("Expert_Field6");
				String field7 = rs.getString("Expert_Field7");
				String field8 = rs.getString("Expert_Field8");
				String field9 = rs.getString("Expert_Field9");
				String field10 = rs.getString("Expert_Field10");
				String field11 = rs.getString("Expert_Field11");
				String field12 = rs.getString("Expert_Field12");
				String field13 = rs.getString("Expert_Field13");
				String field14 = rs.getString("Expert_Field14");
				String field15 = rs.getString("Expert_Field15");
				String field16 = rs.getString("Expert_Field16");
				String field17 = rs.getString("Expert_Field17");
				String field18 = rs.getString("Expert_Field18");
				String field19 = rs.getString("Expert_Field19");
				String field20 = rs.getString("Expert_Field20");
				String field21 = rs.getString("Expert_Field21");
				String field22 = rs.getString("Expert_Field22");
				String field23 = rs.getString("Expert_Field23");
				String field24 = rs.getString("Expert_Field24");
				String field25 = rs.getString("Expert_Field25");
				String field26 = rs.getString("Expert_Field26");
				String field27 = rs.getString("Expert_Field27");
				String field28 = rs.getString("Expert_Field28");
				String field29 = rs.getString("Expert_Field29");
				String field30 = rs.getString("Expert_Field30");
				String field31 = rs.getString("Expert_Field31");
				String field32 = rs.getString("Expert_Field32");
				String field33 = rs.getString("Expert_Field33");
				String field34 = rs.getString("Expert_Field34");
				String field35 = rs.getString("Expert_Field35");
				System.out.println(field35);
				tempExpert = new Expert(field1, field2, field3, field4, field5, field6, field7, field8, field9,
						field10, field11, field12, field13, field14, field15, field16, field17, field18, field19,
						field20, field21, field22, field23, field24, field25, field26, field27, field28, field29,
						field30, field31, field32, field33, field34, field35);
				System.out.println(tempExpert.getExpert_Field1());
				tempExperts.add(tempExpert);
			}

			return tempExperts;
		} catch (Exception ex) {
			System.out.println("GetExpert.java-searchExpertWithChField(List<String>,List<String>):List<Expert> Wrong!");
			// ex.printStackTrace();
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
				// ex.printStackTrace();
			}
		}
	}
	
	public List<Expert> searchExpertFromInfoView(List<String> chField, List<String> value) {
		List<Expert> tempExperts = new ArrayList<Expert>();
		LinkDB link = new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;

		String sqlValue = "select * from infolistview where ";
		for (int i = 0; i < chField.size(); i++) {
			sqlValue += chField.get(i) + " like'%" + value.get(i) + "%' and ";
		}
		sqlValue = sqlValue.substring(0, sqlValue.length() - 5);
//		sqlValue = sqlValue.replace("2='", "2 like '%");
		
		System.out.println(sqlValue);
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Expert tempExpert = null;
				// String id = rs.getString("Expert_id");
				String field1 = rs.getString("Expert_Field1");
				String field2 = rs.getString("Expert_Field2");
				String field3 = rs.getString("Expert_Field3");
				String field4 = rs.getString("Expert_Field4");
				String field5 = rs.getString("Expert_Field5");
				String field6 = rs.getString("Expert_Field6");
				String field7 = rs.getString("Expert_Field7");
				String field8 = rs.getString("Expert_Field8");
				String field9 = rs.getString("Expert_Field9");
				String field10 = rs.getString("Expert_Field10");
				String field11 = rs.getString("Expert_Field11");
				String field12 = rs.getString("Expert_Field12");
				String field13 = rs.getString("Expert_Field13");
				String field14 = rs.getString("Expert_Field14");
				String field15 = rs.getString("Expert_Field15");
				String field16 = rs.getString("Expert_Field16");
				String field17 = rs.getString("Expert_Field17");
				String field18 = rs.getString("Expert_Field18");
				String field19 = rs.getString("Expert_Field19");
				String field20 = rs.getString("Expert_Field20");
				String field21 = rs.getString("Expert_Field21");
				String field22 = rs.getString("Expert_Field22");
				String field23 = rs.getString("Expert_Field23");
				String field24 = rs.getString("Expert_Field24");
				String field25 = rs.getString("Expert_Field25");
				String field26 = rs.getString("Expert_Field26");
				String field27 = rs.getString("Expert_Field27");
				String field28 = rs.getString("Expert_Field28");
				String field29 = rs.getString("Expert_Field29");
				String field30 = rs.getString("Expert_Field30");
				String field31 = rs.getString("Expert_Field31");
				String field32 = rs.getString("Expert_Field32");
				String field33 = rs.getString("Expert_Field33");
				String field34 = rs.getString("Expert_Field34");
				String field35 = rs.getString("Expert_Field35");
				System.out.println(field35);
				tempExpert = new Expert(field1, field2, field3, field4, field5, field6, field7, field8, field9,
						field10, field11, field12, field13, field14, field15, field16, field17, field18, field19,
						field20, field21, field22, field23, field24, field25, field26, field27, field28, field29,
						field30, field31, field32, field33, field34, field35);
				System.out.println(tempExpert.getExpert_Field1());
				tempExperts.add(tempExpert);
			}

			return tempExperts;
		} catch (Exception ex) {
			System.out.println("GetExpert.java-searchExpertFromInfoView(List<String>,List<String>):List<Expert> Wrong!");
			// ex.printStackTrace();
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
				// ex.printStackTrace();
			}
		}
	}

	// //main函数测试
	// public static void main(String args[]){
	// List<String> test1 = new ArrayList<String>();
	// List<String> test2 = new ArrayList<String>();
	// // test1.add("Expert_Field1");
	// test1.add("Expert_Field3");
	// // test2.add("01020001");
	// test2.add("2");
	// GetExpert temp = new GetExpert();
	// //temp.searchExpert(test1, test2);
	// System.out.println(temp.searchExpertWithEnField(test1, test2).size());
	// }

	public List<Expert> searchExpertWithEnField(List<String> enField, List<String> value) {
		List<Expert> tempExperts = new ArrayList<Expert>();
		LinkDB link = new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;

		String sqlValue = "select * from expert_baseinfo where ";
		for (int i = 0; i < enField.size(); i++) {
			sqlValue += enField.get(i) + "='" + value.get(i) + "' and ";
		}
		sqlValue = sqlValue.substring(0, sqlValue.length() - 5);
		System.out.println(sqlValue);
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Expert tempExpert = null;
				// String id = rs.getString("Expert_id");
				String field1 = rs.getString("Expert_Field1");
				String field2 = rs.getString("Expert_Field2");
				String field3 = rs.getString("Expert_Field3");
				String field4 = rs.getString("Expert_Field4");
				String field5 = rs.getString("Expert_Field5");
				String field6 = rs.getString("Expert_Field6");
				String field7 = rs.getString("Expert_Field7");
				String field8 = rs.getString("Expert_Field8");
				String field9 = rs.getString("Expert_Field9");
				String field10 = rs.getString("Expert_Field10");
				String field11 = rs.getString("Expert_Field11");
				String field12 = rs.getString("Expert_Field12");
				String field13 = rs.getString("Expert_Field13");
				String field14 = rs.getString("Expert_Field14");
				String field15 = rs.getString("Expert_Field15");
				String field16 = rs.getString("Expert_Field16");
				String field17 = rs.getString("Expert_Field17");
				String field18 = rs.getString("Expert_Field18");
				String field19 = rs.getString("Expert_Field19");
				String field20 = rs.getString("Expert_Field20");
				String field21 = rs.getString("Expert_Field21");
				String field22 = rs.getString("Expert_Field22");
				String field23 = rs.getString("Expert_Field23");
				String field24 = rs.getString("Expert_Field24");
				String field25 = rs.getString("Expert_Field25");
				String field26 = rs.getString("Expert_Field26");
				String field27 = rs.getString("Expert_Field27");
				String field28 = rs.getString("Expert_Field28");
				String field29 = rs.getString("Expert_Field29");
				String field30 = rs.getString("Expert_Field30");
				String field31 = rs.getString("Expert_Field31");
				String field32 = rs.getString("Expert_Field32");
				String field33 = rs.getString("Expert_Field33");
				String field34 = rs.getString("Expert_Field34");
				String field35 = rs.getString("Expert_Field35");
				System.out.println(field35);
				tempExpert = new Expert(field1, field2, field3, field4, field5, field6, field7, field8, field9,
						field10, field11, field12, field13, field14, field15, field16, field17, field18, field19,
						field20, field21, field22, field23, field24, field25, field26, field27, field28, field29,
						field30, field31, field32, field33, field34, field35);
				System.out.println(tempExpert.getExpert_Field1());
				tempExperts.add(tempExpert);
			}

			return tempExperts;
		} catch (Exception ex) {
			System.out.println("get all experts' info Wrong!");
			// ex.printStackTrace();
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
				// ex.printStackTrace();
			}
		}
	}
	// public static void main(String args[]){
	// GetExpert test = new GetExpert();
	// System.out.println(test.getAllExperts().get(0).getExpert_Field34());
	// }
}
