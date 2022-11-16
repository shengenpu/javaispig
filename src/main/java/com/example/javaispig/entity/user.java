package com.example.javaispig.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class user {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    private String userid;
    private String password;
    @Column(length = 10)
    private String sex;
    private int age;
    private String email;
    private String phone;
}
