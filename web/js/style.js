// 全局变量 是否已经点击抽奖
var hasClick = 0;

/*抽屉式特效*/
$(".wrap ul li").hover(function(){
	$(this).stop().animate({width:"500px"},800).siblings().stop().animate({width:"100px"},800);
	var _index=$(this).index();
	var lineimg=$("#line").find("img");
	$("#line").fadeIn();
	lineimg.eq(_index).fadeIn();
	lineimg.stop().eq(_index).fadeIn().animate({left:0,opacity:1},800).siblings().animate({left:"100px",opacity:0},100);
});
/*控制消失*/
$(".gfwrap").hover(function(){
	$("#line").fadeOut();
	var lineimg=$("#line").find("img");
	lineimg.eq(0).animate({left:"100px",opacity:0},100);
	lineimg.eq(1).animate({left:"100px",opacity:0},100);
	lineimg.eq(2).animate({left:"100px",opacity:0},100);
});
/*抽屉式特效*/
$(".talken ul li").hover(function(){
	$(this).stop().animate({width:"500px"},800).siblings().stop().animate({width:"100px"},800);
});
/*首页淡入淡出效果*/
var thisimg=$("#phone").find("img");
thisimg.fadeIn();
thisimg.eq(0).animate({left:0,opacity:1},1000);
thisimg.eq(1).animate({left:0,opacity:1},1500);
var twoimg=$("#down").find("img");
twoimg.animate({opacity:1},2000);
/*function fun(){alert("Make By Qianjiang Chu Of Software Engineering TYUT\nThe New App I Designed,Welcom Come To Use\nTel:136xxxx1884")};*/
/*切换特效*/
$(".navbar ul").find("li").eq(0).click(function(){
	$(".pc img").stop().animate({left:"170px",opacity:0},1000);
	$("#sec").fadeOut();
	var thisimg=$("#phone").find("img");
	thisimg.fadeIn();
	thisimg.eq(0).animate({left:0,opacity:1},1000);
	thisimg.eq(1).animate({left:0,opacity:1},1000);
	var twoimg=$("#down").find("img");
	twoimg.animate({opacity:1},2000);
	$(".gfwrap").fadeIn();
	$(".wrap").fadeIn();
});
$(".gfwrap #down").eq(0).click(function(){
	$("#sec").fadeOut();
	var thisimg=$("#phone").find("img");
	thisimg.fadeIn();
	thisimg.eq(0).animate({left:0,opacity:1},1000);
	thisimg.eq(1).animate({left:0,opacity:1},1000);
	var twoimg=$("#down").find("img");
	twoimg.animate({opacity:1},2000);
	$(".gfwrap").fadeIn();
	$(".wrap").fadeIn();
});
$(".navbar ul").find("li").eq(2).click(function(){
	$(".pc img").stop().animate({left:"50px",opacity:1},1500);
	$(".pc .pcHeadFrame img").stop().animate({left:"50px",opacity:0},1500);
	$(".pc label").stop().animate({left:"50px",opacity:0},1500);
	$(".pc .logoi2 img").stop().animate({left:"50px",opacity:1},1500);
	$(".pc .helperContent img").stop().animate({left:"50px",opacity:1},2000);
	$(".pc .drawBtn img").stop().animate({left:"50px",opacity:0},2000);
	$(".pc .headFrame_black img").stop().animate({opacity:0},1500);
	$(".pc .info label").stop().animate({opacity:0},1500);
	$(".pc .headFrame_head img").stop().animate({opacity:0},1500);
    $(".resetBg").stop().animate({opacity:0},1000);
    $(".resetSinger").stop().animate({opacity:0},1000);
    $(".resetGroup").stop().animate({opacity:0},1000);
	var thisimg=$("#phone").find("img");
	thisimg.eq(0).fadeOut().animate({left:"-300px",opacity:0},100);
	thisimg.eq(1).fadeOut().animate({left:"100px",opacity:0},100);
	var twoimg=$("#down").find("img");
	twoimg.animate({opacity:0},100);
	$(".gfwrap").fadeOut();
	$(".wrap").fadeOut();
	$("#sec").fadeIn();
});
$("#down").click(function(){
    $(".pc img").stop().animate({left:"50px",opacity:1},1500);
    $(".pc .pcHeadFrame img").stop().animate({left:"50px",opacity:0},1500);
    $(".pc label").stop().animate({left:"50px",opacity:0},1500);
    $(".pc .logoi2 img").stop().animate({left:"50px",opacity:1},1500);
    $(".pc .helperContent img").stop().animate({left:"50px",opacity:1},2000);
    $(".pc .drawBtn img").stop().animate({left:"50px",opacity:0},2000);
    $(".pc .headFrame_black img").stop().animate({opacity:0},1500);
    $(".pc .info label").stop().animate({opacity:0},1500);
    $(".pc .headFrame_head img").stop().animate({opacity:0},1500);
    $(".resetBg").stop().animate({opacity:0},1000);
    $(".resetSinger").stop().animate({opacity:0},1000);
    $(".resetGroup").stop().animate({opacity:0},1000);
    var thisimg=$("#phone").find("img");
    thisimg.eq(0).fadeOut().animate({left:"-300px",opacity:0},100);
    thisimg.eq(1).fadeOut().animate({left:"100px",opacity:0},100);
    var twoimg=$("#down").find("img");
    twoimg.animate({opacity:0},100);
    $(".gfwrap").fadeOut();
    $(".wrap").fadeOut();
    $("#sec").fadeIn();
});
/*抽奖页面PC特效*/
$(".pc img").hover(function(){
	$(".pc img").stop().animate({left:"170px",opacity:1},1000);
	$(".pc .pcHeadFrame img").stop().animate({left:"170px",opacity:1},700);
	$(".pc label").stop().animate({left:"170px",opacity:1},1000);
	$(".pc .logoi2 img").stop().animate({left:"170px",opacity:0},1000);
	$(".pc .helperContent img").stop().animate({left:"170px",opacity:0},1000);
	$(".pc .drawBtn img").stop().animate({left:"170px",opacity:1},1000);
	$(".pc .headFrame_black img").stop().animate({opacity:1},2000);
	$(".pc .info label").stop().animate({opacity:1},2000);
	$(".pc .headFrame_black").stop().animate({top:"-1000px",opacity:1},1000);
	$(".pc .info").stop().animate({top:"-1170px",opacity:1},1000);
	$(".pc .headFrame_head img").stop().animate({opacity:1},3500);
    $(".resetBg").stop().animate({opacity:0},1000);
    $(".resetSinger").stop().animate({opacity:0},1000);
    $(".resetGroup").stop().animate({opacity:0},1000);
});
$(".pc .headFrame_blue img").hover(function(){
	$(".pc .headFrame_black").stop().animate({top:"-1130px",opacity:1},1000);
	$(".pc .info").stop().animate({top:"-1300px",opacity:1},1000);
});
$("#main").hover(function(){
	$(".pc img").stop().animate({left:"50px",opacity:1},1000);
	$(".pc .pcHeadFrame img").stop().animate({left:"50px",opacity:0},1300);
	$(".pc label").stop().animate({left:"50px",opacity:0},1000);
	$(".pc .logoi2 img").stop().animate({left:"50px",opacity:1},1000);
	$(".pc .helperContent img").stop().animate({left:"50px",opacity:1},1500);
	$(".pc .drawBtn img").stop().animate({left:"50px",opacity:0},1500);
	$(".pc .headFrame_black img").stop().animate({opacity:0},500);
	$(".pc .info label").stop().animate({opacity:0},1000);
	$(".pc .headFrame_black").stop().animate({top:"-1000px",opacity:1},1000);
	$(".pc .info").stop().animate({top:"-1170px",opacity:1},1000);
	$(".pc .headFrame_head img").stop().animate({opacity:0},300);
    $(".resetBg").stop().animate({opacity:0},1000);
    $(".resetSinger").stop().animate({opacity:0},1000);
    $(".resetGroup").stop().animate({opacity:0},1000);
});
//图片数组
var usersImg = [
    "images/users/1.jpg",
    "images/users/2.jpg",
    "images/users/3.jpg",
    "images/users/4.jpg",
    "images/users/5.jpg",
    "images/users/6.jpg",
    "images/users/7.jpg",
    "images/users/8.jpg",
    "images/users/9.jpg",
    "images/users/10.jpg",
    "images/users/11.jpg",
    "images/users/12.jpg",
    "images/users/13.jpg",
    "images/users/14.jpg",
    "images/users/15.jpg",
    "images/users/16.jpg",
    "images/users/17.jpg",
    "images/users/18.jpg",
    "images/users/19.jpg",
    "images/users/20.jpg",
    "images/users/21.jpg",
    "images/users/22.jpg",
    "images/users/23.jpg",
    "images/users/24.jpg",
    "images/users/25.jpg",
    "images/users/26.jpg",
    "images/users/27.jpg",
    "images/users/28.jpg",
    "images/users/29.jpg",
    "images/users/30.jpg",
    "images/users/31.jpg",
    "images/users/32.jpg",
    "images/users/33.jpg",
    "images/users/34.jpg",
    "images/users/35.jpg",
    "images/users/36.jpg",
    "images/users/37.jpg",
    "images/users/38.jpg",
    "images/users/39.jpg",
    "images/users/40.jpg",
    "images/users/41.jpg",
    "images/users/42.jpg",
    "images/users/43.jpg",
    "images/users/44.jpg",
    "images/users/45.jpg"
]
//图片切换
function imgChange() {
    $("#headFrame_headimg").attr('src',usersImg[Math.floor(Math.random()*45)]);
}
//点击抽奖
var func;
function drawMain() {
    if(!hasClick){
        $("#startUp").attr('src','images/luckyDraw.png');
        func = setInterval("imgChange()",50);
        $("#usernamne").html("————");
        $("#groupname").html("————");
        hasClick = 1;
    }else{
        clearInterval(func);
        $("#startUp").attr('src','images/startUp.png');
        hasClick = 0;
        // 显示中奖人
        var myData = {
            teamOrSinger:$('input:radio[name="teamOrSinger"]:checked').val(),
            putOrNotput:$('input:radio[name="putOrNotput"]:checked').val()
        };
        $.ajax({
            url: "/drawway",
            type: "get",
            dataType:"json", //后台传输到前台的数据格式
            data: myData,
            success:function (data) {
                console.log(data[0].name);
                if($('input:radio[name="teamOrSinger"]:checked').val()=="2") {
                    $("#usernamne").html(data[0].name);
                    $("#groupname").html(data[0].group_name);
                    $("#headFrame_headimg").stop().animate({opacity:0},500)
                    $("#headFrame_headimg").attr('src',data[0].photo).animate({opacity:1},1000);
                    layer.open({
                        type: 1
                        ,offset: 't' //具体配置参考：offset参数项
                        ,content: data[0].name
                        ,btn: '关闭全部'
                        ,btnAlign: 'c' //按钮居中
                        ,shade: 0 //不显示遮罩
                        ,yes: function(){
                            layer.closeAll();
                        }
                    });
                    $(".name").html(data[0].name);
                } else {
                    $("#headFrame_headimg").stop().animate({opacity:0},500)
                    $("#headFrame_headimg").animate({opacity:1},1000);
                    $("#usernamne").html(data[0].name);
                    $("#groupname").html("");
                    layer.open({
                        type: 1
                        ,offset: 't' //具体配置参考：offset参数项
                        ,content: data[0].name
                        ,btn: '关闭全部'
                        ,btnAlign: 'c' //按钮居中
                        ,shade: 0 //不显示遮罩
                        ,yes: function(){
                            layer.closeAll();
                        }
                    });
                }
                //                // 遍历
                // for(var i in data){
                //     console.log(data[i].用户ID);
                // }
            },
            error: function (e) {
                console.log(e);
                console.log("错误");
            }
        });
    }
}
$("#startUp").click(function(){
    drawMain();
});

