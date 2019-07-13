(function($) {

    var request = $.ajax({
        'url': '/course.json'
    });
    request.done(function (courses) {

        console.log(courses);
        var html = '<table class="highlight"><thead><tr><th>Course Name</th><th>Location</th><th>Start Date</th><th>End Date</th><th>Materials</th><th>Capacity</th></tr></thead><tbody>';
        courses.forEach(function(course) {
           html += `<tr><td>${course.curriculum.name}</td><td>${course.location}</td><td>${course.start_date}</td><td>${course.end_date}</td><td>`;
           course.curriculum.materials.forEach(function(element){
               html += ` ${element.name}`
           });
            html += `</td><td>${course.curriculum.capacity}</td>`;
        });
        html += '</tbody></table>';
        $('#courselist').html(html);
    });
})(jQuery);

