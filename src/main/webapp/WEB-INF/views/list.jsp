<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>            
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  

list.jsp<br>

레코드 갯수 : ${ fn:length(lists) }<br><br>


<table border="1">
	<tr>
		<td>번호</td>
		<td>아이디</td>
		<td>이름</td>
		<td>나이</td>
	</tr>

	<c:forEach var="lists" items="${ lists }">
			
		<tr>
			<td>${ lists.num }</td>
			<td>
				<a href="delete?num=${ lists.num }">${ lists.id }</a>
			</td>
			<td>
				<a href="content_view?num=${ lists.num }">${ lists.name }</a>
			</td>
			<td>${ lists.age }</td>
		</tr>
		
	</c:forEach>

</table>

<a href="write_view">삽입</a>
