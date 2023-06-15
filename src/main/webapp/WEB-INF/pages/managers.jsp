<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"/>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <link rel="shortcut icon" href="images/rcalogo.png" type="image/x-icon"/>
  <title>Managers List</title>
</head>
<body>
<jsp:include page="../components/headeradmin.jsp">
  <jsp:param value="marks" name="title"/>
</jsp:include>
<div class="flex flex-col w-full gap-y-4">
  <div class="flex w-full items-center justify-between">
    <h1 class="font-semibold text-xl text-center">Registered managers</h1>
    <a href="createstudent.php" class="bg-violet-800 hover:bg-violet-900 text-white gap-x-3 font-bold py-2 px-4 rounded">
      <i class="bx bx-plus"></i>  Add Manager
    </a>
  </div>
  <div class="w-full flex overflow-x-auto">
    <table class="min-w-[500px]">
      <thead>
      <tr>
        <th>ID</th>
        <th>FirstName</th>
        <th>LastName</th>
        <th>PhoneNumber</th>
        <th>Date of Birth</th>
        <th>Action</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach items="${managers}" var="manager" varStatus="usrstatus">
        <tr>
          <td>${manager.id}</td>
          <td>${manager.firstName}</td>
          <td>${manager.lastName}</td>
          <td>${manager.phoneNumber}</td>
          <td>${manager.dateOfBirth}</td>
          <td class="buttons">
            <form method="get" action="updatecourse.php/${csr.id}">
              <button type="submit">Delete</button>
            </form>
            <form  method="get" action="updatecourse.phpo/${csr.id}">
              <button type="submit">Update</button>
            </form>
          </td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>
</div>
</div>
</div>
</div>
</body>
<%--<%@ include file="../footer.jsp" %>--%>