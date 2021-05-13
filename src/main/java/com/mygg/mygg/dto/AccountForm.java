package com.mygg.mygg.dto;

import com.mygg.mygg.domain.Account;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class AccountForm {

    private Long id;
    private String email;
    private String password;
    private String name;
    private String nickname;
    private String phone_number;
    private int gender;
    private int age;
    private String location;
    private String photo;
    private int authority;
    private Timestamp join_date;

    @Builder
    public AccountForm(Long id, String email, String password, String name, String nickname, String phone_number, int gender, int age, String location, String photo, int authority, Timestamp join_date) {
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

    public Account toEntity() {
        return Account.builder()
                .id(id)
                .email(email)
                .password(new BCryptPasswordEncoder().encode(password))
                .name(name)
                .nickname(nickname)
                .phone_number(phone_number)
                .gender(gender)
                .age(age)
                .location(location)
                .photo(photo)
                .authority(authority)
                .join_date(join_date)
                .build();
    }

}