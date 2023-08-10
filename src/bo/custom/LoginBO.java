package bo.custom;

public interface LoginBO {
    public boolean checkPassword(String username, String password);
    public String getUserFullName(String username);
}
