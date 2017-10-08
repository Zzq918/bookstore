<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
    <div class="c_pate" style="margin-top: 5px;">
        <s:if test="pageResult.totalResult>0">
		<table width="100%" class="pageDown" border="0" cellspacing="0"
			cellpadding="0">
			<tr>
				<td align="right">
                 	总共<s:property value="pageResult.totalResult"/>条记录，当前第 <span class="page"><s:property  value="pageResult.curPage"/></span>页，共  <s:property value="pageResult.totalPageCount"/> 页 &nbsp;&nbsp;
                            <a id='upto' onclick="upto('<s:property value='pageResult.totalPageCount'/>')">上一页</a>&nbsp;&nbsp;
                            <a id='next2' onclick="next2('<s:property value='pageResult.totalPageCount'/>')">下一页</a>
					到&nbsp;<input id="pageNo" name="pageNo" type="text" style="width: 30px;" onkeypress="if(event.keyCode == 13){doGoPage(this.value);}" min="1"
					max="" value='<s:property value='pageResult.curPage'/>' /> &nbsp;&nbsp;
			    </td>
			</tr>
		</table>
		</s:if><s:else>
	                 当前无数据
		</s:else>	
        </div>
        <script type="text/javascript">
        //分页操作
        var page=1;
        function upto(total){
        	if(page>1){
        		page = page-1;
        		doGoPage(page);
        	}
        }
        function next2(total){
        	if(page<total){
        		page=page+1;
        		doGoPage(page);
        	}else{
        		$('#next2').hide();
        	}
        }
       
		function doGoPage(pageNo){	
		  $("#pageNo").val(pageNo);
		  $("#listadd tr:gt(0)").remove();
	  	  if(pageNo!=null){ 
	    		 var url=list_uri;
	      	     var sendData={"pageNo":pageNo};
	      	     $.post(url,sendData,function(backdata){
		      	    	var books=backdata.pageResult1;
		      	    	var page=books.curPage;
		      	    	
		      	    	$(".page").text(page);
                       var str = template('listBook',books);
                       // 使用 jq  追加到 界面上
                       $("#listadd").append(str); 
                       $('.editor').click(function () {
                           $(".banner>div").hide();
                           $('.editorUI').show();
                       }); 
	      	     });
    	    }else{
    	    	alert("请求参数为空！联系管理员");
    	    }
		}
	</script>