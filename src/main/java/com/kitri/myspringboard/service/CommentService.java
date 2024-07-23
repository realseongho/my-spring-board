package com.kitri.myspringboard.service;

import com.kitri.myspringboard.domain.Board;
import com.kitri.myspringboard.domain.Comment;
import com.kitri.myspringboard.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentMapper commentMapper;

    public List<Board> findCommentById(long board_id){
        return commentMapper.findCommentById(board_id);
    }

    public long findIdByUsername(String username){
        return commentMapper.findIdByUsername(username);
    }

    public void insertComment(Comment comment){
        commentMapper.insertComment(comment);
    }
}
