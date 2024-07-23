package com.kitri.myspringboard.mapper;

import com.kitri.myspringboard.domain.Board;
import com.kitri.myspringboard.domain.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentMapper {
    @Select("SELECT c.id,content,username FROM comment c JOIN users u ON c.user_id = u.id WHERE c.board_id = #{board_id}")
    List<Board> findCommentById(long board_id);

    @Select("SELECT id FROM users WHERE username = #{username}")
    long findIdByUsername(String username);

    @Insert("INSERT INTO comment(content, user_id, board_id) " +
            "VALUES (#{content}, #{user_id}, #{board_id})")
    void insertComment(Comment comment);
}
