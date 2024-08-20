package com.example.potato.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class UserGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userGroupId;

    @Column(nullable = false, length = 100)
    private String userGroupName;

    @OneToMany(mappedBy = "userGroup")
    private List<User> users;

    private String register;
    private String regDatetime; //등록일
    private String lastModifier;
    private String lastModDatetime;
    private String state;
    private boolean isDeleted;
}
