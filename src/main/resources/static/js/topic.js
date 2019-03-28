var topicStatus;

function getAllActiveTopics(status) {
    topicStatus = status;

    $.ajax({
        url: '/ts?action=getAllActiveTopics',
        method: 'GET',
        dataType: 'json',
        success: function (topics) {
            $('#idTbody').empty();
            topics.forEach(function (topic) {
                $('#idTbody').append('<tr>\n' +
                    '<td>'+topic.id+'</td>\n' +
                    '<td>'+topic.title+'</td>\n' +
                    '<td>'+topic.description+'</td>\n' +
                    '<td>'+topic.shareDate+'</td>\n' +
                    '<td>'+topic.viewCount+'</td>\n' +
                    '<td>'+topic.user.firstname+'</td>\n' +
                    '<td>'+topic.user.lastname+'</td>\n' +
                    '<td>'+topic.user.email+'</td>\n' +
                    '<td><a onclick="deleteTopic('+topic.id+', topicStatus)" style="text-align: center">\n' +
                    '            <i class="fas fa-trash-alt" style="display: block"></i>\n' +
                    '        </a></td>\n' +
                    '</tr>');
            });
        }
    });
}

function getAllPendingTopics(status) {
    topicStatus = status;

    $.ajax({
        url: '/ts?action=getAllPendingTopics',
        method: 'GET',
        dataType: 'json',
        success: function (topics) {
            $('#idTbody').empty();
            topics.forEach(function (topic) {
                $('#idTbody').append('<tr>\n' +
                    '<td>'+topic.id+'</td>\n' +
                    '<td>'+topic.title+'</td>\n' +
                    '<td>'+topic.shareDate+'</td>\n' +
                    '<td>'+topic.viewCount+'</td>\n' +
                    '<td>'+topic.user.firstname+'</td>\n' +
                    '<td>'+topic.user.lastname+'</td>\n' +
                    '<td>'+topic.user.email+'</td>\n' +
                    '<td><a href="#" onclick="openSeeMoreDialog('+topic.id+')" style="text-align: center">\n' +
                    '            <i class="fas fa-check-circle" style="display: block"></i>\n' +
                    '        </a></td>\n' +
                    '</tr>');
            });
        }
    });
}

function deleteTopic(id, status) {
    $.ajax({
        url: '/ts?action=deleteTopicById',
        method: 'POST',
        data: 'id=' + id,
        success: function () {
            $('#dialog-see-more').dialog('close');
            if (status == 'active') {
                getAllActiveTopics('active');
            } else {
                getAllPendingTopics('pending');
            }
        }
    });
}

function activateTopic() {
    var id = $('#topicId').val();
    var title = $('#title').val();
    var desc = $('#desc').val();
    $.ajax({
        url: '/ts?action=activateTopicById',
        method: 'POST',
        data: 'id=' + id+'&title='+title+'&desc='+desc,
        success: function () {
            $('#dialog-see-more').dialog('close');
            getAllPendingTopics();
        },
        error: function () {
            alert("Internal error!");
        }
    });
}

function openSeeMoreDialog(id){
    $.ajax({
        url: '/ts?action=getTopicById',
        method: 'GET',
        data: 'id=' + id,
        dataType: 'html',
        success: function (data) {
            $('#dialog-see-more').html(data);
            $('#dialog-see-more').dialog('open');
        },
        error: function () {
            alert("Internal error!");
        }
    });
}