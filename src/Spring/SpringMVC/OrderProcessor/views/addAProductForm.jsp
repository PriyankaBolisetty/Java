<%@ include file="./include.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Product</title>
</head>
<body>
	
	<form:form action="./saveNewProduct" method="POST" commandName="product">
	  <table>
	  	<tr>
	  	<td><fmt:message key="Name: " /></td>
	        <td><form:input path="name" />
	        </td>
	    </tr>
	    <tr>
	  	<td><fmt:message key="Price: " /></td>
	        <td><form:input path="price" />  
	        </td>
	    </tr>
		<tr>
	    <td><input type="submit" value="<fmt:message key="Add" />"> </td>
	    </tr>
	    </table>
  </form:form>
	
</body>
</html>