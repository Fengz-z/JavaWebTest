package com.sirifeng.demo;

/**
 * @author Sirifeng
 */
public class Student {
    private String name;
    private String sno;
    public Student(String name , String sno){
        this.name = name;
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }
}
