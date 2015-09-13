$(document).ready(function () {
    $('#user').submit(function () {
        var name = $.trim($('#name').val());
        var pwd = $.trim($('#pwd').val());
        var repeatPwd = $.trim($('#repeatPwd').val());
        if (name == '') {
            $( "#name" ).nextAll().remove();
            $( "#name" ).after( "<span class='error'>Обязательное поле</span>" );
            return false;
        }
        if (pwd == '') {
            $( "#pwd" ).nextAll().remove();
            $( "#pwd" ).after( "<span class='error'>Обязательное поле</span>" );
            return false;
        }
        if (repeatPwd == '') {
            $( "#repeatPwd" ).nextAll().remove();
            $( "#repeatPwd" ).after( "<span class='error'>Обязательное поле</span>" );
            return false;
        }
        if (repeatPwd != pwd) {
            $( "#repeatPwd" ).nextAll().remove();
            $( "#repeatPwd" ).after( "<span class='error'>Пароли не совпадают</span>" );
            return false;
        }

    });
})
