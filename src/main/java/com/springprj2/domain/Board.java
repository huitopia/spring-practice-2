package com.springprj2.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Board {
    private Integer id;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime insertedDate;
    private Integer memberId;
}
