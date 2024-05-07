CREATE DATABASE prj2;

USE prj2;

CREATE TABLE member
(
    id            INT PRIMARY KEY AUTO_INCREMENT,
    email         VARCHAR(20) NOT NULL UNIQUE,
    password      VARCHAR(20) NOT NULL,
    nick_name     VARCHAR(10) NOT NULL UNIQUE,
    inserted_date DATETIME    NOT NULL DEFAULT NOW()
);

DESC member;

CREATE TABLE authority
(
    id        INT PRIMARY KEY AUTO_INCREMENT,
    name      VARCHAR(20) NOT NULL DEFAULT ('member'),
    member_id INT         NOT NULL REFERENCES member (id)
);

desc authority;

CREATE TABLE board
(
    id            INT PRIMARY KEY AUTO_INCREMENT,
    title         VARCHAR(20)   NOT NULL,
    content       VARCHAR(1000) NOT NULL,
    inserted_date DATETIME      NOT NULL DEFAULT NOW(),
    member_id     INT           NOT NULL REFERENCES member (id)
);

DESC board;

CREATE TABLE comment
(
    id            INT PRIMARY KEY AUTO_INCREMENT,
    comment       VARCHAR(50) NOT NULL,
    inserted_date DATETIME    NOT NULL DEFAULT NOW(),
    member_id     INT         NOT NULL REFERENCES member (id),
    board_id      INT         NOT NULL REFERENCES board (id)
);

DESC comment;