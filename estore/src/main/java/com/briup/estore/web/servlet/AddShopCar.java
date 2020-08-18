package com.briup.estore.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.OrderLine;
import com.briup.estore.bean.ShopCar;
import com.briup.estore.service.IBookImp;


public class AddShopCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取前端传递过来的添加到购物车的书籍id和数量
		String id = request.getParameter("id");
		String num = request.getParameter("num");
		//根据id获取书籍信息
		if(id !=null) {
		IBookImp iBook = new IBookImp();
		Book book = iBook.findBookById(Integer.valueOf(id));
		//新建购物表单OrderLine对象并将获取到的值通过计算赋值给该对象
		OrderLine line = new OrderLine();
		line.setBook(book);
		line.setNum(Integer.valueOf(num));
		line.setCost(book.getPrice()*line.getNum());
		
		//获取shopcar对象，将书籍信息添加到对象中
		HttpSession session = request.getSession();
		ShopCar car = (ShopCar) session.getAttribute("car");
		car.addShopCar(line);
		}
		request.getRequestDispatcher("/WEB-INF/user/shopCar.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
