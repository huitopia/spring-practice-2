package com.springprj2.mapper;

import com.springprj2.domain.Board;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BoardMapper {
    @Select("""
            SELECT b.id,
                    b.title,
                    m.nick_name writer,
                    b.inserted_date,
                    b.member_id
            FROM board b
            JOIN member m
            ON b.member_id = m.id
            ORDER BY b.id DESC
            """)
    List<Board> selectBoardList();

    @Select("""
            SELECT b.id,
                b.title,
                b.content,
                m.nick_name writer,
                b.inserted_date,
                b.member_id
            FROM board b
            JOIN member m ON b.member_id = m.id
            WHERE b.id = #{id}
            """)
    Board selectBoardById(String id);
}
