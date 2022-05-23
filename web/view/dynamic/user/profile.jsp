<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link href="../../assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
        <link href="../../assets/css/style.css" rel="stylesheet">
        <!--<link href="../../css/style.css" rel="stylesheet">-->
        <meta charset="utf-8">
        <title>Online-Learn</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="Free HTML Templates" name="keywords">
        <meta content="Free HTML Templates" name="description">

        <!-- Favicon -->
        <link href="img/favicon.ico" rel="icon">

        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <!--<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap" rel="stylesheet">--> 
        <link href="https://fonts.googleapis.com/css2?family=Alegreya&family=Spectral&family=Tinos&display=swap" rel="stylesheet"> 
        <!-- Font Awesome -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

        <!-- Libraries Stylesheet -->
        <link href="../../lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

        <!-- Customized Bootstrap Stylesheet -->
        <link href="../../css/style.css" rel="stylesheet">

        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <style>

        /*        body {
                    background:whitesmoke
                }*/

        .form-control:focus {
            box-shadow: none;
            border-color: #BA68C8
        }

        .profile-button {
            background: #0e4bf1;
            box-shadow: none;
            border: none
        }

        .profile-button:hover {
            background: #682773

        }

        .profile-button:focus {
            background: blue;
            box-shadow: none
        }

        .profile-button:active {
            background: blue;
            box-shadow: none
        }

        .back:hover {
            color: #682773;
            cursor: pointer
        }

        .labels {
            font-size: 11px
        }

        .add-experience:hover {
            background: #BA68C8;
            color: #fff;
            cursor: pointer;
            border: solid 1px #BA68C8
        }

        .user-profile {
            display: flex;
            /*margin: auto;*/
            width: 80%;
            margin-left: 350px;
            /*border: 1px solid #000;*/
            border-radius: 10px;
            /*box-shadow: 2px 2px 2px 2px solid #ccc;*/
            background-color: #fff;
        }
        .user-profile form {
            margin: auto;
            width: 100%;
            /*height: 500px;*/
        }

    </style>
    <body>
        <div>
            <jsp:include page="header.jsp"></jsp:include>
            </div>
            <div class="container-fluid page-header" style="margin-bottom: 90px;">
                <div class="container">
                    <div class="d-flex flex-column justify-content-center" style="min-height: 300px">
                        <h3 class="display-4 text-white text-uppercase">Thông tin cá nhân</h3>
                        <div class="d-inline-flex text-white">
                            <p class="m-0 text-uppercase"><a class="text-white" href="">Trang Chủ</a></p>
                            <i class="fa fa-angle-double-right pt-1 px-3"></i>
                            <p class="m-0 text-uppercase">Thông tin cá nhân</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container rounded bg-white mt-5 mb-5 user-profile">  
                <form action="profile" method="POST" enctype="multipart/form-data">
                    <div class="row">               
                        <div class="col-md-3 border">
                            <div class="d-flex flex-column align-items-center text-center p-3 py-5">                       
                            <c:if test="${requestScope.user.img==null}"><img class="rounded-circle mt-5" width="150px" height="150px" src="../../img/default.jpg"></c:if>
                            <c:if test="${requestScope.user.img!=null}"><img class="rounded-circle mt-5" width="150px" height="150px" src="../../view/dynamic/user/getImage.jsp"></c:if>
                            <c:if test="${requestScope.user.name!=null}"><span class="font-weight-bold" style="margin-top: 10px">${requestScope.user.name}</span></c:if>
                            <c:if test="${requestScope.user.name==null}"><span class="font-weight-bold" style="margin-top: 10px">Chưa cập nhật tên</span></c:if>                      
                                <div class="mb-3">
                                    Chọn ảnh: <input style="margin-top: 10px" class="form-control form-control-sm" id="formFileSm" type="file" accept=".jpg, .jpeg, .png"  name="img">
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 border">
                            <div class="p-3 py-5">
                                <div class="d-flex justify-content-between align-items-center mb-3">
                                    <h4 class="text-right">Thông tin cá nhân</h4>
                                </div> 
                            <c:if test="${requestScope.tbao!=null}">${requestScope.tbao}</c:if>
                                <div class="row mt-3">
                                    <div class="col-md-6"><label class="labels">Tài khoản</label><br/>${sessionScope.user.username}<input name="username" type="hidden" value="${sessionScope.user.username}"></div>
                                <div class="col-md-6"><label class="labels">Email</label><br/>${sessionScope.user.email}</div>
                            </div>                          
                            <div class="row mt-2">                               
                                <div class="col-md-6"><label class="labels">Họ và tên (bắt buộc)</label><input name="name" type="text" class="form-control" placeholder="Họ và tên" value="${requestScope.user.name}" required></div>                           
                                <div class="col-md-6"><label class="labels">Ngày sinh (tùy chọn)</label><input name="dob" type="date" class="form-control"  value="${requestScope.user.dob}"></div>
                            </div>                       
                            <div class="row mt-2">                                
                                <div class="col-md-6"><label class="labels">Số điện thoại (tùy chọn)</label><input name="phone" pattern="[0-9]{10}" type="text" class="form-control" placeholder="Số điện thoại" value="${requestScope.user.phone}"></div>                               
                                <div class="col-md-6"><label class="labels">Giới tính (tùy chọn)</label><br/>                                  
                                    <input ${requestScope.user.gender?"checked=\"checked\"":""}
                                        type="radio" value="male" name="gender"> Nam
                                    <input ${!requestScope.user.gender?"checked=\"checked\"":""} 
                                        type="radio" value="female" name="gender" style="margin-left: 10px"> Nữ
                                </div>
                            </div>                         
                            <div class="row mt-3">
                                <div class=""><label class="labels">Địa chỉ</label><br/><input name="address" type="text" class="form-control" placeholder="Địa chỉ" value="${requestScope.user.address}"></div>
                            </div>
                            <div class="row mt-3">
                                <div class=""><label class="labels">Mô tả về bản thân</label><br/><textarea class="form-control" id="exampleFormControlTextarea1" rows="5" name="description"  value="${requestScope.user.description}">${requestScope.user.description}</textarea></div>
                            </div>
                            <div class="mt-5 text-center"><button class="btn btn-primary profile-button" type="submit" style="margin-right: 20px">Lưu thông tin</button>
                                <!--<a href="http://localhost:8080/onlinelearn/home"><button class="btn btn-primary profile-button" type="button">Về trang chủ</button></a>-->
                            </div>
                        </div>
                    </div>
                    <!--                    <div class="col-md-3">
                                            <div class="p-3 py-5">
                                                <div class="d-flex justify-content-between align-items-center experience"><span>Khoá học của tôi</span>
                                                </div><br>
                                                <div class="text-center"><a href="#"><button class="btn btn-primary profile-button" type="button">Tới các khoá học</button></a></div>
                                            </div>
                                        </div>-->
                </div>  
            </form>


        </div>
        <div>
            <jsp:include page="../component/footer.jsp"></jsp:include>
        </div>
        <script src="../../assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
        <!-- thư viện ckeditor 4 -->
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="//cdn.ckeditor.com/4.18.0/basic/ckeditor.js"></script>
        <script>
            CKEDITOR.replace('description');//name textarea
        </script>
        <!--.... -->
    </body>
</html>
