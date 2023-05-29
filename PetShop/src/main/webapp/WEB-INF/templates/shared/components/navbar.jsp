<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.petshop.servlets.shared.*" %>



<!-- Navbar Start -->

<nav class="navbar navbar-expand-lg bg-white navbar-light shadow-sm py-3 py-lg-0 px-3 px-lg-0">
    
    <a href="/PetShop/" class="navbar-brand ms-lg-5">
        <h1 class="m-0 text-uppercase text-dark"><i class="bi bi-shop fs-1 text-primary me-3"></i>Pet Shop</h1>
    </a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" >
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarCollapse" style="padding-right:20px;">
        
        <div class="navbar-nav ms-auto py-0">
        
        <a href="/PetShop/" class="nav-item nav-link">Trang chủ</a>
        <c:forEach items='${requestScope["listAnimals"]}' var='animal'>
        	<div class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown">${animal.getAnimalName()}</a>
                <div class="dropdown-menu m-0">
                <c:forEach items='${requestScope["listCategories"]}' var='category'>
                	<c:if test='${animal.getId() == category.getAnimalId()}'>
                    	<a href="/PetShop/san-pham?categoryId=${category.getId()}" class="dropdown-item">${category.getCategoryName()}</a>
                    </c:if>
                </c:forEach>
                </div>
            </div>
        </c:forEach>	
            <a href="/PetShop/gio-hang" class="nav-item nav-link">
            	Giỏ hàng<%
            		List<CartItem> cartItems = (List<CartItem>)(request.getAttribute("cartItems"));
            		if (cartItems == null)
            			cartItems = new ArrayList<>();
            		int totalProducts = 0;
            		for (CartItem cartItem : cartItems) {
            			totalProducts += cartItem.getNum();
            		}
            		if (totalProducts > 0) {%>
            			(<%= totalProducts %>)
            		<%
            		}
            	%>
            </a>
            <a href="/PetShop/don-hang" class="nav-item nav-link">Đơn hàng</a>
            <a href="/PetShop/ve-chung-toi" class="nav-item nav-link">Liên hệ</a>
            <c:choose>
              <c:when test='${requestScope["is_authenticated"] == true}'>
                <div class="nav-item dropdown">
	                <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown">Chào, ${requestScope["authenticated_user"].getUsername()}</a>
	                <div class="dropdown-menu m-0 dropdown-menu-end">
	                  <c:if test='${requestScope["authenticated_user"].getRole().equals("ADMIN")}'>
	                    <button class="dropdown-item">
	                     <a href="/PetShop/admin">Quản lý website</a>
	                    </button>
	                    <hr/>
	                  </c:if>
	                  <button class="dropdown-item">
	                    <a>Tài khoản</a>
	                  </button>
	                  <form action="/PetShop/logout" method="post">
	                   <button type="submit" class="btn-danger dropdown-item">Đăng xuất</button>
	                  </form>
	                </div>
                </div>
              </c:when>
              <c:otherwise>
                <a href="/PetShop/login" class="nav-item nav-link">Đăng nhập</a>
                <a href="/PetShop/signup" class="nav-item nav-link">Đăng ký</a>
              </c:otherwise>
            </c:choose>
        </div>
    </div>
    
</nav>

<!-- Navbar End -->