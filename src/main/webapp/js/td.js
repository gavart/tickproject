$(document).ready(function() {
    $(document).tooltip();
    $('span.details').html('');

    $('td').not('.row_title').not('.sold').on('click', function(){
        $(this).toggleClass('checked');
        var tdCheck = $('td.checked');
        var summ = 0;
        $.each(tdCheck, function(index, element) {
            summ += parseFloat(tdCheck.attr('priceseat'));
        });
        $('span.details').html(summ);
    });

    $('#clear_seats').on('click', function(){
        $('td.checked').removeClass('checked');
        $('span.details').html('');
    });

    $('#sell').on('click', function(){
        var checkedElements = $('td.checked').unbind('click');
        var rowsAndSeatsArray = new Array();
        $.each(checkedElements, function(){
            rowsAndSeatsArray.push($(this).attr('rowAndSeatID'));
        });
        //console.log(rowsAndSeatsArray);
        sendSoldTickets(rowsAndSeatsArray);
        checkedElements.removeClass('active').removeClass('checked').addClass('sold');
        $('span.details').html('');
    });
});
function sendSoldTickets(arrayRowAndSeatsID){
    $.post('http://localhost:8088/tickproject.ua/sellSeats',
        {actionID: localStorage.getItem('current-action'), rowandseatsID:arrayRowAndSeatsID},
        function(serverResponse) {
            alert(serverResponse);
        });
}
