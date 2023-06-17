<%--
  Created by IntelliJ IDEA.
  User: carim
  Date: 4/28/2023
  Time: 9:02 AM
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="../components/mainheader.jsp">
    <jsp:param value="Edit User" name="title"/>
</jsp:include>
<%--<form--%>
<%--        class="flex rounded-md border-2 h-fit flex-col mx-auto p-4 w-full mt-28 gap-y-4 max-w-[450px]"--%>
<%--        method="PUT"--%>
<%--        action="${pageContext.request.contextPath}/modify.php/edituser/${user.getId()}"--%>
<%-->--%>
<%--    <div class="flex flex-col gap-y-1">--%>
<%--        <label class=" px-2" for="username"> Username </label>--%>
<%--        <input--%>
<%--                class="p-2 w-full border-blue-700/50 duration-300 focus:border-blue-700 rounded-md outline-none border-2"--%>
<%--                name="username"--%>
<%--                type="text"--%>
<%--                value="${user.getUsername()}"--%>
<%--                required/>--%>
<%--    </div>--%>
<%--    <div class="flex flex-col gap-y-1">--%>
<%--        <label class=" px-2" for="email"> Email </label>--%>
<%--        <input--%>
<%--                class="p-2 w-full border-blue-700/50 duration-300 focus:border-blue-700 rounded-md outline-none border-2"--%>
<%--                name="email"--%>
<%--                type="text"--%>
<%--                value="${user.getEmail()}"--%>
<%--                required/>--%>
<%--    </div>--%>
<%--    <div class="flex flex-col gap-y-1">--%>
<%--        <label class=" px-2" for="userfullname"> Full Names </label>--%>
<%--        <input--%>
<%--                class="p-2 w-full border-blue-700/50 duration-300 focus:border-blue-700 rounded-md outline-none border-2"--%>
<%--                name="userfullname"--%>
<%--                type="text"--%>
<%--                required/>--%>
<%--    </div>--%>
<%--    <div class="flex flex-col gap-y-1">--%>
<%--        <label class=" px-2" for="password"> Password </label>--%>
<%--        <input--%>
<%--                class="p-2 w-full border-blue-700/50 duration-300 focus:border-blue-700 rounded-md outline-none border-2"--%>
<%--                name="password"--%>
<%--                type="password"--%>
<%--                id="password"--%>
<%--                required/>--%>
<%--    </div>--%>
<%--    <tr>--%>
<%--        <td align="right"><b>Role</b></td>--%>
<%--        <td><select--%>
<%--                name="userRole" id="userRole" required>--%>
<%--            <option value="">Select Role</option>--%>
<%--            <c:forEach items="${userRoles}" var="userrole"--%>
<%--                       varStatus="userrolestatus">--%>
<%--                <option value="${userrole}">--%>
<%--                    <c:out value="${userrole.getRoleDescription()}"/>--%>
<%--                </option>--%>
<%--            </c:forEach>--%>
<%--        </select></td>--%>
<%--    </tr>--%>
<%--</form>--%>
<%@ include file="../components/footer.jsp" %>
</body>
</html>
