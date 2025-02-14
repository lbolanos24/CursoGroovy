//Meta class demo
/*
Expando e = new Expando()
e.name= 'Liliam'
e.writeCode = {->println "$name Loves to write code..."}
e.writeCode()
*/
//Una meta clase en realidad es una Expando
class Developer {

}
//por instancia
Developer lili = new Developer()
lili.metaClass.name = 'Lili'
lili.metaClass.writeCode = {->println "$name Loves to write code..."}
lili.writeCode()

/*Imprime
Lili Loves to write code...
Process finished with exit code 0

Dado que la metaclase se ha asociado a la llamada, la meta clase sabe como manejar el metodo
* */

// para toda instancia. se debe tener cuidado, pues esta modificando una isntancia general y eso es peligroso

String.metaClass.shout = { -> toUpperCase()}
println "Hello Liliam".shout()

/*Imprime
HELLO LILIAM
Process finished with exit code 0
* */