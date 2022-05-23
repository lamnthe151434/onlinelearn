<%-- 
    Document   : header
    Created on : May 20, 2022, 10:31:18 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
        <link href="assets/css/style.css" rel="stylesheet">
    </head>
    <body>


        <!-- Navbar Start -->
        <div class="container-fluid" style="border-bottom: 1px solid #ccc;">
            <div class="row border-top px-xl-0">
                <!--                <div class="col-lg-3 d-none d-lg-block">
                                    <a class="d-flex align-items-center justify-content-between bg-secondary w-100 text-decoration-none" data-toggle="collapse" href="#navbar-vertical" style="height: 67px; padding: 0 30px;">
                                        <h5 class="text-primary m-0"><i class="fa fa-book-open mr-2"></i>Subjects</h5>
                                        <i class="fa fa-angle-down text-primary"></i>
                                    </a>
                                    <nav class="collapse position-absolute navbar navbar-vertical navbar-light align-items-start p-0 border border-top-0 border-bottom-0 bg-light" id="navbar-vertical" style="width: calc(100% - 30px); z-index: 9;">
                                        <div class="navbar-nav w-100">
                                            <div class="nav-item dropdown">
                                                <a href="#" class="nav-link" data-toggle="dropdown">Web Design <i class="fa fa-angle-down float-right mt-1"></i></a>
                                                <div class="dropdown-menu position-absolute bg-secondary border-0 rounded-0 w-100 m-0">
                                                    <a href="" class="dropdown-item">HTML</a>
                                                    <a href="" class="dropdown-item">CSS</a>
                                                    <a href="" class="dropdown-item">jQuery</a>
                                                </div>
                                            </div>
                                            <a href="" class="nav-item nav-link">Apps Design</a>
                                            <a href="" class="nav-item nav-link">Marketing</a>
                                            <a href="" class="nav-item nav-link">Research</a>
                                            <a href="" class="nav-item nav-link">SEO</a>
                                        </div>
                                    </nav>
                                </div>-->
                <div class="col-lg-3 logo">
                    <a href="" class="text-decoration-none">
                        <h1 class="m-0"><span class="text-primary">E</span>COURSE</h1>
                    </a>
                </div>



                <div class="col-lg-7" >
                    <nav class="navbar navbar-expand-lg bg-light navbar-light py-3 py-lg-0 px-0">

                        <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                            <div class="search-bar">
                                <form class="search-form d-flex align-items-center" method="POST" action="#">
                                    <input type="text" name="query" placeholder="Search" title="Enter search keyword">
                                    <button type="submit" title="Search"><i class="bi bi-search"></i></button>
                                </form>
                            </div><!-- End Search Bar -->
                            <div class="navbar-nav py-0">
                                <a href="http://localhost:8080/onlinelearn/home" class="nav-item nav-link active">Trang chủ</a>
                                <a href="" class="nav-item nav-link">Khóa học của tôi</a>
                                <a href="" class="nav-item nav-link">Giảng viên</a>
                                <div class="nav-item dropdown">
                                    <a href="" class="nav-link dropdown-toggle" data-toggle="dropdown">Blog</a>
                                    <div class="dropdown-menu rounded-0 m-0">
                                        <a href="" class="dropdown-item">Blog</a>
                                        <a href="single.html" class="dropdown-item">Thông tin blog</a>
                                    </div>
                                </div>
                                <a href="http://localhost:8080/onlinelearn/contact" class="nav-item nav-link">Liên hệ</a>
                            </div>
                            <!--<a class="btn btn-primary py-2 px-4 ml-auto d-none d-lg-block" href="http://localhost:8080/onlinelearn/login">Đăng nhập</a>-->
                            <!--<a class="btn btn-primary py-2 px-4 ml-auto d-none d-lg-block" href="http://localhost:8080/onlinelearn/register">Đăng ký</a>-->
                        </div>
                    </nav>
                </div>
                <div class="col-lg-2" style="padding: 10px; box-sizing: border-box;">
                    <nav class="header-nav ms-auto">
                        <ul class="d-flex align-items-center">

                            <li style="list-style-type: none;" class="nav-item dropdown">

                                <a class="nav-link nav-icon" href="#" data-bs-toggle="dropdown">
                                    <i class="bi bi-bell"></i>
                                    <span class="badge bg-primary badge-number">3</span>
                                </a><!-- End Notification Icon -->

                                <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow notifications">
                                    <li class="dropdown-header">
                                        Bạn có 3 thông báo
                                        <a href="#"><span class="badge rounded-pill  p-2 ms-2">Xem tất cả</span></a>
                                    </li>
                                    <li>
                                        <hr class="dropdown-divider">
                                    </li>

                                    <c:forEach var="x" begin="0" end="2">
                                        <li class="notification-item">
                                            <i class="bi bi-exclamation-circle"></i>
                                            <div>
                                                <h4>Thông báo ${x + 1}</h4>
                                                <p>Nội dung thông báo ${x + 1}</p>
                                                <p>Thời gian ${x + 1}</p>
                                            </div>
                                        </li>

                                        <li>
                                            <hr class="dropdown-divider">
                                        </li>
                                    </c:forEach>
                                    <li class="dropdown-footer">
                                        <a href="#">Show all notifications</a>
                                    </li>

                                </ul><!-- End Notification Dropdown Items -->

                            </li><!-- End Notification Nav -->

                            <li class="nav-item dropdown pe-3">

                                <a class="nav-link nav-profile d-flex align-items-center pe-0" href="#" data-bs-toggle="dropdown">
                                    <img style="margin-right: 5px;" src="assets/img/profile-img.jpg" alt="Profile" class="rounded-circle">
                                    <span class="d-none d-md-block dropdown-toggle ps-2">${requestScope.user.name}</span>
                                </a><!-- End Profile Iamge Icon -->

                                <ul style="width: 230px;" class="dropdown-menu dropdown-menu-end dropdown-menu-arrow ">
                                    <li class="dropdown-header">
                                        <h6>${requestScope.user.name}</h6>
                                        <span>${requestScope.userGroup}</span>
                                    </li>
                                    <li>
                                        <hr class="dropdown-divider">
                                    </li>

                                    <li>
                                        <a class="dropdown-item d-flex align-items-center" href="http://localhost:8080/onlinelearn/authen/user/profile">
                                            <i class="bi bi-person"></i>
                                            <span>Thông tin cá nhân</span>
                                        </a>
                                    </li>
                                    <li>
                                        <hr class="dropdown-divider">
                                    </li>

                                    <li>
                                        <a class="dropdown-item d-flex align-items-center" href="http://localhost:8080/onlinelearn/password/change">
                                            <i class="bi bi-gear"></i>
                                            <span>Thay đổi mật khẩu</span>
                                        </a>
                                    </li>
                                    <li>
                                        <hr class="dropdown-divider">
                                    </li>

                                    <li>
                                        <a class="dropdown-item d-flex align-items-center" href="">
                                            <i class="bi bi-question-circle"></i>
                                            <span>Hỗ trợ</span>
                                        </a>
                                    </li>
                                    <li>
                                        <hr class="dropdown-divider">
                                    </li>

                                    <li>
                                        <a class="dropdown-item d-flex align-items-center" href="http://localhost:8080/onlinelearn/logout">
                                            <i class="bi bi-box-arrow-right"></i>
                                            <span>Đăng xuất</span>
                                        </a>
                                    </li>

                                </ul><!-- End Profile Dropdown Items -->
                            </li><!-- End Profile Nav -->

                        </ul>
                    </nav>
                </div>
            </div>
        </div>
        <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Template Main JS File -->
        <!--<script src="assets/js/main.js"></script>-->
        <!-- Navbar End -->
    </body>
    <script>

    </script>
</html>
