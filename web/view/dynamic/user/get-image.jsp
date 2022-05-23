

<%@page import="java.sql.Blob"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Topic"%>
<%@page import="model.User"%>
<%@page import="java.io.OutputStream"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    try {
        Blob image = (Blob) request.getAttribute("image");
        byte byteArray[] = image.getBytes(1, (int) image.length());
        response.setContentType("image/gif");
        OutputStream os = response.getOutputStream();
        System.out.println("ok");
        os.write(byteArray);
        os.flush();
        os.close();
    } catch (Exception e) {
        out.println(e);
    }
%>
<!--
<body>
    <p>3</p>
</body>-->
