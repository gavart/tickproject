<%--
  Created by IntelliJ IDEA.
  User: Black Angel
  Date: 25.07.14
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title" id="myModalLabel">Новая бронь</h4>
            </div>
            <div class="modal-body">
                <input type="text" class="input-medium" placeholder="Введите ФИО">
                <input type="text" class="input-medium" placeholder="Номер телефона">

                <table class="table table-hover">
                    <td>id</td><td>ряд</td><td>место</td><td>цена</td><td>действие</td>
                    <tr></tr>
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Отмена</button>
                <button type="button" class="btn btn-primary">Забронировать</button>
            </div>
        </div>
    </div>
</div>