<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <div class="modal fade" id="${param.modalId}" tabindex="-1" role="dialog"
        aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <form class="modal-content" method="POST" action="${param.targetUrl}"
              name="${param.formName}"
            >
                <div class="modal-header">
                    <h5 class="modal-title">Feedback</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        X
                    </button>
                </div>
                <input type="hidden" class="form-control" aria-label="Username" aria-describedby="basic-addon1" name="id">
                <div class="modal-body">
                  <div class="input-group">
                    <span class="input-group-text">Tên khách hàng</span>
                    <input type="text" class="form-control" aria-label="Username" aria-describedby="basic-addon1" name="fullName" value="${fullName}">
                  </div>
                </div>
                <div class="modal-body">
                  <div class="input-group">
                    <span class="input-group-text">Email</span>
                    <input type="text" class="form-control" aria-label="Username" aria-describedby="basic-addon1" name="email" value="${email}">
                  </div>
                </div>
                <div class="modal-body">
                  <div class="input-group">
                    <span class="input-group-text">Số điện thoại</span>
                    <input type="text" class="form-control" aria-label="Username" aria-describedby="basic-addon1" name="phoneNumber" value="${phoneNumber}">
                  </div>
                </div>
                <div class="modal-body">
                  <div class="input-group">
                    <span class="input-group-text">Địa chỉ</span>
                    <input type="text" class="form-control" aria-label="Username" aria-describedby="basic-addon1" name="address" value="${address}">
                  </div>
                </div>
                <div class="modal-body">
                  <div class="input-group">
                    <span class="input-group-text">Nội dung</span>
                    <input type="text" class="form-control" aria-label="Username" aria-describedby="basic-addon1" name="content" value="${content}">
                  </div>
                </div>
                <div class="modal-footer">
                	<button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        Đóng
                    </button>
                </div>
            </form>
        </div>
    </div>
    
    <script>
    
    </script>