package gpw.getInfo;

import gpw.connection.LinkDB;
import gpw.object.JuryIdcode;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetJuryIdcode {
	public List<JuryIdcode> getJuryIdcodes(String juryNo){
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		List<JuryIdcode> result = new ArrayList<JuryIdcode>();
		String sqlValue = "select expert_name,expert_phone,id_code,code_insert_time from jury_idcode where jury_no='"+juryNo+"'";
		//System.out.println("getJuryNo: "+sqlValue);
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while(rs.next()){
				JuryIdcode temp = new JuryIdcode(rs.getString("expert_name"), rs.getString("expert_phone"), 
						rs.getString("id_code"), rs.getString("code_insert_time"));
				result.add(temp);
			}
			
			return result;
		} catch (Exception ex) {
			System.out.println("GetJuryIdcode.java-getJuryIdcodes(String):List<JuryIdcode> wrong!");
			//ex.printStackTrace();
			return result;
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
	public String getJuryNo(String idCode, String expertName, String expertPhone){
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String result = "";
		String sqlValue = "select jury_no from jury_idcode where expert_name='"+expertName+"' and expert_phone='"+expertPhone+"' and id_code='"+idCode+"'";
//		System.out.println("getJuryNo: "+sqlValue);
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while(rs.next()){
				result = rs.getString("jury_no");
			}
			
			return result;
		} catch (Exception ex) {
			System.out.println("GetJuryIdcode.java-getJuryNo(String,String,String):String wrong!");
			//ex.printStackTrace();
			return result;
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
	public List<String> getJuryIdcodeByNamePhone(String expertName, String expertPhone){
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		List<String> result = new ArrayList<String>();
		String sqlValue = "select id_code,code_insert_time from jury_idcode where expert_name='"+expertName+"' and expert_phone='"+expertPhone+"'";
//		System.out.println("getJuryIdcodeByNamePhone: "+sqlValue);
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while(rs.next()){
				result.add(rs.getString("id_code"));
				result.add(rs.getString("code_insert_time"));
			}
			
			return result;
		} catch (Exception ex) {
			System.out.println("GetJuryIdcode.java-getJuryIdcodeByNamePhone(String,String):List<String> wrong!");
			//ex.printStackTrace();
			return result;
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
	public String generateJuryIdcode(String juryNo, String expertName, String expertPhone){
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String result = "";
		String sqlValue = "select insertRandomIdcode('"+juryNo+"','"+expertName+"','"+expertPhone+"') as random, now() as time";
		//System.out.println(sqlValue);
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while(rs.next()){
				result += "{\"random\":\"" + rs.getString("random") + "\",";
				result += "\"time\":\"" + rs.getString("time") + "\"}";
			}
			//System.out.println(result);
			return result;
		} catch (Exception ex) {
			System.out.println("GetJuryIdcode.java-generateJuryIdcode(String,String,String):String wrong!");
			//ex.printStackTrace();
			return result;
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
		
//		Date d = new Date();
//		System.out.println(d);
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String dateNowStr = sdf.format(d);
//		String dateOneDayLateStr = sdf.format(new Date(d.getTime() + 1*24*60*60*1000));
//		System.out.println(dateNowStr);
//		System.out.println(dateOneDayLateStr);
//		System.out.println(dateNowStr.compareTo("2017-07-16 17:45:00"));
//		
//		Date date = sdf.parse("2017-07-15 21:00:00");
//		System.out.println(date);
//		long intervalMilli = d.getTime() - date.getTime();
//		System.out.println(intervalMilli/(60*60*1000));
		
		GetJuryIdcode test = new GetJuryIdcode();
		System.out.println(test.generateJuryIdcode("0102", "李华", "13857898888"));
	}
}
