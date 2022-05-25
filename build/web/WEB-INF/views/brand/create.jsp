<%-- 
    Document   : create
    Created on : Feb 9, 2022, 4:49:35 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="row page-header">
    <div class="col">
        Create Brand
    </div>
</div>
<div class="row page-body">
    <div class="col">
        <form action="${pageContext.request.contextPath}/brand/save.do" method="post">
            <div class="mb-3 mt-3">
                <label for="id" class="form-label">Id:</label>
                <input type="text" class="form-control" value="${id}" id="id" placeholder="Enter brand id" name="id">
            </div>
            <div class="mb-3">
                <label for="name" class="form-label">Name:</label>
                <input type="text" class="form-control" value="${name}" id="name" placeholder="Enter brand name" name="name">
            </div>
            <button type="submit" class="btn btn-sm btn-outline-success" name="op" value="save"><i class="bi bi-check-circle"></i> Save</button> 
            <button type="submit" class="btn btn-sm btn-outline-danger" name="op" value="cancel"><i class="bi bi-x-circle"></i> Cancel</button>
        </form>
        <div style="font-style: italic;color: red;">${errorMessage}</div>
    </div>
    <div class="col">

    </div>
</div>
