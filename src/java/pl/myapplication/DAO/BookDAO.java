
package pl.myapplication.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pl.myapplication.model.Book;
import pl.myapplication.util.ConnectionProvider;

public interface BookDAO {

    public boolean create(Book book);
    public Book read(String isbn);
    public boolean update (Book book);
    public boolean delete (Book book);
}
