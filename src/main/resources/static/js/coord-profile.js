(function($) {

    var request = $.ajax({
        'url': '/curricula.json'
    });
    request.done(function (curricula) {

        console.log(curricula);
        var html = '<table class="highlight"><thead><tr><th>Course Name</th><th>Certification</th><th>Learning Objectives</th><th>Creation Date</th><th>Capacity</th><th>Materials</th></tr></thead><tbody>';
        curricula.forEach(function(cur) {
            html += `<tr><td>${cur.name}</td><td>${cur.certification}</td><td>${cur.learning_objectives}</td><td>${cur.creation_date}</td><td>${cur.end_date}</td><td>`;
            cur.materials.forEach(function(element){
                html += ` ${element.name} `
            });
            html += `</td><td> <a class="waves-effect waves-light btn modal-trigger" href="#modal-cur-${cur.id}">More Info</a>
            <div id="modal-cur-${cur.id}" class="modal">
                <div class="modal-content">
                  <h4>${cur.name}</h4>
                  <p>${cur.course_outline}</p>
                  <p>${cur.description}</p>
                  <a href="">View all active classes</a>
                </div>
                <div class="modal-footer">
                  <a href="#!" class="modal-close waves-effect waves-green btn-flat"></a>
                </div>
              </div>
</td>`
        });
        html += '</tbody></table>';
        $('#courselist').html(html);
        M.AutoInit();
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

