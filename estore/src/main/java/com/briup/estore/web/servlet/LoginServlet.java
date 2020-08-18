package com.briup.estore.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.Customer;
import com.briup.estore.bean.ShopCar;
import com.briup.estore.service.ICustomerImp;
import com.briup.estore.service.ICustomerService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取前端传过来的用户登录信息
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		String url = null;
		//验证用户名和密码
		ICustomerService cust = new ICustomerImp();
		try {
			Customer customer = cust.login(name, password);
			ShopCar car = new ShopCar();
			HttpSession session = request.getSession();
			session.setAttribute("customer", customer);
			session.setAttribute("car", car);
			url = "/toIndex";
		} catch (Exception e) {
			url = "/WEB-INF/jsp/login.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
