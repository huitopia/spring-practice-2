package com.springprj2.mapper;

import com.springprj2.domain.Board;
import org.apache.ibatis.annotations.*;

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

    @Insert("""
            INSERT INTO board (title, content, member_id)
            VALUES (#{title}, #{content}, #{memberId})
            """)
    int insertBoardById(Board board);

    @Update("""
            UPDATE board
            SET title=#{title}, content=#{content}
            WHERE id=#{id} AND member_id=#{memberId}
            """)
    int updateBoardById(Board board);

    @Select("""
            SELECT b.id,
                    m.id member_id
            FROM board b
            JOIN member m ON b.member_id = m.id
            WHERE b.id = #{id}
            """)
    Board selectById(Integer id);

    @Delete("""
            DELETE FROM board WHERE id = #{id}
            """)
    int deleteBoardById(Integer id);
}
