<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 21.07.14
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="setPricesDIV" class="hide">
    <c:forEach items="${defaultPrices}" var="defaultPrice" varStatus="loop">
        <div class="setPrice">Сектор
            <span id="section[${loop.index}]" data-sectionid="${defaultPrice.sectionOfStadium.id}">${defaultPrice.sectionOfStadium.name}</span>
            <input type="hidden" value="${defaultPrice.sectionOfStadium.id}" name="sectionsId[${loop.index}]" id="sectionsId[${loop.index}]" />
            <input type="hidden" value="${defaultPrice.action.id}" name="actionsId[${loop.index}]" id="actionsId[${loop.index}]" />
            <input type="text" class="input-mini prices" placeholder="${defaultPrice.price}" id="prices[${loop.index}]" name="prices[${loop.index}]" value="${defaultPrice.price}" size="10"  />
        </div>
    </c:forEach>
</div>

<!--onkeyup="return proverka(this);" onchange="return proverka(this);"-->