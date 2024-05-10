<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Member</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.3/css/bootstrap.min.css"
          integrity="sha512-jnSuA4Ss2PkkikSOLtYs8BlYIeeIK1h99ty4YfvRPAlzr377vr3CXDb7sb7eEEBYjDtcYj+AjBH3FLv5uSJuXg=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
</head>
<body>
<c:import url="/WEB-INF/fragment/navbar.jsp"></c:import>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-6">
            <h3 class="mb-4">Member</h3>
            <div class="mb-2 row">
                <label for="inputEmail" class="col-sm-2 col-form-label">Email</label>
                <div class="col-sm-10">
                    <input type="email" class="form-control-plaintext" id="inputEmail"
                           readonly value="${member.email}">
                </div>
            </div>
            <div class="mb-2 row">
                <label for="inputNickName" class="col-sm-2 col-form-label">NickName</label>
                <div class="col-sm-10">
                    <input type="email" class="form-control-plaintext" id="inputNickName"
                           readonly value="${member.nickName}">
                </div>
            </div>
            <div class="mb-3 row">
                <label for="inputDate" class="col-sm-2 col-form-label">Date</label>
                <div class="col-sm-10">
                    <input type="datetime-local" class="form-control-plaintext" id="inputDate"
                           readonly value="${member.insertedDate}">
                </div>
            </div>
            <div class="mb-3 row">
                <label for="inputAuthority" class="col-sm-2 col-form-label">Authority</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control-plaintext" id="inputAuthority"
                           readonly value="${member.authority}">
                </div>
            </div>
            <div>
                <sec:authorize access="isAuthenticated()">
                    <sec:authentication property="principal.member" var="authMember"></sec:authentication>
                    <c:if test="${authMember.id eq member.id}">
                        <a href="/modify?id=${board.id}" class="btn btn-outline-info" role="button">Modify</a>
                        <a href="/delete?id=${board.id}" class="btn btn-outline-danger" role="button">
                            Delete
                        </a>
                    </c:if>
                </sec:authorize>
            </div>
        </div>
    </div>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.3/js/bootstrap.min.js"
        integrity="sha512-ykZ1QQr0Jy/4ZkvKuqWn4iF3lqPZyij9iRv6sGqLRdTPkY69YX6+7wvVGmsdBbiIfN/8OdsI7HABjvEok6ZopQ=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</body>
</html>
