package pl.myapplication.DAO;

import pl.myapplication.model.User;

public interface UserDAO {
    
    public boolean create(User user);
    public User read(String pesel);
    public boolean update (User user);
    public boolean delete (User user);
    
}
