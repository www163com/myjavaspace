package com.billyang.vo;

/**
 * @author yangcan14944
 * @version V1.0
 * @Project myshiro
 * @Package com.billyang.vo
 * @Description: ${todo}
 * @date 2018.12.27
 * @time 10:15
 */
public class User {
    private String username;
    private String password;
    private boolean rememberMe;
    public String getUsername() {
        return username;
    }

    public boolean getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
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
}
