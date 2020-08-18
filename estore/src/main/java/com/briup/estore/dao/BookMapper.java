package com.briup.estore.dao;

import java.util.List;

import com.briup.estore.bean.Book;

public interface BookMapper {
	List<Book> findBookByClick();
	List<Book> selectAllBook();
	Book findBookById(Integer id);
	void updateBook(Book book);
	List<Book> findBookByCategoryId(Integer id);
	List<Book> findBookByCategoryIdWithClick(Integer id);
}
