package com.example.demo;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@Autowired
	Repo dao;

	@PostMapping("/details")
	public phone name(@RequestBody phone details) throws IOException {
		
		System.out.println("entered");
		return dao.AddExcel(details);
		
		
	}
		
	}