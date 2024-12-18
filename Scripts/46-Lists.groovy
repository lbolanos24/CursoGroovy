def nums1 = [1,2,3,6,7,9,4,5,3,6,8,9]
println nums1   // [1, 2, 3, 6, 7, 9, 4, 5, 3, 6, 8, 9]
println nums1.class.name   // java.util.ArrayList

List nums = [1,2,3,6,7,9,4,5,3,6,8,9] // tambien se puede con  as LinkedList
println nums   // [1, 2, 3, 6, 7, 9, 4, 5, 3, 6, 8, 9]
println nums.class.name   // java.util.ArrayList

// add|remove|get|clear
//Addig
nums.push(99)  //[99, 1, 2, 3, 6, 7, 9, 4, 5, 3, 6, 8, 9]
nums.putAt(0,77) // replace the 99
println nums   // [77, 1, 2, 3, 6, 7, 9, 4, 5, 3, 6, 8, 9]

//Overload lists
nums[0]=78 // replace the 99
println nums   // [78, 1, 2, 3, 6, 7, 9, 4, 5, 3, 6, 8, 9]

println nums +[3,4,6]   //[78, 1, 2, 3, 6, 7, 9, 4, 5, 3, 6, 8, 9, 3, 4, 6]

println nums + 7   //[78, 1, 2, 3, 6, 7, 9, 4, 5, 3, 6, 8, 9, 7]

// Remmoving
nums.pop()
println nums   //[1, 2, 3, 6, 7, 9, 4, 5, 3, 6, 8, 9]

nums.removeAt(0)
println nums   //[2, 3, 6, 7, 9, 4, 5, 3, 6, 8, 9]

def newList = nums -3
println newList  //[2, 6, 7, 9, 4, 5, 6, 8, 9] remueve las ocurrencias de 3
println nums[4]  // 9. pues es la 4 posicion (comienza en 0)

//Get
println nums.getAt(0..3)  // [2, 3, 6, 7]  , list original [2, 3, 6, 7, 9, 4, 5, 3, 6, 8, 9]
// in loops
for (x in nums){
    println x  // imprime cada numero de la lista
}


// metodo flatten
nums << [3,4,5]
nums << [1,2]
println nums. flatten()  // [2, 3, 6, 7, 9, 4, 5, 3, 6, 8, 9, 3, 4, 5, 1, 2]

// metodo unique
println nums.unique()   // [2, 3, 6, 7, 9, 4, 5, 8, [3, 4, 5], [1, 2]]


def numbers1 = [1,2,7,3,8,3,8,3,8,9,2,6,10,165,4] as Set
println numbers1  // [1, 2, 7, 3, 8, 9, 6, 10, 165, 4]  no hay duplicados en un set
println numbers1.class.name // java.util.LinkedHashSet

def numbers = [1,2,7,3,8,3,8,3,8,9,2,6,10,165,4] as SortedSet
println numbers  // [[1, 2, 3, 4, 6, 7, 8, 9, 10, 165] Lista ordenada sin duplicados
println numbers.class.name // java.util.TreeSet





