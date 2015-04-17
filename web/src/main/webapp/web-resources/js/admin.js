$(document).ready(function () {


    $('#html').jstree();
    $('#tree')
        .on('ready.jstree', function (e, data) {

            var categoryId = getParameterByName('categoryId');

            data.instance.select_node(categoryId)
        })
        .on("activate_node.jstree",
        function (evt, data) {
            //alert(data.node.id);
            window.location.href = 'http://localhost:8080/flyfishalex/ru/admin/categories?categoryId=' + data.node.id;
        })
        .jstree({
            'core': {
                'data': {
                    "url": "http://localhost:8080/flyfishalex/ru/admin/categories.json",
                    "dataType": "json"

                }
            }
        });


    $('#deleteCatogory').click(function () {
        var catId = $('#id').val();
        var r = confirm("Are you sure?");
        if (r == true) {
            $.ajax({
                url: 'http://localhost:8080/flyfishalex/ru/admin/categories?categoryId=' + catId,
                type: 'DELETE',
                success: function (result) {
                    alert(result)
                    window.location.href = 'http://localhost:8080/flyfishalex/ru/admin/categories';
                }
            });

        } else {
        }

    })

})

function getParameterByName(name) {
    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
        results = regex.exec(location.search);
    return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}