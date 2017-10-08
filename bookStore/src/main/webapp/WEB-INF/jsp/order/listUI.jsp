<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	pageContext.setAttribute("basePath", request.getContextPath() + "/");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
  <link rel="stylesheet" href="${basePath}/css/home.css">
  <link rel="stylesheet" href="${basePath}/css/baseLess.css">
  <link rel="stylesheet" href="${basePath}/css/goods.css">
  <script src="${basePath}/libs/jquery-1.11.1.js"></script>
  <script type="text/javascript">
    //删除
	function doDelete(id){
		 if(id!=null){ 
	    		var url="${basePath}order/order_delete.action";
	      	     var sendData={"userorder.oid":id};
	      	     $.post(url,sendData);
   	      }
	      $("#s_"+id).remove();
	}
    //确认订单
	function doPublic(oid,state){
		$.ajax({
			url:"${basePath}order/order_doPublic.action",
			data:{
				"userorder.oid":oid,
				"userorder.state":state
			},
			type:"post",
			success:function(msg){
				if("更新成功"){
					if(state == 1){//说明信息状态已经被改成 发布，状态栏显示 发布，操作栏显示 停用
  						$("#show_"+oid).html("确认订单");
  						$("#oper_"+oid).html('<a href="javascript:doPublic(\''+oid+'\',0)">取消订单</a>');
  					} else {
  						$("#show_"+oid).html("取消订单");
  						$("#oper_"+oid).html('<a href="javascript:doPublic(\''+oid+'\',1)">确认订单</a>');
  					}
				}else{
					alert("更新信息出现错误");
				}
			},error:function(){
				alert("更新信息出现错误");
			}
		});
	}
	
  </script>
<body>
    <div class="good">
    <!--导航条-->
    <div class="shortcut">
        <div class="w clearfix">
            <div class="topBarLogin">
                <a href="../index.html">网上包邮书城</a>&nbsp;&nbsp;
                <a href="user.html"><s:property value='#session.admin.mname'/>,欢迎你</a>
            </div>
            <div class="topChoice">
                <a href="JavaScript:history.go(-1)">返回</a>
                <a href="javascript:location.reload();">刷新</a>
                <a href="${basePath}admin/admin_loginOut.action">注销</a>
            </div>
        </div>
    </div>

    <div class="main w clearfix" >
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
            </div>
        </div>


        <!--右边用来显示的模版区域-->
        <div class="banner" >
            <div class="goodsShow">
                <!--订单信息-->
                <form class="ware" id="s">
                <s:iterator value="pageResult.items">
                    <table id="s_<s:property value="oid" />"class="ware" cellspacing="0">
                        <thead>
                        <tr class="order">
                            <th>订单编号</th>
                            <th>用户名</th>
                            <th>书名</th>
                            <th>价格</th>
                            <th>地址</th>
                            <th>联系方式</th>
                            <th>状态</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr class="info">
                            <td><s:property value="oid" /></td>
                            <td class="title"><s:property value="uid" /></td>
                            <td><s:property value="bname" /></td>
                            <td><s:property value="bprice" /></td>
                            <td><s:property value="address" /></td>
                            <td><s:property value="relation" /></td>
                            <td id="show_<s:property value='oid'/>"><s:property value="state==1?'确认订单':'取消订单'"/> </td>
                            <td class="tdLast">
                               <span  id="oper_<s:property value='oid'/>">
                               	   <s:if test="state==1">
                               		  <a class="btn" href="javascript:doPublic('<s:property value='oid'/>',0)">取消订单</a>
                               	   </s:if>
                               	   <s:else>
                               	      <a class="btn" href="javascript:doPublic('<s:property value='oid'/>',1)">确认订单</a>
                               	   </s:else>
                               	</span>
                                <a class="delete btn" href="javascript:doDelete('<s:property value='oid'/>')">删除</a>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                  </s:iterator>
                </form>

                <table class="pageChange ware pageDown"cellspacing="0">
                <s:if test="pageResult.totalResult>0">
                <table width="100%" class="pageDown" border="0" cellspacing="0"
			      cellpadding="0">
                    <tr class="link">
                        <td align="right">
                                                      总共<span><s:property value="pageResult.totalResult"/></span>条记录，
                                                      当前第 <span class="page"><s:property  value="pageResult.curPage"/></span>页，
                                                      共 <span><s:property value="pageResult.totalPageCount"/> </span> 页 &nbsp;&nbsp;
                             <s:if test="pageResult.curPage>1">
                            <a id='upto' href="javascript:doGoPage('<s:property value="pageResult.curPage-1"/>')">上一页</a>
                            </s:if>&nbsp;&nbsp;
                            <s:if test="pageResult.curPage<pageResult.totalPageCount">
                            <a id='next2' href="javascript:doGoPage('<s:property value="pageResult.curPage+1"/>')">下一页</a>
                            </s:if>&nbsp;&nbsp;到&nbsp;
                            <input class="pag" id="pageNo" name="pageNo" type="text" onkeypress="if(event.keyCode == 13){doGoPage(this.value);}" min="1" max="" value='1' /> &nbsp;页
                        </td>
                    </tr>
                </table>
                </s:if>
                <s:else>
			                 当前无数据
				</s:else>
            </div>
        </div>
    </div>
</div>
  <script type="text/javascript">
        //分页操作
		function doGoPage(pageNo){
			document.getElementById("pageNo").value=pageNo;
			var s=document.getElementById("s");
	  	    s.action=list_uri;
	  	    s.submit(); 
		}
	</script>
</body>
</html>