<%@include file="common/navbar.jsp" %>

<div>
    <h4 class="card-title mt-3 text-center">Create new manager</h4>

    <form action="${pageContext.request.contextPath}/createManager" method="post">
        <div>
            <input name="surname" placeholder="Surname" type="text" required/>
        </div>
        <div>
            <input name="name" placeholder="Name" type="text" required/>
        </div>
        <div>
            <input name="middlename" placeholder="Middle name" type="text"/>
        </div>
        <div>
            <input name="phone" placeholder="Phone number" type="number" required/>
        </div>
        <div>
            <label>
                <select>
                    <c:forEach var="assistant" items="${assistants}">
                        <option value="assistant">"${assistant.name} ${assistant.surname}"</option>
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