package gpw.algorithm;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import gpw.algorithm.Committee;
import gpw.getInfo.GetExpert;
import gpw.object.Expert;

public class Test {
//	public static void main(String args[]){
//		List<Integer> test = new ArrayList<Integer>();
//		test.add(0);
//		test.add(1);
//		test.add(2);
//		Random rs = new Random();
//		try{
//			for(int i=0;i<4;i++){
//				test.remove(rs.nextInt(test.size()));
//			}
//		} catch(IllegalArgumentException e){
//			
//		}
//		
//		System.out.println(test.toString());
//				
//	}
//	public static void main(String args[]) throws ParseException{
//		Date now = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		long timeDistance = now.getTime() - sdf.parse("1995-08-11").getTime();
//		System.out.println(now.getTime());
//		System.out.println(timeDistance/(60*60*1000*24)/365);
//	}
	public static void main(String args[]) throws ParseException{
		Committee test = new Committee("0102", 1, 3, 2016);
		GetExpert obj = new GetExpert();
		
		List<Expert> expertsLastYear = obj.getExpertByJury("0102");
		//for(int i=)
		//System.out.println("test.checkRule2(expertsLastYear); " + test.checkRule2(expertsLastYear));
		
		/*test.selectLastYear();
		test.selectAllCandidates();
		test.mergeLists();
//		System.out.println(test.totalNumber);
//		System.out.println(test.rule4Number);
//		System.out.println(test.expertsLastYear);
//		System.out.println(test.expertsThisYear);
//		System.out.println(test.expertsToChoose.toString());
		test.extract();
		System.out.println(test.director);
		System.out.println(test.viceDirectors);
		System.out.println(test.committees);
		for(int i=0;i<expertsLastYear.size();i++){
			System.out.println("expertsLastYear: " + expertsLastYear.get(i).getExpert_Field2());
		}*/
	}
}
