// Looping
//-------
///Construcciones tipo blucle
//While
List numbers=[1,2,3] //lista llena
while ( numbers ) {
    numbers.remove(0)  // se van removiendo numeros hasta que yas no haya
}
assert numbers == [] // al ejecutar el bloque de codigo no sale nada pues la asercion es verdadera

// for
for (vble in iterable){
}

List nums=[1,2,3]
for (i in nums){
     println i 
} // imprime 1, 2, 3. pues imprime un numero de la lista en cada iteracion

for (i in 1..10){
     println i 
}// imprime 1 al 10. pues imprime un numero del rango en cada iteracion


Closure c = { }
// es importante anotar que ainque la estructura es similar a un closure, son cosas distintas

//return / break / continue
// en Java se debe hacer retornos en todas partes, pero en groovy se tiene el metodo getFoo() que devuelve un string, que basicamente va a retornar ese string en el final de cada metodo 

String getFoo(){
    "foo"
}

Integer a = 1
while ( true ) { // loop infinito si no se condiciona
    a++
    break
}
assert a == 2 // condicional del loop

for (String s in 'a'..'z'){
    if (s == 'a') continue
    println s
    if (s > 'b') break
}  // este bucle imprime b y c