function curricula($) {

    var request = $.ajax({
        'url': '/curricula.json',

    });
    request.done(function (curricula) {

        console.log(curricula);
        var html = `<div class="s12">
            <div style="margin-top: 0px;
" class="card white">
                <div class="card-content">
                    <img src="/toplogoblue.png" alt="logo" style="height: 100px; width: 100px; position: absolute;
                    top: 1%; left: 1%; opacity: .15;"/>
                    <h3 class="card-title center">Courses</h3>
                    <div class="row">
                        <div class="col s3">
                        </div>
                    </div>`;
        html += '<table class="highlight"><thead><tr><th>Curriculum Name</th><th class="hide-on-med-and-down">Creation Date</th><th class="hide-on-med-and-down">Materials</th><th></th></tr></thead><tbody>';
        curricula.forEach(function (cur) {
            cur.creationDate = dateShift(cur.creationDate);
            html += `<tr><td>${cur.name}</td><td class="hide-on-med-and-down">${cur.creationDate}</td><td class="hide-on-med-and-down">`;
            cur.materials.forEach(function (element) {
                html += ` ${element.name} `
            });
            html += `</td><td> <a class="waves-effect waves-light btn modal-trigger" href="#modal-cur-${cur.id}">More Info</a>
            <div id="modal-cur-${cur.id}" class="modal" style="min-height:363px;min-width:596px;max-height:363px; max-width:596px;" >
                <div class="modal-content">
                <!--<img src="/toplogoblue.png" alt="logo" style="height:300px; width:300px;-->
                                    <!--position: absolute;-->
                    <!--top:55.5px; left:149px; opacity:.15;"/>-->
                  <h4>${cur.name}</h4>
                  <h5>Learning Objectives:</h5>
                  <pre style="font: inherit;"><p>${cur.learning_objectives}</p></pre>
                  <h5>Description:</h5>
                  <p>${cur.description}</p>
                  <a th:href="@{/courses}">View all active courses</a>
                </div>
                <div class="modal-footer">
                  <a href="#!" class="modal-close waves-effect waves-green btn-flat">Close</a>
                </div>
              </div>
</td>`
        });
        html += '</tbody></table>';
        $('#courselist').html(html);

        M.AutoInit();
    });

}

curricula($);


function provider($) {

    var request = $.ajax({
        'url': '/provider.json'
    });
    request.done(function (provider) {

        console.log(provider);


        var top = `<div class="s12">
<div style="margin-top: 0px; z-index:-10000;" class="card horizontal">
            <div class="center-align"  style="padding-left: 10px; padding-top: 16px;" class="card-image">
            <img src="${provider.image}" style="height:200px; width:200px;">
            </div>
            <div class="hide-on-med-and-down card-stacked">
            <div class="card-content">
            <h3 class="center-align hide-on-med-and-down">${provider.name}</h3>
            <p class="center-align hide-on-med-and-down">Coordinator: ${provider.coordinator.first_name} ${provider.coordinator.last_name}</p>
        </div>
        <div class="card-action">
        </div>
        </div>
        </div>
        </div>
        </h3>`;

        var html = `<div class="row">

        <div class="col s12">
            <div style="margin-top: 0px;
" class="card white">
                <div class="card-content">
                    <img src="/toplogoblue.png" alt="logo" style="height: 100px; width: 100px; opacity:.15; position: absolute;
                    top: 1%; left: 1%;"/>
                    <h3 class="card-title center">Courses</h3>
                    <div class="row">
                        <div class="col s3">
                        </div>
                    </div>`;

        html += `<table class="highlight "><thead><tr><th>Name</th><div><th class="hide-on-med-and-down">Email</th></div><th>Phone</th><th>Role</th><th>Make Instructor</th></tr></thead><tbody>`;
        provider.users.forEach(function (element) {
            if (element.role == 'student') {
                html += `<tr><td>${element.first_name} ${element.last_name}</td><td class="hide-on-med-and-down">${element.email}</td><td>${element.phone}</td><td>${element.role}</td><td><form><input class="emp_id" name="emp_id" value="${element.id}" type="hidden"/><button class="makeinstructor btn waves-effect waves-light" name="employee" value="${element.id}"  type="submit">Change<i class="material-icons right">person_add</i></button></form></td></tr>`
            } else {
                html += `<tr><td>${element.first_name} ${element.last_name}</td><td class="hide-on-med-and-down">${element.email}</td><td>${element.phone}</td><td>${element.role}</td><td><form><input class="emp_id" name="emp_id" value="${element.id}" type="hidden"/></form></td></tr>`
            }

        });
        html += '</tbody></table>';
        $('#top').html(top);
        $('#provider').html(html);
        addListener();

    });
}

