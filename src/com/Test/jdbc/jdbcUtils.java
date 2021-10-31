package com.Test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class jdbcUtils {
	public static Connection getConnection() {
		//public static Connection getConn () {
			Connection conn=null;
			String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver"; //加载驱动
			String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=xiaoxueqi";
			//"jdbc:sqlserver://localhost:1433;databaseName = xxx"是microsoft提供的java-sqlserver数据库连接驱动来访问sqlserver时的url
			//localhost是指数据库服务器地址，1433为sqlserver端口号！
			String userName="20183709"; //自己创建的登录名
			String userPwd="123456";//登录密码
			try{
				Class.forName(driverName).newInstance();
				conn=DriverManager.getConnection(dbURL,userName,userPwd);
				System.out.println("连接成功");
			}
			catch(Exception e){
				System.out.println("连接失败");
			}
			return conn;
	}
	/*	Connection conn = null;
		try {
			//注册驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/register?serverTimezone=UTC", "root", "root");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
		
	*/
	
	//关闭连接，这个一般是查询的Dao层所用的
	public static void close(Connection conn,PreparedStatement ptsmt,ResultSet rs) {
		
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
		if(ptsmt!=null) {
			try {
				ptsmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
		
	}
}
