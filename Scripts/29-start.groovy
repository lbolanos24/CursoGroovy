//if
if (true)
    println "value is true"

// false | null | empty string | empty collection    
if (true)
    println "value is false"
 
String name = "Liliam"
if (name)
    println "name has a value"

String last = ""
if (name)
    

//if/else
def x = 5
if (x==10){
    println "X is 10"
}else{
    println "X is NOT 10"
}

// classic while
def i =1
while (i <= 10){
    println i
    i++
}

//for in list
def list = [1,2,3,4]
for (num in list){
    println num
}

// closure
def list2 = [1,2,3,4]
list2.each { println it }

//switch
def myNumber = 1
switch(myNumber){
    case 1:
         println "myNumber is 1"
         break
    case 2:
         println "myNumber is 2"
         break
    default:
     println "We hit the default case"
}