
<%@ include file="/WEB-INF/views/templates/header.jsp"%>

<br>
<br>
<br>
<br>
<!-- Page Content -->
<div class="container">
	<div class="row text-center">
		<c:forEach items="${products}" var="product">
			<div class="col-lg-3 col-md-6 mb-4">
				<div class="card">
					<img class="card-img-top"
						src="<c:url value="/resources/images/${product.product_id}.png" />"
						alt="">
					<div class="card-body">
						<h4 class="card-title">${product.product_name}</h4>
						<p class="card-text">${product.product_price}</p>
					</div>
					<div class="card-footer">
						<a href="<c:url value="/product/${product.product_id}" />"
							class="btn btn-primary">Details</a>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</div>
