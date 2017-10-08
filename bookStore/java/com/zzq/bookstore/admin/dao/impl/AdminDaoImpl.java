package com.zzq.bookstore.admin.dao.impl;

import java.util.List;

import com.zzq.bookstore.admin.dao.AdminDao;
import com.zzq.bookstore.admin.javabean.Admin;
import com.zzq.bookstore.core.dao.impl.BaseDaoImpl;

public class AdminDaoImpl extends BaseDaoImpl<Admin> implements AdminDao{

	public List<Admin> findByAccountAndPassword(String uname, String passWord) {
		String hql="FROM Admin a where a.uname=? AND a.passWord=?";
		@SuppressWarnings("unchecked")
		List<Admin> list = currentSession().createQuery(hql).setParameter(0, uname).setParameter(1, passWord).list();
		return list;
	}

}
