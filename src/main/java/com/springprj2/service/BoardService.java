package com.springprj2.service;

import com.springprj2.domain.Board;
import com.springprj2.domain.CustomUser;
import com.springprj2.domain.Member;
import com.springprj2.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class BoardService {
    private final BoardMapper mapper;

    public List<Board> selectBoardList() {
        return mapper.selectBoardList();
    }

    public Board selectBoardById(String id) {
        return mapper.selectBoardById(id);
    }

    public void insertBoardById(Board board, Authentication authentication) {
        // Authentication 객체에서 현재 사용자를 나타내는 principal 가져옴
        Object principal = authentication.getPrincipal();
        // 현재 사용자가 CustomUser 인지 확인
        if (principal instanceof CustomUser user) {
            // CustomUser 에서 회원 정보 가져옴
            Member member = user.getMember();
            // board 객체에 현재 사용자의 회원 ID 설정 => board 와 member 연결
            board.setMemberId(member.getId());
            // DB 삽입하러 mapper ㄱㄱ
            mapper.insertBoardById(board);
        }
    }


    public void updateBoardById(Board board) {
        mapper.updateBoardById(board);
    }
}
