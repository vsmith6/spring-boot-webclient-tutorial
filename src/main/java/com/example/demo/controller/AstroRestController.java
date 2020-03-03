package com.example.demo.controller;

import com.example.demo.entities.AstroResponse;
import com.example.demo.services.AstroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


	@RestController
	public class AstroRestController {

	    private final AstroService service;

	    @Autowired
	    public AstroRestController(AstroService service) {
	        this.service = service;
	    }

	    @GetMapping("/astronauts")
	    public String getAstro() {
	        return "There are " + service.getAstronauts().getNumber()
	                + " people in space";
	    }

	}
