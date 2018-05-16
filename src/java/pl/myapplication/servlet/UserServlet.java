package pl.myapplication.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pl.myapplication.DAO.DAOFactory;
import pl.myapplication.DAO.MySQLDAOFactory;
import pl.myapplication.DAO.MySQLUserDAO;
import pl.myapplication.DAO.UserDAO;
import pl.myapplication.model.User;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        String pesel = request.getParameter("pesel");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String option = request.getParameter("option");
        
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL_DAO);
        UserDAO dao = factory.getUserDAO();
        User user = null;
        String operation = null;
        boolean result = false;
        
        if ("add".equals(option)){
            user = new User(pesel, firstname, lastname);
            result = dao.create(user);
            operation = "add";
        } else if ("update".equals(option)){
            user = new User(pesel, firstname, lastname);
            result = dao.update(user);
            operation = "update";
        } else if ("search".equals(option)){
            user = dao.read(user.getPesel());
            result = user != null;
            operation = "search";
        } else if ("delete".equals(option)){
            user =  new User(pesel, firstname, lastname);
            result = dao.delete(user);
            operation ="delete";
        }    
        
        if (user != null && result){
            request.setAttribute("user", user);
            request.setAttribute("option", operation);
            request.getRequestDispatcher("result.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

}
