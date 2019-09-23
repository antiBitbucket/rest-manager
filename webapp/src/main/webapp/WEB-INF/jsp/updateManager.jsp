<%@include file="common/navbar.jsp" %>

<div>
    <h4 class="card-title mt-3 text-center">Edit manager</h4>

    <form action="${pageContext.request.contextPath}/updateManager" method="post">
        <div>
            <input name="surname" placeholder="Surname" type="text" value="${manager.surname}" required/>
        </div>
        <div>
            <input name="name" placeholder="Name" type="text" value="${manager.name}" required/>
        </div>
        <div>
            <input name="middlename" placeholder="Middle name" type="text" value="${manager.middlename}"/>
        </div>
        <div>
            <input name="phone" placeholder="Phone number" type="number" value="${manager.phone}" required/>
        </div>
        <div>
            <label>
                <select>
                    <c:forEach var="assistant" items="${assistants}">
                        <option value="assistant"> "${assistant.name} ${assistant.surname}"</option>
                    </c:forEach>
                </select>
            </label>
        </div>
        <div>
            <button type="submit" class="btn btn-primary btn-block"
                    onclick="return confirm('Edit?')"> Edit
            </button>
        </div>
    </form>
    <form action="${pageContext.request.contextPath}/deleteManager?managerId=${manager.id}" method="post">
        <button type="submit" class="btn btn-primary btn-block"
                onclick="return confirm('Delete?')"> Delete manager
        </button>
    </form>
</div>
<!--container end.//-->
<%@include file="common/footer.jsp" %>