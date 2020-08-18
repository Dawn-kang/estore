package com.briup.estore.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.Customer;
import com.briup.estore.dao.CustomerMapper;
import com.briup.estore.util.GetSqlSession;

public class ICustomerImp implements ICustomerService{

	@Override
	public void register(Customer customer) throws Exception {
		SqlSession session = GetSqlSession.openSession();
		CustomerMapper mapper = session.getMapper(CustomerMapper.class);
		//通过名字来查询数据库用户，若查询出来的集合对象大于0则表明该用户已存在
		//用户名已存在则继抛出用户名已存在的错误信息，否则将该用户写入到数据库用户表中
		List<Customer> list = mapper.selectCustomerByName(customer.getName());
		if(list.size()>0) {
			throw new Exception("该用户名已存在，请重新注册!"); 
		}else {
			mapper.insertCustomer(customer);
			session.commit();
		}
	}

	@Override
	public Customer login(String name, String password) throws Exception {
		SqlSession session = GetSqlSession.openSession();
		CustomerMapper mapper = session.getMapper(CustomerMapper.class);
		List<Customer> list = mapper.selectCustomerByName(name);
		//若通过用户名查询到数据库用户信息则继续比较密码是否正确
		//否则抛出用户名不存在异常
		if(list.size()>0) {
			Customer cust = list.get(0);
			if(cust.getPassword().equals(password)) {
				return cust;
			}else {
				throw new Exception("密码错误，请重新输入！");
			}
		}else {
			throw new Exception("用户名不存在，请重新输入！");
		}
	}

	
}
