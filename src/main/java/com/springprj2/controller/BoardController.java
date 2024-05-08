package com.springprj2.controller;

import com.springprj2.domain.Board;
import com.springprj2.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {
    private final BoardService service;

    @GetMapping("/")
    public String boardList(Model model) {
        List<Board> boards = service.selectBoardList();
        model.addAttribute("boardList", boards);
        return "board/home";
    }

    @GetMapping("/board")
    public String boardView(String id, Model model) {
        model.addAttribute("board", service.selectBoardById(id));
        return "board/view";
    }

    @GetMapping("/add")
    public String addView() {
        return "board/add";
    }

    @PostMapping("/add")
    // Authentication : 현재 사용자 정보
    public String addBoard(Board board, Authentication authentication) {
        service.insertBoardById(board, authentication);
        return "redirect:/";
    }

    @GetMapping("/modify")
    public String modifyView(String id, Model model) {
        model.addAttribute("board", service.selectBoardById(id));
        return "board/modify";
    }

    @PostMapping("/modify")
    public String updateBoard(String id, Board board) {
        service.updateBoardById(board);
        return "redirect:/";
    }
}
