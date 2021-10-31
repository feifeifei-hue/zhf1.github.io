package com.Test.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Test.Dao.allDao;
import com.Test.userBean.HeroBean;

/**
 * Servlet implementation class findHeroServlet
 */
@WebServlet("/findHeroServlet")
public class findHeroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   		req.setCharacterEncoding("utf-8");
   		String method = req.getParameter("method");
   		if ("findHero".equals(method)) {
   			String heroname = req.getParameter("Hero_name");
   			String health = req.getParameter("Hero_health");
   			String mana = req.getParameter("Hero_mana");
   			String as = req.getParameter("Hero_as");
   			System.out.println(heroname+"--"+health+"--"+mana+"--"+as);
   			if(!heroname.equals("")) {
   				List<HeroBean> userall = allDao.findHerosByName(heroname);
   	   			if(!userall.isEmpty()) {
   	   			req.setAttribute("heroall",userall);
   	   			req.getRequestDispatcher("houtai/findHero.jsp").forward(req, resp);
   	   			}else {
   	   			resp.getWriter().print("<script language='javascript'>alert('unfind!');window.location.href='houtai/findHero.jsp';</script>");
   	   			}
   			}else if(!health.equals("")) {
   				List<HeroBean> userall = allDao.findHeroByHealth(health);
   				if(!userall.isEmpty()) {
   				req.setAttribute("heroall",userall);
   	   			req.getRequestDispatcher("houtai/findHero.jsp").forward(req, resp);}else {
   	   	   			resp.getWriter().print("<script language='javascript'>alert('unfind!');window.location.href='houtai/findHero.jsp';</script>");
   	   	   			}
   			}else if(!mana.equals("")) {
   				List<HeroBean> userall = allDao.findHeroByMana(mana);
   				if(!userall.isEmpty()) {
   				req.setAttribute("heroall",userall);
   	   			req.getRequestDispatcher("houtai/findHero.jsp").forward(req, resp);}else {
   	   	   			resp.getWriter().print("<script language='javascript'>alert('unfind!');window.location.href='houtai/findHero.jsp';</script>");
   	   	   			}
   			}else if(!as.equals("")) {
   				List<HeroBean> heroall = allDao.findHeroByAs(as);
   				if(!heroall.isEmpty()) {
   				req.setAttribute("heroall",heroall);
   	   			req.getRequestDispatcher("houtai/findHero.jsp").forward(req, resp);}else {
   	   	   			resp.getWriter().print("<script language='javascript'>alert('unfind!');window.location.href='houtai/findHero.jsp';</script>");
   	   	   			}
   			}
   		}
   		else if ("updatefind".equals(method)) {
   			String heroname = req.getParameter("Hero_name");
   			HeroBean hero = allDao.findHeroByName(heroname);
   			if(hero!=null) {
   				req.setAttribute("hero",hero);
   	   			req.getRequestDispatcher("houtai/update2.jsp").forward(req, resp);
   			}else {
   				resp.getWriter().print("<script language='javascript'>alert('unfind!');window.location.href='houtai/update.jsp';</script>");
   			}
   		}
   		
	}
	
    public findHeroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
