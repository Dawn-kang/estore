package com.briup.estore.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.Category;
import com.briup.estore.dao.CategoryMapper;
import com.briup.estore.util.GetSqlSession;

public class ICategoryImp implements ICategoryService{

	@Override
	public List<Category> findFirstWithSecondCategory() {
		SqlSession session = GetSqlSession.openSession();
		CategoryMapper mapper = session.getMapper(CategoryMapper.class);
		List<Category> list = mapper.selectFirstCategory();
		return list;
	}

}
