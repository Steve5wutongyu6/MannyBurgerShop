package utils;

import java.sql.*;

public class DBUtil {

	static Connection conn;
	static String url="jdbc:mysql://rm-f8z2sbii4xfjv9b5wso.mysql.rds.aliyuncs.com:3306/homework?useUnicode=true&characterEncoding=UTF-8";
	static String userName="javaweb";
	static String password="@Lt&$J$rFM44qbk";
	static {
		//连接数据库
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//获取数据库通路的方法
	public static Connection getConnection() {
		try {
			conn=DriverManager.getConnection(url,userName,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	//关闭与数据库的连接
	public static void close(Connection conn,Statement stmt,ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
			}
			if(stmt != null) {
				stmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		} catch (SQLException e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Connection conn = DBUtil.getConnection();
		if (conn==null) {
			System.out.println("连接失败");
		} else {
			System.out.println("连接成功");
		}
	}
}
