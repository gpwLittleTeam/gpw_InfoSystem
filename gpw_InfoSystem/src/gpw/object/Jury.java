package gpw.object;

import gpw.connection.LinkDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Jury {
	//private String Jury_id;
	private String Jury_no;
	private String Jury_name;
	private String Jury_type;
	private String Jury_power;
	private String Jury_qualiname;
	private String Jury_dept;
	private String Jury_comments;
	private String Jury_date;
	
	public Jury(){
		
	}
	
	public Jury(String Jury_no, String Jury_name,
			String Jury_type, String Jury_power, String Jury_qualiname,
			String Jury_dept, String Jury_comments, String Jury_date){
		//this.Jury_id = Jury_id;
		this.Jury_no = Jury_no;
		this.Jury_name = Jury_name;
		this.Jury_type = Jury_type;
		this.Jury_power = Jury_power;
		this.Jury_qualiname = Jury_qualiname;
		this.Jury_dept = Jury_dept;
		this.Jury_comments = Jury_comments;
		this.Jury_date = Jury_date;
	}

//	public String getJury_id() {
//		return Jury_id;
//	}
//
//	public void setJury_id(String jury_id) {
//		Jury_id = jury_id;
//	}

	public String getJury_no() {
		return Jury_no;
	}

	public void setJury_no(String jury_no) {
		Jury_no = jury_no;
	}

	public String getJury_name() {
		return Jury_name;
	}

	public void setJury_name(String jury_name) {
		Jury_name = jury_name;
	}

	public String getJury_type() {
		return Jury_type;
	}

	public void setJury_type(String jury_type) {
		Jury_type = jury_type;
	}

	public String getJury_power() {
		return Jury_power;
	}

	public void setJury_power(String jury_power) {
		Jury_power = jury_power;
	}

	public String getJury_qualiname() {
		return Jury_qualiname;
	}

	public void setJury_qualiname(String jury_qualiname) {
		Jury_qualiname = jury_qualiname;
	}

	public String getJury_dept() {
		return Jury_dept;
	}

	public void setJury_dept(String jury_dept) {
		Jury_dept = jury_dept;
	}

	public String getJury_comments() {
		return Jury_comments;
	}

	public void setJury_comments(String jury_comments) {
		Jury_comments = jury_comments;
	}

	public String getJury_date() {
		return Jury_date;
	}

	public void setJury_date(String jury_date) {
		Jury_date = jury_date;
	}
	
	public List<String> getAllJuryNo(){
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		List<String> result = new ArrayList<String>();
		String sqlValue = "select Jury_no from jury_dept";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				result.add(rs.getString("Jury_no"));
			}
			return result;
		} catch (Exception ex) {
			System.out.println("get all Jury_no wrong!");
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

	
	public List<String> getAllJuryName(){
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		List<String> result = new ArrayList<String>();
		String sqlValue = "select Jury_name from jury_dept";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				result.add(rs.getString("Jury_name"));
			}
			return result;
		} catch (Exception ex) {
			System.out.println("get all group_no wrong!");
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
	
	public String getJuryNoByJuryName(String juryName){
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String result = null;
		String sqlValue1 = "select Jury_no from jury_dept where Jury_name ='" +juryName+ "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue1);
			while (rs.next()) {
				result = rs.getString("Jury_no");
			}
			return result;
		} catch (Exception ex) {
			System.out.println("Jury.java-getJuryNoByJuryName(String) wrong!");
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
	
	public String getJuryNameByJuryNo(String juryNo){
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String result = null;
		String sqlValue1 = "select Jury_name from jury_dept where Jury_no ='" +juryNo+ "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue1);
			while (rs.next()) {
				result = rs.getString("Jury_name");
			}
			return result;
		} catch (Exception ex) {
			System.out.println("Jury.java-getJuryNameByJuryNo(int) wrong!");
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
	
	public String getJuryTypeByJuryNo(int juryNo){
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String result = null;
		String sqlValue1 = "select Jury_type from jury_dept where Jury_no ='" +juryNo+ "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue1);
			while (rs.next()) {
				result = rs.getString("Jury_type");
			}
			return result;
		} catch (Exception ex) {
			System.out.println("Jury.java-getJuryTypeByJuryNo(int) wrong!");
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
	
	public String getJuryPowerByJuryNo(String juryNo){
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String result = null;
		String sqlValue1 = "select Jury_power from jury_dept where Jury_no ='" +juryNo+ "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue1);
			while (rs.next()) {
				result = rs.getString("Jury_power");
			}
			return result;
		} catch (Exception ex) {
			System.out.println("Jury.java-getJuryPowerByJuryNo(int) wrong!");
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
	
	public String getJuryQualinameByJuryNo(int juryNo){
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String result = null;
		String sqlValue1 = "select Jury_qualiname from jury_dept where Jury_no ='" +juryNo+ "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue1);
			while (rs.next()) {
				result = rs.getString("Jury_qualiname");
			}
			return result;
		} catch (Exception ex) {
			System.out.println("Jury.java-getJuryQualinameByJuryNo(int) wrong!");
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
	
	public String getJuryDeptByJuryNo(int juryNo){
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String result = null;
		String sqlValue1 = "select Jury_dept from jury_dept where Jury_no ='" +juryNo+ "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue1);
			while (rs.next()) {
				result = rs.getString("Jury_dept");
			}
			return result;
		} catch (Exception ex) {
			System.out.println("Jury.java-getJuryDeptByJuryNo(int) wrong!");
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
	
	public String getJuryCommentsByJuryNo(int juryNo){
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String result = null;
		String sqlValue1 = "select Jury_comments from jury_dept where Jury_no ='" +juryNo+ "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue1);
			while (rs.next()) {
				result = rs.getString("Jury_comments");
			}
			return result;
		} catch (Exception ex) {
			System.out.println("Jury.java-getJuryCommentsByJuryNo(int) wrong!");
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
