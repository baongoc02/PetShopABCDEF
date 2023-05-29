<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <div class="modal fade" id="${param.modalId}" tabindex="-1" role="dialog"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Bạn có chắc chắn muốn đăng xuất</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        X
                    </button>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Hủy</button>
                    <form action="/PetShop/logout" method="post">
                      <button type="submit" class="btn btn-primary" href="/PetShop/login">Đăng xuất</button>
                    </form>
                </div>
            </div>
        </div>
    </div>