package com.example.securiy1.domain;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import com.example.securiy1.model.User;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String content;
	private String writer;
	@CreationTimestamp
	private Timestamp insertTime;
	private Timestamp updateTime;
	
	@Builder
	public Board(String title, String content, String writer, Timestamp insertTime, Timestamp updateTime) {
		
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.insertTime = insertTime;
		this.updateTime = updateTime;
	}
}
