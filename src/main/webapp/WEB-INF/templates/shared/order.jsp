<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="/PetShop/static/css/cart.css" rel="stylesheet" type="text/css">	
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    
	  <c:import url="/WEB-INF/templates/shared/components/header.jsp">
	    <c:param name="title" value="Đơn hàng của tôi"/>
	  </c:import>
  </head>
<body>
	<c:import url="/WEB-INF/templates/shared/components/navbar.jsp"/>
    <c:import url="/WEB-INF/templates/shared/components/errorHandle.jsp"/>
    
    
    <div class="petshop-cart">
      <div class="wrap cf">
        <h1 class="projTitle">
          ĐƠN HÀNG CỦA TÔI
        </h1>
        <c:forEach items="${listOrders}" var="order">
	        <form method="post" action="/PetShop/don-hang/update" onsubmit="return onUpdateOrder()">
	        <div class="heading cf">
	          <h1>Đơn hàng #${order.getId()}</h1>
	          <c:choose>
	          <c:when test='${order.getStatus() =="Đã nhận hàng"}'>
	        		<input type="hidden" name="orderId" value="${order.getId()}">
              		<input class="btn btn-primary" 
              		style="background: green;margin-left: 500px" value="Đã nhận hàng" readonly>
        	</c:when>
        	<c:otherwise>
        		<input type="hidden" name="orderId" value="${order.getId()}">
           		<input type="submit" class="btn btn-primary" 
	           		style="background-color: #aaaaaa;margin-left: 500px" value="Đánh dấu đã nhận hàng">
        	</c:otherwise>
              </c:choose>
        	</form>
	        </div method="" action="/PetShop/donhang">
	        <div class="cart">
	          <ul class="cartWrap">
	          <h3 class="label"; style="font-size: 20px;">Tổng: ${order.getTotalPrice()} VNĐ</h3><br/>
	          <c:choose>
		        	<c:when test='${order.getStatus() =="Đã nhận hàng"}'>
		        		<h3 style="color: darkgreen; font-size: 20px;">Trạng thái: Đã nhận hàng</h3>
		        	</c:when>
		        	<c:otherwise>
		        		<h3 style="color: red;font-size: 20px">Trạng thái: Đang giao hàng</h3>
		        	</c:otherwise>
	       		</c:choose>
	          	<c:forEach items="${order.getOrderDetails()}" var='cartItem'>
	          		<li class="items odd">
		              <div class="infoWrap">
		                <div class="cartSection">
		                  <img
		                    src="http://lorempixel.com/output/technics-q-c-300-300-4.jpg"
		                    alt=""
		                    class="itemImg"
		                  />
		                  <c:forEach items='${requestScope["listProducts"]}' var='product'>
			                  <c:if test="${cartItem.getProductId() == product.getId()}">
			                  <h3>${product.getProductName()}</h3>
			                  <p>
			                    <input type="text" class="qty product-quantity" id="product-${cartItem.getProductId()}" placeholder="${cartItem.getQuantity()}"/> x <span class="vnd">${product.getPrice()}</span>
			                  </p>
			                  </c:if>
		                  </c:forEach>
		                </div>
		
		                <div class="prodTotal cartSection">
		                  <p class="vnd"></p>
		                </div>
		              </div>
		            </li>
	          	</c:forEach>
	          </ul>
	        </div>
	
	        <div class="subtotal cf" style="display: none;">
	          <ul>
	            <li class="totalRow final" >
	              <span class="label">Tổng</span><span class="value">${order.getTotalPrice()}</span>
	            </li>
	            <li class="totalRow">
	            	<form method="post">
	            		<c:forEach items="${cartItems}" var='cartItem'>
	            			<input type="hidden" name="productId-${cartItem.getProductId()}" value='${cartItem.getNum()}'>
	            		</c:forEach>
	            	</form>
	            </li>
	          </ul>
	        </div>
        </c:forEach>
      </div>
    </div>
    
  	<c:import url="/WEB-INF/templates/shared/components/js-includes.jsp"></c:import>
    <script>
    $('a.remove').click(function(){
      event.preventDefault();
      $( this ).parent().parent().parent().hide( 400 );
    
    })
    $('a.btn.continue').click(function(){
        $('li.items').show(400);
    })
    $('input.product-quantity').change(function() {
    	const sender = $(this);
    	const id = sender.attr('id');
    	const newValue = sender.val();
    	const productId = id.split('-')[1];
    	console.log(productId);
    	const elm = document.getElementsByName('productId-' + productId)[0];
    	elm.value = newValue;
    })
    function onUpdateOrder() {
          if (confirm('Bạn có chắc xác nhận đã nhận hàng không?')) {
            return true;
          }
          return false;
        }
    </script>
</body>
</html>