<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <c:import url="/WEB-INF/templates/shared/components/header.jsp">
    <c:param name="title" value="Trang chủ"/>
  </c:import>
</head>

<body>
	<style>
	@import url("https://fonts.googleapis.com/css2?family=Poppins:weight@100;200;300;400;500;600;700;800&display=swap");
	body{
		font-family: "Poppins", sans-serif;
		font-weight: 40;
	}
	
	.height{
		margin: 10px !important;
		height: auto;
	}
	
	.search{
		/*position: relative;*/
		box-shadow: 0 0 40px rgba(51, 51, 51, .1);
	}
	
	.search input{
	 height: 40px;
	 text-indent: 25px;
	 border: 2px solid #6B8E23;
	}
	
	
	.search input:focus{
	 box-shadow: none;
	 border: 2px solid green;
	}
	
	.search .fa-search{
	 position: absolute;
	 top: 20px;
	 left: 16px;
	}
	
	.search button{
	 position: absolute;
	 top: 5px;
	 right: 5px;
	 height: 50px;
	 width: 110px;
	 background: blue;
	}
	</style>
	
    <c:import url="/WEB-INF/templates/shared/components/navbar.jsp"/>
    <c:import url="/WEB-INF/templates/shared/components/errorHandle.jsp"/>
    <form method="get" action="/PetShop/san-pham">
        <div class="input-group mb-3" style="width: 500px; margin-left: auto; margin-right: auto; margin-top: 10px">
          <input type="text" class="form-control" name="productName" placeholder="Bạn tìm gì?"  >
          <input type="submit" class="btn btn-primary" value="Tìm">

    	</div>
    </form>
    
    
    <!-- Hero Start -->
    <div class="container-fluid bg-primary py-5 mb-5 hero-header">
        <div class="container py-5">
            <div class="row justify-content-start">
                <div class="col-lg-8 text-center text-lg-start">
                    <h1 class="display-1 text-uppercase text-dark mb-lg-4">Pet Shop ABCDEF</h1>
                    <h1 class="text-uppercase text-white mb-lg-4">Make Your Pets Happy</h1>
                    <p class="fs-4 text-white mb-lg-4" ">Petshop ABCDEF bảo đảm mang đến cho bạn những sản phẩm dành cho thú cưng tuyệt vời.                                                       </p>
                    <div class="d-flex align-items-center justify-content-center justify-content-lg-start pt-5">
                        <a href="" class="btn btn-outline-light border-2 py-md-3 px-md-5 me-5">Read More</a>
                        <button type="button" class="btn-play" data-bs-toggle="modal"
                            data-src="https://www.youtube.com/embed/DWRcNpR6Kdc" data-bs-target="#videoModal">
                            <span></span>
                        </button>
                        <h5 class="font-weight-normal text-white m-0 ms-4 d-none d-sm-block">Play Video</h5>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Hero End -->
    
    <!-- About Start -->
    <div class="container-fluid py-5">
        <div class="container">
            <div class="row gx-5">
                <div class="col-lg-5 mb-5 mb-lg-0" style="min-height: 500px;">
                    <div class="position-relative h-100">
                        <img class="position-absolute w-100 h-100 rounded" src="/PetShop/static/img/about.jpg" style="object-fit: cover;">
                    </div>
                </div>
                <div class="col-lg-7">
                    <div class="border-start border-5 border-primary ps-5 mb-5">
                        <h6 class="text-primary text-uppercase">About Us</h6>
                        <h1 class="display-5 text-uppercase mb-0">We Keep Your Pets Happy All Time</h1>
                    </div>
                    <h4 class="text-body mb-4">Diam dolor diam ipsum tempor sit. Clita erat ipsum et lorem stet no labore lorem sit clita duo justo magna dolore</h4>
                    <div class="bg-light p-4">
                        <ul class="nav nav-pills justify-content-between mb-3" id="pills-tab" role="tablist">
                            <li class="nav-item w-50" role="presentation">
                                <button class="nav-link text-uppercase w-100 active" id="pills-1-tab" data-bs-toggle="pill"
                                    data-bs-target="#pills-1" type="button" role="tab" aria-controls="pills-1"
                                    aria-selected="true">Our Mission</button>
                            </li>
                            <li class="nav-item w-50" role="presentation">
                                <button class="nav-link text-uppercase w-100" id="pills-2-tab" data-bs-toggle="pill"
                                    data-bs-target="#pills-2" type="button" role="tab" aria-controls="pills-2"
                                    aria-selected="false">Our Vission</button>
                            </li>
                        </ul>
                        <div class="tab-content" id="pills-tabContent">
                            <div class="tab-pane fade show active" id="pills-1" role="tabpanel" aria-labelledby="pills-1-tab">
                                <p class="mb-0">Tempor erat elitr at rebum at at clita aliquyam consetetur. Diam dolor diam ipsum et, tempor voluptua sit consetetur sit. Aliquyam diam amet diam et eos sadipscing labore. Clita erat ipsum et lorem et sit, sed stet no labore lorem sit. Sanctus clita duo justo et tempor consetetur takimata eirmod, dolores takimata consetetur invidunt magna dolores aliquyam dolores dolore. Amet erat amet et magna</p>
                            </div>
                            <div class="tab-pane fade" id="pills-2" role="tabpanel" aria-labelledby="pills-2-tab">
                                <p class="mb-0">Tempor erat elitr at rebum at at clita aliquyam consetetur. Diam dolor diam ipsum et, tempor voluptua sit consetetur sit. Aliquyam diam amet diam et eos sadipscing labore. Clita erat ipsum et lorem et sit, sed stet no labore lorem sit. Sanctus clita duo justo et tempor consetetur takimata eirmod, dolores takimata consetetur invidunt magna dolores aliquyam dolores dolore. Amet erat amet et magna</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- About End -->
    
    <c:import url="/WEB-INF/templates/shared/components/js-includes.jsp"></c:import>
</body>
</html>

    