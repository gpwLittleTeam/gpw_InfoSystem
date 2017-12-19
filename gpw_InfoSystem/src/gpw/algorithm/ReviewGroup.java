package gpw.algorithm;

import gpw.connection.LinkDB;
import gpw.getInfo.GetExpert;
import gpw.object.Expert;
import gpw.object.Group;
import gpw.object.Grouptitle;
import gpw.object.Jury;
import gpw.operateDatabase.Insert;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;


public class ReviewGroup {
	String grouptitleLeaderName;
	String grouptitleMemeberName;
//	public List<Group> groupNames = new ArrayList<Group>(); //存储用于显示的专业组名字
//	public String juryNo = "";	//存储所在的高评委编号
//	public List<Expert> expertOfGroup = new ArrayList<Expert>(); //存储所需要显示信息的专业组里的专家们
//	public List<Expert> leaderOfGroup = new ArrayList<Expert>(); //存储最后选出来的组长，注意一次调用只会出来一个组长
//	public List<Expert> memberOfGroup = new ArrayList<Expert>(); //存储最后选出来的组员
//	//int numberOfChoosenGroup = 0; //存储所选了几个专业组数目
//	int numberToRandom = 0;
	
	//传入高评委编号，然后查询所拥有的专业组并存入groupNames
	public ReviewGroup() {
		//初始化专业组职务的名称
		Grouptitle objGrouptitle = new Grouptitle();
		grouptitleLeaderName = objGrouptitle.getPostByCode("01");
		grouptitleMemeberName = objGrouptitle.getPostByCode("02");
	}
	
