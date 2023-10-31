<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path1" value="${pageContext.servletContext.contextPath }" />
<!doctype html>
<html lang="en">
<head>
    <jsp:include page="../include/head.jsp" />
</head>
<body>

<%--헤더 임포트--%>
<jsp:include page="../include/header.jsp"/>
<%--헤더 임포트--%>

<table class="pure-table">
    <thead>
    <tr>
        <th>#</th>
        <th>ID</th>
        <th>NAME</th>
        <th>DATE</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="userList" items="${userList}" varStatus="status">
    <tr>
        <td>${status.count}</td>
        <td>${userList.id}</td>
        <td>${userList.username}</td>
        <td>${userList.regdate}</td>
    </tr>
    </c:forEach>
    </tbody>
</table>

<%--footer 임포트 --%>
<jsp:include page="../include/footer.jsp"/>
<%--footer 임포트 --%>

</body>
</html>