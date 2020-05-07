package com.company;

public class PErson  extends User{
    private String name;

    public PErson(int id,String name, String username, String password){
        super(id,name,username,password);
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
