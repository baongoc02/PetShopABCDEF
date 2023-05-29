<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.petshop.servlets.shared.CartItem" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="/PetShop/static/css/cart.css" rel="stylesheet" type="text/css">	
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
      crossorigin="anonymous"
    />
    
	  <c:import url="/WEB-INF/templates/shared/components/header.jsp">
	    <c:param name="title" value="Thanh toán"/>
	    </c:import>
  </head>
  <body>
    <c:import url="/WEB-INF/templates/shared/components/navbar.jsp"></c:import>
    <c:import url="/WEB-INF/templates/shared/components/errorHandle.jsp"/>
  	
  
    <form class="petshop-cart"
    	name="frm-petshop-payment"
    	method="post"
    	onsubmit="return onPaymentSubmit()">
      <div class="wrap cf">
        <div class="heading cf">
          <h1>Thông tin mua hàng</h1>

          <a href="/PetShop/gio-hang" class="continue">Quay lại giỏ hàng</a>
        </div>
        <div class="cart">
          <!--    <ul class="tableHead">
              <li class="prodHeader">Product</li>
              <li>Quantity</li>
              <li>Total</li>
               <li>Remove</li>
            </ul>-->

          <div class="container">
            <div class="row">
              <!-- column 1-->
              <div class="col">
                <div class="form-floating mb-3">
                  <input
                    type="text"
                    class="form-control"
                    placeholder="HoVaTen"
                    name="fullName"
                    value="${requestScope['authenticated_user'].getFullName()}"
                  />
                  <label for="floatingInput">Họ và tên</label>
                </div>
                <div class="form-floating mb-3">
                  <input type="text" class="form-control" placeholder="SDT" name="phoneNumber"
                  	value="${requestScope['authenticated_user'].getPhoneNumber()}"/>
                  <label for="floatingInput">Số điện thoại</label>
                </div>
                <div class="form-floating mb-3">
                  <input
                    type="text"
                    class="form-control"
                    placeholder="DiaChi"
                    name="address"
                    value="${requestScope['authenticated_user'].getAddress()}"
                  />
                  <label for="floatingPassword">Địa chỉ </label>
                </div>
                
                <div class="form-floating mb-3">
                  <textarea
                    class="form-control"
                    id="floatingTextarea"
                    name="note"
                  ></textarea>
                  <label for="floatingTextarea" >Ghi chú (tùy chọn)</label>
                </div>
              </div>
              <div class="col">
                <h2>Phương thức thanh toán</h2>
                <div class="card" style="width: 18rem">
                  <ul class="list-group list-group-flush">
                    <li class="list-group-item">
                      <div class="form-check">
                        <input
                          class="form-check-input"
                          type="radio"
                          name="isCod"
                          checked
                        />
                        <label class="form-check-label" for="flexRadioDefault1">
                          Thanh toán khi giao hàng (COD)
                        </label>
                      </div>
                    </li>
                  </ul>
                </div>
              </div>
              <div class="col">
                <!-- column 2-->
                
                <ul class="cartWrap">
                    <h2>Đơn hàng</h2>
                  <c:forEach items="${cartItems}" var='cartItem'>
                  <li class="items odd" name="cart-items-check">
                    <div class="infoWrap">
                      <div class="cartSection">
                        <img
                          src="http://lorempixel.com/output/technics-q-c-300-300-4.jpg"
                          alt=""
                          class="itemImg"
                        />
                        <h3>${cartItem.productName}</h3>

                        <p>
                          ${cartItem.getNum()} x ${cartItem.getPrice()}                          
                        </p>

                      </div>

                      <div class="prodTotal cartSection">
                        <p>${cartItem.getPrice() * cartItem.getNum()}</p>
                      </div>
                    </div>
                  </li>
                  </c:forEach>
                </ul>
              </div>
            </div>
          </div>
        </div>

        <div class="subtotal cf">
          <ul>
          	<%
          		int totalPrice = 0;
          		for (CartItem cartItem : (List<CartItem>)request.getAttribute("cartItems")) {
          			totalPrice += cartItem.getNum() * cartItem.getPrice();
          		}
          	%>
            <li class="totalRow final">
              <span class="label">Tổng tiền</span><span class="value"><%= totalPrice %></span>
            </li>
            <li class="totalRow">
              <input type="submit" class="btn continue" value="Đặt hàng">
            </li>
          </ul>
        </div>
      </div>
    </form>
  <c:import url="/WEB-INF/templates/shared/components/js-includes.jsp"></c:import>
    <script>
    function onPaymentSubmit() {
    	const form = document.forms["frm-petshop-payment"];
    	const fullName = form["fullName"].value;
    	const phoneNumber = form["phoneNumber"].value;
    	const address = form["address"].value;
    	const isCod = form["isCod"];
    	const cartItems = document.getElementsByName('cart-items-check');
    	if (cartItems.length == 0) {
    		alert('Không có đơn hàng nào trong giỏ hàng cả');
    		return false;
    	}
    	if (fullName == null || fullName == '') {
    		alert('Họ và tên không được trống');
    		return false;
    	}
    	if (phoneNumber == null || phoneNumber == '') {
    		alert('Số điện thoại không được trống');
    		return false;
    	}
    	if (address == null || address == '') {
    		alert('Địa chỉ không được trống');
    		return false;
    	}
    	if (!isCod.checked) {
    		alert('Vui lòng chọn phương thức thanh toán');
    		return false;
    	}
    	return true;
    }
    </script>
  </body>
</html>
