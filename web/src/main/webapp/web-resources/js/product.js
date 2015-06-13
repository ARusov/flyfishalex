$(document).ready(function () {
    $('.product-variant-link').click(function () {
        //alert(window.location.hostname);
        //alert($(this).attr('name'));
        var id=$(this).attr('name');
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/flyfishalex/ru/user/basket/"+id,
            success:function(response){
                alert(response)
            }
        })
    })
})

