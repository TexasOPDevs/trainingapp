(function($) {

    var request = $.ajax({
        'url': '/curricula.json',

    });
    request.done(function (curricula) {

        console.log(curricula);
        var html = '<table class="highlight"><thead><tr><th>Course Name</th><th>Certification</th><th>Learning Objectives</th><th>Creation Date</th><th>Materials</th><th></th></tr></thead><tbody>';
        curricula.forEach(function(cur) {
            html += `<tr><td>${cur.name}</td><td>${cur.certification}</td><td>${cur.learning_objectives}</td><td>${cur.creation_date}</td><td>`;
            cur.materials.forEach(function(element){
                html += ` ${element.name} `
            });
            html += `</td><td> <a class="waves-effect waves-light btn modal-trigger" href="#modal-cur-${cur.id}">More Info</a>
            <div id="modal-cur-${cur.id}" class="modal">
                <div class="modal-content">
                  <h4>${cur.name}</h4>
                  <h5>Outline:</h5>
                  <p>${cur.course_outline}</p>
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



var provider = function($) {

    var request = $.ajax({
        'url': '/provider.json'
    });
    request.done(function (provider) {

        console.log(provider);




        var html=` <div class="card horizontal">
            <div class="card-image">
            <img src="${provider.image}">
            </div>
            <div class="card-stacked">
            <div class="card-content">
            <h3>${provider.name}</h3>
            <p>Coordinator: ${provider.coordinator.first_name} ${provider.coordinator.last_name}</p>
        </div>
        <div class="card-action">
            <a href="#">This is a link</a>
        </div>
        </div>
        </div>
        </div>
        </h3>`;


           html += `<table class="highlight"><thead><tr><th>Name</th><th>Email</th><th>Phone</th><th>Role</th><th>Make Instructor</th></tr></thead><tbody>`;
        provider.users.forEach(function(element){

            html += `<tr><td>${element.first_name} ${element.last_name}</td><td>${element.email}</td><td>${element.phone}</td><td>${element.role}</td><td><form method="post" action="/makeInstructor" name="employeeForm"><input class="emp_id" name="emp_id" value="${element.id}" type="hidden"/><button class="makeinstructor" name="employee" value="${element.id}" type="submit">Submit</button></form></td></tr>`

        });
        html += '</tbody></table>';
        $('#provider').html(html);
    });
};


$(function() {
    /*  Submit form using Ajax */
    $('.makeinstructor').click(function(e) {

        //Prevent default submission of form
        e.preventDefault();

    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
        //Remove all errors
       var data = $(".emp_id").val();
        $.get({
            url : '/makeInstructor',
            contentType: "application/json; charset=utf-8",
            data : JSON.stringify(data),
            dataType : "json",
            // ajaxOptions : {
            //     beforeSend: function(xhr)
            //     {
            //         xhr.setRequestHeader(token, header)
            //     }
            // },
            success : function(res) {

            }
        })
    });
    provider($);
});


(function($) {

    var request = $.ajax({
        'url': '/curricula.json'
    });
    request.done(function (curricula) {

        console.log(curricula);
        var html = '<table class="highlight"><thead><tr><th>Course Name</th><th>Location</th><th>Start Date</th><th>End Date</th><th>Status</th><th>Instructors</th></tr></thead><tbody>';
        curricula.forEach(function(cur) {
            cur.courses.forEach(function (course) {
                if (course.start_date === null){
                    course.start_date = "tbd";
                }
                if (course.end_date === null){
                    course.end_date = "tbd";
                }
                if (course.location === null){
                    course.location = "tbd";
                }
                html += `<tr><td>${cur.name}</td><td>${course.location}</td><td>${course.start_date}</td><td>${course.end_date}</td><td>${course.status.name}</td><td>`;
                course.instructors.forEach(function(element){
                    html += ` ${element.first_name} ${element.last_name}`
                })
            });
        });
        html += '</tbody></table>';
        $('#classlist').html(html);
        M.AutoInit();
    });
})(jQuery);

provider($);