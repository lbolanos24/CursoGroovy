package com.groovycourse

// Este metodo es llamado cuando cuando el metodo llamado no esta presnete en el Objeto de Groovy
class InvokeDemo {
    def invokeMethod (String name, Object args){
        return "called invokeMethod $name $args"
    }

    def test(){
        return "Method exists"
    }
}

def invokeDemo = new InvokeDemo()
assert invokeDemo.test() == "Method exists"
assert invokeDemo.someMethod() == "called invokeMethod someMethod []"