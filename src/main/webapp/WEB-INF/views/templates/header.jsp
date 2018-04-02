<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Heroic Features - Start Bootstrap Template</title>

<!-- Bootstrap core CSS -->
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<!-- Custom styles for this template -->
<link href="<c:url value="/resources/css/heroic-features.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/myapp.js" />"></script>
</head>

<body>

	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav navbar-left">
					<li class="nav-item" id="home"><a class="nav-link"
						href="<c:url value="/" />">Home
					</a></li>
					<li class="nav-item" id="product"><a class="nav-link"
						href="<c:url value="${contextRoot}/product" />">Products</a></li>
				</ul>
				<ul class="navbar-nav pull-right">
					<c:if test="${pageContext.request.userPrincipal.name != null}">
						<li><a class="nav-link">Welcome:
								${pageContext.request.userPrincipal.name}</a></li>
						<li><a class="nav-link"
							href="<c:url value="/j_spring_security_logout" />">Logout</a></li>

						<%-- <c:if test="${pageContext.request.userPrincipal.name != 'admin'}">
							<li><a href="<c:url value="/order" />">Order</a></li>
						</c:if> --%>

						<c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
							<li class="nav-item"><a href="<c:url value="/admin" />"
								class="nav-link">Admin</a></li>
						</c:if>

					</c:if>

					<c:if test="${pageContext.request.userPrincipal.name == null}">
						<li class="nav-item"><a href="<c:url value="/login" />"
							class="nav-link">Login</a></li>
					</c:if>
				</ul>
			</div>
		</div>
	</nav>