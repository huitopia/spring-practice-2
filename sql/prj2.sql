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

# 컬럼 타입 변경
ALTER TABLE member
    MODIFY password VARCHAR(200);

DESC member;

SELECT *
FROM member;

CREATE TABLE authority
(
    id        INT PRIMARY KEY AUTO_INCREMENT,
    name      VARCHAR(20) DEFAULT ('member'),
    member_id INT NOT NULL REFERENCES member (id)
);

DESC authority;

SELECT *
FROM authority;

CREATE TABLE board
(
    id            INT PRIMARY KEY AUTO_INCREMENT,
    title         VARCHAR(20)   NOT NULL,
    content       VARCHAR(1000) NOT NULL,
    inserted_date DATETIME      NOT NULL DEFAULT NOW(),
    member_id     INT           NOT NULL REFERENCES member (id)
);

DESC board;

INSERT INTO board (title, content, member_id)
VALUES ('title1', 'desc1', 2),
       ('title2', 'desc2', 2);

SELECT *
FROM board;

CREATE TABLE comment
(
    id            INT PRIMARY KEY AUTO_INCREMENT,
    comment       VARCHAR(50) NOT NULL,
    inserted_date DATETIME    NOT NULL DEFAULT NOW(),
    member_id     INT         NOT NULL REFERENCES member (id),
    board_id      INT         NOT NULL REFERENCES board (id)
);

DESC comment;

SELECT b.id, b.title, b.content, m.nick_name, b.inserted_date, b.member_id
FROM board b
         JOIN member m
              ON b.member_id = m.id
ORDER BY b.id DESC