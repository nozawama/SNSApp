var form = document.getElementById("formRegister");

document.getElementById("buttonSubmit").onclick = function () {
    if(form.password.value != form.passwordConfirm.value) {
        form.passwordConfirm.setCustomValidity("パスワードが一致しません。");
    } else {
        form.passwordConfirm.setCustomValidity("");
    }
}
