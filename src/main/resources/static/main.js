var clearForm = function() {
    try {
        [].slice.call(document.getElementById("taskform")
        .querySelectorAll("input"),0).forEach(i => i.value = null);
        [].slice.call(document.getElementById("taskform")
        .querySelectorAll("textarea"),0).forEach(i => i.value = null);
    } catch(e){}
}

var proccessTaskList = function (data){
    $("#tasklist").html("");
    let list = "";
    data.forEach(t => {
        list += '<div class="card bg-primary mb-3">';
        list += '<button type="button" onclick="deleteTask(' + t.id + ');" ' +
                'class="btn-close btn-close-white" aria-label="Close" style="position: absolute; top: 0.5em; right: 1em"></button>';
        list += '<div class="card-body">';
        list += '<h5 class="card-title" style="color:' + t.colorTitle + '">' + t.title + '</h5>';
        list += '<div class="card-text" style="color:' + t.colorBody + '">' + t.body + '</div>';
        list += '</div>';
        list += '</div>';
    });
    $("#tasklist").html(list);
}

var getTaskList = function () {
    $.get( "/list")
        .done(function (data) {
            proccessTaskList(data);
        })
        .fail(function (error) {
            console.log(error);
        });
}

$("#taskform").on("submit", function (e) {
    e.preventDefault();

    let form = $(this);
    let url = form.attr('action');

    $.ajax({
        type: "POST",
        url: url,
        data: form.serialize(),
        success: function(data)
        {
            getTaskList();
            clearForm();
        }
    });
});

deleteTask = function (id) {
    let url = "/delete";
    let data = {id: id};
    $.ajax({
        type: "POST",
        url: url,
        data: data,
        success: function(data)
        {
            getTaskList();
            clearForm();
        }
    });
}

$(document).ready(function (){getTaskList();});

