package com.bookgroovy.controllers

import com.bookgroovy.models.Book
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@CrossOrigin(origins = "http://localhost:4200", maxAge=86400L)
@RestController
class MainController {
	@RequestMapping("/")
	def home(){
		"Spring Boot Author and Book API"
	}

}
