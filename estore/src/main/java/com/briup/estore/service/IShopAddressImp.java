package com.briup.estore.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.ShopAddress;
import com.briup.estore.dao.ShopAddressMapper;
import com.briup.estore.util.GetSqlSession;

public class IShopAddressImp implements IShopAddressService{

	@Override
	public List<ShopAddress> selectAddressByCustId(int id) {
		SqlSession session = GetSqlSession.openSession();
		ShopAddressMapper mapper = session.getMapper(ShopAddressMapper.class);
		List<ShopAddress> list = mapper.selectAddressByCustId(id);
		return list;
	}

	@Override
	public ShopAddress selectAddressById(int id) {
		SqlSession session = GetSqlSession.openSession();
		ShopAddressMapper mapper = session.getMapper(ShopAddressMapper.class);
		ShopAddress address = mapper.selectAddressById(id);
		return address;
	}

	
}
