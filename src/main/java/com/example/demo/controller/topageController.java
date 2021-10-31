package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/topage")
public class topageController {
	
	@RequestMapping("{/EscapeME_Home}")
	public String topage(@RequestParam String page) {
		return page;
	}
}
