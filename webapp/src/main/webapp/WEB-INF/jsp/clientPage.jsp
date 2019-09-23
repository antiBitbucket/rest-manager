<%@include file="common/navbar.jsp" %>

<table cellspacing="0">
    <tr>
        <th>Code</th>
        <th>Name</th>
        <th>Address</th>
        <th>Full manager name</th>
        <th>Phone</th>
        <th>Second phone</th>
    </tr>
    <tr>
        <td>${client.id}</td>
        <td>${client.name}></td>
        <td>${client.address}</td>
        <td>${client.manager.surname} ${client.manager.name} ${client.manager.middlename}</td>
        <td>${client.manager.phone}</td>
        <td>${client.manager.assistant.phone}</td>
    </tr>
</table>
<form action="${pageContext.request.contextPath}/updateClient?clientId=${client.id}"
      method="GET">
    <button class="btn btn-danger" type="submit">
        <span>Edit</span>
    </button>
</form>

<%@include file="common/footer.jsp" %>
