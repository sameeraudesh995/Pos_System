package dao.custom;

import dao.SuperDAO;

public interface LoginDAO extends SuperDAO {
    public String getPasswordByUsername(String username);
    public String getUserFullName(String username);
}
