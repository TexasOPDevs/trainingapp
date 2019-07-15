(function($) {

    var request = $.ajax({
        'url': '/curricula.json'
    });
    request.done(function (curricula) {

        console.log(curricula);
        var html =
            `<table class="highlight">`+
            `<thead>`+
            `<tr>`+
            `<th>ID</th>`+
            `<th>Name</th>`+
            `<th>Certification</th>`+
            `</tr>`+
            `</thead><tbody>`;
        curricula.forEach(function(curriculum) {
            html +=
                `<tr>`+
                `<td><a href="#">${curriculum.id}</a></td>`+
                `<td><a href="#">${curriculum.name}</a></td>`+
                `<td>${curriculum.certification}</td>`+
                `</tr>`
        });
        html += '</tbody></table>';
        $('#curriculaTable').html(html);
    });

})(jQuery);
