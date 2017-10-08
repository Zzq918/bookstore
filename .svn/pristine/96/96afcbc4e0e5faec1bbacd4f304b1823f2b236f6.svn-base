package com.zzq.bookstore.login;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zzq.bookstore.admin.javabean.Admin;
import com.zzq.bookstore.admin.service.AdminService;
import com.zzq.bookstore.core.Constant;

public class Login extends ActionSupport{
	@Resource
	 private AdminService adminService;
	 private Admin admin;
	 private String result;
    public String login(){
   		if (admin != null) {
   			if (StringUtils.isNotBlank(admin.getUname()) && StringUtils.isNotBlank(admin.getPassWord())) {
   				// 查询用户信息
   				List<Admin> list = adminService.findByAccountAndPassword(admin.getUname(),admin.getPassWord());
   				if (list != null && list.size() > 0) {
   					// 登陆成功
   					Admin admin = list.get(0);
   					// 将用户保存到session中
   					ServletActionContext.getRequest().getSession().setAttribute(Constant.LOGIN_ADMIN, admin);
   					// 写入日志文件
   					Log log = LogFactory.getLog(getClass());
   					log.info("用户名称为：" + admin.getUname() + "的用户登陆了系统");
   					//跳转到管理员页面
   					return "list";
   				} else {
   					result = "账户或密码不正确！";
   				}
   			}
   		} 
   		return loginUI();
    }
  
    public String loginUI(){
   	 return "loginUI";
    }
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
    

}
