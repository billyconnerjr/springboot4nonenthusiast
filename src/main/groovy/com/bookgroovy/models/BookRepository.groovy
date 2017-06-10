package com.bookgroovy.models

import org.springframework.data.repository.CrudRepository

/**
 * Created by bconner on 6/4/17.
 */
interface BookRepository extends CrudRepository<Book, Long>{
    List<Book> findById(Long id)

    List<Book> findAllByTitleStartingWith(String title)

    List<Book>findAllByAuthor(Author author)


    //You also get support for operators such as
    // And, Or, Between, LessThan, GreaterThan, Like and many more
}
