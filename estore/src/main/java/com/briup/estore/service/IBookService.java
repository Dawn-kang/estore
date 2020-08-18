package com.briup.estore.service;

import java.util.List;

import com.briup.estore.bean.Book;

public interface IBookService {
	List<Book> findBookByClick();
	List<Book> selectAllBook();
	Book findBookById(Integer id);
	List<Book> findBookByCategoryId(Integer id);
	List<Book> findBookByCategoryIdWithClick(Integer id);

}
