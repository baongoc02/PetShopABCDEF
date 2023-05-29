<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <div class="modal fade" id='${param.modalId}' tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <form
              class="modal-content"
              method="POST"
              action="${param.targetUrl}"
              name="${param.formName}"
            >
              <div class="modal-header">
	              <h5 class="modal-title">Bạn có chắc muốn xóa sản phẩm này không?</h5>
	              <button class="close" type="button" data-dismiss="modal" aria-label="Close">
	                  X
	              </button>
	            </div>
	            <input type="hidden" name="id"/>
              <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Đóng</button>
                <button type="submit" class="btn btn-danger">Xóa</button>
              </div>
            </form>
        </div>
    </div>
  