/*
List
Crear una lista de dias(Sun - Sat)
imprimir la lista
imprimir el tama�o de la lista
remover el sabado
a�adir el sabado a la lista
imprimir el miercoles usndo index
*/

def days = ["Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"]

println days   // [Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday]
println days.size()   // 7
days.pop()
println days  // [Monday, Tuesday, Wednesday, Thursday, Friday, Saturday]
days.add("Saturday")  // [Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Saturday]
println days
println days [3]  // Thursday
