$(document).ready(function() {
    //add more file components if Add is clicked
    $('#addSection').click(function() {
        var sectionIndex = $('#sectionTable tr').children().length - 1;
        $('#sectionTable').append(
            '<tr>' +
                '<td>Сектор:</td>'+
                '<td><input name="names['+ sectionIndex + ']" type="text" size="40" style="color: #777;" value="Название сектора"  /></td>' +
                '<td><input name="descriptions['+ sectionIndex + ']" type="text" size="100" style="color: #777;" value="Описание сектора" /></td>'+
                '</tr>');
    });


    $("#form_add_action #isNewPrices").click ( function() {
        var checkButtton = Boolean($("#isNewPrices").is(":checked"));
        if(checkButtton == true)
        {
            $("#setPricesDIV").removeClass("hide");
            $("#setPricesDIV").addClass("show");
        }
        else {
            $("#setPricesDIV").addClass("hide");
            $("#setPricesDIV").removeClass("show");
        }
    });

    $("#form_add_action").submit(function() {

        var arr = document.getElementsByClassName('prices'),
            len = arr.length,
            data = [];

        for (var i=0; i < len; i++){

            data.push(arr[i].value);
            if(arr[i].value=="") {
                alert("Одно из полей с ценами пустое");
                return false;
            }
            if(!(checkPrice(arr[i].value))) {
                alert("Некоректно заполнены цены");
                return false;
            }


        }

        if($("#nameaction").val()=="") {
            alert("Введите название мероприятия");
            return false;
        }
        if($("#datetimeaction").val()=="") {
            alert("Укажите дату и время");
            return false;
        }


       
    });

});
function checkPrice(price) {
    return /^(([0-9]{0,10})([.,]?([0-9]{0,2})))$/g.test(price);
};

