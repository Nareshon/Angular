
package com.cognizant.truyum.model;

public class User {
    private String username;
    private String firstname;
    private String lastname;
    private String password;
    private String confirm_password;
    public User(String username, String firstname, String lastname, String password,
            String confirm_password) {
        super();
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.confirm_password = confirm_password;
    }
    public User() {
        super();
        // TODO Auto-generated constructor stub
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getConfirm_password() {
        return confirm_password;
    }
    public void setConfirm_password(String confirm_password) {
        this.confirm_password = confirm_password;
    }
    @Override
    public String toString() {
        return "User [username=" + username + ", firstname=" + firstname + ", lastname=" + lastname
                + ", password=" + password + ", confirm_password=" + confirm_password + "]";
    }
    
    

}







