<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!-- Bootstrap core JavaScript-->
    <script src="/PetShop/static/admin/vendor/jquery/jquery.min.js"></script>
    <script src="/PetShop/static/admin/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="/PetShop/static/admin/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="/PetShop/static/admin/js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="/PetShop/static/admin/vendor/chart.js/Chart.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="/PetShop/static/admin/js/demo/chart-area-demo.js"></script>
    <script src="/PetShop/static/admin/js/demo/chart-pie-demo.js"></script>
    
    <script>
    const vndFormat = (x) => x.toLocaleString('it-IT', {style : 'currency', currency : 'VND'});
    const vnds = document.getElementsByClassName('vnd');
    for (const vnd of vnds) {
  	  vnd.textContent = vndFormat(parseInt(vnd.textContent));
    }
    </script>