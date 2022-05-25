<%-- 
    Document   : create
    Created on : Jan 20, 2022, 12:47:25 PM
    Author     : PHT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="row page-header">
    <div class="col">
        Edit Toys
    </div>
</div>
<div class="row page-body">
    <div class="col">
        <form action="${pageContext.request.contextPath}/toy/update.do" method="post">
            <div class="mb-3 mt-3">
                <label for="id" class="form-label">Id:</label>
                <input type="hidden" class="form-control" value="${toy.id}" id="id" placeholder="Enter toy id" name="id" >
                <input type="text" class="form-control" value="${toy.id}" id="id" placeholder="Enter toy id" name="id" disabled>
            </div>
            <div class="mb-3">
                <label for="name" class="form-label">Name:</label>
                <input type="text" class="form-control" value="${toy.name}" id="name" placeholder="Enter toy name" name="name">
            </div>
            <div class="mb-3">
                <label for="price" class="form-label">Price:</label>
                <input type="number" step="0.01" class="form-control" value="${toy.price}" id="price" placeholder="Enter toy price" name="price">
            </div>
            <div class="mb-3">
                <label for="expDate" class="form-label">Expired date:</label>
                <input type="date" class="form-control" value="${toy.expDate}" id="expDate" placeholder="Enter toy expired date" name="expDate">
            </div>
            <div class="mb-3">
                <label for="brandId" class="form-label">Brand id:</label>
                <input type="text" class="form-control" value="${toy.brandId}" id="brandId" placeholder="Enter toy brand id" name="brandId">
            </div>
            <button type="submit" class="btn btn-sm btn-outline-success" name="op" value="update"><i class="bi bi-check-circle"></i> Update</button> 
            <button type="submit" class="btn btn-sm btn-outline-danger" name="op" value="cancel"><i class="bi bi-x-circle"></i> Cancel</button>
        </form>
        <div style="font-style: italic;color: red;">${errorMessage}</div>
    </div>
    <div class="col">

    </div>
</div>