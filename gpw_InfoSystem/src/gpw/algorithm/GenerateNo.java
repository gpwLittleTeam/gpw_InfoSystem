package gpw.algorithm;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import gpw.connection.LinkDB;

public class GenerateNo {
	//
	public String generateGroupNo(String juryNo){
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String result = juryNo;
		String tempResult = null;
		String sqlValue = "select max(Group_no) as temp from group_dept where Group_no like '"+juryNo+"%'";
//		System.out.println(sqlValue);
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			rs.next();
			if(rs.getString("temp")!=null){			//表中对应的该评委组中存在专家，所以可以直接搜索其中编号最大的人
				//System.out.println("有数据");
				//System.out.println(Integer.parseInt(rs.getString("temp"))+1);
				tempResult = (Integer.parseInt(rs.getString("temp").substring(4))+1)+"";		//首先拿出来的是例如01020002这样的数字后裁剪后四位0002转为int->2后再加1
				//System.out.println(tempResult);
				char[] ary1 = tempResult.toCharArray();			//创建两个char来完成左边自动补上数字
				char[] ary2 = {'0','0','0','0','0','0'};
				System.arraycopy(ary1, 0, ary2, ary2.length-ary1.length, ary1.length);
				tempResult = new String(ary2);
				result += tempResult; 
				//System.out.println(result);
			}
			else{		//表中对应的该评委组暂时还没有专家，所以不能搜索其中编号最大的人，应重新新建一个
				//System.out.println("没有数据");			
				result += "000001";
			}
			return result;
		} catch (Exception ex) {
			System.out.println("get gpw default field wrong!");
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
	//测试函数
/*	public static void main(String args[]){
		GenerateNo obj = new GenerateNo();
		System.out.println(obj.generateGroupNo("0130"));
	}*/
	
	public String generateExpertNo(String juryNo){
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String result = juryNo;
		String tempResult = null;
		String sqlValue = "select max(Expert_Field1) as temp from expert_baseinfo where Expert_Field1 like '"+juryNo+"%'";
//		System.out.println(sqlValue);
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			rs.next();
			if(rs.getString("temp")!=null){			//表中对应的该评委组中存在专家，所以可以直接搜索其中编号最大的人
				//System.out.println("有数据");
				//System.out.println(Integer.parseInt(rs.getString("temp"))+1);
				tempResult = (Integer.parseInt(rs.getString("temp").replace(result, ""))+1)+"";		//首先拿出来的是例如01020002这样的数字后裁剪后四位0002转为int->2后再加1
				//System.out.println(tempResult);
				char[] ary1 = tempResult.toCharArray();			//创建两个char来完成左边自动补上数字
				char[] ary2 = {'0','0','0','0'};
				System.arraycopy(ary1, 0, ary2, ary2.length-ary1.length, ary1.length);
				tempResult = new String(ary2);
				result += tempResult; 
				//System.out.println(result);
			}
			else{		//表中对应的该评委组暂时还没有专家，所以不能搜索其中编号最大的人，应重新新建一个
				//System.out.println("没有数据");			
				result += "0001";
			}
			return result;
		} catch (Exception ex) {
			System.out.println("get gpw default field wrong!");
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
	 * 自动生成rule_management中的rule_no
	 * 只支持int型
	 */
	public String generateRuleNo(){
		String ruleNo = "";
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String tempResult = null;
		String sqlValue = "select max(rule_no) as temp from rule_management";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			rs.next();
			if(rs.getString("temp")!=null){		
				tempResult = (Integer.parseInt(rs.getString("temp"))+1)+"";		//
				//System.out.println(tempResult);
				char[] ary1 = tempResult.toCharArray();			//创建两个char来完成左边自动补上数字
				char[] ary2 = {'0','0','0','0'};
				System.arraycopy(ary1, 0, ary2, ary2.length-ary1.length, ary1.length);
				tempResult = new String(ary2);
				ruleNo += tempResult; 
			}
			else{		//表中对应的该评委组暂时还没有专家，所以不能搜索其中编号最大的人，应重新新建一个
				ruleNo += "0001";
			}
			return ruleNo;
		} catch (Exception ex) {
			System.out.println("get gpw default field wrong!");
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
				//ex.printStackTrace();
			}
		}
	}
}
