$(function () {
    getAllBlog();
    $('#btnBlogSave').click(function () {
        // var titleBlog = $('#titleBlog').val();
        // var descBlog = $('#descBlog').val();
        // var imgBlog = $('#imgBlog').val();
        // alert(titleBlog + descBlog + imgBlog);
        addBlog();
    })

});

function getAllBlog() {
    $.ajax({
        type: "GET",
        url: "/blog/get-all-blog",
        data: "JSON",
        success: function (blogs) {
            $('#blog-content').empty();
            blogs.forEach(function (blog) {
                $('#blog-content').append('                            <tr>\n' +
                    '                                <td id="idTableBlog">' + blog.id + '</td>\n' +
                    '                                <td id="titleTableBlog">' + blog.title + '</td>\n' +
                    '                                <td id="descTableBlog">' + blog.desc + '</td>\n' +
                    '                                <td>' + blog.shareDate + '</td>\n' +
                    '                                <td id="imgTableBlog">' + blog.imagePath + '</td>\n' +
                    '                                <td>\n' +
                    '                                    <a href="#editEmployeeModal" id="btnEditBlogTable" class="edit" data-toggle="modal"><i class="fa fa-edit"\n' +
                    '                                                                                                     data-toggle="tooltip"\n' +
                    '                                                                                                     title="Edit"></i></a>\n' +
                    '                                    <a href="#deleteEmployeeModal" class="delete" data-toggle="modal"><i\n' +
                    '                                            class="fa fa-trash-o" data-toggle="tooltip" title="Delete"></i></a>\n' +
                    '                                </td>\n' +
                    '                            </tr>');
            });
        },
        error: function () {
            console.log("Error get all blog function!")
        }
    })
}

function addBlog() {
    var titleBlog = $('#titleBlog').val();
    var descBlog = $('#descBlog').val();
    var imgBlog = $('#imgBlog').val();

    $.ajax({
        type: 'POST',
        url: '/blog/add-blog',
        data: {titleBlog: titleBlog, descBlog: descBlog, imgBlog: imgBlog},
        success: function () {
            alert("Success");
        },
        error: function () {
            alert("Error")
        }
    })
}











