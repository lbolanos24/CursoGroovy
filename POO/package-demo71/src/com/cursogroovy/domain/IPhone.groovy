package com.cursogroovy.domain

import groovy.transform.ToString

@ToString()
class IPhone extends Phone {

    String iosVersion

    def homeButtonPressed(){
    }

    def airPlay(){
    }

    @Override
    def powerOn(){
    }
}
