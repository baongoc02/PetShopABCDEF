<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach items='${requestScope["error_messages"]}' var='map'>
	<div class="alert alert-danger" role="alert">
	 ${map}
	</div>
</c:forEach>