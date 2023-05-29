<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <div class="modal fade" id="${param.modalId}" tabindex="-1" role="dialog"
        aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <form class="modal-content" method="POST" action="${param.targetUrl}"
              name="${param.formName}"
              onsubmit="return validateUpdateProduct()"
            >
                <div class="modal-header">
                    <h5 class="modal-title">Cập nhật thông tin sản phẩm</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        X
                    </button>
                </div>
                <input type="hidden" class="form-control" aria-label="Username" aria-describedby="basic-addon1" name="id">
                <div class="modal-body">
                  <div class="input-group">
                    <span class="input-group-text">Mã sản phẩm</span>
                    <input type="text" class="form-control" aria-label="Username" aria-describedby="basic-addon1" name="productCode">
                  </div>
                </div>
                <div class="modal-body">
                  <div class="input-group">
                    <span class="input-group-text">Tên sản phẩm</span>
                    <input type="text" class="form-control" aria-label="Username" aria-describedby="basic-addon1" name="productName">
                  </div>
                </div>
                <div class="modal-body">
                  <div class="input-group">
                    <span class="input-group-text">Giá</span>
                    <input type="number" step="1" min="1000" class="form-control" aria-label="Username" aria-describedby="basic-addon1" name="price">
                  </div>
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Đóng</button>
                  <button type="submit" class="btn btn-primary">Lưu</button>
                </div>
            </form>
        </div>
    </div>
    
    <script>
    function validateUpdateProduct() {
      const form = document.forms["${param.formName}"];
      
      const productCode = form["productCode"].value;
      if (productCode == null || productCode == '') {
        alert('Vui lòng nhập mã sản phẩm');
        return false;
      }
      
      const productName = form["productName"].value;
      if (productName == null || productName == '') {
        alert('Vui lòng nhập tên sản phẩm');
        return false;
      }
      
      const price = parseInt(form["price"].value);
      if (isNan(price)) {
        alert('Vui lòng nhập giá sản phẩm');
        return false;
      }
      
      if (price < 1000) {
        alert('Giá sản phẩm phải >= 1000 VNĐ');
        return false;
      }
      
      return true;
    }
    </script>