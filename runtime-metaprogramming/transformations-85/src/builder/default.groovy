package builder

Developer lili = Developer
        .builder() // En vez de instanciar el objeto se llama directamente al metodo build
// ya con esto se puede llamar a los setters para cada propiedad
        .firstName("Liliam")
        .lastName("Bolanos")
        .middleInitial("P")
        .email("lbolanos@gmail.com")
        .hireDate(new Date())
        .languages(["Java","Groovy"])
        .build()
println(lili)
assert lili.firstName == "Liliam"
assert lili.lastName == "Bolanos"
assert lili.languages.size() == 2

// es otra manera de instanciar un objeto usando la anotacion builder