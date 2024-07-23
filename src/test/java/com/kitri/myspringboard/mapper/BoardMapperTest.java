package com.kitri.myspringboard.mapper;

import com.kitri.myspringboard.domain.Board;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
class BoardMapperTest {

    @Autowired
    BoardMapper boardMapper;

    @Test
    void findAll() {
        List<Board> boards = boardMapper.findAll();
        assertThat(boards).hasSize(5);
    }

    @Test
    void findById() {
        Board board = boardMapper.findById(28L);
        assertThat(board).isNotNull();
//        assertThat(board.getTitle()).isEqualTo("test title");
//        assertThat(board.getContent()).isEqualTo("test content");
    }

    @Test
    void insert() {
        Board board = new Board();
        board.setTitle("인서트 테스트");
        board.setContent("인서트 테스트 콘텐츠");
        board.setWriter("관리자");
//        System.out.println(board.getId());
        boardMapper.insert(board);
        System.out.println(board.getId());
    }

    @Test
    void update() {
        Board board = new Board();
        board.setTitle("금요일");
        board.setContent("좋아");
        board.setWriter("최준서");
        boardMapper.insert(board);

        board.setTitle("aaaa");
        board.setContent("BBBB");
        board.setWriter("TEST");
        boardMapper.update(board);

        Board isUpdated = boardMapper.findById(board.getId());
        assertThat(isUpdated).isNotNull();
        assertThat(isUpdated.getTitle()).isEqualTo("aaaa");
        assertThat(isUpdated.getContent()).isEqualTo("BBBB");
        assertThat(isUpdated.getWriter()).isEqualTo("TEST");
    }

    @Test
    void delete(long id) {
        Board board = new Board();
        board.setTitle("금요일");
        board.setContent("좋아");
        board.setWriter("최준서");
        boardMapper.insert(board);
        boardMapper.delete((long)(board.getId()));

        Board deleted = boardMapper.findById(board.getId());
        assertThat(deleted).isNull();
    }
}