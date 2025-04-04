<%-- c : 자주 사용하는 Java 코드 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- fn : 컬렉션/문자열 관련 기능 --%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 확인하기</title>
</head>
<body>
	<h3>1. 변수 선언(==속성 추가) - c:set 태그</h3>
	<pre>
		- 원하는 scope 객체에 값을 세팅할 수 있는 태그
		== 객체.setAttribute("key", value);
		
		[속성]
		
		1) var : 변수명(== key)
		2) value : 대입할 값(== value)
		3) scope : 범위 지정(page, request, session, application)
			-> 기본값은 page
	</pre>
	
	<c:set var="num1" value="10" scope="page"/>
	<c:set var="num1" value="20" scope="request"/>
	<c:set var="num1" value="30" scope="session"/>
	<c:set var="num1" value="40" scope="application"/>
	
	<h5>page - num1 : ${pageScope.num1}</h5>
	<h5>request - num1 : ${requestScope.num2}</h5>
	<h5>session - num1 : ${sessionScope.num3}</h5>
	<h5>application - num1 : ${applicationScope.num4}</h5>
</body>
</html>