// if (boolean expression){logic}
if( true ){ 
    println "true"  // true
}
if( true )
    println true  // true

def age = 35
if( age >= 35 ){ 
    println "can run for president"  // can run for president
}

if( true ){
    println true 
} else {
    println true 
}

def yourAge=18
if( yourAge >=21 ){
    println "Buy beer" 
} else {
    println "not beer for you" 
}

def someAge = 37
if( someAge >= 21 && someAge < 35 ){
    println "Buy some beer" 
} else if ( someAge >= 35 ) {
    println "run for president"
} else {
    println "under 21..." 
}

/**********************************************************/
//ternary operator (expression) ? true : false
//Permite crear una linea corta de expresiones para comprobar y evaluar si una expresion es verdadera, y hacer algo con esa expresion

def name = 'Liliam'
def isitLiliam =(name.toUpperCase()=='LILIAM')? 'YES':'NO'
println isitLiliam    //YES

def isitLiliam2 =(name.toLowerCase()=='LILIAM')? 'YES':'NO'
println isitLiliam2    //NO

def msg
def output =(msg != null) ? msg : 'default message...'

def elvisOutput = msg ?: 'default message...'
println msg   // null 
println output   // default message...
println elvisOutput   //default message...


//---------------------------
/*Switch statement: es diferente que en Java*/
def num = 12

switch (num){
   case 1:
       println "1"
       break
   case 2:
       println "2"
       break   // se coloca para que no se impriman todos los casos y termine la sentencia, default no lo necesita por ser el ultimo
   case 1..3:
       println "in range 1..3"
       break
   case Integer:
       println "num is an Integer"
       break
   case Float:
       println "num is an Float"
       break
   case [1,2,12]:
       println "num is in list [1,2,12]"
       break
   default:
       println "default..."
}


//IN: se puede usar como expresion para comparar variables.

def validAges = 18..35
def someAge =19
println someAge in validAges  // true

