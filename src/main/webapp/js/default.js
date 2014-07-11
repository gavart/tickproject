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
});