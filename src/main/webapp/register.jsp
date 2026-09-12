<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register - Shine Cloud</title>
        <link rel="stylesheet" type="text/css" href="styles/auth.css">
    </head>
    <body>
        <%@ include file="Chung/auth-header.jsp" %>
        
        <main>
            <form action="Authentic" method="POST">
                <h2>Create Account</h2>
                
                <c:if test="${not empty errorMessage}">
                    <p class="error-message">${errorMessage}</p>
                </c:if>
                
                <input type="hidden" name="action" value="registerUser" />
                
                    <p>
                        <label for="userFirstName">First Name:</label>
                        <input type="text" id="userFirstName" name="userFirstName" value="${tmpuser.userFirstName}" required />
                    </p>
                    
                    <p>
                        <label for="userLastName">Last Name:</label>
                        <input type="text" id="userLastName" name="userLastName" value="${tmpuser.userLastName}"required />
                    </p>
                    
                    <p>
                        <label>Gender:</label><br>
                        <input type="radio" id="male" name="isMale" value="${tmpuser.isMale}" checked>
                        <label for="male" style="display:inline; font-weight:normal;">Male</label>
                        
                        <input type="radio" id="female" name="isMale" value="false">
                        <label for="female" style="display:inline; font-weight:normal;">Female</label>
                    </p>

                    <p>
                        <label for="email">Email:</label>
                        <input type="email" id="email" name="email" value="${tmpuser.email}" required />
                    </p>
                    
                    <p>
                        <label for="userAccount">Username:</label>
                        <input type="text" id="userAccount" name="userAccount" required />
                    </p>
                    
                    <p>
                        <label for="userPass">Password:</label>
                        <input type="password" id="userPass" name="userPass" required />
                    </p>
            
                
                <p>
                    <button type="submit">Register Account</button>
                </p>
                
                <p >Already have an account? <a href="Authentic?action=LoginAc">Sign in</a></p>
            </form>
        </main>
    </body>
</html>