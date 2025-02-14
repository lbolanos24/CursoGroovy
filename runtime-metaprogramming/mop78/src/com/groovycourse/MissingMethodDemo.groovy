package com.groovycourse

import org.codehaus.groovy.runtime.metaclass.MissingMethodExceptionNoStack

//Groovy soporta el concepto de MethodMissing(). este metodo difiere del de invocacion en que ese es unico
// es invocado en caso de que falle el metodo dispatch, cuando el metodo no puede ser encontrado por el nombre dado y/o los argumentos dados

class MyEmployee {
    def methodMissing(String name, def args){

        if( name != 'someMethod' ){
            throw new MissingMethodException(name,args)
        }

        println "Method missing called on: $name"
        println "with argument ${args}"
    }
}

MyEmployee emp = new MyEmployee()
emp.someMethod(1,2,3)
/*Imprime
 Method missing called on: someMethod
with argument [1, 2, 3]
* */

emp.someOtherMethod(4,5,6)
