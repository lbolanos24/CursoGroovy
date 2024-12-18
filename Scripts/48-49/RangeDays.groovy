/*
Ranges
Crear un rango de enum
imprimir el tamaño del rango
use un metodo para saber si Wednesday esta ahi
imprima from elemento del rango
imprima to elemento del rango
*/

enum Days {
    SUNDAY,MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY
}

def dayRange = Days.SUNDAY..Days.SATURDAY

/*for in loop*/
for (day in dayRange){
    println day
}
println ""
/*using closures*/
dayRange.each {day -> 
    println day
}
println ""
println dayRange.size()
println dayRange.contains(Days.WEDNESDAY)
println dayRange.from  //get
println dayRange.to   //get