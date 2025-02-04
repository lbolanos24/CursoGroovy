package com.groovycourse;

import java.io.Serializable;

//Clase estandar de Java. esta es una clase standar de Bean de Java
public class EmployeeBean implements Serializable {
    //private properties
    private String first;
    private String last;
    private String email;

    //public no-args contructor
    public EmployeeBean(){

    }
    //Getters and setters (Generados con clic derecho generar D¿Getters y setters)
    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Impleamentacion de ToString (Generado con clic derecho)

    @Override
    public String toString() {
        return "EmployeeBean{" +
                "first='" + first + '\'' +
                ", last='" + last + '\'' +
                '}';
    }
}

// Uno de los problemas de java , es que hay mucho ruido, en el ejemplo anterior solo hay 3 campos pero hay demasiada data. y por esto se puede incrementar cosiderablemente el mantenimiento e codigo.

