<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	pageContext.setAttribute("basePath", request.getContextPath() + "/");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>欢迎登录</title>
    <link rel="stylesheet" href="${basePath}/css/baseLess.css">
    <link rel="stylesheet" href="${basePath}/css/login.css">
    <script src="${basePath}/libs/jquery-1.11.1.js"></script>
</head>
<script type="text/javascript">
   function tologin(){
	   var userName=$("#userName").val();
	   var passWord=$("#passWord").val();

   }
</script>
<body>
    <div class="login">
        <div class="header">
            <div class="w clearfix">
                <div class="logo">
                    <a href="../index.html">包邮书城</a>
                    <b>欢迎登录</b>
                </div>
                <a class="q-link" href="../index.html">去首页</a>
            </div>
        </div>

        <div class="content">
            <div class="login-warp">
                <div class="w clearfix">

                    <div class="login-form">
                        <div class="login-tab">
                            <a href="login.html">账号登录</a>
                        </div>
                        <div class="login-tab login-tab-r">
                            <a href="login.html">扫码登录</a>
                        </div>
                        <div class="login-box">
                            <form class="form" action="${basePath}login_login.action" method="post">
                                <div class="item">
                                    <label>账  号:</label>
                                    <input id="userName" name="admin.uname" type="text">
                                </div>
                                <div class="item">
                                    <label>密 码:</label>
                                    <input id="passWord" name="admin.passWord" type="password">
                                </div>
                                <div class="item clearfix">
                                   <input id="login" class="btn" type="submit" value="登陆">
                                    <a class="btn" href="javascript:history.back(-1)">返&nbsp;回</a>
                                </div>
                            </form>
                        </div>
                        <div class="login-bt">
                            <ul>
                                <li><a href="###">QQ</a></li>
                                <li><a href="###">微信</a></li>
                                <li><a href="reg.html">立即注册</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>