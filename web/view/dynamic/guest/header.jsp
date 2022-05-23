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
    </head>
    <style>
        .logo {
            padding-top: 12px;
        }
    </style>
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
        <div class="container-fluid">
            <div class="row border-top px-xl-5">
                <div class="col-lg-3 d-none d-lg-block logo">
                    <h1 class="m-0"><span class="text-primary ">E</span>COURSE</h1>
                    <!--                    <a class="d-flex align-items-center justify-content-between bg-secondary w-100 text-decoration-none" data-toggle="collapse" href="#navbar-vertical" style="height: 67px; padding: 0 30px;">
                                            <h5 class="text-primary m-0"><i class="fa fa-book-open mr-2"></i>Subjects</h5>
                                            <i class="fa fa-angle-down text-primary"></i>
                                        </a>-->
                    <!--                    <nav class="collapse position-absolute navbar navbar-vertical navbar-light align-items-start p-0 border border-top-0 border-bottom-0 bg-light" id="navbar-vertical" style="width: calc(100% - 30px); z-index: 9;">
                                                                   <h1 class="m-0"><span class="text-primary">E</span>COURSES</h1>
                    
                                        </nav>-->
                </div>
                <div class="col-lg-9">
                    <nav class="navbar navbar-expand-lg bg-light navbar-light py-3 py-lg-0 px-0">
                        <a href="" class="text-decoration-none d-block d-lg-none">
                            <h1 class="m-0"><span class="text-primary">E-</span>LEARN</h1>
                        </a>
                        <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                            <div class="navbar-nav py-1 px-4">
                                <a href="http://localhost:8080/onlinelearn/home" class="nav-item nav-link active">Trang chủ</a>
                                <a href="http://localhost:8080/onlinelearn/about" class="nav-item nav-link">Về chúng tôi</a>
                                <a href="http://localhost:8080/onlinelearn/course/popular" class="nav-item nav-link">Khóa học</a>
                                <a href="http://localhost:8080/onlinelearn/expert/list" class="nav-item nav-link">Giảng viên</a>
                                <div class="nav-item dropdown">
                                    <a href="http://localhost:8080/onlinelearn/blog" class="nav-link dropdown-toggle" data-toggle="dropdown">Blog</a>
                                    <div class="dropdown-menu rounded-0 m-0">
                                        <a href="http://localhost:8080/onlinelearn/blog" class="dropdown-item">Blog</a>
                                        <a href="single.html" class="dropdown-item">Thông tin blog</a>
                                    </div>
                                </div>
                                <a href="http://localhost:8080/onlinelearn/contact" class="nav-item nav-link">Liên hệ</a>
                            </div>
                            <div class="navbar-nav py-1 px-1">
                                <a style="margin-right: 10px;" class="btn btn-primary py-2 px-4 ml-auto d-none d-lg-block" href="http://localhost:8080/onlinelearn/login">Đăng nhập</a>
                                <a style="margin: 0px;" class="btn btn-primary py-2 px-4 ml-auto d-none d-lg-block" href="http://localhost:8080/onlinelearn/register">Đăng ký</a>
                            </div>

                        </div>
                    </nav>
                </div>
            </div>
        </div>
        <!-- Navbar End -->
    </body>
</html>
