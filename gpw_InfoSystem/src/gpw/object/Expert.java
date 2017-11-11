package gpw.object;

import gpw.connection.LinkDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Expert {
	/*private String Expert_id;*/
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
	
	public Expert(){}
	
	public Expert(String Expert_Field1, String Expert_Field2, 
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
//		this.Expert_id = Expert_id;
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

	
	public String getExpert(int i){
		String tempResult = "";
		switch(i){
		case 1: tempResult = this.Expert_Field1;break;
		case 2: tempResult = this.Expert_Field2;break;
		case 3: tempResult = this.Expert_Field3;break;
		case 4: tempResult = this.Expert_Field4;break;
		case 5: tempResult = this.Expert_Field5;break;
		case 6: tempResult = this.Expert_Field6;break;
		case 7: tempResult = this.Expert_Field7;break;
		case 8: tempResult = this.Expert_Field8;break;
		case 9: tempResult = this.Expert_Field9;break;
		case 10: tempResult = this.Expert_Field10;break;
		case 11: tempResult = this.Expert_Field11;break;
		case 12: tempResult = this.Expert_Field12;break;
		case 13: tempResult = this.Expert_Field13;break;
		case 14: tempResult = this.Expert_Field14;break;
		case 15: tempResult = this.Expert_Field15;break;
		case 16: tempResult = this.Expert_Field16;break;
		case 17: tempResult = this.Expert_Field17;break;
		case 18: tempResult = this.Expert_Field18;break;
		case 19: tempResult = this.Expert_Field19;break;
		case 20: tempResult = this.Expert_Field20;break;
		case 21: tempResult = this.Expert_Field21;break;
		case 22: tempResult = this.Expert_Field22;break;
		case 23: tempResult = this.Expert_Field23;break;
		case 24: tempResult = this.Expert_Field24;break;
		case 25: tempResult = this.Expert_Field25;break;
		case 26: tempResult = this.Expert_Field26;break;
		case 27: tempResult = this.Expert_Field27;break;
		case 28: tempResult = this.Expert_Field28;break;
		case 29: tempResult = this.Expert_Field29;break;
		case 30: tempResult = this.Expert_Field30;break;
		case 31: tempResult = this.Expert_Field31;break;
		case 32: tempResult = this.Expert_Field32;break;
		case 33: tempResult = this.Expert_Field33;break;
		case 34: tempResult = this.Expert_Field34;break;
		case 35: tempResult = this.Expert_Field35;break;
		default: tempResult = "wrong";break;
		}
		return tempResult;
	}
	
	public String getExpert_Field1() {
		return Expert_Field1;
	}

	public void setExpert_Field1(String expert_Field1) {
		Expert_Field1 = expert_Field1;
	}

	public String getExpert_Field2() {
		return Expert_Field2;
	}

	public void setExpert_Field2(String expert_Field2) {
		Expert_Field2 = expert_Field2;
	}

	public String getExpert_Field3() {
		return Expert_Field3;
	}

	public void setExpert_Field3(String expert_Field3) {
		Expert_Field3 = expert_Field3;
	}

	public String getExpert_Field4() {
		return Expert_Field4;
	}

	public void setExpert_Field4(String expert_Field4) {
		Expert_Field4 = expert_Field4;
	}

	public String getExpert_Field5() {
		return Expert_Field5;
	}

	public void setExpert_Field5(String expert_Field5) {
		Expert_Field5 = expert_Field5;
	}

	public String getExpert_Field6() {
		return Expert_Field6;
	}

	public void setExpert_Field6(String expert_Field6) {
		Expert_Field6 = expert_Field6;
	}

	public String getExpert_Field7() {
		return Expert_Field7;
	}

	public void setExpert_Field7(String expert_Field7) {
		Expert_Field7 = expert_Field7;
	}

	public String getExpert_Field8() {
		return Expert_Field8;
	}

	public void setExpert_Field8(String expert_Field8) {
		Expert_Field8 = expert_Field8;
	}

	public String getExpert_Field9() {
		return Expert_Field9;
	}

	public void setExpert_Field9(String expert_Field9) {
		Expert_Field9 = expert_Field9;
	}

	public String getExpert_Field10() {
		return Expert_Field10;
	}

	public void setExpert_Field10(String expert_Field10) {
		Expert_Field10 = expert_Field10;
	}

	public String getExpert_Field11() {
		return Expert_Field11;
	}

	public void setExpert_Field11(String expert_Field11) {
		Expert_Field11 = expert_Field11;
	}

	public String getExpert_Field12() {
		return Expert_Field12;
	}

	public void setExpert_Field12(String expert_Field12) {
		Expert_Field12 = expert_Field12;
	}

	public String getExpert_Field13() {
		return Expert_Field13;
	}

	public void setExpert_Field13(String expert_Field13) {
		Expert_Field13 = expert_Field13;
	}

	public String getExpert_Field14() {
		return Expert_Field14;
	}

	public void setExpert_Field14(String expert_Field14) {
		Expert_Field14 = expert_Field14;
	}

	public String getExpert_Field15() {
		return Expert_Field15;
	}

	public void setExpert_Field15(String expert_Field15) {
		Expert_Field15 = expert_Field15;
	}

	public String getExpert_Field16() {
		return Expert_Field16;
	}

	public void setExpert_Field16(String expert_Field16) {
		Expert_Field16 = expert_Field16;
	}

	public String getExpert_Field17() {
		return Expert_Field17;
	}

	public void setExpert_Field17(String expert_Field17) {
		Expert_Field17 = expert_Field17;
	}

	public String getExpert_Field18() {
		return Expert_Field18;
	}

	public void setExpert_Field18(String expert_Field18) {
		Expert_Field18 = expert_Field18;
	}

	public String getExpert_Field19() {
		return Expert_Field19;
	}

	public void setExpert_Field19(String expert_Field19) {
		Expert_Field19 = expert_Field19;
	}

	public String getExpert_Field20() {
		return Expert_Field20;
	}

	public void setExpert_Field20(String expert_Field20) {
		Expert_Field20 = expert_Field20;
	}

	public String getExpert_Field21() {
		return Expert_Field21;
	}

	public void setExpert_Field21(String expert_Field21) {
		Expert_Field21 = expert_Field21;
	}

	public String getExpert_Field22() {
		return Expert_Field22;
	}

	public void setExpert_Field22(String expert_Field22) {
		Expert_Field22 = expert_Field22;
	}

	public String getExpert_Field23() {
		return Expert_Field23;
	}

	public void setExpert_Field23(String expert_Field23) {
		Expert_Field23 = expert_Field23;
	}

	public String getExpert_Field24() {
		return Expert_Field24;
	}

	public void setExpert_Field24(String expert_Field24) {
		Expert_Field24 = expert_Field24;
	}

	public String getExpert_Field25() {
		return Expert_Field25;
	}

	public void setExpert_Field25(String expert_Field25) {
		Expert_Field25 = expert_Field25;
	}

	public String getExpert_Field26() {
		return Expert_Field26;
	}

	public void setExpert_Field26(String expert_Field26) {
		Expert_Field26 = expert_Field26;
	}

	public String getExpert_Field27() {
		return Expert_Field27;
	}

	public void setExpert_Field27(String expert_Field27) {
		Expert_Field27 = expert_Field27;
	}

	public String getExpert_Field28() {
		return Expert_Field28;
	}

	public void setExpert_Field28(String expert_Field28) {
		Expert_Field28 = expert_Field28;
	}

	public String getExpert_Field29() {
		return Expert_Field29;
	}

	public void setExpert_Field29(String expert_Field29) {
		Expert_Field29 = expert_Field29;
	}

	public String getExpert_Field30() {
		return Expert_Field30;
	}

	public void setExpert_Field30(String expert_Field30) {
		Expert_Field30 = expert_Field30;
	}

	public String getExpert_Field31() {
		return Expert_Field31;
	}

	public void setExpert_Field31(String expert_Field31) {
		Expert_Field31 = expert_Field31;
	}

	public String getExpert_Field32() {
		return Expert_Field32;
	}

	public void setExpert_Field32(String expert_Field32) {
		Expert_Field32 = expert_Field32;
	}

	public String getExpert_Field33() {
		return Expert_Field33;
	}

	public void setExpert_Field33(String expert_Field33) {
		Expert_Field33 = expert_Field33;
	}

	public String getExpert_Field34() {
		return Expert_Field34;
	}

	public void setExpert_Field34(String expert_Field34) {
		Expert_Field34 = expert_Field34;
	}

	public String getExpert_Field35() {
		return Expert_Field35;
	}

	public void setExpert_Field35(String expert_Field35) {
		Expert_Field35 = expert_Field35;
	}
	
	public String getExpertInfoByFieldId (String fieldId){
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String result = null;
		String tempField = "Expert_Field"+fieldId;
		String sqlValue = "select "+tempField+" from infolistview where Expert_Field1 ='" +this.Expert_Field1+ "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				result = rs.getString(tempField);
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
	
	public void setExpertInfoByFieldId (String fieldId, String value){
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String tempField = "Expert_Field"+fieldId;
		String sqlValue = "update expert_baseinfo set "+tempField+"='"+value+"' where Expert_field1 ='"+this.Expert_Field1+"'";
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sqlValue);
		} catch (Exception ex) {
			System.out.println("Expert.java-setExpertInfoByFieldId(String, String) wrong!");
			//ex.printStackTrace();
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
	public static void main(String[] args)
	{
		Expert test = new Expert();
		test.setExpert_Field1("01010001");
		test.setExpertInfoByFieldId("2", "陈昊地");
	}
	
	
	public String getExpertInfoByOrder (String order){
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		String result = null;
		String sqlValue1 = "select Field_id from systable_stru where Field_order ='" +order+ "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue1);
			while (rs.next()) {
				String tempField = "Expert_Field"+rs.getString("Field_id");
				String sqlValue2 = "select "+tempField+" from infolistview where Expert_Field1 ='" +this.Expert_Field1+ "'";
				stmt = conn.createStatement();
				rs1 = stmt.executeQuery(sqlValue2);
				while (rs1.next()){
					result = rs1.getString(tempField);
				}
			}
//			System.out.println("order:"+order);
//			System.out.println("result:"+result);
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
				if (rs1 != null) {
					rs1.close();
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
	
	public String generateExpertNo(String juryNo){
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String result = juryNo;
		String tempResult = null;
		String sqlValue = "select max(Expert_Field1) as temp from expert_baseinfo where Expert_Field1 like '"+juryNo+"%'";
		System.out.println(sqlValue);
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
	
//	public static void main(String[] args){
//		Expert test = new Expert();
//		test
//	}
	

//	@Override
//	public String toString() {
//		// TODO 自动生成的方法存根
//		return "Expert: expert_field2:"+ Expert_Field2 + " Expert_field1:" + Expert_Field1 +"\n  Expert_field3:" + Expert_Field3;
//	}
}
