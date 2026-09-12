<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Book Page</title>
        <link rel="stylesheet" type="text/css" href="styles/main.css">
    </head>
    <body>
        <%@ include file="Chung/header.jsp" %>
                
        <div class="book-list">
            <c:forEach var="item" items="${listBook}">
                <div class="book-item">
                    <img src="Image/${item.imagePath}" width="100" height="100"/>
                    <a href="BookService?action=reqestDownload&amp;fileName=${item.path}">
                       ${item.bookName}
                    </a>
                </div>
            </c:forEach>
        </div>
    </body>
</html>