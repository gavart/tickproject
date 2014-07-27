var URL = "http://localhost:8080/tickproject.ua";
$(document).ready(function() {
    disableButton();
    $(document).tooltip();

    $('td').not('.row_title').not('.table-hover').on('click', function(){
        $(this).toggleClass('checked');
        var checkedElements = $('td.checked');
        validSelection(checkedElements);
    });

    $('#clear_pick').on('click', function(){
        $('td.checked').removeClass('checked');
    });

    $('#booking').on('click', function(){
        var checkedElements = $('td.checked');
        var summ = 0;
        var  bookedTbody = $("table.tickInfo tbody").empty();
        $.each(checkedElements, function(index, valueElement){
            var rowText = $(valueElement).attr('rowText');
            var seattext = $(valueElement).attr('seattext');
            var price = parseFloat($(valueElement).attr('priceseat'));
            var number = index + 1;
            var rowAndSeatID = $(valueElement).attr('rowandseatid');
            summ += price;
            $(bookedTbody).append('<tr class="trTemplate" rowAndSeatID=\"'+rowAndSeatID+'\">'+'<td class="tempID">'+ number +'</td>'+'<td class="tempRow">'+ rowText +'</td>'+'<td class="tempPlace">'+ seattext +'</td>'+'<td class="tempPrice">'+ price +'</td>'+'<td class="tempA">удалить</td>'+'</tr>');
        });
        $('.modal-body p span').text(summ);

        $('td.tempA').on('click',function(){
            var seatID = $(this).parent().attr('rowandseatid');
            checkSelection(seatID);
            summ -= parseFloat($(this).attr('tempPrice'));
            $('.modal-body p span').text(summ);
            $(this).parent().remove();
        });

        $('#modalCancel').on('click',function(){
            $('#select-plase-box td').removeClass('checked');
            clearModal();
            disableButton();
        });
        //checkedElements.removeClass('active').removeClass('checked').addClass('booked');
    });

    $('#sell').on('click', function(){
        var checkedElements = $('td.checked');
        var rowsAndSeatsArray = new Array();
        $.each(checkedElements, function(){
            rowsAndSeatsArray.push($(this).attr('rowAndSeatID'));
        });
        sendSoldTickets(rowsAndSeatsArray);
        checkedElements.removeClass('active').removeClass('checked').removeClass('booked').addClass('sold');
        disableButton();
    });
});
function checkSelection(seatID){
    $('#select-plase-box td[rowandseatid='+seatID+']').toggleClass('checked');
}

function onAjax(data) {
    alert(data);
}
function sendSoldTickets(rowandseatsID){
    //console.log(rowandseatsID);
    $.post(URL+'/sellseats',
        {"actionID": localStorage.getItem('current-action'), "rowandseatsID[]":rowandseatsID},
        onAjax
    );
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
            disableButton();
            $('#return_seats').removeAttr('disabled');
        }
    else if ($(arrayElements).hasClass('booked'))
    {
        enableButton();
        $('#booking').attr('disabled', true);
    }
    else
        {
            enableButton();
            $('#return_seats').attr('disabled', true);
        }
}
function disableButton(){
    $('#sell').attr('disabled', true);
    $('#booking').attr('disabled', true);
    $('#return_seats').attr('disabled', true);
}
function enableButton(){
    $('#sell').removeAttr('disabled');
    $('#booking').removeAttr('disabled');
    $('#return_seats').removeAttr('disabled');
}
$('myModal').on('hidden', function(){
    clearModal();
});
$('myModal').on('show', function(){
    clearModal();
});
function clearModal(){
    $("table.tickInfo tbody").empty();
    $('.modal-body input').each(function(){
        $(this).val('');
    });
    $('.modal-body p span').text(0);
};