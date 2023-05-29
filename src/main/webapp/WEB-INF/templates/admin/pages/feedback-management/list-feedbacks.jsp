<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <!DOCTYPE html>
 <html lang="en">

 <head>
     <c:import url="/WEB-INF/templates/admin/_layout/header.jsp">
         <c:param name="title" value="Danh sách feedback" />
     </c:import>
 </head>

 <body id="page-top">
     <!-- Page Wrapper -->
     <div id="wrapper">
         <c:import url="/WEB-INF/templates/admin/_layout/sidebar.jsp" />

         <c:import url="/WEB-INF/templates/admin/pages/feedback-management/feedback-modal.jsp">
             <c:param name="modalId" value="modalViewFeedback" />
             <c:param name="formName" value="formViewFeedback" />
             <c:param name="targetUrl" value="/PetShop/admin/feedbacks" />
         </c:import>


         <!-- Content Wrapper -->
         <div id="content-wrapper" class="d-flex flex-column">

             <!-- Main Content -->
             <div id="content">
                 <c:import url="/WEB-INF/templates/admin/_layout/topbar.jsp" />

                 <!-- Begin Page Content -->
                 <div class="container-fluid">

                     <!-- Page Heading -->
                     <h1 class="h3 mb-2 text-gray-800">Feedbacks</h1>

                     <!-- DataTales Example -->
                     <div class="card shadow mb-4">
                         <div class="card-body">

                             <div class="table-responsive">
                                 <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                     <thead>
                                         <tr>
                                             <th>Tên khách hàng</th>
                                             <th>Email</th>
                                             <th>Số điện thoại</th>
                                             <th>Địa chỉ</th>
                                             <th>Nội dung</th>
                                         </tr>
                                     </thead>
                                     <tbody>
                                         <c:forEach items='${requestScope["listFeedbacks"]}' var='feedback'>
                                             <tr>
                                                 <td>${feedback.getFullName()}</td>
                                                 <td>${feedback.getEmail()}</td>
                                                 <td>${feedback.getPhoneNumber()}</td>
                                                 <td>${feedback.getAddress()}</td>
                                                 <td>${feedback.getContent()}</td>
                                                 <td style="display: none;">
                                                     <button class="btn btn-link shadow-none btn-sm"
                                                         onclick="onEditRowClick(${feedback.getId()}, '${feedback.getFullName()}', '${feedback.getEmail()}', '${feedback.getPhoneNumber()}', '${feedback.getAddress()}', '${feedback.getContent()}')"
                                                         data-toggle="modal"
                                                         data-target="#modalViewFeedback">Xem</button>
                                                     <button class="btn btn-danger shadow-none btn-sm"
                                                         onclick="onDeleteRowClick(${feedback.getId()})"
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
                                                     href="/PetShop/admin/product-management?page=${currentPage - 1}&limit=${numberOfRowsPerPage}">Trang
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
                                                         href="/PetShop/admin/feedbacks?page=${pageId}&limit=${numberOfRowsPerPage}">${pageId}</a>
                                                 </li>
                                             </c:when>
                                             <c:otherwise>
                                                 <li class="page-item"><a class="page-link"
                                                         href="/PetShop/admin/feedbacks?page=${pageId}&limit=${numberOfRowsPerPage}">${pageId}</a>
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
                                                     href="/PetShop/admin/feedbacks?page=${currentPage + 1}&limit=${numberOfRowsPerPage}">Trang
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
         function onEditRowClick(id, fullName, email, phoneNumber, address, content) {
             const form = document.forms["formViewFeedback"];
             form["id"].value = id;
             form["fullName"].value = fullName;
             form["email"].value = email;
             form["phoneNumber"].value = phoneNumber;
             form["address"].value = address;
             form["content"].value = content;
         }
     </script>
 </body>

 </html>