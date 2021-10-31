package com.Test.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Test.Dao.allDao1;
import com.Test.userBean.SkinBean;

/**
 * Servlet implementation class SkinUpdateServlet
 */
@WebServlet("/SkinUpdateServlet")
public class SkinUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   		req.setCharacterEncoding("utf-8");
   		String method = req.getParameter("method");
   		if ("update1".equals(method)) {
   			String skinname = req.getParameter("Skin_name");
   			String skinbg = req.getParameter("Skin_bg");
   			String skinprice = req.getParameter("Skin_price");
   			SkinBean skin = new SkinBean(skinname, skinbg, skinprice);
   			if(allDao1.update1(skin)) {
   				req.setAttribute("xiaoxi","更新成功");
   	   			req.getRequestDispatcher("/SkinSearchServlet?method=search1").forward(req, resp);
   			}else {
				resp.sendRedirect("houtai/searchAll1.jsp");
			}
   		}
	}
    public SkinUpdateServlet() {
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