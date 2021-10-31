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
 * Servlet implementation class searchAllServlet
 */
@WebServlet("/searchAllServlet")
public class searchAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   		req.setCharacterEncoding("utf-8");
   		String method = req.getParameter("method");
   		if ("search".equals(method)) {
   			List<HeroBean> heroall = allDao.getAll();
   			java.util.Collections.reverse(heroall);
   			req.setAttribute("heroall",heroall);
   			req.getRequestDispatcher("houtai/searchAll.jsp").forward(req, resp);
//   			resp.sendRedirect("houtai/searchAll.jsp");
   		}
   		
	}
	  
    public searchAllServlet() {
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
