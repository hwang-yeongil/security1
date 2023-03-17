package com.example.securiy1.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.securiy1.CustomException;
import com.example.securiy1.ErrorCode;
import com.example.securiy1.domain.Board;
import com.example.securiy1.domain.BoardRequestDto;
import com.example.securiy1.domain.BoardResponseDto;
import com.example.securiy1.repository.BoardRepository;

import groovyjarjarantlr4.v4.parse.ANTLRParser.finallyClause_return;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {
	
	private final BoardRepository boardRepository;
	
//	게시글 생성
	@Transactional
	public Long save(final BoardRequestDto params) {
		
		Board entity = boardRepository.save(params.toEntity());
		return entity.getId();
	}
//	게시글 조회
	public List<BoardResponseDto> findAll(){
		Sort sort =Sort.by(Direction.DESC, "id"	, "insertTime");
		List<Board> list =boardRepository.findAll(sort);
		return list.stream().map(BoardResponseDto::new).collect(Collectors.toList());
	}
	
//	게시글 리스트 조회 ( 삭제여부
	public List<BoardResponseDto> findAllByDeleteYn(final char deleteYn){
		Sort sort = Sort.by(Direction.DESC, "id", "insertTime");
		List<Board> list = boardRepository.findAllByDeleteYn(deleteYn, sort);
		return list.stream().map(BoardResponseDto::new).collect(Collectors.toList());
	}
	
//	게시글 수정
	@Transactional
	public Long update(final Long id, final BoardRequestDto params) {
		Board entity = boardRepository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.POSTS_NOT_FOUND));

//	    if (entity == null) {
//	        throw new CustomException(ErrorCode.POSTS_NOT_FOUND);
//	    }

		entity.update(params.getTitle(),params.getContent()	, params.getWriter());
		
		return id;
	}
	
	@Transactional
	public Long delete(final Long id) {
		Board entity = boardRepository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.POSTS_NOT_FOUND));
		entity.delete();
		return id;
	}
	
	 /**
     * 게시글 상세정보 조회
     */
    @Transactional
    public BoardResponseDto findById(final Long id) {

        Board entity = boardRepository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.POSTS_NOT_FOUND));
//        entity.increaseHits();
        return new BoardResponseDto(entity);
    }
}
