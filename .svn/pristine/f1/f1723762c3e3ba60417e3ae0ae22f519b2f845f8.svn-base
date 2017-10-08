/**
 * Created by Administrator on 2017/9/2/002.
 */

$(document).ready(function () {

    /*获取存放轮播图盒子的宽高*/

    var $pic = $('.pic');

    var picWidth = $pic.width();
    var picHeight = $pic.height();

// 该类内的ul，li的样式

    var moveUl = $('.pic ul');

    var liArr = $('.pic li');


// 设置计速器
    var index = 1;

    /*
     * 设置ul的宽高为所有li标签+2用作无缝轮播图
     * li的宽高
     *
     * */
    moveUl.width(picWidth*(liArr.length+2));
    moveUl.height(picHeight);

    moveUl.css('left',-index*picWidth);


    liArr.width(picWidth);
    liArr.height(picHeight);

    /*复制第一张和最后一张图片*/
    var clone1 = liArr.eq(0).clone(true);
    var clone2 = liArr.eq(liArr.length-1).clone(true);
    moveUl.append(clone1);
    moveUl.prepend(clone2);

    /*设置定时器使图片自动播放*/
    // 向右
    $('#next').click(function () {
        index ++;
        /*过大*/
        if (index > liArr.length){
            // 瞬间移动到第一张
            moveUl.css('left',0);
            index = 1;
        }
        moveUl.animate({left:-index*picWidth});

        // 小圆点
        for (var i = 0; i < olArr.length; i++) {
            olArr[i].className = '';
        }
        olArr[index-1].className = 'active';
        console.log('右'+index);
    });
    // 向左
    $('#prov').click(function () {
        index --;
        /*过小*/
        if (index < 1){
            index = liArr.length;
            // 瞬间移动到最后一张
            moveUl.css('left',-liArr.length*picWidth);
        }
        moveUl.animate({left:-index*picWidth});
        // 小圆点
        for (var i = 0; i < olArr.length; i++) {
            olArr[i].className = '';
        }
        olArr[index-1].className = 'active';

        console.log('左'+index);
    });

    // 创建下边的圆点按钮
    var $ol = $('<ol></ol>');
    // 添加到页面
    for (var i = 0; i < liArr.length; i++) {
        $ol.append($('<li></li>'));
    }
    $pic.append($ol);


    // 计算ol的长度,使得ol居中显示
    $ol.css({'margin-left':-0.5*$ol.width()});

    // 原点的个数
    var olArr = $ol.children();

    // 网页加载之后小圆点在第一张显示白色
    olArr[index - 1].className = 'active';

    // 给原点绑定点击事件切换图片
    for (var j = 0; j < olArr.length; j++) {
        olArr[j].index = j+1;
        olArr[j].onclick = function () {

            // 小圆点的类
            for (var k = 0; k < olArr.length; k++) {
                olArr[k].className = '';
            }
            this.className = 'active';

            index = this.index;
            moveUl.animate({left:-index*picWidth});
        };

    }




});





