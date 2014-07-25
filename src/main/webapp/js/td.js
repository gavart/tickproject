var URL = "http://localhost:8080/tickproject.ua";
$(document).ready(function() {
    disableButton();
    $(document).tooltip();

    $('td').not('.row_title').on('click', function(){
        $(this).toggleClass('checked');
        var checkedElements = $('td.checked');
        validSelection(checkedElements);
    });

    $('#clear_pick').on('click', function(){
        $('td.checked').removeClass('checked');
    });

    $('#booking').on('click', function(){
        var checkedElements = $('td.checked');
        checkedElements.removeClass('active').removeClass('checked').addClass('booked');
    });

    $('#sell').on('click', function(){
        var checkedElements = $('td.checked').unbind('click');
        var rowsAndSeatsArray = new Array();
        $.each(checkedElements, function(){
            rowsAndSeatsArray.push($(this).attr('rowAndSeatID'));
        });
        sendSoldTickets(rowsAndSeatsArray);
        checkedElements.removeClass('active').removeClass('checked').removeClass('booked').addClass('sold');
    });
});
function sendSoldTickets(rowandseatsID){
    console.log(rowandseatsID);
    $.post(URL+'/sellseats',
        {"actionID": localStorage.getItem('current-action'), "rowandseatsID[]":rowandseatsID},
        function(serverResponse) {
            alert(serverResponse);
        });
}
function validSelection(arrayElements){
    console.log(arrayElements);
    if (($(arrayElements).hasClass('active') && $(arrayElements).hasClass('sold') && $(arrayElements).hasClass('booked'))
        ||
        ($(arrayElements).hasClass('active') && $(arrayElements).hasClass('sold'))
        ||
        ($(arrayElements).hasClass('sold') && $(arrayElements).hasClass('booked'))
        ||
        ($(arrayElements).hasClass('active') && $(arrayElements).hasClass('booked'))
        ||
        ($(arrayElements).length == 0)
        )
        {
           disableButton();
        }
    else if ($(arrayElements).hasClass('sold'))
        {
            $('#booking').attr('disabled', true);
        }
    else if ($(arrayElements).hasClass('booked'))
    {
        enableButton();
        $('#booking').attr('disabled', true);
    }
    else
        {
            enableButton();
        }
}
function disableButton(){
    $('#sell').attr('disabled', true);
    $('#booking').attr('disabled', true);
    /*added code for div massage*/
    console.log('disabled button with id #sell and #booking');
}
function enableButton(){
    $('#sell').removeAttr('disabled');
    $('#booking').removeAttr('disabled');
}