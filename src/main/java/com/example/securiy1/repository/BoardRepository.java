package com.example.securiy1.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.securiy1.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long>{
	// 게시글 리스트 조회 - ( 삭제 여부 기준 )
	
	List<Board> findAllByDeleteYn(final char deleteYn, final Sort sort);
}
