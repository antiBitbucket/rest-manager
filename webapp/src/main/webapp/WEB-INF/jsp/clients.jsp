<%@include file="common/navbar.jsp" %>

<th colspan="3">Clients</th>
<table cellspacing="0">
    <tr>
        <th>Code</th>
        <th>Name</th>
        <th>Address</th>
        <th>Full manager name</th>
        <th>Phone</th>
        <th>Second phone</th>
    </tr>
    <c:forEach var="client" items="${clients}">
        <tr>
            <td>${client.id}</td>
            <td><a href="${pageContext.request.contextPath}/showClientPage?clientId=${client.id}"/>
                <c:out value="${client.name}"/></td>
            <td>${client.address}</td>
            <td>${client.manager.surname} ${client.manager.name} ${client.manager.middlename}</td>
            <td>${client.manager.phone}</td>
            <td>${client.manager.assistant.phone}</td>
        </tr>
    </c:forEach>
</table>

<%@include file="common/footer.jsp" %>
