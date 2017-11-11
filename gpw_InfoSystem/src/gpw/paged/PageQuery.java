package gpw.paged;

import java.sql.*;
import java.util.List;
import gpw.object.Expert;

import javax.servlet.http.HttpServletRequest;

public class PageQuery {
	
	int Offset;      //记录偏移量
	int Total;		 //记录总数
	
	int MaxLine;	 //记录每页显示记录数
	List<Expert> rs;  	 //读出的结果
	
	int Tpages;   	 //总页数
	int Cpages; 	 //当前页数
	
	String PageQuery;//分页显示要传递的参数
	String Query;  	 //query语句
	String QueryPart;//"FROM" 以后的query部分
	
	String FilePath;
	
	PagedClass db;	 //object of dbclass
	
	//constructer do nothing
	public PageQuery(){
		MaxLine = 20;
		db = new PagedClass();
	}
	
	//读取记录
	public List<Expert> myQuery(List<Expert> experts, HttpServletRequest req) throws SQLException {
		String query_part, os;
		int begin, offset;
		
//		//截取from以后的query语句
//		begin = query.indexOf("FROM");
//		query_part = query.substring(begin, query.length()).trim();
		
		//计算偏移量
		os = req.getParameter("offset");
		if (os == null) Offset = 0;
		else Offset = Integer.parseInt(os);
		
		//获取文件名
		FilePath = req.getRequestURI();
		
//		Query = query;
//		QueryPart = query_part;
		
		//计算总的记录条数
//		String SQL = "SELECT Count(*) AS total" + this.QueryPart;
//		rs = db.executeQuery(SQL);
//		if (rs.next())
//			Total = rs.getInt(1);
		Total = experts.size();
		
		//设置当前页数和总页数
		Tpages = (int)Math.ceil((double)this.Total/this.MaxLine);
		Cpages = (int)Math.floor((double)Offset/this.MaxLine+1);
		
		//根据条件判断,取出所需记录
		if (Total > 0){
//			SQL = Query + "LIMIT" + Offset + "," + MaxLine;
//			rs = db.executeQuery(SQL);
			if((Offset+MaxLine) > Total){ rs = experts.subList(Offset, Total);}
			else {rs = experts.subList(Offset, MaxLine+Offset);}
			
		}
		
		return rs;
	}
	public void close(){
		db.closedb();
	}
	public int getTotalPages(){
		return Tpages;
	}
	public int getCurrentPages(){
		return Cpages;
	}
	
	//显示翻页提示栏
	//显示首页下页上页尾页
	public String PageLegend(){
		String str = "";
		int first, next, prev, last;
		first = 0;
		next = Offset + MaxLine;
		prev = Offset - MaxLine;
		last = (this.Tpages - 1) * MaxLine;
		
		if(Offset >= MaxLine)
			str += "<A href=" + FilePath + "?offset=" + first + ">首页 </A>";
		else str += "首页 ";
		if(prev >= 0)
			str += "<A href=" + FilePath + "?offset=" + prev + ">前页 </A>";
		else str += "前页 ";
		if(next < Total)
			str += "<A href=" + FilePath + "?offset=" + next + ">后页 </A>";
		else str += "后页 ";
		if(Tpages != 0 && Cpages < Tpages)
			str += "<A href=" +FilePath + "?offset=" + last + ">尾页 </A>";
		else str += "尾页 ";
		
		str += "页次：" + getCurrentPages() + "/" + getTotalPages() + "页 ";
		str += MaxLine + "条/页 " + "共 " + Total + "条";
		String pageNum;
		return str;
	}
}
