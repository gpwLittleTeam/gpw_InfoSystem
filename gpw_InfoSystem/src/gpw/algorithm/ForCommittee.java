package gpw.algorithm;

import gpw.connection.LinkDB;
import gpw.object.CodeModel;
import gpw.object.Expert;
import gpw.object.Methods;
import gpw.object.RuleField;
import gpw.object.RuleManagement;
import gpw.operateDatabase.Insert;
import gpw.object.Jury;
import gpw.getInfo.GetCode;
import gpw.getInfo.GetExpert;
import gpw.getInfo.GetHistoryTitle;
import gpw.getInfo.GetRuleField;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;


/*
 * 使用方法：
 * 		1.实例化后传入高评委编号，想抽取的副主任委员数量和委员数量，年份
 */
public class ForCommittee {
	
	private Jury temp = new Jury();
	
	private String juryNo;	// 高评委编号
	private Random ra = new Random();
	private int VDNumber;	// 副主任委员数量
	private int CNumber;	// 委员数量
	private int totalNumber;	// 总数
	private int year;		// 年份
	private Expert director; // 主任
	private List<Expert> viceDirectors = new ArrayList<Expert>();	// 副主任
	private List<Expert> committees = new ArrayList<Expert>();	//委员
	private List<Expert> expertsToChoose = new ArrayList<Expert>();	// 用于抽取的经过筛选后的专家组
	private List<Expert> expertsLastYear = new ArrayList<Expert>();	// 上一年评委会成员
	private List<Expert> expertsThisYear = new ArrayList<Expert>();	// 今年的参与抽取的专家
	private List<Expert> results = new ArrayList<Expert>();			// 抽取结果
	
	private int rule4Number;	// 上一年执行评委随机保留二分之一，另二分之一随机抽取
	private int rule2Number;	// 正高级专家占四分之一以上
	private int rule3Number;	// 45周岁以下的专家占评委会的四分之一以上
	
	
	/*
	 * Step1: 首先查出各个最大数量，用于网页上异步检测用户输入的数量是否超出最大值
	 * Step2: 根据 rule4 查出所有想要参选的专家
	 * Step3: 循环根据 rule2，rule3 来筛选最后用于参选的专家
	 * Step4: 依次抽取主任，副主任，委员
	 * Step5: 显示结果
	 * Step6: 根据情况录入
	 */

	
	public ForCommittee(String juryNo, int VDNumber, int CNumber, int Year){
		this.juryNo = juryNo;
		this.VDNumber = VDNumber;
		this.CNumber = CNumber;
		this.year = Year;
		this.totalNumber = VDNumber + CNumber + 1;
		this.rule2Number = this.totalNumber / 4;
		this.rule3Number = this.totalNumber / 4;
		this.rule4Number = Math.round((float)this.totalNumber / 2);
		
	}
	public ForCommittee(){
		
	}
	
