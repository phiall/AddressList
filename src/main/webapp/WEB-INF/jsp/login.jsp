<%--
  Created by IntelliJ IDEA.
  User: Heping
  Date: 2018/9/11
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="../easyui/themes/metro/easyui.css">
    <link rel="stylesheet" type="text/css" href="../easyui/themes/mobile.css">
    <link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
    <script type="text/javascript" src="../easyui/jquery.min.js"></script>
    <script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../easyui/jquery.easyui.mobile.js"></script>
    <script type="text/javascript" src="../js/login/login.js"></script>
    <script type="text/javascript" src="../js/util/md5.js"></script>
</head>
<body>
<div class="easyui-navpanel">
    <header>
        <div class="m-toolbar">
            <span class="m-title">Login to System</span>
        </div>
    </header>
    <div style="margin:20px auto;width:100px;height:100px;border-radius:100px;overflow:hidden">
        <img src="../img/login1.jpg" style="margin:0;width:100%;height:100%;">
    </div>
    <div style="padding:0 20px">
        <div style="margin-bottom:10px">
            <input id="UserNameInput" class="easyui-textbox" data-options="prompt:'Type username',iconCls:'icon-man'" style="width:100%;height:38px">
        </div>
        <div>
            <input id="PasswordInput" class="easyui-passwordbox" data-options="prompt:'Type password'" style="width:100%;height:38px">
        </div>
        <div style="text-align:center;margin-top:30px">
            <a href="#" onclick="Login()" class="easyui-linkbutton" style="width:100%;height:40px"><span style="font-size:16px">Login</span></a>
        </div>
        <div style="text-align:center;margin-top:30px">
            <a href="./register" class="easyui-linkbutton" plain="true" outline="true" style="width:100px;height:35px"><span style="font-size:16px">Register</span></a>
        </div>
    </div>
</div>
</body>
</html>
