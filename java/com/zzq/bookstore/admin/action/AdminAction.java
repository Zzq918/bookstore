package com.zzq.bookstore.admin.action;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.zzq.bookstore.admin.javabean.Admin;
import com.zzq.bookstore.admin.service.AdminService;
import com.zzq.bookstore.core.Constant;
import com.zzq.bookstore.core.action.BaseAction;

public class AdminAction extends BaseAction{
	private Admin admin;
	@Resource
	private AdminService adminService;
	private File headImg;
	private String headImgContentType;
	private String headImgFileName;
	public String list(){
		return "list";
	}
	public String loginOut(){
		ServletActionContext.getRequest().getSession().removeAttribute(Constant.LOGIN_ADMIN);
		return "loginUI";
	}
	public String updateInfo(){
		if(admin!=null){
			try {
				if(headImg!=null){
					//获取文件路径
					String path = ServletActionContext.getServletContext().getRealPath("upload/admin");
					//创建文件名称
					String fileName=UUID.randomUUID().toString().replaceAll("-", "")+headImgFileName.substring(headImgFileName.lastIndexOf("."));
					FileUtils.copyFile(headImg, new File(path,fileName));
					admin.setHeadImg("admin/"+fileName);		
				}
                adminService.update(admin);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "loginUI"; 
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public File getHeadImg() {
		return headImg;
	}
	public void setHeadImg(File headImg) {
		this.headImg = headImg;
	}
	public String getHeadImgContentType() {
		return headImgContentType;
	}
	public void setHeadImgContentType(String headImgContentType) {
		this.headImgContentType = headImgContentType;
	}
	public String getHeadImgFileName() {
		return headImgFileName;
	}
	public void setHeadImgFileName(String headImgFileName) {
		this.headImgFileName = headImgFileName;
	}
	
}
