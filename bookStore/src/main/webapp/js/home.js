

// 点击新增页面，在本页显示一个输入页，输入信息，点击关闭后重新回到主页面
$(document).ready(function(){

    var divAll = $('.banner>div');
    // 除了欢迎页面，其他全部隐藏
    divAll.hide();
    $('.list').show();
    // 书库信息
    
    
    function fn() {
        divAll.hide();
        $('.list').show();
    }
    $('#selectBook').click(function () {
        // divAll.hide();
        // $('.list').show();
        fn();
    });
    
    // 新增信息
    $('#add').click(function () {
    	alert(1);
        divAll.hide();
        $('.addUI').show();
    });
    
    $('.editor').click(function () {
        divAll.hide();
        $('.editorUI').show();
    });

    // 确认增加
    $('.login').click(function () {
        divAll.hide();
        $('.list').show();
        console.log('榜上的了');
    });

    $('.back').click(function () {
        divAll.hide();
        $('#list').show();
        console.log(1);
    });
    
    // 新增UI页，确认返回
    $('#confirm').click(function () {
    	
        divAll.hide();
        $('#list').show();
    });
    $('#cancel').click(function () {
        divAll.hide();
        $('#list').show();
    });
}
