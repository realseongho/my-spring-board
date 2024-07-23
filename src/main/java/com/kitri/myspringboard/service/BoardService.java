package com.kitri.myspringboard.service;

import com.kitri.myspringboard.domain.Board;
import com.kitri.myspringboard.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    BoardMapper boardMapper;

    public int count() {
        return boardMapper.count();
    }

    public List<Board> findAll() {
        return boardMapper.findAll();
    }

    public List<Board> findByContentLike(String title){
        return boardMapper.findByContentLike(title);
    }

    public Board findById(long id) {
        return boardMapper.findById(id);
    }

    public void insert(Board board) {
        boardMapper.insert(board);
    }

    public void update(Board board) {
        boardMapper.update(board);
    }

    public void delete(long id) {
        boardMapper.delete(id);
    }
}
