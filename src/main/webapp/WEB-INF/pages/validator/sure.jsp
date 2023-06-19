<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<jsp:include page="../../components/headeradmin.jsp">
  <jsp:param
          name="title" value="Create Course"/>
</jsp:include>
<form
        class="flex h-fit shadow-lg  flex-col w-[40%] p-4  mx-auto  gap-y-4"
        method="POST"
        action="delete.php?id=${id}&page=deleteMark"
>
  <h2 class=" text-center font-sans ">${message}</h2>

 <div class="flex items-center justify-center flex-row space-x-4 ">
   <button
           class="p-3 mt-1 px-3 rounded-md w-fit bg-red-500 hover:bg-violet-900 duration-300 uppercase  text-white text-sm"
           type="submit"
   >
     Delete
   </button>
   <button
           class="p-3 mt-1 px-3 rounded-md w-fit bg-violet-800 hover:bg-violet-900 duration-300 uppercase  text-white text-sm"
           type="button"
   >
     Cancel
   </button>
 </div>
</form>
<%--<%@ include file="../../components/footer.jsp" %>--%>