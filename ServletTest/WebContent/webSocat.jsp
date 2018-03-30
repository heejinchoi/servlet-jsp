<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>웹 소켓</title>
</head>
<body>
	<h1>클라이언트에서 웹 소켓을 접속하는 방법</h1>
	
	<form>
		<input type="text" id="textMessage">
		<input type="button" value="보내기" onclick="sendMessage()">
		<input type="button" value="종료" onclick="disconnect()">
	</form>
	<br><br>
	
	<!-- 결과 메시지 보여주는 창 -->
	<textarea id="messageTextArea" rows="10" cols="50" ></textarea>
	
	<script type="text/javascript">
		//ServletTest : 프로젝트 이름
		//WebSocat : 클래스 이름
		var websocat = new WebSocat("ws://localhost/WebSocatEx/websocat");
		var messageTextArea = document.getElementById("messageTextArea");
		
		//웹 소켓이 연결되었을 때 호출되는 이벤트 
		websocat.onopen = function(message) {
			messageTextArea.value += "Server Connect...\n";
		}
		
		//웹 소켓이 닫혔을 때 호출되는 이벤트
		websocat.onclose = function(message) {
			messageTextArea += "Server Disconnect...\n";
		}
		
		//웹 소켓이 에러가 났을 때 호출되는 이벤트
		websocat.onerror = function(message) {
			messageTextArea += "Error...\n";
		}
		
		//웹 소켓에서 메시지가 날아왔을 때 호출되는 이벤트
		websocat.onmessage = function(message) {
			messageTextArea.value += "Recieve From Server => " + message.data + "\n";
		}
		
		//'보내기' 버튼을 누르면 실행되는 함수
		function sendMessage() {
			var message = documnet.getElementById("textMessage");
			messageTextArea.value += "Send to Server => " + message.value + "/n";
			//웹 소켓으로 textMessage 객체의 값을 보낸다.
			websocat.send(message.value);
			//textMessage 객체의 값 초기화
			message.value = "";
		}
		
		//웹 소켓의 종료
		function disconnect(){
			websocat.close();
		}
		
		
	</script>
	
	
</body>
</html>