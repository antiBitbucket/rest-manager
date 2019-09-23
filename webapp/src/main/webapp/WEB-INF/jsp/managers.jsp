<%@include file="common/navbar.jsp" %>

<th colspan="3">Managers</th>
<table cellspacing="0">
    <tr>
        <th>Full name</th>
        <th>Phone</th>
        <th>Assistant</th>
        <th>Assistant's phone</th>
    </tr>
    <c:forEach var="manager" items="${managers}">
        <tr>
            <td><a href="${pageContext.request.contextPath}/showManagerPage?managerId=${manager.id}"/>
                <c:out value="${manager.surname} ${manager.name} ${manager.middlename}"/></td>
            <td>${manager.phone}</td>
            <td><a href="${pageContext.request.contextPath}/showManagerPage?managerId=${manager.assistant.id}"/>
                <c:out value="${manager.assistant.surname} ${manager.assistant.name} ${manager.assistant.middlename}"/>
            </td>
            <td>${manager.assistant.phone}</td>
        </tr>
    </c:forEach>
</table>

<%@include file="common/footer.jsp" %>
