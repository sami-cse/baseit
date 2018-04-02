<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/WEB-INF/views/templates/header.jsp"%>

<br>
<br>
<br>
<br>
<!-- Page Content -->
<div class="container">
	<div class="row text-center">
		<div class="col-md-8">
			<c:if test="${not empty error}">
				<div class="error" style="color: #ff0000;">${error}</div>
			</c:if>
			<c:if test="${not empty msg}">
				<div class="error" style="color: #ff0000;">${msg}</div>
			</c:if>
			<h3>Login Here</h3>
			<form name="loginForm"
				action="<c:url value="/j_spring_security_check"/>" method="post">
				<div class="form-group">
					<input type="text" id="username" name="username"
						class="form-control" placeholder="Enter User Name"/>
				</div>
				<div class="form-group">
					<input type="password" id="password" name="password"
						class="form-control" placeholder="Enter Password"/>
				</div>
				<input type="submit" value="Submit" class="btn btn-primary btn-block">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form>
		</div>
	</div>
</div>