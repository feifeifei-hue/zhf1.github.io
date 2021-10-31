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
 * Servlet implementation class SkinFindServlet
 */
@WebServlet("/SkinFindServlet")
public class SkinFindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   		req.setCharacterEncoding("utf-8");
   		String method = req.getParameter("method");
   		if ("findSkin".equals(method)) {
   			String skinname = req.getParameter("Skin_name");
   			String skinbg = req.getParameter("Skin_bg");
   			String skinprice = req.getParameter("Skin_price");
   			System.out.println(skinname+"--"+skinbg+"--"+skinprice+"--");
   			if(!skinname.equals("")) {
   				List<SkinBean> userall = allDao1.findSkinsByName(skinname);
   	   			if(!userall.isEmpty()) {
   	   			req.setAttribute("skinall",userall);
   	   			req.getRequestDispatcher("houtai/findSkin.jsp").forward(req, resp);
   	   			}else {
   	   			resp.getWriter().print("<script language='javascript'>alert('unfind!');window.location.href='houtai/findSkin.jsp';</script>");
   	   			}
   			}else if(!skinbg.equals("")) {
   				List<SkinBean> userall = allDao1.findSkinBySkinbg(skinbg);
   				if(!userall.isEmpty()) {
   				req.setAttribute("skinall",userall);
   	   			req.getRequestDispatcher("houtai/findSkin.jsp").forward(req, resp);
   				}else{
   	   	   			resp.getWriter().print("<script language='javascript'>alert('unfind!');window.location.href='houtai/findSkin.jsp';</script>");
   	   	   			}
   			}else if(!skinprice.equals("")) {
   				List<SkinBean> userall = allDao1.findSkinBySkinprice(skinprice);
   				if(!userall.isEmpty()) {
   				req.setAttribute("skinall",userall);
   	   			req.getRequestDispatcher("houtai/findSkin.jsp").forward(req, resp);
   	   			}else{
   	   	   			resp.getWriter().print("<script language='javascript'>alert('unfind!');window.location.href='houtai/findSkin.jsp';</script>");
   	   	   			}
   			}
   		}
   		else if ("updatefind1".equals(method)) {
   			String skinname = req.getParameter("Skin_name");
   			SkinBean skin = allDao1.findSkinByName(skinname);
   			if(skin!=null) {
   				req.setAttribute("skin",skin);
   	   			req.getRequestDispatcher("houtai/update4.jsp").forward(req, resp);
   			}else {
   				resp.getWriter().print("<script language='javascript'>alert('unfind!');window.location.href='houtai/update3.jsp';</script>");
   			}
   		}
   		
	}
	
    public SkinFindServlet() {
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
