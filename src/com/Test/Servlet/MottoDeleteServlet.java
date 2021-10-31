package com.Test.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.Test.Dao.allDao2;

	/**
	 * Servlet implementation class MottoDeleteServlet
	 */
	@WebServlet("/MottoDeleteServlet")
	public class MottoDeleteServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.setCharacterEncoding("utf-8");
			String method = req.getParameter("method");
			if("delete2".equals(method)) {
				String mottoname = req.getParameter("Motto_name");
				if(allDao2.deleteById(mottoname)) {
					req.setAttribute("xiaoxi", "É¾³ý³É¹¦!");
					req.getRequestDispatcher("/MottoSearchServlet?method=search2").forward(req, resp);
				}else {
					resp.sendRedirect("searchAll2.jsp");
				}
			}
		}

	    public MottoDeleteServlet() {
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

