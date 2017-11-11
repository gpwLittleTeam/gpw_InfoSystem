package gpw.paged;

import gpw.connection.LinkDB;

import java.sql.*;

public class PagedClass {
	
	LinkDB link = new LinkDB();
	Connection conn = link.getConn();
	Statement stmt = null;
	ResultSet rs = null;
	ResultSetMetaData resultsMeta = null;
	int rows = 0;
	
	public ResultSet executeQuery(String sql) throws SQLException{
		ResultSet rs = null;
		try{
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next())
				this.rows ++;
			rs = stmt.executeQuery(sql);
		}
		catch(SQLException e){
			System.out.println("Query:" + e.getMessage());
		}
		
		this.rs = rs;
		return rs;
	}
	
	public boolean executeUpdate(String sql){
		try{
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			return true;
		}
		catch(SQLException e){
			System.out.println("Update:" + e.getMessage());
			return false;
		}
	}
	
	public int getColumns(){
		int columns = 0;
		try{
			this.resultsMeta = this.rs.getMetaData();
			columns = this.resultsMeta.getColumnCount();
		}
		catch(SQLException e){}
		return columns;
	}
	
	public int getRows(){
		return this.rows;
	}
	public void closedb(){
		try{
			conn.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
}
