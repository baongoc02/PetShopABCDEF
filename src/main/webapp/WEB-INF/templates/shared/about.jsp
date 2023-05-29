<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <c:import url="/WEB-INF/templates/shared/components/header.jsp">
    <c:param name="title" value="Liên hệ"/>
  </c:import>
</head>

<body>
    <c:import url="/WEB-INF/templates/shared/components/navbar.jsp"></c:import>
    <c:import url="/WEB-INF/templates/shared/components/errorHandle.jsp"/>
    
    <!-- Contact Start -->
    <div class="container-fluid pt-5">
        <div class="container">
            <div class="border-start border-5 border-primary ps-5 mb-5" style="max-width: 600px;">
                <h2 class="text-primary text-uppercase">Đồ án cuối kì lập trình web </h2>
            </div>
            <div>
              <c:forEach items="${success_messages}" var="message">
              <div class="alert alert-success" role="alert">
							  ${message}
							</div>
							</c:forEach>
            </div>
            <div class="row g-5">
                <div class="col-lg-7">
                    <form method="post">
                        <div class="row g-3">
                            <div class="col-12">
                                <input type="text" required class="form-control bg-light border-0 px-4" placeholder="Tên của bạn" style="height: 55px;" name="fullName">
                            </div>
                            <div class="col-12">
                                <input type="email" required class="form-control bg-light border-0 px-4" placeholder="Email" style="height: 55px;" name="email">
                            </div>
                            <div class="col-12">
                                <input type="text" required class="form-control bg-light border-0 px-4" placeholder="Số điện thoại" style="height: 55px;" name="phoneNumber">
                            </div>
                            <div class="col-12">
                                <input type="text" required class="form-control bg-light border-0 px-4" placeholder="Địa chỉ" style="height: 55px;" name="address">
                            </div>
                            <div class="col-12">
                                <textarea required class="form-control bg-light border-0 px-4 py-3" rows="8" placeholder="Nội dung" name="content"></textarea>
                            </div>
                            <div class="col-12">
                                <button class="btn btn-primary w-100 py-3" type="submit">Gửi đánh giá</button>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="col-lg-5">
                    <div class="bg-light mb-5 p-5">
                        <div class="d-flex align-items-center mb-2">
                            <i class="bi bi-geo-alt fs-1 text-primary me-3"></i>
                            <div class="text-start">
                                <h6 class="text-uppercase mb-1">Được thực hiện bởi nhóm ABCDEF </h6>
                                <span>20110276 - Trần Thị Bảo Ngọccccc</span><br/>
                                <span>20110224 - Nguyễn Thành Văn</span>
                            </div>
                        </div>
                        <div>
                            <iframe
                              class="position-relative w-100"
                              src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3918.497145715363!2d106.771588!3d10.849741499999999!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x317527a03a6378c5%3A0xb4a838949a4175c8!2zMSDEkC4gVsO1IFbEg24gTmfDom4sIExpbmggQ2hp4buDdSwgVGjhu6cgxJDhu6ljLCBUaMOgbmggcGjhu5EgSOG7kyBDaMOtIE1pbmg!5e0!3m2!1svi!2s!4v1670680294146!5m2!1svi!2s"
                              frameborder="0" style="height: 205px; border:0;" allowfullscreen="" aria-hidden="false"
                              tabindex="0">
                            </iframe>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Contact End -->
    
    <c:import url="/WEB-INF/templates/shared/components/js-includes.jsp"></c:import>
</body>

</html>