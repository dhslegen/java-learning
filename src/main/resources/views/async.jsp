<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>servlet async support</title>
</head>
<body>
<script type="text/javascript" src="../assets/js/jquery.js"></script>
<script type="text/javascript">
    // 页面打开后发送请求
    deferred();

    function deferred() {
        $.get('defer', function (data) {
            // 输出后台推送的数据
            console.log(data);
            // 继续请求
            deferred();
        })
    }
</script>
</body>
</html>