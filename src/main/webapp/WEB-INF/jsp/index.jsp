<%--
  Created by IntelliJ IDEA.
  User: kinlo
  Date: 2018/3/10
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>ClassmatesHome</title>
    <link rel="stylesheet" type="text/css" href="../easyui/themes/metro/easyui.css">
    <link rel="stylesheet" type="text/css" href="../easyui/themes/mobile.css">
    <link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
    <script type="text/javascript" src="../easyui/jquery.min.js"></script>
    <script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../easyui/jquery.easyui.mobile.js"></script>
    <script type="text/javascript" src="../js/login/index.js"></script>
    <script type="text/javascript" src="../js/util/md5.js"></script>
</head>
<body>
<style scoped>
    .tt-inner{
        display:inline-block;
        line-height:12px;
        padding-top:0px;
    }
</style>
<div class="easyui-navpanel">
    <header id="hh">
        <div class="m-toolbar">
            <div class="m-title" id="main_title">Yellow Book</div>
        </div>
    </header>
    <div class="easyui-tabs" data-options="tabHeight:60,fit:true,tabPosition:'bottom',border:false,pill:true,narrow:true,justified:true">
        <div style="padding:0px">
            <div class="panel-header tt-inner">
                <a href="javascript:void(0)" onclick="onIndexMainBtnClk(0)" class="easyui-linkbutton" data-options="iconCls:'icon-large-picture',size:'large',iconAlign:'top',plain:true">Home</a>
            </div>
            ab
        </div>
        <div style="padding:0px">
            <div class="panel-header tt-inner">
                <a href="javascript:void(0)" onclick="onIndexMainBtnClk(1)" class="easyui-linkbutton" data-options="iconCls:'icon-large-clipart',size:'large',iconAlign:'top',plain:true">Yellow Book</a>
            </div>

            <div id="div_dg" class="easyui-navpanel" >
                <table id="dg" data-options="singleSelect:true,border:false,fit:true,scrollbarSize:0" style="width:100%;">
                </table>
            </div>
        </div>
        <div style="padding:0px">
            <div class="panel-header tt-inner">
                <a href="javascript:void(0)" onclick="onIndexMainBtnClk(2)" class="easyui-linkbutton" data-options="iconCls:'icon-large-shapes',size:'large',iconAlign:'top',plain:true">More</a>
            </div>
            <div>
                <input type="file" hidden name="uploadFile" multiple id="uploadFile" accept=".gif,.png" onchange="filesConfirm()">
            </div>
            <div>
                <a href="javascript:void(0)" onclick="openUpload()" class="easyui-linkbutton" plain="true" outline="true" style="width:100px;height:35px"><span style="font-size:16px">Upload</span></a>
            </div>
            <div style="width: 60%;margin:auto" id="test_div"></div>
        </div>
        <div style="padding:0px">
            <div class="panel-header tt-inner">
                <a href="javascript:void(0)" onclick="onIndexMainBtnClk(3)" class="easyui-linkbutton" data-options="iconCls:'icon-large-smartart',size:'large',iconAlign:'top',plain:true">Me</a>
            </div>
            ef
        </div>
    </div>
</div>
<div id="classmate_panel" class="easyui-navpanel">
    <header>
        <div class="m-toolbar">
            <div class="m-left">
                <a href="#" class="easyui-linkbutton m-back" data-options="plain:true,outline:true,back:true">Back</a>
            </div>
            <div class="m-title">DETAIL</div>
        </div>
    </header>
    <ul id="classmate_detail" class="easyui-datalist" data-options="valueField:'valueField',textField:'textField',fit: true,lines: false,border: false">
    </ul>
</div>
</body>
</html>