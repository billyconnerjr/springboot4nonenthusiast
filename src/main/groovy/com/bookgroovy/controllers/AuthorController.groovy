package com.bookgroovy.controllers

import com.bookgroovy.models.Author
import com.bookgroovy.models.AuthorRepository

/**
 * Created by bconner on 6/4/17.
 */

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@CrossOrigin(origins = "http://localhost:4200", maxAge=86400L)
@RestController
class AuthorController {
    @Autowired AuthorRepository authorRepository

    @RequestMapping(value = "/author/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    def getAuthor(@PathVariable Long id){
        authorRepository.findById(id)
    }

    @RequestMapping(value = "/authors", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    def getAuthors() {
        authorRepository.findAll() //free method
    }

    @RequestMapping(value = "/author", method = RequestMethod.POST, consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    void createAuthor(@RequestBody Author author){
        authorRepository.save(author)
    }


}
