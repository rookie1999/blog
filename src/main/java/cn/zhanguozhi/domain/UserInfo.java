package cn.zhanguozhi.domain;



public class UserInfo {
    private int id;
    private String username;
    private String password;
    private String email;
    private String lastLoginTime;
    //private StatusCode status; //状态码

    public UserInfo() {
    }

    public UserInfo(int id, String username, String password, String email, String date) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.lastLoginTime = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
}
