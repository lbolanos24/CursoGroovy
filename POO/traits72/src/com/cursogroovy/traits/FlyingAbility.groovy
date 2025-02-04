package com.cursogroovy.traits

trait FlyingAbility {
    String fly(){
        "I'm Flying!"
    }

    abstract String foo() // metodo abstracto, vacio
    //Tambien se puede implemantar metodos privados
    private String bar(){
        "bar"
    }
}