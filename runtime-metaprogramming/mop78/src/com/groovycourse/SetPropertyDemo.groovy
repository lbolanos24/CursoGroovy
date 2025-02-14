package com.groovycourse

//se puede interceptar el acceso de escritura a las propiedades sobreescribiendo el metodo setProperty()
class POGO {
    String property

    void setProperty(String name, Object value){
        this.@"$name" ='overridden'
    }
}

def pogo = new POGO()
pogo.property='a'

assert pogo.property == 'overridden'