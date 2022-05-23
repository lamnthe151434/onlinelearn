

<%@page import="java.sql.Blob"%>
<%@page import="model.User"%>
<%@page import="java.io.OutputStream"%>
<%@page import="model.Image"%>
<%@page import="dal.ImageDBContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    //String id = request.getParameter("id"); 
    User user = (User) request.getSession().getAttribute("user");
    try {
//        ImageDBContext db = new ImageDBContext();
//        Image anh1 = db.getImage(user.getUsername());
        Blob image = user.getImg();
        byte byteArray[] = image.getBytes(1, (int) image.length());
        response.setContentType("image/gif");
        OutputStream os = response.getOutputStream();
        os.write(byteArray);
        os.flush();
        os.close();
    } catch (Exception e) {
        out.println(e);
    }
%>
