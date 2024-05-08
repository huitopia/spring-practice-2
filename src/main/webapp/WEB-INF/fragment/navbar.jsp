<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Prj2</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/">Home</a>
                </li>
                <sec:authorize access="not isAuthenticated()">
                    <li class="nav-item">
                        <a class="nav-link" href="/member/signup">SighUp</a>
                    </li>
                </sec:authorize>
                <sec:authorize access="not isAuthenticated()">
                    <li class="nav-item">
                        <a class="nav-link" href="/member/login">LogIn</a>
                    </li>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                    <li class="nav-item">
                        <a class="nav-link" href="/logout">LogOut</a>
                    </li>
                </sec:authorize>
            </ul>
        </div>
    </div>
</nav>

<div>
    <sec:authentication property="principal"></sec:authentication>
</div>