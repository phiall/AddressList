<%--
  Created by IntelliJ IDEA.
  User: Heping
  Date: 2018/9/12
  Time: 18:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>Register</title>
    <link rel="stylesheet" type="text/css" href="../easyui/themes/metro/easyui.css">
    <link rel="stylesheet" type="text/css" href="../easyui/themes/mobile.css">
    <link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
    <script type="text/javascript" src="../easyui/jquery.min.js"></script>
    <script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../easyui/jquery.easyui.mobile.js"></script>
    <script type="text/javascript" src="../js/login/register.js"></script>
    <script type="text/javascript" src="../js/util/md5.js"></script>
</head>
<body>
<div class="easyui-navpanel" style="position:relative;padding:20px">
    <header>
        <div class="m-toolbar">
            <div class="m-title">Welcome to Register</div>
            <div class="m-right">
                <a href="javascript:void(0)" class="easyui-linkbutton" plain="true" outline="true" onclick="$('#ff').form('reset')" style="width:60px">Reset</a>
            </div>
        </div>
    </header>
    <form id="reg_form">
        <div style="margin-bottom:10px">
            <input id="Name" name="Name" class="easyui-textbox" label="Full Name:" prompt="Full name" style="width:95%;">
            <img id="nameTip" hidden src="../easyui/themes/icons/no.png" alt="" style="margin-bottom: -5px">
        </div>
        <div style="margin-bottom:10px">
            <input id="Password" name="pwd" class="easyui-passwordbox" label="Password:" prompt="Password" style="width:95%">
            <img id="passwordTip" hidden src="../easyui/themes/icons/no.png" alt="" style="margin-bottom: -5px">
        </div>
        <div style="margin-bottom:10px">
            <input id="RePassword" name="pwd" class="easyui-passwordbox" label="Confirm:" prompt="Confirm Password" style="width:95%">
            <img id="rePasswordTip" hidden src="../easyui/themes/icons/no.png" alt="" style="margin-bottom: -5px">
        </div>
        <div style="margin-bottom:10px;width: 100%">
            <label class="textbox-label">Gender:</label>
            <input id="GenderMale" class="easyui-radiobutton" name="Gender" value="0" label="Male">
            <span>&nbsp;&nbsp;&nbsp;&nbsp;</span>
            <input id="GenderFemale" class="easyui-radiobutton" name="Gender" value="1" label="Female">
            <img id="genderTip" hidden src="../easyui/themes/icons/no.png" alt="" style="margin-bottom: -5px">
        </div>

        <div style="margin-bottom:10px">
            <input id="Phone" name="Phone" class="easyui-numberbox" label="Phone:" prompt="Phone Number" style="width:95%">
            <img id="phoneTip" hidden src="../easyui/themes/icons/no.png" alt="" style="margin-bottom: -5px">
        </div>
        <div style="margin-bottom:10px">
            <input id="workcityinput" name="WorkCity" class="easyui-textbox" label="WorkCity:" readonly prompt="Work City" style="width:95%">
            <a id="gotoCityPanel" href="#city_panel"></a>
            <img id="workcityinputTip" hidden src="../easyui/themes/icons/no.png" alt="" style="margin-bottom: -5px">
        </div>
        <div style="margin-bottom:10px">
            <input id="WorkAddr" name="WorkAddr" class="easyui-textbox" label="Address:" prompt="Detail Address" style="width:95%">
            <img id="workAddrTip" hidden src="../easyui/themes/icons/no.png" alt="" style="margin-bottom: -5px">
        </div>
        <div style="margin-bottom:10px">
            <input id="hometowninput" name="HomeTown" class="easyui-textbox" label="HomTown:" readonly prompt="Hom Town" style="width:95%">
            <img id="hometowninputTip" hidden src="../easyui/themes/icons/no.png" alt="" style="margin-bottom: -5px">
        </div>
        <div style="margin-bottom:10px">
            <input id="HomeAddr" name="HomeAddr" class="easyui-textbox" label="Address:" prompt="Detail Address" style="width:95%">
            <img id="homeAddrTip" hidden src="../easyui/themes/icons/no.png" alt="" style="margin-bottom: -5px">
        </div>

        <div style="text-align:center;margin-top:30px">
            <a href="#" onclick="Register()" class="easyui-linkbutton" style="width:100%;height:40px"><span style="font-size:16px">Register</span></a>
        </div>
    </form>
</div>

<div id="city_panel" class="easyui-navpanel">
    <header>
        <div class="m-toolbar">
            <div class="m-left">
                <a id='city_back' href="#" class="easyui-linkbutton m-back" data-options="plain:true,outline:true,back:true">Back</a>
            </div>
            <div class="m-right">
                <a href="javascript:void(0)" onclick="cityConfirm()" class="easyui-linkbutton" plain="true" outline="true" style="width:60px">OK</a>
            </div>
            <div class="m-title">SELECT</div>
        </div>
    </header>
    <ul id="select_candidate" class="m-list">
    </ul>
</div>
</body>
</html>
