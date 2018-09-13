
function Login() {
    var tempForm = document.createElement("form");
    tempForm.id = "tempForm";
    tempForm.name = "tempForm";
    document.body.appendChild(tempForm);
    var input = document.createElement("input");
    input.type = "text";
    input.name = "Name";
    input.value = $("#UserNameInput").val();
    tempForm.appendChild(input);
    input = document.createElement("input");
    input.type = "text";
    input.name = "Password";
    input.value = hex_md5($("#PasswordInput").val());
    tempForm.appendChild(input);
    tempForm.method = "POST";
    tempForm.action = "/User/Login.do";
    tempForm.submit();
    document.body.removeChild(tempForm);
}