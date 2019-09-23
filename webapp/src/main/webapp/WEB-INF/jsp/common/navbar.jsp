<%@include file="header.jsp" %>

    <!-- Fixed navbar -->
    <body>
        <ul>
            <li><a class="active" href="${pageContext.request.contextPath}/getHome">Main</a></li>
            <li><a href="${pageContext.request.contextPath}/getClients">Clients</a></li>
            <li><a href="${pageContext.request.contextPath}/getManagers">Managers</a></li>
            <li><a href="${pageContext.request.contextPath}/createManager">Create manager</a></li>
            <li><a href="${pageContext.request.contextPath}/createClient">Create client</a></li>
        </ul>
    </body>