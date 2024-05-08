<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>modify</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.3/css/bootstrap.min.css"
          integrity="sha512-jnSuA4Ss2PkkikSOLtYs8BlYIeeIK1h99ty4YfvRPAlzr377vr3CXDb7sb7eEEBYjDtcYj+AjBH3FLv5uSJuXg=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
</head>
<body>
<c:import url="/WEB-INF/fragment/navbar.jsp"></c:import>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-6">
            <form action="/modify?id=${board.id}" method="post">
                <div class="mb-3">
                    <label for="inputTitle" class="col-sm-2 col-form-label">Title</label>
                    <input type="text" class="form-control" id="inputTitle"
                           required value="${board.title}" name="title">
                </div>
                <div class="mb-3">
                    <label for="textareaControl" class="form-label">Content</label>
                    <textarea id="textareaControl" class="form-control" name="content">${board.content}</textarea>
                </div>
                <div>
                    <input type="hidden" name="memberId" value="${board.memberId}">
                </div>
                <div>
                    <sec:authorize access="isAuthenticated()">
                        <sec:authentication property="principal.member" var="authMember"></sec:authentication>
                        <c:if test="${authMember.id eq board.memberId}">
                            <button type="submit" class="btn btn-outline-info">Update</button>
                            <a href="/delete?id=${board.id}" class="btn btn-outline-danger" role="button">Delete</a>
                        </c:if>
                    </sec:authorize>
                </div>
            </form>
        </div>
    </div>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.3/js/bootstrap.min.js"
        integrity="sha512-ykZ1QQr0Jy/4ZkvKuqWn4iF3lqPZyij9iRv6sGqLRdTPkY69YX6+7wvVGmsdBbiIfN/8OdsI7HABjvEok6ZopQ=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</body>
</html>
