
<%@ include file="/WEB-INF/views/templates/header.jsp"%>

<br>
<br>
<br>
<br>
<!-- Page Content -->
<div class="container">
    
    
    <div class="row text-center">
		<div class="col-md-3" style="">
			<a href="<c:url value="/admin/product/add" />" class="btn btn-primary btn btn-primary btn-block">Add New Product</a>
		</div>
		<div class="col-md-3" style="">
			<a href="<c:url value="/admin" />" class="btn btn-primary btn-block">Back To
				Admin Page</a>
		</div>
	</div>
	<table class="table table-striped table-hover">
		<thead>
			<tr class="bg-success">
				<th>Proto Thumb</th>
				<th>Product Name</th>
				<th>Price</th>
				<th>Action</th>
			</tr>
		</thead>
		<c:forEach items="${products}" var="product">
			<tr>
				<td><img src="<c:url value="/resources/images/${product.product_id}.png" />" alt="image"
					style="width: 70px; height: 30px" /></td>
				<td>${product.product_name}</td>
				<td>${product.product_price} BDT</td>
				<td><a
					href="<c:url value="/admin/product/edit/${product.product_id}" />">Edit</a>
					|| <a
					href="<c:url value="/admin/product/delete/${product.product_id}" />">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	
</div>