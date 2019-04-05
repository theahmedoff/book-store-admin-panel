$(function () {
    getAllBlog();
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
                    '                                <td>' + blog.id + '</td>\n' +
                    '                                <td>' + blog.title + '</td>\n' +
                    '                                <td>' + blog.desc + '</td>\n' +
                    '                                <td>' + blog.shareDate + '</td>\n' +
                    '                                <td>' + blog.imagePath + '</td>\n' +
                    '                                <td>\n' +
                    '                                    <a href="#editEmployeeModal" class="edit" data-toggle="modal"><i class="fa fa-edit"\n' +
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

