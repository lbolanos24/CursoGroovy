// Delegates.groovy. como cambiar los delegados si asi lo queremos
/*
def writer = {
    append 'Liliam'
    append 'Lives in Envigado'
}
def append (String s){
println "append() called with argument of $s"
}
writer()*/
/* result with out StringBuffer
append() valled with argument of Liliam
append() valled with argument of Lives in Envigado
*/
/*
def writer = {
    append 'Liliam'
    append ' Lives in Envigado'
}

StringBuffer sb = new StringBuffer()
writer.delegate = sb
writer()
*/
/* result with StringBuffer
Liliam Lives in Envigado

se delega el resultado de writer en el stringbuffer el cual sabe append es un metodo que toma el string
*/
/*
def writer = {
    append 'Liliam'
    append 'Lives in Envigado'
}
def append (String s){
println "append() called with argument of $s"
}

StringBuffer sb = new StringBuffer()
writer.delegate = sb
writer()
*/
/* result 
append() called with argument of Liliam
append() called with argument of Lives in Envigado

lo que pasa aca es que aunque se le ha asignado un delegado, aun llama al metodo encasillado append, pues esa es basicamente la estrategia de resolucion /resolucion que tiene
*/


def writer = {
    append 'Liliam'
    append ' Lives in Envigado'
}
def append (String s){
println "append() called with argument of $s"
}

StringBuffer sb = new StringBuffer()
writer.resolveStrategy = Closure.DELEGATE_FIRST
writer.delegate = sb
writer()

/* result with DELEGATE_FIRST
Liliam Lives in Envigado
*/