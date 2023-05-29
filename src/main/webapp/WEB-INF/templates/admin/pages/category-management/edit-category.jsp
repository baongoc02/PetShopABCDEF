<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

        <c:import url="/WEB-INF/templates/admin/pages/product-management/create-Product-modal.jsp">
          <c:param name="modalId" value="modalCreateProduct" />
          <c:param name="formName" value="formCreateProduct" />
          <c:param name="targetUrl" value="/PetShop/admin/product-management/create" />
        </c:import>

        <c:import url="/WEB-INF/templates/admin/pages/product-management/update-Product-modal.jsp">
          <c:param name="modalId" value="modalUpdateProduct" />
          <c:param name="formName" value="formUpdateProduct" />
          <c:param name="targetUrl" value="/PetShop/admin/product-management/update" />
        </c:import>

        <c:import url="/WEB-INF/templates/admin/pages/product-management/delete-Product-modal.jsp">
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
              <h1 class="h3 mb-2 text-gray-800">Chỉnh sửa loại sản phẩm <strong>${product.getProductName()}</strong></h1>

              <!-- DataTales Example -->
              <div class="card shadow mb-4">
                <div class="card-body">
                  <div class="row">
                    <div class="col">
                      
                    </div>
                    <div class="col">
                      <div class="row">
                        <div class="col">
                          <h2 class="h4 mb-2 text-gray-800">Thông tin cơ bản</h2>
                          <form method="post" class="form" action="/PetShop/admin/product-management/update">
                            <input type="hidden" name="productId" value="${category.getId()}"></br>
                            <div class="input-group mb-3">
                              <span class="input-group-text">Tên loại sản phẩm</span>
                              <input type="text" class="form-control" value="${product.getCategoryName()}" name="categoryName">
                            </div>
                            <div class="input-group mb-3">
                              <span class="input-group-text">Loại thú cưng</span>
                              <input type="text" class="form-control" value="" name="animalName">
                            </div>
                            <div class="input-group mb-3" style="margin-top: 15px">
                              <div class="text-center">
                                <input type="submit" min="1000" step="1" class="btn btn-primary" value="Lưu lại">
                              </div>
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