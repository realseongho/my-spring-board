package com.kitri.myspringboard.controller;

import com.kitri.myspringboard.domain.Board;
import com.kitri.myspringboard.service.BoardService;
import com.kitri.myspringboard.service.CommentService;
import com.kitri.myspringboard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board")
public class boardController {

    @Autowired
    BoardService boardService;

    @Autowired
    CommentService commentService;

    // 보드 리스트 불러오기 (메인화면)
    @GetMapping("/list")
    public String list(Model model){
        int totalPages = 1;
        int total = boardService.count();
        if(total>3 && total%3==0) totalPages = total/3;
        else if(total>3 && (total%3==1||total%3==2)) totalPages = total/3 + 1;

        model.addAttribute("boards", boardService.findAll());
        model.addAttribute("totalPages", totalPages);
        return "board/list";
    }

    // 특정 보드 리스트 불러오기 (메인화면)
    @PostMapping("/list/boardSearch")
    public String boardSearch(@RequestParam("boardSearch") String boardSearch, Model model){
        model.addAttribute("boards", boardService.findByContentLike(boardSearch));
        return "board/list";
    }

    // 보드 상세화면 + 댓글
    @GetMapping("/{id}")
    public String content(@PathVariable long id, Model model){
        model.addAttribute("board", boardService.findById(id));
        model.addAttribute("comments", commentService.findCommentById(id));
        return "board/id";
    }

    // 보드 등록, 수정
    @GetMapping("/insert")
    public String insertButton(Model model){
        model.addAttribute("writer",
                SecurityContextHolder.getContext().getAuthentication().getName());
        return "board/insert";
    }
    @PostMapping("/submit")
    public String insert(@RequestParam("title") String title,
                         @RequestParam("content") String content,
                         @RequestParam("writer") String writer,
                         @RequestParam("id") long id){
        Board board = new Board();
        board.setTitle(title);
        board.setContent(content);
        board.setWriter(writer);
        if(id!=0L) {
            board.setId(id);
            boardService.update(board);
        }
        else boardService.insert(board);

        return "redirect:/board/list";
    }

    // 보드 수정 링크
    @GetMapping("/{id}/edit")
    public String editButton(@PathVariable long id, Model model){
        model.addAttribute("board", boardService.findById(id));

        return "board/edit";
    }

    // 보드 삭제
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable long id, Model model){
        boardService.delete(id);

        return "redirect:/board/list";
    }
}
