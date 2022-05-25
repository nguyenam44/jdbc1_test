<%-- 
    Document   : main
    Created on : Jan 18, 2022, 12:37:18 PM
    Author     : PHT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Jdbc1</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <link href="${pageContext.request.contextPath}/css/site.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <!--Header-->
        <div class="container p-5 bg-warning text-white text-center">
            <h1>Jdbc Example</h1>
        </div>
        <!--Navigation-->
        <div class="container">
             <nav class="navbar navbar-expand-sm bg-light navbar-light">
             <div class="container">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link active" href="${pageContext.request.contextPath}/">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/toy/index.do">Toy</a>
                    </li>  
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/brand/index.do">Brand</a>
                    </li> 
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/equation/equation1.do">Equation1</a>
                    </li>
                </ul>
            </div>
        </nav>
    </div>
    <!--Contents-->
    <div class="container mt-5">
        <div class="row">
            <div class="col">
                <jsp:include page="/WEB-INF/views/${controller}/${action}.jsp" />
            </div>            
        </div>
    </div>
    <!--Footer-->
    <div class="container p-1 bg-warning text-white text-center">
        Copyright 2021-2022 by PRJ. All Rights Reserved.
    </div>    

</body>
</html>