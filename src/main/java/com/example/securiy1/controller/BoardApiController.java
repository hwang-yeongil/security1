package com.example.securiy1.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.securiy1.domain.BoardRequestDto;
import com.example.securiy1.domain.BoardResponseDto;
import com.example.securiy1.service.BoardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BoardApiController {
	
	private final BoardService boardService;
	
	@PostMapping("/boards")
	public Long save(@RequestBody final BoardRequestDto params) {
		return boardService.save(params);
	}
	
	@PatchMapping("/boards/{id}")
    public Long update(@PathVariable final Long id, @RequestBody final BoardRequestDto params) {
        return boardService.update(id, params);
    }
	
	@DeleteMapping("/boards/{id}")
	public Long delete(@PathVariable final Long id) {
		return boardService.delete(id);
	}
	
	@GetMapping("/boards")
	public List<BoardResponseDto> findAll(@RequestParam final char deleteYn){
		return boardService.findAllByDeleteYn(deleteYn);
	}

	@GetMapping("/boards/{id}")
	public BoardResponseDto findById(@PathVariable final Long id) { 
		return boardService.findById(id);
	}
}
