package com.springprj2.mapper;

import com.springprj2.domain.Member;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface MemberMapper {
    @Insert("""
            INSERT INTO member
            (email, password, nick_name)
            VALUES (#{email}, #{password}, #{nick_name})
            """)
    int insertMember(Member member);

    @Select("""
            SELECT *
            FROM member
            WHERE email = #{email}
            """)
    Member selectByEmail(String email);

    @Select("""
            SELECT name
            FROM authority
            WHERE member_id = #{id}
            """)
    List<String> selectAuthorityByMemberId(Integer id);

    @Select("""
            SELECT *
            FROM member
            ORDER BY id DESC 
            """)
    List<Member> selectMember();

    @Select("""
            SELECT *
            FROM member
            WHERE id = #{id}
            """)
    Member selectById(Integer id);

    @Update("""
            UPDATE member
            SET password=#{password}
            WHERE id=#{id}
            """)
    int modifyMemberById(Member member);
}
