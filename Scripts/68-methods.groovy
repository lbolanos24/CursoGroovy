/* ejemplo de clase con un constructor
class Person {
    // contructores
    public Person(){
        return this
    }
    
    otro ejemplo de contructor con parametros puede ser 
     public Person(String first, last){
        this.first = first
}
Person p = new Person()
*/
/* Constructor por defecto
@groovy.transform.ToString
class Person {
    String first, last
    // contructor
   }
Person p = new Person(first:'Liliam', last:'Bolanos')
println p   // Person(Liliam, Bolanos), campos construidos por defecto
*/
/*Constructor propio*/
/*
@groovy.transform.ToString
class Person {
    String first, last
    // contructores
    Person(String fullName){   // instancia de la clase
        List parts = fullName.split(' ')
        first = parts[0]
        last = parts[1]
    }
}
Person p = new Person("Liliam Bolanos")
println p  // Person(Liliam, Bolanos)
*/

/*Metodos*/

@groovy.transform.ToString
class Person {
    String first, last
    // contructores
    Person(String fullName){   // instancia de la clase
        List parts = fullName.split(' ')
        first = parts[0]
        last = parts[1]
    }
    // Metodo en Java
    public void foo(String a, String b){
        //do stuff
    }
    // Metodo en Groovy. por defecto son public. y tampoco se necesita el return
    String getFullName(String a, String b){
        "$first $last"
    }
    // Otra caracteristica de groovy es q    ue no se necesita definir el tipo de retorno
    def bar(){
        // puede ser cualquier tipo inclusive void en el retorno
    }
    //Tambien se pueden crear metodos estaticos
    static String doGoodWork(){
        println "doing good work..."
    }
    //Se puede crear metodos que llaman mas metodos, o metodos argumento
    def someMethod(numbers){  // al argumento se le puede o no asignar un tipo. o tambien se le puede colocar valor por defecto
        println "doing good work..."
    }
    // hay casos en los cuales no se sabe cuantos argumentos van a pasar en un metodo
    //Se puede pasar la variag¿ble VarArgs
    def concat (String...args){
        println args.length  
    }
}
//Para los metodos no es necesario definir una instancia de la clase
//Person.doGoodWork()  // imprime: doing good work...
Person p = new Person("Liliam Bolanos")
p.concat('a','b')  // imprime la longitud = 2

