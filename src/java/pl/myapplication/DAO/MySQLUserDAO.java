package pl.myapplication.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pl.myapplication.model.Book;
import pl.myapplication.model.User;
import pl.myapplication.util.ConnectionProvider;

public class MySQLUserDAO implements UserDAO{
    
    private final static String CREATE = "INSERT INTO user (pesel, firstname, lastname) VALUES (?,?,?);";
    private final static String READ = "SELECT pesel, firstname, lastname FROM user WHERE pesel=?;";
    private final static String UPDATE = "UPDATE user SET pesel=?, firstname=?, lastname=? WHERE pesel=?;";
    private final static String DELETE = "DELETE FROM user WHERE pesel =?;";

    @Override
    public boolean create(User user){
        Connection conn = null;
        PreparedStatement prepStmt = null;
        boolean result = false;
        
        try {
            conn = ConnectionProvider.getConnection();
            prepStmt = conn.prepareStatement(CREATE);
            prepStmt.setString(1, user.getPesel());
            prepStmt.setString(2, user.getFirstName());
            prepStmt.setString(3, user.getLastName());
            int rowsAffected = prepStmt.executeUpdate();
            if (rowsAffected>0){
                result=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            releaseResource(prepStmt, null, conn);
        }
        
        return result;
    }
    
    @Override
    public User read(String pesel){
        Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet resultSet = null;
        User resultUser = null;
        
        try {
            conn = ConnectionProvider.getConnection();
            prepStmt = conn.prepareStatement(READ);
            prepStmt.setString(1, pesel);
            resultSet = prepStmt.executeQuery();
                if(resultSet.next()){
                    resultUser = new User();
                    resultUser.setPesel(resultSet.getString("pesel"));
                    resultUser.setFirstName(resultSet.getString("firstname"));
                    resultUser.setLastName(resultSet.getString("lastname"));
                }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            releaseResource(prepStmt, resultSet, conn);
        }
        
        return resultUser;
    }
    
    @Override
    public boolean update (User user){
        Connection conn = null;
        PreparedStatement prepStmt = null;
        boolean result = false;
        
        try {
            conn = ConnectionProvider.getConnection();
            prepStmt = conn.prepareStatement(UPDATE);
            prepStmt.setString(1, user.getPesel());
            prepStmt.setString(2, user.getFirstName());
            prepStmt.setString(3, user.getLastName());
            prepStmt.setString(4, user.getPesel());
            
            int rowsAffected = prepStmt.executeUpdate();
            if(rowsAffected > 0){
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            releaseResource(prepStmt, null, conn);
        }
        
        return result;
    }
    
    @Override
    public boolean delete (User user){
        
        Connection conn = null;
        PreparedStatement prepStmt = null;
        boolean result = false;
        
        try {
            conn = ConnectionProvider.getConnection();
            prepStmt = conn.prepareStatement(DELETE);
            prepStmt.setString(1, user.getPesel());
            int rowsAffected = prepStmt.executeUpdate();
            if (rowsAffected>0){
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            releaseResource(prepStmt, null, conn);
        }
        
        return result;
    }
    public void releaseResource(PreparedStatement prepStmt, ResultSet res, Connection conn){
        try {
            if (prepStmt != null && !prepStmt.isClosed()){
                prepStmt.close();
            }
            if (res != null && !res.isClosed()){
                res.close();
            }
            if (conn != null && !conn.isClosed()){
                conn.close();
            }
            
        } catch (SQLException e) {
        }
    }
    
}
