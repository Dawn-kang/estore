package com.briup.estore.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.bean.Book;
import com.briup.estore.service.IBookImp;
import com.briup.estore.service.IBookService;

@WebServlet("/toViewBook")
public class ToViewBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取书籍对应的id
		Integer id = Integer.parseInt(request.getParameter("id"));
		//根据id查询出书籍的信息
		IBookService ibook = new IBookImp();
		Book book = ibook.findBookById(id);
		//将查询出来的书籍信息存放到request中
		request.setAttribute("book", book);
		request.getRequestDispatcher("/WEB-INF/jsp/viewBook.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
