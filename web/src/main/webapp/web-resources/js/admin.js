$(document).ready(function () {


    $('#selectCategory').click(function () {
        $('#selectCategoryForm').removeClass('invisible');
    });

    $('#selectCategoryFormClose').click(function () {
        $('#selectCategoryForm').addClass('invisible');
    });

    $('#selectCategoryTable').find('tr').click(function () {
        var cId = $(this).find('td').eq(0).text();
        var cName = $(this).find('td').eq(1).text();
        $('#parentId').val(cId);
        $('#parentName').val(cName);
        $('#selectCategoryForm').addClass('invisible');
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
