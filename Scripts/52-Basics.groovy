Closure c1 = {}

println c1.class.name  // 52-Basics$_run_closure1
println c1 instanceof Closure   // true

def c = {}
println c.class.name  // 52-Basics$_run_closure2
println c instanceof Closure   // true

//El closure es un bloque de codigo que actua como una como una funcion anonima
def sayHello1 = {
    println "Hello"
}
sayHello1()   // Hello

def sayHello = { name ->  // se puede pasar parametros
    println "Hello, $name"
}
sayHello('Liliam')   // Hello, Liliam

List nums = [1,4,7,4,30,2]
nums.each ({ 
    println it // palabra reservada it para tomar cada elemento de la lista en el closure
                // Result: [1, 4, 7, 4, 30, 2]
})

nums.each ({ num ->  // otra forma es si se quiere el nombre de la vble
    println num // palabra reservada it para tomar cada elemento de la lista en el closure
                // Result: [1, 4, 7, 4, 30, 2]
})

// los closures son objets y ultimo parametro
def timesTen(num,closure){
     closure (num*10)
}
timesTen(10, {println it})  // 100
timesTen(2, {println it})   // 20

10.times {
    println it  // imprime del 0 al 9
}

import java.util.Random
Random rand = new Random()
3.times{
    println rand.nextInt()   // imprime 3 numeros aleatorios
}