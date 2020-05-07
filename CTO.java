package com.company;

public class CTO extends Employee{
    private int motion_designers;

    public CTO(String name, int salary, String status, int motion_designers){
        super(name, salary, status);
        this.motion_designers = motion_designers;
    }

    public int getMotion_designers() {
        return motion_designers;
    }

    public void setMotion_designers(int motion_designers) {
        this.motion_designers = motion_designers;
    }
}
