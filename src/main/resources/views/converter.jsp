<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<!<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>HttpMessageConverter Demo</title>
</head>
<body>
<div id="resp"></div>
<input type="button" onclick="req();" value="请求"/>
<script src="../assets/js/jquery.js" type="text/javascript"></script>
<script>
    function req() {
        $.ajax({
            url: "/convert",
            date: "1-zhaowenhao",
            type: "POST",
            contentType: "application/x-wisely",
            success: function (date) {
                $("#resp").html(date)
            }
        });
    }
</script>
</body>
</html>