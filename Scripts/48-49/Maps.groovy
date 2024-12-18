/*
Maps
Crear un mapa de dias de la semana: 1:Sunday...
imprima el mapa
imprima la clase del mapa
imprima el tamaño del mapa
Hay un metodo ara imprimir los dias?
LinkedHashMap
*/

Map map = [1:"Sunday",2:"Monday",3:"Tuesday",4:"Wednesday",5:"Thursday",6:"Friday",7:"Saturday"]

println map   // [1:Sunday, 2:Monday, 3:Tuesday, 4:Wednesday, 5:Thursday, 6:Friday, 7:Saturday]
println map.getClass().getName()  // java.util.LinkedHashMap
println map.size()   // 7
println map.values()  // [Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday]
