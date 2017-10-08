package com.zzq.bookstore.order.action;

import java.net.URLDecoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.zzq.bookstore.admin.javabean.Userorder;
import com.zzq.bookstore.core.page.PageResult;
import com.zzq.bookstore.core.util.QueryHelper;
import com.zzq.bookstore.core.util.ResponseWrite;
import com.zzq.bookstore.order.service.OrderService;

public class OrderAction {
	@Resource
	private OrderService orderService;
    private PageResult pageResult;
	private int pageNo;
	private int pageSize;
	private static int PAGE_SIZE=4;
	private Userorder userorder;
     public String listUI(){
    	 QueryHelper queryHelper = new QueryHelper(Userorder.class, "u");
 		try {
 			pageResult = orderService.getPageResult(queryHelper,getPageNo(),getPageSize());
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
    	 return "listUI";
     }	
	
 	//删除
 	public String delete(){
 		if(userorder.getOid()!=null && userorder!=null){
 			   //setStrBname(Book.getBname());
 			   userorder= orderService.findObjectById(userorder.getOid());
 		       orderService.delete(userorder);
 		}
 		return "list";
 	}
    public void  doPublic(){
    	try {
			if(userorder.getOid()!=null){
			   Userorder  tem =orderService.findObjectById(userorder.getOid());
			   tem.setState(userorder.getState());
			   orderService.update(tem);
			   HttpServletResponse response = ServletActionContext.getResponse();
			   ResponseWrite.write("更新成功", response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

	public PageResult getPageResult() {
		return pageResult;
	}
	public void setPageResult(PageResult pageResult) {
		this.pageResult = pageResult;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		if(pageSize < 1) pageSize =PAGE_SIZE;
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public Userorder getUserorder() {
		return userorder;
	}
	public void setUserorder(Userorder userorder) {
		this.userorder = userorder;
	}
	
}
