(function($) {

    var request = $.ajax({
        'url': '/all-courses.json'
    });
    request.done(function (curricula) {

        console.log(curricula);
        var html =
            `<table class="highlight">` +
            `<thead>`+
            `<tr>`+
            `<th>Course</th>` +
            `<th>Organization</th>` +
            `<th>End Date</th>` +
            `</tr>`+
            `</thead><tbody>`;
        curricula.forEach(function(cur) {
            cur.courses.forEach(function(course) {
                    if (course.status.name === "approved") {
                    html +=
                        `<tr>` +
                        `<td><a class="modal-trigger" href="#modal-cur-id-${cur.id}">${cur.name}</a></td>` +
                        `<td><a href="#">${cur.provider.name}</a></td>` +
                        `<td>${course.start_date}</td>` +
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
        $('#studentTable').html(html);
        M.AutoInit();
    });

})(jQuery);
