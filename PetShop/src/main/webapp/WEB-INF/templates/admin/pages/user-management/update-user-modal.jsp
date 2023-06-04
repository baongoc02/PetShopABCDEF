<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <div class="modal fade" id="${param.modalId}" tabindex="-1" role="dialog"
        aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <form class="modal-content" method="POST" action="${param.targetUrl}"
              name="${param.formName}"
              onsubmit="return validateUpdatePassword()"
            >
                <div class="modal-header">
                    <h5 class="modal-title">Cập nhật mật khẩu người dùng</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        X
                    </button>
                </div>
                <input type="hidden" class="form-control" aria-label="Username" aria-describedby="basic-addon1" name="id">
                <div class="modal-body">
                  <div class="input-group">
                    <span class="input-group-text">Tên người dùng</span>
                    <input type="text" class="form-control" aria-label="Username" aria-describedby="basic-addon1" name="fullName" value="${fullName}">
                  </div>
                </div>
                <div class="modal-body">
                  <div class="input-group">
                    <span class="input-group-text">Mật khẩu mới</span>
                    <input type="text" class="form-control" aria-label="Username" aria-describedby="basic-addon1" name="password">
                  </div>
                </div>
                <div class="modal-footer">
                	<button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        Đóng
                    </button>
                  <button type="submit" class="btn btn-primary">Lưu</button>
                </div>
            </form>
        </div>
    </div>
    
    <script>
    function validateUpdatePassword() {
        const form = document.forms["${param.formName}"];
        
        const password = form["password"].value;
        if (password == null || password == '') {
          alert('Vui lòng nhập mật khẩu mới');
          return false;
        }
        
        if (password.length < 8 || password.length > 20) {
        	alert('Password phải có độ dài từ 8 đến 20 ký tự.');
            return false;
        }
        
        var lowerCaseLetters = /[a-z]/g;
        if(!password.match(lowerCaseLetters)) {
        	alert('Password phải có ít nhất một ký tự thường.');
            return false;
        }
        
        var upperCaseLetters = /[A-Z]/g;
        if(!password.match(upperCaseLetters)) {
        	alert('Password phải có ít nhất một ký tự in hoa.');
            return false;
        }
        
        var numbers = /[0-9]/g;
        if(!password.match(numbers)) {
        	alert('Password phải có ít nhất một ký tự số.');
            return false;
        }
        
        var specialChars = /[@,#,$,%,^,&,*]/g;
        if (!password.match(specialChars )) {
        	alert('Password phải có ít nhất một ký tự đặc biệt.');
            return false;
        }
        	
        return true;
      }
    </script>