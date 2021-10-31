package com.Test.Servlet;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Test.Dao.allDao2;
import com.Test.userBean.MottoBean;
/**
 * Servlet implementation class MottoAddServlet
 */
@WebServlet("/MottoAddServlet")
public class MottoAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   		req.setCharacterEncoding("utf-8");
   		String method = req.getParameter("method");
   		if ("add2".equals(method)) {
   			String mottoname = req.getParameter("Motto_name");
   			String mottorank = req.getParameter("Motto_rank");
   			String mottofc = req.getParameter("Motto_function");
   			
   			MottoBean motto = new MottoBean(mottoname, mottorank, mottofc);
   			boolean pd = allDao2.register2(motto);
   			if(pd) {
//   				req.getSession().setAttribute("message", "×¢²á³É¹¦");
   				resp.getWriter().print("<script language='javascript'>alert('succeed!');window.location.href='MottoSearchServlet?method=search2';</script>");
//   				resp.sendRedirect("searchAllServlet?method=search");
   			}else {
   				resp.getWriter().print("<script language='javascript'>alert('unsucceed!');window.location.href='houtai/MottoAdd.jsp';</script>");
//   				req.setAttribute("message", "×¢²áÊ§°Ü£¬ÇëÖØÐÂ×¢²á");
//   				resp.sendRedirect("houtai/StuAdd.jsp");
   				
   			}
   		}
   		
	}

    public MottoAddServlet() {
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

