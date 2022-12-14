<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="products">
    <h2>Products</h2>

    <table id="productsTable" class="table table-striped">
        <thead>
        <tr>
            <th style="width: 150px;">Name</th>
            <th style="width: 200px;">Price</th>
			<th style="width: 200px;">Product Type</th>
        </tr>
        </thead>
        <tbody>
			<c:forEach items="${products}" var="product"> 
				<tr>
					<td><c:out value="${product.name}"/></td>
					<td><c:out value="${product.price}"/></td>	
					<td><c:out value="${product.productType.id}"/></td>				
				</tr>
			</c:forEach>
        </tbody>
    </table>
	<sec:authorize access="hasAuthority('admin')">
		<a class="btn btn-default" href='<spring:url value="/product/create" htmlEscape="true"/>'>Add Product</a>
	</sec:authorize>
</petclinic:layout>
