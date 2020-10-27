<%--
  Created by IntelliJ IDEA.
  User: LoverStream
  Date: 2018/1/17
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form action="Test" method="get">
    中奖结果:<input type="text" id="drawResult" name="drawResult" value=""/><br/><br/>
    请选择抽奖形式<br/><br/>
    <label><input name="teamOrSinger" type="radio" value="2" checked="checked"/>1.抽取中奖者</label>
    <label><input name="teamOrSinger" type="radio" value="1"/>2.抽取中奖小组</label><br/><br/>
    <label><input name="putOrNotput" type="radio" value="1" checked="checked"/>1.放回抽取</label>&nbsp;&nbsp;
    <label><input name="putOrNotput" type="radio" value="2" disabled="disabled"/>2.不放回抽取</label><br/><br/>
<%--<button type="submit" class="btn btn-default">提交</button>--%>
        <button type="button" id="submit">提交</button>
    <button type="reset" class="btn btn-default">重置</button>
</form>
<script src="https://cdn.bootcss.com/jquery/3.1.0/jquery.js"></script>
<script>
    $("#submit").click(function () {
        // 上传的数据
        var myData = {
            teamOrSinger:$('input:radio[name="teamOrSinger"]:checked').val(),
            putOrNotput:$('input:radio[name="putOrNotput"]:checked').val(),
        };
        $.ajax({
            url: "/Test",
            type: "get",
            dataType:"json", //后台传输到前台的数据格式
            data: myData,
            success:function (data) {
                if(data[0].用户名称) {
                    $("#drawResult").val(data[0].用户名称 + " - " + data[0].团队名称);
                } else {
                    $("#drawResult").val(data[0].团队名称);
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
    })
</script>
</body>
</html>
