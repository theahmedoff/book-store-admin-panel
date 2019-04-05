$(function () {
    getAllBooks();
});


function getAllBooks() {
    $.ajax({
        type: "GET",
        url: "/book/get-all-book",
        data: "JSON",
        success: function (books) {
            $('#idTableBook').empty();
            books.forEach(function (book) {
                $('#idTableBook').append('                            <tr>\n' +
                    '                                <td>' + book.idBook + '</td>\n' +
                    '                                <td>' + book.title + '</td>\n' +
                    '                                <td>' + book.imagePath + '</td>\n' +
                    '                                <td>' + book.author.fullName + '</td>\n' +
                    '                                <td>' + book.writeDate + '</td>\n' +
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


function edit(id) {
    $.ajax({
        type: 'POST',
        url: '/book/edit/' + id,
        success
    })
}


function deleteBook(id) {
    $.ajax({
        type: 'POST',
        url: '/book/delete/' + id,
        success: function () {
            getAllBooks();

            alert("Delete Book");
        },
    })

}