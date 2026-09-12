package murach.bussiness;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import murach.entity.Book;
import murach.general.mainLobby;
@WebServlet(name = "BookServiceServlet", urlPatterns = {"/BookService"})
public class BookServiceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    String action = request.getParameter("action");
    if (action == null) {
        action = "default";
    }

    switch (action) {
        case "viewBooks":
            String typeBookCode = request.getParameter("typeBookCode");
            mainLobby presentLobby = (mainLobby) getServletContext().getAttribute("initLobby");
            List<Book> listBook = presentLobby.gettypeBookbyID(typeBookCode).getBooks();
            
            request.getSession().setAttribute("listBook", listBook);
            response.sendRedirect(request.getContextPath() + "/bookPage.jsp");
            return;

        case "reqestDownload":
            if (!isUserLoggedIn(request)) {
               response.sendRedirect(request.getContextPath() + "/Authentic?action=LoginAc");        
               return;
            }

            String fileName = request.getParameter("fileName");
            response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
            request.getRequestDispatcher("/Download/" + fileName).forward(request, response);
            return; 

        case "default":
        default:
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            break;
    }
}
    private boolean isUserLoggedIn(HttpServletRequest request) {
       Cookie[] cookies = request.getCookies();
         if (cookies != null) {
            for (Cookie c : cookies) {
               if ("userAcc".equals(c.getName())) {
                   return true;
               }
            }
    }
    return false;
}
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
