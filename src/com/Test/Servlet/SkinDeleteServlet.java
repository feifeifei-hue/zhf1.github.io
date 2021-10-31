package com.Test.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.Test.Dao.allDao1;

	/**
	 * Servlet implementation class SkinDeleteServlet
	 */
	@WebServlet("/SkinDeleteServlet")
	public class SkinDeleteServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.setCharacterEncoding("utf-8");
			String method = req.getParameter("method");
			if("delete1".equals(method)) {
				String skinname = req.getParameter("Skin_name");
				if(allDao1.deleteById(skinname)) {
					req.setAttribute("xiaoxi", "É¾³ý³É¹¦!");
					req.getRequestDispatcher("/SkinSearchServlet?method=search1").forward(req, resp);
				}else {
					resp.sendRedirect("searchAll1.jsp");
				}
			}
		}

	    public SkinDeleteServlet() {
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


