package com.zzq.bookstore.admin.dao;

import java.util.List;

import com.zzq.bookstore.admin.javabean.Admin;
import com.zzq.bookstore.core.dao.BaseDao;

public interface AdminDao extends BaseDao<Admin> {
     /**
      * //根据管理员用户名密码查询用户信息
      * @param uname   用户名
      * @param passWord   密码
      * @return   管理员类列表
      */
	List<Admin> findByAccountAndPassword(String uname, String passWord);

}
