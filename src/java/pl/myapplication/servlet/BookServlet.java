package pl.myapplication.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pl.myapplication.DAO.BookDAO;
import pl.myapplication.DAO.DAOFactory;
import pl.myapplication.model.Book;

@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String isbn = request.getParameter("isbn");
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String option = request.getParameter("option");
        
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL_DAO);
        BookDAO dao = factory.getBookDAO();
        Book book = null;
        String operation = null;
        boolean result = false;
        
        if ("search".equals(option)){
            book = dao.read(isbn);
            result = book!=null;
            operation = "search";
        } else if ("add".equals(option)){
            book = new Book(isbn, title, description);
            result = dao.create(book);
            operation = "add";
        } else if ("update".equals(option)){
            book = new Book(isbn,title, description);
            result = dao.update(book);
            operation = "update";
        } else if ("delete".equals(option)){
            book = new Book(isbn, title, description);
            result = dao.delete(book);
            operation = "delete";
        }
        
        if (book != null && result){
            request.setAttribute("option", operation);
            request.setAttribute("book", book);
            request.getRequestDispatcher("result.jsp").forward(request, response); 
        } else {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

}
