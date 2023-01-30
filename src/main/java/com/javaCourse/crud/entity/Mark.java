package com.javaCourse.crud.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
@Table(name = "mark")
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "mark")
    private int mrk;
    @Column(name = "CourseCode")
    private String code;

    public Mark() {
    }

    public Mark(int mrk, String code) {
        this.mrk = mrk;
        this.code = code;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMrk(int mrk) {
        this.mrk = mrk;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public int getMrk() {
        return mrk;
    }

    public String getCode() {
        return code;
    }
}
