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
			<form:form
				action="${pageContext.request.contextPath}/admin/product/add"
				method="post" commandName="product" enctype="multipart/form-data">
				<div class="form-group">
				    <form:errors path="product_name" cssStyle="color:#ff0000;" />
					<form:input path="product_name" class="form-Control"
						placeholder="Add Product Name" />
				</div>
				<div class="form-group">
				    <form:errors path="product_price" cssStyle="color:#ff0000;" />
					<form:input path="product_price" class="form-Control"
						placeholder="Add Product Price" />
				</div>
				<div class="form-group">
					<form:input id="product_image" path="product_image" type="file"
						class="form-Control" />
				</div>
				<input type="submit" value="submit" class="btn btn-primary">
				<a href="<c:url value="/admin/inventory" />" class="btn btn-default">Cancel</a>

			</form:form>
		</div>
	</div>
</div>