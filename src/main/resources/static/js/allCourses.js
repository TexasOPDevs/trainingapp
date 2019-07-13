(function($) {

    var request = $.ajax({
        'url': '/courses.json'
    });
    request.done(function (courses) {

        console.log(courses);
        var html =
            `<table class="highlight">` +
            `<thead>`+
            `<tr>`+
            `<th>Course</th>` +
            `<th>Organization</th>` +
            `<th>Start Date</th>` +
            `</tr>`+
            `</thead><tbody>`;
        courses.forEach(function(course) {
            html +=
                `<tr>`+
                `<td><a href="#">${course.curriculum.name}</a></td>`+
                `<td><a href="#">${course.curriculum.provider.name}</a></td>`+
                `<td>${course.start_date}</td>`+
                `</tr>`
    });
        html += '</tbody></table>';
        $('#coursesTable').html(html);
    });

})(jQuery);


