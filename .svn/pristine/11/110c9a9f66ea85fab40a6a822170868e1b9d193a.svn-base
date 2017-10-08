package com.zzq.bookstore.core.util;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

public class ResponseWrite {
	public static void write(Object o,HttpServletResponse response)throws Exception{
		response.setContentType("text/html;charset=utf-8");
		ServletOutputStream outputStream = response.getOutputStream();
		outputStream.write(o.toString().getBytes());
		outputStream.flush();
		outputStream.close();
	}
}
