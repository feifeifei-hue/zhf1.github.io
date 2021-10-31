package com.Test.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Test.Dao.allDao;

/**
 * Servlet implementation class deleteServlet
 */
@WebServlet("/deleteServlet")
public class deleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String method = req.getParameter("method");
		if("delete".equals(method)) {
			String heroname = req.getParameter("Hero_name"); /* 根据字段的key，返回value */
			if(allDao.deleteById(heroname)) {
				req.setAttribute("xiaoxi", "删除成功!"); /* 将这个对象保存在request作用域中 */
				req.getRequestDispatcher("/searchAllServlet?method=search").forward(req, resp); /* 请求转发 */
			}else {
				resp.sendRedirect("searchAll.jsp"); /* 重定向 */
			}
		}
	}

    public deleteServlet() {
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
