package com.groovycourse.service;

import com.groovycourse.domain.Person

interface IPersonService {
    // usa metodos abtractos, no se implemeta logica
    Person find()
    List<Person> findAll()
}
