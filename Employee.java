package com.company;

public class Employee extends PErson{
    private int salary;
    private String status;


    public Employee(String name, int salary, String status) {
        super(name);
        this.salary = salary;
        this.status = status;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void work(){
        System.out.println("I am working");
    }
}
