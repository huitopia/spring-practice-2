<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>MemberList</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.3/css/bootstrap.min.css"
          integrity="sha512-jnSuA4Ss2PkkikSOLtYs8BlYIeeIK1h99ty4YfvRPAlzr377vr3CXDb7sb7eEEBYjDtcYj+AjBH3FLv5uSJuXg=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
</head>
<body>
<c:import url="/WEB-INF/fragment/navbar.jsp"></c:import>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-7">
            <h3 class="mb-4">MemberList</h3>
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>#</th>
                    <th style="width: 30%">email</th>
                    <th>nickName</th>
                    <th>insertedDate</th>
                    <th>authority</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${memberList}" var="member">
                    <tr>
                        <td>${member.id}</td>
                        <td>
                            <a href="/member/view?id=${member.id}">${member.email}</a>
                        </td>
                        <td>${member.nickName}</td>
                        <td>${member.insertedDate}</td>
                        <td>${member.authority}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.3/js/bootstrap.min.js"
        integrity="sha512-ykZ1QQr0Jy/4ZkvKuqWn4iF3lqPZyij9iRv6sGqLRdTPkY69YX6+7wvVGmsdBbiIfN/8OdsI7HABjvEok6ZopQ=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</body>
</html>
