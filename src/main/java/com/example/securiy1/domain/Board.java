package com.example.securiy1.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String content;
	private String writer; // user.id
//	@CreationTimestamp
	private LocalDateTime insertTime; 
	private LocalDateTime updateTime;
	
	// insertTime = updateTime 수정시 updateTime 만 수정
	
	@Builder
	public Board(String title, String content, String writer, LocalDateTime insertTime, LocalDateTime updateTime) {
		
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.insertTime = insertTime;
		this.updateTime = updateTime;
	}
}
