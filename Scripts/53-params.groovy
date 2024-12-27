// Implicit parameter
def foo ={     // Tambien se puede usar name -> println name
    println it
    }
foo ('Lili')  //  Envia a imrimir Lili

def noparams = {
    println "no params ..."
}
noparams()  //Imprime lo que este en noprarams()  no params ...

def sayHello = { String first, String last ->
    println "Hello, $first $last"
}
sayHello ("Liliam","Bolanos")   // en el print Hello, Liliam Bolanos

//default values
def greet = {String name, String greeting ="Howdy" ->
    println "$greeting, $name"
}
greet("Liliam","Hello")   // se imprime Hello, Liliam
greet("Paola")   // se imprime Howdy, Paola

//var-arg : para pasar tantos argumentos como sea necesario sin conocer la cantidad
def concat = {String... args ->
    args.join('')
}
println concat ('abc','def')   // abcdef
println concat ('abc','def','123','456') // abcdef123456

//
def someMethod(Closure c){
    println "..."
    println c.maximumNumberOfParameters
    println c.parameterTypes
}
def someClosure = {int x, int y -> x + y}
someMethod(someClosure)  // impime para numero de parametros  2   y pata tipo [int, int]


