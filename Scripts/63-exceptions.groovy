// Exceptions
// el manejo de excepciones en groovy es similar al de Java. Try-catch
// la diferencia radica en que en groovy las exepciones son opcionales. por tanto no necesitan formar parte del metodo

//Java
/*
public void foo() throws Exception{  // esto hace que sea obligatorio en los metodos
    throw new Exception()
}*/

// Groovy--
def foo(){
    // do stuff
     throw new Exception("Foo Exception")
}

//Example

List log = []

try {
    foo()
} catch ( Exception e ) {
    log << e.message
} finally {
    log << 'finally'
}
println log   
//-- imprime [Foo Exception, finally]


// Java 7 introdujo un multi catch sintaxis

try {
    //do stuff here
} catch ( FileNotFoundException | NullPointerException e ) {
    println e.class.name
    println e.message
}