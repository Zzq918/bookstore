package com.zzq.bookstore.admin.service;

import java.util.List;

import com.zzq.bookstore.admin.javabean.Admin;
import com.zzq.bookstore.core.service.BaseService;

public interface AdminService extends BaseService<Admin> {
    //根据用户名密码查询用户信息
	List<Admin> findByAccountAndPassword(String uname, String passWord);

}
