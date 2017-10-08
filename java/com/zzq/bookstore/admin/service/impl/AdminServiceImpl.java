package com.zzq.bookstore.admin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zzq.bookstore.admin.dao.AdminDao;
import com.zzq.bookstore.admin.javabean.Admin;
import com.zzq.bookstore.admin.service.AdminService;
import com.zzq.bookstore.core.service.impl.BaseServiceImpl;

@Service("adminService")
public class AdminServiceImpl extends BaseServiceImpl<Admin> implements AdminService{
    private AdminDao adminDao;
    @Resource
    public void setBaseDao(AdminDao adminDao) {
    	super.setBaseDao(adminDao);
    	this.adminDao=adminDao;
    }
	public List<Admin> findByAccountAndPassword(String uname, String passWord) {
		return adminDao.findByAccountAndPassword(uname,passWord);
	}
}
