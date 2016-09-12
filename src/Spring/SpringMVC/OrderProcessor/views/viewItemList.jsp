<%@ include file="./include.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Items in order ${orderCode}:</h1>
	<table BORDER="8" bgcolor="#FAEBD7" cellspacing="10" cellpadding="15">
		<tr>
			<th>Product</th>
			<th>Price</th>
		</tr>
			<c:forEach var="curItem" items="${itemList}">
				<tr>
			   		<td>${curItem.product.name}</td><td>${curItem.product.price}</td>
				</tr>
			</c:forEach>
	</table>

	<br><br>

	<h2>
	<a href="${context}">Home</a>
	</h2>
	
</body>
</html>