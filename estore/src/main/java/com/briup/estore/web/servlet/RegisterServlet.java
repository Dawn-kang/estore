package com.briup.estore.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.bean.Customer;
import com.briup.estore.service.ICustomerImp;
import com.briup.estore.service.ICustomerService;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//从前端获取注册信息并封装成Customer对象
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String zipCode = request.getParameter("zipCode");
		String telephone = request.getParameter("telephone");
		String email = request.getParameter("email");
		Customer customer = new Customer(name,password,zipCode,telephone,email);
		
		//调用存储用户信息的方法，注册成功则跳转到登录页面，失败则继续留在注册页面
		ICustomerService ics = new ICustomerImp();
		String url = null;
		try {
			ics.register(customer);
			url = "/WEB-INF/jsp/login.jsp";
		} catch (Exception e) {
			url = "/WEB-INF/jsp/register.jsp";
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
