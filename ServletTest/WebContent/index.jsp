<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="testPost" method="post">
	<fieldset>
	<legend>실습폼  - 3</legend>
		<ul>
			<li>
				<label for="id">아이디</label>
				<input type="text" id="userId" name="userId" required placeholder="아이디를 입력하세요.">
			</li>
			<br>
			<li>
				<label for="password">비밀번호</label>
				<input type="text" id="password" name="password" >
			</li>
			<br>
			<li>
				<label for="mobile">휴대폰</label>
				<input type="text" id="mobile" name="mobile" >
			</li>
			<br>
			<li>
				<label for="email">이메일</label>
				<input type="email" id="email" name="email" >
			</li>
		</ul>
	</fieldset>
	<div>
		<input type="submit" value="전송" style="margin-left: 100px; margin-top: 20px;">
	</div>
</form>
</body>
</html>