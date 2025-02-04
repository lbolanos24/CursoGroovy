package com.groovycourse

/* Una forma de validar la clse empleado
Employee emp = new Employee(first: "Liliam",last: "Bolanos",email: "lb@email.com")
println emp
*/
/*
Imprime
com.groovycourse.Employee(Liliam, Bolanos, lb@email.com)
Process finished with exit code 0
* */

/*Otra forma es */

//Employee emp = new Employee()
//emp.first = "Lili"  // esta es la equivalencia de set first
//println emp.first // equivalencia al setter

// impime : Lili


// tercera forma

/*Otra forma es */

DoubleBean db = new DoubleBean()
db.value=100

println db.value  // imprime 200
println db.@value  // imprime 100... el valor asignado aca sin llamar al getter