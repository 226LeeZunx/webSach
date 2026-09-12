import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import murach.entity.User;
import murach.general.UserPool;

@WebServlet(urlPatterns = {"/Authentic"})
public class AuthenticServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        if (action == null) {
            action = "LoginAc"; 
        }

        switch (action) {
            case "LoginAc":
                request.getRequestDispatcher("/login.jsp").forward(request, response);
                break;
                
            case "RegisAc":
                request.getRequestDispatcher("/register.jsp").forward(request, response);
                break;                
            default:
                response.sendRedirect(request.getContextPath() + "/index.jsp");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        HttpSession session=request.getSession();
        String action = request.getParameter("action");
        UserPool userPool = (UserPool) getServletContext().getAttribute("UserDB");

        switch (action) {
            case "loginUser":
                String userAccount = request.getParameter("userAccount");
                String userPass = request.getParameter("userPass");
                session.setAttribute("userAccount",userAccount);
                String rememberMe = request.getParameter("rememberMe");
                
                User user = userPool.getUserByAccount(userAccount);

                if (user != null && user.getUserPass().equals(userPass)) {
                    Cookie loginCookie = new Cookie("userAcc", userAccount);
                    
                    if ("true".equals(rememberMe)) {
                        loginCookie.setMaxAge(60 * 30);
                    } else {
                        loginCookie.setMaxAge(-1); 
                    }
                    
                    response.addCookie(loginCookie);
                    response.sendRedirect(request.getContextPath() + "/index.jsp");
                } else {
                    request.setAttribute("errorMessage", "Tài khoản hoặc mật khẩu không chính xác!");
                    request.getRequestDispatcher("/login.jsp").forward(request, response);
                }
                break;

            case "registerUser":
                String fName = request.getParameter("userFirstName");
                String lName = request.getParameter("userLastName");
                boolean isMale = Boolean.parseBoolean(request.getParameter("isMale"));
                String email = request.getParameter("email");
                String newAccount = request.getParameter("userAccount");
                String newPass = request.getParameter("userPass");
                User tmpuser= new User(email,fName,lName,isMale);
                session.setAttribute("tmpuser",tmpuser);
                boolean isSuccess = userPool.addUser(fName, lName, isMale, email, newAccount, newPass);

                if (isSuccess) {
                    request.setAttribute("errorMessage", "Đăng ký thành công! Vui lòng đăng nhập.");
                    request.getRequestDispatcher("/login.jsp").forward(request, response);
                } else {
                    session.setAttribute("errorMessage", "Tên đăng nhập đã tồn tại. Vui lòng chọn tên khác!");
                    response.sendRedirect(request.getContextPath()+"/register.jsp");
                }
                break;
             case "LogoutAc":
                Cookie[] cookies = request.getCookies();
                if (cookies != null) {
                    for (Cookie cookie : cookies) {
                        if ("userAcc".equals(cookie.getName())) {
                            cookie.setMaxAge(0); 
                            response.addCookie(cookie);
                            break;
                        }
                    }
                }
                response.sendRedirect(request.getContextPath() + "/index.jsp");
                break;
            default:
                response.sendRedirect(request.getContextPath() + "/index.jsp");
                break;
        }
    }
}