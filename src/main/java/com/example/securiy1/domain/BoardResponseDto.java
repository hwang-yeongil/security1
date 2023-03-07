package com.example.securiy1.domain;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class BoardResponseDto {
	private Long id;
	private String title;
	private String content;
	private String writer; // user.id
	private LocalDateTime insertTime = LocalDateTime.now();
	private LocalDateTime updateTime;
	
	public BoardResponseDto(Board entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
        this.content = entity.getContent();
        this.writer = entity.getWriter();
        this.insertTime = entity.getInsertTime();
        this.updateTime = entity.getUpdateTime();
	}
}
