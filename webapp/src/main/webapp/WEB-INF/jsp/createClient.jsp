<%@include file="common/navbar.jsp" %>

<div>
    <h4 class="card-title mt-3 text-center">Create new client</h4>

    <form action="${pageContext.request.contextPath}/createClient" method="post">
        <div>
            <input name="name" placeholder="Name" type="text" required/>
        </div>
        <div>
            <input name="address" placeholder="Address" type="text"/>
        </div>
        <div>
            <label>
                <select>
                    <c:forEach var="manager" items="${managers}">
                        <option value="manager">"${manager.name} ${manager.surname}"</option>
                    </c:forEach>
                </select>
            </label>
        </div>
        <div>
            <button type="submit" class="btn btn-primary btn-block"
                    onclick="return confirm('Are you sure?')"> Create
            </button>
        </div>
    </form>
</div>
<!--container end.//-->
<%@include file="common/footer.jsp" %>