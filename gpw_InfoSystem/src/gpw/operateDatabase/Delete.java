package gpw.operateDatabase;

import gpw.connection.LinkDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Delete {
	//根据专家编号删除
		public Boolean deleteExpertByNumber(List<String> numberList){
			//建立连接
			LinkDB link =  new LinkDB();
			Connection conn = link.getConn();
			Statement stmt = null;
			String sqlValue = "delete from expert_baseinfo where ";
			for(int i=0;i<numberList.size();i++){
				sqlValue += "Expert_Field1='" + numberList.get(i)+"' or ";
			}
			sqlValue = sqlValue.substring(0,sqlValue.length()-4);
			//String sqlValue = "delete from expert_baseinfo where Expert_Field1='" + number +"'";
			System.out.println(sqlValue);
			try {
				stmt = conn.createStatement();
				stmt.executeUpdate(sqlValue);
				return true;
			} catch (Exception ex) {
				System.out.println("Delete.java-deleteExpertByNumber(List<String>):Boolean wrong!");
				ex.printStackTrace();
				return false;
			} finally {
				try {
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
//		public static void main(String args[]){
//			Delete test = new Delete();
//			List<String> temp = new ArrayList<String>();
//			temp.add("1234");
//			temp.add("1");
//			test.deleteExpertByNumber(temp);
//		}
		
		
		public Boolean deleteGroupByNo(List<String> numberList){
			//建立连接
			LinkDB link =  new LinkDB();
			Connection conn = link.getConn();
			Statement stmt = null;
			String sqlValue = "delete from group_dept where ";
			for(int i=0;i<numberList.size();i++){
				sqlValue += "Group_no='" + numberList.get(i)+"' or ";
			}
			sqlValue = sqlValue.substring(0,sqlValue.length()-4);
			//String sqlValue = "delete from group_dept where Group_no='" +no+"'" ;
			System.out.println(sqlValue);
			try {
				stmt = conn.createStatement();
				stmt.executeUpdate(sqlValue);
				return true;
			} catch (Exception ex) {
				System.out.println("Delete.java-deleteGroupByNo(List<String>):Boolean wrong!");
				ex.printStackTrace();
				return false;
			} finally {
				try {
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
		//测试函数
//		public static void main(String args[]){
//			Delete test = new Delete();
//			List<String> temp = new ArrayList<String>();
//			temp.add("08222");
//			temp.add("022222");
//			test.deleteJuryByNo(temp);
//		}
		
		public Boolean deleteJuryByNo(List<String> numberList){
			//建立连接
			LinkDB link =  new LinkDB();
			Connection conn = link.getConn();
			Statement stmt = null;
			String sqlValue = "delete from jury_dept where ";
			for(int i=0;i<numberList.size();i++){
				sqlValue += "Jury_no='" + numberList.get(i)+"' or ";
			}
			sqlValue = sqlValue.substring(0,sqlValue.length()-4);
			//String sqlValue = "delete from group_dept where Group_no='" +no+"'" ;
			System.out.println(sqlValue);
			try {
				stmt = conn.createStatement();
				stmt.executeUpdate(sqlValue);
				return true;
			} catch (Exception ex) {
				System.out.println("Delete.java-deleteJuryByNo(List<String>):Boolean wrong!");
				ex.printStackTrace();
				return false;
			} finally {
				try {
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
		
		public Boolean deleteHistoryTitleByNoAndYear(List<String> numberList,List<String> serveyear){
			//建立连接
			LinkDB link =  new LinkDB();
			Connection conn = link.getConn();
			Statement stmt = null;
			String sqlValue = "delete from history_title where ";
			for(int i=0;i<numberList.size();i++){
				sqlValue += "(expert_no='" + numberList.get(i)+"' and expert_serveyear='"+serveyear.get(i)+"') or ";
			}
			sqlValue = sqlValue.substring(0,sqlValue.length()-4);
			//String sqlValue = "delete from group_dept where Group_no='" +no+"'" ;
			System.out.println(sqlValue);
			try {
				stmt = conn.createStatement();
				stmt.executeUpdate(sqlValue);
				return true;
			} catch (Exception ex) {
				System.out.println("Delete.java-deleteHistoryTitleByNo(List<String>):Boolean wrong!");
				ex.printStackTrace();
				return false;
			} finally {
				try {
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

		//删除用户的同时会根据当前正删除的名字调用deleteUserFieldByName(String):Boolean来配合删除对应的user_field里的数据
		public Boolean deleteUserLoginByName(List<String> nameList){
			//建立连接
			LinkDB link =  new LinkDB();
			Connection conn = link.getConn();
			Statement stmt = null;
			String sqlValue = "delete from user_login where ";
			for(int i=0;i<nameList.size();i++){
				sqlValue += "user_name='" + nameList.get(i)+"' or ";
				this.deleteUserFieldByName(nameList.get(i));
			}
			sqlValue = sqlValue.substring(0,sqlValue.length()-4);
			//String sqlValue = "delete from group_dept where Group_no='" +no+"'" ;
			System.out.println(sqlValue);
			try {
				stmt = conn.createStatement();
				stmt.executeUpdate(sqlValue);
				return true;
			} catch (Exception ex) {
				System.out.println("Delete.java-deleteUserLoginByName(List<String>):Boolean wrong!");
				ex.printStackTrace();
				return false;
			} finally {
				try {
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
		
		public Boolean deleteUserFieldByName(String name){
			
			//建立连接
			LinkDB link =  new LinkDB();
			Connection conn = link.getConn();
			Statement stmt = null;
			String sqlValue = "delete from user_field where user_name = '" +name+"'";
			System.out.println(sqlValue);
			try {
				stmt = conn.createStatement();
				stmt.executeUpdate(sqlValue);
				return true;
			} catch (Exception ex) {
				System.out.println("Delete.java-deleteUserFieldByName(String):Boolean wrong!");
				ex.printStackTrace();
				return false;
			} finally {
				try {
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
		
		public Boolean deleteJuryIdcodeByNamePhone(String expert_name, String expert_phone){
			//建立连接
			LinkDB link =  new LinkDB();
			Connection conn = link.getConn();
			Statement stmt = null;
			String sqlValue = "delete from jury_idcode where expert_name = '" +expert_name+"' and expert_phone='"+expert_phone+"'";
			//System.out.println(sqlValue);
			try {
				stmt = conn.createStatement();
				stmt.executeUpdate(sqlValue);
				return true;
			} catch (Exception ex) {
				System.out.println("Delete.java-deleteJuryIdcodeByNamePhone(String,String):Boolean wrong!");
				ex.printStackTrace();
				return false;
			} finally {
				try {
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
		
		public Boolean deleteRuleByNo(String ruleNo) {
			LinkDB link =  new LinkDB();
			Connection conn = link.getConn();
			Statement stmt = null;
			String sqlValue = "delete from rule_management where rule_no = '" + ruleNo + "'";
			System.out.println(sqlValue);
			try {
				stmt = conn.createStatement();
				stmt.executeUpdate(sqlValue);
				return true;
			} catch (Exception ex) {
				System.out.println("Delete.java-deleteRuleByNo(String):Boolean wrong!");
				ex.printStackTrace();
				return false;
			} finally {
				try {
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
		
//		public static void main(String args[]){
//			Delete test = new Delete();
//			test.deleteUserFieldByName("aa");
//		}
//		public static void main(String args[]){
//			Delete test = new Delete();
//			List<String> temp = new ArrayList<String>();
//			temp.add("test1");
//			temp.add("test2");
//			test.deleteUserLoginByName(temp);
//		}
//		
		//测试函数
//		public static void main(String args[]){
//			Delete test = new Delete();
//			List<String> temp = new ArrayList<String>();
//			temp.add("01010001");
//			test.deleteHistoryTitleByNoAndYear(temp,"2002");
//		}
		
		public Boolean deleteCounciltitle(List<String> codeList){
			//建立连接
			LinkDB link =  new LinkDB();
			Connection conn = link.getConn();
			Statement stmt = null;
			String sqlValue = "delete from code_counciltitle where ";
			for(int i=0;i<codeList.size();i++){
				sqlValue += "code='"+codeList.get(i)+"' or ";
			}
			sqlValue = sqlValue.substring(0, sqlValue.length()-3);
//			System.out.println(sqlValue);
			try {
				stmt = conn.createStatement();
				stmt.executeUpdate(sqlValue);
				return true;
			} catch (Exception ex) {
				System.out.println("Delete.java-deleteCounciltitle(List<String>):Boolean wrong!");
				ex.printStackTrace();
				return false;
			} finally {
				try {
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
		
//		public static void main(String args[]){
//			Delete test = new Delete();
//			List<String> temp = new ArrayList<String>();
//			temp.add("66");
//			temp.add("77");
//			test.deleteDegree(temp);
//		}
		
		public Boolean deleteDegree(List<String> codeList){
			//建立连接
			LinkDB link =  new LinkDB();
			Connection conn = link.getConn();
			Statement stmt = null;
			String sqlValue = "delete from code_degree where ";
			for(int i=0;i<codeList.size();i++){
				sqlValue += "code='"+codeList.get(i)+"' or ";
			}
			sqlValue = sqlValue.substring(0, sqlValue.length()-3);
//			System.out.println(sqlValue);
			try {
				stmt = conn.createStatement();
				stmt.executeUpdate(sqlValue);
				return true;
			} catch (Exception ex) {
				System.out.println("Delete.java-deleteDegree(List<String>):Boolean wrong!");
				ex.printStackTrace();
				return false;
			} finally {
				try {
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

		public Boolean deleteEducation(List<String> codeList){
			//建立连接
			LinkDB link =  new LinkDB();
			Connection conn = link.getConn();
			Statement stmt = null;
			String sqlValue = "delete from code_education where ";
			for(int i=0;i<codeList.size();i++){
				sqlValue += "code='"+codeList.get(i)+"' or ";
			}
			sqlValue = sqlValue.substring(0, sqlValue.length()-3);
//			System.out.println(sqlValue);
			try {
				stmt = conn.createStatement();
				stmt.executeUpdate(sqlValue);
				return true;
			} catch (Exception ex) {
				System.out.println("Delete.java-deleteEducation(List<String>):Boolean wrong!");
				ex.printStackTrace();
				return false;
			} finally {
				try {
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
		
		public Boolean deleteEngage(List<String> codeList){
			//建立连接
			LinkDB link =  new LinkDB();
			Connection conn = link.getConn();
			Statement stmt = null;
			String sqlValue = "delete from code_engage where ";
			for(int i=0;i<codeList.size();i++){
				sqlValue += "code='"+codeList.get(i)+"' or ";
			}
			sqlValue = sqlValue.substring(0, sqlValue.length()-3);
//			System.out.println(sqlValue);
			try {
				stmt = conn.createStatement();
				stmt.executeUpdate(sqlValue);
				return true;
			} catch (Exception ex) {
				System.out.println("Delete.java-deleteEngage(List<String>):Boolean wrong!");
				ex.printStackTrace();
				return false;
			} finally {
				try {
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

		public Boolean deleteGrouptitle(List<String> codeList){
			//建立连接
			LinkDB link =  new LinkDB();
			Connection conn = link.getConn();
			Statement stmt = null;
			String sqlValue = "delete from code_grouptitle where ";
			for(int i=0;i<codeList.size();i++){
				sqlValue += "code='"+codeList.get(i)+"' or ";
			}
			sqlValue = sqlValue.substring(0, sqlValue.length()-3);
//			System.out.println(sqlValue);
			try {
				stmt = conn.createStatement();
				stmt.executeUpdate(sqlValue);
				return true;
			} catch (Exception ex) {
				System.out.println("Delete.java-deleteGrouptitle(List<String>):Boolean wrong!");
				ex.printStackTrace();
				return false;
			} finally {
				try {
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

		public Boolean deleteSeries(List<String> codeList){
			//建立连接
			LinkDB link =  new LinkDB();
			Connection conn = link.getConn();
			Statement stmt = null;
			String sqlValue = "delete from code_series where ";
			for(int i=0;i<codeList.size();i++){
				sqlValue += "code='"+codeList.get(i)+"' or ";
			}
			sqlValue = sqlValue.substring(0, sqlValue.length()-3);
//			System.out.println(sqlValue);
			try {
				stmt = conn.createStatement();
				stmt.executeUpdate(sqlValue);
				return true;
			} catch (Exception ex) {
				System.out.println("Delete.java-deleteSeries(List<String>):Boolean wrong!");
				ex.printStackTrace();
				return false;
			} finally {
				try {
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

		public Boolean deleteSex(List<String> codeList){
			//建立连接
			LinkDB link =  new LinkDB();
			Connection conn = link.getConn();
			Statement stmt = null;
			String sqlValue = "delete from code_sex where ";
			for(int i=0;i<codeList.size();i++){
				sqlValue += "code='"+codeList.get(i)+"' or ";
			}
			sqlValue = sqlValue.substring(0, sqlValue.length()-3);
//			System.out.println(sqlValue);
			try {
				stmt = conn.createStatement();
				stmt.executeUpdate(sqlValue);
				return true;
			} catch (Exception ex) {
				System.out.println("Delete.java-deleteSex(List<String>):Boolean wrong!");
				ex.printStackTrace();
				return false;
			} finally {
				try {
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

		public Boolean deleteSpecial(List<String> codeList){
			//建立连接
			LinkDB link =  new LinkDB();
			Connection conn = link.getConn();
			Statement stmt = null;
			String sqlValue = "delete from code_special where ";
			for(int i=0;i<codeList.size();i++){
				sqlValue += "code='"+codeList.get(i)+"' or ";
			}
			sqlValue = sqlValue.substring(0, sqlValue.length()-3);
//			System.out.println(sqlValue);
			try {
				stmt = conn.createStatement();
				stmt.executeUpdate(sqlValue);
				return true;
			} catch (Exception ex) {
				System.out.println("Delete.java-deleteSpecial(List<String>):Boolean wrong!");
				ex.printStackTrace();
				return false;
			} finally {
				try {
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

		public Boolean deleteTitle(List<String> codeList){
			//建立连接
			LinkDB link =  new LinkDB();
			Connection conn = link.getConn();
			Statement stmt = null;
			String sqlValue = "delete from code_title where ";
			for(int i=0;i<codeList.size();i++){
				sqlValue += "code='"+codeList.get(i)+"' or ";
			}
			sqlValue = sqlValue.substring(0, sqlValue.length()-3);
//			System.out.println(sqlValue);
			try {
				stmt = conn.createStatement();
				stmt.executeUpdate(sqlValue);
				return true;
			} catch (Exception ex) {
				System.out.println("Delete.java-deleteTitle(List<String>):Boolean wrong!");
				ex.printStackTrace();
				return false;
			} finally {
				try {
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

		public Boolean deleteTitlegrade(List<String> codeList){
			//建立连接
			LinkDB link =  new LinkDB();
			Connection conn = link.getConn();
			Statement stmt = null;
			String sqlValue = "delete from code_titlegrade where ";
			for(int i=0;i<codeList.size();i++){
				sqlValue += "code='"+codeList.get(i)+"' or ";
			}
			sqlValue = sqlValue.substring(0, sqlValue.length()-3);
//			System.out.println(sqlValue);
			try {
				stmt = conn.createStatement();
				stmt.executeUpdate(sqlValue);
				return true;
			} catch (Exception ex) {
				System.out.println("Delete.java-deleteTitlegrade(List<String>):Boolean wrong!");
				ex.printStackTrace();
				return false;
			} finally {
				try {
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
