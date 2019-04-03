$(function () {
    var pageName = $('#pageName').val();
    if (pageName === 'blogPage') {
        console.log("success");
        getBlogs();
    }
});


function getBlogs() {
    $.ajax({
        type: 'GET',
        url: '/get-all-blog',
        dataType: 'html',
        success: function (data) {
            $('#table').html(data);
        },
        error: function () {
            console.log('Error blog!')
        }
    })
}




function getAllBlog() {
    $.ajax({
        type: "GET",
        url: "/get-all-blog",
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
                    '                                <td>' + blog.user.username + '</td>\n' +
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




// $(document).ready(function () {
//     // Activate tooltip
//     $('[data-toggle="tooltip"]').tooltip();
//
//     // Select/Deselect checkboxes
//     var checkbox = $('table tbody input[type="checkbox"]');
//     $("#selectAll").click(function () {
//         if (this.checked) {
//             checkbox.each(function () {
//                 this.checked = true;
//             });
//         } else {
//             checkbox.each(function () {
//                 this.checked = false;
//             });
//         }
//     });
//     checkbox.click(function () {
//         if (!this.checked) {
//             $("#selectAll").prop("checked", false);
//         }
//     });
// });