package com.bookgroovy.controllers

import com.bookgroovy.models.Book
import com.bookgroovy.models.BookRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

/**
 * Created by bconner on 6/4/17.
 */
@CrossOrigin(origins = "http://localhost:4200", maxAge=86400L)
@RestController
class BookController {
    @Autowired BookRepository bookRepository

    @RequestMapping(value = "/books/search", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    def searchByTitle(@RequestParam(value = "title") String title){
        println "Searching for ${title}"
        bookRepository.findAllByTitleStartingWith(title)
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    def getBook(@PathVariable Long id){
        bookRepository.findById(id)
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    def getBooks(){
        bookRepository.findAll()
    }

    @RequestMapping(value = "/book", method = RequestMethod.POST, consumes =  "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    void createBook(@RequestBody Book book){
        bookRepository.save(book)
    }
}
