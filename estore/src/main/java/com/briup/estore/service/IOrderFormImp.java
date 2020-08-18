package com.briup.estore.service;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.OrderForm;
import com.briup.estore.dao.OrderFormMapper;
import com.briup.estore.util.GetSqlSession;

public class IOrderFormImp implements IOrderFormService{

	@Override
	public void insertOrderForm(OrderForm orderForm) {
			SqlSession session = GetSqlSession.openSession();
			OrderFormMapper mapper = session.getMapper(OrderFormMapper.class);
			mapper.insertOrderForm(orderForm);
			session.commit();
	}

}
