package com.javaCourse.crud.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@ToString
@Table(name = "student")
public class Student {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reg_no;
    @Column(name = "FirstNAme")
    private String fname;
    @Column(name = "LastName")
    private String lname;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Reg_nbr",referencedColumnName = "reg_no")
    List<Mark> mark = new ArrayList<>();

    public Student() {
    }

    public Student(int reg_no, String fname, String lname, List<Mark> mark) {
        this.reg_no = reg_no;
        this.fname = fname;
        this.lname = lname;
        this.mark = mark;
    }

    public int getReg_no() {
        return reg_no;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public List<Mark> getMark() {
        return mark;
    }

    public void setReg_no(int reg_no) {
        this.reg_no = reg_no;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setMark(List<Mark> mark) {
        this.mark = mark;
    }

}
