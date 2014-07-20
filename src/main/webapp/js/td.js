$(document).ready(function() {
    $('td').not('.row_title').click(function(){
        $(this).toggleClass('checked');
    });
    $('a.clear_seats').click(function(){
        $('td.checked').removeClass('checked');
    });
});