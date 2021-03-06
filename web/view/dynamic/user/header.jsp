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
        <link href="../../assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
        <link href="../../assets/css/style.css" rel="stylesheet">
    </head>
    <body>
        <!-- Topbar Start -->
<!--        <div class="container-fluid d-none d-lg-block">
            <div class="row align-items-center py-4 px-xl-5">
                <div class="col-lg-3">
                    <a href="" class="text-decoration-none">
                        <h1 class="m-0"><span class="text-primary">E</span>COURSES</h1>
                    </a>
                </div>
                <div class="col-lg-3 text-right">
                    <div class="d-inline-flex align-items-center">
                        <i class="fa fa-2x fa-map-marker-alt text-primary mr-3"></i>
                        <div class="text-left">
                            <h6 class="font-weight-semi-bold mb-1">Our Office</h6>
                            <small>123 Street, New York, USA</small>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 text-right">
                    <div class="d-inline-flex align-items-center">
                        <i class="fa fa-2x fa-envelope text-primary mr-3"></i>
                        <div class="text-left">
                            <h6 class="font-weight-semi-bold mb-1">Email Us</h6>
                            <small>info@example.com</small>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 text-right">
                    <div class="d-inline-flex align-items-center">
                        <i class="fa fa-2x fa-phone text-primary mr-3"></i>
                        <div class="text-left">
                            <h6 class="font-weight-semi-bold mb-1">Call Us</h6>
                            <small>+012 345 6789</small>
                        </div>
                    </div>
                </div>
            </div>
        </div>-->
        <!-- Topbar End -->


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
                                <a href="http://localhost:8080/onlinelearn/home" class="nav-item nav-link active">Trang ch???</a>
                                <a href="" class="nav-item nav-link">Kh??a h???c c???a t??i</a>
                                <!--<a href="" class="nav-item nav-link">Gi???ng vi??n</a>-->
                                <div class="nav-item dropdown">
                                    <a href="" class="nav-link dropdown-toggle" data-toggle="dropdown">Blog</a>
                                    <div class="dropdown-menu rounded-0 m-0">
                                        <a href="" class="dropdown-item">Blog</a>
                                        <a href="single.html" class="dropdown-item">Th??ng tin blog</a>
                                    </div>
                                </div>
                                <a href="http://localhost:8080/onlinelearn/contact" class="nav-item nav-link">Li??n h???</a>
                            </div>
                            <!--<a class="btn btn-primary py-2 px-4 ml-auto d-none d-lg-block" href="http://localhost:8080/onlinelearn/login">????ng nh???p</a>-->
                            <!--<a class="btn btn-primary py-2 px-4 ml-auto d-none d-lg-block" href="http://localhost:8080/onlinelearn/register">????ng k??</a>-->
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
                                        B???n c?? 3 th??ng b??o
                                        <a href="#"><span class="badge rounded-pill  p-2 ms-2">Xem t???t c???</span></a>
                                    </li>
                                    <li>
                                        <hr class="dropdown-divider">
                                    </li>

                                    <c:forEach var="x" begin="0" end="2">
                                        <li class="notification-item">
                                            <i class="bi bi-exclamation-circle"></i>
                                            <div>
                                                <h4>Th??ng b??o ${x + 1}</h4>
                                                <p>N???i dung th??ng b??o ${x + 1}</p>
                                                <p>Th???i gian ${x + 1}</p>
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
                                    <img style="margin-right: 5px;" src="../../assets/img/profile-img.jpg" alt="Profile" class="rounded-circle">
                                    <span class="d-none d-md-block dropdown-toggle ps-2">${sessionScope.user.name}</span>
                                </a><!-- End Profile Iamge Icon -->

                                <ul style="width: 230px;" class="dropdown-menu dropdown-menu-end dropdown-menu-arrow ">
                                    <li class="dropdown-header">
                                        <h6>${sessionScope.user.name}</h6>
                                        <span>${sessionScope.userGroup}</span>
                                    </li>
                                    <li>
                                        <hr class="dropdown-divider">
                                    </li>

                                    <li>
                                        <a class="dropdown-item d-flex align-items-center" href="http://localhost:8080/onlinelearn/authen/user/profile">
                                            <i class="bi bi-person"></i>
                                            <span>Th??ng tin c?? nh??n</span>
                                        </a>
                                    </li>
                                    <li>
                                        <hr class="dropdown-divider">
                                    </li>

                                    <li>
                                        <a class="dropdown-item d-flex align-items-center" href="http://localhost:8080/onlinelearn/password/change">
                                            <i class="bi bi-gear"></i>
                                            <span>?????i m???t kh???u</span>
                                        </a>
                                    </li>
                                    <li>
                                        <hr class="dropdown-divider">
                                    </li>

                                    <li>
                                        <a class="dropdown-item d-flex align-items-center" href="">
                                            <i class="bi bi-question-circle"></i>
                                            <span>H??? tr???</span>
                                        </a>
                                    </li>
                                    <li>
                                        <hr class="dropdown-divider">
                                    </li>

                                    <li>
                                        <a class="dropdown-item d-flex align-items-center" href="http://localhost:8080/onlinelearn/logout">
                                            <i class="bi bi-box-arrow-right"></i>
                                            <span>????ng xu???t</span>
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
