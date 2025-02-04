package com.groovycourse.service

import com.groovycourse.domain.Person

class PersonService implements IPersonService{
    //Esta clasae implemeta la interfaz
    @Override
    Person find() {
        Person p = new Person(first:"Liliam", last:"Bolanos")
        return p
    }

    @Override
    List<Person> findAll() {
        Person p1 = new Person(first:"Liliam", last:"Bolanos")
        Person p2 = new Person(first:"German", last:"Velasco")

        [p1,p2]
    }
}
