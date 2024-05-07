<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>SignUp</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.3/css/bootstrap.min.css"
          integrity="sha512-jnSuA4Ss2PkkikSOLtYs8BlYIeeIK1h99ty4YfvRPAlzr377vr3CXDb7sb7eEEBYjDtcYj+AjBH3FLv5uSJuXg=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
</head>
<body>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-6">
            <h3 class="mb-4">SignUp</h3>
            <form action="member/signup" method="post">
                <div class="mb-3">
                    <label for="inputEmail" class="form-label">Email</label>
                    <div class="input-group">
                        <input type="email" class="form-control" id="inputEmail" required>
                        <button type="button" class="btn btn-outline-secondary" id="buttonEmailCheck"
                                onclick="emailCheck()">
                            중복 확인
                        </button>
                    </div>
                </div>
                <div class="mb-3">
                    <label for="inputPassword" class="form-label">Password</label>
                    <input type="password" class="form-control" id="inputPassword">
                </div>
                <div class="mb-3">
                    <label for="inputPassword2" class="form-label">Check Password</label>
                    <input type="password" class="form-control" id="inputPassword2">
                </div>
                <div class="mb-3">
                    <label for="inputNickName" class="form-label">NickName</label>
                    <input type="text" class="form-control" id="inputNickName">
                </div>
                <button class="btn btn-outline-primary">
                    SignUp
                </button>
            </form>
        </div>
    </div>
</div>
<script>
    async function emailCheck() {
        const inputEmail = document.querySelector("#inputEmail").value;
        const url = "/member/email?email=" + inputEmail;

        // ajax 요청
        const response = await fetch(encodeURI(url));
        alert(await response.text());
    }
</script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.3/js/bootstrap.min.js"
        integrity="sha512-ykZ1QQr0Jy/4ZkvKuqWn4iF3lqPZyij9iRv6sGqLRdTPkY69YX6+7wvVGmsdBbiIfN/8OdsI7HABjvEok6ZopQ=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</body>
</html>
