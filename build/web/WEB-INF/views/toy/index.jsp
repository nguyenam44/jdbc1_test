<%-- 
    Document   : index
    Created on : Jan 13, 2022, 1:00:28 PM
    Author     : PHT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h1>List of Toys</h1>
<hr/>
<a class="btn btn-sm btn-outline-success" href="${pageContext.request.contextPath}/toy/create.do"><i class="bi bi-plus-circle"></i> Create New</a> 
<table class="table table-striped">
    <thead>
        <tr>
            <th>#</th>
            <th>Id</th>
            <th>Name</th>
            <th style="text-align: right;">Price</th>
            <th style="text-align: right;">Expired Date</th>
            <th>Brand Id</th>
            <th>Operation</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="toy" items="${list}" varStatus="count">
            <tr>
                <td>${count.index + 1}</td>
                <td>${toy.id}</td>
                <td>${toy.name}</td>
                <td style="text-align: right;"><fmt:formatNumber value="${toy.price}" pattern="$ #,##0.00" /></td>
                <td style="text-align: right;"><fmt:formatDate value="${toy.expDate}" pattern="MM-dd-yyyy" /></td>
                <td>${toy.brandId}</td>
                <td>
                    <a class="btn btn-sm btn-outline-success" href="${pageContext.request.contextPath}/toy/edit.do?id=${toy.id}"><i class="bi bi-pencil-square"></i> Edit</a> 
                    <a class="btn btn-sm btn-outline-danger" href="${pageContext.request.contextPath}/toy/confirm.do?id=${toy.id}"><i class="bi bi-x-circle-fill"></i> Delete</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

