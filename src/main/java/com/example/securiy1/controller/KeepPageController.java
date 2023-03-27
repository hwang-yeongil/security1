package com.example.securiy1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.securiy1.domain.Board;
import com.example.securiy1.domain.BoardResponseDto;
import com.example.securiy1.service.BoardService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/keep")
@RequiredArgsConstructor
public class KeepPageController {
	
	private final BoardService boardService;
	
	@GetMapping("/list")
	public String openKeepList() {
		return "keep/list";      
	}
	@GetMapping("/view/{id}")
    public String openBoardView(@PathVariable final Long id, Model model) {
        model.addAttribute("id", id);
        return "keep/view";
    }
    @GetMapping("/write")
    public String openBoardWrite(@RequestParam(required = false) final Long id, Model model) {
        model.addAttribute("id", id);
        return "keep/write";
    }
	
}
