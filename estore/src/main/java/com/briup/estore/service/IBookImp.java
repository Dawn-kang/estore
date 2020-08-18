package com.briup.estore.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.Book;
import com.briup.estore.dao.BookMapper;
import com.briup.estore.util.GetSqlSession;

public class IBookImp implements IBookService{

	@Override
	public List<Book> findBookByClick() {
		SqlSession session = GetSqlSession.openSession();
		BookMapper mapper = session.getMapper(BookMapper.class);
		List<Book> list = mapper.findBookByClick();
		return list;
	}

	@Override
	public List<Book> selectAllBook() {
		SqlSession session = GetSqlSession.openSession();
		BookMapper mapper = session.getMapper(BookMapper.class);
		List<Book> list = mapper.selectAllBook();
		return list;
	}

	@Override
	public Book findBookById(Integer id) {
		SqlSession session = GetSqlSession.openSession();
		BookMapper mapper = session.getMapper(BookMapper.class);
		Book book = mapper.findBookById(id);
		int click = book.getClick()+1;
		book.setClick(click);
		mapper.updateBook(book);
		session.commit();
		return book;
	}

	@Override
	public List<Book> findBookByCategoryId(Integer id) {
		SqlSession session = GetSqlSession.openSession();
		BookMapper mapper = session.getMapper(BookMapper.class);
		List<Book> list = mapper.findBookByCategoryId(id);
		return list;
	}

	@Override
	public List<Book> findBookByCategoryIdWithClick(Integer id) {
		SqlSession session = GetSqlSession.openSession();
		BookMapper mapper = session.getMapper(BookMapper.class);
		List<Book> list = mapper.findBookByCategoryIdWithClick(id);
		return list;
	}
	
}
