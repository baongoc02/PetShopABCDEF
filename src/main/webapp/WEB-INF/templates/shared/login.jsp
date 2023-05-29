<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <c:import url="/WEB-INF/templates/shared/components/header.jsp">
    <c:param name="title" value="Đăng nhập"/>
  </c:import>
</head>

<body>
    <c:import url="/WEB-INF/templates/shared/components/navbar.jsp"></c:import>

    <!-- Contact Start -->
    <div class="container-fluid pt-5" style="min-height: calc(100vh - 200px)">
        <div class="container">
            <div style="text-align: center;" class="mb-3">
                <h2 class="text-uppercase mb-0">Đăng nhập</h2>
            </div>
            <div class="row g-5">
                <div class="col-lg-4" style="margin-left: auto; margin-right: auto;">
                    <form action="/PetShop/login" method="post">
                        <c:import url="/WEB-INF/templates/shared/components/errorHandle.jsp"/>
                        <div class="row g-3">
                            <div class="col-12">
                                <input type="text" class="form-control bg-light border-0 px-4" placeholder="Tên đăng nhập" style="height: 55px;" name="username">
                            </div>
                            <div class="col-12">
                                <input type="password" class="form-control bg-light border-0 px-4" placeholder="Mật khẩu" style="height: 55px;" name="password">
                            </div>
                            <div class="col-12">
                                <button class="btn btn-primary w-100 py-3" type="submit">Đăng nhập</button>
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