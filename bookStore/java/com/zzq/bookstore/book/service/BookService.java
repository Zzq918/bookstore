package com.zzq.bookstore.book.service;

import java.io.File;
import java.util.List;

import javax.servlet.ServletOutputStream;

import com.zzq.bookstore.book.javabean.Book;
import com.zzq.bookstore.core.service.BaseService;

public interface BookService extends BaseService<Book>{
    //导出书本销售情况表
	void exportExcel(List<Book> books, ServletOutputStream outputStream);
    //导入书本列表
	void importExcel(File bookExcel, String bookExcelFileName);

}
