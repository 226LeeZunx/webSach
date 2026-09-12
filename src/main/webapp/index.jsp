<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome Page</title>
        <link rel="stylesheet" type="text/css" href="styles/main.css">
    </head>
    <body>
        <%@ include file="Chung/header.jsp" %>

        <div class="link_label">
            <c:forEach var="item" items="${initLobby.getNowLobby()}">
                <a href="BookService?action=viewBooks&amp;typeBookCode=${item.id}">
                  ${item.typeName}
                </a><br>
            </c:forEach>
        </div>
    </body>
</html>