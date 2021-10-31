package com.Test.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.Test.Dao.allDao;
import com.Test.userBean.HeroBean;


/**
 * Servlet implementation class registerServlet
 */
@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   		req.setCharacterEncoding("utf-8");
   		String method = req.getParameter("method");
   		if ("add".equals(method)) {
   			String heroname = req.getParameter("Hero_name");
   			String health = req.getParameter("Hero_health");
   			String mana = req.getParameter("Hero_mana");
   			String as = req.getParameter("Hero_as");
   			String ac = req.getParameter("Hero_ac");
			String[] skinname = req.getParameterValues("skinname"); /* 根据key，返回多个value值 */
   			String[] mottoname = req.getParameterValues("mottoname");
   			String skinname1="";
   			String mottoname1="";
   			for(int i = 0;i<skinname.length-1;i++) {
   				skinname1+=skinname[i]+","; //将皮肤名称连起来
   			}
   			for(int i = 0;i<mottoname.length-1;i++) {
   				mottoname1+=mottoname[i]+","; //将铭文名称连起来
   			}
   			
   			mottoname1+=mottoname[mottoname.length-1];
   			skinname1+=skinname[skinname.length-1];
   			HeroBean hero = new HeroBean(heroname, health, mana, as, ac, skinname1, mottoname1);
   			boolean pd = allDao.register(hero);
   			if(pd) {
//   				req.getSession().setAttribute("message", "注册成功");
   				resp.getWriter().print("<script language='javascript'>alert('succeed!');window.location.href='searchAllServlet?method=search';</script>");
//   				resp.sendRedirect("searchAllServlet?method=search");
   			}else {
   				resp.getWriter().print("<script language='javascript'>alert('unsucceed!');window.location.href='houtai/HeroAdd.jsp';</script>");
//   				req.setAttribute("message", "注册失败，请重新注册");
//   				resp.sendRedirect("houtai/StuAdd.jsp");
   				
   			}
   		}
   		
	}

    public registerServlet() {
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
