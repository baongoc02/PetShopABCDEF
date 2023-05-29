<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <c:import url="/WEB-INF/templates/shared/components/header.jsp">
    <c:param name="title" value="Sản phẩm"/>
  </c:import>
</head>

<body>
    <c:import url="/WEB-INF/templates/shared/components/navbar.jsp"></c:import>
    <c:import url="/WEB-INF/templates/shared/components/errorHandle.jsp"/>
    
    <!-- Products Start -->
    <div class="container-fluid py-5">
        <div class="container">
            <div class="border-start border-5 border-primary ps-5 mb-5" style="max-width: 600px;">
                <h6 class="text-primary text-uppercase">Sản phẩm</h6>
                <h1 class="display-7 text-uppercase mb-0" style="color: white;">${category.getCategoryName()}</h1>
            </div>
            <div class="row">
              <c:forEach items='${listProducts}' var='product'>
              <div class="col-3" style="height: 100%; max-height: 100%;">
		            <div class="pb-5" style="height: 100%; max-height: 100%;">
		                <div class="product-item bg-light text-center" style="min-height: 450px;">
		                	<div class="container">
			                    <img class="img-fluid mb-4" src="${product.getImageLink()}" alt=""
			                    	style="max-width: 100%; height: 200px;">
			                    <h6 class="text-uppercase">${product.getName()}</h6>
			                    <h5 class="text-primary mb-0 vnd">${product.getPrice()}</h5>
		                    </div>
		                    <div class="footer" style="margin-bottom: 0px;">
		                    	<c:import url="/WEB-INF/templates/shared/components/productmodal.jsp">
		                    		<c:param name="productId" value="${product.id}"/>
		                    		<c:param name="productName" value="${product.name}"/>
		                    		<c:param name="productPrice" value="${product.price}"/>
		                    		<c:param name="productImage" value="${product.imageLink}"/>
		                    		<c:param name="description">
		                    			<c:forEach items="${product.listProductDescriptions}" var='des'>
		                    				<c:choose>
		                    					<c:when test='${des.type == "text"}'>
		                    						<p>${des.content}</p>
		                    					</c:when>
		                    					<c:when test='${des.type == "heading"}'>
		                    						<h2>${des.content}</h2>
		                    					</c:when>
		                    					<c:when test='${des.type == "href"}'>
		                    						<img src="${des.content}"/>
		                    					</c:when>
		                    				</c:choose>
		                    			</c:forEach>
		                    		</c:param>
		                    	</c:import>
		                    </div>
		                </div>
		            </div>
	            </div>
              </c:forEach>
            </div>
          </div>
        </div>
  <c:import url="/WEB-INF/templates/shared/components/js-includes.jsp"></c:import>
  <script>
  const vndFormat = (x) => x.toLocaleString('it-IT', {style : 'currency', currency : 'VND'});
  const vnds = document.getElementsByClassName('vnd');
  for (const vnd of vnds) {
	  vnd.textContent = vndFormat(parseInt(vnd.textContent));
  }
  </script>
</body>
</html>