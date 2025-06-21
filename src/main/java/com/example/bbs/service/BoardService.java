package com.example.bbs.service;

import com.example.bbs.domain.Board;
import com.example.bbs.repository.BoardRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    // paging type 1
    public Page<Board> getBoardList1(PageRequest pageRequest) {
        return repository.findAll(pageRequest);
    }

    // paging type 2
    public Slice<Board> getBoardList2(PageRequest pageRequest) {
        return repository.findAll(pageRequest);
    }

    // get board

    // add process
    public void saveBoard(Board board) {
        repository.save(board);
    }

    public void bulkBoard() {
        List<Board> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Board board = new Board();
            board.setCreatedBy("writer");
            board.setTitle("bulk title - " + i);
            board.setContent("bulk content - " + i);
            list.add(board);
        }
        repository.saveAll(list);
    }

    // edit process


}
