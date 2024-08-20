package com.example.potato.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @ManyToOne
    @JoinColumn(name = "userGroupId")
    private UserGroup userGroup;

    @ManyToOne
    @JoinColumn(name = "positionId")
    private Position position;

    @OneToMany(mappedBy = "user")
    private  List<UserLog> userLogs;

    private String name;
    private String email;
    private String phone;
    private String password;
    private String regDate; // 등록일
    private String state;
    private boolean isDeleted;
    private int pwdFailCnt;
}
