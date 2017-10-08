package com.zzq.bookstore.book.action;

import com.zzq.bookstore.book.javabean.Book;
import com.zzq.bookstore.book.service.BookService;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.zzq.bookstore.core.action.BaseAction;
import com.zzq.bookstore.core.page.PageResult;
import com.zzq.bookstore.core.util.QueryHelper;

public class BookAction extends BaseAction {
	@Resource 
	private BookService bookService;
	private Book book;
	private Book jsonBook;
    private String strBname;
    private File bookExcel;
	private String bookExcelContentType;
	private String bookExcelFileName;
	private PageResult pageResult1;
	private File bimg;
	private String bimgContentType;
	private String bimgFileName;

	public String listUI(){
		QueryHelper queryHelper = new QueryHelper(Book.class, "b");
		try {
			if(book!=null){
				if(StringUtils.isNotBlank(book.getBname())){
					book.setBname(URLDecoder.decode(book.getBname(),"utf-8"));
					queryHelper.addCondition("b.bname like ?","%"+ book.getBname() +"%");
				}
			}
			pageResult = bookService.getPageResult(queryHelper,getPageNo(),getPageSize());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "listUI";
	}
	//返回展示页面
	public String add(){
		try {
			if(book!=null){
				if(bimg!=null){
					//获取文件路径
					String path = ServletActionContext.getServletContext().getRealPath("upload/book");
					//创建文件名称
					String fileName=UUID.randomUUID().toString().replaceAll("-", "")+bimgFileName.substring(bimgFileName.lastIndexOf("."));
					FileUtils.copyFile(bimg, new File(path,fileName));
					book.setBimg("book/"+fileName);
					
				}
				book.setSale(0.0);
				bookService.save(book);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "list";
	}
	//跳转更新页面
	public String updateUI(){
		if(book.getBid()!=null){
			//解决查询条件覆盖问题
			//setStrBname(Book.getBname());
			jsonBook = bookService.findObjectById(book.getBid());
		}
		return SUCCESS;
	}
	//执行更新操作
	public String update(){
			try {
				if(book!=null){
					if(bimg!=null){
						//获取文件路径
						String path = ServletActionContext.getServletContext().getRealPath("upload/book");
						//创建文件名称
						String fileName=UUID.randomUUID().toString().replaceAll("-", "")+bimgFileName.substring(bimgFileName.lastIndexOf("."));
						FileUtils.copyFile(bimg, new File(path,fileName));
						book.setBimg("book/"+fileName);		
					}
				   bookService.update(book);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return "list";
	}
	//删除
	public String delete(){
		if(book.getBid()!=null && book!=null){
			   //setStrBname(Book.getBname());
			   book= bookService.findObjectById(book.getBid());
		       bookService.delete(book);
		}
		return "list";
	}
	
	//批量删除
	public String deleteFetch(){
		if(selectedRow!=null){
			for(String s:selectedRow){
				//setStrBname(Book.getBname());
				book= bookService.findObjectById(s);
			    bookService.delete(book);
			}
		}
		return "list";
	}
	// 导出数据
		public void exportExcel() {
			try {
				// 查找所有的用户列表
				// 导出
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setContentType("application/x-execl");
				response.setHeader("Content-Disposition",
						"attachment;filename=" + new String("书库销售列表.xls".getBytes(), "ISO-8859-1"));
				ServletOutputStream outputStream = response.getOutputStream();
				bookService.exportExcel(bookService.findObject(), outputStream);
				if (outputStream != null) {
					outputStream.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 导入数据
		public String importExcel() {
			if (bookExcel != null) {
				if (bookExcelFileName.matches("^.+\\.(?i)((xls)|(xlsx))$")) {
					bookService.importExcel(bookExcel, bookExcelFileName);
				}
			}
			return "list";
		}

    public String getlimtQuery(){
    	QueryHelper queryHelper = new QueryHelper(Book.class, "b");
		try {
			pageResult1 = bookService.getPageResult(queryHelper,getPageNo(),getPageSize());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
    }
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public String getStrBname() {
		return strBname;
	}
	public void setStrBname(String strBname) {
		this.strBname = strBname;
	}
	public File getBookExcel() {
		return bookExcel;
	}
	public void setBookExcel(File bookExcel) {
		this.bookExcel = bookExcel;
	}
	public String getBookExcelContentType() {
		return bookExcelContentType;
	}
	public void setBookExcelContentType(String bookExcelContentType) {
		this.bookExcelContentType = bookExcelContentType;
	}
	public String getBookExcelFileName() {
		return bookExcelFileName;
	}
	public void setBookExcelFileName(String bookExcelFileName) {
		this.bookExcelFileName = bookExcelFileName;
	}
	public Book getJsonBook() {
		return jsonBook;
	}
	public PageResult getPageResult1() {
		return pageResult1;
	}
	public File getBimg() {
		return bimg;
	}
	public void setBimg(File bimg) {
		this.bimg = bimg;
	}
	public String getBimgContentType() {
		return bimgContentType;
	}
	public void setBimgContentType(String bimgContentType) {
		this.bimgContentType = bimgContentType;
	}
	public String getBimgFileName() {
		return bimgFileName;
	}
	public void setBimgFileName(String bimgFileName) {
		this.bimgFileName = bimgFileName;
	}
	
	
}
