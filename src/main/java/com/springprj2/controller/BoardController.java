package com.springprj2.controller;

import com.springprj2.domain.Board;
import com.springprj2.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {
    private final BoardService service;

    @GetMapping("/")
    public String BoardList(Model model) {
        List<Board> boards = service.selectBoardList();
        boards.forEach(System.out::println);
        model.addAttribute("boardList", boards);
        return "board/home";
    }

}
