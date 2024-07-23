package com.kitri.myspringboard.mapper;

import com.kitri.myspringboard.domain.Board;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardMapper {
    // 페이지네이션
    @Select("SELECT COUNT(*) FROM board")
    int count();

    @Select("select * from board")
    List<Board> findAll();

    @Select("select * from board where id = #{id}")
    Board findById(long id);

    // 검색 기능
    @Select("SELECT * FROM board WHERE title LIKE CONCAT('%', #{title}, '%')")
    List<Board> findByContentLike(String title);

    @Insert("insert into board(title, content, writer) values (#{title}, #{content}, #{writer})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Board board);

    @Update("update board set title = #{title}, content = #{content}, writer = #{writer} where id = #{id}")
    void update(Board board);

    @Delete("delete from board where id = #{id}")
    void delete(long id);
}
