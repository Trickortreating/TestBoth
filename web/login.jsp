<%--
  Created by IntelliJ IDEA.
  User: d
  Date: 2017/12/26
  Time: 上午8:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
<p>请输入用户名和密码：</p>
<s:form action="Login">
    <s:textfield name="user.username" label="用户名" tooltip="输入用户名" labelposition="left"/>
    <s:password name="user.password" label="密码" tooltip="输入密码" labelposition="left"/>
    <s:submit value="登录" align="center"/>
</s:form>
</body>
</html>
