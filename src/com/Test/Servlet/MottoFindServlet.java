package com.Test.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Test.Dao.allDao2;
import com.Test.userBean.MottoBean;

/**
 * Servlet implementation class MottoFindServlet
 */
@WebServlet("/MottoFindServlet")
public class MottoFindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   		req.setCharacterEncoding("utf-8");
   		String method = req.getParameter("method");
   		if ("findMotto".equals(method)) {
   			String mottoname = req.getParameter("Motto_name");
   			String mottorank = req.getParameter("Motto_rank");
   			String mottofc = req.getParameter("Motto_function");
   			System.out.println(mottoname+"--"+mottorank+"--"+mottofc+"--");
   			if(!mottoname.equals("")) {
   				List<MottoBean> userall = allDao2.findMottosByName(mottoname);
   	   			if(!userall.isEmpty()) {
   	   			req.setAttribute("mottoall",userall);
   	   			req.getRequestDispatcher("houtai/findMotto.jsp").forward(req, resp);
   	   			}else {
   	   			resp.getWriter().print("<script language='javascript'>alert('unfind!');window.location.href='houtai/findMotto.jsp';</script>");
   	   			}
   			}else if(!mottorank.equals("")) {
   				List<MottoBean> userall = allDao2.findMottoByMottorank(mottorank);
   				if(!userall.isEmpty()) {
   				req.setAttribute("mottoall",userall);
   	   			req.getRequestDispatcher("houtai/findMotto.jsp").forward(req, resp);
   				}else{
   	   	   			resp.getWriter().print("<script language='javascript'>alert('unfind!');window.location.href='houtai/findMotto.jsp';</script>");
   	   	   			}
   			}else if(!mottofc.equals("")) {
   				List<MottoBean> userall = allDao2.findMottoByMottofc(mottofc);
   				if(!userall.isEmpty()) {
   				req.setAttribute("mottoall",userall);
   	   			req.getRequestDispatcher("houtai/findMotto.jsp").forward(req, resp);
   	   			}else{
   	   	   			resp.getWriter().print("<script language='javascript'>alert('unfind!');window.location.href='houtai/findMotto.jsp';</script>");
   	   	   			}
   			}
   		}
   		else if ("updatefind2".equals(method)) {
   			String mottoname = req.getParameter("Motto_name");
   			MottoBean motto = allDao2.findMottoByName(mottoname);
   			if(motto!=null) {
   				req.setAttribute("motto",motto);
   	   			req.getRequestDispatcher("houtai/update6.jsp").forward(req, resp);
   			}else {
   				resp.getWriter().print("<script language='javascript'>alert('unfind!');window.location.href='houtai/update5.jsp';</script>");
   			}
   		}
	}
	
    public MottoFindServlet() {
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
