<%@include file="common/navbar.jsp" %>

<div class="container">
    <div class="row">
        <div class="col-md-4">
            <c:out value=" Manager: ${manager.surname} ${manager.name} ${manager.middlename}"/>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th colspan="3">Clients</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="client" items="${clients}">
                    <tr>
                        <td style="width: 60%">
                            <c:out value="${client.id}"/>
                        </td>
                        <td style="width: 60%">
                            <a href="${pageContext.request.contextPath}/showClientPage?clientId=${client.id}"
                            <c:out value="${client.name}"/>
                        </td>
                        <td style="width: 60%; word-break: break-all;">
                            <c:out value="Legal address: ${client.address}"/>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="col-md-4">
            <a href="${pageContext.request.contextPath}/updateManager?managerId=${manager.id}" class="button">
                Edit manager
            </a>
        </div>
    </div>
</div>

<%@include file="common/footer.jsp" %>
