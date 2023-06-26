<html xmlns:th="http://www.thymeleaf.org">

<head>
<title>Home</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<script>
function login() {
	location.href = "/hello";
}
</script>
<body>
<h1>
Hello world! (KeyCloak - OpenID)
<input type=button value="Keycloak Login (OpenID)" onclick="javascript:login();" style="height:30px;font-size:20px;">
</h1>

<p th:text="${serverTime}"> The time on the server is ${serverTime}. </p>
</body>
</html>
