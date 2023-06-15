<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"/>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="shortcut icon" href="images/rcalogo.png" type="image/x-icon"/>
    <title>Students List</title>
</head>
<body>
<jsp:include page="../components/headeradmin.jsp">
    <jsp:param value="users" name="title"/>
</jsp:include>
<div class="flex flex-col w-full gap-y-4">
    <div class="flex w-full items-center justify-between">
        <h1 class="font-semibold text-xl text-center">Registered students</h1>
        <a href="createstudent.php" class="bg-violet-800 hover:bg-violet-900 text-white gap-x-3 font-bold py-2 px-4 rounded">
            <i class="bx bx-plus"></i>  Add Student
        </a>
    </div>
    <div class="w-full flex overflow-x-auto">
        <table class="min-w-[500px]">
            <thead>
            <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Phone Number</th>
                <th>dateOfBirth</th>
                <th>isInternational</th>
                <th>isPartTime</th>
                <th>isRepeating</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${students}" var="usr" varStatus="usrstatus">
                <tr>
                    <td>${usr.id}</td>
                    <td>${usr.phoneNumber}</td>
                    <td>${usr.isInternational}</td>
                    <td>${usr.isPartTime}</td>
                    <td>${usr.isRepeating}</td>
                    <td>
                        <button>Edit</button>
                        <button>Delete</button>
                    </td>
                    <td><input type="checkbox" name="usrIds"
                               value="${usr.id}"/></td>
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