package canonical

//Haciendo uso de TupleConstructor se crea una persona
Person p1= new Person("Liliam", "Bolanos", "lbolanos@mail.com")
Person p2= new Person("Liliam", "Bolanos", "lbolanos@mail.com")

// Cn el asser se hace uso del EqualsAndHashCode
assert p1 == p2

//Y finalmente se hace uso del ToString
print p1.toString()