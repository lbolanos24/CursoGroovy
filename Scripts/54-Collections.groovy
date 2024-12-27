// each / eachWithIndex
List favNums = [2,21,44,35,8,4]

for (num in favNums){
    println num
}   // imprime 2,21,44,35,8,4 con salto de linea

favNums.each { println it } // imprime 2,21,44,35,8,4 con salto de linea

for (int  i=0; i < favNums.size(); i++ ){
      println "$i:${favNums[i]}"
} // imprime 0:2,1:21,2:44,3:35,4:8,5:4 con salto de linea

favNums.eachWithIndex { num, idx -> 
    println "$idx:$num" 
    } // imprime 0:2,1:21,2:44,3:35,4:8,5:4 con salto de linea

// findAll, pasando una condicion
List days = ["Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"]
List weekend = days.findAll {it.startsWith("S")}

println days   // [Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday]
println weekend   // [Sunday, Saturday]

//collect
List nums =[1,2,2,7,2,8,2,4,6]
List numsTimesTen =[]
nums.each{num ->
    numsTimesTen << num * 10
}
println nums  // [1, 2, 2, 7, 2, 8, 2, 4, 6]
println numsTimesTen  //[10, 20, 20, 70, 20, 80, 20, 40, 60]
// Sin embargo esta no es la forma mas eficiente de hacerlo, pues esta haciendo un ciclo sobre la lista
// se puede hacer un uso mas funcional con la coleccion

List newTimesTen = nums.collect{ num -> num * 10}
println newTimesTen  // [10, 20, 20, 70, 20, 80, 20, 40, 60]

