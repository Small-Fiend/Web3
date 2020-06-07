package Core;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

//@WebServlet("/result")
public class result extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("User");

        List<Branch> array = DataBase.getBranch(user.getId());

        if (array.size() != 0){
            user.setBranch(array);
            request.setAttribute("checkEmpty", false);
        } else {
            request.setAttribute("checkEmpty", true);
        }

        request.setAttribute("name", user.getNameUser());
        request.setAttribute("login", user.getLogin());
        request.setAttribute("User", user);
        session.setAttribute("User", user);
        getServletContext().getRequestDispatcher("/result.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("checkEmpty", true);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("User");
        request.setAttribute("name", user.getNameUser());
        request.setAttribute("login", user.getLogin());
        request.setAttribute("User", user);
        getServletContext().getRequestDispatcher("/result.jsp").forward(request, response);
    }
}
