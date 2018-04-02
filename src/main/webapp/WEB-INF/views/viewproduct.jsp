
<%@ include file="/WEB-INF/views/templates/header.jsp"%>

<br>
<br>
<br>
<br>
<!-- Page Content -->
<div class="container">
	<div class="row text-center">
		<div class="col-md-5">
			<img
				src="<c:url value="/resources/images/${product.product_id}.png" />"
				alt="image" style="width: 100%" />
		</div>
		<div class="col-md-5">
			<h3>${product.product_name}</h3>
			<p>${product.product_price}BDT</p>
		</div>
	</div>
</div>
