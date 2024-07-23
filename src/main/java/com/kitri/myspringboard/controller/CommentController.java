package com.kitri.myspringboard.controller;

import com.kitri.myspringboard.domain.Board;
import com.kitri.myspringboard.domain.Comment;
import com.kitri.myspringboard.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommentController {
    @Autowired
    CommentService commentService;

    @PostMapping("/board/{id}/submit")
    public String insert(@PathVariable long id,
                         @RequestParam("content") String content){
        Comment comment = new Comment();
        long currentUserId = commentService.findIdByUsername(SecurityContextHolder.getContext().getAuthentication().getName());

        comment.setContent(content);
        comment.setUser_id(currentUserId);
        comment.setBoard_id(id);
        commentService.insertComment(comment);
        return "redirect:/board/{id}";
    }
}
