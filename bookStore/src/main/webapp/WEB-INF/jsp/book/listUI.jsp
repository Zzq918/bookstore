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
<link rel="stylesheet" href="${basePath}/css/baseLess.css">
<link rel="stylesheet" href="${basePath}/css/home.css">
<link rel="stylesheet" href="${basePath}/css/homeBook.css">
<script type="text/javascript" src="${basePath}/libs/jquery-1.11.1.js"></script>
<script type="text/javascript" src="${basePath}/libs/template-native.js"></script>
<script type="text/javascript" src="${basePath}/js/home.js"></script>
<script type="text/javascript">
	 var list_uri="${basePath}book/book_getlimtQuery.action"
	      	//全选、全反选
			function doSelectAll(){
		        $("input[name=selectedRow]").prop("checked", $("#selAll").is(":checked"));	
			}
	       //添加操作
	       function doAdd(){
	    	   $('.banner>div').hide();
	           $('.addUI').show();
	       }
	    	//更新
	      	function doEdit(id){
	      	    if(id!=null){ 
		    		var url="${basePath}book/book_updateUI.action";
		      	     var sendData={"book.bid":id};
		      	     $.post(url,sendData,function(backdata){
			      	    	 var book=backdata.jsonBook;
			      	    	 console.log(book);
	                         var str = template('template',book);

	                         // 使用 jq  追加到 界面上
	                         $("#edit").append(str);
		      	     });
	      	    }else{
	      	    	alert("请求参数为空！联系管理员");
	      	    }
	      	    
	      	  $('.banner>div').hide();
	          $('.editorUI').show();
	      	}
	    	//删除
	    	function doDelete(id){
	    		var x=document.getElementById("s");
	      	    x.action="${basePath}book/book_delete.action?book.bid="+id;
	      	    x.submit();  
	    	}
	    	//批量删除
	    	function doDeleteAll(){
	    		var x=document.getElementById("s");
	      	    x.action="${basePath}book/book_deleteFetch.action";
	      	    x.submit();
	    	}
	    	//导出数据到Excel
	    	function doExportExcel(){
	    		window.open("${basePath}book/book_exportExcel.action")
	    	}
	    	//导入数据
	    	function doImportExcel(){
	    		var f=$("input[name='bookExcel']").val();
	    		if(f.length!=0){
		    	    var x=document.getElementById("s");
		      	    x.action="${basePath}book/book_importExcel.action";
		      	    x.submit(); 
	    		}else{
	    			alert("请添加相应格式的Excel文件");
	    		}
	    	}
	    	//搜索事件
	    	function doSearch(){
	    		var x=document.getElementById("s");
	      	    x.action="${basePath}book/book_listUI.action";
	      	    x.submit(); 
	    	}

  
    </script>
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
						href="javascript:location.reload();">刷新</a> <a href="${basePath}admin/admin_loginOut.action">注销</a>
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
            </div>
        </div>

			<!--右边用来显示的模版区域-->
			<div class="banner">

				<!--点击书库之后显示书库信息-->
				<div id="list" class="list">
					<form class="index" id="s" method="post"
						enctype="multipart/form-data">
						<div class="navigation clearfix">
							<div class="search">
								<s:textfield name="book.bname" id="search" placeholder="请输入书名搜索" />
								<input type="button" value="搜索" onclick="doSearch()">
							</div>
							<div class="link">
								<a class="addLink" id="add" onclick="doAdd()">新增</a> <a class="addLink"
									href="javascript:doDeleteAll();">删除</a> <input id="leading"
									type="file" name="bookExcel"> <a class="addLink"
									href="javascript:doImportExcel();">导入</a> <a class="addLink"
									href="javascript:doExportExcel();">导出</a>
							</div>
						</div>
						<table class="stack" id="listadd" cellspacing="0">
							<tr>
								<th><input class="check"  id="selAll" type="checkbox"
									onclick="doSelectAll()"></th>
								<th>书名</th>
								<th>作者</th>
								<th>价格</th>
								<th>库存</th>
								<th>销售量</th>
								<th>操作</th>
							</tr>
							<s:iterator value="pageResult.items">
								<tr>
									<td><input class="check" type="checkbox"
										name="selectedRow" value='<s:property value='bid'/>' /></td>
									<td><s:property value="bname" /></td>
									<td><s:property value="author" /></td>
									<td><s:property value="bprice" /></td>
									<td><s:property value="number" /></td>
									<td><s:property value="sale" /></td>
									<td><input class="editor" type="button" value="编辑"
										onclick="doEdit('<s:property value='bid'/>')"> <input
										class="delete" type="button" value="删除"
										onclick="doDelete('<s:property value='bid'/>')"></td>
								</tr>
							</s:iterator>

						</table>
					</form>
					<jsp:include page="/common/pageNavigate.jsp"></jsp:include>
				</div>

				<!--新增页面-->
				<div class="addUI bookName">
					<div class="cue">添加书本信息</div>
					<form action="${basePath }book/book_add.action" method="post"
						enctype="multipart/form-data">
						<table class="items">
							<tr class="item">
								<td class="nature">书名</td>
								<td><s:textfield name="book.bname" /></td>
							</tr>
							<tr class="item">
								<td class="nature">作者</td>
								<td><s:textfield name="book.author" /></td>
							</tr>
							<tr class="item">
								<td class="nature">价格</td>
								<td><s:textfield name="book.bprice" /></td>
							</tr>
							<tr class="item">
								<td class="nature">库存</td>
								<td><s:textfield name="book.number" /></td>
							</tr>
							<tr class="item">
								<td class="nature">书图片</td>
								<td><input type="file" name="bimg"></td>
							</tr>
							<tr class="item">
								<td class="nature">介绍</td>
								<td><s:textarea class="introduce" name="book.introduce" /></td>
							</tr>
							<tr class="item dope">
								<td class="click"><input class="btn" type="submit"
									id="confirm" value="确认"/></td>
								<td class="click"><a class="btn" id="cancel" class="click"
									href=###"">返回</a></td>
							</tr>
						</table>
					</form>
				</div>
				<!--编辑界面-->

				<div class="editorUI ">
					<div class="cue">编辑书本</div>
					<div id="edit"></div>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/template" id='template'>
   <form action="${basePath}book/book_update.action" method="post" enctype="multipart/form-data">
       <table class="items">
           <tr class="item">
               <td class="nature">书 名</td>
               <td><input type="text" name="book.bname" value="@?=bname?"></td>
           </tr>
           <tr class="item">
               <td class="nature">作者</td>
               <td><input type="text" name="book.author" value="@?=author?"></td>
           </tr>
           <tr class="item">
               <td class="nature">价格</td>
               <td><input type="text" name="book.bprice" value="@?=bprice?"></td>
           </tr>
           <tr class="item">
           <td class="nature">库存</td>
           <td><input type="text" name="book.number" value="@?=number?"></td>
       </tr>
           <tr class="item">
               <td class="nature">书图</td>
               <td>

                    <img src="${basePath}upload/@?=bimg?" width="100" height="100"/>
                    <input type="file" name="book.bimg"></td>
           </tr>
           <tr class="item ">
               <td class="nature">介绍</td>
               <td>
                   <textarea class="introduce" name="book.introduce">@?=introduce?</textarea>
               </td>
           </tr>
           <input type="hidden" name="book.bid" value="@?=bid?">
           <input type="hidden" name="book.sale" value="@?=sale?">
           <tr class="item dope">
               <td class="click">
                   <input class="btn" type="submit" value="确认">
               </td>
               <td class="click">
                   <a href="javascript:location.reload();" class="btn back">取消</a>
               </td>
           </tr>
       </table>
   </form>
</script>
<script type="text/template" id="listBook">
    @?for(var i=0;i<items.length;i++){?
    <tr>
        <td><input class="check" type="checkbox" name="selectedRow" value="@?=items[i].bid?/"></td>
        <td class="title">@?=items[i].bname?</td>
        <td>@?=items[i].author?</td>
        <td>@?=items[i].bprice?</td>
        <td>@?=items[i].number?</td>
        <td>@?=items[i].sale?</td>
        <td>
            <input  class="editor" type="button" onclick="doEdit('@?=items[i].bid?')" value="编辑">
            <input class="delete" type="button" onclick="doDelete('@?=items[i].bid?')" value="删除">
        </td>
    </tr>
    @?}?

</script>

</html>