package gpw.operateDatabase;

import gpw.connection.LinkDB;
import gpw.object.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Update {
	//设置USER的默认显示字段
	//tempList = {Expert_Field1,Expert_Field2}
	public Boolean setDefaultFieldUpdate (String userName, List<String> tempList){
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		List<String> tempColumnName = new ArrayList<String>();
		List<String> tempValue = new ArrayList<String>();
		
		tempColumnName.add("user_name"); //注意update的话需要用到column的名字
		tempValue.add(userName);
		for (int i=0; i<35; i++){
			tempValue.add("0"); //用于初始的全0数据
		}
		for (int i=0; i<tempList.size(); i++){
			tempList.set(i, tempList.get(i).substring(12));  //把tempList里的Expert_Field删除留下对应的序号
			tempValue.set(Integer.parseInt(tempList.get(i)) , "1");  //根据序号把值改成1
		}
		
//		System.out.println(tempList);
//		System.out.println(tempValue);
		
		for (int i=0; i<35; i++){
			tempColumnName.add("Expert_Field"+(i+1));  //添加列名
		}
//		System.out.println(tempColumnName);
		
		String sqlValue = "update user_field set ";
		for (int i=0; i<34; i++){
			sqlValue += tempColumnName.get(i+1) + "=" + tempValue.get(i+1) + ","; //拼凑
		}
		sqlValue += tempColumnName.get(35) + "=" + tempValue.get(35) + " where " + tempColumnName.get(0) + "='" + tempValue.get(0)+"'";
		//因为第一个column和第一个value是对应的username，所以这里要用where来唯一区分
		
		System.out.println(sqlValue);
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sqlValue);
			return true;
		} catch (Exception ex) {
			System.out.println("Update.java-setDefaultFieldUpdate(String,List<String>):Boolean wrong!");
			ex.printStackTrace();
			return false;
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
	
	//main函数测试
//	public static void main(String args[]){
//		Update test = new Update();
//		List<String> testList = new ArrayList<String>();
//		testList.add("Expert_Field1");
//		testList.add("Expert_Field2");
//		System.out.println(testList);
//		test.setDefaultFieldUpdate("zjut",testList);
//	}
	
	public Boolean updateCode(CodeModel obj, String codeName){
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String tempColumn = "";
		
		switch(codeName){
		case "sex":
			tempColumn="sex";
			break;
		case "Counciltitle":
			tempColumn="counciltitle";
			break;
		case "degree":
			tempColumn="degree";
			break;
		case "education":
			tempColumn="education";
			break;
		case "engage":
			tempColumn="engage";
			break;
		case "grouptitle":
			tempColumn="grouptitle";
			break;
		case "series":
			tempColumn="series";
			break;
		case "special":
			tempColumn="special";
			break;
		case "title":
			tempColumn="title";
			break;
		case "titlegrade":
			tempColumn="titlegrade";
			break;
		default:
			System.out.println("Update.java-updateCode-switch wrong");
			break;
		}
		String sqlValue = "update code_"+codeName+" set "
				+ tempColumn+"='"+obj.getCodeName()
				+ "', comments='"+obj.getCodeComments()+"'"
				+ " where code='"+obj.getCodeNo()+"'";

		System.out.println(sqlValue);
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sqlValue);
			return true;
		} catch (Exception ex) {
			System.out.println("Update.java-updateCode(CodeModel,String):Boolean wrong!");
			ex.printStackTrace();
			return false;
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
	
	public static void main(String args[]){
		CodeModel test = new CodeModel();
		test.setCodeNo("01");
		test.setCodeName("研究生毕业");
		test.setCodeComments(null);
		Update temp = new Update();
		temp.updateCode(test, "education");
	}
	
	public Boolean updateExpertInfoByNo(Expert tempEx){
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;

		String sqlValue = "update expert_baseinfo set ";
		for(int i=0; i<35; i++){
			sqlValue += "Expert_Field"+(i+1)+"='"+tempEx.getExpert(i+1)+"',";
		}
		sqlValue=sqlValue.substring(0, sqlValue.length()-1);
		sqlValue+=" where Expert_Field1='"+tempEx.getExpert_Field1()+"'";
		System.out.println(sqlValue);
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sqlValue);
			return true;
		} catch (Exception ex) {
			System.out.println("Update.java-updateExpertInfoByNo(Expert):Boolean wrong!");
			ex.printStackTrace();
			return false;
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
	
//	public static void main(String args[]){
//		Update test = new Update();
//		Experts testE = new Experts("2","多","3","4","5","6","7","8","9","10",
//				"11","12","13","14","15","16","17","18","19","20",
//				"21","22","23","24","25","26","27","28","29","30",
//				"31","33","33","34","35");
//		test.updateExpertInfoByNo(testE);
//	}
	
	//只更改comm和date
	public Boolean updateGroup(Group tempGp){
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;

		String sqlValue = "update group_dept set Group_date='"+tempGp.getGroup_date()
					+"', Group_comm='"+tempGp.getGroup_comm()+"' where Group_no='"+tempGp.getGroup_no()+"'";
		System.out.println(sqlValue);
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sqlValue);
			return true;
		} catch (Exception ex) {
			System.out.println("Update.java-updateGroup(Group):Boolean wrong!");
			ex.printStackTrace();
			return false;
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
	
//	public static void main(String args[]){
//		Update test = new Update();
//		Group tempGp = new Group("08010","2","3","44","55");
//		test.updateGroupByNo(tempGp);
//	}
	
	public Boolean updateJury(Jury tempJy){
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;

		String sqlValue = "update jury_dept set Jury_name='"+tempJy.getJury_name()
					+"', Jury_type='"+tempJy.getJury_type()
					+"', Jury_power='"+tempJy.getJury_power()
					+"', Jury_qualiname='"+tempJy.getJury_qualiname()
					+"', Jury_dept='"+tempJy.getJury_dept()
					+"', Jury_comments='"+tempJy.getJury_comments()
					+"', Jury_date='"+tempJy.getJury_date()
					+"' where Jury_no='"+tempJy.getJury_no()+"'";
		System.out.println(sqlValue);
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sqlValue);
			return true;
		} catch (Exception ex) {
			System.out.println("Update.java-updateJury(Jury):Boolean wrong!");
			ex.printStackTrace();
			return false;
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
	
//	public static void main(String args[]){
//		Update test = new Update();
//		Jury temp = new Jury("1","11","6","7","14","15","16","2008-08-08 00:00:00");
//		test.updateJury(temp);
//	}
	
	public Boolean updateUserLoginByName(UserLogin ul){
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;

		String sqlValue = "update user_login set user_psd='"+ul.getUser_psd()
					+"', user_enable='"+ul.getUser_enable()
					+"', user_date='"+ul.getUser_date()
					+"', user_type='"+ul.getUser_type()
					+"', user_jury='"+ul.getUser_jury()
					+"', user_dept='"+ul.getUser_dept()
					+"', user_tel='"+ul.getUser_tel()
					+"' where user_name='"+ul.getUser_name()+"'";
		System.out.println(sqlValue);
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sqlValue);
			return true;
		} catch (Exception ex) {
			System.out.println("Update.java-updateUserLoginByName(UserLogin):Boolean wrong!");
			ex.printStackTrace();
			return false;
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
	
	public Boolean updateJuryIdcodeByNamePhone(String expert_name,String expert_phone){
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;

		String sqlValue = "update jury_idcode set code_insert_time=now()"
					+" where expert_name='"+expert_name+"' and expert_phone='"+expert_phone+"'";
		System.out.println(sqlValue);
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sqlValue);
			return true;
		} catch (Exception ex) {
			System.out.println("Update.java-updateJuryIdcodeByNamePhone(String,String):Boolean wrong!");
			ex.printStackTrace();
			return false;
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
	
	
	
//	public static void main(String args[]){
//		Update test = new Update();
//		UserLogin temp = new UserLogin("zjut","3","4","2008-08-08 00:00:00","6","7","8","9");
//		test.updateUserLoginByName(temp);
//	}
	
	public Boolean updatePsdByName(String name, String psd){
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;

		String sqlValue = "update user_login set user_psd='"+psd
					+"' where user_name='"+name+"'";
		System.out.println(sqlValue);
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sqlValue);
			return true;
		} catch (Exception ex) {
			System.out.println("Update.java-updatePsdByName(String,String):Boolean wrong!");
			ex.printStackTrace();
			return false;
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
	
	//以下三个是控制用户禁用状态的接口，由updateUnableByUserName根据传入值判断后调用对用的setEnable1和setEnable0两接口
	public Boolean updateEnableByUserName(List<String> name, List<String> enable){
		try{
			List<String> nameToSet1 = new ArrayList<String>();
			List<String> nameToSet0 = new ArrayList<String>();
			for(int i=0; i<name.size(); i++){
				if(enable.get(i).equals("0")){
					nameToSet0.add(name.get(i));
				}
				else if(enable.get(i).equals("1")){
					nameToSet1.add(name.get(i));	
				}
			}
			if(nameToSet0.size() != 0){
				this.setEnable0(nameToSet0);
			}
			if(nameToSet1.size() != 0){
				this.setEnable1(nameToSet1);
			}
			return true;
		}
		catch(Exception ex){
			System.out.println("Update.java-updateEnableByUserName(List<String>,List<String>):Boolean wrong!");
			ex.printStackTrace();
			return false;
		}
	}
	private Boolean setEnable1(List<String> nameToSet){
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "update user_login set user_enable='1' where user_name in(";
		for(int i=0;i<nameToSet.size();i++){
			sqlValue += "'"+nameToSet.get(i)+"',";
		}
		sqlValue = sqlValue.substring(0, sqlValue.length()-1);
		sqlValue += ")";
		System.out.println(sqlValue);
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sqlValue);
			return true;
		} catch (Exception ex) {
			System.out.println("Update.java-setEnable1(List<String>):Boolean wrong!");
			ex.printStackTrace();
			return false;
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
	private Boolean setEnable0(List<String> nameToSet){
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "update user_login set user_enable='0' where user_name in(";
		for(int i=0;i<nameToSet.size();i++){
			sqlValue += "'"+nameToSet.get(i)+"',";
		}
		sqlValue = sqlValue.substring(0, sqlValue.length()-1);
		sqlValue += ")";
		System.out.println(sqlValue);
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sqlValue);
			return true;
		} catch (Exception ex) {
			System.out.println("Update.java-setEnable0(List<String>):Boolean wrong!");
			ex.printStackTrace();
			return false;
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
	
//	public static void main(String args[]){
//		Update test = new Update();
//		List<String> temp1 = new ArrayList<String>();
//		temp1.add("1");
//		temp1.add("0");
//		temp1.add("1");
//		List<String> temp2 = new ArrayList<String>();
//		temp2.add("zz1");
//		temp2.add("zz2");
//		temp2.add("zz3");
//		test.updateEnableByUserName(temp2, temp1);
//	}
}
