package dao.custom;

public interface LoginDAO {
    public String getPasswordByUsername(String username);
    public String getUserFullName(String username);
}
