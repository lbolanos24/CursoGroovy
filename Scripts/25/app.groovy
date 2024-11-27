// Create a new instance of a developer
Developer d = new Developer() 
d.first = "Dan"
d.setLast("Vega")

//asign some languages
d.languages << "Groovy"
d.languages << "Java"

// call some methods
d.work()