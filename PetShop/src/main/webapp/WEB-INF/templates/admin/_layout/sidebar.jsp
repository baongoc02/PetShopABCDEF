<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="/PetShop/admin">
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fas fa-laugh-wink"></i>
                </div>
                <div class="sidebar-brand-text mx-3">PetShop Dasboard</div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">
            
            <li class="nav-item active">
                <a class="nav-link" href="/PetShop">
                    <i class="fas fa-arrow-left"></i>
                    <span>Quay lại trang chính</span></a>
            </li>

            <!-- Nav Item - Dashboard -->
            <li class="nav-item active">
                <a class="nav-link" href="/PetShop/admin">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Quản trị</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->
            <div class="sidebar-heading">
                Sản phẩm	
            </div>

			<li class="nav-item active">
                <a class="nav-link" href="/PetShop/admin/animal-management">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Loại thú cưng</span></a>
            </li>
            <!-- Nav Item - Pages Collapse Menu -->
            <li class="nav-item" style="display: none;">
                <a class="nav-link collapsed" href="/PetShop/admin" data-toggle="collapse" data-target="#animalsCollapse"
                    aria-expanded="true" aria-controls="collapseTwo">
                    <i class="fas fa-fw fa-cog"></i>
                    <span>Thú cưng kinh doanh</span>
                </a>
                <div id="animalsCollapse" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <a class="collapse-item" href="/PetShop/admin/animal-management">Quản lý</a>
                    </div>
                </div>
            </li>
            
            <li class="nav-item active">
                <a class="nav-link" href="/PetShop/admin/category-management">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Loại sản phẩm</span></a>
            </li>
            
            <li class="nav-item active">
                <a class="nav-link" href="/PetShop/admin/product-management">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Sản phẩm</span></a>
            </li>

            <div class="sidebar-heading">
                Đơn hàng
            </div>

            <!-- Nav Item - Utilities Collapse Menu -->
            <li class="nav-item active">
                <a class="nav-link" href="/PetShop/admin/order-management">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Quản lý đơn hàng</span></a>
            </li>
            
            <div class="sidebar-heading">
                Người dùng
            </div>

            <!-- Nav Item - Utilities Collapse Menu -->
            <li class="nav-item active">
                <a class="nav-link" href="/PetShop/admin/user-management">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Quản lý người dùng</span></a>
            </li>
            
            <div class="sidebar-heading">
                Feedback
            </div>

            <!-- Nav Item - Utilities Collapse Menu -->
            <li class="nav-item active">
                <a class="nav-link" href="/PetShop/admin/feedbacks">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Các feedback</span></a>
            </li>
            
            <div class="sidebar-heading" style="display:none">
                Cài đặt
            </div>

            <!-- Nav Item - Utilities Collapse Menu -->
            <li class="nav-item" style="display:none">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#settingCollapse"
                    aria-expanded="true" aria-controls="collapseUtilities">
                    <i class="fas fa-fw fa-wrench"></i>
                    <span>Chung</span>
                </a>
                <div id="settingCollapse" class="collapse" aria-labelledby="headingUtilities"
                    data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Custom Utilities:</h6>
                        <a class="collapse-item" href="utilities-color.html">Colors</a>
                        <a class="collapse-item" href="utilities-border.html">Borders</a>
                        <a class="collapse-item" href="utilities-animation.html">Animations</a>
                        <a class="collapse-item" href="utilities-other.html">Other</a>
                    </div>
                </div>
            </li>
          </ul>