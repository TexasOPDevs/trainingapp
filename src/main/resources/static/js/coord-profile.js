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



(function($) {

    var request = $.ajax({
        'url': '/provider.json'
    });
    request.done(function (provider) {

        console.log(provider);
        var html= `<img src="${provider.image}"><h1>${provider.name}</h1><h3>Coordinator: ${provider.coordinator.first_name} ${provider.coordinator.last_name}</h3><table class="highlight"><thead><tr><th>Name</th><th>Email</th><th>Phone</th></tr></thead><tbody>`;
        provider.users.forEach(function(element){
            html += `<tr><td>${element.first_name} ${element.last_name}</td><td>${element.email}</td><td>${element.phone}</td>`
        });
        html += '</tbody></table>';
        $('#provider').html(html);
    });
})(jQuery);