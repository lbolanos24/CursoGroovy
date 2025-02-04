package com.groovycourse

import groovy.transform.ToString
@ToString

class Employee implements Serializable {
    String first, last, email
    // Se necesitan Get/ y set para estos campos, para ello se pasan los campos a privados por debajo
    // Para ello lo que se debe jhacer es Implementar la clase Serializable
    // Al hacer Build > Compile de esta clase se crea la carpeta out, y dentro la el archivo Employee.class
    // Donde se van a generar los argumentos privados, contructor sin argumentos , Getters y settes

    String fullName
    // Se puede escribir sus propios get and set si asi se desea
    void setFullName(String name){
        fullName=name
    }
    String getFullName(){
        "Full Name: ${fullName}"
    }
}
