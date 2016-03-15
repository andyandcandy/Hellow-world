package com.java1234.model;


public class User {
    private int id;//±‡∫≈
    private String userName;//”√ªß√˚
    private String passWord;//√‹¬Î
    
    public User() {
        super();
        // TODO Auto-generated constructor stub
    }

    public User(String userName, String passWord) {
        super();
        this.userName = userName;
        this.passWord = passWord;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public String getpassWord() {
        return passWord;
    }
    
    public void setpassWord(String passWord) {
        this.passWord = passWord;
    }
    
    
}
