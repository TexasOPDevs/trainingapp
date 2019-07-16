(function($) {

    // function formatDate(date) {
    //     var monthNames = [
    //         "January", "February", "March",
    //         "April", "May", "June", "July",
    //         "August", "September", "October",
    //         "November", "December"
    //     ];
    //
    //     var day = date.getDate();
    //     var monthIndex = date.getMonth();
    //     var year = date.getFullYear();
    //
    //     return day + ' ' + monthNames[monthIndex] + ' ' + year;
    // }

    var request = $.ajax({
        'url': '/curricula.json'
    });
    request.done(function (curricula) {

        console.log(curricula);
        var html =
            `<table class="highlight">` +
            `<thead>`+
            `<tr>`+
            `<th>Course</th>` +
            `<th>Organization</th>` +
            `<th>Start Date</th>` +
            `<th></th>` +
            `</tr>`+
            `</thead><tbody>`;
        curricula.forEach(function(cur) {
            cur.courses.forEach(function(course){
                if (course.status.name === "active") {
                    html +=
                        `<tr>` +
                        `<td><a class="modal-trigger" href="#modal-cur-id-${cur.id}">${cur.name}</a></td>` +
                        `<td><a href="#">${cur.provider.name}</a></td>` +
                        `<td>${course.start_date}</td>` +
                        `<td>`+
                            `<form method="post" action="/courses">`+
                                `<input type="hidden" name="course" value="${course.id}"/>
                                <a class="right waves-effect waves-light btn">Apply</a>
                            </form>` +
                         `</td>` +
                        `</tr>` +
                        `<div id="modal-cur-id-${cur.id}" class="modal">
                            <div class="modal-content">
                                <h4>${cur.name}</h4>
                                <h5>Location: ${course.location}</h5>
                                <p>${cur.course_outline}</p>
                                <p>${cur.description}</p>
                            </div>
                        <div class="modal-footer">
                        <a href="#!" class="modal-close waves-effect waves-green btn-flat">Close</a>
                        </div>` +
              `</div>`
                }
            });
    });
        html += '</tbody></table>';
        $('#coursesTable').html(html);
        M.AutoInit();
    });

})(jQuery);


