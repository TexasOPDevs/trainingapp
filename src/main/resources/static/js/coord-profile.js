(function ($) {

    var request = $.ajax({
        'url': '/curricula.json',

    });
    request.done(function (curricula) {

        console.log(curricula);
        var html = '<table class="highlight"><thead><tr><th>Course Name</th><th class="hide-on-med-and-down">Creation Date</th><th class="hide-on-med-and-down">Materials</th><th></th></tr></thead><tbody>';
        curricula.forEach(function (cur) {
            html += `<tr><td>${cur.name}</td><td class="hide-on-med-and-down">${cur.creationDate}</td><td class="hide-on-med-and-down">`;
            cur.materials.forEach(function (element) {
                html += ` ${element.name} `
            });
            html += `</td><td> <a class="waves-effect waves-light btn modal-trigger" href="#modal-cur-${cur.id}">More Info</a>
            <div id="modal-cur-${cur.id}" class="modal">
                <div class="modal-content">
                  <h4>${cur.name}</h4>
                  <h5>Learning Objectives:</h5>
                  <pre><p>${cur.learning_objectives}</p></pre>
                  <h5>Description:</h5>
                  <p>${cur.description}</p>
                  <a href="">View all active classes</a>
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
})(jQuery);


var provider = function ($) {

    var request = $.ajax({
        'url': '/provider.json'
    });
    request.done(function (provider) {

        console.log(provider);


        var html = ` <div class="card horizontal">
            <div class="card-image">
            <img src="${provider.image}">
            </div>
            <div class="card-stacked">
            <div class="card-content">
            <h3>${provider.name}</h3>
            <p>Coordinator: ${provider.coordinator.first_name} ${provider.coordinator.last_name}</p>
        </div>
        <div class="card-action">
            <a href="/provider/${provider.name}">View Page</a>
        </div>
        </div>
        </div>
        </div>
        </h3>`;


        html += `<table class="highlight "><thead><tr><th>Name</th><div><th class="hide-on-med-and-down">Email</th></div><th>Phone</th><th>Role</th><th>Make Instructor</th></tr></thead><tbody>`;
        provider.users.forEach(function (element) {

            html += `<tr><td>${element.first_name} ${element.last_name}</td><td class="hide-on-med-and-down">${element.email}</td><td>${element.phone}</td><td>${element.role}</td><td><form class="employeeform" name="employeeForm"><input class="emp_id" name="emp_id" value="${element.id}" type="hidden"/><button class="makeinstructor" name="employee" value="${element.id}" type="submit">Submit</button></form></td></tr>`

        });
        html += '</tbody></table>';
        $('#provider').html(html);
    });
};

provider($);

var makeInstructor = function ($) {
    /*  Submit form using Ajax */

    $('.employeeform button').on("click", '.makeinstructor', function(e) {
        e.preventDefault();
        //Prevent default submission of form
        //event delegate
        //replace click for .on(click

        var token = $("meta[name='_csrf']").attr("content");
        var header = $("meta[name='_csrf_header']").attr("content");
        console.log(token);
        console.log(header);
        //Remove all errors
        var data = {
            token: token,
            header: header,
            emp_id: $(".emp_id").val()
        };


        $.post({
            url: '/makeInstructor',
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(data),
            dataType: "json",
            jsonpCallback:provider($),
            success: function (html) {
                provider($);
                return false;
            }
        })
    });
};


(function ($) {

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
                }
                if (course.endDate === null) {
                    course.endDate = "tbd";
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
        html += '</tbody></table>';
        $('#classlist').html(html);
        M.AutoInit();
    });
})(jQuery);


