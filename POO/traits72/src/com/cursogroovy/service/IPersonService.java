package com.cursogroovy.service;

public interface IPersonService {
    public default void doSomenting(){
        System.out.println("doing somenting...");
    }
}
