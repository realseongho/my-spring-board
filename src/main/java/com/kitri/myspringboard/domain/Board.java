package com.kitri.myspringboard.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Board {
    private Long id = 0L;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime createdAt;
    private String username;
}
