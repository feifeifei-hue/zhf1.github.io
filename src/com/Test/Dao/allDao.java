package com.Test.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.Test.jdbc.jdbcUtils;
import com.Test.userBean.AdBean;
import com.Test.userBean.HeroBean;

public class allDao {

	public static boolean register(HeroBean hero){
		Connection conn = null;
		PreparedStatement ptsmt = null; /* 预编译，支持批处理，访问数据库更快 */
		boolean pd = false;
		if(findHeroByName(hero.getHeroname())!=null) {
			return false;
		}else {
			try {
				//获取连接
				conn = jdbcUtils.getConnection();
				//编写语句
				String sql = "insert into dbo.hero values(?,?,?,?,?,?,?)";
				//获取语句执行对象
				  ptsmt = conn.prepareStatement(sql);
				//完善语句
				  ptsmt.setString(1, hero.getHeroname()); /* 第一个参数是该参数在语句中的索引。参数标记具有从 1 开始的编号。 通常指的是第一个“？”第二个参数是要对第一个参数设置的值。 */
				  ptsmt.setString(2, hero.getHerohealth());
				  ptsmt.setString(3, hero.getHeromana()); 
				  ptsmt.setString(4, hero.getHeroas());
				  ptsmt.setString(5, hero.getHeroac());
				  ptsmt.setString(6, hero.getSkinname());
				  ptsmt.setString(7, hero.getMottoname());
				//执行语句并接受结果
				int res = ptsmt.executeUpdate(); /* 表示有多少条数据受到影响 */
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
	
	public static List<HeroBean> getAll(){
		List<HeroBean> list = new ArrayList<HeroBean>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = jdbcUtils.getConnection();
			String sql = "select * from dbo.hero";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();/* 下达select指令以查询数据库，executeQuery()方法会把数据库响应的查询结果存放在ResultSet类对象中供我们使用。 */
			while (rs.next()) { /* 如果有下一行则游标向下移动一行 */
				HeroBean hero = new HeroBean();
				hero.setHeroname(rs.getString("Hero_name"));
				hero.setHerohealth(rs.getString("Hero_health"));
				hero.setHeromana(rs.getString("Hero_mana"));
				hero.setHeroas(rs.getString("Hero_as"));
				hero.setHeroac(rs.getString("Hero_ac"));
				hero.setSkinname(rs.getString("skinname"));
				hero.setMottoname(rs.getString("mottoname"));
				list.add(hero);
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
			String sql="delete from dbo.hero where Hero_name=?";
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
	
	public static boolean update(HeroBean hero) {
		boolean pd = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = jdbcUtils.getConnection();
			String sql = "update dbo.hero set Hero_name=?,Hero_health=?,Hero_mana=?,Hero_as=?,Hero_ac=?,skinname=?,mottoname=? where Hero_name=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, hero.getHeroname());
			pstmt.setString(2, hero.getHerohealth());
			pstmt.setString(3, hero.getHeromana());
			pstmt.setString(4, hero.getHeroas());
			pstmt.setString(5, hero.getHeroac());
			pstmt.setString(6, hero.getSkinname());
			pstmt.setString(7, hero.getMottoname());
			pstmt.setString(8, hero.getHeroname());
			
			int res = pstmt.executeUpdate();
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
	
	public static HeroBean findHeroByName(String heroname){
		HeroBean hero = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = jdbcUtils.getConnection();
			String sql = "select * from dbo.hero where Hero_name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, heroname);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				hero = new HeroBean();
				hero.setHeroname(rs.getString("Hero_name"));
				hero.setHerohealth(rs.getString("Hero_health"));
				hero.setHeromana(rs.getString("Hero_mana"));
				hero.setHeroas(rs.getString("Hero_as"));
				hero.setHeroac(rs.getString("Hero_ac"));
				hero.setSkinname(rs.getString("skinname"));
				hero.setMottoname(rs.getString("mottoname"));
			}else {
				hero = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			jdbcUtils.close(conn, pstmt, rs);
		}
		if(hero!=null) {
			return hero;
		}else {
			return null;
		}
	}
	
	public static List<HeroBean> findHerosByName(String heroname){
		HeroBean hero = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<HeroBean> list = new ArrayList<HeroBean>();
		try {
			conn = jdbcUtils.getConnection();
			String sql = "select * from dbo.hero where Hero_name like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + heroname + "%"); /* 模糊查询 */
			rs = pstmt.executeQuery();
			if(rs.next()) {
				hero = new HeroBean();
				hero.setHeroname(rs.getString("Hero_name"));
				hero.setHerohealth(rs.getString("Hero_health"));
				hero.setHeromana(rs.getString("Hero_mana"));
				hero.setHeroas(rs.getString("Hero_as"));
				hero.setHeroac(rs.getString("Hero_ac"));
				hero.setSkinname(rs.getString("skinname"));
				hero.setMottoname(rs.getString("mottoname"));
				list.add(hero);
			}else {
				list = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			jdbcUtils.close(conn, pstmt, rs);
		}
		if(hero!=null) {
			return list;
		}else {
			return null;
		}
	}
	
	public static List<HeroBean> findHeroByHealth(String health){
		List<HeroBean> list = new ArrayList<HeroBean>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = jdbcUtils.getConnection();
			String sql = "select * from dbo.hero where Hero_health=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, health);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				HeroBean hero = new HeroBean();
				hero = new HeroBean();
				hero.setHeroname(rs.getString("Hero_name"));
				hero.setHerohealth(rs.getString("Hero_health"));
				hero.setHeromana(rs.getString("Hero_mana"));
				hero.setHeroas(rs.getString("Hero_as"));
				hero.setHeroac(rs.getString("Hero_ac"));
				hero.setSkinname(rs.getString("skinname"));
				hero.setMottoname(rs.getString("mottoname"));
				list.add(hero);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			jdbcUtils.close(conn, pstmt, rs);
		}
			return list;
	}
	
	public static List<HeroBean> findHeroByMana(String mana){
		List<HeroBean> list = new ArrayList<HeroBean>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = jdbcUtils.getConnection();
			String sql = "select * from dbo.hero where Hero_mana=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mana);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				HeroBean hero = new HeroBean();
				hero = new HeroBean();
				hero.setHeroname(rs.getString("Hero_name"));
				hero.setHerohealth(rs.getString("Hero_health"));
				hero.setHeromana(rs.getString("Hero_mana"));
				hero.setHeroas(rs.getString("Hero_as"));
				hero.setHeroac(rs.getString("Hero_ac"));
				hero.setSkinname(rs.getString("skinname"));
				hero.setMottoname(rs.getString("mottoname"));
				list.add(hero);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			jdbcUtils.close(conn, pstmt, rs);
		}
			return list;
	}
	
	public static List<HeroBean> findHeroByAs(String as){
		List<HeroBean> list = new ArrayList<HeroBean>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = jdbcUtils.getConnection();
			String sql = "select * from dbo.hero where Hero_as=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, as);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				HeroBean hero = new HeroBean();
				hero = new HeroBean();
				hero.setHeroname(rs.getString("Hero_name"));
				hero.setHerohealth(rs.getString("Hero_health"));
				hero.setHeromana(rs.getString("Hero_mana"));
				hero.setHeroas(rs.getString("Hero_as"));
				hero.setHeroac(rs.getString("Hero_ac"));
				hero.setSkinname(rs.getString("skinname"));
				hero.setMottoname(rs.getString("mottoname"));
				list.add(hero);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			jdbcUtils.close(conn, pstmt, rs);
		}
			return list;
	}
}
