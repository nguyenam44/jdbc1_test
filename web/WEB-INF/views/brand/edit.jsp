<%-- 
    Document   : create
    Created on : Jan 20, 2022, 12:47:25 PM
    Author     : PHT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="row page-header">
    <div class="col">
        Edit Brand
    </div>
</div>
<div class="row page-body">
    <div class="col">
        <form action="${pageContext.request.contextPath}/brand/update.do">
            <div class="mb-3 mt-3">
                <label for="id" class="form-label">Id:</label>
                <input type="text" class="form-control" value="${brand.id}" id="id1" placeholder="Enter brand id" name="id1" disabled>
                <input type="hidden" class="form-control" value="${brand.id}" id="id" placeholder="Enter brand id" name="id" >
            </div>
            <div class="mb-3">
                <label for="name" class="form-label">Name:</label>
                <input type="text" class="form-control" value="${brand.name}" id="name" placeholder="Enter brand name" name="name">
            </div>
            <button type="submit" class="btn btn-sm btn-outline-success" name="op" value="update"><i class="bi bi-check-circle"></i> Update</button> 
            <button type="submit" class="btn btn-sm btn-outline-danger" name="op" value="cancel"><i class="bi bi-x-circle"></i> Cancel</button>
        </form>
        <div style="font-style: italic;color: red;">${errorMessage}</div>
    </div>
    <div class="col">

    </div>
</div>