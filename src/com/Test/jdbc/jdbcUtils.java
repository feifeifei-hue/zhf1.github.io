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
			String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver"; //��������
			String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=xiaoxueqi";
			//"jdbc:sqlserver://localhost:1433;databaseName = xxx"��microsoft�ṩ��java-sqlserver���ݿ���������������sqlserverʱ��url
			//localhost��ָ���ݿ��������ַ��1433Ϊsqlserver�˿ںţ�
			String userName="20183709"; //�Լ������ĵ�¼��
			String userPwd="123456";//��¼����
			try{
				Class.forName(driverName).newInstance();
				conn=DriverManager.getConnection(dbURL,userName,userPwd);
				System.out.println("���ӳɹ�");
			}
			catch(Exception e){
				System.out.println("����ʧ��");
			}
			return conn;
	}
	/*	Connection conn = null;
		try {
			//ע������
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/register?serverTimezone=UTC", "root", "root");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
		
	*/
	
	//�ر����ӣ����һ���ǲ�ѯ��Dao�����õ�
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
