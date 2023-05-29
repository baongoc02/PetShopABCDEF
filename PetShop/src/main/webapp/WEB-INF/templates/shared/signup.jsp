<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <c:import url="/WEB-INF/templates/shared/components/header.jsp">
    <c:param name="title" value="Đăng ký"/>
  </c:import>
</head>
<body>
	<c:import url="/WEB-INF/templates/shared/components/navbar.jsp"></c:import>

    <!-- Contact Start -->
    <div class="container-fluid pt-5" style="min-height: calc(100vh - 200px)">
        <div class="container">
            <div style="text-align: center;" class="mb-3">
                <h2 class="text-uppercase mb-0">Đăng ký</h2>
            </div>
            <div class="row g-5">
                <div class="col-lg-4" style="margin-left: auto; margin-right: auto;">
                    <form action="/PetShop/signup" method="post">
                        <c:import url="/WEB-INF/templates/shared/components/errorHandle.jsp"/>
                        <div class="row g-3">
                          <div class="col-12">
                                <input type="text" required class="form-control bg-light border-0 px-4" placeholder="Tên đăng nhập" style="height: 55px;" name="userName">
                            </div>
                            <div class="col-12">
                                <input type="text" required class="form-control bg-light border-0 px-4" placeholder="Tên đầy đủ" style="height: 55px;" name="fullName">
                            </div>
                            <div class="col-12">
                                <input type="password" required class="form-control bg-light border-0 px-4" placeholder="Mật khẩu" style="height: 55px;" name="password">
                            </div>
                            <div class="col-12">
                                <input type="text" required class="form-control bg-light border-0 px-4" placeholder="Số điện thoại" style="height: 55px;" name="phoneNumber">
                            </div>
                            <div class="col-12">
                                <input type="text" required class="form-control bg-light border-0 px-4" placeholder="Địa chỉ" style="height: 55px;" name="address">
                            </div>
                            <div class="col-12">
                                <button class="btn btn-primary w-100 py-3" type="submit">Đăng ký</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <!-- Contact End -->
    
    <c:import url="/WEB-INF/templates/shared/components/js-includes.jsp"></c:import>
</body>
</html>