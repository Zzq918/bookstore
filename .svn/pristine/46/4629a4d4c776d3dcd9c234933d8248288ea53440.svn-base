package com.zzq.bookstore.core.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzq.bookstore.core.Constant;

public class LoginFilter implements Filter{

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest reques, ServletResponse respons, FilterChain chain)
			throws IOException, ServletException {
      HttpServletResponse respose=(HttpServletResponse) respons;
      HttpServletRequest request=(HttpServletRequest) reques;
      String uri=request.getRequestURI();
      //不是登陆请求
      if(!uri.contains("login_")){
    	  //根据session判断用户是否在线
    	  if(request.getSession().getAttribute(Constant.LOGIN_ADMIN)!=null){
    		  chain.doFilter(request, respose);  
    	  }else{
    		  respose.sendRedirect(request.getContextPath());
    	  }
      }else{
    	chain.doFilter(request, respose);  
      }
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}
   
}
