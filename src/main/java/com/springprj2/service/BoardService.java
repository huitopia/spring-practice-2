package com.springprj2.service;

import com.springprj2.domain.Board;
import com.springprj2.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
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
}
