<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<div class="header-container">
    <h1> Shine Cloud </h1>
    <div class="login-panel"> 
        <c:choose>
            <c:when test="${cookie.userAcc.value == null}">
                <form name="Logform" action="Authentic" method="GET" style="display: inline-block;">
                    <input type="submit" value="Sign in" name="loginbutton" />
                    <input type="hidden" value="LoginAc" name="action" />
                </form>
                <form name="Regform" action="Authentic" method="GET" style="display: inline-block;">
                    <input type="submit" value="Create Account" name="Regisbutton" />
                    <input type="hidden" value="RegisAc" name="action" />
                </form>
            </c:when>
            <c:otherwise>
                <span>Hello, ${cookie.userAcc.value}!</span>
                <form name="Logoutform" action="Authentic" method="POST" style="display: inline-block;">
                    <input type="submit" value="Logout" name="logoutbutton" />
                    <input type="hidden" value="LogoutAc" name="action" />
                </form>
            </c:otherwise>
        </c:choose>
    </div>
    <hr>
</div>