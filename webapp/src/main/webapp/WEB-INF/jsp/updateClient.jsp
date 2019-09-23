<%@include file="common/navbar.jsp" %>

<div>
    <h4 class="card-title mt-3 text-center">Edit client</h4>

    <form action="${pageContext.request.contextPath}/updateClient" method="post">
        <div>
            <input name="name" placeholder="Name" type="text" value="${client.name}" required/>
        </div>
        <div>
            <input name="address" placeholder="Address" type="text" value="${client.address}" required/>
        </div>

        <div>
            <button type="submit" class="btn btn-primary btn-block"
                    onclick="return confirm('Edit?')"> Edit
            </button>
        </div>
    </form>
    <form action="${pageContext.request.contextPath}/deleteClient?clientId=${client.id}" method="post">
        <button type="submit" class="btn btn-primary btn-block"
                onclick="return confirm('Are you sure of deleting?')"> Delete client
        </button>
    </form>
</div>
<!--container end.//-->
<%@include file="common/footer.jsp" %>