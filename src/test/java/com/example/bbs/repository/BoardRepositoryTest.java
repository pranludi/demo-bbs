package com.example.bbs.repository;

import com.example.bbs.domain.Board;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardRepositoryTest {

    @Autowired
    BoardRepository boardRepository;

    @Test
    void save() {
        // given
        Board board = new Board();
        board.setCreatedBy("test_user01");
        board.setCreatedTime(LocalTime.now());
        board.setTitle("test title");
        board.setContent("test content");

        // when
        Board savedBoard = boardRepository.save(board);

        // then
        Assertions.assertThat(savedBoard.getTitle()).isEqualTo(board.getTitle());
    }


}