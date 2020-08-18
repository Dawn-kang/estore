package com.briup.estore.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.Customer;
import com.briup.estore.bean.ShopAddress;
import com.briup.estore.service.IShopAddressImp;
import com.briup.estore.service.IShopAddressService;


public class ToConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//从session中获取customer信息
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("customer");
		//根据用户id查询所有收货地址信息并保存到request中
		IShopAddressService address = new IShopAddressImp();
		List<ShopAddress> list = address.selectAddressByCustId(customer.getId());
		request.setAttribute("addressList", list);
		//跳转到confirm.jsp页面
		request.getRequestDispatcher("/WEB-INF/user/confirm.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
