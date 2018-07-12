<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>SSE Demo</title>
</head>
<body>
<div id="msgFromPush"></div>
<script type="text/javascript" src="<c:url value="../assets/js/jquery.js"/>"></script>
<script type="text/javascript">
    if (!!window.EventSource) {//EventSource对象只有新式浏览器才有(Chrome,Firefox)等,EventSource是SSE的客户端;
        //新建一个EventSource对象,请求的路径指向"push"
        var source = new EventSource('push');
        s = '';
        source.addEventListener('message', function (e) {//添加SSE客户端监听,在此获得服务器的推送消息.
            s += e.data + "<br/>";
            $("#msgFromPush").html(s);
        });
        source.addEventListener('open', function (e) {
            console.log("链接打开!");
        }, false);
        source.addEventListener('error', function (e) {
            if (e.readyState == EventSource.CLOSED) {
                console.log("连接关闭!")
            } else {
                console.log(e.readyState);
            }
        }, false);
    } else {
        console.log("你的浏览器不支持SSE!");
    }
</script>
</body>
</html>