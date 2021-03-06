$(function () {
    getUserByStatus();
});


function getUserByStatus() {
    $.ajax({
        type: "GET",
        url: "/get-all-users",
        data: "JSON",
        success: function (users) {
            console.log(users);
            $('#idTableUser').empty();
            users.forEach(function (user) {
                $('#idTableUser').append('                            <tr>\n' +
                    '                                <td>' + user.idUser + '</td>\n' +
                    '                                <td>' + user.name + '</td>\n' +
                    '                                <td>' + user.surname + '</td>\n' +
                    '                                <td>' + user.username + '</td>\n' +
                    '                                <td>' + user.email + '</td>\n' +
                    '                                <td>' + user.status + '</td>\n' +
                    '                                <td>' + user.role.roleType + '</td>\n' +
                    '                                <td>\n' +
                    '                                    <a href="#editEmployeeModal" class="edit" data-toggle="modal"><i class="fa fa-edit"\n' +
                    '                                                                                                     data-toggle="tooltip"\n' +
                    '                                                                                                     title="Edit"></i></a>\n' +
                    '                                    <a onclick="deleteBook(' + book.idBook + ')" class="delete" data-toggle="modal"><i\n' +
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