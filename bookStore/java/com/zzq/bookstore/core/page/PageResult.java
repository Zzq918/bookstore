package com.zzq.bookstore.core.page;

import java.util.ArrayList;
import java.util.List;

public class PageResult {
	//总记录数
	private long totalResult;
	//当前页号
	private int curPage;
	//总页数
	private int totalPageCount;
	//页大小
	private int pageResult;
	//列表记录
	private List items;
     
	public PageResult(long totalResult, int curPage, int pageResult, List items) {
		this.items = items==null?new ArrayList():items;
		this.totalResult = totalResult;
		this.pageResult = pageResult;
		if(totalResult!=0){
			int emp=(int) (totalResult/pageResult);
			this.totalPageCount=(totalResult%pageResult)==0?emp:emp+1;
			this.curPage = curPage;
		}else{
			this.curPage=0;
		}
	}
	public long getTotalResult() {
		return totalResult;
	}
	public void setTotalResult(long totalResult) {
		this.totalResult = totalResult;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	
	public int getTotalPageCount() {
		return totalPageCount;
	}
	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	public int getPageResult() {
		return pageResult;
	}
	public void setPageResult(int pageResult) {
		this.pageResult = pageResult;
	}
	public List getItems() {
		return items;
	}
	public void setItems(List items) {
		this.items = items;
	}
	
	
}
