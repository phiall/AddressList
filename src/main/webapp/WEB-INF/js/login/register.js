function isValidInput() {
    if($("#Name").textbox("getValue").trim() == "") {
        $("#nameTip").show();
        return false;
    } else {
        $("#nameTip").hide()
    }
    if($("#Password").textbox("getValue").trim() == "") {
        $("#passwordTip").show();
        return false;
    } else {
        $("#passwordTip").hide();
    }
    if($("#RePassword").textbox("getValue").trim() == "") {
        $("#rePasswordTip").show();
        return false;
    } else {
        $("#rePasswordTip").hide();
    }
    var pwd = $("#Password").textbox("getValue");
    var rePwd = $("#RePassword").textbox("getValue");
    if(pwd != rePwd) {
        $("#rePasswordTip").show();
        return false;
    } else {
        $("#rePasswordTip").hide();
    }

    if(!$("#GenderMale").radiobutton('options')["checked"]
        && !$("#GenderMale").radiobutton('options')["checked"]) {
        $("#genderTip").show();
        return false;
    } else {
        $("#genderTip").hide();
    }
    var phone = $("#Phone").textbox("getValue").trim();
    if(phone == "" || !isPoneAvailable(phone)) {
        $("#phoneTip").show();
        return false;
    } else {
        $("#phoneTip").hide();
    }
    if($("#workcityinput").textbox("getValue").trim() == "") {
        $("#workcityinputTip").show();
        return false;
    } else {
        $("#workcityinputTip").hide();
    }
    if($("#WorkAddr").textbox("getValue").trim() == "") {
        $("#workAddrTip").show();
        return false;
    } else {
        $("#workAddrTip").hide();
    }
    if($("#hometowninput").textbox("getValue").trim() == "") {
        $("#hometowninputTip").show();
        return false;
    } else {
        $("#hometowninputTip").hide();
    }
    if($("#HomeAddr").textbox("getValue").trim() == "") {
        $("#homeAddrTip").show();
        return false;
    } else {
        $("#homeAddrTip").hide();
    }
    return true;
}
function isPoneAvailable(str) {
    var myreg=/^[1][3,4,5,7,8][0-9]{9}$/;
    if (!myreg.test(str)) {
        return false;
    } else {
        return true;
    }
}

function Register() {
    if(!isValidInput()) return;
    var tempForm = document.getElementById("reg_form");
    var input = document.createElement("input");
    input.type = "text";
    input.name = "Password";
    input.value = hex_md5($("#Password").val());
    tempForm.appendChild(input);
    tempForm.method = "POST";
    tempForm.action = "/User/Register.do";
    tempForm.submit();
    tempForm.removeChild(input);
}
$(document).ready(function () {
    $("#workcityinput").textbox('textbox').bind("click", function () {
        $("#gotoCityPanel").click();
        loadCityData();
        forAction = 0;
    });
    $("#hometowninput").textbox('textbox').bind("click", function () {
        $("#gotoCityPanel").click();
        loadCityData();
        forAction = 1;
    });
});
function cityConfirm() {
    if(4 != select_level) return;
    if(forAction == 0) {
        $('#workcityinput').textbox("setValue", select_result);
    } else if(forAction == 1) {
        $('#hometowninput').textbox("setValue", select_result);
    }
    $('#city_back').click();
}
var select_level = 1;
var select_result = '';
var forAction = -1;
function loadCityData() { //0 Work place select 1 home town select
    select_result = '';
    select_level = 1;
    $.getJSON("../data/province.json", function (data) {
        //console.log(data);
        $('#select_candidate').datalist({
            fit:true,
            plain:true,
            valueField:'name',
            textField:'name',
            singleSelect:true,
            groupField:'dataType',
            onClickRow:function (index, row) {
                if(select_level > 1 && index == 0) {
                    loadCityData();
                    return;
                }
                if(1 == select_level) {
                    var newData = [];
                    newData[0] = {'code':row.code, 'name':row.name, 'dataType':'You Selected:'}
                    select_result = row.name;
                    for(var i in row.cityList) {
                        var key = (parseInt(i) + 1).toString()
                        newData[key] = row.cityList[i];
                        newData[key].dataType = 'Please Select:';
                    }
                    $('#select_candidate').datalist('loadData', newData);
                    select_level = 2;
                } else if(2 == select_level) {
                    var newData = [];
                    select_result += row.name;
                    newData["0"] = {'code':row.code, 'name':select_result, 'dataType':'You Selected:'}
                    for(var i in row.areaList) {
                        var key = (parseInt(i) + 1).toString()
                        newData[key] = row.areaList[i];
                        newData[key].dataType = 'Please Select:';
                    }
                    $('#select_candidate').datalist('loadData', newData);
                    select_level = 3;
                } else {
                    var newData = [];
                    select_result += row.name;
                    newData["0"] = {'code':row.code, 'name':select_result, 'dataType':'You Selected:'}
                    $('#select_candidate').datalist('loadData', newData);
                    select_level = 4;
                }
            }
        });
        var copyData = [];
        for(var obj in data) {
            copyData[obj] = data[obj];
            copyData[obj].dataType = 'Please Select:';
        }
        $('#select_candidate').datalist('loadData',copyData);
    });
}