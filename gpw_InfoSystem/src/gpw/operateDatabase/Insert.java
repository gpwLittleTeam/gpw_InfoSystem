package gpw.operateDatabase;

import gpw.connection.LinkDB;
import gpw.object.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;

public class Insert {
	//信息录入的添加到数据库接口
		public Boolean insertNewExpert (Expert ext){
			//建立连接
			LinkDB link =  new LinkDB();
			Connection conn = link.getConn();
			Statement stmt = null;
			
			//注意没有expert_id
			String sqlValue = "insert into expert_baseinfo"
					+ "(Expert_Field1,Expert_Field2,Expert_Field3,Expert_Field4,Expert_Field5,"
					+ "Expert_Field6,Expert_Field7,Expert_Field8,Expert_Field9,Expert_Field10,"
					+ "Expert_Field11,Expert_Field12,Expert_Field13,Expert_Field14,Expert_Field15,"
					+ "Expert_Field16,Expert_Field17,Expert_Field18,Expert_Field19,Expert_Field20,"
					+ "Expert_Field21,Expert_Field22,Expert_Field23,Expert_Field24,Expert_Field25,"
					+ "Expert_Field26,Expert_Field27,Expert_Field28,Expert_Field29,Expert_Field30,"
					+ "Expert_Field31,Expert_Field32,Expert_Field33,Expert_Field34,Expert_Field35)"
					+ " values('" 
							+ ext.getExpert_Field1() + "','"
							+ ext.getExpert_Field2() + "','"
							+ ext.getExpert_Field3() + "','"
							+ ext.getExpert_Field4() + "','"
							+ ext.getExpert_Field5() + "','"
							+ ext.getExpert_Field6() + "','"
							+ ext.getExpert_Field7() + "','"
							+ ext.getExpert_Field8() + "','"
							+ ext.getExpert_Field9() + "','"
							+ ext.getExpert_Field10() + "','"
							+ ext.getExpert_Field11() + "','"
							+ ext.getExpert_Field12() + "','"
							+ ext.getExpert_Field13() + "','"
							+ ext.getExpert_Field14() + "','"
							+ ext.getExpert_Field15() + "','"
							+ ext.getExpert_Field16() + "','"
							+ ext.getExpert_Field17() + "','"
							+ ext.getExpert_Field18() + "','"
							+ ext.getExpert_Field19() + "','"
							+ ext.getExpert_Field20() + "','"
							+ ext.getExpert_Field21() + "','"
							+ ext.getExpert_Field22() + "','"
							+ ext.getExpert_Field23() + "','"
							+ ext.getExpert_Field24() + "','"
							+ ext.getExpert_Field25() + "','"
							+ ext.getExpert_Field26() + "','"
							+ ext.getExpert_Field27() + "','"
							+ ext.getExpert_Field28() + "','"
							+ ext.getExpert_Field29() + "','"
							+ ext.getExpert_Field30() + "','"
							+ ext.getExpert_Field31() + "','"
							+ ext.getExpert_Field32() + "','"
							+ ext.getExpert_Field33() + "','"
							+ ext.getExpert_Field34() + "','"
							+ ext.getExpert_Field35() + "')";
			try {
				System.out.println(sqlValue);
				stmt = conn.createStatement();
				stmt.executeUpdate(sqlValue);
				return true;
			} catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e){
				HttpServletRequest request = (HttpServletRequest)
						ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
				request.setAttribute("Error", "repeat");
				System.out.println("Insert.java-InsertNewExpert(Expert):Boolean repeat!");
				return false;
			} catch (com.mysql.jdbc.MysqlDataTruncation e){
				HttpServletRequest request = (HttpServletRequest)
						ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
				System.out.println("Insert.java-InsertNewExpert(Expert):Boolean dataTooLong!");
				request.setAttribute("Error", "dataTooLong");
				return false;
			} catch (Exception ex) {
				System.out.println("Insert.java-InsertNewExpert(Expert):Boolean wrong!");
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
		
//		//main函数测试
//		public static void main(String args[]){
//			Expert testE = new Expert("2","多的","3","330227199508115374","5","6","7","8","9","10",
//										"11","12","13","14","15","16","17","18","19","20",
//										"21","22","23","24","25","26","27","28","29","30",
//										"31","33","33","34","35");
//			Insert test = new Insert();
//			test.insertNewExpert(testE);
//		}
		//com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException
		
		//设置用户的默认字段
		public Boolean setDefaultFieldInsert (String username, List<String> tempList){
			LinkDB link =  new LinkDB();
			Connection conn = link.getConn();
			Statement stmt = null;
			ResultSet rs = null;
			List<String> tempValue = new ArrayList<String>();
			String value = "";
			tempValue.add(username);
			for (int i=0; i<35; i++){
				tempValue.add("0"); //用于初始的全0数据
			}
			for (int i=0; i<tempList.size(); i++){
				tempList.set(i, tempList.get(i).substring(12));  //把tempList里的Expert_Field删除留下对应的序号
				tempValue.set(Integer.parseInt(tempList.get(i)) , "1");  //根据序号把值改成1
			}
			for (int i=0; i<tempValue.size()-1; i++){
				value += "'"+tempValue.get(i)+"',";  //拼凑最后的value
			}
			value += tempValue.get(tempValue.size()-1);
//			System.out.println(tempList);
//			System.out.println(tempValue);
			String sqlValue = "insert into user_field values ("+value+")";
//			System.out.println(sqlValue);
			try {
				stmt = conn.createStatement();
				stmt.executeUpdate(sqlValue);
				return true;
			} catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e){
				HttpServletRequest request = (HttpServletRequest)
						ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
				request.setAttribute("Error", "repeat");
				return false;
			} catch (com.mysql.jdbc.MysqlDataTruncation e){
				HttpServletRequest request = (HttpServletRequest)
						ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
				request.setAttribute("Error", "dataTooLong");
				return false;
			} catch (Exception ex) {
				System.out.println("Insert.java-setDefaultFieldInsert(String,List<String>):Boolean wrong!");
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
//		public static void main(String args[]){
//			Insert test = new Insert();
//			List<String> testList = new ArrayList<String>();
//			testList.add("Expert_Field1");
//			testList.add("Expert_Field2");
//			testList.add("Expert_Field4");
//			testList.add("Expert_Field35");
//			System.out.println(testList);
//			test.setDefaultFieldInsert("zju",testList);
//		}
		
//		//main函数测试
//		public static void main(String args[]){
//			SetDefaultField test = new SetDefaultField();
//			List<String> testList = new ArrayList<String>();
//			testList.add("Expert_Field1");
//			testList.add("Expert_Field2");
//			System.out.println(testList);
//			test.setDefaultField("2",testList);
//		}
		
		
		//新建专业组
		public Boolean insertNewGroup(Group gp){
			//建立连接
			LinkDB link =  new LinkDB();
			Connection conn = link.getConn();
			Statement stmt = null;
			
			//注意没有expert_id
			String sqlValue = "insert into group_dept(Group_no, Group_name, Group_jury,"
					+ "Group_date,Group_comm) values('" 
							+ gp.getGroup_no() + "','"
							+ gp.getGroup_name() + "','"
							+ gp.getGroup_jury() + "','"
							+ gp.getGroup_date() + "','"
							+ gp.getGroup_comm() + "')";
			try {
				stmt = conn.createStatement();
				stmt.executeUpdate(sqlValue);
				return true;
			} catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e){
				HttpServletRequest request = (HttpServletRequest)
						ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
				request.setAttribute("Error", "repeat");
				return false;
			} catch (com.mysql.jdbc.MysqlDataTruncation e){
				HttpServletRequest request = (HttpServletRequest)
						ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
				request.setAttribute("Error", "dataTooLong");
				return false;
			} catch (Exception ex) {
				System.out.println("Insert.java-insertNewGroup(Group):Boolean wrong!");
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
//			Group test = new Group("08009","化学组","0102","2008-08-08 00:00:00","sdfsdfe");
//			Insert temp = new Insert();
//			temp.insertNewGroup(test);
//		}

		public Boolean insertNewJury(Jury jy){
			//建立连接
			LinkDB link =  new LinkDB();
			Connection conn = link.getConn();
			Statement stmt = null;
			
			//注意没有expert_id
			String sqlValue = "insert into jury_dept(Jury_no,Jury_name,Jury_type,Jury_power,"
					+ "Jury_qualiname,jury_dept,jury_comments,jury_date) values('" 
							+ jy.getJury_no() + "','"
							+ jy.getJury_name() + "','"
							+ jy.getJury_type() + "','"
							+ jy.getJury_power() + "','"
							+ jy.getJury_qualiname() + "','"
							+ jy.getJury_dept() + "','"
							+ jy.getJury_comments() + "','"
							+ jy.getJury_date() + "')";
			try {
				stmt = conn.createStatement();
				stmt.executeUpdate(sqlValue);
				return true;
			} catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e){
				HttpServletRequest request = (HttpServletRequest)
						ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
				request.setAttribute("Error", "repeat");
				return false;
			} catch (com.mysql.jdbc.MysqlDataTruncation e){
				HttpServletRequest request = (HttpServletRequest)
						ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
				request.setAttribute("Error", "dataTooLong");
				return false;
			} catch (Exception ex) {
				System.out.println("Insert.java-insertNewJury(Jury):Boolean wrong!");
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

		//新建用户时会根据用户名在user_field中新建一个默认全是0的数据
		public Boolean insertNewUserLogin(UserLogin ul){
			//建立连接
			LinkDB link =  new LinkDB();
			Connection conn = link.getConn();
			Statement stmt = null;
			
			//注意没有user_id
			String sqlValue = "insert into user_login(user_name,user_psd,user_enable,user_date,"
					+ "user_type,user_jury,user_dept,user_tel) values('" 
							+ ul.getUser_name() + "','"
							+ ul.getUser_psd() + "','"
							+ ul.getUser_enable() + "','"
							+ ul.getUser_date() + "','"
							+ ul.getUser_type() + "','"
							+ ul.getUser_jury() + "','"
							+ ul.getUser_dept() + "','"
							+ ul.getUser_tel() + "')";
			try {
				stmt = conn.createStatement();
				stmt.executeUpdate(sqlValue);
				this.insertNewUserField(ul.getUser_name());
				return true;
			} catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e){
				HttpServletRequest request = (HttpServletRequest)
						ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
				request.setAttribute("Error", "repeat");
				return false;
			} catch (com.mysql.jdbc.MysqlDataTruncation e){
				HttpServletRequest request = (HttpServletRequest)
						ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
				request.setAttribute("Error", "dataTooLong");
				return false;
			} catch (Exception ex) {
				System.out.println("Insert.java-insertNewUserLogin(UserLogin):Boolean wrong!");
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
		
		public Boolean insertNewUserField(String name){
			//建立连接
			LinkDB link =  new LinkDB();
			Connection conn = link.getConn();
			Statement stmt = null;
			
			//注意没有user_id
			String sqlValue = "insert into user_field values('"+name+"','1','1',";
			for(int i=0;i<33;i++){
				sqlValue+="'0',";
			}
			sqlValue=sqlValue.substring(0, sqlValue.length()-1);
			sqlValue+=")";
			System.out.println(sqlValue);
							
			try {
				stmt = conn.createStatement();
				stmt.executeUpdate(sqlValue);
				return true;
			} catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e){
				HttpServletRequest request = (HttpServletRequest)
						ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
				request.setAttribute("Error", "repeat");
				return false;
			} catch (com.mysql.jdbc.MysqlDataTruncation e){
				HttpServletRequest request = (HttpServletRequest)
						ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
				request.setAttribute("Error", "dataTooLong");
				return false;
			} catch (Exception ex) {
				System.out.println("Insert.java-insertNewUserField(String):Boolean wrong!");
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
//			Insert temp = new Insert();
//			temp.insertNewUserField("a");
//		}
		
//		public static void main(String args[]){
//			try{
//				throw new MySQLIntegrityConstraintViolationException(null);
//			} catch (MySQLIntegrityConstraintViolationException e){
//				System.out.println(e instanceof MySQLIntegrityConstraintViolationException);
//				System.out.println(111);
//			} catch (Exception e){
//				System.out.println(222);
//			}
//		}
		
//		public static void main(String args[]){
//			UserLogin test = new UserLogin("1","2","3","2002-02-02 00:00:00","5","6","7","8");
//			Insert temp = new Insert();
//			temp.insertNewUserLogin(test);
//		}
		
		public Boolean insertCounciltitle(CodeModel ct){
			//建立连接
			LinkDB link =  new LinkDB();
			Connection conn = link.getConn();
			Statement stmt = null;
			
			String sqlValue = "insert into code_counciltitle values('" 
							+ ct.getCodeNo()+ "','"
							+ ct.getCodeName() + "','"
							+ ct.getCodeComments() + "')";
			try {
				stmt = conn.createStatement();
				stmt.executeUpdate(sqlValue);
				return true;
			} catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e){
				HttpServletRequest request = (HttpServletRequest)
						ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
				request.setAttribute("Error", "repeat");
				return false;
			} catch (com.mysql.jdbc.MysqlDataTruncation e){
				HttpServletRequest request = (HttpServletRequest)
						ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
				request.setAttribute("Error", "dataTooLong");
				return false;
			} catch (Exception ex) {
				System.out.println("Insert.java-insertCounciltitle(Counciltitle):Boolean wrong!");
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

		public Boolean insertDegree(CodeModel de){
			//建立连接
			LinkDB link =  new LinkDB();
			Connection conn = link.getConn();
			Statement stmt = null;
			
			String sqlValue = "insert into code_degree values('" 
							+ de.getCodeNo()+ "','"
							+ de.getCodeName() + "','"
							+ de.getCodeComments() + "')";
			try {
				stmt = conn.createStatement();
				stmt.executeUpdate(sqlValue);
				return true;
			} catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e){
				HttpServletRequest request = (HttpServletRequest)
						ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
				request.setAttribute("Error", "repeat");
				return false;
			} catch (com.mysql.jdbc.MysqlDataTruncation e){
				HttpServletRequest request = (HttpServletRequest)
						ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
				request.setAttribute("Error", "dataTooLong");
				return false;
			} catch (Exception ex) {
				System.out.println("Insert.java-insertDegree(Degree):Boolean wrong!");
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

		public Boolean insertEducation(CodeModel ed){
			//建立连接
			LinkDB link =  new LinkDB();
			Connection conn = link.getConn();
			Statement stmt = null;
			
			String sqlValue = "insert into code_education values('" 
							+ ed.getCodeNo()+ "','"
							+ ed.getCodeName() + "','"
							+ ed.getCodeComments() + "')";
			try {
				stmt = conn.createStatement();
				stmt.executeUpdate(sqlValue);
				return true;
			} catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e){
				HttpServletRequest request = (HttpServletRequest)
						ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
				request.setAttribute("Error", "repeat");
				return false;
			} catch (com.mysql.jdbc.MysqlDataTruncation e){
				HttpServletRequest request = (HttpServletRequest)
						ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
				request.setAttribute("Error", "dataTooLong");
				return false;
			} catch (Exception ex) {
				System.out.println("Insert.java-insertEducation(Education):Boolean wrong!");
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
		
		public Boolean insertEngage(CodeModel en){
			//建立连接
			LinkDB link =  new LinkDB();
			Connection conn = link.getConn();
			Statement stmt = null;
			
			String sqlValue = "insert into code_engage values('" 
							+ en.getCodeNo()+ "','"
							+ en.getCodeName() + "','"
							+ en.getCodeComments() + "')";
			try {
				stmt = conn.createStatement();
				stmt.executeUpdate(sqlValue);
				return true;
			} catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e){
				HttpServletRequest request = (HttpServletRequest)
						ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
				request.setAttribute("Error", "repeat");
				return false;
			} catch (com.mysql.jdbc.MysqlDataTruncation e){
				HttpServletRequest request = (HttpServletRequest)
						ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
				request.setAttribute("Error", "dataTooLong");
				return false;
			} catch (Exception ex) {
				System.out.println("Insert.java-insertEngage(Engage):Boolean wrong!");
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

		public Boolean insertGrouptitle(CodeModel gp){
			//建立连接
			LinkDB link =  new LinkDB();
			Connection conn = link.getConn();
			Statement stmt = null;
			
			String sqlValue = "insert into code_grouptitle values('" 
							+ gp.getCodeNo()+ "','"
							+ gp.getCodeName() + "','"
							+ gp.getCodeComments() + "')";
			try {
				stmt = conn.createStatement();
				stmt.executeUpdate(sqlValue);
				return true;
			} catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e){
				HttpServletRequest request = (HttpServletRequest)
						ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
				request.setAttribute("Error", "repeat");
				return false;
			} catch (com.mysql.jdbc.MysqlDataTruncation e){
				HttpServletRequest request = (HttpServletRequest)
						ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
				request.setAttribute("Error", "dataTooLong");
				return false;
			} catch (Exception ex) {
				System.out.println("Insert.java-insertGrouptitle(Grouptitle):Boolean wrong!");
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
		
		public Boolean insertSeries(CodeModel se){
			//建立连接
			LinkDB link =  new LinkDB();
			Connection conn = link.getConn();
			Statement stmt = null;
			
			String sqlValue = "insert into code_series values('" 
							+ se.getCodeNo()+ "','"
							+ se.getCodeName() + "','"
							+ se.getCodeComments() + "')";
			try {
				stmt = conn.createStatement();
				stmt.executeUpdate(sqlValue);
				return true;
			} catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e){
				HttpServletRequest request = (HttpServletRequest)
						ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
				request.setAttribute("Error", "repeat");
				return false;
			} catch (com.mysql.jdbc.MysqlDataTruncation e){
				HttpServletRequest request = (HttpServletRequest)
						ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
				request.setAttribute("Error", "dataTooLong");
				return false;
			} catch (Exception ex) {
				System.out.println("Insert.java-insertSeries(Series):Boolean wrong!");
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
//			Insert test = new Insert();
//			Sex temp = new Sex();
//			temp.setCodeNo("0001");
//			temp.setCodeName("11");
//			temp.setCodeComments("222");
//			test.insertSex(temp);
//		}
		
		public Boolean insertSex(CodeModel sx){
			//建立连接
			LinkDB link =  new LinkDB();
			Connection conn = link.getConn();
			Statement stmt = null;
			
			String sqlValue = "insert into code_sex values('" 
							+ sx.getCodeNo()+ "','"
							+ sx.getCodeName() + "','"
							+ sx.getCodeComments() + "')";
			
			System.out.println("insertSex() sqlValue"+sqlValue);
			try {
				stmt = conn.createStatement();
				stmt.executeUpdate(sqlValue);
				return true;
			} catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e){
				HttpServletRequest request = (HttpServletRequest)
						ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
				request.setAttribute("Error", "repeat");
				return false;
			} catch (com.mysql.jdbc.MysqlDataTruncation e){
				HttpServletRequest request = (HttpServletRequest)
						ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
				request.setAttribute("Error", "dataTooLong");
				return false;
			} catch (Exception ex) {
				System.out.println("Insert.java-insertSex(Sex):Boolean wrong!");
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

		public Boolean insertSpecial(CodeModel sp){
			//建立连接
			LinkDB link =  new LinkDB();
			Connection conn = link.getConn();
			Statement stmt = null;
			
			String sqlValue = "insert into code_special values('" 
							+ sp.getCodeNo()+ "','"
							+ sp.getCodeName() + "','"
							+ sp.getCodeComments() + "')";
			try {
				stmt = conn.createStatement();
				stmt.executeUpdate(sqlValue);
				return true;
			} catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e){
				HttpServletRequest request = (HttpServletRequest)
						ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
				request.setAttribute("Error", "repeat");
				return false;
			} catch (com.mysql.jdbc.MysqlDataTruncation e){
				HttpServletRequest request = (HttpServletRequest)
						ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
				request.setAttribute("Error", "dataTooLong");
				return false;
			} catch (Exception ex) {
				System.out.println("Insert.java-insertSpecial(Special):Boolean wrong!");
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

		public Boolean insertTitle(CodeModel te){
			//建立连接
			LinkDB link =  new LinkDB();
			Connection conn = link.getConn();
			Statement stmt = null;
			
			String sqlValue = "insert into code_title values('" 
							+ te.getCodeNo()+ "','"
							+ te.getCodeName() + "','"
							+ te.getCodeComments() + "')";
			try {
				stmt = conn.createStatement();
				stmt.executeUpdate(sqlValue);
				return true;
			} catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e){
				HttpServletRequest request = (HttpServletRequest)
						ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
				request.setAttribute("Error", "repeat");
				return false;
			} catch (com.mysql.jdbc.MysqlDataTruncation e){
				HttpServletRequest request = (HttpServletRequest)
						ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
				request.setAttribute("Error", "dataTooLong");
				return false;
			} catch (Exception ex) {
				System.out.println("Insert.java-insertTitle(Title):Boolean wrong!");
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

		public Boolean insertTitlegrade(CodeModel tg){
			//建立连接
			LinkDB link =  new LinkDB();
			Connection conn = link.getConn();
			Statement stmt = null;
			
			String sqlValue = "insert into code_titlegrade values('" 
							+ tg.getCodeNo()+ "','"
							+ tg.getCodeName() + "','"
							+ tg.getCodeComments() + "')";
			try {
				stmt = conn.createStatement();
				stmt.executeUpdate(sqlValue);
				return true;
			} catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e){
				HttpServletRequest request = (HttpServletRequest)
						ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
				request.setAttribute("Error", "repeat");
				return false;
			} catch (com.mysql.jdbc.MysqlDataTruncation e){
				HttpServletRequest request = (HttpServletRequest)
						ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
				request.setAttribute("Error", "dataTooLong");
				return false;
			} catch (Exception ex) {
				System.out.println("Insert.java-insertTitlegrade(Titlegrade):Boolean wrong!");
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
		
		public Boolean insertDirectorHistoryTitle(String serveYear, List<Expert> resultExperts){
			//建立连接
			LinkDB link =  new LinkDB();
			Connection conn = link.getConn();
			Statement stmt = null;
			String sqlValue = "insert into history_title(expert_no,expert_name,expert_jury,"
					+ "expert_group,expert_post,expert_serveyear) values";
			for(int i=0; i<resultExperts.size(); i++){
				sqlValue += "('"
						+ resultExperts.get(i).getExpert_Field1() + "','"
						+ resultExperts.get(i).getExpert_Field2() + "','"
						+ resultExperts.get(i).getExpert_Field31() + "','"
						+ resultExperts.get(i).getExpert_Field33() + "','"
						+ "主任委员" + "','"
						+ serveYear + "'),";
			}
			sqlValue = sqlValue.substring(0, sqlValue.length()-1);
//			System.out.println(sqlValue);
//			String sqlValue = "insert into history_title(expert_no,expert_name,expert_jury,"
//					+ "expert_group,expert_post,expert_serveyear) values('" 
//							+ resultExpert.getExpert_Field1() + "','"
//							+ resultExpert.getExpert_Field2() + "','"
//							+ resultExpert.getExpert_Field31() + "','"
//							+ resultExpert.getExpert_Field33() + "','"
//							+ post + "','"
//							+ serveYear + "')";
			try {
				stmt = conn.createStatement();
				stmt.executeUpdate(sqlValue);
				return true;
			} catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e){
				HttpServletRequest request = (HttpServletRequest)
						ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
				request.setAttribute("Error", "repeat");
				return false;
			} catch (com.mysql.jdbc.MysqlDataTruncation e){
				HttpServletRequest request = (HttpServletRequest)
						ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
				request.setAttribute("Error", "dataTooLong");
				return false;
			} catch (Exception ex) {
				System.out.println("Insert.java-insertDirectorHistoryTitle(String,List<Expert>):Boolean wrong!");
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

		public Boolean insertViceDirectorHistoryTitle(String serveYear, List<Expert> resultExperts){
			//建立连接
			LinkDB link =  new LinkDB();
			Connection conn = link.getConn();
			Statement stmt = null;
			
			String sqlValue = "insert into history_title(expert_no,expert_name,expert_jury,"
					+ "expert_group,expert_post,expert_serveyear) values";
			for(int i=0; i<resultExperts.size(); i++){
				sqlValue += "('"
						+ resultExperts.get(i).getExpert_Field1() + "','"
						+ resultExperts.get(i).getExpert_Field2() + "','"
						+ resultExperts.get(i).getExpert_Field31() + "','"
						+ resultExperts.get(i).getExpert_Field33() + "','"
						+ "副主任委员" + "','"
						+ serveYear + "'),";
			}
			sqlValue = sqlValue.substring(0, sqlValue.length()-1);
			
			try {
				stmt = conn.createStatement();
				stmt.executeUpdate(sqlValue);
				return true;
			} catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e){
				HttpServletRequest request = (HttpServletRequest)
						ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
				request.setAttribute("Error", "repeat");
				return false;
			} catch (com.mysql.jdbc.MysqlDataTruncation e){
				HttpServletRequest request = (HttpServletRequest)
						ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
				request.setAttribute("Error", "dataTooLong");
				return false;
			} catch (Exception ex) {
				System.out.println("Insert.java-insertViceDirectorHistoryTitle(String,List<Expert>):Boolean wrong!");
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

		public Boolean insertCommitteeHistoryTitle(String serveYear, List<Expert> resultExperts){
			//建立连接
			LinkDB link =  new LinkDB();
			Connection conn = link.getConn();
			Statement stmt = null;
			
			String sqlValue = "insert into history_title(expert_no,expert_name,expert_jury,"
					+ "expert_group,expert_post,expert_serveyear) values";
			for(int i=0; i<resultExperts.size(); i++){
				sqlValue += "('"
						+ resultExperts.get(i).getExpert_Field1() + "','"
						+ resultExperts.get(i).getExpert_Field2() + "','"
						+ resultExperts.get(i).getExpert_Field31() + "','"
						+ resultExperts.get(i).getExpert_Field33() + "','"
						+ "委员" + "','"
						+ serveYear + "'),";
			}
			sqlValue = sqlValue.substring(0, sqlValue.length()-1);
			
			try {
				stmt = conn.createStatement();
				stmt.executeUpdate(sqlValue);
				return true;
			} catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e){
				HttpServletRequest request = (HttpServletRequest)
						ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
				request.setAttribute("Error", "repeat");
				return false;
			} catch (com.mysql.jdbc.MysqlDataTruncation e){
				HttpServletRequest request = (HttpServletRequest)
						ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
				request.setAttribute("Error", "dataTooLong");
				return false;
			} catch (Exception ex) {
				System.out.println("Insert.java-insertCommitteeHistoryTitle(String,List<Expert>):Boolean wrong!");
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

		public Boolean insertGroupLeaderHistoryTitle(String serveYear, List<Expert> resultExperts){
			//建立连接
			LinkDB link =  new LinkDB();
			Connection conn = link.getConn();
			Statement stmt = null;
			
			String sqlValue = "insert into history_title(expert_no,expert_name,expert_jury,"
					+ "expert_group,expert_post,expert_serveyear) values";
			for(int i=0; i<resultExperts.size(); i++){
				sqlValue += "('"
						+ resultExperts.get(i).getExpert_Field1() + "','"
						+ resultExperts.get(i).getExpert_Field2() + "','"
						+ resultExperts.get(i).getExpert_Field31() + "','"
						+ resultExperts.get(i).getExpert_Field33() + "','"
						+ "组长" + "','"
						+ serveYear + "'),";
			}
			sqlValue = sqlValue.substring(0, sqlValue.length()-1);
			System.out.println("insertGroupLeaderHistoryTitle -> sqlValue:" + sqlValue);
			try {
				stmt = conn.createStatement();
				stmt.executeUpdate(sqlValue);
				return true;
			} catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e){
				HttpServletRequest request = (HttpServletRequest)
						ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
				request.setAttribute("Error", "repeat");
				return false;
			} catch (com.mysql.jdbc.MysqlDataTruncation e){
				HttpServletRequest request = (HttpServletRequest)
						ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
				request.setAttribute("Error", "dataTooLong");
				return false;
			} catch (Exception ex) {
				System.out.println("Insert.java-insertGroupLeaderHistoryTitle(String,List<Expert>):Boolean wrong!");
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

		public Boolean insertGroupMemberHistoryTitle(String serveYear, List<Expert> resultExperts){
			//建立连接
			LinkDB link =  new LinkDB();
			Connection conn = link.getConn();
			Statement stmt = null;
			
			String sqlValue = "insert into history_title(expert_no,expert_name,expert_jury,"
					+ "expert_group,expert_post,expert_serveyear) values";
			for(int i=0; i<resultExperts.size(); i++){
				sqlValue += "('"
						+ resultExperts.get(i).getExpert_Field1() + "','"
						+ resultExperts.get(i).getExpert_Field2() + "','"
						+ resultExperts.get(i).getExpert_Field31() + "','"
						+ resultExperts.get(i).getExpert_Field33() + "','"
						+ "组员" + "','"
						+ serveYear + "'),";
			}
			sqlValue = sqlValue.substring(0, sqlValue.length()-1);
			
			try {
				stmt = conn.createStatement();
				stmt.executeUpdate(sqlValue);
				return true;
			} catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e){
				HttpServletRequest request = (HttpServletRequest)
						ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
				request.setAttribute("Error", "repeat");
				return false;
			} catch (com.mysql.jdbc.MysqlDataTruncation e){
				HttpServletRequest request = (HttpServletRequest)
						ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
				request.setAttribute("Error", "dataTooLong");
				return false;
			} catch (Exception ex) {
				System.out.println("Insert.java-insertGroupMemberHistoryTitle(String,List<Expert>):Boolean wrong!");
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
		
		public Boolean insertJuryIdcode(JuryIdcode jic){
			//建立连接
			LinkDB link =  new LinkDB();
			Connection conn = link.getConn();
			Statement stmt = null;
			
			String sqlValue = "insert into jury_idcode(jury_no,expert_name,expert_phone) values('" 
							+ jic.getJuryNo() + "','"
							+ jic.getExpert_name() + "','"
							+ jic.getExpert_phone() + "')";
			
			//System.out.println("insertSex() sqlValue"+sqlValue);
			try {
				stmt = conn.createStatement();
				stmt.executeUpdate(sqlValue);
				return true;
			} catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e){
				HttpServletRequest request = (HttpServletRequest)
						ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
				request.setAttribute("Error", "repeat");
				return false;
			} catch (com.mysql.jdbc.MysqlDataTruncation e){
				HttpServletRequest request = (HttpServletRequest)
						ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
				request.setAttribute("Error", "dataTooLong");
				return false;
			} catch (Exception ex) {
				System.out.println("Insert.java-insertJuryIdcode(JuryIdcode):Boolean wrong!");
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
		
		public Boolean insertJuryIdcodes(List<JuryIdcode> jic){
			//建立连接
			LinkDB link =  new LinkDB();
			Connection conn = link.getConn();
			Statement stmt = null;
			String sqlValue = "insert into jury_idcode(jury_no,expert_name,expert_phone,id_code,state,code_invalid_time) values";
			for(int i=0;i<jic.size();i++){
				sqlValue += "('" 
							+ jic.get(i).getJuryNo() + "','"
							+ jic.get(i).getExpert_name() + "','"
							+ jic.get(i).getExpert_phone() + "','"
							+ jic.get(i).getId_code() + "','"
							+ jic.get(i).getState() + "','"
							+ jic.get(i).getCode_invalid_time() + "')";
				if((i+1) == jic.size()){
					sqlValue += ";";
				} else{
					sqlValue += ",";
				}
			}
			try {
				//System.out.println("sqlValue:" + sqlValue);
				stmt = conn.createStatement();
				stmt.executeUpdate(sqlValue);
				return true;
			} catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e){
				HttpServletRequest request = (HttpServletRequest)
						ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
				request.setAttribute("Error", "repeat");
				return false;
			} catch (com.mysql.jdbc.MysqlDataTruncation e){
				HttpServletRequest request = (HttpServletRequest)
						ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
				request.setAttribute("Error", "dataTooLong");
				return false;
			} catch (Exception ex) {
				System.out.println("Insert.java-insertJuryIdcode(JuryIdcode):Boolean wrong!");
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
		
		
		public Boolean insertRuleManagement(RuleManagement obj) {
			//建立连接
			LinkDB link =  new LinkDB();
			Connection conn = link.getConn();
			Statement stmt = null;
			String sqlValue = "insert into rule_management(rule_no,rule_field,rule_relation,rule_value,rule_percent,rule_percentRelation,rule_range,rule_force,rule_enabled) values ('"
						+ obj.getRule_no() + "','"
						+ obj.getRule_field() + "','"
						+ obj.getRule_relation() + "','"
						+ obj.getRule_value() + "','"
						+ obj.getRule_percent() + "','"
						+ obj.getRule_percentRelation() + "','"
						+ obj.getRule_range() + "','"
						+ obj.getRule_force() + "','"
						+ obj.getRule_enabled() + "')";
			try {
				System.out.println("sqlValue:" + sqlValue);
				stmt = conn.createStatement();
				stmt.executeUpdate(sqlValue);
				return true;
			} catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e){
				HttpServletRequest request = (HttpServletRequest)
						ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
				request.setAttribute("Error", "repeat");
				return false;
			} catch (com.mysql.jdbc.MysqlDataTruncation e){
				HttpServletRequest request = (HttpServletRequest)
						ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
				request.setAttribute("Error", "dataTooLong");
				return false;
			} catch (Exception ex) {
				System.out.println("Insert.java-insertRuleManagement(RuleManagement):Boolean wrong!");
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
//			Insert test = new Insert();
//			Counciltitle ct = new Counciltitle("a","b","c");
//			test.insertCounciltitle(ct);
//		}
}