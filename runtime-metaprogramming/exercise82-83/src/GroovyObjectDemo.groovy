// Se crea un objeto developer añadiendo un metodo o llamando un metodo a developer que no existe
//
Developer developer = new Developer(first: "Liliam", last:"Bolanos", email: "lbolanos@gmail.com")
developer.writeCode("Groovy")
println(developer.first)
developer.languajes=["Groovy","Java"]

/*
imprime
invokeMethod() called with args [Groovy]
getProperty method called...
Liliam
setProperty() called with name languajes and newValue [Groovy, Java]
* */