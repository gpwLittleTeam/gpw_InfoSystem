package gpw.connection;

import java.sql.*;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;

import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;
import com.opensymphony.xwork2.ActionContext;

public class LinkDB {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/gpwinfomanagementsystem?useUnicode=true&characterEncoding=UTF-8";
	
	private Connection conn;
	
	public Connection getConn() {
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, "root",
					"root");
			return conn;
		} catch (ClassNotFoundException | SQLException ex) {
			System.out.println("Can't connect to ds!");//
			HttpServletRequest request = (HttpServletRequest)
					ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
			request.setAttribute("Error", "NoConnect");
			//ex.printStackTrace();
			return null;
		} catch (Exception e) {
			System.out.println("An unknown error occurred!");
			HttpServletRequest request = (HttpServletRequest)
					ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
			request.setAttribute("Error", "Unknown");
			e.printStackTrace();
			return null;
		}
	}
	
	public void close(Connection conn) throws SQLException {
		if (conn != null) {
			conn.close();
		}
	}
}
