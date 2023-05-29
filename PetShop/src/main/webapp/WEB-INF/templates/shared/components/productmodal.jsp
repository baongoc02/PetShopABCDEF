<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <link href="/PetShop/static/css/productmodal.css" rel="stylesheet" type="text/css">	
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>

    <div class="product-modal">
      <div class="modal-container-${param.productId} modal-container" id="modal-container">
        <div class="modal-background">
          <div class="modal">
            <div class="wrapper">
              <section class="columns">
                <div class="column">
                  <img
                    src="${param.productImage}"
                  />
                </div>

                <div class="column">
                  <h2>${param.productName}</h2>
                  <p>Giá: <span class="vnd">${param.productPrice}</span></p>
                  <p>Mô tả:</p>
                  <div class="product-description">
                    ${param.description}
                  </div>
                  <p>Mã sản phẩm ${param.productCode}</p>
                  
                  <form action="/PetShop/them-vao-gio-hang" method="post">
                  	<input type="hidden" name="productId" value="${param.productId}">
                  	<input type="submit" class="btn continue" value="Thêm vào giỏ hàng">
                  </form>
                </div>
              </section>
            </div>
            <svg
              class="modal-svg"
              xmlns="http://www.w3.org/2000/svg"
              width="100%"
              height="100%"
              preserveAspectRatio="none"
            >
              <rect
                x="0"
                y="0"
                fill="none"
                width="1000px"
                height="500px"
                rx="3"
                ry="3"
              ></rect>
            </svg>
          </div>
        </div>
      </div>
      <div class="content">
        <div class="buttons">
          <div id="${param.productId}" class="button btn-view-product-${param.productId}">Xem sản phẩm</div>
        </div>
      </div>
    </div>
    <script>
      $(".btn-view-product-${param.productId}").click(function () {
	      var buttonId = $(this).attr("id");
	      var modalContainer = $(".modal-container-${param.productId}");
          //modalContainer.removeAttr("class");
          modalContainer.addClass("modal-blabla-active");
	      $("body").addClass("modal-active");
      });

      $(".modal-container-${param.productId}").click(function () {
          $(this).addClass("out");
          $("body").removeClass("modal-active");
      });
    </script>
