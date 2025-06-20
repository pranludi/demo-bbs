package com.example.bbs.controller;

import com.example.bbs.domain.Board;
import com.example.bbs.service.BoardService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/list")
    public String boardList(Model model) {
        List<Board> list = boardService.getBoardList();
        model.addAttribute("list", list);
        return "boardList";
    }

    @GetMapping("/add/form")
    public String addForm() {
        return "boardAdd";
    }

    @PostMapping("/add/form")
    public String addForm(@Valid BoardForm form) {
        Board newBoard = new Board();
        newBoard.setCreatedBy(form.getCreatedBy());
        newBoard.setTitle(form.getTitle());
        newBoard.setContent(form.getContent());
        boardService.saveBoard(newBoard);
        return "redirect:/list";
    }

    // todo bulk insert
    @GetMapping("/bulk")
    public String bulk() {
        boardService.bulkBoard();
        return "redirect:/list";
    }


}
