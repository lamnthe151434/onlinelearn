<%-- 
    Document   : add-image
    Created on : May 22, 2022, 12:18:31 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body>
        <form action="" method="POST" enctype="multipart/form-data">
            <div class="d-flex flex-column align-items-center text-center p-3 py-5">                       
                <div class="mb-3">
                    Chọn ảnh: <input style="margin-top: 10px" class="form-control form-control-sm" id="formFileSm" type="file" accept=".jpg, .jpeg, .png"  name="img">
                </div>
            </div>
            <button>Submit</button>
        </form>
    </div>
</body>
</html>
