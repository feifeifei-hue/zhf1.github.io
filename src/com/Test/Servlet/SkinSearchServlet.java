package com.Test.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Test.Dao.allDao1;
import com.Test.userBean.SkinBean;

/**
 * Servlet implementation class SkinSearchServlet
 */
@WebServlet("/SkinSearchServlet")
public class SkinSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   		req.setCharacterEncoding("utf-8");
   		String method = req.getParameter("method");
   		if ("search1".equals(method)) {
   			List<SkinBean> userall = allDao1.getAll1();
   			java.util.Collections.reverse(userall);
   			req.setAttribute("skinall",userall);
   			req.getRequestDispatcher("houtai/searchAll1.jsp").forward(req, resp);
   		}
	}
	  
    public SkinSearchServlet() {
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
