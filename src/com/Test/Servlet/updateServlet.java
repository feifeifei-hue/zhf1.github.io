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
 * Servlet implementation class updateServlet
 */
@WebServlet("/updateServlet")
public class updateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   		req.setCharacterEncoding("utf-8");
   		String method = req.getParameter("method");
   		if ("update".equals(method)) {
   			String heroname = req.getParameter("Hero_name");
   			String health = req.getParameter("Hero_health");
   			String mana = req.getParameter("Hero_mana");
   			String as = req.getParameter("Hero_as");
   			String ac = req.getParameter("Hero_ac");
   			String[] skinname = req.getParameterValues("skinname");
   			String[] mottoname = req.getParameterValues("mottoname");
   			String mottoname1="";
   			String skinname1="";
   			for(int i =0;i<skinname.length-1;i++) {
   				skinname1+=skinname[i]+",";
   			}
   			for(int i =0;i<mottoname.length-1;i++) {
   				mottoname1+=mottoname[i]+",";
   			}
   			skinname1+=skinname[skinname.length-1];
   			mottoname1+=mottoname[mottoname.length-1];
   			HeroBean hero = new HeroBean(heroname, health, mana, as, ac, skinname1, mottoname1);
   			if(allDao.update(hero)) {
   				req.setAttribute("xiaoxi","更新成功");
   	   			req.getRequestDispatcher("/searchAllServlet?method=search").forward(req, resp);
   			}else {
				resp.sendRedirect("houtai/searchAll.jsp");
			}
   			
   		}
   		
	}
	
    public updateServlet() {
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
