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
	    <c:param name="title" value="Giỏ hàng"/>
	  </c:import>
  </head>
  <body>
    <c:import url="/WEB-INF/templates/shared/components/navbar.jsp"/>
    <c:import url="/WEB-INF/templates/shared/components/errorHandle.jsp"/>
  
    <div class="petshop-cart">
      <div class="wrap cf">
        <h1 class="projTitle">
          PETSHOP ABCDEF
        </h1>
        <div class="heading cf">
          <h1>Giỏ hàng của tôi</h1>
          <a href="/PetShop/" class="continue">Tiếp tục mua sắm</a>
        </div>
        <div class="cart">
          <!--    <ul class="tableHead">
        <li class="prodHeader">Product</li>
        <li>Quantity</li>
        <li>Total</li>
         <li>Remove</li>
      </ul>-->
          <ul class="cartWrap">
          	<c:forEach items="${cartItems}" var='cartItem'>
          		<li class="items odd">
	              <div class="infoWrap">
	                <div class="cartSection">
	                  <img
	                    src="http://lorempixel.com/output/technics-q-c-300-300-4.jpg"
	                    alt=""
	                    class="itemImg"
	                  />
	                  <h3>${cartItem.productName}</h3>
	                  <p>
	                    <input type="text" class="qty product-quantity" id="product-${cartItem.getProductId()}" placeholder="${cartItem.getNum()}"/> x <span class="vnd">${cartItem.getPrice()}</span>
	                  </p>
	                </div>
	
	                <div class="prodTotal cartSection">
	                  <p class="vnd"></p>
	                </div>
	                <div class="cartSection removeWrap" style="margin-left: auto; margin-right: 0px; float:right;">
	                	<form method="post" action="/PetShop/xoa-san-pham">
	                		<input type="hidden" name="productId" value="${cartItem.getProductId()}">
	                  		<input type="submit" href="#" class="remove" value="x">
	                  	</form>
	                </div>
	              </div>
	            </li>
          	</c:forEach>
          </ul>
        </div>

        <div class="subtotal cf">
          <ul>
            <li class="totalRow final" style="display:none">
              <span class="label">Tạm tính</span><span class="value">$35.00</span>
            </li>
            <li class="totalRow">
            	<form method="post">
            		<c:forEach items="${cartItems}" var='cartItem'>
            			<input type="hidden" name="productId-${cartItem.getProductId()}" value='${cartItem.getNum()}'>
            		</c:forEach>
            		<input type="submit" class="btn continue" value="Tiếp tục">
            	</form>
            </li>
          </ul>
        </div>
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
    </script>
  </body>
</html>
