package com.zzq.bookstore.core.util;

import java.util.List;

import javax.servlet.ServletOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;

import com.zzq.bookstore.admin.javabean.Admin;
import com.zzq.bookstore.book.javabean.Book;


public class ExcelUtil {
	public static void exportExcel(List<Book> books, ServletOutputStream outputStream) {

		try {
			//1、创建工作簿  为了兼容创建03版本的工作薄
			 HSSFWorkbook workbook = new HSSFWorkbook();
			//1.1、创建合并单元格对象   参数含义 起始行  结束行  起始列 结束列
			 CellRangeAddress cellRangeAddress = new CellRangeAddress(0, 0, 0, 5); 
			//1.2、头标题样式
			 HSSFCellStyle headStyle = CreatedFont(workbook,(short)16);
			 //1.3、列标题样式
			 HSSFCellStyle lineStyle = CreatedFont(workbook, (short)13); 
			//
			//2、创建工作表
			 HSSFSheet sheet = workbook.createSheet("图书列表");
			//2.1、加载合并单元格对象
			 sheet.addMergedRegion(cellRangeAddress);
			//3、创建行
			 HSSFRow row0 = sheet.createRow(0);
			 sheet.setDefaultColumnWidth(23);
			//3.1、创建头标题行；并且设置头标题
			 HSSFCell cell0 = row0.createCell(0);
			 cell0.setCellStyle(headStyle);
			 cell0.setCellValue("图书销售情况表");
			//3.2、创建列标题行；并且设置列标题
			 HSSFRow row1 = sheet.createRow(1);
			 String[]lines={"编号","书名","作者","价格","库存","销售额"};
			 for(int j=0;j<lines.length;j++){
				HSSFCell cell1 = row1.createCell(j);
				cell1.setCellStyle(lineStyle);
				cell1.setCellValue(lines[j]);
			 }
			 //操作单元格，将用户写入Excel
			 if(books!=null){
				for(int i=0;i<books.size();i++){
					HSSFRow row2 = sheet.createRow(i+2);
					HSSFCell cell2 = row2.createCell(0);
					cell2.setCellValue(books.get(i).getBid());
					HSSFCell cell3 = row2.createCell(1);
					cell3.setCellValue(books.get(i).getBname());
					HSSFCell cell4 = row2.createCell(2);
					cell4.setCellValue(books.get(i).getAuthor());
					HSSFCell cell5 = row2.createCell(3);
					cell5.setCellValue(books.get(i).getBprice());
					HSSFCell cell6 = row2.createCell(4);
					cell6.setCellValue(books.get(i).getNumber());
					HSSFCell cell7 = row2.createCell(5);
					cell7.setCellValue(books.get(i).getSale());
				}
			 }	
			//5、输出
			 workbook.write(outputStream);
			 workbook.close();
			 //
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 创建单元格样式
	 * @param workbook 工作簿
	 * @param fontsize 字体大小
	 * @return 单元格样式
	 */
	private static HSSFCellStyle CreatedFont(HSSFWorkbook workbook, short fontsize) {
		// TODO Auto-generated method stub
		 HSSFCellStyle cellStyle = workbook.createCellStyle();
		 cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		 cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		 HSSFFont font = workbook.createFont();
		 font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		 font.setFontHeightInPoints((short)fontsize);
		 cellStyle.setFont(font);
		 return cellStyle;
	}   
}
