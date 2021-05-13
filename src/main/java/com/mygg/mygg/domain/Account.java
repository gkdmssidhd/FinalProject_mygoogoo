package com.mygg.mygg.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Builder
    public Account(Long id, String email, String password, String name, String nickname, String phone_number, int gender, int age, String location, String photo, int authority, Timestamp join_date) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.phone_number = phone_number;
        this.gender = gender;
        this.age = age;
        this.location = location;
        this.photo = photo;
        this.authority = authority;
        this.join_date = join_date;
    }
}