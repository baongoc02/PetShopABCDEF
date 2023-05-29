<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
      <c:import url="/WEB-INF/templates/admin/_layout/header.jsp">
        <c:param name="title" value="Chỉnh sửa sản phẩm" />
      </c:import>
    </head>

    <body id="page-top">
      <!-- Page Wrapper -->
      <div id="wrapper">
        <c:import url="/WEB-INF/templates/admin/_layout/sidebar.jsp" />

        <c:import url="/WEB-INF/templates/admin/pages/product-management/create-product-modal.jsp">
          <c:param name="modalId" value="modalCreateProduct" />
          <c:param name="formName" value="formCreateProduct" />
          <c:param name="targetUrl" value="/PetShop/admin/product-management/create" />
        </c:import>

        <c:import url="/WEB-INF/templates/admin/pages/product-management/update-product-modal.jsp">
          <c:param name="modalId" value="modalUpdateProduct" />
          <c:param name="formName" value="formUpdateProduct" />
          <c:param name="targetUrl" value="/PetShop/admin/product-management/update" />
        </c:import>

        <c:import url="/WEB-INF/templates/admin/pages/product-management/delete-product-modal.jsp">
          <c:param name="modalId" value="modalDeleteProduct" />
          <c:param name="formName" value="formDeleteProduct" />
          <c:param name="targetUrl" value="/PetShop/admin/product-management/delete" />
        </c:import>

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

          <!-- Main Content -->
          <div id="content">
            <c:import url="/WEB-INF/templates/admin/_layout/topbar.jsp" />

            <!-- Begin Page Content -->
            <div class="container-fluid">

              <!-- Page Heading -->
              <h1 class="h3 mb-2 text-gray-800">Chỉnh sửa sản phẩm <strong>${product.getProductName()}</strong></h1>

              <!-- DataTales Example -->
              <div class="card shadow mb-4">
                <div class="card-body">
                  <div class="row">
                    <div class="col">
                      <c:forEach items='${productImages}' var='productImage'>
                        <ul class="list-group">
                          <form class="list-group-item" method="post"
                            action="/PetShop/admin/productImage-management/delete"
                            onsubmit="return onDeleteImageHandler()">
                            <input type="hidden" name="productId" value="${product.getId()}">
                            <input type="hidden" name="productImageId" value="${productImage.getId()}">
                            <div class="row">
                              <div class="col">
                                <img class="rounded mx-auto d-block" width=100px height=100px src="${productImage.getProductImageLink()}"
                                  class="img-fluid" alt="404">
                              </div>
                              <div class="col-3">
                                <div class="mb-3">
                                  <input type="submit" class="btn btn-primary" style="background: Salmon; margin-top: calc(50% - 20px)" value="x">
                                </div>
                              </div>
                            </div>
                          </form>
                        </ul>
                      </c:forEach>
                      <form method="post" class="form" action="/PetShop/admin/productImage-management/create">
                        <input type="hidden" name="productId" value="${product.getId()}"></br>
                        
                        <div class="row mt-3">
                        <div class="col">
                          <div class="card pl-3 pr-3 pb-3">
                            <div class="text-center mt-3">
                              <h2>Thêm hình ảnh</h2>
                            </div>
                              
                              <div class="input-group mb-3">
                                <span class="input-group-text">Link ảnh</span>
                                <input type="text" class="form-control" name="imageLink">
                              </div>
                              <div class="input-group mb-3">
                                <span class="input-group-text">Số thứ tự</span>
                                <input type="number" class="form-control" name="imageOrder">
                              </div>
                              <div class="input-group mb-3">
                                <div class="text-center">
                                  <input type="submit" class="btn btn-primary" value="Thêm">
                                </div>
                              </div>
                          </div>
                        </div>
                      </div>
                        
                      </form>
                      
                    </div>
                    <div class="col">
                      <div class="row">
                        <div class="col">
                          <h2 class="h4 mb-2 text-gray-800">Thông tin cơ bản</h2>
                          <form method="post" class="form" action="/PetShop/admin/product-management/update">
                            <input type="hidden" name="productId" value="${product.getId()}"></br>
                            <div class="input-group mb-3">
                              <span class="input-group-text">Mã sản phẩm</span>
                              <input type="text" class="form-control" value="${product.getProductCode()}" name="productCode">
                            </div>
                            <div class="input-group mb-3">
                              <span class="input-group-text">Tên sản phẩm</span>
                              <input type="text" class="form-control" value="${product.getProductName()}" name="productName">
                            </div>
                            <div class="input-group mb-3">
                              <span class="input-group-text">Giá</span>
                              <input type="number" min="1000" step="1" class="form-control"
                                value="${product.getPrice()}" name="productPrice">
                            </div>
                            <div class="input-group mb-3" style="margin-top: 15px">
                              <div class="text-center">
                                <input type="submit" min="1000" step="1" class="btn btn-primary" value="Lưu lại">
                              </div>
                            </div>
                          </form>
                        </div>
                      </div>
                      <div class="row mt-3" style="margin-bottom: 15px">
                        <div class="col">
                          <div class="card pl-3 pr-3 pb-3">
                            <div class="text-center mt-3">
                              <h2>Loại sản phẩm</h2>
                            </div>
                            <c:forEach items='${listCategoryByProductIds}' var='category'>
                              <form method="post" action="/PetShop/admin/categoryProduct-management/delete" onsubmit="return onDeleteImageHandler()">
                                <div class="input-group mb-3">
                                  <input type="hidden" name="productId" value="${product.getId()}">
                                  <span class="input-group-text">Loại</span>
                                  <select class="form-control" name="categorys" size="1"
                                    style="width:196px; padding:5px;">
                                    <option value="${category.getId()}" autocomplete="off"> ${category.getCategoryName()} </option>
                                    <c:forEach items='${listCategories}' var='categ'>
                                      <option value="${categ.getId()}" <c:if test="${categ.getId() eq selectedCatId}">
                                        selected="selected"</c:if>
                                        >${categ.getCategoryName()} </option>
                                    </c:forEach>
                                  </select>
                                      <input type="submit" class="btn btn-primary" style="background: Salmon;" value="x">
		                                
                                </div>
                              </form>
                            </c:forEach>
                          </div>
                        </div>
                      </div>
                      <div class="row mt-3" style="margin-bottom: 15px">
                        <div class="col">
                          <div class="card pl-3 pr-3 pb-3">
                            <div class="text-center mt-3">
                              <h2>Thêm loại sản phẩm</h2>
                            </div>
                            <form method="post" action="/PetShop/admin/categoryProduct-management/create">
                              <div class="input-group mb-3">
                                <input type="hidden" name="productId" value="${product.getId()}">
                                <span class="input-group-text">Loại</span>
                                <select class="form-control" name="categorys-add" size="1"
                                  style="width:196px; padding:5px;">
                                  <option value="${category.getId()}" autocomplete="off">
                                    ${category.getCategoryName()} </option>
                                  <c:forEach items='${listCategories}' var='categ'>
                                    <option value="${categ.getId()}" <c:if test="${categ.getId() eq selectedCatId}">
                                      selected="selected"</c:if>
                                      >${categ.getCategoryName()} </option>
                                  </c:forEach>
                                </select>
                              </div>
                              <div class="input-group mb-3">
                                <div class="text-center">
                                  <input type="submit" class="btn btn-primary" value="Thêm loại sản phẩm">
                                </div>
                              </div>
                            </form>
                          </div>
                        </div>
                      </div>
                      <div class="row">
                        <div class="col">
                          <ul class="list-group">
                            <c:forEach items="${productDescriptions}" var='des'>
                              <li class="list-group-item">
                                <c:choose>
                                  <c:when test='${des.type == "heading"}'>
                                    <h3>${des.content}</h3>
                                  </c:when>
                                  <c:when test='${des.type == "text"}'>
                                    <p>${des.content}</p>
                                  </c:when>
                                  <c:when test='${des.type == "href"}'>
                                    <img src="${des.content}">
                                  </c:when>
                                </c:choose>
                                <form method="post" action="/PetShop/admin/productDescription-management/delete"
                                  onsubmit="return onDeleteImageHandler()">
                                  <input type="hidden" name="productId" value="${product.getId()}">
                                  <input type="hidden" name="descriptionId" value="${des.getId()}">
                                  <input class="btn btn-link shadow-none align-middle" type="submit" value="Xóa">
                                </form>
                              </li>
                            </c:forEach>
                          </ul>
                        </div>
                      </div>
                      <div class="row mt-3">
                        <div class="col">
                          <div class="card pl-3 pr-3 pb-3">
                            <div class="text-center mt-3">
                              <h2>Thêm mô tả</h2>
                            </div>
                            <form method="post" action="/PetShop/admin/productDescription-management/create">
                              <div class="input-group mb-3">
                                <input type="hidden" name="productId" value="${product.getId()}">
                                <span class="input-group-text">Loại</span>
                                <select class="form-select" name="descriptionType">
                                  <option value="heading">Tiêu đề</option>
                                  <option value="text">Đoạn văn</option>
                                  <option value="href">Link hình</option>
                                </select>
                              </div>
                              <div class="input-group mb-3">
                                <span class="input-group-text">Nội dung</span>
                                <input type="text" class="form-control" name="descriptionContent">
                              </div>
                              <div class="input-group mb-3">
                                <span class="input-group-text">Số thứ tự</span>
                                <input type="number" class="form-control" name="descriptionOrder">
                              </div>
                              <div class="input-group mb-3">
                                <div class="text-center">
                                  <input type="submit" class="btn btn-primary" value="Thêm">
                                </div>
                              </div>
                            </form>
                          </div>
                        </div>
                      </div>
                      <div class="row mt-3">
                        <div class="col">
                            <form method="post" action="/PetShop/admin/product-management/delete" onsubmit="return onDeleteImageHandler()">
                                <div class="input-group mb-3">
                                  <input type="hidden" name="productId" value="${product.getId()}">
                                  <input type="submit" class="btn btn-primary" style="background: Salmon;" value="Xóa sản phẩm">
                                    
                                </div>
                              </form>
                          </div>
                      </div>
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

      <c:import url="/WEB-INF/templates/admin/_layout/js-includes.jsp" />

      <!-- Scroll to Top Button-->
      <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
      </a>

      <script>
        function onDeleteImageHandler() {
          if (confirm('Bạn có chắc muốn xóa không?')) {
            return true;
          }
          return false;
        }
      </script>
    </body>

    </html>