	public List<Group> showReviewGroup(String juryNo){
		List<Group> groupNames = new ArrayList<Group>();
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from group_dept where Group_jury='"+juryNo+"'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Group tempGroup = null;
				String field2 = rs.getString("Group_no");
				String field3 = rs.getString("Group_name");
				String field4 = rs.getString("Group_jury");
				String field5 = rs.getString("Group_date");
				String field6 = rs.getString("Group_comm");
				tempGroup = new Group(field2, field3, field4, field5,
										field6);
				groupNames.add(tempGroup);
			}
			return groupNames;
		} catch (Exception ex) {
			System.out.println("ReviewGroup.java-reviewGroup(String) wrong!");
			ex.printStackTrace();
			return groupNames;
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
	
	//传入点击显示的专业组的编号，然后查询对应专业组的可被抽取的专家的人数
	public List<Expert> showExpertsOfChoosenGroup(String groupNo){
		List<Expert> expertOfGroup = new ArrayList<Expert>();
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "SELECT * FROM infolistview where Expert_Field1 in (select Expert_Field1 from expert_baseinfo where Expert_Field33 = " + groupNo +" and  (Expert_Field34 = 01 or Expert_Field34 = 02))";
		//System.out.println(sqlValue);
		//System.exit(0);
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				Expert tempExpert = null;
//				String id = rs.getString("Expert_id");
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
				tempExpert = new Expert(field1, field2, field3, field4, field5,
										field6, field7, field8, field9, field10,
										field11, field12, field13, field14, field15,
										field16, field17, field18, field19, field20,
										field21, field22, field23, field24, field25, 
										field26, field27, field28, field29, field30, 
										field31, field32, field33, field34, field35);
				expertOfGroup.add(tempExpert);
			}
			return expertOfGroup;
		} catch (Exception ex) {
			System.out.println("ReviewGroup.java-showExpertsOfChoosenGroup(String):void wrong!");
			ex.printStackTrace();
			return expertOfGroup;
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
//		List<String> temp = new ArrayList<String>();
//		temp.add("08005");
//		//temp.add("08009");
//		ReviewGroup test = new ReviewGroup();
//		test.juryNo = "0102";
//		test.showExpertsOfChoosenGroup(temp);
//		System.out.println(test.expertOfGroup);
//	}
	
	public Boolean randomFunction(String groupNo, int numberChoosen, List<Expert> leader, List<Expert> members){
		try{
			List<Expert> tempExperts = this.showExpertsOfChoosenGroup(groupNo);
			Random ra = new Random();
			int randomLeader = -1;
			int randomMember = -1;

			List<Expert> tempLeader = new ArrayList<Expert>();
			List<Expert> tempMember = new ArrayList<Expert>();

			//System.out.println(tempExperts.size());
			//遍历该专业组内专家
			for(int k=0; k<tempExperts.size(); k++){
				//如果拟任职务是组长，则将该专家从tempExperts中	加入tempLeader中
				System.out.println("ReviewGroup.java randomFunction()-> tempExperts.get(k).getExpert_Field34:" + grouptitleLeaderName);
				if(tempExperts.get(k).getExpert_Field34().equals(grouptitleLeaderName)){ 
					tempLeader.add(tempExperts.get(k));
				}
				//如果拟任职务是组员，则将该专家从tempExperts中加入tempMember中
				if(tempExperts.get(k).getExpert_Field34().equals(grouptitleMemeberName)){
					tempMember.add(tempExperts.get(k));
				}
			}
			//System.out.println(tempExperts.size());
//			System.out.println(tempLeader.size());
//			System.out.println(tempMember.size());
			if(tempLeader.size() == 0){
				HttpServletRequest request = (HttpServletRequest)
						ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
				request.setAttribute("Error", "NoLeaderToRandom");
				return false;
			}
			else if(tempMember.size() == 0){
				HttpServletRequest request = (HttpServletRequest)
						ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
				request.setAttribute("Error", "NoMemberToRandom");
				return false;
			} else {
				//抽取组长模块
				randomLeader = ra.nextInt(tempLeader.size()); //按照已有的个数随机生成一个组长
				//System.out.println(s);
				leader.add(tempLeader.get(randomLeader));//将该专家从tempLeader加入leaderOfGroup中
				tempLeader.remove(randomLeader);
				for(int h=0; h<tempLeader.size(); h++){	//把未选中组长的专家放到tempMember中
					tempMember.add(tempLeader.get(h));
					tempLeader.remove(h);
				}
			}
//			System.out.println("抽完组长后的membersize："+tempMember.size());
//			for(int i=0;i<tempMember.size();i++){
//				System.out.print(tempMember.get(i).getExpert_Field1()+" ");
//			}
//			System.out.println();
			
			//抽取组员模块
			for(int j=0; j<numberChoosen-1; j++){ //按照选择的人数遍历，每次随机抽取一个组员从tempMember中放入memberOfGroup
				randomMember = ra.nextInt(tempMember.size());
				members.add(tempMember.get(randomMember));
				tempMember.remove(randomMember);
			}
			//tempMember.clear();
			return true;
		}catch(Exception e){
			System.out.println("ReviewGroup.java-randomFunction(String,int,List<Expert>,List<Epxert>):Boolean wrong!");
			return false;
		}
	}
	
	public Boolean deleteHistoryTitles(String serveyear){
		//建立连接
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		String sqlValue = "delete from history_title where expert_serveyear='" + serveyear + "'";
//		sqlValue = sqlValue.substring(0, sqlValue.length()-3);
//		System.out.println(sqlValue);
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sqlValue);
			return true;
		} catch (Exception ex) {
			System.out.println("ReviewGroup.java-deleteHistoryTitles:Bool wrong!");
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
	
	public Boolean insertResult(List<Expert> leader, List<Expert> members, String serveYear){
		try{
			if((leader.size() != 0) && (members.size() != 0)){
				this.deleteHistoryTitles(serveYear);
				Jury objJury = new Jury();
				Group objGroup = new Group();
				Insert insert = new Insert();
				//组长name->code
				for(int i=0;i<leader.size();i++){  
					leader.get(i).setExpert_Field31(objJury.getJuryNoByJuryName(leader.get(i).getExpert_Field31()));
					leader.get(i).setExpert_Field33(objGroup.getGroupNoByGroupName(leader.get(i).getExpert_Field33()));
				}
				//组员name->code
				for(int i=0;i<members.size();i++){  
					members.get(i).setExpert_Field31(objJury.getJuryNoByJuryName(members.get(i).getExpert_Field31()));
					members.get(i).setExpert_Field33(objGroup.getGroupNoByGroupName(members.get(i).getExpert_Field33()));
				}
				insert.insertGroupLeaderHistoryTitle(serveYear, leader);
				insert.insertGroupMemberHistoryTitle(serveYear, members);
			}
			else{
				System.out.println("有一个值为空");
				HttpServletRequest request = (HttpServletRequest)
						ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
				request.setAttribute("Error", "NoExpertsToInsertResult");
				return false;
			}
			return true;
		}catch(Exception e){
			System.out.println("ReviewGroup.java-insertResult(List<Expert>,List<Expert>,String):Boolean wrong!");
			return false;
		}
	}
	
/*	public static void main(String args[]){
		ReviewGroup test = new ReviewGroup();
		List<Expert> leader = new ArrayList<Expert>();
		List<Expert> members = new ArrayList<Expert>();
		test.randomFunction("00007", 3, leader, members);
		System.out.println("leader:");
		for(int i=0;i<leader.size();i++){
			System.out.println(leader.get(i).getExpert_Field1());
		}
		System.out.println("members:");
		for(int i=0;i<members.size();i++){
			System.out.println(members.get(i).getExpert_Field1());
		}
		test.insertResult(leader, members, "2015");
	}*/
	
	//完整的测试参考此处
//	public static void main(String args[]){
//		ReviewGroup test = new ReviewGroup();
//		test.showReviewGroup("0102");
//		test.showExpertsOfChoosenGroup("08005");
//		test.randomFunction(test.expertOfGroup, 3);
//		System.out.println(test.leaderOfGroup.get(0).getExpert_Field1()+"next:");
//		for(int i=0;i<test.memberOfGroup.size();i++){
//			System.out.println(test.memberOfGroup.get(i).getExpert_Field1());
//		}
//	}
	

//当选择多个专业组时的随机，已舍弃，留作纪念
//	public void randomFunction(List<Expert> tempExperts){
//		List<Expert> tempLeader = new ArrayList<Expert>();
//		List<Expert> tempMember = new ArrayList<Expert>();
//		List<Expert> tempPartOfExperts = new ArrayList<Expert>();
//		
//		//1.首先按一个个专业组来抽取
//		for(int i=0; i<this.numberOfChoosenGroup; i++){
//			String tempGroupNumber = tempExperts.get(0).getExpert_Field33(); //每次都按第一个来抽
//			for(int j=0; j<tempExperts.size(); j++){ //遍历，然后把相同专业组的专家拿出来
//														//放进tempPartOfExperts中，并从tempExperts
//														//中删除
//				if(tempExperts.get(j).getExpert_Field33() == tempGroupNumber){
//					tempPartOfExperts.add(tempExperts.get(j));
//					tempExperts.remove(j);
//				}
//			}
//			//2.现在tempPartOfExperts里的专家都是同一个专业组的，先把拟任组长的放到tempLeader中
//			for(int k=0; k<tempPartOfExperts.size(); k++){
//				if(tempPartOfExperts.get(k).getExpert_Field34() == "01"){
//					tempLeader.add(tempPartOfExperts.get(k));
//					tempPartOfExperts.remove(k);
//				}
//				Random ra = new Random();
//				int s = ra.nextInt(tempLeader.size())+1; //按照已有的个数随机生成一个组长
//				//System.out.println(s);
//				this.leaderOfGroup.add(tempLeader.get(s));
//				tempLeader.remove(s);
//				for(int h=0; h<tempLeader.size(); h++){	//把未选中组长的专家放到tempMember中
//					tempMember.add(tempLeader.get(h));
//					tempLeader.remove(h);
//				}
//				for(int h=0; h<tempPartOfExperts.size(); h++){ //把partOfExperts中剩下的也放进tempMember中
//					tempMember.add(tempPartOfExperts.get(h));
//					tempPartOfExperts.remove(h);
//				}
//				
//			}		
//		}
//	}
	
//	public static void main(String args[]){
//		Random ra = new Random();
//		int s = ra.nextInt(3)+1;
//		System.out.println(s);
//	}
	
//	public static void main(String args[]){
//		ReviewGroup test = new ReviewGroup();
//		System.out.println(test.groupNames);
//		test.showReviewGroup("0102");
//		System.out.println(test.juryNo);
//		System.out.println(test.groupNames);
//		test.showReviewGroup("0101");
//		System.out.println(test.juryNo);
//	}
	
}
