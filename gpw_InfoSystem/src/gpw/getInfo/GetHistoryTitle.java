package gpw.getInfo;

import gpw.connection.LinkDB;
import gpw.object.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetHistoryTitle {
	public GetHistoryTitle(){
		
	}
	
	public List<Historytitle> getAllHistoryTitles(){
		List<Historytitle> result = new ArrayList<Historytitle>();
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from history_title";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Historytitle tempHistorytitle = null;
				String field1 = rs.getString("expert_no");
				String field2 = rs.getString("expert_name");
				String field3 = rs.getString("expert_jury");
				String field4 = rs.getString("expert_group");
				String field5 = rs.getString("expert_post");
				String field6 = rs.getString("expert_serveyear");
				tempHistorytitle = new Historytitle(field1, field2, field3, field4, field5,
										field6);
				result.add(tempHistorytitle);
			}
			
			return result;
		} catch (Exception ex) {
			System.out.println("GetHistoryTitle.java-getAllHistoryTitles() wrong!");
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
//		GetHistoryTitle test = new GetHistoryTitle();
//		System.out.println(test.getAllHistoryTitles().get(0).getExpert_name());
//	}
	
	public List<Historytitle> getHistoryTitlesByExpertNo(String expertNo){
		List<Historytitle> result = new ArrayList<Historytitle>();
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from history_title where expert_no='"+expertNo+"'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Historytitle tempHistorytitle = null;
				String field1 = rs.getString("expert_no");
				String field2 = rs.getString("expert_name");
				String field3 = rs.getString("expert_jury");
				String field4 = rs.getString("expert_group");
				String field5 = rs.getString("expert_post");
				String field6 = rs.getString("expert_serveyear");
				tempHistorytitle = new Historytitle(field1, field2, field3, field4, field5,
										field6);
				result.add(tempHistorytitle);
			}
			
			return result;
		} catch (Exception ex) {
			System.out.println("GetHistoryTitle.java-getHistoryTitlesByExpertNo(String) wrong!");
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
	
	public List<Historytitle> getHistoryTitlesByExpertName(String expertName){
		List<Historytitle> result = new ArrayList<Historytitle>();
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from history_title where expert_name='"+expertName+"'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Historytitle tempHistorytitle = null;
				String field1 = rs.getString("expert_no");
				String field2 = rs.getString("expert_name");
				String field3 = rs.getString("expert_jury");
				String field4 = rs.getString("expert_group");
				String field5 = rs.getString("expert_post");
				String field6 = rs.getString("expert_serveyear");
				tempHistorytitle = new Historytitle(field1, field2, field3, field4, field5,
										field6);
				result.add(tempHistorytitle);
			}
			
			return result;
		} catch (Exception ex) {
			System.out.println("GetHistoryTitle.java-getHistoryTitlesByExpertName(String) wrong!");
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
	
	public List<Historytitle> getHistoryTitlesByExpertJury(String expertJury){
		List<Historytitle> result = new ArrayList<Historytitle>();
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from history_title where expert_jury='"+expertJury+"'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Historytitle tempHistorytitle = null;
				String field1 = rs.getString("expert_no");
				String field2 = rs.getString("expert_name");
				String field3 = rs.getString("expert_jury");
				String field4 = rs.getString("expert_group");
				String field5 = rs.getString("expert_post");
				String field6 = rs.getString("expert_serveyear");
				tempHistorytitle = new Historytitle(field1, field2, field3, field4, field5,
										field6);
				result.add(tempHistorytitle);
			}
			
			return result;
		} catch (Exception ex) {
			System.out.println("GetHistoryTitle.java-getHistoryTitlesByExpertJury(String) wrong!");
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
	
	public List<Historytitle> getHistoryTitlesByExpertGroup(String expertGroup){
		List<Historytitle> result = new ArrayList<Historytitle>();
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from history_title where expert_group='"+expertGroup+"'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Historytitle tempHistorytitle = null;
				String field1 = rs.getString("expert_no");
				String field2 = rs.getString("expert_name");
				String field3 = rs.getString("expert_jury");
				String field4 = rs.getString("expert_group");
				String field5 = rs.getString("expert_post");
				String field6 = rs.getString("expert_serveyear");
				tempHistorytitle = new Historytitle(field1, field2, field3, field4, field5,
										field6);
				result.add(tempHistorytitle);
			}
			
			return result;
		} catch (Exception ex) {
			System.out.println("GetHistoryTitle.java-getHistoryTitlesByExpertGroup(String) wrong!");
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
	
	public List<Historytitle> getHistoryTitlesByExpertPost(String expertPost){
		List<Historytitle> result = new ArrayList<Historytitle>();
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from history_title where expert_post='"+expertPost+"'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Historytitle tempHistorytitle = null;
				String field1 = rs.getString("expert_no");
				String field2 = rs.getString("expert_name");
				String field3 = rs.getString("expert_jury");
				String field4 = rs.getString("expert_group");
				String field5 = rs.getString("expert_post");
				String field6 = rs.getString("expert_serveyear");
				tempHistorytitle = new Historytitle(field1, field2, field3, field4, field5,
										field6);
				result.add(tempHistorytitle);
			}
			
			return result;
		} catch (Exception ex) {
			System.out.println("GetHistoryTitle.java-getHistoryTitlesByExpertPost(String) wrong!");
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
	
	public List<Historytitle> getHistoryTitlesByExpertServeyear(String expertServeyear){
		List<Historytitle> result = new ArrayList<Historytitle>();
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from history_title where expert_serveyear='"+expertServeyear+"'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Historytitle tempHistorytitle = null;
				String field1 = rs.getString("expert_no");
				String field2 = rs.getString("expert_name");
				String field3 = rs.getString("expert_jury");
				String field4 = rs.getString("expert_group");
				String field5 = rs.getString("expert_post");
				String field6 = rs.getString("expert_serveyear");
				tempHistorytitle = new Historytitle(field1, field2, field3, field4, field5,
										field6);
				result.add(tempHistorytitle);
			}
			
			return result;
		} catch (Exception ex) {
			System.out.println("GetHistoryTitle.java-getHistoryTitlesByExpertServeyear(String) wrong!");
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
	
	
	public List<Historytitle> getAllHistoryTitlesInView(){
		List<Historytitle> result = new ArrayList<Historytitle>();
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from historytitleview";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Historytitle tempHistorytitle = null;
				String field1 = rs.getString("expert_no");
				String field2 = rs.getString("expert_name");
				String field3 = rs.getString("expert_jury");
				String field4 = rs.getString("expert_group");
				String field5 = rs.getString("expert_post");
				String field6 = rs.getString("expert_serveyear");
				tempHistorytitle = new Historytitle(field1, field2, field3, field4, field5,
										field6);
				result.add(tempHistorytitle);
			}
			
			return result;
		} catch (Exception ex) {
			System.out.println("GetHistoryTitle.java-getAllHistoryTitlesInView() wrong!");
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
		GetHistoryTitle test = new GetHistoryTitle();
		System.out.println(test.getAllHistoryTitlesInView().get(0).getExpert_jury());
	}
	
	public List<Historytitle> getHistoryTitlesByExpertNoInView(String expertNo){
		List<Historytitle> result = new ArrayList<Historytitle>();
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from historytitleview where expert_no='"+expertNo+"'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Historytitle tempHistorytitle = null;
				String field1 = rs.getString("expert_no");
				String field2 = rs.getString("expert_name");
				String field3 = rs.getString("expert_jury");
				String field4 = rs.getString("expert_group");
				String field5 = rs.getString("expert_post");
				String field6 = rs.getString("expert_serveyear");
				tempHistorytitle = new Historytitle(field1, field2, field3, field4, field5,
										field6);
				result.add(tempHistorytitle);
			}
			
			return result;
		} catch (Exception ex) {
			System.out.println("GetHistoryTitle.java-getHistoryTitlesByExpertNoInView(String) wrong!");
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
	
	public List<Historytitle> getHistoryTitlesByExpertNameInView(String expertName){
		List<Historytitle> result = new ArrayList<Historytitle>();
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from historytitleview where expert_name='"+expertName+"'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Historytitle tempHistorytitle = null;
				String field1 = rs.getString("expert_no");
				String field2 = rs.getString("expert_name");
				String field3 = rs.getString("expert_jury");
				String field4 = rs.getString("expert_group");
				String field5 = rs.getString("expert_post");
				String field6 = rs.getString("expert_serveyear");
				tempHistorytitle = new Historytitle(field1, field2, field3, field4, field5,
										field6);
				result.add(tempHistorytitle);
			}
			
			return result;
		} catch (Exception ex) {
			System.out.println("GetHistoryTitle.java-getHistoryTitlesByExpertNameInView(String) wrong!");
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
	
	public List<Historytitle> getHistoryTitlesByNameAndJuryNoInView(String expertName,String juryNo){
		List<Historytitle> result = new ArrayList<Historytitle>();
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from historytitleview where expert_name='"+expertName+"'"
				+ " and expert_jury='"+juryNo+"'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Historytitle tempHistorytitle = null;
				String field1 = rs.getString("expert_no");
				String field2 = rs.getString("expert_name");
				String field3 = rs.getString("expert_jury");
				String field4 = rs.getString("expert_group");
				String field5 = rs.getString("expert_post");
				String field6 = rs.getString("expert_serveyear");
				tempHistorytitle = new Historytitle(field1, field2, field3, field4, field5,
										field6);
				result.add(tempHistorytitle);
			}
			
			return result;
		} catch (Exception ex) {
			System.out.println("GetHistoryTitle.java-getHistoryTitlesByNameAndJuryNoInView(String,String):List<Historytitle> wrong!");
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
	
	public List<Historytitle> getHistoryTitlesByExpertJuryInView(String expertJury){
		List<Historytitle> result = new ArrayList<Historytitle>();
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from historytitleview where expert_jury='"+expertJury+"'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Historytitle tempHistorytitle = null;
				String field1 = rs.getString("expert_no");
				String field2 = rs.getString("expert_name");
				String field3 = rs.getString("expert_jury");
				String field4 = rs.getString("expert_group");
				String field5 = rs.getString("expert_post");
				String field6 = rs.getString("expert_serveyear");
				tempHistorytitle = new Historytitle(field1, field2, field3, field4, field5,
										field6);
				result.add(tempHistorytitle);
			}
			
			return result;
		} catch (Exception ex) {
			System.out.println("GetHistoryTitle.java-getHistoryTitlesByExpertJuryInView(String) wrong!");
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
	
	public List<Historytitle> getHistoryTitlesByExpertGroupInView(String expertGroup){
		List<Historytitle> result = new ArrayList<Historytitle>();
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from historytitleview where expert_group='"+expertGroup+"'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Historytitle tempHistorytitle = null;
				String field1 = rs.getString("expert_no");
				String field2 = rs.getString("expert_name");
				String field3 = rs.getString("expert_jury");
				String field4 = rs.getString("expert_group");
				String field5 = rs.getString("expert_post");
				String field6 = rs.getString("expert_serveyear");
				tempHistorytitle = new Historytitle(field1, field2, field3, field4, field5,
										field6);
				result.add(tempHistorytitle);
			}
			
			return result;
		} catch (Exception ex) {
			System.out.println("GetHistoryTitle.java-getHistoryTitlesByExpertGroupInView(String) wrong!");
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
	
	public List<Historytitle> getHistoryTitlesByGroupAndJuryNoInView(String expertGroup,String juryNo){
		List<Historytitle> result = new ArrayList<Historytitle>();
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from historytitleview where expert_group='"+expertGroup+"'"
				+ " and expert_jury='"+juryNo+"'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Historytitle tempHistorytitle = null;
				String field1 = rs.getString("expert_no");
				String field2 = rs.getString("expert_name");
				String field3 = rs.getString("expert_jury");
				String field4 = rs.getString("expert_group");
				String field5 = rs.getString("expert_post");
				String field6 = rs.getString("expert_serveyear");
				tempHistorytitle = new Historytitle(field1, field2, field3, field4, field5,
										field6);
				result.add(tempHistorytitle);
			}
			
			return result;
		} catch (Exception ex) {
			System.out.println("GetHistoryTitle.java-getHistoryTitlesByGroupAndJuryNoInView(String,String):List<Historytitle> wrong!");
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
	
	public List<Historytitle> getHistoryTitlesByExpertPostInView(String expertPost){
		List<Historytitle> result = new ArrayList<Historytitle>();
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from historytitleview where expert_post='"+expertPost+"'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Historytitle tempHistorytitle = null;
				String field1 = rs.getString("expert_no");
				String field2 = rs.getString("expert_name");
				String field3 = rs.getString("expert_jury");
				String field4 = rs.getString("expert_group");
				String field5 = rs.getString("expert_post");
				String field6 = rs.getString("expert_serveyear");
				tempHistorytitle = new Historytitle(field1, field2, field3, field4, field5,
										field6);
				result.add(tempHistorytitle);
			}
			
			return result;
		} catch (Exception ex) {
			System.out.println("GetHistoryTitle.java-getHistoryTitlesByExpertPostInView(String) wrong!");
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
	
	public List<Historytitle> getHistoryTitlesByPostAndJuryNoInView(String expertPost,String juryNo){
		List<Historytitle> result = new ArrayList<Historytitle>();
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from historytitleview where expert_post='"+expertPost+"'"
				+ " and expert_jury='"+juryNo+"'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Historytitle tempHistorytitle = null;
				String field1 = rs.getString("expert_no");
				String field2 = rs.getString("expert_name");
				String field3 = rs.getString("expert_jury");
				String field4 = rs.getString("expert_group");
				String field5 = rs.getString("expert_post");
				String field6 = rs.getString("expert_serveyear");
				tempHistorytitle = new Historytitle(field1, field2, field3, field4, field5,
										field6);
				result.add(tempHistorytitle);
			}
			
			return result;
		} catch (Exception ex) {
			System.out.println("GetHistoryTitle.java-getHistoryTitlesByPostAndJuryNoInView(String,String):List<Historytitle> wrong!");
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
	
	public List<Historytitle> getHistoryTitlesByExpertServeyearInView(String expertServeyear){
		List<Historytitle> result = new ArrayList<Historytitle>();
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from historytitleview where expert_serveyear='"+expertServeyear+"'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Historytitle tempHistorytitle = null;
				String field1 = rs.getString("expert_no");
				String field2 = rs.getString("expert_name");
				String field3 = rs.getString("expert_jury");
				String field4 = rs.getString("expert_group");
				String field5 = rs.getString("expert_post");
				String field6 = rs.getString("expert_serveyear");
				tempHistorytitle = new Historytitle(field1, field2, field3, field4, field5,
										field6);
				result.add(tempHistorytitle);
			}
			
			return result;
		} catch (Exception ex) {
			System.out.println("GetHistoryTitle.java-getHistoryTitlesByExpertServeyearInView(String) wrong!");
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
	
	public List<Historytitle> getHistoryTitlesByServeyearAndJuryNoInView(String expertServeyear,String juryNo){
		List<Historytitle> result = new ArrayList<Historytitle>();
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from historytitleview where expert_serveyear='"+expertServeyear+"'"
				+ " and expert_jury='"+juryNo+"'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Historytitle tempHistorytitle = null;
				String field1 = rs.getString("expert_no");
				String field2 = rs.getString("expert_name");
				String field3 = rs.getString("expert_jury");
				String field4 = rs.getString("expert_group");
				String field5 = rs.getString("expert_post");
				String field6 = rs.getString("expert_serveyear");
				tempHistorytitle = new Historytitle(field1, field2, field3, field4, field5,
										field6);
				result.add(tempHistorytitle);
			}
			
			return result;
		} catch (Exception ex) {
			System.out.println("GetHistoryTitle.java-getHistoryTitlesByServeyearAndJuryNoInView(String,String):List<Historytitle> wrong!");
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
