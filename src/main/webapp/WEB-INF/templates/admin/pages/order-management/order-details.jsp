<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.petshop.hibernate.entities.*" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <c:import url="/WEB-INF/templates/admin/_layout/header.jsp">
    <c:param name="title" value="Quản lý danh sách đơn hàng"/>
  </c:import>
</head>

<body id="page-top">
    <!-- Page Wrapper -->
    <%
    	Order order = (Order)request.getAttribute("order");
    %>
    <div id="wrapper">
        <c:import url="/WEB-INF/templates/admin/_layout/sidebar.jsp"/>
        
        <c:import url="/WEB-INF/templates/admin/pages/product-management/create-product-modal.jsp">
          <c:param name="modalId" value="modalCreateProduct" />
          <c:param name="formName" value="formCreateProduct"/>
          <c:param name="targetUrl" value="/PetShop/admin/product-management/create"/>
        </c:import>
        
        <c:import url="/WEB-INF/templates/admin/pages/product-management/update-product-modal.jsp">
          <c:param name="modalId" value="modalUpdateProduct" />
          <c:param name="formName" value="formUpdateProduct"/>
          <c:param name="targetUrl" value="/PetShop/admin/product-management/update"/>
        </c:import>
        
        <c:import url="/WEB-INF/templates/admin/pages/product-management/delete-product-modal.jsp">
          <c:param name="modalId" value="modalDeleteProduct" />
          <c:param name="formName" value="formDeleteProduct"/>
          <c:param name="targetUrl" value="/PetShop/admin/product-management/delete"/>
        </c:import>
        
        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">
            <!-- Main Content -->
            <div id="content">
                <c:import url="/WEB-INF/templates/admin/_layout/topbar.jsp"/>
                        
                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">Thông tin đặt hàng</h1>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-body">
                            <div class="mb-4">
                              <div class="row">
                                <div class="col">
                                </div>
                              </div>
                            </div>
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Mã sản phẩm</th>
                                            <th>Tên sản phẩm</th>
                                            <th>Số lượng</th>
                                            <th>Đơn giá</th>
                                            <th>Tổng</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                      <c:forEach items='${requestScope["listOrderDetails"]}' var='order'>
	                                      <tr>
	                                         <td>${order.getId()}</td>
	                                         <td>${order.getProductName()}</td>
	                                         <td>${order.getQuantity()}</td>
	                                         <td class="vnd">${order.getPrice()}</td>
	                                         <td class="vnd">${order.getPrice() * order.getQuantity()}</td>
	                                      </tr>
                                      </c:forEach>
                                    </tbody>
                                    <tfoot>
	                                      <tr>
	                                         <td><strong>Tổng</strong></td>
	                                         <td></td>
	                                         <td></td>
	                                         <td></td>
	                                         <td>
	                                         	<strong class="vnd">${requestScope["totalPrice"]}</strong>
	                                         </td>
	                                      </tr>
                                    	
                                    </tfoot>
                                </table>
                            </div>
                            <div class="row">
                            	<div class="col">
                            		<form class="card" method="post" action="/PetShop/admin/order-management/update-delivered-at">
                            			<input type="hidden" value="${order.getId()}" name="orderId">
                            			<div class="card-body">
                            			<div>
		                            			<p>Họ tên: ${order.getFullName()}</p>
		                            			<p>Số điện thoại: ${order.getPhoneNumber()}</p>
		                            			<p>Địa chỉ: ${order.getAddress()}</p>
		                            			<p>Ghi chú: ${order.getNote()}</p>
                            			
                            			</div>
	                            			<div class="form-check">
		                            			<div class="input-group mb-3">
												  <span class="input-group-text" id="basic-addon1">Ngày giao hàng</span>
												  <input type="date" class="form-control" name="deliveredAt" value='${order.getDeliveredAt()}'>
												</div>
											</div>
											<div class="mb-3">
												<div class="text-center">
													<button type="submit" class="btn btn-primary">Lưu</button>
												</div>
											</div>
										</div>
                            		</form>
                            	</div>
                            	<div class="col-4" style="display: none;">
                            		<form class="card" method="post" action="/PetShop/admin/order-management/update-detail-status">
                            			<input type="hidden" value="${order.getId()}" name="orderId">
                            			<div class="card-body">
                            				<input type="hidden" name="orderId" value="${order.getId()}">
	                            			<div class="form-check">
											  <input class="form-check-input" type="radio" id="flexRadioDefault1" name="status" <% if (order.getStatus() != null && order.getStatus().equals("OK")) {%>checked<% } %> value="1">
											  <label class="form-check-label" for="flexRadioDefault1">
											    Đánh dấu đã giao hàng
											  </label>
											</div>
											<div class="form-check">
											  <input class="form-check-input" type="radio" id="flexRadioDefault2" name="status" <% if (order.getStatus() == null) {%>checked<% } %> value="2">
											  <label class="form-check-label" for="flexRadioDefault2">
											    Đánh dấu chưa giao hàng
											  </label>
											</div>
											<div class="mb-3">
												<div class="text-center">
													<button type="submit" class="btn btn-primary">Lưu</button>
												</div>
											</div>
										</div>
                            		</form>
                            	</div>
                            </div>
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

            <!-- Footer -->
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright &copy; Your Website 2020</span>
                    </div>
                </div>
            </footer>
            <!-- End of Footer -->

        </div>
    </div>
    <!-- End of Page Wrapper -->
    
    <c:import url="/WEB-INF/templates/admin/_layout/js-includes.jsp"/>

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>4
</body>

</html>
