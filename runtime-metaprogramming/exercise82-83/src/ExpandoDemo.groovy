Expando e = new Expando()

e.first = "Lili"
e.last = "BolanosR"
e.email = "lbolanos1@gmail.com"

e.getFullName = {
    "$first $last"
}

println(e.toString())
println(e.getFullName())
/*
Imprime
{last=BolanosR, getFullName=ExpandoDemo$_run_closure1@610db97e, first=Lili, email=lbolanos1@gmail.com}
Lili BolanosR

 este es el resultado de expando
* */

// lo siguiente sucede en tiempo de compilacion
@groovy.transform.ToString(includeNames = true)
class Person {
    String first, last
}

Person p = new Person(first:"LiliamP", last: "BolanosR1")
p.metaClass.email = "lbolanos2@gmail.com"
println(p)
println(p.email)
/*
Person(first:LiliamP, last:BolanosR1)
lbolanos2@gmail.com
* */

