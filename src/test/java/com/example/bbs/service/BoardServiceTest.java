package com.example.bbs.service;

import com.example.bbs.domain.Board;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardServiceTest {

    @Autowired
    BoardService boardService;

    @Test
    void getBoardList() {
        // given
        Board board1 = new Board();
        board1.setCreatedBy("writer_1");
        board1.setCreatedTime(LocalTime.now());
        board1.setTitle("test title 1");
        board1.setContent("test content 1");
        Board board2 = new Board();
        board2.setCreatedBy("writer_2");
        board2.setCreatedTime(LocalTime.now());
        board2.setTitle("test title 2");
        board2.setContent("test content 2");

        // when
        boardService.saveBoard(board1);
        boardService.saveBoard(board2);

        // then
        List<Board> list = boardService.getBoardList();
        Assertions.assertThat(2).isEqualTo(list.size());
    }
}