	/*******抽取规则********/
	//查询上一年执行评委，若没有则空
	// 输入格式为，高评委编号和年份，输出为根据编号和前一年得到的评委会
	public List<Expert> selectLastYear(){
		LinkDB link = new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		//SQL语句需要更改以下，from infolistview
		String sqlValue = "select * from expert_baseinfo where Expert_Field1 in "
				+ "(select expert_no from history_title where expert_jury='"+juryNo+"' and"
				+ " expert_serveyear='"+(this.year - 1)+"')";
		try{
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while(rs.next()){
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
				expertsLastYear.add(tempExpert);
			}
			return expertsLastYear;
		} catch (Exception ex) {
				System.out.println("Committee.java-selectLastYear(String):List<Expert> wrong!");
				ex.printStackTrace();
				return expertsLastYear;
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
	
	//查询所有今年准备参与抽取委员会的专家
	public List<Expert> selectAllCandidates(){
		
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		//SQL语句需要更改以下，from infolistview
		String sqlValue = "select * from expert_baseinfo where Expert_Field31='"+juryNo+"' and("
				+ "Expert_Field32='01' or Expert_Field32='02' or Expert_Field32='03')";
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
				expertsThisYear.add(tempExpert);
			}
			return expertsThisYear;
		} catch (Exception ex) {
			System.out.println("Committee.java-selectAllCandidates(String):List<Expert> wrong!");
			ex.printStackTrace();
			return expertsThisYear;
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
	
	//从去年的专家组中抽今年所需的一半的人数
	//从今年的专家组中抽剩余的人数
	//判断是否符合规则
/*	public void mergeLists() throws ParseException{
		
		try{
			// 根据抽取数的一半来随机循环加入待抽组
			for(int i=0; i<expertsLastYear.size(); i++){
				int randomIndex = ra.nextInt(expertsLastYear.size());
				expertsToChoose.add(expertsLastYear.get(randomIndex));
			}
		} catch(IllegalArgumentException e){
			// 如果去年的人数未到抽取数的一半则把去年的全部加入，这个括号里不需要做什么事
		}
		
		// 然后根据 rule2 和 rule3 来从今年想要参与的随机选择另外一半组成最后用来抽取的专家组
		List<Expert> tempChecked = new ArrayList<Expert>();
		int times = 0;
		do{
			for(int i=0; i<(totalNumber-expertsToChoose.size()); i++){
				tempChecked.add(expertsThisYear.get(ra.nextInt(expertsThisYear.size())));
			}
			times++;
		} while ((check1Director(tempChecked) && checkViceDirector(tempChecked))||
				(checkRule2(tempChecked,juryNo) && checkRule3(tempChecked,juryNo)) 
				|| (times == 100));
		
		//System.out.println(tempChecked.size());
		for(int i=0; i<tempChecked.size(); i++){
			expertsToChoose.add(tempChecked.get(i));
		}
	}*/
	
	public void extract(){
		List<Integer> directorIndexs = new ArrayList<Integer>();
		List<Integer> viceDirectorIndexs = new ArrayList<Integer>();
		List<Integer> committeeIndexs = new ArrayList<Integer>();
		
		System.out.println("361:" + this.expertsToChoose.size());  
		// 遍历整这个List,在里面找是否有参选主任的，将下标储存，如果存在的话就然后随机抽取一个后放入 results 中，然后在 expertsToChoose 里将对应位置置空
		for(int i=0; i<this.expertsToChoose.size(); i++){
			System.out.println("364:"+ expertsToChoose.get(i).getExpert_Field32());
			if(expertsToChoose.get(i).getExpert_Field32().equals("主任委员")){
				directorIndexs.add(i);
			}
		}
		System.out.println("369:" + directorIndexs.toString());
		if(directorIndexs.size() != 0){
			int indexOfDirector = directorIndexs.get(ra.nextInt(directorIndexs.size()));
			this.director = expertsToChoose.get(indexOfDirector);
			expertsToChoose.set(indexOfDirector, null);
		}
		
		
		// 副主任
		for(int i=0; i<this.expertsToChoose.size(); i++){
			if(expertsToChoose.get(i) != null){
				if(expertsToChoose.get(i).getExpert_Field32().equals("副主任委员")){
					viceDirectorIndexs.add(i);
				}
			}
		}
		if(viceDirectorIndexs.size() >= this.VDNumber){
			for(int i=0; i<this.VDNumber; i++){
				int indexOfViceDirector = viceDirectorIndexs.get(ra.nextInt(viceDirectorIndexs.size()));
				this.viceDirectors.add(expertsToChoose.get(indexOfViceDirector));
				expertsToChoose.set(indexOfViceDirector, null);
			}
		} else if(viceDirectorIndexs.size() < this.VDNumber && viceDirectorIndexs.size() > 0){
			for(int i=0; i<viceDirectorIndexs.size(); i++){
				int indexOfViceDirector = viceDirectorIndexs.get(ra.nextInt(viceDirectorIndexs.size()));
				this.viceDirectors.add(expertsToChoose.get(indexOfViceDirector));
				expertsToChoose.set(indexOfViceDirector, null);
			}
		}
		
		// 委员
		for(int i=0; i<this.expertsToChoose.size(); i++){
			if(expertsToChoose.get(i) != null){
				if(expertsToChoose.get(i).getExpert_Field32().equals("委员")){
					committeeIndexs.add(i);
				}
			}
			
		}
		if(committeeIndexs.size() >= this.VDNumber){
			for(int i=0; i<this.VDNumber; i++){
				int indexOfCommittee = committeeIndexs.get(ra.nextInt(committeeIndexs.size()));
				this.committees.add(expertsToChoose.get(indexOfCommittee));
				expertsToChoose.set(indexOfCommittee, null);
			}
		} else if(committeeIndexs.size() < this.VDNumber && committeeIndexs.size() > 0){
			for(int i=0; i<committeeIndexs.size(); i++){
				int indexOfCommittee = committeeIndexs.get(ra.nextInt(committeeIndexs.size()));
				this.committees.add(expertsToChoose.get(indexOfCommittee));
				expertsToChoose.set(indexOfCommittee, null);
			}
		}
		
		// 补充
		System.out.println("423:" + this.director);
		System.out.println("424:" + this.viceDirectors);
		System.out.println("425" + this.committees);
		System.out.println("426:" + this.expertsToChoose);
		if(this.director == null){
			for(int i=0; i<expertsToChoose.size(); i++){
				if(expertsToChoose.get(i) != null){
					this.director = expertsToChoose.get(i);
					expertsToChoose.set(i, null);
				}
			}
		}
		//System.out.println(this.viceDirectors);
		if(this.viceDirectors.size() != this.VDNumber){
			for(int i=0; i<(this.VDNumber-this.viceDirectors.size()); i++){
				if(expertsToChoose.get(i) != null){
					this.viceDirectors.add(expertsToChoose.get(i));
					expertsToChoose.set(i, null);
				}
			}
		}
		System.out.println("386:" + this.committees.size());
		System.out.println("387:" + this.expertsToChoose.size());
		if(this.committees.size() != this.CNumber){
			//System.out.println("389:" + this.CNumber);
			//System.out.println("390:" + (this.CNumber-this.committees.size()));
			for(int i=0; i<expertsToChoose.size(); i++){
				if(expertsToChoose.get(i) != null){
					this.committees.add(expertsToChoose.get(i));
					expertsToChoose.set(i, null);
				}
//				System.out.println("2");
			}
		}
	}
	
	/**
	 * [旧]用于检查是否满足 rule2——正高级专家占四分之一以上
	 * @param listToCheck
	 * @param juryNo
	 * @return
	 */
	private Boolean checkRule2(List<Expert> listToCheck, String juryNo){
		String jury_power = new Jury().getJuryPowerByJuryNo(juryNo);
		if(!jury_power.equals("2")){//说明是正高级或者正副合一
			int numberOfZG = 0; // 正高级计数
			for(int i=0; i<listToCheck.size(); i++){
				if(listToCheck.get(i).getExpert_Field18().equals("正高级")){
					//System.out.println(listToCheck.get(i).getExpert_Field2());
					numberOfZG++;
				}
			}
			System.out.println("总人数：" + listToCheck.size());
			System.out.println("正高级专家数: " + numberOfZG);
			
			if((numberOfZG*4) >= (listToCheck.size())){
				return true;
			} else {
				return false;
			}
		}
		//System.out.println("jury_power.equals('2')");
		return true;
	}
	
	/**
	 * [旧]用于检查是否满足 rule3
	 * @param listToCheck
	 * @param juryNo
	 * @return
	 * @throws ParseException
	 */
	private Boolean checkRule3(List<Expert> listToCheck,String juryNo) throws ParseException{
		int numberOfAge45 = 0; // 45岁以下数量
		long timeDistance;  //年龄（s）
		int age;  //年龄
		for(int i=0; i<listToCheck.size(); i++){
			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			timeDistance = now.getTime() - sdf.parse(listToCheck.get(i).getExpert_Field5()).getTime();  //年龄(s)=现在时间-出生年月
			age = (int)(timeDistance/(60*60*1000*24)/365);
			if(age < 45){
				//System.out.println(listToCheck.get(i).getExpert_Field2() + " 年龄： " + age);
				numberOfAge45++;
			}
		}
		//System.out.println("45岁以下人数: " + numberOfAge45);
		//具有正副高级合一及正高级评审权限的委员会，45周岁以下的专家占评委会的四分之一以上
		String jury_power = new Jury().getJuryPowerByJuryNo(juryNo);
	//	System.out.println("这个高评委的评审权限为： " + jury_power); //1=正高级评审权限
		if(numberOfAge45*3 >= listToCheck.size()){
			return true; //如果大于1/3以上的话，不管是正高级还是副高级都是满足要求的
		} else {
			if(jury_power.equals("2")) {
				return false; //是副高级 不满足要求
			} else {  //说明是正高级或者正副合一
				if(numberOfAge45*4 >= listToCheck.size()){
					return true;
				} else{
					return false;
				}
			}
		}
	}
	
	/**
	 * 禁止使用
	 */
	private void checkRule4() {
		/*
		 * 1. 得到去年的评委
		 * 2. 根据之前抽取主任委员和副主任委员的结果，从去年的评委List中删除对应专家  //showCommittee
		 * 3. 从剩下的去年的评委中再抽取n人以满足“去年评委随机保留二分之一”
		 * 4. 再把剩下的去年的评委加入得到几年的委员候选人中，进行抽取
		 */
	}
	
	/**
	 * 调用该函数来判断是否满足规则,根据返回值判断结果
	 * @param listToCheck 抽取的专家结果
	 * @param rules 需要满足的规则集合
	 * @return 返回规则结果
	 * 			0：满足规则
	 * 			1：不符合规则1
	 * 			2：不符合规则2
	 * 			以此类推……
	 * @throws ParseException
	 */
	public String check(List<Expert> listToCheck, List<RuleManagement> rules) throws ParseException {
		String juryNo = new Methods().getCurrentUser().getUser_jury();
		String result = "0";
		/*[旧]*/
		if(!checkRule2(listToCheck,juryNo)){
			result = "2";
			return result;
		} else if(!checkRule3(listToCheck,juryNo)){
			result = "3";
			return result;
		}
		for(int i=0;i<rules.size();i++){
			if(!checkWithOneRule(listToCheck,rules.get(i))){
				result = rules.get(i).getRule_no();
				System.err.println("algorithm.ForCommittee.check(List<Expert>, List<RuleManagement>)不符合规则：" + result);
				break;
			}
		}
		return result;
	}
	
	
	/**
	 * 检测抽取结果是否满足规则
	 * @param listToCheck 被检测的抽取结果
	 * @param rule
	 * @return 满足规则返回true;不满足规则返回false;
	 * @throws ParseException 
	 */
	/* 1. 通过field判断类型
	 * 2. 数List中 符合rulemanagement里的value的个数
	 */
	private Boolean checkWithOneRule(List<Expert> listToCheck,RuleManagement rule) throws ParseException{
		float counter = 0f; 
		GetRuleField objGetRuleField = new  GetRuleField();
		RuleField objRuleField = objGetRuleField.getRuleFieldByFieldName(rule.getRule_field());
		if(objRuleField.getField_type().equals("1")){
			for(int i=0;i<listToCheck.size();i++){
				String value = listToCheck.get(i).getExpertInfoByFieldId(rule.getRule_field()); //需要去判断的值
				//防止报错
				if(value == null){
					value = "";
				}
				//判断是否符合（等于）规则
				if(value.equals(rule.getRule_value())){
					counter += 1; //float
				}
			}
		} else if(objRuleField.getField_type().equals("3")){
			for(int i=0;i<listToCheck.size();i++){
				String value = listToCheck.get(i).getExpertInfoByFieldId(rule.getRule_field()); //需要去判断的值
				//防止报错
				if(value != null && !value.equals("")){
					//都是年份，需要换算
					//System.out.println("No:" + listToCheck.get(i).getExpert_Field1() + "  String日期:" + value);
					Date date = new SimpleDateFormat("yyyy-MM-dd").parse(value);
					long timeDifference =  System.currentTimeMillis() - date.getTime();
					long years = timeDifference / (1000L * 60L * 60L * 24L * 365L);
					//System.out.println("years:" + years);
					int ruleValue = Integer.parseInt(rule.getRule_value());
					//判断是否满足条件
					if(rule.getRule_relation().equals("==")){
						if(years == ruleValue){
							counter += 1f;
						} 
					} else if(rule.getRule_relation().equals(">=")){
						if(years >= ruleValue){
							counter += 1f;
						} 
					} else if(rule.getRule_relation().equals("<=")){
						if(years <= ruleValue){
							counter += 1f;
						} 
					}
				}
			}
		}
		//判断是否满足百分比
		if(checkForPercent(counter, listToCheck.size(), rule.getRule_percentRelation(), Float.parseFloat(rule.getRule_percent()))){
			return true;
		} else{
			return false;
		}
	}
	
	/**
	 * 
	 * @param counter  满足条件的人数
	 * @param total 参与抽取的专家的总人数
	 * @param percentRelation 数据库规则的占比符号
	 * @param rulePercent 规则的值，无需处理
	 * @return
	 */
	private Boolean checkForPercent(float counter, int total,String percentRelation, float rulePercent){
		float realPercent = counter / total;
		rulePercent = rulePercent / 100f;
		System.err.println("realPercent:" + realPercent + " 需要 " + percentRelation + "  rulePercent:" + rulePercent);
		if(percentRelation.equals("==")){
			if(realPercent == rulePercent){
				return true;
			} else {
				return false;
			}
		} else if(percentRelation.equals(">=")){
			if(realPercent >= rulePercent){
				return true;
			} else {
				return false;
			}
		} else if(percentRelation.equals("<=")){
			if(realPercent <= rulePercent){
				return true;
			} else {
				return false;
			}
		} else {
			System.out.println("algorithm.ForCommittee.checkForPercent(float, int, String) 符号错误");
			return false;
		}
	}
	
	
	/*****抽取规则结束*******/
	
	
	//查询最大副主任委员的个数
	public int selectMaxViceDirectorNumber(String juryNo){
			String juryName = temp.getJuryNameByJuryNo(juryNo);
			int maxViceDirectorNumber = -1;
			LinkDB link =  new LinkDB();
			Connection conn = link.getConn();
			Statement stmt = null;
			ResultSet rs = null;
			String sqlValue = "select count(*) maxnumber from infolistview where expert_field31='"+juryName+"'"
					+ " and (expert_field32='副主任委员' or expert_field32='主任委员')";
			try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sqlValue);
				while (rs.next()) {
					maxViceDirectorNumber += rs.getInt("maxnumber"); //查询出参选主任委员和副主任委员的人的个数，
					//由于主任委员只有一个,所以副主任委员的最大个数即为两个加起来-1												
				}
				return maxViceDirectorNumber;
			} catch (Exception ex) {
				System.out.println("Committee.java-selectMaxViceDirectorNumber(String):int wrong!");
				ex.printStackTrace();
				return maxViceDirectorNumber;
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
	
	//查询最大委员的个数
	public int selectMaxCommitteeNumber(String juryNo, int viceDirectorNumber){
		String juryName = temp.getJuryNameByJuryNo(juryNo);
		int maxViceDirectorNumber = -1;
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select count(*) maxnumber from infolistview where expert_field31='"+juryName+"'" + " and (expert_field32='副主任委员' or expert_field32='主任委员' or expert_field32='委员')";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlValue);
			while (rs.next()) {
				maxViceDirectorNumber = rs.getInt("maxnumber")-1-viceDirectorNumber;
			}
			return maxViceDirectorNumber;
		} catch (Exception ex) {
			System.out.println("Committee.java-selectMaxViceDirectorNumber(String):int wrong!");
			ex.printStackTrace();
			return maxViceDirectorNumber;
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
	
	//listToCheck中是否有主任委员
	private Boolean check1Director(List<Expert> listToCheck){
			Boolean result = false;
			for(int i=0; i<listToCheck.size(); i++){
				if(listToCheck.get(i).getExpert_Field32() == "主任委员"){
					result = true;
					break;
				}
			}
			return result;
		}
		
		//listToCheck中副主任委员的数量是否大于等于VDNumber
	private Boolean checkViceDirector(List<Expert> listToCheck){
			Boolean result = false;
			int number = 0;
			for(int i=0; i<listToCheck.size(); i++){
				if(listToCheck.get(i).getExpert_Field32() == "副主任委员"){
					number++;
					if(number == this.VDNumber){
						result = true;
						break;
					}
				}
			}
			return result;
		}
	//两个最大数的使用看这里
/*	public static void main(String args[]){
		Committee test = new Committee();
		int temp = test.selectMaxViceDirectorNumber("0101");
		System.out.println(temp);
		System.out.println(test.selectMaxCommitteeNumber("0101", temp));
		
	}*/
	
	
	
	//根据juryNo查询所有候选主任
	public List<Expert> showDirectors(String juryNo){
		String juryName = temp.getJuryNameByJuryNo(juryNo);
		List<Expert> expertsToBeDirectors = new ArrayList<Expert>();
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from infolistview where Expert_Field31='"+juryName+"' and"
				+ " Expert_Field32='主任委员'";
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
				expertsToBeDirectors.add(tempExpert);
			}
			return expertsToBeDirectors;
		} catch (Exception ex) {
			System.out.println("Committee.java-showDirectors(String):List<Expert> wrong!");
			ex.printStackTrace();
			return expertsToBeDirectors;
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
	
	//抽取主任，此接口调用上面的showDirectors,返回抽取出来的director以及未抽中的专家留到下一步中
	/**
	 * 抽取主任委员的算法
	 * @param juryNo 当前高评委的编号
	 * @param director 传入一个空的List,将抽到的主任委员放在该List中
	 * @return 返回未被抽取的专家List
	 */
	public List<Expert> extractDirector(String juryNo, List<Expert> director){
		List<Expert> expertsToExtract = this.showDirectors(juryNo);   //主任委员候选人
		try{
			if(expertsToExtract.size() != 0){   //是否有拟任主任委员
				Random ra = new Random();
				int randomDirector = ra.nextInt(expertsToExtract.size());
				director.add(expertsToExtract.get(randomDirector));
				expertsToExtract.remove(randomDirector);
			}
			else{  
				HttpServletRequest request = (HttpServletRequest)
						ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
				request.setAttribute("Error", "NoExpertsToExtractDirector");
				return expertsToExtract;
			}
			return expertsToExtract;
		}catch(Exception e){
			System.out.println("Committee.java-extractDirector(List<Expert>,Lit<Expert>):Boolean wrong!");
			return expertsToExtract;
		}
	}

	//根据juryNo查询所有候选副主任，并与传入的上面未抽中的专家合并为候选副主任
	public List<Expert> showViceDirectors(String juryNo, List<Expert> expertsAfterExtractingDirector){
		String juryName = temp.getJuryNameByJuryNo(juryNo);
		List<Expert> expertsToBeViceDirectors = new ArrayList<Expert>();
		for(int i=0;i<expertsAfterExtractingDirector.size();i++){
			expertsToBeViceDirectors.add(expertsAfterExtractingDirector.get(i));
		}
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from infolistview where Expert_Field31='"+juryName+"' and"
				+ " Expert_Field32='副主任委员'";
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
				expertsToBeViceDirectors.add(tempExpert);
			}
			return expertsToBeViceDirectors;
		} catch (Exception ex) {
			System.out.println("Committee.java-showViceDirectors(String,List<Expert>):List<Expert> wrong!");
			ex.printStackTrace();
			return expertsToBeViceDirectors;
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
	
	//抽取副主任，此接口调用上面的showViceDirectors，返回抽取出来的viceDirector以及未抽中的专家留到下一步中
	//number 抽取的人数， expertsAfterExtractingDirector 抽完剩余的人
	/**
	 * 抽取副主任委员
	 * @param juryNo  用户所在的高评委juryNo
	 * @param expertsAfterExtractingDirector  在抽取主任委员的环节中没有被抽中的人
	 * @param viceDirector  抽中的专家
	 * @param number  抽取的数目
	 * @return 剩余没有被抽中为副主任委员的人
	 */
	public List<Expert> extractViceDirector(String juryNo, List<Expert> expertsAfterExtractingDirector, List<Expert> viceDirector, int number){
		List<Expert> expertsToExtract = this.showViceDirectors(juryNo, expertsAfterExtractingDirector);
		try{		
			if(expertsToExtract.size() >= number){
				//抽取 同时抽取
				/*Random ra = new Random();
				for(int i=0;i<number;i++){
					int randomDirector = ra.nextInt(expertsToExtract.size());
					viceDirector.add(expertsToExtract.get(randomDirector));
					expertsToExtract.remove(randomDirector);
				}*/
				Random_custom obj = new Random_custom();
				int[] directorNo = obj.randomsNoRepeat(0, expertsToExtract.size()-1, number);
				//抽取 一个个抽
				for(int i=0;i<number;i++){
					//System.out.println(expertsToExtract.get(directorNo[i]-i).getExpert_Field2());
					viceDirector.add(expertsToExtract.get(directorNo[i]-i));  //每次减掉一个之后，i之后的专家会往前移一位 
					expertsToExtract.remove(directorNo[i]-i);
				}
			}
			else{
				System.out.println("抽取数量大于被抽取的人数");
				HttpServletRequest request = (HttpServletRequest)
						ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
				request.setAttribute("Error", "NoExpertsToExtractViceDirector");
				return expertsToExtract;
			}
			return expertsToExtract;
		}catch(Exception e){
			System.out.println("Committee.java-extractDirector(List<Expert>,Lit<Expert>,int):Boolean wrong!");
			return expertsToExtract;
		}
	}
	
	/**
	 * [新]显示所有委员抽取候选人的函数，委员候选人 = 拟任委员的候选人+未被抽取为副主任委员的候选人
	 * @param juryNo
	 * @param expertsAfterExtractingViceDirector 未被抽取为副主任委员的候选人
	 * @return
	 */
	/*[新]*/
	/*
	public List<Expert> showCommittee(String juryNo, List<Expert> expertsAfterExtractingViceDirector){
		String juryName = temp.getJuryNameByJuryNo(juryNo);
		List<Expert> expertsToBeCommittee = new ArrayList<Expert>(); //委员抽取候选人 = 拟任委员的候选人+未被抽取为副主任委员的候选人
		
		expertsToBeCommittee.addAll(expertsAfterExtractingViceDirector);
		链接数据库获取拟任委员的候选人
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from infolistview where Expert_Field31='"+juryName+"' and"
				+ " Expert_Field32='委员'";
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
				expertsToBeCommittee.add(tempExpert);
			}
			获取拟任委员的候选人，并整合进expertsToBeCommittee end
			return expertsToBeCommittee;
		} catch (Exception ex) {
			System.out.println("Committee.java-showCommittee(String,List<Expert>):List<Expert> wrong!");
			ex.printStackTrace();
			return expertsToBeCommittee;
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
	}*/
	
	/**
	 * [旧]根据juryNo查询所有候选委员，并与传入的上面未抽中的专家合并为候选委员，并且还加上去年的委员
	 * 
	 * @param juryNo
	 * @param expertsAfterExtractingViceDirector
	 * @param thisYear
	 * @return
	 */
	
	public List<Expert> showCommittee(String juryNo, List<Expert> expertsAfterExtractingViceDirector, int thisYear){
		String juryName = temp.getJuryNameByJuryNo(juryNo);
		List<Expert> expertsToBeCommittee = new ArrayList<Expert>();
		
		expertsToBeCommittee.addAll(expertsAfterExtractingViceDirector);
		
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue = "select * from infolistview where Expert_Field31='"+juryName+"' and"
				+ " Expert_Field32='委员'";
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
				expertsToBeCommittee.add(tempExpert);
			}
			
			//algorithm for rule4
			Methods objMethods = new Methods();
			int selectedCount = 0; //计数 主任委员和副主任委员中有几个是去年的专家
			List<Expert> selected = new ArrayList<Expert>();
			selected.addAll((List<Expert>)objMethods.getSession("listDirector"));
			selected.addAll((List<Expert>)objMethods.getSession("listViceDirector"));  //在主任委员和副主任委员中已经被选出来的;
			List<Expert> remainderOfLastYearExperts = lastYearCommittees(thisYear, juryNo);
			int lastYearCommitteesSize = remainderOfLastYearExperts.size();
			objMethods.setSession("lastYearCommitteesSize", lastYearCommitteesSize);
			for(int i=0;i<remainderOfLastYearExperts.size();i++){  
				for(int j=0;j<selected.size();j++){
					if(remainderOfLastYearExperts.get(i).getExpert_Field1().equals(selected.get(j).getExpert_Field1())){
						remainderOfLastYearExperts.remove(i);
						i--;
						selectedCount++;
						break;
					}
				}
			}
			//把上一年且没有被选中是主任委员和副主任委员的专家加入到候选人中,并且去重
			for(int i=0;i<remainderOfLastYearExperts.size();i++){
				for(int j=0;j<expertsToBeCommittee.size();j++){
					if(remainderOfLastYearExperts.get(i).getExpert_Field1().equals(expertsToBeCommittee.get(j).getExpert_Field1())){
						expertsToBeCommittee.remove(j);
						break;
					}
				}
			}
			expertsToBeCommittee.addAll(remainderOfLastYearExperts);
			objMethods.setSession("selectedCount", selectedCount);
			objMethods.setSession("remainderOfLastYearExperts", remainderOfLastYearExperts); 
			return expertsToBeCommittee;
		} catch (Exception ex) {
			System.out.println("Committee.java-showCommittee(String,List<Expert>):List<Expert> wrong!");
			ex.printStackTrace();
			return expertsToBeCommittee;
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
	
	
	//返回去年参与的委员
	private List<Expert> lastYearCommittees(int thisYear, String juryNo) {
		List<Expert> experts = new ArrayList<Expert>();
		
		LinkDB link =  new LinkDB();
		Connection conn = link.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlValue =  
				 "select * from infolistview where Expert_Field1 in " + 
				 "(select expert_no from history_title where expert_jury = '" + juryNo + "' and expert_serveyear = '"+ (thisYear - 1) +"')";
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
				experts.add(tempExpert);
			}
			System.out.println("Committee.java lastYearCommittees.size() : "+ experts.size()  );
			return experts;
		}
		catch (Exception ex) {
			System.out.println("Committee.lastYearCommittees() wrong!");
			ex.printStackTrace();
			return experts;
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
	
	/* 1. 先从去年的专家里抽，至满足去年人数的二分之一
	 * 2. 剩下的名额从所有委员候选人中抽（不要重复）
	 */
	/**
	 * [旧]抽取委员，从session中得到委员候选人，先从去年的专家里抽，至满足去年人数的二分之一 （如果是奇数，则不足1/2）//因为是抽取的最后一步，所以没有必要有返回值
	 * @param juryNo
	 * @param committee 返回抽取出来的committee
	 * @param number
	 */
	public void extractCommittee(String juryNo, List<Expert> committee, int number){
		Methods objMethods = new Methods();
		List<Expert> expertsToExtract = (List<Expert>)objMethods.getSession("candidateCommittee");//来自gpw.action.jump.To_Pwcq_wyh.fourthPage() //包含去年的专家
		List<Expert> remainderOfLastYearExperts = (List<Expert>)objMethods.getSession("remainderOfLastYearExperts");
		int selectedCount = (int)objMethods.getSession("selectedCount");
		int lastYearCommitteesSize = (int)objMethods.getSession("lastYearCommitteesSize");
		int NoToExtractFromLastYear = (lastYearCommitteesSize/2 - selectedCount); //还要从去年的委员中抽多少人 
		if(NoToExtractFromLastYear > number) {  //考虑到如果去年抽的人很多，今年的抽的人不到去年的一半，则全部都是去年的人
			NoToExtractFromLastYear = number;
		}
		try{
			if(expertsToExtract.size() >= number){			
				Random_custom obj = new Random_custom();
				// 先从去年的专家里抽，至满足去年人数的二分之一
				int[] committeesNoFromLastYear = obj.randomsNoRepeat(0, remainderOfLastYearExperts.size()-1, NoToExtractFromLastYear);
				
				for(int i=0;i<NoToExtractFromLastYear;i++){
					committee.add(remainderOfLastYearExperts.get(committeesNoFromLastYear[i]));
					for(int j=0;j<expertsToExtract.size();j++) {//防止重复，从等一下要抽取的候选人中删除
						if(committee.get(i).getExpert_Field1().equals(expertsToExtract.get(j).getExpert_Field1())){
							expertsToExtract.remove(j);
							break;
						}
					}
				}
				
				number = number - NoToExtractFromLastYear; //抽完去年的人之后，从全部的人里面还要抽几个人
				int[] committeesRandNo = obj.randomsNoRepeat(0, expertsToExtract.size()-1, number);  //一次随机出number个数字
				//把选中的专家添加到变量committee中，并判断是否符合要求
				for(int i=0;i<number;i++){
					committee.add(expertsToExtract.get(committeesRandNo[i]));  
				}
			}
			else{
				System.out.println("抽取数量大于被抽取的人数");
				HttpServletRequest request = (HttpServletRequest)
						ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
				request.setAttribute("Error", "NoExpertsToExtractCommittee");
			}
		}catch(Exception e){
			System.out.println("Committee.java-extractCommittee(List<Expert>,Lit<Expert>,int):Boolean wrong!");
			e.printStackTrace();
		}
	}
	
	//根据id录入historytitle
	public Boolean insertResult(List<String> directorId, List<String> viceDirectorId, List<String> committeeId, String serveYear){
		try{
			if((directorId.size() != 0) && (viceDirectorId.size() != 0) && (committeeId.size() != 0)){
				this.deleteHistoryTitles(serveYear);
				Insert insert = new Insert();
				GetExpert getExpert = new GetExpert();
				
				List<Expert> director = new ArrayList<Expert>();
				List<Expert> viceDirector = new ArrayList<Expert>();
				List<Expert> committee = new ArrayList<Expert>();
				
				for(int i=0; i<directorId.size(); i++){
					director.add(getExpert.getExpertByNumber(directorId.get(i)));
				}
				insert.insertDirectorHistoryTitle(serveYear, director);
				
				for(int i=0; i<viceDirectorId.size(); i++){
					viceDirector.add(getExpert.getExpertByNumber(viceDirectorId.get(i)));
				}
				insert.insertViceDirectorHistoryTitle(serveYear, viceDirector);
				
				for(int i=0; i<committeeId.size(); i++){
					committee.add(getExpert.getExpertByNumber(committeeId.get(i)));
				}
				insert.insertCommitteeHistoryTitle(serveYear, committee);
				
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
			System.out.println("Committee.java-insertResult(List<Expert>,Lit<Expert>,List<Expert>,String):Boolean wrong!");
			return false;
		}
	}
	/**
	 * [新]抽取委员， 返回抽中的委员
	 * @param juryNo  用户所在高评委的编号
	 * @param number 抽取的数目
	 * @return 抽中的委员
	 */
/*	public List<Expert> extractCommittee(String juryNo, int number) {
		Methods objMethods = new Methods();
		List<Expert> expertsToExtract = (List<Expert>)objMethods.getSession("candidateCommittee");//来自gpw.action.jump.To_Pwcq_wyh.fourthPage()
		List<Expert> committeeMemeber = new ArrayList<Expert>(); //用于储存抽取到的委员
		try{		
			if(expertsToExtract.size() >= number){
				//抽取 同时抽取
				Random ra = new Random();
				for(int i=0;i<number;i++){
					int randomDirector = ra.nextInt(expertsToExtract.size());
					viceDirector.add(expertsToExtract.get(randomDirector));
					expertsToExtract.remove(randomDirector);
				}
				Random_custom obj = new Random_custom();
				int[] randomNo = obj.randomsNoRepeat(0, expertsToExtract.size()-1, number);
				//System.out.println("randomNo 是有序的吗：" + randomNo);
				//抽取 一个个抽
				for(int i=0;i<number;i++){
					committeeMemeber.add(expertsToExtract.get(randomNo[i])); 
				}
			}
			else{
				System.out.println("抽取数量大于被抽取的人数");
				HttpServletRequest request = (HttpServletRequest)
						ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
				request.setAttribute("Error", "NoExpertsToExtractCommittee");
				return committeeMemeber;
			}
			return committeeMemeber;
		}catch(Exception e){
			System.out.println("Committee.java-extractDirector(List<Expert>,Lit<Expert>,int):Boolean wrong!");
			return committeeMemeber;
		}
	}
*/

	
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
			System.out.println("Committee.java-deleteHistoryTitles:Boolean wrong!");
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

	
	
		
//	public static void main(String args[]){
//		List<Expert> experts = new ArrayList<Expert>();
//		List<Expert> director = new ArrayList<Expert>();
//		List<Expert> viceDirector = new ArrayList<Expert>();
//		List<Expert> committee = new ArrayList<Expert>();
//		Committee test = new Committee();
//		
//		//首先查询出所有候选人（主任，副主任，委员）
//		//experts = test.selectAllCandidates("0101");
//		
//		//抽取主任
//		//experts = test.showDirectors("0101");
//		experts = test.extractDirector("0101", director);
//		System.out.println("Director:"+director.get(0).getExpert_Field2());
//		//抽取完后从候选人中删除
////		for(Expert p : director){
////			experts.remove(p);
////		}
//		
//		//抽取副主任
//		//experts = test.showViceDirectors("0101", experts);
//		experts = test.extractViceDirector("0101",experts,viceDirector,2);
//		for(int i=0;i<viceDirector.size();i++){
//			System.out.println("ViceDirector:"+viceDirector.get(i).getExpert_Field2());
//		}
//		//抽取完后从候选人中删除
////		for(Expert p : viceDirector){
////			experts.remove(p);	
////		}
//		
//		//抽取委员
//		//experts = test.showCommittee("0101", experts);
//		experts = test.extractCommittee("0101",experts, committee, 2);
//		for(int i=0;i<committee.size();i++){
//			System.out.println("Committee:"+committee.get(i).getExpert_Field2());
//		}
//		//抽取完后从候选人中删除
////		for(Expert p : committee){
////			experts.remove(p);
////		}
//		
//		//录入至history_title
//		//首先收集抽取到的所有Id
//		List<String> directorId = new ArrayList<String>();
//		for(Expert p : director){
//			directorId.add(p.getExpert_Field1());
//		}
//		System.out.println(directorId);
//		
//		List<String> viceDirectorId = new ArrayList<String>();
//		for(Expert p : viceDirector){
//			viceDirectorId.add(p.getExpert_Field1());
//		}
//		System.out.println(viceDirectorId);
//		
//		List<String> committeeId = new ArrayList<String>();
//		for(Expert p : committee){
//			committeeId.add(p.getExpert_Field1());
//		}
//		System.out.println(committeeId);
//		
//		test.insertResult(directorId, viceDirectorId, committeeId, "2011");
//	}
	
}
