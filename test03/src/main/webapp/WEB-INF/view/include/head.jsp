<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path1" value="${pageContext.servletContext.contextPath }" />


<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="A layout example that shows off a responsive pricing table.">
<title>회원 상세보기</title>

<%-- pure css --%>
<link rel="stylesheet" href="${path1}/resources/css/pure-min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/grids-responsive-min.css" />
<link rel="stylesheet" href="${path1}/resources/css/style.css">
<%-- pure css --%>


<%-- bulma css--%>
<link rel="stylesheet" href="">
<link rel="stylesheet" href="">
<%-- bulma css--%>