package com.example.securiy1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/keep")
public class KeepPageController {
	
	@GetMapping("/list")
	public String openKeepList() {
		return "keep/list";
	}

}
