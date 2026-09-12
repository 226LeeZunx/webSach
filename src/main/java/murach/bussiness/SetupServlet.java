/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package murach.bussiness;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import murach.general.UserPool;
import murach.general.mainLobby;

/**
 *
 * @author dung2
 */
@WebServlet(name = "SetupServlet", urlPatterns = {"/Setup"})
public class SetupServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        UserPool userDB = new UserPool();
        getServletContext().setAttribute("UserDB", userDB);
        mainLobby initLobby = new mainLobby();
        getServletContext().setAttribute("initLobby", initLobby);
        
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/index.jsp").forward(request, response);

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }
    
}
