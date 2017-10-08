<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%
	pageContext.setAttribute("basePath", request.getContextPath() + "/");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员页面</title>
<link rel="stylesheet" href="${basePath}/css/baseLess.css">
<link rel="stylesheet" href="${basePath}/css/home.css">
<script type="text/javascript" src="${basePath}/libs/jquery-1.11.1.js"></script>
<script type="text/javascript" src="${basePath}/libs/template-native.js"></script>
<script type="text/javascript" src="${basePath}/js/home.js"></script>
</head>
<body>
	<div class="home">
		<!--导航条-->
		<div class="shortcut">
			<div class="w clearfix">
				<div class="topBarLogin">
					<a href="###">网上包邮书城</a>&nbsp;&nbsp; <a href="###">免费注册</a>
				</div>
				<div class="topChoice">
					<a href="JavaScript:history.go(-1)">返回</a> <a
						href="javascript:location.reload();">刷新</a> <a
						href="${basePath}admin/admin_loginOut.action">注销</a>
				</div>
			</div>
		</div>

		<!--左边的账号列表-->
		<div class="main w clearfix">
			<div class="homeName ">
            <a class="head" href="###"> <img src="${basePath }upload/<s:property value='#session.admin.headImg'/>">
            </a>
            <div class="homeName-info">
                <p>
                    店铺名称：<span class="info"><s:property value='#session.admin.name 


' /></span>
                </p>
                <p>
                    昵称：<span class="info"><s:property value='#session.admin.mname' /></span>
                </p>
                <p>
                    账户：<span class="info"><s:property value='#session.admin.balance' /></span>
                </p>
                <p>
                    联系方式：<span class="info"><s:property value='#session.admin.phone' /></span>
                </p>
                <div class="link">
                    <a href="${basePath }book/book_listUI.action" id="selectBook">书库信息</a>
                    <a href="${basePath}order/order_listUI.action" id="selectOrder">收到订单</a>
                </div>
                <div class="adminMg">
                    <input id="oneP" class="adminMg-btn" type="button" value="个人中心">
                </div>
            </div>
        </div>
	<script>
				    $('#oneP').click(function () {
				        $('.welcome').hide();
				        $('.adminEditor').show();
				    });
				</script>
			<!--右边用来显示的模版区域-->
			<div class="banner">
				<!--网页默认欢迎信息-->
				<div class="welcome">
					<div class="welcomeName">
						<span>小强：</span>好久没来了
					</div>
					<div class="welcomeImg">
						<img src="../images/homeLike.jpg" alt="">
					</div>
				</div>
				<div class="adminEditor">
					<div class="mc">
						<form class="index" action="${basePath}admin/admin_updateInfo.action" method="post" enctype="multipart/form-data">
							<table class="stack" cellspacing="0">
								<tr>
									<th>店铺名称：</th>
									<td><input type="text" name="admin.name" value='<s:property value='#session.admin.name'/>'></td>
								</tr>
								<tr>
									<th>昵称：</th>
									<td><input type="text" name="admin.mname" value='<s:property value='#session.admin.mname'/>'></td>
								</tr>
								<tr>
									<th>联系方式：</th>
									<td><input type="text" name="admin.phone" value='<s:property value='#session.admin.phone'/>'></td>
								</tr>
								<tr>
									<th>账户：</th>
									<td><input type="text" name="admin.uname" value='<s:property value='#session.admin.uname'/>'></td>
								</tr>
								<tr>
									<th>密码：</th>
									<td><input type="password" name="admin.passWord" value='<s:property value='#session.admin.passWord'/>'></td>
								</tr>
								<tr>
									<th>头像：</th>
									<td class="clearfix"> 
									<c:set var="isImg" value="${not empty sessionScope.admin.headImg}"/>
									<c:if test="${isImg}">
									   <img src="${basePath }/upload/<s:property value='#session.admin.headImg'/>" width="100" height="100"/>
									   <s:hidden name="headImg"></s:hidden>
									 </c:if>
	                                     <input type="file" name="headImg"/>
                                    </td>
								</tr>
								<input type="hidden" name="admin.AId" value='<s:property value='#session.admin.AId'/>'/>
								<div class="change">
									<input type="submit" value="确认" class="btn"> <input type="button" value="取消" class="btn">
								</div>
							</table>

						</form>
					</div>
				</div>
			</div>
		</div>
</body>
</html>