function dateShift(str) {
    str = str.split("-");
    let year = str.shift();
    str.push(year);
    str = str.join("-");
    return str;
}

provider($);

function addListener() {
    $('.makeinstructor').mousedown(function (e) {

        e.preventDefault();
        var emp_id = ($(this).prop("value"));


        var token = $("meta[name='_csrf']").attr("content");
        var header = $("meta[name='_csrf_header']").attr("content");
        console.log(token);
        console.log(header);
        console.log(emp_id);
        var data = emp_id;
        //Remove all errors


        $.post({
            url: '/makeInstructor/' + emp_id,
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(data),
            beforeSend: function (jqXHR) {
                jqXHR.setRequestHeader('X-CSRF-Token', token,)
            },
            dataType: "json",
            success: function (html) {
                console.log(html);
            }
        });
        provider($)
    });
    $('.makeinstructor').mouseup(function (e) {
        e.preventDefault();
        provider($);
    })

}


// var makeinstructor = function($)


function classList($) {

    var request = $.ajax({
        'url': '/curricula.json'
    });
    request.done(function (curricula) {

        console.log(curricula);

        var html = '<table class="highlight"><thead><tr><th>Course Name</th><th class="hide-on-med-and-down">Location</th><th class="hide-on-med-and-down">Start Date</th><th class="hide-on-med-and-down">End Date</th><th class="hide-on-med-and-down">Status</th><th>Instructors</th></tr></thead><tbody>';
        curricula.forEach(function (cur) {
            cur.courses.forEach(function (course) {


                if (course.startDate === null) {
                    course.startDate = "tbd";
                } else {
                    course.startDate = dateShift(course.startDate);
                }
                if (course.endDate === null) {
                    course.endDate = "tbd";
                } else {
                    course.endDate = dateShift(course.endDate);
                }
                if (course.location === null) {
                    course.location = "tbd";
                }


                html += `<tr><td>${cur.name}</td><td class="hide-on-med-and-down">${course.location}</td><td class="hide-on-med-and-down">${course.startDate}</td><td class="hide-on-med-and-down">${course.endDate}</td><td class="hide-on-med-and-down">${course.status.name}</td><td>`;
                course.instructors.forEach(function (element) {
                    html += ` ${element.first_name} ${element.last_name}`
                })
            });
        });
        html += '</tbody>';
        $('#classlist').html(html);
        M.AutoInit();
    });
}

classList($);

$("#status").on('change', function () {
    let status = $("#status").val();
    console.log(status);
    switch (status) {
        case 1:
            classList($);
            break;
        case '201':
            statusFilter(status);
            break;
        case '202':
            statusFilter(status);
            break;
        case '203':
            statusFilter(status);
            break;
        case '204':
            statusFilter(status);
            break;
        default:
            classList($);
    }
});


function statusFilter(status) {
    var request = $.ajax({
        'url': '/curricula.json'
    });
    request.done(function (curricula) {

        console.log(curricula);

        var html = '<table class="highlight"><thead><tr><th>Course Name</th><th class="hide-on-med-and-down">Location</th><th class="hide-on-med-and-down">Start Date</th><th class="hide-on-med-and-down">End Date</th><th class="hide-on-med-and-down">Status</th><th>Instructors</th></tr></thead><tbody>';
        curricula.forEach(function (cur) {
            cur.courses.forEach(function (course) {
                console.log(course.status + ' ' + status);
                if (course.status.id == status) {

                    if (course.startDate === null) {
                        course.startDate = "tbd";
                    } else {
                        course.startDate = dateShift(course.startDate);
                    }
                    if (course.endDate === null) {
                        course.endDate = "tbd";
                    } else {
                        course.endDate = dateShift(course.endDate);
                    }
                    if (course.location === null) {
                        course.location = "tbd";
                    }


                    html += `<tr><td>${cur.name}</td><td class="hide-on-med-and-down">${course.location}</td><td class="hide-on-med-and-down">${course.startDate}</td><td class="hide-on-med-and-down">${course.endDate}</td><td class="hide-on-med-and-down">${course.status.name}</td><td>`;
                    course.instructors.forEach(function (element) {
                        html += ` ${element.first_name} ${element.last_name}`
                    })
                }
            });

        });
        html += '</tbody>';
        $('#classlist').html(html);
    })
}

