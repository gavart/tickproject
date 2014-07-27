var URL = "http://localhost:8080/tickproject.ua";
$(document).ready(function() {
    disableButton();
    $(document).tooltip();

    $('td').not('.row_title').not('.tickInfo').on('click', function(){
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
            $(this).parent().remove();
            var summa = 0;
            $('.modal-body td.tempPrice').each(function(){
                summa += parseFloat($(this).text());
            });
            $('.modal-body p span').text(summa);
        });
    });

    $('#sell').on('click', function(){
        var checkedElements = $('td.checked');
        var rowsAndSeatsArray = new Array();
        $.each(checkedElements, function(){
            rowsAndSeatsArray.push($(this).attr('rowAndSeatID'));
        });
        //sendSoldTickets(rowsAndSeatsArray);
        sendToServer(3, rowsAndSeatsArray,'','');
        checkedElements.removeClass('active').removeClass('checked').removeClass('booked').addClass('sold');
        disableButton();
    });
/*
    $('td.booked').not('.row_title').not('.tickInfo').on('click', function(){

        var customerID = $(this).attr('customerID');
        var arrayBooking = ('td.booked[customerID = '+customerID+']');
        $.each(arrayBooking, function(index, element){
            var rowText = $(valueElement).attr('rowText');
            var seattext = $(valueElement).attr('seattext');
            var price = parseFloat($(valueElement).attr('priceseat'));
            var number = index + 1;
            var rowAndSeatID = $(valueElement).attr('rowandseatid');
            summ += price;
            $(bookedTbody).append('<tr class="trTemplate" rowAndSeatID=\"'+rowAndSeatID+'\">'+'<td class="tempID">'+ number +'</td>'+'<td class="tempRow">'+ rowText +'</td>'+'<td class="tempPlace">'+ seattext +'</td>'+'<td class="tempPrice">'+ price +'</td>'+'<td class="tempA">удалить</td>'+'</tr>');
        });
    });*/
    $('#modalCancel').click(function(){
        $('#select-plase-box td').removeClass('checked');
        clearModal();
        disableButton();
    });

    $('#modalBooking').click(function(){

        if (!(($.trim($('.modal-body input.lastName').val()) == '')&&($.trim($('.modal-body input.firstName').val()) == '')))
        {
            if (checkValidTick())
            {
                var rowandseatsID = new Array();
                var arrayElemets = $('.modal-body table tbody tr');
                $.each(arrayElemets, function(){
                    rowandseatsID.push($(this).attr('rowAndSeatID'));
                });
                var lastName = $('.modal-body input.lastName').val();
                var firstName = $('.modal-body input.firstName').val();
                sendToServer(2,rowandseatsID,firstName,lastName);
                disableButton();
            }
            else
            {
                alert('ОШИБКА!!! Среди выбраных билетов есть проданый');
                $('#modalCancel').click();
            }
            //checkedElements.removeClass('checked').addClass('booked');
        }
        else
        {
            alert('Заполните инормацию о человеке который заказывает бронь!');
        }
    });
});
function checkSelection(seatID){
    $('#select-plase-box td[rowandseatid='+seatID+']').toggleClass('checked');
}

function onAjax(data) {
    location.reload(true);
    console.log(data);
}
/*function sendSoldTickets(rowandseatsID){
    //console.log(rowandseatsID);
    $.post(URL+'/sellseats',
        {"actionID": localStorage.getItem('current-action'), "rowandseatsID[]":rowandseatsID},
        onAjax
    );
}*/
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
/*
$('myModal').modal('hidden', function(){

});
$('myModal').on('show', function(){
    //clearModal();
});*/
function clearModal(){
    $("table.tickInfo tbody").empty();
    $('.modal-body input').each(function(){
        $(this).val('');
    });
    $('.modal-body p span').text(0);
};

function checkValidTick(){
    return true;
}
function sendToServer(statusID, rowandseatsIDarray, firstName, lastName) {
    $.post(URL+'/sellseats',
        {"actionID": localStorage.getItem('current-action'), "rowandseatsID[]":rowandseatsIDarray, "firstName": firstName, "lastName": lastName , "statusID": statusID },
        onAjax
    );
    if (statusID == 2)
        {
            $('#modalCancel').click();
        }
}