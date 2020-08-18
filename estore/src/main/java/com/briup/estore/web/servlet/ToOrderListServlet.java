package com.briup.estore.web.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.Customer;
import com.briup.estore.bean.OrderForm;
import com.briup.estore.bean.OrderLine;
import com.briup.estore.bean.ShopAddress;
import com.briup.estore.bean.ShopCar;
import com.briup.estore.service.IOrderFormImp;
import com.briup.estore.service.IOrderFormService;
import com.briup.estore.service.IShopAddressImp;
import com.briup.estore.service.IShopAddressService;

public class ToOrderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//通过session获取car信息
		ShopCar car = (ShopCar) session.getAttribute("car");
		//通过session获取customer信息
		Customer customer = (Customer) session.getAttribute("customer");
		//通过地址id获取shopAddress信息
		String addId = request.getParameter("shopAddId");
		IShopAddressService sas = new IShopAddressImp();
		ShopAddress shopAddress = sas.selectAddressById(Integer.parseInt(addId));
		//设置订单信息
		OrderForm form = new OrderForm();
		form.setCost(car.getCost());
		form.setCustomer(customer);
		form.setOrderdate(new Date());
		form.setShopAddress(shopAddress);
		//保存订单
		IOrderFormService ofs = new IOrderFormImp();
		ofs.insertOrderForm(form);
		//获取订单项信息
		Map<Integer, OrderLine> map = car.getOrderLines();
		Set<Entry<Integer,OrderLine>> entrySet = map.entrySet();
		//遍历订单项信息并设置订单信息
		for (Entry<Integer, OrderLine> entry : entrySet) {
			OrderLine orderLine = entry.getValue();
			orderLine.setForm(form);
		}
		//跳转到orderList.jsp
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
