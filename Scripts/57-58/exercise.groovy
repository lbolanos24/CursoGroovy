/*[Exercise] Using Closures
Closure Basics
Locate the class groovy.lang.Closure and spend a few minutes looking through documentation.
Create a Method that accepts a closure as an argument
Create a closure that performs some action
Call the method and pass the closure to it.
Create a list and use them each to iterate over each item in the list and print it out
Hint - You can use the implicit it or use your own variable
Create a map of data and iterate over it using each method. 
This method can take a closure that accepts 1 or 2 arguments. 
Use 2 arguments and print out the key and value on each line.
Demonstrate the use of curry and try to come up with an example different from the one we used in the lecture. 
*/

//Create a Method that accepts a closure as an argument
def mymethod(Closure c){
    c()
}
//Create a closure that performs some action
def foo ={
    println "foo"
}
//Call the method and pass the closure to it.
mymethod(foo) // imprime el contenido del print = foo

//Create a list and use them each to iterate over each item in the list and print it out
List names = ["Dan Vega","Joe Vega","Andy vega","Katie Vega"]
names.each{ name ->
    println name
}// Imprime  Dan Vega, Joe Vega, Andy vega, Katie Vega en cada linea

//Create a map of data and iterate over it using each method. 
Map teams = [baseball:"Cleveland Indians", basketball:"Cleveland Cavs", football:"Cleveland Browns"]
teams.each{k,v ->
    println "$k = $v"
} // imprime baseball = Cleveland Indians, basketball = Cleveland Cavs, football = Cleveland Browns

//Demonstrate the use of curry and try to come up with an example different from the one we used in the lecture.  
def greet = {String greeting, String name ->
    println "$greeting, $name"
} 
greet ("Hello","Liliam") // Hello, Liliam

def sayHello = greet.curry("Hello")
sayHello("Paola") // Hello, Paola

/*
Explore the GDK
In the following exercises we are going to explore the GDK to find some methods that take closures and learn how to use them. Hint - I would narrow your search to java.util.Collection, java.lang.Iterable & java.util.List

https://groovy-lang.org/gdk.html

Search for the find and findAll methods.
What is the difference between the two? 
Write some code to show how they both work.

Collection > find(Closure c) y findAll(Closure c)
find(Closure closure)
Finds the first value matching the closure condition.
findAll(Closure closure)
Finds all values matching the closure condition.

Search for the any and every methods.
What is the difference between the two? 
Write some code to show how they both work. 

Iterable > 
any(Closure predicate)
Iterates over the contents of an iterable, and checks whether a predicate is valid for at least one element.
every(Closure predicate)
Used to determine if the given predicate closure is valid (i.e. returns true for all items in this iterable).


Search for the method groupBy that accepts a closure
What does this method do? 
Write an example of how to use this method.

Map	groupBy(Closure closure)
Sorts all Iterable members into groups determined by the supplied mapping closure.
Map	groupBy(Object closures)
Sorts all Iterable members into (sub)groups determined by the supplied mapping closures.
Map	groupBy(List closures)
Sorts all Iterable members into (sub)groups determined by the supplied mapping closures.

*/
//Lista de mapas
List people = [
    [name:'Jane', city:"New York City"],
    [name:'John', city:"Cleveland"],
    [name:'Mary', city:"New York City"],
    [name:'Dan', city:"Cleveland"],
    [name:'Tom', city:"New York City"],
    [name:'Frank', city:"New York City"],
    [name:'Jason', city:"Cleveland"]
]

println people.find{person -> person.city=="Cleveland"}
// Imprime el primer elemento de la lista que concuerde: [name:John, city:Cleveland]
println people.findAll{person -> person.city=="Cleveland"}
// Imprime [[name:John, city:Cleveland], [name:Dan, city:Cleveland], [name:Jason, city:Cleveland]]

println people.any{person -> person.city == "Cleveland"}  // imprime  true
println people.every{person -> person.city == "Cleveland"}  // imprime  false
println people.every{person -> person.name.size() >= 3}  // imprime  true

def peopleByCity = people.groupBy { person -> person.city } 
println people.peopleByCity  // Imprimio nulls

def newYorkers = peopleByCity["New York City"]
def clevelanders = peopleByCity["Cleveland"]

clevelanders.each{
    println it.name
} // John, Dan, Jason