//重置按钮
$("#putRadio").hover(function(){
    $(".resetBg").stop().animate({opacity:1},1000);
    $(".resetSinger").stop().animate({opacity:1},1000);
    $(".resetGroup").stop().animate({opacity:1},1000);
});
$("#putLabel").hover(function(){
    $(".resetBg").stop().animate({opacity:1},1000);
    $(".resetSinger").stop().animate({opacity:1},1000);
    $(".resetGroup").stop().animate({opacity:1},1000);
});
$(".resetSinger").hover(function(){
    $(".resetBg").stop().animate({opacity:1},1000);
    $(".resetSinger").stop().animate({opacity:1},1000);
    $(".resetGroup").stop().animate({opacity:1},1000);
});
$(".resetBg").hover(function(){
    $(".resetBg").stop().animate({opacity:1},1000);
    $(".resetSinger").stop().animate({opacity:1},1000);
    $(".resetGroup").stop().animate({opacity:1},1000);
});
$(".resetGroup").hover(function(){
    $(".resetBg").stop().animate({opacity:1},1000);
    $(".resetSinger").stop().animate({opacity:1},1000);
    $(".resetGroup").stop().animate({opacity:1},1000);
});

$(".reset").click(function(){
    layer.msg('正在重置', {time: 1000});
    var value = {
        resetInfo:$(this).attr("data-value")
    };
    $.ajax({
        url: "/reset",
        type: "get",
        dataType:"text", //后台传输到前台的数据格式
        data: value,
        success:function (data) {
            layer.msg('重置成功', {time: 1000});
        },
        error: function (e) {
            console.log(e);
            console.log("错误");
        }
    });
})