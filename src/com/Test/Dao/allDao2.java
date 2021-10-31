package com.Test.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.Test.jdbc.jdbcUtils;
import com.Test.userBean.AdBean;
import com.Test.userBean.MottoBean;

public class allDao2 {

	public static boolean register2(MottoBean motto){
		Connection conn = null;
		PreparedStatement ptsmt = null;
		boolean pd = false;
		if(findMottoByName(motto.getMottoname())!=null) {
			return false;
		}else {
			try {
				//获取连接
				conn = jdbcUtils.getConnection();
				//编写语句
				String sql = "insert into dbo.motto values(?,?,?)";
				//获取语句执行对象
				ptsmt = conn.prepareStatement(sql);
				//完善语句
				  ptsmt.setString(1, motto.getMottoname()); 
				  ptsmt.setString(2, motto.getMottorank());
				  ptsmt.setString(3, motto.getMottofc()); 
				  
				//执行语句并接受结果
				int res = ptsmt.executeUpdate();
				if(res>0) {
					pd=true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				jdbcUtils.close(conn, ptsmt, null);
			}
			return pd;
		}
	}
	
	public static boolean login(AdBean ad) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean pd = false ;
		try {
			conn = jdbcUtils.getConnection();
			String sql = "select * from login where username=? and password=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ad.getUsername());
			pstmt.setString(2, ad.getPassword());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				pd=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			jdbcUtils.close(conn, pstmt, rs);
		}
		return pd;
	}
	
	public static List<MottoBean> getAll2(){
		List<MottoBean> list = new ArrayList<MottoBean>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = jdbcUtils.getConnection();
			String sql = "select * from dbo.motto";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MottoBean motto = new MottoBean();
				motto.setMottoname(rs.getString("Motto_name"));
				motto.setMottorank(rs.getString("Motto_rank"));
				motto.setMottofc(rs.getString("Motto_function"));
				list.add(motto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			jdbcUtils.close(conn, pstmt, rs);
		}
			return list;
	}
	
	public static boolean deleteById(String name) {
		boolean pd = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = jdbcUtils.getConnection();
			String sql="delete from dbo.motto where Motto_name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			int res = pstmt.executeUpdate();
			if(res>0) {
				pd=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			jdbcUtils.close(conn, pstmt, null);
		}
		return pd;
	}
	
	public static boolean update2(MottoBean motto) {
		boolean pd = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = jdbcUtils.getConnection();
			String sql = "update dbo.motto set Motto_name=?,Motto_rank=?,Motto_function=? where Motto_name=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, motto.getMottoname());
			pstmt.setString(2, motto.getMottorank());
			pstmt.setString(3, motto.getMottofc());
			pstmt.setString(4, motto.getMottoname());
			int res = pstmt.executeUpdate(); //返回int，表示有多少条数据受到影响
			System.out.println(res);
			if(res>0) {
				pd=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			jdbcUtils.close(conn, pstmt, null);
		}
		return pd;
	}
	
	public static MottoBean findMottoByName(String mottoname){
		MottoBean motto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = jdbcUtils.getConnection();
			String sql = "select * from dbo.motto where Motto_name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mottoname);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				motto = new MottoBean();
				motto.setMottoname(rs.getString("Motto_name"));
				motto.setMottorank(rs.getString("Motto_rank"));
				motto.setMottofc(rs.getString("Motto_function"));
			}else {
				motto = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			jdbcUtils.close(conn, pstmt, rs);
		}
		if(motto!=null) {
			return motto;
		}else {
			return null;
		}
	}
	
	public static List<MottoBean> findMottosByName(String mottoname){
		MottoBean motto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MottoBean> list = new ArrayList<MottoBean>();
		try {
			conn = jdbcUtils.getConnection();
			String sql = "select * from dbo.motto where Motto_name like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+mottoname+"%");
			rs = pstmt.executeQuery();
			if(rs.next()) {
				motto = new MottoBean();
				motto.setMottoname(rs.getString("Motto_name"));
				motto.setMottorank(rs.getString("Motto_rank"));
				motto.setMottofc(rs.getString("Motto_function"));
				list.add(motto);
			}else {
				list = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			jdbcUtils.close(conn, pstmt, rs);
		}
		if(motto!=null) {
			return list;
		}else {
			return null;
		}
	}
	
	public static List<MottoBean> findMottoByMottorank(String mottorank){
		List<MottoBean> list = new ArrayList<MottoBean>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = jdbcUtils.getConnection();
			String sql = "select * from dbo.motto where Motto_rank=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mottorank);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MottoBean motto = new MottoBean();
				motto.setMottoname(rs.getString("Motto_name"));
				motto.setMottorank(rs.getString("Motto_rank"));
				motto.setMottofc(rs.getString("Motto_function"));
				list.add(motto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			jdbcUtils.close(conn, pstmt, rs);
		}
			return list;
	}
	
	public static List<MottoBean> findMottoByMottofc(String mottofc){
		List<MottoBean> list = new ArrayList<MottoBean>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = jdbcUtils.getConnection();
			String sql = "select * from dbo.motto where Motto_function=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mottofc);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MottoBean motto = new MottoBean();
				motto.setMottoname(rs.getString("Motto_name"));
				motto.setMottorank(rs.getString("Motto_rank"));
				motto.setMottofc(rs.getString("Motto_function"));
				list.add(motto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			jdbcUtils.close(conn, pstmt, rs);
		}
			return list;
	}
}


