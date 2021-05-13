package com.mygg.mygg.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class CreateUserForm {

    private Long id; // 고유 회원 번호
    private String email;
    private String password;
    private String name;
    private String nickname;
    private String phone_number;
    private int gender; // 0: 남자, 1: 여자
    private int age;
    private String location;
    private String photo;
    private int authority; // 0: 일반회원, 1: 관리자, 2: 활동중지회원
    private Timestamp join_date;

}