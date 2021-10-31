package com.Test.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.Test.jdbc.jdbcUtils;
import com.Test.userBean.AdBean;
import com.Test.userBean.SkinBean;

public class allDao1 {

	public static boolean register1(SkinBean skin){
		Connection conn = null;
		PreparedStatement ptsmt = null;
		boolean pd = false;
		if(findSkinByName(skin.getSkinname())!=null) {
			return false;
		}else {
			try {
				//获取连接
				conn = jdbcUtils.getConnection();
				//编写语句
				String sql = "insert into dbo.skin values(?,?,?)";
				//获取语句执行对象
				ptsmt = conn.prepareStatement(sql);
				//完善语句
				  ptsmt.setString(1, skin.getSkinname()); 
				  ptsmt.setString(2, skin.getSkinbg());
				  ptsmt.setString(3, skin.getSkinprice()); 
				  
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
	
	public static List<SkinBean> getAll1(){
		List<SkinBean> list = new ArrayList<SkinBean>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = jdbcUtils.getConnection();
			String sql = "select * from dbo.skin";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				SkinBean skin = new SkinBean();
				skin.setSkinname(rs.getString("Skin_name"));
				skin.setSkinbg(rs.getString("Skin_bg"));
				skin.setSkinprice(rs.getString("Skin_price"));
				list.add(skin);
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
			String sql="delete from dbo.skin where Skin_name=?";
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
	
	public static boolean update1(SkinBean skin) {
		boolean pd = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = jdbcUtils.getConnection();
			String sql = "update dbo.skin set Skin_name=?,Skin_bg=?,Skin_price=? where Skin_name=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, skin.getSkinname());
			pstmt.setString(2, skin.getSkinbg());
			pstmt.setString(3, skin.getSkinprice());
			pstmt.setString(4, skin.getSkinname());
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
	
	public static SkinBean findSkinByName(String skinname){
		SkinBean skin = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = jdbcUtils.getConnection();
			String sql = "select * from dbo.skin where Skin_name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, skinname);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				skin = new SkinBean();
				skin.setSkinname(rs.getString("Skin_name"));
				skin.setSkinbg(rs.getString("Skin_bg"));
				skin.setSkinprice(rs.getString("Skin_price"));
			}else {
				skin = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			jdbcUtils.close(conn, pstmt, rs);
		}
		if(skin!=null) {
			return skin;
		}else {
			return null;
		}
	}
	
	public static List<SkinBean> findSkinsByName(String skinname){
		SkinBean skin = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<SkinBean> list = new ArrayList<SkinBean>();
		try {
			conn = jdbcUtils.getConnection();
			String sql = "select * from dbo.skin where Skin_name like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+skinname+"%");
			rs = pstmt.executeQuery();
			if(rs.next()) {
				skin = new SkinBean();
				skin.setSkinname(rs.getString("Skin_name"));
				skin.setSkinbg(rs.getString("Skin_bg"));
				skin.setSkinprice(rs.getString("Skin_price"));
				list.add(skin);
			}else {
				list = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			jdbcUtils.close(conn, pstmt, rs);
		}
		if(skin!=null) {
			return list;
		}else {
			return null;
		}
	}
	
	public static List<SkinBean> findSkinBySkinbg(String skinbg){
		List<SkinBean> list = new ArrayList<SkinBean>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = jdbcUtils.getConnection();
			String sql = "select * from dbo.skin where Skin_bg=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, skinbg);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				SkinBean skin = new SkinBean();
				skin.setSkinname(rs.getString("Skin_name"));
				skin.setSkinbg(rs.getString("Skin_bg"));
				skin.setSkinprice(rs.getString("Skin_price"));
				list.add(skin);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			jdbcUtils.close(conn, pstmt, rs);
		}
			return list;
	}
	
	public static List<SkinBean> findSkinBySkinprice(String skinprice){
		List<SkinBean> list = new ArrayList<SkinBean>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = jdbcUtils.getConnection();
			String sql = "select * from dbo.skin where Skin_price=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, skinprice);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				SkinBean skin = new SkinBean();
				skin.setSkinname(rs.getString("Skin_name"));
				skin.setSkinbg(rs.getString("Skin_bg"));
				skin.setSkinprice(rs.getString("Skin_price"));
				list.add(skin);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			jdbcUtils.close(conn, pstmt, rs);
		}
			return list;
	}
}
