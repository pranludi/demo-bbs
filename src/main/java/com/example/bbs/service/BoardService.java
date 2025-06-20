package com.example.bbs.service;

import com.example.bbs.domain.Board;
import com.example.bbs.repository.BoardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    private final BoardRepository repository;

    public BoardService(BoardRepository repository) {
        this.repository = repository;
    }

    // list
    public List<Board> getBoardList() {
        return repository.findAll();
    }

    // get board

    // add process
    public void saveBoard(Board board) {
        repository.save(board);
    }

    // edit process



}
