<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login - Shine Cloud</title>
        <link rel="stylesheet" type="text/css" href="styles/auth.css">
    </head>
    <body>
        <%@ include file="Chung/auth-header.jsp" %>
        
        <main>
            <form action="Authentic" method="POST" >
                <h2>Sign In</h2>
                
                <c:if test="${not empty requestScope.errorMessage}">
                    ${requestScope.errorMessage}
                </c:if>
                
                <input type="hidden" name="action" value="loginUser" />
                
                    <p>
                        <label for="userAccount">Account:</label>
                        <input type="text" id="userAccount" name="userAccount" value="${userAccount}" required />
                    </p>
                    
                    <p>
                        <label for="userPass">Password:</label>
                        <input type="password" id="userPass" name="userPass" required />
                    </p>
                    
                    <p>
                        <input type="checkbox" id="rememberMe" name="rememberMe" value="true" />
                        <label for="rememberMe" style="display:inline; font-weight:normal; cursor:pointer;">Remember me</label>
                    </p>                
                <p>
                    <button type="submit">Login</button>
                </p>
                
                <p style="text-align: center;">Don't have an account? <a href="Authentic?action=RegisAc">Register here</a></p>
            </form>
        </main>
    </body>
</html>