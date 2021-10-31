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
 * Servlet implementation class SkinAddServlet
 */
@WebServlet("/SkinAddServlet")
public class SkinAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   		req.setCharacterEncoding("utf-8");
   		String method = req.getParameter("method");
   		if ("add1".equals(method)) {
   			String skinname = req.getParameter("Skin_name");
   			String skinbg = req.getParameter("Skin_bg");
   			String skinprice = req.getParameter("Skin_price");
   			
   			SkinBean skin = new SkinBean(skinname, skinbg, skinprice);
   			boolean pd = allDao1.register1(skin);
   			if(pd) {
//   				req.getSession().setAttribute("message", "ע��ɹ�");
   				resp.getWriter().print("<script language='javascript'>alert('succeed!');window.location.href='SkinSearchServlet?method=search1';</script>");
//   				resp.sendRedirect("searchAllServlet?method=search");
   			}else {
   				resp.getWriter().print("<script language='javascript'>alert('unsucceed!');window.location.href='houtai/SkinAdd.jsp';</script>");
//   				req.setAttribute("message", "ע��ʧ�ܣ�������ע��");
//   				resp.sendRedirect("houtai/StuAdd.jsp");
   				
   			}
   		}
   		
	}

    public SkinAddServlet() {
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
