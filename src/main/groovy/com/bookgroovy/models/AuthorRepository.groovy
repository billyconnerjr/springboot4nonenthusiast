package com.bookgroovy.models

import org.springframework.data.repository.CrudRepository

/**
 * Created by bconner on 6/4/17.
 */
interface AuthorRepository extends CrudRepository<Author, Long>{

    //dynamic query method by declaring the method signature.
    List<Author> findById(Long id)

    List<Author> findByLastName(String lastName)

}
