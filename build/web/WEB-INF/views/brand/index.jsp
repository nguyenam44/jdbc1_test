<%-- 
    Document   : index.jsp
    Created on : Feb 9, 2022, 4:12:45 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>List of Brands</h1>
<hr/>
<a class="btn btn-sm btn-outline-success" href="${pageContext.request.contextPath}/brand/create.do"><i class="bi bi-plus-circle"></i> Create New</a> 
<table class="table table-striped">
    <thead>
        <tr>
            <th>#</th>
            <th>Id</th>
            <th>Name</th>
            <th>Operation</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="brand" items="${list}" varStatus="count">
            <tr>
                <td>${count.index + 1}</td>
                <td>${brand.id}</td>
                <td>${brand.name}</td>
                <td>
                    <a class="btn btn-sm btn-outline-success" href="${pageContext.request.contextPath}/brand/edit.do?id=${brand.id}"><i class="bi bi-pencil-square"></i> Edit</a> 
                    <a class="btn btn-sm btn-outline-danger" href="${pageContext.request.contextPath}/brand/confirm.do?id=${brand.id}"><i class="bi bi-x-circle-fill"></i> Delete</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
