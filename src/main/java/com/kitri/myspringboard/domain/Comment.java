package com.kitri.myspringboard.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Comment {
    private Long id;
    private String content;
    private Long user_id;
    private Long board_id;
    private LocalDateTime createdAt;
}
