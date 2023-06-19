<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"/>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="shortcut icon" href="images/rcalogo.png" type="image/x-icon"/>
    <title>List of Course</title>
</head>
<body>
<jsp:include page="../components/headeradmin.jsp">
    <jsp:param value="courses" name="title"/>
</jsp:include>
<div class="flex flex-col w-full gap-y-4">
    <div class="flex w-full items-center justify-between">
        <h1 class="font-semibold text-xl text-center">${message}</h1>
        <div class="flex flex-row  gap-4">
            <a href="generate_courses_report.php" class="bg-violet-800 flex gap-4 justify-between hover:bg-violet-900 text-white  font-bold py-2 px-3 rounded">
                <i class="bx text-xl font-bold bx-download"></i>  Download excel
            </a>
            <a href="create_course.php" class="bg-violet-800 hover:bg-violet-900 text-white gap-x-3 font-bold py-2 px-4 rounded">
                <i class="bx bx-plus"></i>  Add Course
            </a>
        </div>

    </div>
    <div class="w-full flex overflow-x-auto">
        <table class="min-w-[500px]">
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Code</th>
                <th>Start Date</th>
                <th>End Date</th>
                <th>Min Students</th>
                <th>Max Students</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${courses}" var="course">
                <tr>
                    <td>${course.id}</td>
                    <td>${course.name}</td>
                    <td>${course.code}</td>
                    <td>${course.start}</td>
                    <td>${course.end}</td>
                    <td>${course.minStudent}</td>
                    <td>${course.maxStudent}</td>
                    <td class="buttons flex space-x-4 justify-end">
                        <a href="update.php?id=${course.id}&page=updateCourse">
                            <button type="submit"><i class='bx bxs-edit text-2xl'></i></button>
                        </a>
                        <a href="delete.php?id=${course.id}&page=deleteCourse">
                            <button type="submit"><i class='bx bxs-trash text-2xl'></i></button>
                        </a>
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