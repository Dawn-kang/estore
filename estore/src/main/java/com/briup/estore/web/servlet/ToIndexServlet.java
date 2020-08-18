package com.briup.estore.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.Category;
import com.briup.estore.service.IBookImp;
import com.briup.estore.service.IBookService;
import com.briup.estore.service.ICategoryImp;
import com.briup.estore.service.ICategoryService;

@WebServlet("/toIndex")
public class ToIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ICategoryService category = new ICategoryImp();
		List<Category> categoryList = category.findFirstWithSecondCategory();
		request.setAttribute("categoryList", categoryList);
		
		IBookService book = new IBookImp();
		List<Book> bookList1 = book.findBookByClick();
		List<Book> bookList2 = book.selectAllBook();
		request.setAttribute("bookList1", bookList1);
		request.setAttribute("bookList2", bookList2);
		request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
