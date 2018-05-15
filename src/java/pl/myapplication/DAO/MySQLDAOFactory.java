package pl.myapplication.DAO;

public class MySQLDAOFactory extends DAOFactory{

    public BookDAO getBookDAO() {
        return new MySQLBookDAO();
    }

    public UserDAO getUserDAO() {
        return new MySQLUserDAO();
    }

}
