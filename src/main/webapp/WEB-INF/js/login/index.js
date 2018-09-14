window.onload = function () {
    onIndexLoad();
};
function onIndexLoad() {
    $.ajax({
        url:"/User/Classmates.do",
        type:"get",
        async:false,
        success:function(data){
            $('#dg').datagrid("loadData", data.data);
        }
    });
}
function genderFormatter(value){
    if(value == 0){
        return 'Male';
    }else{
        return 'Female';
    }
}
function addrFormatter(value) {
    return value ? value : '';
}
$(document).ready(function () {
    $('#dg').datagrid({
//对应json数据中的每一列
        columns : [ [ {
            field : 'name',
            title : 'Name',
            width : fixWidth(0.3),
            align : 'center',
            formatter:function (value,index, row) {
                return "<a href='#classmate_panel' target='_block'>" + value + "</a>";
            }
        }, {
            field : 'gender',
            title : 'Gender',
            width : fixWidth(0.3),
            align : 'center',
            formatter : function(value){//格式化值的显示
                return genderFormatter(value);
            }
        }, {
            field : 'phone',
            title : 'Phone',
            width : fixWidth(0.4),
            align : 'center',
        }
        ] ],
        idField:'id',
        loadMsg:'Processing, please wait …',
        onClickRow:function (index, row) {
            var infos = [];
            infos.push({valueField:'Name: ' + row.name, textField:'Name: ' + row.name});
            infos.push({valueField:'Gender: ' + genderFormatter(row.gender), textField:'Gender: ' + genderFormatter(row.gender)});
            infos.push({valueField:'Phone: ' + addrFormatter(row.phone), textField:'Phone: ' + addrFormatter(row.phone)});
            infos.push({valueField:'Work Place: '
                    + addrFormatter(row.workCity) + addrFormatter(row.workAddr),
                textField:'Work Place: '
                    + addrFormatter(row.workCity) + addrFormatter(row.workAddr)
            });
            infos.push({valueField:'Home Place: '
                    + addrFormatter(row.homeTown) + addrFormatter(row.homeAddr),
                textField:'Home Place: '
                    + addrFormatter(row.homeTown) + addrFormatter(row.homeAddr)
            });
            infos.push({valueField:'Last Login: ' + row.updatedAt, textField:'Last Login: ' + row.updatedAt});
            $('#classmate_detail').datalist("loadData", infos);
        },
        //pagination:true
    });
    $('#main_title').html('Welcome');
});

function fixWidth(percent)
{
    return (document.body.clientWidth) * percent ;
}
function onIndexMainBtnClk(val) {
    switch (val) {
        case 0:
            $('#main_title').html('Welcome');
            break;
        case 1:
            $('#main_title').html('Yellow Book');
            break;
        case 2:
            $('#main_title').html('More');
            break;
        case 3:
            $('#main_title').html('Me');
            break;
    }
}


function openUpload() {
    $('#uploadFile').click();
}
function filesConfirm() {
    var files = $('#uploadFile').get(0).files;
    $('#test_div').html('');
    var str = "";
    for (var i = 0; i < files.length; i++) {
        var reader = new FileReader();
        reader.readAsDataURL(files[i]);
        reader.onload = function (e) {
            str += "<img  style='width: auto; height: auto; max-width: 100%; max-height: 100%;text-align: center' id='img' src='" + e.target.result + "'/><br/>";
            $('#test_div').html(str);
        }
    }
}