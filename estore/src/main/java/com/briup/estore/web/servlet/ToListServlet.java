package com.briup.estore.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.bean.Book;
import com.briup.estore.service.IBookImp;
import com.briup.estore.service.IBookService;

@WebServlet("/toList")
public class ToListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取前端传递过来的二级栏目的id
		Integer categoryId = Integer.valueOf(request.getParameter("id"));
		IBookService book = new IBookImp();
		List<Book> categoryBook = book.findBookByCategoryId(categoryId);
		List<Book> topBook = book.findBookByCategoryIdWithClick(categoryId);
		request.setAttribute("categoryBook", categoryBook);
		request.setAttribute("topBook", topBook);
		request.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
