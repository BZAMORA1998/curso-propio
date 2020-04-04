<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Usuarios</title>
    </head>
    <body>
        <h1>Lista de usuarios</h1>
        <ul>
            <c:forEach items="${usuarios}" var="usuario">
                <li>${usuario.username} ${usuario.password}</li>
            </c:forEach>
        </ul>
            
    </body>
</html>
