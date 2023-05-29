<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <!DOCTYPE html>
 <html lang="en">

 <head>
     <c:import url="/WEB-INF/templates/admin/_layout/header.jsp">
         <c:param name="title" value="Quản lý tài khoản người dùng" />
     </c:import>
 </head>

 <body id="page-top">
     <!-- Page Wrapper -->
     <div id="wrapper">
         <c:import url="/WEB-INF/templates/admin/_layout/sidebar.jsp" />

         <c:import url="/WEB-INF/templates/admin/pages/user-management/update-user-modal.jsp">
             <c:param name="modalId" value="modalUpdatePassword" />
             <c:param name="formName" value="formUpdatePassword" />
             <c:param name="targetUrl" value="/PetShop/admin/user-management/update" />
         </c:import>


         <!-- Content Wrapper -->
         <div id="content-wrapper" class="d-flex flex-column">

             <!-- Main Content -->
             <div id="content">
                 <c:import url="/WEB-INF/templates/admin/_layout/topbar.jsp" />

                 <!-- Begin Page Content -->
                 <div class="container-fluid">

                     <!-- Page Heading -->
                     <h1 class="h3 mb-2 text-gray-800">Tài khoản người dùng</h1>

                     <!-- DataTales Example -->
                     <div class="card shadow mb-4">
                         <div class="card-body">
                         <div class="mb-4">
		                    <div class="row">
		                      <div class="col">
		                      </div>
		                      <div class="col">
		                        <form method="get" action="/PetShop/admin/user-management">
		                          <div class="input-group mb-3">
		                            <input type="text" class="form-control" name="fullName" value="${fullName}">
		                            <input type="submit" class="btn btn-primary" value="Tìm">
		
		                          </div>
		                        </form>
		                      </div>
		                    </div>
		                  </div>

                             <div class="table-responsive">
                                 <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                     <thead>
                                         <tr>
                                             <th>Mã khách hàng</th>
                                             <th>Tên khách hàng</th>
                                             <th>Số điện thoại</th>
                                             <th>Địa chỉ</th>
                                             <th></th>
                                         </tr>
                                     </thead>
                                     <tbody>
                                         <c:forEach items='${requestScope["listUsers"]}' var='user'>
                                             <tr>
                                                 <td>${user.getId()}</td>
                                                 <td>${user.getFullName()}</td>
                                                 <td>${user.getPhoneNumber()}</td>
                                                 <td>${user.getAddress()}</td>
                                                 <td>
                                                     <button class="btn btn-link shadow-none btn-sm"
                                                         onclick="onEditRowClick(${user.getId()}, '${user.getFullName()}')"
                                                         data-toggle="modal"
                                                         data-target="#modalUpdatePassword">Đổi mật khẩu</button>
                                                     <button class="btn btn-danger shadow-none btn-sm"
                                                         onclick="onDeleteRowClick(${user.getId()})"
                                                         data-toggle="modal" data-target="#modalDeleteProduct"
                                                         style="display: none;">
                                                         Xóa
                                                     </button>
                                                 </td>
                                             </tr>
                                         </c:forEach>
                                     </tbody>
                                 </table>
                             </div>
                             <nav aria-label="Page navigation example">
                                 <ul class="pagination justify-content-center">
                                     <li class="page-item">
                                         <c:choose>
                                             <c:when test='${currentPage <= 1}'>
                                                 <a class="page-link" aria-disabled="true">Trang trước</a>
                                             </c:when>
                                             <c:otherwise>
                                                 <a class="page-link"
                                                     href="/PetShop/admin/user-management?page=${currentPage - 1}&limit=${numberOfRowsPerPage}">Trang
                                                     trước</a>
                                             </c:otherwise>
                                         </c:choose>
                                     </li>
                                     <c:forEach begin="1"
                                         end="${(pageSize + numberOfRowsPerPage - 1) / numberOfRowsPerPage}"
                                         var='pageId'>
                                         <c:choose>
                                             <c:when test='${pageId == currentPage}'>
                                                 <li class="page-item active"><a class="page-link"
                                                         href="/PetShop/admin/user-management?page=${pageId}&limit=${numberOfRowsPerPage}">${pageId}</a>
                                                 </li>
                                             </c:when>
                                             <c:otherwise>
                                                 <li class="page-item"><a class="page-link"
                                                         href="/PetShop/admin/user-management?page=${pageId}&limit=${numberOfRowsPerPage}">${pageId}</a>
                                                 </li>
                                             </c:otherwise>
                                         </c:choose>
                                     </c:forEach>
                                     <li class="page-item">
                                         <c:choose>
                                             <c:when
                                                 test='${currentPage >= (pageSize + numberOfRowsPerPage - 1) / numberOfRowsPerPage - 1}'>
                                                 <a class="page-link" aria-disabled="true">Trang sau</a>
                                             </c:when>
                                             <c:otherwise>
                                                 <a class="page-link"
                                                     href="/PetShop/admin/user-management?page=${currentPage + 1}&limit=${numberOfRowsPerPage}">Trang
                                                     sau</a>
                                             </c:otherwise>
                                         </c:choose>
                                     </li>
                                 </ul>
                             </nav>
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
         function onEditRowClick(id, fullName) {
             const form = document.forms["formUpdatePassword"];
             form["id"].value = id;
             form["fullName"].value = fullName;
         }
     </script>
 </body>

 </html>