package com.bookgroovy.models

import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToMany

/**
 * Created by bconner on 6/4/17.
 */
@Entity
class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id
    String firstName
    String lastName
    @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER) //can also be Lazy Loaded
    @JoinColumn(name="author_id")
    List<Book> books
}
