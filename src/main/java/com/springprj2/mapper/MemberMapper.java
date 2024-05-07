package com.springprj2.mapper;

import com.springprj2.domain.Member;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MemberMapper {
    @Insert("""
            INSERT INTO member
            (email, password, nick_name)
            VALUES (#{email}, #{password}, #{nick_name})
            """)
    int insertMember(Member member);

    @Select("""
            SELECT email
            FROM member
            WHERE email = #{email}
            """)
    String selectByEmail(String email);
}
