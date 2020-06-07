package Core;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebServlet("/index")
public class index extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        User user = new User(-1, login);
        user = DataBase.checkUser(user);

        if (user.getId() == -1){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
            request.setAttribute("login", login);
            request.setAttribute("checkError", false);
            requestDispatcher.forward(request, response);
        } else if (DataBase.getPassword(user.getId()).equals(password)){
                HttpSession session = request.getSession();
                session.setAttribute("User", user);
                response.sendRedirect("/result");
        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
            request.setAttribute("login", login);
            request.setAttribute("checkError", false);
            requestDispatcher.forward(request, response);
        }

    }
}

