$(function () {
    getAllBooks();
    $('#btnBookSave').click(function () {
        // var titleBook = $('#titleBook').val();
        // var descBook = $('#descBook').val();
        // var firstImgBook = $('#firstImgBook').val();
        // var secondImgBook = $('#secondImgBook').val();
        // var authorIdBook = $('#authorIdBook').val();
        // alert(titleBook + descBook + firstImgBook + secondImgBook + authorIdBook);
        addBook();
    })
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

function addBook() {
    var titleBook = $('#titleBook').val();
    var descBook = $('#descBook').val();
    var firstImgBook = $('#firstImgBook').val();
    var secondImgBook = $('#secondImgBook').val();
    var authorNameBook = $('#authorNameBook').val();
    var langBook = $('#langBook').val();
    var priceBook = $('#priceBook').val();
    var quantityBook = $('#quantityBook').val();
    var discountBook = $('#discountBook').val();
    var ageRangeBook = $('#ageRangeBook').val();

    $.ajax({
        type: 'POST',
        url: '/book/add-book',
        data: {titleBook: titleBook, descBook: descBook, firstImgBook: firstImgBook, secondImgBook: secondImgBook, authorNameBook: authorNameBook,
            langBook: langBook, priceBook: priceBook, quantityBook: quantityBook, discountBook: discountBook, ageRangeBook: ageRangeBook},
        success: function () {
            alert("Success");
        },
        error: function () {
            alert("Error")
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

