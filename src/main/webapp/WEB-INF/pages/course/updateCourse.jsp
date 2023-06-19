<%--
  Created by IntelliJ IDEA.
  User: Valens NIYONSENGA
  Date: 6/17/2023
  Time: 3:59 PM
  To change this template use File | Settings | File Templates.
--%>

<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<jsp:include page="../../components/headeradmin.jsp">
  <jsp:param
          name="title" value="Update Course"/>
</jsp:include>
<form
        class="flex h-fit flex-col max-w-[600px] p-4 w-full gap-y-4"
        method="POST"
        action="update.php?id=${id}&page=updateCourse"
>
  <c:if test="${message != null}">
    <span class="text-yellow-700"> ${message}</span>
  </c:if>
  <h2 class=" text-2xl ">Update Course</h2>
  <div class="flex flex-col gap-y-1">
    <label class=" px-2" for="courseName"> Name </label>
    <input
            class="p-2 w-full border-blue-700/50 duration-300 focus:border-blue-700 rounded-md outline-none border-2"
            name="courseName"
            type="text"
            value="${course.name}"
            required/>
  </div>
  <div class="flex flex-col gap-y-1">
    <label class=" px-2" for="courseCode"> Code </label>
    <input
            class="p-2 w-full border-blue-700/50 duration-300 focus:border-blue-700 rounded-md outline-none border-2"
            name="courseCode"
            type="text"
            value="${course.code}"
            required/>
  </div>
  <div class="flex flex-col gap-y-1">
    <label class=" px-2" for="minStudent"> Minimum Students </label>
    <input
            class="p-2 w-full border-blue-700/50 duration-300 focus:border-blue-700 rounded-md outline-none border-2"
            name="minStudent"
            type="number"
            value="${course.minStudent}"
            required/>
  </div>
  <div class="flex flex-col gap-y-1">
    <label class=" px-2" for="maxStudent"> Maximum Students </label>
    <input
            class="p-2 w-full border-blue-700/50 duration-300 focus:border-blue-700 rounded-md outline-none border-2"
            name="maxStudent"
            type="number"
            value="${course.maxStudent}"
            required/>
  </div>
  <div class="flex flex-col gap-y-1">
    <label class=" px-2" for="startDate"> Course Start Date </label>
    <input
            class="p-2 w-full border-blue-700/50 duration-300 focus:border-blue-700 rounded-md outline-none border-2"
            name="startDate"
            type="date"
            value="${course.start}"
            required/>
  </div>
  <div class="flex flex-col gap-y-1">
    <label class=" px-2" for="endDate"> Course Start Date </label>
    <input
            class="p-2 w-full border-blue-700/50 duration-300 focus:border-blue-700 rounded-md outline-none border-2"
            name="endDate"
            type="date"
            value="${course.end}"
            required/>
  </div>

  <button
          class="p-3 mt-1 px-9 rounded-md w-fit bg-violet-800 hover:bg-violet-900 duration-300 uppercase  text-white text-sm"
          type="submit"
  >
    Update Course
  </button>
</form>
<%@ include file="../../components/footer.jsp" %>