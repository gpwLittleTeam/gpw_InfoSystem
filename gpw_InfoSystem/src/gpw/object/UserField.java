package gpw.object;

import gpw.connection.LinkDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class UserField {
	//user的默认字段
	private String user_name; //用户名
	private String Expert_Field1;	//编号
	private String Expert_Field2;	//姓名
	private String Expert_Field3;	//性别
	private String Expert_Field4;	//身份证
	private String Expert_Field5;	//出生年月
	private String Expert_Field6;	//最高学历
	private String Expert_Field7;	//所获学位
	private String Expert_Field8;	//毕肄业时间
	private String Expert_Field9;	//毕肄业学校
	private String Expert_Field10;	//所学专业
	private String Expert_Field11;	//参加工作时间
	private String Expert_Field12;	//现从事专业
	private String Expert_Field13;	//现从事专业年限
	private String Expert_Field14;	//工作单位
	private String Expert_Field15;	//是否本单位
	private String Expert_Field16;	//行政职务
	private String Expert_Field17;	//现有任职资格
	private String Expert_Field18;	//资格级别
	private String Expert_Field19;	//任职资格所属系列
	private String Expert_Field20;	//任职资格取得时间
	private String Expert_Field21;	//聘任情况
	private String Expert_Field22;	//曾属高评委名称
	private String Expert_Field23;	//曾任高评委职务
	private String Expert_Field24;	//任职时间
	private String Expert_Field25;	//通信地址
	private String Expert_Field26;	//手机
	private String Expert_Field27;	//办公室电话
	private String Expert_Field28;	//住宅电话
	private String Expert_Field29;	//邮政编码
	private String Expert_Field30;	//电子邮箱
	private String Expert_Field31;	//现拟任高评委名称
	private String Expert_Field32;	//拟任高评委职务
	private String Expert_Field33;	//所属专业组名称
	private String Expert_Field34;	//拟任专业组职务
	private String Expert_Field35;	//入库时间
	
	public UserField(){
		
	}
	
	public UserField(String user_name, String Expert_Field1, String Expert_Field2, 
			 String Expert_Field3, String Expert_Field4, String Expert_Field5,
			 String Expert_Field6, String Expert_Field7, String Expert_Field8,
			 String Expert_Field9, String Expert_Field10, String Expert_Field11,
			 String Expert_Field12, String Expert_Field13, String Expert_Field14,
			 String Expert_Field15, String Expert_Field16, String Expert_Field17,
			 String Expert_Field18, String Expert_Field19, String Expert_Field20,
			 String Expert_Field21, String Expert_Field22, String Expert_Field23,
			 String Expert_Field24, String Expert_Field25, String Expert_Field26,
			 String Expert_Field27, String Expert_Field28, String Expert_Field29,
			 String Expert_Field30, String Expert_Field31, String Expert_Field32,
			 String Expert_Field33, String Expert_Field34, String Expert_Field35){
		this.user_name = user_name;
		this.Expert_Field1 = Expert_Field1;
		this.Expert_Field2 = Expert_Field2;
		this.Expert_Field3 = Expert_Field3;
		this.Expert_Field4 = Expert_Field4;
		this.Expert_Field5 = Expert_Field5;
		this.Expert_Field6 = Expert_Field6;
		this.Expert_Field7 = Expert_Field7;
		this.Expert_Field8 = Expert_Field8;
		this.Expert_Field9 = Expert_Field9;
		this.Expert_Field10 = Expert_Field10;
		this.Expert_Field11 = Expert_Field11;
		this.Expert_Field12 = Expert_Field12;
		this.Expert_Field13 = Expert_Field13;
		this.Expert_Field14 = Expert_Field14;
		this.Expert_Field15 = Expert_Field15;
		this.Expert_Field16 = Expert_Field16;
		this.Expert_Field17 = Expert_Field17;
		this.Expert_Field18 = Expert_Field18;
		this.Expert_Field19 = Expert_Field19;
		this.Expert_Field20 = Expert_Field20;
		this.Expert_Field21 = Expert_Field21;
		this.Expert_Field22 = Expert_Field22;
		this.Expert_Field23 = Expert_Field23;
		this.Expert_Field24 = Expert_Field24;
		this.Expert_Field25 = Expert_Field25;
		this.Expert_Field26 = Expert_Field26;
		this.Expert_Field27 = Expert_Field27;
		this.Expert_Field28 = Expert_Field28;
		this.Expert_Field29 = Expert_Field29;
		this.Expert_Field30 = Expert_Field30;
		this.Expert_Field31 = Expert_Field31;
		this.Expert_Field32 = Expert_Field32;
		this.Expert_Field33 = Expert_Field33;
		this.Expert_Field34 = Expert_Field34;
		this.Expert_Field35 = Expert_Field35;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getExpert_Field1() {
		return Expert_Field1;
	}

	public void setExpert_Field1(String Expert_Field1) {
		this.Expert_Field1 = Expert_Field1;
	}

	public String getExpert_Field2() {
		return Expert_Field2;
	}

	public void setExpert_Field2(String Expert_Field2) {
		this.Expert_Field2 = Expert_Field2;
	}

	public String getExpert_Field3() {
		return Expert_Field3;
	}

	public void setExpert_Field3(String Expert_Field3) {
		this.Expert_Field3 = Expert_Field3;
	}

	public String getExpert_Field4() {
		return Expert_Field4;
	}

	public void setExpert_Field4(String Expert_Field4) {
		this.Expert_Field4 = Expert_Field4;
	}

	public String getExpert_Field5() {
		return Expert_Field5;
	}

	public void setExpert_Field5(String Expert_Field5) {
		this.Expert_Field5 = Expert_Field5;
	}

	public String getExpert_Field6() {
		return Expert_Field6;
	}

	public void setExpert_Field6(String Expert_Field6) {
		this.Expert_Field6 = Expert_Field6;
	}

	public String getExpert_Field7() {
		return Expert_Field7;
	}

	public void setExpert_Field7(String Expert_Field7) {
		this.Expert_Field7 = Expert_Field7;
	}

	public String getExpert_Field8() {
		return Expert_Field8;
	}

	public void setExpert_Field8(String Expert_Field8) {
		this.Expert_Field8 = Expert_Field8;
	}

	public String getExpert_Field9() {
		return Expert_Field9;
	}

	public void setExpert_Field9(String Expert_Field9) {
		this.Expert_Field9 = Expert_Field9;
	}

	public String getExpert_Field10() {
		return Expert_Field10;
	}

	public void setExpert_Field10(String Expert_Field10) {
		this.Expert_Field10 = Expert_Field10;
	}

	public String getExpert_Field11() {
		return Expert_Field11;
	}

	public void setExpert_Field11(String Expert_Field11) {
		this.Expert_Field11 = Expert_Field11;
	}

	public String getExpert_Field12() {
		return Expert_Field12;
	}

	public void setExpert_Field12(String Expert_Field12) {
		this.Expert_Field12 = Expert_Field12;
	}

	public String getExpert_Field13() {
		return Expert_Field13;
	}

	public void setExpert_Field13(String Expert_Field13) {
		this.Expert_Field13 = Expert_Field13;
	}

	public String getExpert_Field14() {
		return Expert_Field14;
	}

	public void setExpert_Field14(String Expert_Field14) {
		this.Expert_Field14 = Expert_Field14;
	}

	public String getExpert_Field15() {
		return Expert_Field15;
	}

	public void setExpert_Field15(String Expert_Field15) {
		this.Expert_Field15 = Expert_Field15;
	}

	public String getExpert_Field16() {
		return Expert_Field16;
	}

	public void setExpert_Field16(String Expert_Field16) {
		this.Expert_Field16 = Expert_Field16;
	}

	public String getExpert_Field17() {
		return Expert_Field17;
	}

	public void setExpert_Field17(String Expert_Field17) {
		this.Expert_Field17 = Expert_Field17;
	}

	public String getExpert_Field18() {
		return Expert_Field18;
	}

	public void setExpert_Field18(String Expert_Field18) {
		this.Expert_Field18 = Expert_Field18;
	}

	public String getExpert_Field19() {
		return Expert_Field19;
	}

	public void setExpert_Field19(String Expert_Field19) {
		this.Expert_Field19 = Expert_Field19;
	}

	public String getExpert_Field20() {
		return Expert_Field20;
	}

	public void setExpert_Field20(String Expert_Field20) {
		this.Expert_Field20 = Expert_Field20;
	}

	public String getExpert_Field21() {
		return Expert_Field21;
	}

	public void setExpert_Field21(String Expert_Field21) {
		this.Expert_Field21 = Expert_Field21;
	}

	public String getExpert_Field22() {
		return Expert_Field22;
	}

	public void setExpert_Field22(String Expert_Field22) {
		this.Expert_Field22 = Expert_Field22;
	}

	public String getExpert_Field23() {
		return Expert_Field23;
	}

	public void setExpert_Field23(String Expert_Field23) {
		this.Expert_Field23 = Expert_Field23;
	}

	public String getExpert_Field24() {
		return Expert_Field24;
	}

	public void setExpert_Field24(String Expert_Field24) {
		this.Expert_Field24 = Expert_Field24;
	}

	public String getExpert_Field25() {
		return Expert_Field25;
	}

	public void setExpert_Field25(String Expert_Field25) {
		this.Expert_Field25 = Expert_Field25;
	}

	public String getExpert_Field26() {
		return Expert_Field26;
	}

	public void setExpert_Field26(String Expert_Field26) {
		this.Expert_Field26 = Expert_Field26;
	}

	public String getExpert_Field27() {
		return Expert_Field27;
	}

	public void setExpert_Field27(String Expert_Field27) {
		this.Expert_Field27 = Expert_Field27;
	}

	public String getExpert_Field28() {
		return Expert_Field28;
	}

	public void setExpert_Field28(String Expert_Field28) {
		this.Expert_Field28 = Expert_Field28;
	}

	public String getExpert_Field29() {
		return Expert_Field29;
	}

	public void setExpert_Field29(String Expert_Field29) {
		this.Expert_Field29 = Expert_Field29;
	}

	public String getExpert_Field30() {
		return Expert_Field30;
	}

	public void setExpert_Field30(String Expert_Field30) {
		this.Expert_Field30 = Expert_Field30;
	}

	public String getExpert_Field31() {
		return Expert_Field31;
	}

	public void setExpert_Field31(String Expert_Field31) {
		this.Expert_Field31 = Expert_Field31;
	}

	public String getExpert_Field32() {
		return Expert_Field32;
	}

	public void setExpert_Field32(String Expert_Field32) {
		this.Expert_Field32 = Expert_Field32;
	}

	public String getExpert_Field33() {
		return Expert_Field33;
	}

	public void setExpert_Field33(String Expert_Field33) {
		this.Expert_Field33 = Expert_Field33;
	}

	public String getExpert_Field34() {
		return Expert_Field34;
	}

	public void setExpert_Field34(String Expert_Field34) {
		this.Expert_Field34 = Expert_Field34;
	}

	public String getExpert_Field35() {
		return Expert_Field35;
	}

	public void setExpert_Field35(String Expert_Field35) {
		this.Expert_Field35 = Expert_Field35;
	}
	
	
	//对应接口
	public List<String> getDefaultFieldNrByUserName (String name){
		//通过登录用户的id获得某高评委的默认字段

		
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		List<String> tempList = new ArrayList<String>();
		String sqlValue = "select * from user_field where user_name ='" +name+ "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				for(int i=1; i<=35; i++){
					String field = rs.getString("Expert_Field"+i);
					if(field.equals("1"))
					{
						String tempI = Integer.toString(i);
						tempList.add(tempI);
					}
				}
			}
			return tempList;
		} catch (Exception ex) {
			System.out.println("getDefaultFieldNrByUserId wrong!");
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
		
	public List<String> getDefaultFieldChNameByUserName (String name){
		UserField temp = new UserField();
		List<String> tempList = new ArrayList<String>();
		tempList = temp.getDefaultFieldNrByUserName(name);
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		List<String> resultList = new ArrayList<String>();
		try {
			for (int i=0; i<tempList.size(); i++){
				String sqlValue = "select Field_chname from systable_stru where Field_id ='" +tempList.get(i)+ "'";
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sqlValue);
				while (rs.next()) {
					resultList.add(rs.getString("Field_chname"));
				}
			}
			return resultList;
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
	
	public List<String> getDefaultFieldEnNameByUserName (String name){
		UserField temp = new UserField();
		List<String> tempList = new ArrayList<String>();
		tempList = temp.getDefaultFieldNrByUserName(name);
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		List<String> resultList = new ArrayList<String>();
		try {
			for (int i=0; i<tempList.size(); i++){
				String sqlValue = "select Field_name from systable_stru where Field_id ='" +tempList.get(i)+ "'";
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sqlValue);
				while (rs.next()) {
					resultList.add(rs.getString("Field_name"));
				}
			}
			return resultList;
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
}
