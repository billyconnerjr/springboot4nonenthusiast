package com.bookgroovy.models

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIgnore

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne

/**
 * If your not familiar with Groovy pretend this is pseudo code for java.
 * Assume there are constructors and getters and setters.
 * Created by bconner on 6/4/17.
 */
@Entity
class Book {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long id
    String title

    @JsonIgnore
    @ManyToOne
    Author author
}
