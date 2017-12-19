package gpw.algorithm;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AuthCode {
	Random_custom objRandom = new Random_custom();
	
	/**
	 * @return 6位数的随机验证码
	 */
	public String getRandAuthCode() {
		int randNo = objRandom.random(100000, 999999);
		return randNo+"";
	}
	
	/**
	 * 以现在时间为基础，产生一个7天之后的时间，精确到秒
	 * @return 
	 */
	public String getValidDate() {
		int time = 7; //7天的有效期
		String dateString = "";
		Date date = new Date();
		Calendar rightNow = Calendar.getInstance();
		rightNow.setTime(new Date());
		rightNow.add(Calendar.DAY_OF_YEAR, time);
		//System.out.println(rightNow.get(Calendar.DAY_OF_YEAR));
		date = rightNow.getTime();
		//Timestamp objTimestamp = new Timestamp(date.getTime());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dateString = sdf.format(date);
		return dateString;
	}
	
	public static void main(String[] args) {
		//Date obj = new AuthCode().getValidDate();
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
		//System.out.println("sdf:" + sdf.format(obj));
		
		//String obj = new AuthCode().getValidDate();
		//System.out.println("obj: " + obj);
	}
}
