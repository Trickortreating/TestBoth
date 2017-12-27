<%--
  Created by IntelliJ IDEA.
  User: d
  Date: 2017/12/26
  Time: 上午8:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>用户注册</title>
</head>
<p>注册一个新用户</p>
<s:form action="Register">
    <s:actionerror /> <s:fielderror/>
    <s:textfield name="user.username" label="用户名"/>
    <s:password name="user.password" label="口令"/>
    <s:textfield name="user.age" label="年龄"/>
    <s:textfield name="user.email" label="Email地址"/>
    <s:submit value="注册"/>
</s:form>
<body>

</body>
</html>
