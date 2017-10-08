package com.zzq.bookstore.book.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.zzq.bookstore.book.dao.BookDao;
import com.zzq.bookstore.book.javabean.Book;
import com.zzq.bookstore.book.service.BookService;
import com.zzq.bookstore.core.service.impl.BaseServiceImpl;
import com.zzq.bookstore.core.util.ExcelUtil;

@Service("bookService")
public class BookServiceImpl extends BaseServiceImpl<Book> implements BookService{
   
	private BookDao bookDao;
	@Resource
	public void setBaseDao(BookDao bookDao) {
		super.setBaseDao(bookDao);
		this.bookDao= bookDao;
	}
	public void exportExcel(List<Book> books, ServletOutputStream outputStream) {
		ExcelUtil.exportExcel(books, outputStream);
		
	}
	public void importExcel(File bookExcel, String bookExcelFileName) {
		try {
			FileInputStream fileInputStream = new FileInputStream(bookExcel);
			boolean excel07 = bookExcelFileName.matches("^.+\\.(?i)(xlsx)");
			// 创建工作薄
			Workbook workbook = excel07 ? new XSSFWorkbook(fileInputStream) : new HSSFWorkbook(fileInputStream);
			// 创建工作表
			Sheet sheet = workbook.getSheetAt(0);
			int rows = sheet.getPhysicalNumberOfRows();
			if (rows > 2) {
				Book book= null;
				for (int i = 2; i < rows; i++) {
					// 读取单元格
					Row row = sheet.getRow(i);
					book = new Book();
					// 书本名称
					Cell cell1 = row.getCell(0);
					book.setBname(getValue(cell1));
					// 作者
					Cell cell2=row.getCell(1);
					book.setAuthor(getValue(cell2));
					//书本价格
					Cell cell3 = row.getCell(2);
					book.setBprice(Double.parseDouble(getValue(cell3)));	
					//书本库存
					Cell cell4 = row.getCell(3);
					book.setNumber(Double.parseDouble(getValue(cell4)));
					//书本销售量
					Cell cell5 = row.getCell(4);
					book.setSale(Double.parseDouble(getValue(cell5)));
					//书本介绍
					Cell cell6= row.getCell(5);
					book.setIntroduce(cell6.getStringCellValue());
					System.out.println(book);
					save(book);
				}
			}
			workbook.close();
			fileInputStream.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
    private String getValue(Cell cell) {
        if (cell.getCellType() == cell.CELL_TYPE_BOOLEAN) {
            // 返回布尔类型的值
            return String.valueOf(cell.getBooleanCellValue());
        } else if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
            // 返回数值类型的值
            return String.valueOf(cell.getNumericCellValue());
        } else {
            // 返回字符串类型的值
            return String.valueOf(cell.getStringCellValue());
        }
    }
}
