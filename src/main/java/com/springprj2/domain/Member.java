package com.springprj2.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Member {
    private Integer id;
    private String email;
    private String password;
    private String nick_name;
    private LocalDateTime inserted_date;
}