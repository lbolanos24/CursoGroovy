# The Complete Apache Groovy Developer Course
>https://perficient.udemy.com/course/apache-groovy/
 
 En este archivo ire llenando las notas que considero relevantes colocando las secciones abordadas de la mas nueva a la mas antigua.

 /************************************************/

 /************************************************/

 /************************************************/

 /************************************************/

 /************************************************/

 /************************************************/

 /************************************************/

 /************************************************/

 /************************************************/
# Seccion 11 - 105:
List of Builders

Documentacion: 
https://groovy-lang.org/dsls.html
 >> sectioon 8  
 
Da una descripcion de varios builders


 /************************************************/
# Seccion 11 - 104:
Object Graph Builder

Documentacion: 
https://groovy-lang.org/api.html
>> groovy.util  >> ObjectGraphBuilder 

Para creacion de objetos graficos

crear la el script book.groovy dentro del src del proyecto object-graph. y en el archivo crear las clases para el objeto libro

    import groovy.transform.ToString

    @ToString(includeNames = true)
    class Book {
        String title
        String summary
        List<Section> sections = []
    }

    @ToString(includeNames = true)
    class Section {
        String title
        List<Chapter> chapters = []
    }

    @ToString(includeNames = true)
    class Chapter{
        String title
    }

para ejemplificar se tiene el modo de Java, en la parte de abajo de la definicion de las clases, El cual se comenta mas tarde.

    //Java Style (No usado en este ejemplo)
    public Book createBook(){
        Book b = new Book();
        b.setTitle("My book");
        b.setSummary("My summary");

        Section s = new Section();
        s.setTitle("My section 1");

        Chapter  c1 = new Chapter();
        c1.setTitle("My Chapter 1");
        Chapter  c2 = new Chapter();
        c2.setTitle("My Chapter 2");

        s.addChapters(c1,c2);
        b.getSections().add(s)

        return b;
    }
        

En su lugar se usara el Object builder class de groovy

    ObjectGraphBuilder builder = new ObjectGraphBuilder()

si se ejecuta en la consola de groovy se necesita tener un loader y pasarlo al constructor, pero en intellij no es necesario

en el siguiente codigo. book se refiere a una ruta nodo (similar a json markup)

    ObjectGraphBuilder builder = new ObjectGraphBuilder()

    def book = builder.book(
            title:"Groovy in Action 2nd Edition",
            summary:"Groovy in Action, Second Edition is a thoroughly revised, comprehensive guide to Groovy programming.") {
        section(title:"Section 1"){
            chapter(title: "Chapter 1")
            chapter(title: "Chapter 2")
            chapter(title: "Chapter 3")
        }
        section(title:"Section 2"){
            chapter(title: "Chapter 4")
            chapter(title: "Chapter 5")
            chapter(title: "Chapter 6")
        }
    }

println book

que al ejecutarlo se obtiene en consola

    Book(title:Groovy in Action 2nd Edition, summary:Groovy in Action, Second Edition is a thoroughly revised, comprehensive guide to Groovy programming., sections:[Section(title:Section 1, chapters:[Chapter(title:Chapter 1), Chapter(title:Chapter 2), Chapter(title:Chapter 3)]), Section(title:Section 2, chapters:[Chapter(title:Chapter 4), Chapter(title:Chapter 5), Chapter(title:Chapter 6)])])

 Se pueden crear algunos asserts, como por ejemplo 
 
    assert book.title == "Groovy in Action 2nd Edition"
    assert book.sections.size() == 2
    assert book.sections[0].title == "Section 1"
    assert book.sections[0].chapters.size() == 3

 /************************************************/
# Seccion 11 - 103:
JSON builder


Es similar a markupbuilder, pero con algunas diferencias

Crear el script json.groovy y el paquete json

    import groovy.json.JsonBuilder
    JsonBuilder builder = new JsonBuilder()

    builder.books {
        book {
            title'The 4 Hour Work Week'
            isbn '978-0-307-46535-1'
            author(first'Timothy', last:'Ferriss', twitter:'@tferriss')
            related 'The 4 Hour Body','The 4 Hour chef'
        }
    }

    println builder.toString()

que al ejecutarlo da como resultado un json de la siguiente forma

    {"books":{"book":{"title":"The 4 Hour Work Week","isbn":"978-0-307-46535-1","first":[{"last":"Ferriss","twitter":"@tferriss"},"Timothy"],"author":[{"last":"Ferriss","twitter":"@tferriss"},"Timothy"],"related":["The 4 Hour Body","The 4 Hour chef"]}}}

Para añadir otro libro, se debe tener en cuenta que los elementos de la estructura de datos de Jason necesitan tener llaves unicas

    import groovy.json.JsonBuilder
    JsonBuilder builder = new JsonBuilder()

    builder.books {
        currentBook {
            title'The 4 Hour Work Week'
            isbn '978-0-307-46535-1'
            author(first'Timothy', last:'Ferriss', twitter:'@tferriss')
            related 'The 4 Hour Body','The 4 Hour chef'
        }

        nextBook {
            title'#AskGaryVee'
            isbn '978-0-06-227312-3'
            author(first'Gary', last:'Vaynerchuck', twitter:'@garyvee')
            related 'Jab, Jab, Jab, Right Hook','Crush it'
        }
    }

    println builder.toString()

al ejecutar:

    {"books":{"currentBook":{"title":"The 4 Hour Work Week","isbn":"978-0-307-46535-1","first":[{"last":"Ferriss","twitter":"@tferriss"},"Timothy"],"author":[{"last":"Ferriss","twitter":"@tferriss"},"Timothy"],"related":["The 4 Hour Body","The 4 Hour chef"]},"nextBook":{"title":"#AskGaryVee","isbn":"978-0-06-227312-3","first":[{"last":"Vaynerchuck","twitter":"@garyvee"},"Gary"],"author":[{"last":"Vaynerchuck","twitter":"@garyvee"},"Gary"],"related":["Jab, Jab, Jab, Right Hook","Crush it"]}}}

Documentacion: 
https://groovy-lang.org/api.html
>> groovy.json  >> JsonBuilder 

metodo toPrettyString() para tener una vista diferente del jason

    println builder.toPrettyString()

imprimira:

    {
        "books": {
            "currentBook": {
                "title": "The 4 Hour Work Week",
                "isbn": "978-0-307-46535-1",
                "first": [
                    {
                        "last": "Ferriss",
                        "twitter": "@tferriss"
                    },
                    "Timothy"
                ],
                "author": [
                    {
                        "last": "Ferriss",
                        "twitter": "@tferriss"
                    },
                    "Timothy"
                ],
                "related": [
                    "The 4 Hour Body",
                    "The 4 Hour chef"
                ]
            },
            "nextBook": {
                "title": "#AskGaryVee",
                "isbn": "978-0-06-227312-3",
                "first": [
                    {
                        "last": "Vaynerchuck",
                        "twitter": "@garyvee"
                    },
                    "Gary"
                ],
                "author": [
                    {
                        "last": "Vaynerchuck",
                        "twitter": "@garyvee"
                    },
                    "Gary"
                ],
                "related": [
                    "Jab, Jab, Jab, Right Hook",
                    "Crush it"
                ]
            }
        }
    }


para imprimir el json generado en un archivo aparte se añade la linea

    new File('json/books.json').write(builder.toPrettyString())

 /************************************************/
# Seccion 11 - 101-102:
Ejercicio

XML
Use the MarkupBuilder to generate the following XML

    <books>
        <book isbn="978-1935182443">
            <title>Groovy in Action 2nd Edition</title>
            <author>Dierk Koenig</author>
            <price>50.58</price>
        </book>
        <book isbn="978-1935182948">
            <title>Making Java Groovy</title>
            <author>Ken Kousen</author>
            <price>33.96</price>
        </book>
        <book isbn="978-1937785307">
            <title>Programming Groovy 2: Dynamic Productivity for the Java Developer</title>
            <author>Venkat Subramaniam</author>
            <price>28.92</price>
        </book>
    </books>


HTML
With the same data from the xml version build an HTML page that lists that data.

Bonus
Using a FileWriter write the contents of the HTML from the MarkupBuilder to a file.


Para XML se crea el archivo xml.groovy con el codigo

    import groovy.xml.MarkupBuilder
    FileWriter writer = new FileWriter("xml/books.xml")
    MarkupBuilder builder = new MarkupBuilder(writer)

    builder.books {
        book(isbn:"978-1935182443") {
            title("Groovy in Action 2nd Edition")
            author("Dierk Koenig")
            price("50.58")
        }
        book (isbn:"978-1935182948"){
            title("Making Java Groovy")
            author("Ken Kousen")
            price("33.96")
        }
        book (isbn:"978-1937785307"){
            title("Programming Groovy 2: Dynamic Productivity for the Java Developer")
            author("Venkat Subramaniam")
            price("28.92")
        }
    }
 
Que al ejecutarlo crea el archivo books.xml en la carpeta ya creada xml
 
    <books>
    <book isbn='978-1935182443'>
        <title>Groovy in Action 2nd Edition</title>
        <author>Dierk Koenig</author>
        <price>50.58</price>
    </book>
    <book isbn='978-1935182948'>
        <title>Making Java Groovy</title>
        <author>Ken Kousen</author>
        <price>33.96</price>
    </book>
    <book isbn='978-1937785307'>
        <title>Programming Groovy 2: Dynamic Productivity for the Java Developer</title>
        <author>Venkat Subramaniam</author>
        <price>28.92</price>
    </book>
    </books>



Para HTML se crea el archivo html.groovy con el codigo

    import groovy.xml.MarkupBuilder

    def books =[
            [isbn:"978-1935182443", title:"Groovy in Action 2nd Edition", author:"Dierk Koenig", price:"50.58"],
            [isbn:"978-1935182948", title:"Making Java Groovy", author:"Ken Kousen",price:"33.96"],
            [isbn:"978-1935182443", title:"Groovy in Action 2nd Edition", author:"Dierk Koenig", price:"50.58"]
    ]

    FileWriter fileWriter = new FileWriter("html/books.html")
    MarkupBuilder builder = new MarkupBuilder(fileWriter)

    builder.books {
        head {
            title"Books"
        }
        body{
            h1("books")
            table{
                tr{
                    th 'ISBN'
                    th 'Title'
                    th 'Author'
                    th 'Price'
                }
                books.each { book ->
                    tr {
                        td book.isbn
                        td book.title
                        td book.author
                        td book.price
                    }
                }
            }
        }
    }


Que al ejecutarlo crea el archivo books.html en la carpeta ya creada html

    <books>
    <head>
        <title>Books</title>
    </head>
    <body>
        <h1>books</h1>
        <table>
        <tr>
            <th>ISBN</th>
            <th>Title</th>
            <th>Author</th>
            <th>Price</th>
        </tr>
        <tr>
            <td>978-1935182443</td>
            <td>Groovy in Action 2nd Edition</td>
            <td>Dierk Koenig</td>
            <td>50.58</td>
        </tr>
        <tr>
            <td>978-1935182948</td>
            <td>Making Java Groovy</td>
            <td>Ken Kousen</td>
            <td>33.96</td>
        </tr>
        <tr>
            <td>978-1935182443</td>
            <td>Groovy in Action 2nd Edition</td>
            <td>Dierk Koenig</td>
            <td>50.58</td>
        </tr>
        </table>
    </body>
    </books>


 /************************************************/
# Seccion 11 - 99:
Documentacion Builder

https://groovy-lang.org/api.html  

Dado que la documetacion es lago ligera se recomienda ir al codigo fuentey revisar los test unitarios https://github.com/apache/groovy  
https://github.com/apache/groovy/blob/master/subprojects/groovy-xml/src/test/groovy/groovy/xml/MarkupBuilderTest.groovy    
Copiar los ejemplos y ehjecutarlos es una buena forma de aprender sobre los builders  

https://github.com/apache/groovy/blob/master/subprojects/groovy-xml/src/test/groovy/groovy/xml/MarkupBuilderTest.groovy  

# Seccion 11 - 100:
MarkupBuilder - HTML

https://groovy-lang.org/api.html
>> groovy.xml  >> MarkupBuilder

Crear el script html.groovy, tratando de seguir la estructura de un html

    import groovy.xml.MarkupBuilder
    MarkupBuilder builder = new MarkupBuilder()

    builder.html {
        head {
            title 'About Liliam Bolanos'
            description 'This is an about me page'
            keywords 'Liliam Bolanos, Groovy, Java, Spring'
        }
        body {
            h1 'About me'
            p 'This is a bunch of text about me...'
            section {
                h2 'Courses'
                table{
                    tr{
                        th 'id'
                        th 'name'
                    }
                    tr{
                        th '1'
                        th 'Groovy'
                    }
                    tr{
                        th '2'
                        th 'Spring Boot'
                    }
                }
            }
        }
    }

Que al ejecutarlo obtiene una estructura de html de la siguiente forma

    <html>
    <head>
        <title>About Liliam Bolanos</title>
        <description>This is an about me page</description>
        <keywords>Liliam Bolanos, Groovy, Java, Spring</keywords>
    </head>
    <body>
        <h1>About me</h1>
        <p>This is a bunch of text about me...</p>
        <section>
        <h2>Courses</h2>
        <table>
            <tr>
            <th>id</th>
            <th>name</th>
            </tr>
            <tr>
            <th>1</th>
            <th>Groovy</th>
            </tr>
            <tr>
            <th>2</th>
            <th>Spring Boot</th>
            </tr>
        </table>
        </section>
    </body>
    </html>
    Process finished with exit code 0


basicamernte lo que se hace es usar codigo para generar markups, y asi mismo se pueden usar para construir markups dentro del mismo. Por ejemplo se puede usar una lista para generar la tabla:

    import groovy.xml.MarkupBuilder

    MarkupBuilder builder = new MarkupBuilder()

    List courses = [
            [id:1, name: 'Apache Groovy'],
            [id:2, name: 'Spring Boot']
    ]

    builder.html {
        head {
            title 'About Liliam Bolanos'
            description 'This is an about me page'
            keywords 'Liliam Bolanos, Groovy, Java, Spring'
        }
        body {
            h1 'About me'
            p 'This is a bunch of text about me...'
            section {
                h2 'Courses'
                table{
                    tr{
                        th 'id'
                        th 'name'
                    }
                    courses.each { course ->
                        tr {
                            td course.id
                            td course.name
                        }
                    }
                }
            }
        }
    }

que al ejecutarlo obtiene un resultado similar

    <html>
    <head>
        <title>About Liliam Bolanos</title>
        <description>This is an about me page</description>
        <keywords>Liliam Bolanos, Groovy, Java, Spring</keywords>
    </head>
    <body>
        <h1>About me</h1>
        <p>This is a bunch of text about me...</p>
        <section>
        <h2>Courses</h2>
        <table>
            <tr>
            <th>id</th>
            <th>name</th>
            </tr>
            <tr>
            <td>1</td>
            <td>Apache Groovy</td>
            </tr>
            <tr>
            <td>2</td>
            <td>Spring Boot</td>
            </tr>
        </table>
        </section>
    </body>
    </html>
    Process finished with exit code 0

Tambien se puede escribir esto en un archivo añadiendo una anotacion de archivo al inicio, y pasar el writer en el builder

    FileWriter writer = new FileWriter('html/about.html')
    MarkupBuilder builder = new MarkupBuilder(writer)

Lo que crea el archivo about.html en la careta html al ejecutar el codigo, con el codigo en HTML

    <html>
    <head>
        <title>About Liliam Bolanos</title>
        <description>This is an about me page</description>
        <keywords>Liliam Bolanos, Groovy, Java, Spring</keywords>
    </head>
    <body>
        <h1>About me</h1>
        <p>This is a bunch of text about me...</p>
        <section>
        <h2>Courses</h2>
        <table>
            <tr>
            <th>id</th>
            <th>name</th>
            </tr>
            <tr>
            <td>1</td>
            <td>Apache Groovy</td>
            </tr>
            <tr>
            <td>2</td>
            <td>Spring Boot</td>
            </tr>
        </table>
        </section>
    </body>
    </html>


 /************************************************/
# Seccion 11 - 98:
MarkupBuilder - XML

https://groovy-lang.org/api.html
>> groovy.xml  >> MarkupBuilder

Se crea un script xml.groovy, se tiene un builder llamando a un metodo llamado sports. Se puede pasar un closure a un metodo y se puede omitir los parentesis, solo usando las llaves. Y como para builder no se encontrara un metodo llamado sports, este es un metodo Invoke o missing method. Dentro se contrut¿yen nodos individuales con atributos mapeados.


    import groovy.xml.MarkupBuilder
    MarkupBuilder builder = new MarkupBuilder()

    builder.sports {
        sport(id:1) {
            name 'Baseball'
        }
        sport(id:2) {
            name 'Baskeball'
        }
        sport(id:3) {
            name 'Football'
        }
        sport(id:4) {
            name 'Hockey'
        }
        sport(id:null) {
            name ''
        }
        
    }

Y al ejecutar se obtiene en formato XML

    <sports>
    <sport id='1'>
        <name>Baseball</name>
    </sport>
    <sport id='2'>
        <name>Baskeball</name>
    </sport>
    <sport id='3'>
        <name>Football</name>
    </sport>
    <sport id='4'>
        <name>Hockey</name>
    </sport>
    </sports>
    Process finished with exit code 0


al añador un nodo mas 

	sport(id:null) {
        name ''
    }

y ejecutar nuevamente se ve para esa seccion se ve un atributo vacio

    <sport id=''>
        <name></name>
    </sport>
  
otro ejemplo es añadir las anotaciones 

    builder.omitEmptyAttributes = true
    builder.omitNullAttributes = true

y añadir un nodo:

	sport(id:null, foo:'') {
        name ''
    }

se obtiene como resultado sports como el nodo sin los vacios o nulos

    <sport>
        <name></name>
    </sport>

 /************************************************/
# Seccion 11 - 97:
Introduccion a Builders  
Es una manera conveniente de build out objetos

 /************************************************/
 # Seccion 10 - 95-96:
Ejercicio

AST Transformations

We looking at a lot of AST Transformations in this section. Now I want you to go through the documentation and find one that we didn't look at and see if you can get it to work on your own.

https://groovy-lang.org/api.html
>> groovy.transform  >> AutoClone

Asiste en la creacion de clases autoclonales. que añade un metodo clonable publico para listar las interfaces que la clase implementa

se crea la clase Person.groovy
 
    package clone
    import groovy.transform.AutoClone
    @AutoClone
    class Person {
    String first, last
    List favItems
    Date since
    }
 
Al hacer el build y revisar en la clase generada Person.class, se ve que la clase implemeta la clase Clonable y que se ha generado un metodo clone()

        @Generated
        public Person clone() throws CloneNotSupportedException {
            Object _result = ((Class)ScriptBytecodeAdapter.invokeMethodOnSuper0(Person.class, this, (String)"clone")).cast<invokedynamic>(ScriptBytecodeAdapter.invokeMethodOnSuper0(Person.class, this, (String)"clone"));
            if (this.favItems instanceof Cloneable) {
                List var2 = ((Class)InvokerHelper.class.invoke<invokedynamic>(InvokerHelper.class, this.favItems, "clone", (Object)null)).cast<invokedynamic>(InvokerHelper.class.invoke<invokedynamic>(InvokerHelper.class, this.favItems, "clone", (Object)null));
                ScriptBytecodeAdapter.setProperty(var2, (Class)null, _result, (String)"favItems");
            }

            Object var10000 = ScriptBytecodeAdapter.compareEqual((Object)null, this.since) ? null : this.since.invoke<invokedynamic>(this.since);
            Date var3 = ((Class)var10000).cast<invokedynamic>(var10000);
            ScriptBytecodeAdapter.setProperty(var3, (Class)null, _result, (String)"since");
            return _result.cast<invokedynamic>(_result);
        }
	

Crear el script clonedemo.groovy

    package clone

    def p = new Person(first:'John', last:'Smith', favItems:['ipod', 'shiraz'], since:new Date())
    def p2 = p.clone()

    assert p instanceof Cloneable
    assert p.favItems instanceof Cloneable
    assert p.since instanceof Cloneable
    assert !(p.first instanceof Cloneable)

    assert !p.is(p2)
    assert !p.favItems.is(p2.favItems)
    assert !p.since.is(p2.since)
    assert p.first.is(p2.first)


 /************************************************/
# Seccion 10 - 94:
Builder
es usado para ayuader a escribir clases que pueden ser creadas ussando algo llamado fluent API calls. permite una nueva manera de contruir objetos (objetos de objetos tambien)
https://groovy-lang.org/api.html
>> groovy.transform.builder  >> Builder

en este ejemplo se usara defaultStrategy

crear la clase Developer.Groovy

    package builder
    import groovy.transform.ToString
    import groovy.transform.builder.Builder

    @Builder
    @ToString(includeNames = true)
    class Developer {
        String firstName
        String lastName
        String middleInitial
        String email
        Date hireDate
        List languages
    }

y luego el script default.groovy

En vez de instanciar el objeto se llama directamente al metodo build
ya con esto se puede llamar a los setters para cada propiedad

    package builder
    Developer lili = Developer
            .builder() 

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

imprime 

    builder.Developer(firstName:Liliam, lastName:Bolanos, middleInitial:P, email:lbolanos@gmail.com, hireDate:Mon Feb 24 18:21:09 COT 2025, languages:[Java, Groovy])
    y el proceso termina con exito

// es otra manera de instanciar un objeto usando la anotacion builder


 /************************************************/
# Seccion 10 - 93:
CompileStatic

CompileStatic trabaja de la mno con TypeChecked. permite al compilador de groovy usar la anotacion TypeChecked en la misma forma que Java como Static compilation, similar a Javabyte code.

https://groovy-lang.org/api.html
>> groovy.transform  >> CompileStatic

Ejemplo SomeClass.groovy

    package compile
    import groovy.transform.CompileStatic
    import groovy.transform.TypeCheckingMode

    @CompileStatic
    class SomeClass {

        String foo(){
            "foo"
        }
        String bar(){
            "bar"
        }

        @CompileStatic(TypeCheckingMode.SKIP)
        void noReturn(){
        }
    }


 /************************************************/
# Seccion 10 - 92:
TypeChecked

https://groovy-lang.org/api.html
>> groovy.transform  >> TypeChecked

Para chequeo de typo en tiempo de compilacion

creo la clase persona con un metodo para obtener el nombre completo. lo que hara dicho metodo es retornar la union de las vbles

    package typechecked

    class Person {
        String firstName
        String lastName

        String getFullName(){
            "$firstName $lastName"
        }
    }

pero que pasa por ejemplo si en el metodo se coloca un error de typeo

    String getFullName(){
        "$firstName $lastname"
    }

que aunque en el codigo se vera marcada, no necesariamente se sabe que es lo que ocurre, y no es un error de tiempo de compilacion necesariamente. si se trata de hacer compilacion (Build > Compile Person), termina con exito, por no ser un problema de compilacion. Lo que se puede hacer en este caso es añadir la anotacion de TypeChecked, lo que quiere decir que todo en la clase sera revisado en typeo. Tambien se puede añadir individualmete a metodos o propiedades.

    package typechecked
    import groovy.transform.TypeChecked

    @TypeChecked
    class Person {
        String firstName
        String lastName

        String getFullName(){
            "$firstName $lastname"
        }
    }

al ejecutar se obtiene un error de compilacion

    Groovyc: [Static type checking] - The variable [lastname] is undeclared.


si se repara la variable lastname por lastName, y se vuelve a compilar funciona con exito


 /************************************************/
 # Seccion 10 - 91:
Immutable
Una vez que se crea una instancia de alh¿go no se puede cambiar su estado
https://groovy-lang.org/api.html
>> groovy.transform  >> Immutble

Se crea la clase Person.groovy con los AST de ToString y Immutable

    package immutable
    import groovy.transform.Immutable
    import groovy.transform.ToString

    @ToString
    @Immutable
    class Person {
        String first
        String last
}


y por otro lao el script app.groovy

    package immutable
    Person p= new Person("Liliam", "Bolanos")
    println p.toString()
    p.first = "Andy"

Al ejecutar esto se obtiene un error que indica que no se puede cambiar el estado, si se va a ver Person.class. se ve que tiene metodo final y variables privadas. no hay Setters para esos camos en particular


  /************************************************/
# Seccion 10 - 90:
Sorteable
Para el ordenamiento de objetos o clases
Implementa la interfaz comparable

https://groovy-lang.org/api.html
>> groovy.transform  >> Sorteable

Se crea la clase Person.groovy

    package sorted
    import groovy.transform.Canonical
    @Canonical
    class Person {
        String first
        String last
    }

Y en el script app.groovy

    package sorted
    Person p1= new Person("Liliam", "Bolanos")
    Person p2= new Person("Kelly", "Bolanos")
    Person p3= new Person("Fernando", "Bolanos")
    Person p4= new Person("Antonio", "Bolanos")

    def bolanos =[p1,p2,p3,p4]
    println(bolanos)

al ejecutar esto imprime la lista en el orden de creacion:

    [sorted.Person(Liliam, Bolanos), sorted.Person(Kelly, Bolanos), sorted.Person(Fernando, Bolanos), sorted.Person(Antonio, Bolanos)]


pero a cambiar la linea de impresion con el toSorted()

    println(bolanos.toSorted())

Se va a la definicion de ToSorted donde se ve que es una ordenacion iterable, y asume que los elementos son coparables, pero en si aun no hay forma de ordenarlos pues no sabe como ordenarlos, entonces se puede uase el estandar Java para implementar  la interfaz de comparacion. para esto se añade la anotacion Sorteabe en  la clase persona

    package sorted
    import groovy.transform.Canonical
    import groovy.transform.Sortable

    @Canonical
    @Sortable
    class Person {
        String first
        String last
    }

Al ejecutar nuevamente el script imprime

    [sorted.Person(Antonio, Bolanos), sorted.Person(Fernando, Bolanos), sorted.Person(Kelly, Bolanos), sorted.Person(Liliam, Bolanos)]

se añade una persona

    Person p5= new Person("Jason", "NotBolanos")

y al volver a ejecutar se obtiene

    [sorted.Person(Antonio, Vega), sorted.Person(Fernando, Vega), sorted.Person(Kelly, Vega), sorted.Person(Liliam, Vega)]


Con el Sort se puede incluir un orden o campos en particular

    package sorted

    import groovy.transform.Canonical
    import groovy.transform.Sortable

    @Canonical
    @Sortable (includes = ['last','first'])
    class Person {
        String first
        String last
    }

y al ejecutar de nuevo

    package sorted

    Person p1= new Person("Liliam", "Bolanos")
    Person p2= new Person("Kelly", "Bolanos")
    Person p3= new Person("Fernando", "Bolanos")
    Person p4= new Person("Antonio", "Bolanos")
    Person p5= new Person("Jason", "NotBolanos")

    def bolanos =[p1,p2,p3,p4,p5]
    println bolanos.toSorted()


se obtiene el orden de apellido luego nombre

    [sorted.Person(Jason, NotaVega), sorted.Person(Antonio, Vega), sorted.Person(Fernando, Vega), sorted.Person(Kelly, Vega), sorted.Person(Liliam, Vega)]


 /************************************************/
# Seccion 10 - 89:
Singleton
Es una manera de hacer que una clase siga cierto estandar. En Java solo se puede tener una instancia de la clase en existenca (metodo estatico y contructor privado)
En groovy se puede añadir el AST Singleton


https://groovy-lang.org/api.html
>> groovy.transform  >> Singleton

Crea la clase DatabaseConnection.groovy y se coloca el singleton

    package singleton
    @Singleton
    class DatabaseConnection {
    }

Luego en el script de app.groovy

    package singleton
    DatabaseConnection dbConnection = new DatabaseConnection()
    println(dbConnection)

si se ejecuta en este punto se obtiene un error, pues solo se puede acceder a la isnancia atravez del metodo estatico, y lo que se hara es ir al codigo generado de la clase DatabaseConnection.class

Hay una  public static final DatabaseConnection instance, asi que se puede acceder por medio del metodo getInstance()

ahora en el archivo app.groovy

    package singleton

    DatabaseConnection db = DatabaseConnection.instance
    println(db)

Y al ejecutarlo ya no presenta error y se obtiene

    singleton.DatabaseConnection@54107f42

Entonces el singleton permite seguir el patron singleton y se debe asegurar que solo exista una instancia de esa clase.


 /************************************************/
# Seccion 10 - 88:
Canonical
Esta es la mezcla de las 3 anteriores ToString, EqualsAndHashCode y TupleConstructor

https://groovy-lang.org/api.html
>> groovy.transform  >> Canonical

En la clase Person.groovy

    package canonical
    import groovy.transform.Canonical

    @Canonical
    class Person {
        String first
        String last
        String email
    }

Y en el sript app.Groovy se escribe:

    package canonical

Haciendo uso de TupleConstructor se crea una persona

    Person p1= new Person("Liliam", "Bolanos", "lbolanos@mail.com")
    Person p2= new Person("Liliam", "Bolanos", "lbolanos@mail.com")

Con el assert se hace uso del EqualsAndHashCode

    assert p1 == p2

Y finalmente se hace uso del ToString 

    print p1.toString()

al ejecutar se obtiene resultado exitoso con la impresion de P1

    canonical.Person(Liliam, Bolanos, lbolanos@mail.com)


 /************************************************/
 # Seccion 10 - 87:
TupleConstructor

https://groovy-lang.org/api.html
>> groovy.transform  >> TupleConstructor

se usa cuando no se nombran los parametros cuando se define el objeto

Comienza definiendo la clase Person.groovy

    package tuple
    import groovy.transform.ToString
    import groovy.transform.TupleConstructor

    @ToString
    @TupleConstructor
    class Person {
        String first
        String last
        String email
    }

Y en el scrips app.groovy se coloca

    package tuple
    Person p= new Person("Liliam", "Bolanos", "lbolanos@mail.com")
    print p.toString()

y al ejecutar esta parte se obtiene los datos tal como los presenta en a clase:

    tuple.Person(Liliam, Bolanos, lbolanos@mail.com)


 /************************************************/
# Seccion 10 - 86:
Equals and HashCode AST transformations

https://groovy-lang.org/api.html
>> groovy.transform  >> EqualsAndHashCode

Reusamos la clase PersonPerson

    package equals
    import groovy.transform.ToString

    class Person {
        String first
        String last
        String email
    }

Y en el script app.groovy escribe

    package equals
    Person p1= new Person(first:"Liliam", last:"Bolanos", email:"lbolanos@mail.com")
    Person p2= new Person(first:"Liliam", last:"Bolanos", email:"lbolanos@mail.com")
    assert p1==p2

que al ejecutarlo, falla, pues la applicacion no sabe que significa el igual (==), pues solo referencia a la instancia actual, y para este las instancias son diferentes

lo que se debe hacer en Groovy es usar Equals y hashCode, para esto vamos a la clase person

    package equals
    import groovy.transform.EqualsAndHashCode
    @EqualsAndHashCode
    class Person {
        String first
        String last
        String email
    }

Y al volver a ejecutar el script se obtione resultado exitoso. Esta es la forma en que el programa entiende la igualdad, pues ya sabe que son propiedades iguales

Al hacer cambio en una de las instancias

    package equals
    Person p1= new Person(first:"Liliam", last:"Bolanos", email:"lbolanos@mail.com")
    Person p2= new Person(first:"Liliam", last:"Bolanos", email:"lbolanos@work.com")
    assert p1==p2

si se ejecuta en este momento se obtendra error pues no son iguales. lo que se puese hacer en este casi es que puede seguir obteniendo la igualdad al excluir el parametro en la clase afectado

    @EqualsAndHashCode(excludes = ["email"])

Al ejecutar el script, el proceso termina exitosamente de nuevo.


 /************************************************/
# Seccion 10 - 85:

Anotacion ToString

https://groovy-lang.org/api.html
>> groovy.transform  >> ToString

Se crea la clase Person.groovy 

    class Person {
        String first
        String last
        String email
    }

se presiona en windows click derecho o en mac Cmd+N en la seccion de definicion de vbles, Luego presionar Generar.. > toString(), para generar las propiedades que se dese incluir.
y se crea este codigo dentro de la clase el metodo ToString

    package tostring
    class Person {
        String first
        String last
        String email

        @Override
        public String toString() {
            return "Person{" +
                    "first='" + first + '\'' +
                    ", last='" + last + '\'' +
                    ", email='" + email + '\'' +
                    '}';
        }
    }


Crear un script llamado app.groovy

    package tostring
    Person p= new Person(first:"Liliam", last:"Bolanos", email:"lbolanos@mail.com")
    print p.toString()

que al ejecutarlo se obtiene:

    Person{first='Liliam', last='Bolanos', email='lbolanos@mail.com'}

El problema con esta forma es el alto costo de mantenimiento del metodo.

asi que otra forma de trabajarlo es, añadir la anotacion para el metodo toString asi que la clase queda de la siguiente forma

    package tostring
    import groovy.transform.ToString
    @ToString
    class Person {
        String first
        String last
        String email
    }

y al ejecutar nuevamente el script app.groovy se obtiene:

    tostring.Person(Liliam, Bolanos, lbolanos@mail.com)

Ahora se añade al ToString includeNames

    @ToString (includeNames = true)

Y al ejecutar nuevamente el script se obtiene el resultado incuyendo el nombre de las vbles:

    tostring.Person(first:Liliam, last:Bolanos, email:lbolanos@mail.com)

Tambien se puede usar otros metodos como Excludes, ejemplo

    tostring.Person(first:Liliam, last:Bolanos, email:lbolanos@mail.com)
    que imprime:
    tostring.Person(first:Liliam, last:Bolanos)


Si se va a la carpeta de salida Out... y se busca la clase generada Person.class, se puede ver los AST generados para Tostring. dada la complejidad es bueno usar las anotaciones para este caso.


 /************************************************/
# Seccion 10 - 84:

Compile Time Metaprogramming  
ATS Transformations

 /************************************************/
# Seccion 9 - 82-83:
Ejercicio

Runtime Metaprogramming

*GroovyObject*  
Create a class and implement each of the following methods from the GroovyObject Interface  
invokeMethod  
getProperty  
setProperty  

    Developer.groovy

    class Developer {
        String first
        String last
        String email
        List languajes

        Developer(){}

        def invokeMethod (String name, Object args){
            println("invokeMethod() called with args $args")
        }

        def getProperty (String property){
            println("getProperty method called...")
            metaClass.getProperty(this,property)
        }
        void setProperty (String property, Object newValue){
            println("setProperty() called with name $property and newValue $newValue")
            metaClass.setProperty(this,property,newValue)
        }
    }

Se crea un objeto developer añadiendo un metodo o llamando un metodo a developer que no existe  

    GroovyObjectDemo.Groovy

    Developer developer = new Developer(first: "Liliam", last:"Bolanos", email: "lbolanos@gmail.com")
    developer.writeCode("Groovy")
    println(developer.first)
    developer.languajes=["Groovy","Java"]


Imprime:  

    invokeMethod() called with args [Groovy]
    getProperty method called...
    Liliam
    setProperty() called with name languajes and newValue [Groovy, Java]



*Expando*  
Create an Expando Class  
Add some properties and methods to it  
Knowing that a class's metaclass is an expando to create your own class and add properties and methods to it.  

    ExpandoDemo.Groovy

    Expando e = new Expando()

    e.first = "Lili"
    e.last = "BolanosR"
    e.email = "lbolanos1@gmail.com"

    e.getFullName = {
        "$first $last"
    }

    println(e.toString())
    println(e.getFullName())


Imprime

    {last=BolanosR, getFullName=ExpandoDemo$_run_closure1@610db97e, first=Lili, email=lbolanos1@gmail.com}
    Lili BolanosR

Este es el resultado de expando


Lo siguiente sucede en tiempo de compilacion

    @groovy.transform.ToString(includeNames = true)
    class Person {
        String first, last
    }

    Person p = new Person(first:"LiliamP", last: "BolanosR1")
    p.metaClass.email = "lbolanos2@gmail.com"
    println(p)
    println(p.email)

Imprime:  

    Person(first:LiliamP, last:BolanosR1)
    lbolanos2@gmail.com


*Times Two*  
Add a new method to the Integer class called `timesTwo`  
This method should be available to any instance of Integer  
What is another approach that we can take to create this method that would be a little more controlled?

    SquareDemo.groovy
    Integer.metaClass.timesTwo = { delegate*2}

    println(2.timesTwo())
    println(4.timesTwo())
    println(5.timesTwo())
    println(10.timesTwo())

Imprime  
        4
        8
        10
        20


 /************************************************/
 # Seccion 9 - 81:

Intercept / Cache /Invoke Pattern  

    InterceptCacheInvoke.groovy

    class Developer{
        def methodMissing (String name, args){
            println "${name}() method was called..."
        }
    }
    Developer dan = new Developer()
    dan.writeGroovy()

Imprime: 

    InterceptCacheInvoke

Otro ejemplo:  
Intercept - Cache - Invoke pattern

    class Developer{

        List languages = []

        def methodMissing (String name, args){
            println "${name}() method was called..."
            if(name.startsWith('write')){
                String language = name.split("write")[1]
                if(languages.contains(language)){
                    def impl = { Object[] theArgs ->
                        println "I like to write code in $language"
                    }
                    getMetaClass()."$name" = impl
                    return impl(args)
                }
            }
        }
    }
    Developer dan = new Developer()
    dan.languages << "Groovy"
    dan.languages << "Java"
        println dan.metaClass.methods.size()
    dan.writeGroovy()
    dan.writeGroovy()
    dan.writeGroovy()
        println dan.metaClass.methods.size()
    dan.writeJava()
    dan.writeGroovy()
    println dan.metaClass.methods.size()

La primera vez se llama el metodo Missing, pero una vez ya se ha llamado lo ejecuta como si existiera. y solo vuelve a llamarlo cuando cambia el llamado a otro valor  
Esto es lo llamado Intercept cache invoke pattern, que es un performance boost

 /************************************************/
# Seccion 9 - 80:
Categorias de clases

        catdemo.groovy
        String.metaClass.shout = { -> toUpperCase()}

        println "Hello, World!".shout()

Imprime  

    HELLO, WORLD!

El problema aqui es que se esta añadindo un metodo a la clase restringida String  
Entonces la no se sabe que el metodo exite a menos que se defina en una API  
Asi que no es una buena idea y por eso es bueno crear una Clase Categoria

        StringCategory.groovy

        class StringCategory {
            static String shout(String str){
                str.toUpperCase()
            }
        }

La manera en que se usa la clase categoria es el use  
Lo llamado dentro de esa clase categoria es como un metodo nativo


        catdemo.groovy

        use (StringCategory) {
            println "Hello, World!".shout()
        }   

Imprime  
        
    HELLO, WORLD! al igual que lo hizo de la anterior forma. sin embargo si se hace el llamado fuera del metodo use se genera un error groovy.lang.MissingMethodException: No signature of method

Una clase que esta ya definida es TimeCategory.  

        time.groovy

        import groovy.time.TimeCategory

        use(TimeCategory){
            println 1.minute.from.now  //  Wed Feb 12 18:32:48 COT 2025
            println 10.hours.ago   //  Wed Feb 12 08:31:48 COT 2025

            def someDate = new Date()
            println someDate - 3.months  // Tue Nov 12 18:31:48 COT 2024
        }

 /************************************************/
# Seccion 9 - 79:
MetaClass

Crear el pryecto meta-class-79
crear el archivo de groovy MetaClassDemo en el src  

        Meta class demo
        class Developer {
        }
        Developer lili = new Developer()
        println "Hello Lili..."

Colocar un breakpont permite detener la ejecucion del programa en el punto indicado  
Para despues usar el debbuger y evaluar que esta pasando en el programa  
Al ejecutar el debug indica que la variable lili pertenece a metaclass. por tanto lo  puede llamar. 
Ejemplo  

        lili.metaClass

EXPANDO  

        class Developer {
        }
        Developer lili = new Developer()
        Expando e = new Expando()

Dentro de la clase expando se puede ver que representa a una expansion dinamica de bean  
Es decir que se puede añador campos y metodos que Expando no tiene

        e.name= 'Liliam'
        e.writeCode = {->println "$name Loves to write code..."}
        e.writeCode()

Imprime:  
        Liliam Loves to write code...
        Process finished with exit code 0

Si se añade una segunda instanci falla:  

        Expando e2 = new Expando()
        e2.writeCode()
Imprime un error:  

        Caught: groovy.lang.MissingMethodException: No signature of method: groovy.util.Expando.writeCode() is applicable for argument types: () values: []*/



Una meta clase en realidad es una Expando  

        class Developer {
        }

Por instancia

        Developer lili = new Developer()
        lili.metaClass.name = 'Lili'
        lili.metaClass.writeCode = {->println "$name Loves to write code..."}
        lili.writeCode()

Imprime  

        Lili Loves to write code...
        Process finished with exit code 0

Dado que la metaclase se ha asociado a la llamada, la meta clase sabe como manejar el metodo

Para toda instancia.  
Se debe tener cuidado, pues esta modificando una isntancia general y eso es peligroso

    String.metaClass.shout = { -> toUpperCase()}
    println "Hello Liliam".shout()

Imprime  

    HELLO LILIAM
    Process finished with exit code 0


 /************************************************/
# Seccion 9 - 78:

Creo el archivo MOP.txt con la descripcion:

        - GroovyObject
        - Employee.groovy
        - invokeMethod()
        - get property
        - property missing
        - set property
        - method missing


Class de nombre Employee, sin ningún cambio, lo dejamos tal cual.

        package com.groovycourse
        class Employee {
        }

Creo un simple Groovy Script de nombre InvokeMethodDemo, empezamos a colocar esto en el código:  

Este metodo es llamado cuando cuando el metodo llamado no esta presnete en el Objeto de Groovy  

        package com.groovycourse
        class InvokeDemo {
            def invokeMethod (String name, Object args){
                return "called invokeMethod $name $args"
            }

            def test(){
                return "Method exists"
            }
        }

        def invokeDemo = new InvokeDemo()
        assert invokeDemo.test() == "Method exists"
        assert invokeDemo.someMethod() == "called invokeMethod someMethod []"


Creo GetPropertyDemo.groovy

Cada lectura de acceso a una propiedad puede ser interceptada por sobreescritura del metodo getproperty() del objeto actual.  

        package com.groovycourse
        class PropertyDemo {
            def prop1 = "prop1"
            def prop2 = "prop2"
            def prop3 = "prop3"

            def getProperty (String name){
                println "getProperty() called with argument $name"

                if(metaClass.hasProperty(this,name)){
                    metaClass.hasProperty(this,name)
                }else{
                    println "lets do something fun with this property"
                    return "party time..."
                }
                // return
                //metaClass.getProperty(this,name)
            }
        }

        def pd = new PropertyDemo()
        //get property
        println pd.prop1
        println pd.prop2
        println pd.prop3
        //property missing
        println pd.prop4

Ejecuto y obtengo esto:  
    getProperty() is called with argument prop1
    prop1
    getProperty() is called with argument prop2
    prop2
    getProperty() is called with argument prop3
    prop3
    getProperty() is called with argument prop4
    lets do something fun with this property
    party time...

PropertyMissingDemo.groovy  
Groovy supports the concept of propertyMissing for intercepting failing property resolution attemps  

        class Foo{
            def propertyMissing(String name){
                "caught missing property: $name"
            }
        }

        println new Foo().bar

Doy click derecho y selecciono Run 'PropertyMissingDemo', y obtengo esto:  
        caught missing property: bar
        Process finished with exit code 0


Crear archivo SetPropertyDemo.groovy  

Se puede interceptar el acceso de escritura a las propiedades sobreescribiendo el metodo setProperty()  

        package com.groovycourse
        class POGO {
            String property

            void setProperty(String name, Object value){
                this.@"$name" ='overridden'
            }
        }

        def pogo = new POGO()
        pogo.property='a'

        assert pogo.property == 'overridden'

Ejecuto con click derecho y obtengo cero errores, todo ok


Creo un simple Groovy Script de nombre MissingMethodDemo, 

Groovy soporta el concepto de MethodMissing(). este metodo difiere del de invocacion en que ese es unico. Es invocado en caso de que falle el metodo dispatch, cuando el metodo no puede ser encontrado por el nombre dado y/o los argumentos dados.  

    package com.groovycourse

    import org.codehaus.groovy.runtime.metaclass.MissingMethodExceptionNoStack
    class MyEmployee {
        def methodMissing(String name, def args){

            if( name != 'someMethod' ){
                throw new MissingMethodException(name,args)
            }

            println "Method missing called on: $name"
            println "with argument ${args}"
        }
    }

    MyEmployee emp = new MyEmployee()
    emp.someMethod(1,2,3)
    /*Imprime
    Method missing called on: someMethod
    with argument [1, 2, 3]
    */
    emp.someOtherMethod(4,5,6)

Ejecuto y obtengo lo siguiente  

    Method Missing called on: someMethod
    with arguments [1, 2, 3]
    -Caught: groovy.lang.GroovyRuntimeException: Could not find matching constructor for: groovy.lang.MissingMethodException(String, [Ljava.lang.Object;)
    -groovy.lang.GroovyRuntimeException: Could not find matching constructor for: groovy.lang.MissingMethodException(String, [Ljava.lang.Object;)
    -	at com.domain_name.MyEmployee.methodMissing(MissingMethodDemo.groovy:8)
    -	at com.domain_name.MissingMethodDemo.run(MissingMethodDemo.groovy:17)

Process finished with exit code 1


 /************************************************/
# Seccion 9 - 77:
Meta Object protocol (MOP)  
La metaprogramacion es la escritura de progamas de pc que escriben o manipulan otros programas.  
MOP: coleccion de reglas de como una solicitud de llamada a un metodo es llamada por el sistema en tiempo de ejecucion y coo controlar la capaintermedia.  
 
Entonces, cuando hablamos de llamadas desde Groovy, en realidad podríamos estar tratando con tres tipos diferentes de objetos, ¿cierto?

POJO.  
Tenemos un objeto Java normal cuya clase puede escribirse en Java o en cualquier otro lenguaje para la JVM.

POGO.  
objeto Groovy cuya clase está escrita en Groovy. Extiende java.lang.object e implementa la interfaz de objeto Groovy Feeling de Groovy de manera predeterminada.

Groovy interceptor.  
Y un interceptor Groovy es un objeto que implementa la interfaz Groovy Interceptable y tiene una capacidad de interceptación de métodos. 

Entonces, estos son los tres tipos diferentes de objetos con los que Groovy va a trabajar y, en función de cuál tenga, tomará una ruta diferente.

 /************************************************/
 # Seccion 9 - 76:
*Runtime Metaprogramming*  
Grovy es un lenguaje dinamico, muchas de esas capacidades vienen de la metaprogramacion  

 /************************************************/

# Seccion 8 - 74-75:
Ejercicio

What makes up a class  
Tweet  
We are going to create a class that represents a single tweet. This is an exercise both about code and starting to think about what goes into building a class. There is no right or wrong answer here so don't be afraid to build your class how you see fit. I will go over in the review what I was thinking about when I built mine but again my answer is not the right one.   
What properties and methods go into building a tweet class?   
Bonus Points  
How could you extract mentions and hashtags from the post text?   

    @groovy.transform.Canonical
    class Tweet {
        String post // message
        String username
        Date postDateTime
        
        private List favorites = []
        private List retweets = []
        private List mentions = []
        private List hashtags = []
        
        // Implementacion de metodos
        void favorite(String username){
            favorites << username
        }
        List getFavorites(){
            favorites
        }
        void retweets(String username){
            retweets << username
        }
        List getRetweets(){
            retweets
        }
        List getMentions(){
            String pattern = /\B@[a-z0-9_-]+/
            post.findAll(pattern)
        }
        List getHashTags(){
            String pattern = /(?:\s|\A)[##]+([A-Za-z0-9-_]+)/
            post.findAll(pattern)
        }
    }

    Tweet tweet = new Tweet (post:"Avance del curso groovy seccion 8 @therealdanvega #Java #groovylang", username:"@lbolanos", postDateTime: new Date() )
    println tweet
    // Imprime: Tweet(Avance del curso groovy seccion 8, @lbolanos, Fri Jan 31 17:15:33 COT 2025)

    tweet.favorite("@ApacheGroovy")
    tweet.retweets("@ApacheGroovy")

    println tweet.getFavorites()   // imprime [@ApacheGroovy]
    println tweet.getRetweets()   // imprime [@ApacheGroovy]

    println tweet.getMentions()   // imprime [@therealdanvega]
    println tweet.getHashTags()   // imprime [ #Java,  #groovylang]


 /************************************************/
# Seccion 8 - 73:
Groovy beans
Es como un eatandar, una clase con estandares para seguir
- Todas las propiedades privadas (Uso de getters y setters)
- Constructor publico sin argumentos
- Implementar serializable
	java provee un mecanismo, llamado objeto de serializacion donde un objeto puede ser representado como una secuenca de bytes que incluye esa data del objeto, asi como la informacion sobre el tupo de dato y los tipos de dato almacenados en el objeto.

- Crear Java Bean
- Equivalencia en groovy Bean
- Ver que ocurre por debajo de un groovy bean
- Como usar Groovy beans
- Como escribir tus getters /Setters
- Acceso directo a campos


Clase Java de ejemploEmployeeBean.java

    package com.groovycourse;

    import java.io.Serializable;

    public class EmployeeBean implements Serializable {
        private String first;
        private String last;
        private String email;

        public EmployeeBean() {
        }

        public String getFirst() {
            return this.first;
        }

        public void setFirst(String first) {
            this.first = first;
        }

        public String getLast() {
            return this.last;
        }

        public void setLast(String last) {
            this.last = last;
        }

        public String getEmail() {
            return this.email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String toString() {
            return "EmployeeBean{first='" + this.first + "', last='" + this.last + "'}";
        }
    }

Uno de los problemas de java , es que hay mucho ruido, en el ejemplo anterior solo hay 3 campos pero hay demasiada data. y por esto se puede incrementar cosiderablemente el mantenimiento e codigo.

*En groovy*  
Employee.groovy  
package com.groovycourse  
    import groovy.transform.ToString
    @ToString

    class Employee implements Serializable {
        String first, last, email
// Se necesitan Get/ y set para estos campos, para ello se pasan los campos a privados por debajo  
// Para ello lo que se debe jhacer es Implementar la clase Serializable  
// Al hacer Build > Compile de esta clase se crea la carpeta out, y dentro la el archivo Employee.class  
// Donde se van a generar los argumentos privados, contructor sin argumentos , Getters y settes  

        String fullName
        // Se puede escribir sus propios get and set si asi se desea
        void setFullName(String name){
            fullName=name
        }
        String getFullName(){
            "Full Name: ${fullName}"
        }
    }



DoubleBean.groovy  
package com.groovycourse

    class DoubleBean {
        public Integer value
        // un valor publico podra accederse desde la instancia

        void setValue(value){
            this.value=value
        }
        Integer getValue(){
            value * 2
        }
    }

app.groovy  
package com.groovycourse

Forma 1: Una forma de validar la clse empleado

        Employee emp = new Employee(first: "Liliam",last: "Bolanos",email: "lb@email.com")
        println emp

        Imprime
        com.groovycourse.Employee(Liliam, Bolanos, lb@email.com)
        Process finished with exit code 0



Forma 2:

        Employee emp = new Employee()
        emp.first = "Lili"  // esta es la equivalencia de set first
        println emp.first // equivalencia al setter

        imprime : Lili


Forma 3:

        DoubleBean db = new DoubleBean()
        db.value=100

        println db.value  // imprime 200
        println db.@value  // imprime 100... el valor asignado aca sin llamar al getter


 /************************************************/
# Seccion 8 - 72:
Traits
Permite componer capacidades en las clases. Se puede heredar tarits
la diferencia es que un trat puede tener un estado

En java 8 se puede generar una interfaz de este tipo 

IPersonService.java
default public interface IPersonService {
    public void doSomenting(){
        System.out.println("doing somenting...");
    }
}

Una intefaz no tiene un cuerpo en el metodo en Java 7, pero 8 implemento esa capacidad
Al hacer el metodo default puede implementarse dentro del metodo.

docs.groovy-lang.org/next/html/documentation/core-traits.html


FlyingAbility.groovy
    String fly(){
        "I'm Flying!"
    }

    abstract String foo() // metodo abstracto, vacio
    //Tambien se puede implemantar metodos privados
    private String bar(){
        "bar"
    }


SpeakingAbility.groovy
package com.cursogroovy.traits

trait SpeakingAbility {

    public String a
    private String b

    String speak(){
        "I'm Speaking!"
    }
}


Bird.Groovy
package com.cursogroovy.traits

class Bird implements FlyingAbility, SpeakingAbility{

    @Override
    String foo() {
        return null
    }

}


app.groovy
package com.cursogroovy

import com.cursogroovy.traits.Bird

Bird b=new Bird()
assert b.fly() == "I'm Flying!"
assert b.speak() == "I'm Speaking!"



/// Process finished with exit code 0
 /************************************************/
# Seccion 8 - 71:
Interfaces

con clic derecho donde se implemeta la interfaz > genetare > implement methods . se selecciona los metodos para sobre escribir



Person.groovy
package com.groovycourse.domain

import groovy.transform.ToString

@ToString
class Person {
    String first, last
}

/**/
IPersonService.Groovy

package com.groovycourse.service;

import com.groovycourse.domain.Person

interface IPersonService {
    // usa metodos abtractos, no se implemeta logica
    Person find()
    List<Person> findAll()
}



/**/

PersonService.Groovy

package com.groovycourse.service

import com.groovycourse.domain.Person

class PersonService implements IPersonService{
    //Esta clasae implemeta la interfaz
    @Override
    Person find() {
        Person p = new Person(first:"Liliam", last:"Bolanos")
        return p
    }

    @Override
    List<Person> findAll() {
        Person p1 = new Person(first:"Liliam", last:"Bolanos")
        Person p2 = new Person(first:"German", last:"Velasco")

        [p1,p2]
    }
}

/**/


app.groovy

package com.groovycourse

import com.groovycourse.service.PersonService

PersonService personService = new PersonService()

println personService.find()

Imprime
com.groovycourse.domain.Person(Liliam, Bolanos)
Process finished with exit code 0

 /************************************************/
# Seccion 8 - 70:

Herencia: se usa con la palabra reservada *extends*

Archivo de clase *Phone.groovy*

        package com.cursogroovy.domain

        class Phone {

            String name
            String os
            String appStore

            def powerOn(){
            }

            def powerOff(){
            }

            def ring(){
            }
        }

Archivo de clase *IPhone.groovy*

        package com.cursogroovy.domain

        import groovy.transform.ToString

        @ToString()
        class IPhone extends Phone {

            String iosVersion

            def homeButtonPressed(){
            }

            def airPlay(){
            }

            @Override
            def powerOn(){
            }
        }

Archivo *app.groovy*

        package com.cursogroovy
        import com.cursogroovy.domain.IPhone

        IPhone phone = new IPhone(name:"iPhone",appStore: "App Store", os: "IOS")
        println(phone)

Al ejecutar, tiene el resultado:

        com.cursogroovy.domain.IPhone(null)
        Process finished with exit code 0


 /************************************************/
# Seccion 8 - 69:

En groovy se debe declarar el uso de paquetes, si no se hace se usa el paquete por defecto

Se crea el proyecto Package demo con paquetes y clases

    paquete com.cursogroovy
    > controller
        >>democontroller.groovy
    >domain
        >>Person.groovy
    >service
        >>PersonService.groovy

 /************************************************/
# Seccion 8 - 68:

Constructores y Metodos

Ejemplo de clase con un constructor  

        class Person{
            // contructores
            public Person(){
                return this
            }
            
            otro ejemplo de contructor con parametros puede ser 
            public Person(String first, last){
                this.first = first
        }
        Person p = new Person()

Constructor por defecto ejemplo:

        @groovy.transform.ToString
        class Person {
            String first, last
            // contructor
        }
        Person p = new Person(first:'Liliam', last:'Bolanos')
        println p   // Person(Liliam, Bolanos), campos construidos por defecto


Constructor propio ejemplo: 

        @groovy.transform.ToString
        class Person {
            String first, last
            // contructores
            Person(String fullName){   // instancia de la clase
                List parts = fullName.split(' ')
                first = parts[0]
                last = parts[1]
            }
        }
        Person p = new Person("Liliam Bolanos")
        println p  // Person(Liliam, Bolanos)

Metodos  

        @groovy.transform.ToString
        class Person {
            String first, last
//contructores  

            Person(String fullName){   // instancia de la clase
                List parts = fullName.split(' ')
                first = parts[0]
                last = parts[1]
            }
    // Metodo en Java
            public void foo(String a, String b){
                //do stuff
            }
    // Metodo en Groovy. por defecto son public. y tampoco se necesita el return
            String getFullName(String a, String b){
                "$first $last"
            }
    // Otra caracteristica de groovy es que no se necesita definir el tipo de retorno
            def bar(){
                // puede ser cualquier tipo inclusive void en el retorno
            }
    //Tambien se pueden crear metodos estaticos
            static String doGoodWork(){
                println "doing good work..."
            }
    //Se puede crear metodos que llaman mas metodos, o metodos argumento

            def someMethod(numbers){  
    // al argumento se le puede o no asignar un tipo. o tambien se le puede colocar valor por defecto
                println "doing good work..."
            }

    // hay casos en los cuales no se sabe cuantos argumentos van a pasar en un metodo  
    //Se puede pasar la variable VarArgs
            def concat (String...args){
                println args.length  
            }
        }
Para los metodos no es necesario definir una instancia de la clase  

        Person.doGoodWork()  // imprime: doing good work...

        Person p = new Person("Liliam Bolanos")
        p.concat('a','b')  // imprime la longitud = 2
 /************************************************/
 # Seccion 8 - 66 - 67:
 Programacion Oriantada a Ojetos

 Clases:
 
    class Person {
        //fields
        String firstName, lastName
        def dob
        // private | protected | public
        protected String f1, f2, f3
        private Date createdOn = new Date()
        
        static welcomeMsg = 'HELLO'  
        //Constante: en java y Groovy se ven en mayúsculas
        public static final String WELCOME_MSG = 'Hello' 
        
        //Local variables: declaradas al interior del metodo, por tanto son locales a ese metodo unicamernte
        // las variables locales a metodo no se confunden con las declase aun cuando tienen el mismo nombre
        def foo(){
            String msg = "Hello you"
            String firstName = "Liliam"
            println "$msg, $firstName"
        }
    }

Prueba de fields  
En la manera normal, Cuando se necesita acceder a la clase se debe crear una instancia
    
    Person p = new Person()

// con un campo elastico se puede acceder a la clase sin necesidad de instanciarla

    println Person.welcomeMsg  // HELLO
    println Person.WELCOME_MSG  // Hello

Prueba de local variables

    def person = new Person()
    person.foo()  //  Hello you, Liliam

 /************************************************/

## Section 7 64-65
 [Exercise] Control Structures  

We used a class similar to this in a previous exercise but I think it's a short and sweet example of what we need to review in this exercise. 

Create An Account Class  
create a property of type BigDecimal called balance with an initial value of 0.0  
Create a method called deposit  
use a conditional structure (if would work great here) to check if the amount being passed is less than zero. If it is we should catch this case because we don't want to deposit negative numbers. In this case, throw an exception.  
Create another method called deposit that takes a list of amounts  
use a for loop to loop over these amounts and call deposit
Now that we have our class let's test it out. You can do all of this in the same file (just don't create a file called Account.groovy)   
Create an instance of the account class  
deposit a valid amount  
deposit an invalid amount (what happens?)  
try / catch on invalid amounts  
deposit a list of amounts. 

Solucion:  

    class Account {
        BigDecimal balance = 0.0
        
        def deposit(BigDecimal amount){
            if ( amount < 0 ){
                throw new Exception ("Deposit amount must be greater than 0")
            }
            balance += amount
        }
        
        def deposit(List amounts){
            for ( amount in amounts ) {
                deposit(amount)
            }
        }
    }

    Account checking = new Account()
    checking.deposit(10)
    println checking.balance

    try {
        checking.deposit(-1)
    }catch (Exception e) {
        println e.message
    }

    println checking.balance

    checking.deposit([1,5,10,20,50])
    println checking.balance

 /************************************************/
## Seccion 7 - 63

Exceptions  
El manejo de excepciones en groovy es similar al de Java. Try-catch  
La diferencia radica en que en groovy las exepciones son opcionales. por tanto no necesitan formar parte del metodo

En Java  

    public void foo() throws Exception{  // esto hace que sea obligatorio en los metodos
        throw new Exception()
    }

En Groovy  

    def foo(){
        // do stuff
        throw new Exception("Foo Exception")
    }

Ejemplo  

        List log = []

        try {
            foo()
        } catch ( Exception e ) {
            log << e.message
        } finally {
            log << 'finally'
        }
        println log   
        //-- imprime [Foo Exception, finally]


        // Java 7 introdujo un multi catch sintaxis

        try {
            //do stuff here
        } catch ( FileNotFoundException | NullPointerException e ) {
            println e.class.name
            println e.message
        }

 /************************************************/
## Seccion 7 - 62

Looping: Construcciones tipo blucle  

*While*

        List numbers=[1,2,3] //lista llena
        while ( numbers ) {
            numbers.remove(0)  // se van removiendo numeros hasta que yas no haya
        }
        assert numbers == [] // al ejecutar el bloque de codigo no sale nada pues la asercion es verdadera


*for*  

    for (vble in iterable){
    }

    List nums=[1,2,3]
    for (i in nums){
        println i 
    } // imprime 1, 2, 3. pues imprime un numero de la lista en cada iteracion

    for (i in 1..10){
        println i 
    }// imprime 1 al 10. pues imprime un numero del rango en cada iteracion


    Closure c = { }

Nota: es importante anotar que aunque la estructura es similar a un closure, son cosas distintas

*return / break / continue*  
En Java se debe hacer retornos en todas partes, pero en groovy se tiene el metodo getFoo() que devuelve un string, que basicamente va a retornar ese string en el final de cada metodo 

        String getFoo(){
            "foo"
        }

        Integer a = 1
        while ( true ) { // loop infinito si no se condiciona
            a++
            break
        }
        assert a == 2 // condicional del loop

        for (String s in 'a'..'z'){
            if (s == 'a') continue
            println s
            if (s > 'b') break
        }  // este bucle imprime b y c


 /************************************************/
## Seccion 7 - 61

Estructuras condicionales
- if (boolean expression){logic}  

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


- Ternary operator '(expression) ? true : false'  
Permite crear una linea corta de expresiones para comprobar y evaluar si una expresion es verdadera, y hacer algo con esa expresion

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


- Switch statement: es diferente que en Java  

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


- IN: se puede usar como expresion para comparar variables.

        def validAges = 18..35
        def someAge =19
        println someAge in validAges  // true



 /************************************************/
## Seccion 7 - 59
groovy-lang.org/semantics.html#_control_structures

## Seccion 7 - 60

Groovy truth  

Una expresion siempre verdadera, ejemplo: 

    if(true) {
        println "true"
    }

- boolean, 				Boolean value es verdadero

        assert true
        assert !false

- Matcher,				Matcher tiene Match (expresiones regulares)

        assert ('a' =~/a/)
        assert !('a' =~/b/)

- Collection,			Coleccion no vacia

        assert [1]
        assert ![]

- Map,					Mapa no vacio

        assert [1:'one']
        assert ![:]

- String,				Cadena no vacia  

        assert 'a'
        assert !''

- Number, Character	Numero no cero

        assert 1
        assert 3.5
        assert !0

- Non of the above,	Objeto referencia que no es null  

        assert new Object()  
        assert !null

Es importante entender como groovy evalua diferentes items, para el uso de los operadores condicionales


 /************************************************/
## Section 6 - 57/58:
https://groovy-lang.org/closures.html
https://groovy-lang.org/api.html
groovy.lang > Classes - Closure

[Exercise] Using Closures
Closure Basics
* Locate the class groovy.lang.Closure and spend a few minutes looking through documentation.
    - Create a Method that accepts a closure as an argument
    - Create a closure that performs some action
    - Call the method and pass the closure to it.
* Create a list and use them each to iterate over each item in the list and print it out
    - Hint - You can use the implicit it or use your own variable
* Create a map of data and iterate over it using each method. 
    - This method can take a closure that accepts 1 or 2 arguments. 
    - Use 2 arguments and print out the key and value on each line.
    - Demonstrate the use of curry and try to come up with an example different from the one we used in the lecture. 


Create a Method that accepts a closure as an argument  

        def mymethod(Closure c){
            c()
        }

Create a closure that performs some action  

        def foo ={
            println "foo"
        }

Call the method and pass the closure to it.  

        mymethod(foo) // imprime el contenido del print = foo

Create a list and use them each to iterate over each item in the list and print it out  

        List names = ["Dan Vega","Joe Vega","Andy vega","Katie Vega"]
        names.each{ name ->
            println name
        }Imprime  Dan Vega, Joe Vega, Andy vega, Katie Vega en cada linea

Create a map of data and iterate over it using each method.   

        Map teams = [baseball:"Cleveland Indians", basketball:"Cleveland Cavs", football:"Cleveland Browns"]
        teams.each{k,v ->
            println "$k = $v"
        } // imprime baseball = Cleveland Indians, basketball = Cleveland Cavs, football = Cleveland Browns

Demonstrate the use of curry and try to come up with an example different from the one we used in the lecture.  

        def greet = {String greeting, String name ->
            println "$greeting, $name"
        } 
        greet ("Hello","Liliam") // Hello, Liliam

        def sayHello = greet.curry("Hello")
        sayHello("Paola") // Hello, Paola


Explore the GDK
In the following exercises we are going to explore the GDK to find some methods that take closures and learn how to use them. Hint - I would narrow your search to java.util.Collection, java.lang.Iterable & java.util.List

https://groovy-lang.org/gdk.html

* Search for the find and findAll methods.
    - What is the difference between the two? 
    - Write some code to show how they both work.

        Collection > find(Closure c) y findAll(Closure c)
        find(Closure closure)
        Finds the first value matching the closure condition.
        findAll(Closure closure)
        Finds all values matching the closure condition.

* Search for the any and every methods.
    - What is the difference between the two? 
    - Write some code to show how they both work. 

        Iterable > 
        any(Closure predicate)
        Iterates over the contents of an iterable, and checks whether a predicate is valid for at least one element.
        every(Closure predicate)
        Used to determine if the given predicate closure is valid (i.e. returns true for all items in this iterable).

* Search for the method groupBy that accepts a closure
    - What does this method do? 
    - Write an example of how to use this method.

        Map	groupBy(Closure closure)
        Sorts all Iterable members into groups determined by the supplied mapping closure.
        Map	groupBy(Object closures)
        Sorts all Iterable members into (sub)groups determined by the supplied mapping closures.
        Map	groupBy(List closures)
        Sorts all Iterable members into (sub)groups determined by the supplied mapping closures.

Lista de mapas  

        List people = [
            [name:'Jane', city:"New York City"],
            [name:'John', city:"Cleveland"],
            [name:'Mary', city:"New York City"],
            [name:'Dan', city:"Cleveland"],
            [name:'Tom', city:"New York City"],
            [name:'Frank', city:"New York City"],
            [name:'Jason', city:"Cleveland"]
        ]

        println people.find{person -> person.city=="Cleveland"}
        // Imprime el primer elemento de la lista que concuerde: [name:John, city:Cleveland]
        println people.findAll{person -> person.city=="Cleveland"}
        // Imprime [[name:John, city:Cleveland], [name:Dan, city:Cleveland], [name:Jason, city:Cleveland]]

        println people.any{person -> person.city == "Cleveland"}  // imprime  true
        println people.every{person -> person.city == "Cleveland"}  // imprime  false
        println people.every{person -> person.name.size() >= 3}  // imprime  true

        def peopleByCity = people.groupBy { person -> person.city } 
        println people.peopleByCity  // Imprimio nulls

        def newYorkers = peopleByCity["New York City"]
        def clevelanders = peopleByCity["Cleveland"]

        clevelanders.each{
            println it.name
        } // John, Dan, Jason


 /************************************************/

## Seccion 6 - 56:
Closure Delegates  
https://docs.oracle.com/javase/8/docs/api/java/lang/StringBuffer.html  

    Class StringBuffer
    java.lang.Object
    java.lang.StringBuffer

    public final class StringBuffer
    extends Object
    implements Serializable, CharSequence

Owner, delegate and This
This:  corresponde a la clase encasillada donde el closure es definido
owner: corresponde al objeto encasillado donde el closure es definido / clase o closure
delegate: corresponde al un objeto de tercera parte donde as llamadas a los metodos propiedades son resueltas siempre que el receiver del mensaje no este definido

Creacion del archivo `touch Scope.groovy`  
Ingreso a la consola groovyConsole `Scope.groovy`

        class ScopeDemo {
            def outerClosure = {
                println this.class.name  // ScopeDemo
                println owner.class.name  // ScopeDemo
                println delegate.class.name  // ScopeDemo la clase delegada suele ser el Owner a menos que se cambie
                def nestedClosure = {
                    println this.class.name  // ScopeDemo - apunta a la clase principal, la clase ScopeDemo
                    println owner.class.name  // ScopeDemo$_closure1 la clase propietaria es outerClosure
                    println delegate.class.name  //ScopeDemo$_closure1 la clase propietaria es outerClosure
                }
                nestedClosure()
            }
        }

        def demo = new ScopeDemo()
        demo.outerClosure()

Delegados  
Creacion del archivo `touch Delegates.groovy`  
Ingreso a la consola groovyConsole `Delegates.groovy`

Como cambiar los delegados si asi lo queremos 

        def writer = {
            append 'Liliam'
            append 'Lives in Envigado'
        }
        def append (String s){
        println "append() called with argument of $s"
        }
        writer()

    /* result with out StringBuffer
    append() valled with argument of Liliam
    append() valled with argument of Lives in Envigado
    */

Otro metodo para cambio de delegados  
        def writer = {
            append 'Liliam'
            append ' Lives in Envigado'
        }

        StringBuffer sb = new StringBuffer()
        writer.delegate = sb
        writer()

    /* result with StringBuffer
    Liliam Lives in Envigado
    se delega el resultado de writer en el stringbuffer el cual sabe append es un metodo que toma el string
    */


Cambio con Apendice  
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

    /* result 
    append() called with argument of Liliam
    append() called with argument of Lives in Envigado

    lo que pasa aca es que aunque se le ha asignado un delegado, aun llama al metodo encasillado append, pues esa es basicamente la estrategia de resolucion /resolucion que tiene
    */

Metodo DELEGATE_FIRST
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

 /************************************************/

## Seccion 6 - 55:

Curry Methods  

        def log = {String type,Date createdOn, String msg ->
            println "$createdOn [$type] - $msg"
        }
        log("DEBUG", new Date(), "This is my first debug statement")
        // imprime al llamar al metodo: Tue Dec 24 16:35:07 COT 2024 [DEBUG] - This is my first debug statement

Reusar un closure reusando el ya existente  
        def debugLog = log.curry("DEBUG")
        debugLog(new Date(),"This is the second debug statement")  // Tue Dec 24 16:41:46 COT 2024 [DEBUG] - This is the second debug statement
        debugLog(new Date(),"This is the third debug statement")  // Tue Dec 24 16:41:46 COT 2024 [DEBUG] - This is the third debug statement

        def todayDebugLog = log.curry("DEBUG", new Date())
        todayDebugLog("This is the today's debug msg") // Tue Dec 24 16:44:46 COT 2024 [DEBUG] - This is the today's debug msg

Right curry  
        def crazyPersonLog = log.rcurry("Why am I loggin this way.")
        crazyPersonLog("ERROR",new Date()) // Tue Dec 24 16:49:14 COT 2024 [ERROR] - Why am I loggin this way.

Index based currying  
        def typeMsgLog = log.ncurry(1,new Date()) // reemplaza la fecha con la variable en particular
        typeMsgLog("ERROR","This is using ncurry") // Tue Dec 24 16:52:50 COT 2024 [ERROR] - This is using ncurry

 /************************************************/
## Seccion 6 - 54

Collection methods
http://groovy-lanf.org/gdk.html

each(Closure c) 
eachWithIndex(Closure c) 

each / eachWithIndex  

        List favNums = [2,21,44,35,8,4]

        for (num in favNums){
            println num
        }   // imprime 2,21,44,35,8,4 con salto de linea

        favNums.each { println it } // imprime 2,21,44,35,8,4 con salto de linea

        for (int  i=0; i < favNums.size(); i++ ){
            println "$i:${favNums[i]}"
        } // imprime 0:2,1:21,2:44,3:35,4:8,5:4 con salto de linea

        favNums.eachWithIndex { num, idx -> 
            println "$idx:$num" 
            } // imprime 0:2,1:21,2:44,3:35,4:8,5:4 con salto de linea

findAll, pasando una condicion  

        List days = ["Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"]
        List weekend = days.findAll {it.startsWith("S")}

        println days   // [Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday]
        println weekend   // [Sunday, Saturday]

Colecciones: collect  

        List nums =[1,2,2,7,2,8,2,4,6]
        List numsTimesTen =[]
        nums.each{num ->
            numsTimesTen << num * 10
        }
        println nums  // [1, 2, 2, 7, 2, 8, 2, 4, 6]
        println numsTimesTen  //[10, 20, 20, 70, 20, 80, 20, 40, 60]

Sin embargo esta no es la forma mas eficiente de hacerlo, pues esta haciendo un ciclo sobre la lista. Se puede hacer un uso mas funcional con la coleccion  

        List newTimesTen = nums.collect{ num -> num * 10}
        println newTimesTen  // [10, 20, 20, 70, 20, 80, 20, 40, 60]


 /************************************************/
## Seccion 6 - 53

Closure parameters  

        // Implicit parameter
        def foo ={     // Tambien se puede usar name -> println name
            println it
            }
        foo ('Lili')  //  Envia a imrimir Lili

        def noparams = {
            println "no params ..."
        }
        noparams()  //Imprime lo que este en noprarams()  no params ...

        def sayHello = { String first, String last ->
            println "Hello, $first $last"
        }
        sayHello ("Liliam","Bolanos")   // en el print Hello, Liliam Bolanos

        //default values
        def greet = {String name, String greeting ="Howdy" ->
            println "$greeting, $name"
        }
        greet("Liliam","Hello")   // se imprime Hello, Liliam
        greet("Paola")   // se imprime Howdy, Paola

        //var-arg : para pasar tantos argumentos como sea necesario sin conocer la cantidad
        def concat = {String... args ->
            args.join('')
        }
        println concat ('abc','def')   // abcdef
        println concat ('abc','def','123','456') // abcdef123456

        //
        def someMethod(Closure c){
            println "..."
            println c.maximumNumberOfParameters
            println c.parameterTypes
        }
        def someClosure = {int x, int y -> x + y}
        someMethod(someClosure) // impime para numero de parametros  2 y para el tipo [int, int]

 /************************************************/
## Seccion 6 - 52:

Ejemplos de closures:  

        Closure c1 = {}

        println c1.class.name  // 52-Basics$_run_closure1
        println c1 instanceof Closure   // true

        def c = {}
        println c.class.name  // 52-Basics$_run_closure2
        println c instanceof Closure   // true

        //El closure es un bloque de codigo que actua como una como una funcion anonima
        def sayHello1 = {
            println "Hello"
        }
        sayHello1()   // Hello

        def sayHello = { name ->  // se puede pasar parametros
            println "Hello, $name"
        }
        sayHello('Liliam')   // Hello, Liliam

        List nums = [1,4,7,4,30,2]
        nums.each ({ 
            println it // palabra reservada it para tomar cada elemento de la lista en el closure
                        // Result: [1, 4, 7, 4, 30, 2]
        })

        nums.each ({ num ->  // otra forma es si se quiere el nombre de la vble
            println num // palabra reservada it para tomar cada elemento de la lista en el closure
                        // Result: [1, 4, 7, 4, 30, 2]
        })

        // los closures son objets y ultimo parametro
        def timesTen(num,closure){
            closure (num*10)
        }
        timesTen(10, {println it})  // 100
        timesTen(2, {println it})   // 20

        10.times {
            println it  // imprime del 0 al 9
        }

        import java.util.Random
        Random rand = new Random()
        3.times{
            println rand.nextInt()   // imprime 3 numeros aleatorios
        }

 /************************************************/
## Seccion 6 - 51:

Closures  
https://groovy-lang.org/closures.html  
https://docs.groovy-lang.org/latest/html/api/groovy/lang/Closure.html  

Es como un metodo a exepcionque es como un ciudadano de primera clase del lenguaje  
Hace lo mismo que un metodo pero funciona como un objeto y puede ser pasado o usado entre los programas.  
Son usados para:
Iteradores, CallBacks, Higher-order functions, estructuras de conrol especializadas, Constructores Localizacionde recursos, hilos, DSLs, Fluent interfaces

 /************************************************/

##  Section 5: 48-49

Ejercicio de unidad 5  
        /*
        Ranges
        Crear un rango de enum
        imprimir el tamaño del rango
        use un metodo para saber si Wednesday esta ahi
        imprima from elemento del rango
        imprima to elemento del rango
        */

        enum Days {
            SUNDAY,MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY
        }

        def dayRange = Days.SUNDAY..Days.SATURDAY

        /*for in loop*/
        for (day in dayRange){
            println day
        }
        println ""
        /*using closures*/
        dayRange.each {day -> 
            println day
        }
        println ""
        println dayRange.size()
        println dayRange.contains(Days.WEDNESDAY)
        println dayRange.from  //get
        println dayRange.to   //get


        /*
        List
        Crear una lista de dias(Sun - Sat)
        imprimir la lista
        imprimir el tamaño de la lista
        remover el sabado
        añadir el sabado a la lista
        imprimir el miercoles usndo index
        */

        def days = ["Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"]

        println days   // [Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday]
        println days.size()   // 7
        days.pop()
        println days  // [Monday, Tuesday, Wednesday, Thursday, Friday, Saturday]
        days.add("Saturday")  // [Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Saturday]
        println days
        println days [3]  // Thursday



        /*
        Maps
        Crear un mapa de dias de la semana: 1:Sunday...
        imprima el mapa
        imprima la clase del mapa
        imprima el tamaño del mapa
        Hay un metodo ara imprimir los dias?
        LinkedHashMap
        */

        Map map = [1:"Sunday",2:"Monday",3:"Tuesday",4:"Wednesday",5:"Thursday",6:"Friday",7:"Saturday"]

        println map   // [1:Sunday, 2:Monday, 3:Tuesday, 4:Wednesday, 5:Thursday, 6:Friday, 7:Saturday]
        println map.getClass().getName()  // java.util.LinkedHashMap
        println map.size()   // 7
        println map.values()  // [Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday]


 /************************************************/

## Seccion 5 - 47

https://docs.groovy-lang.org/latest/html/groovy-jdk/java/util/Map.html  
Maps : diccionarios en  otros lenguajes  

    def map =[:]  // ladiferencia con listas es que se usa :
    println map   // [:]
    println map.getClass().getName()   // implementacion default java.util.LinkedHashMap

    def person =[first:"Liliam", last:"Bolanos", email:"lbolanos@gmail.com"]  // ladiferencia con listas es que se usa :
    println person   // [first:Liliam, last:Bolanos, email:lbolanos@gmail.com
    println person.first  // Liliam

Add. añadir algo nuevo

    person.twitter ="@liliambolanos"
    println person // [first:Liliam, last:Bolanos, email:lbolanos@gmail.com, twitter:@liliambolanos]

Ejemplps de llaves no directamente nombradas que son textos:  

    def twitter = [username:"@liliamb",'Email Address':"lbolanos1984@gmail.com"]  // String como llave debe ir entre comillas simples''
    println twitter  // [username:@liliamb, Email Address:lbolanos1984@gmail.com]

    def emailKey = "Email Address"
    def twitter2 = [username:"@liliamb",(emailKey):"lbolanos84@gmail.com"]  // Variable como llave debe ir entre parentesis ()
    println twitter2  // [username:@liliamb, Email Address:lbolanos84@gmail.com]

Tamaño del mapa, es decir cuantos elementos tiene

    println person.size() // tamaño del mapa : 4

No hay un ordenamiento directo del mapa pero igual se puede hacer con ordenamiento alfabetico de las llaves  

    println person.sort()  // [email:lbolanos@gmail.com, first:Liliam, last:Bolanos, twitter:@liliambolanos]

Looping through a person

    for (entry in person){
        println entry  // Imprime cada uno de los elementos del mapa en cada iteacion llave=contenido (first=Liliam)
    }

    for (key in person.keySet() ){
        println "$key:${person[key]}"  // Imprime cada ino de los elementos del mapa en cada iteacion llave:contenido (last:Bolanos)
    }

/************************************************/

## Seccion 5 - 46

Listas

https://docs.groovy-lang.org/latest/html/groovy-jdk/java/util/List.html

Las listas son agrupaciones de datos de un mismo tipo, algunos ejemplos a continuación:

    def nums1 = [1,2,3,6,7,9,4,5,3,6,8,9]
    println nums1   // [1, 2, 3, 6, 7, 9, 4, 5, 3, 6, 8, 9]
    println nums1.class.name   // java.util.ArrayList

    List nums = [1,2,3,6,7,9,4,5,3,6,8,9] // tambien se puede con  as LinkedList
    println nums   // [1, 2, 3, 6, 7, 9, 4, 5, 3, 6, 8, 9]
    println nums.class.name   // java.util.ArrayList

add|remove|get|clear

Addig

    nums.push(99)  //[99, 1, 2, 3, 6, 7, 9, 4, 5, 3, 6, 8, 9]
    nums.putAt(0,77) // replace the 99
    println nums   // [77, 1, 2, 3, 6, 7, 9, 4, 5, 3, 6, 8, 9]

Overload lists  

    nums[0]=78 // replace the 99
    println nums   // [78, 1, 2, 3, 6, 7, 9, 4, 5, 3, 6, 8, 9]

    println nums +[3,4,6]   //[78, 1, 2, 3, 6, 7, 9, 4, 5, 3, 6, 8, 9, 3, 4, 6]

    println nums + 7   //[78, 1, 2, 3, 6, 7, 9, 4, 5, 3, 6, 8, 9, 7]

Remmoving  

    nums.pop()
    println nums   //[1, 2, 3, 6, 7, 9, 4, 5, 3, 6, 8, 9]

    nums.removeAt(0)
    println nums   //[2, 3, 6, 7, 9, 4, 5, 3, 6, 8, 9]

    def newList = nums -3
    println newList  //[2, 6, 7, 9, 4, 5, 6, 8, 9] remueve las ocurrencias de 3
    println nums[4]  // 9. pues es la 4 posicion (comienza en 0)

Get  
    println nums.getAt(0..3)  // [2, 3, 6, 7]  , list original [2, 3, 6, 7, 9, 4, 5, 3, 6, 8, 9]

In loops  
    for (x in nums){
        println x  // imprime cada numero de la lista
    }


Método flatten  

    nums << [3,4,5]
    nums << [1,2]
    println nums. flatten()  // [2, 3, 6, 7, 9, 4, 5, 3, 6, 8, 9, 3, 4, 5, 1, 2]

Método unique  

    println nums.unique()   // [2, 3, 6, 7, 9, 4, 5, 8, [3, 4, 5], [1, 2]]


    def numbers1 = [1,2,7,3,8,3,8,3,8,9,2,6,10,165,4] as Set
    println numbers1  // [1, 2, 7, 3, 8, 9, 6, 10, 165, 4]  no hay duplicados en un set
    println numbers1.class.name // java.util.LinkedHashSet

    def numbers = [1,2,7,3,8,3,8,3,8,9,2,6,10,165,4] as SortedSet
    println numbers  // [[1, 2, 3, 4, 6, 7, 8, 9, 10, 165] Lista ordenada sin duplicados
    println numbers.class.name // java.util.TreeSet


 /************************************************/

## Seccion 5 - 45

Collections - Ranges  
https://docs.groovy-lang.org/latest/html/gapi/groovy/lang/Range.html

Examples

    for( int x = 1; x <= 10; ++x){
        print x
    }

    println ""

    for( int y = 10; y >= 1; --y){
        print y
    }

    println ""

    def letters = ['a','b','c']
    for( int i = 0; i < letters.size(); ++i){
        print letters[i]
    }
    
/*---------------------------------------------*/

    Range r = 1..10  // doble punto indica que es un rango
    //Range r = <1..10  // rango de 1 a menor que 10
    println r  //No me imprimio el rango, debe ser [1,2,3,4,5,6,7,8,9,10]
    println r.class.name // groovy.lang.IntRange
    println r.from  //1  Inicio del rango
    println r.to  //10 final del rango

    assert (0..10).contains(0)
    assert (0..10).contains(10)
    assert (0..10).contains(-10) == false
    assert (0..10).contains(11) == false

    assert (0..<10).contains(0)
    assert (0..<10).contains(10) == false

    Date today = new Date()
    Date oneWeekAway = today + 7

    println today  // Mon Dec 09 18:34:37 COT 2024
    println oneWeekAway // Mon Dec 16 18:34:37 COT 2024

    Range days = today..oneWeekAway
    println days  // Mon Dec 09 18:36:23 COT 2024..Mon Dec 16 18:36:23 COT 2024

    Range letters = 'a'..'z'
    println letters // a..z


 /************************************************/

## Seccion 4 - 43

*Expresiones regulares* (regex)
las expresiones regulares son representaciones de l busqueda de un patron usada ara escanear y concordar con un texto.  

Operadores en groovy

Groovy usa la API de expresiones regulares, con 3 operadores:  

        Find operator		(=~)		java.util.regex.Matcher
        Match operator		(==~)		boleean
        Pattern operator	(~string)	java.util.regex.Pattern


        Pattern						Meaning
        abc							Concuerda con string que contenga a seguida de b y b seguida de c
        b[aeiou]t					Concuerda con bat,bet,bit,bot y but
        <TAG\b[^>]*>(.*?)</TAG>		Concuerda con HTLM especifico dentro del tag
        \b[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,}\b	concuerda con cualquier email	

www.regular-expressions.info/refquick.html


Ejemplos

1. touch regex.groovy
2. groovyConsole regex.groovy

// Java sample Pattern

        import java.util.regex.*;
        Pattern pattern =Pattern.compile("a\\\\b") // en kjava para usar el back slash se necesita colocar 4 de ellos
        println pattern        // a con un solo \ ya con 4\ sale a\\b
        println pattern.class  // class java.util.regex.Pattern

Patterns in Groovy

        String slashy = /a\b/  // colocar informacion detre slash permite el uso de back slash simple
        String url = $/http://threal/danvega.com/blog/$   // cuando hay varios se usa el dollar slash inicio y fin
        println slashy.class

        def pattern2 =  ~/a\b/   //class java.lang.String
        println pattern2.class // class java.util.regex.Pattern


Find | Match

        def text = "empieza con Pablito clavo un clavito, que clavito clavo pablito"
        def pattern3 = ~/Pablito clavo/
        def finder = text =~ pattern3
        def matcher = text ==~ pattern3

        println finder  // java.util.regex.Matcher[pattern=Pablito clavo region=0,63 lastmatch=]
        println finder.size()  //1
        println matcher  // boolean: false

        def text2 = "Pablito clavo"
        def pattern4 = ~/Pablito clavo/
        def matcher2 = text2 ==~ pattern4
        println matcher2  // boolean: true

        def text3 = "empieza con Pablito clavo un clavito, que clavito clavo pablito"
        def pattern5 = ~/Pablito/

        text3 = text3.replaceFirst (pattern5,"Dolores")
        println text3 // empieza con Dolores clavo un clavito, que clavito clavo pablito


 /************************************************/

## SECCION 4 - 42

Trabajando con strings en Groovy

//Java ::

    char c = 'c'
    println c.class // class java.lang.Character

    String str = "This is a string"
    println str.class  // class java.lang.String

//Groovy ::

    def c2  = 'c'   // class java.lang.String
    println c2.class

    def str2 = 'This is a string'
    println str.class // class java.lang.String

Nota: groovy strings instances of java.lang.String

string interpolation

- Java  

        String name = "Liliam"
        String msg = "Hello " + name + "..."
        println msg   // Hello Liliam...

- Groovy  

        String msg2 = "Hello ${name}"
        println msg2   // Hello Liliam

        String msg3 = 'Hello ${name}'
        println msg3   // Hello ${name}

        String msg4 = "We can evaluate expresions here: ${1 + 1}"
        println msg4  // We can evaluate expresions here: 2

Multiple strings  
Se puede colocar cadenas de caracteres en diferentes lineas

    def alargeMsg = '''
    A Msg goes
    here and
    keeps going
    '''  
    println  alargeMsg
    A Msg goes
    here and
    keeps going


    def alargeMsg2 = """
    A Msg goes
    here and
    keeps going  ${1 + 1}
    """
    println  alargeMsg2
    A Msg goes
    here and
    keeps going  2

Dollar strings    
Son cadenas de string con caracteres especiales, en groovy se pueden colocar etre `$//$` para que sean leidas correctamente

    def folder = "C:\\groovy\\CursoGroovy\\Scripts"
    println folder // C:\groovy\CursoGroovy\Scripts

    def folder2 = $/C:\groovy\CursoGroovy\Scripts/$
    println folder2  //C:\groovy\CursoGroovy\Scripts


  /************************************************/

## SECCION 4 - 40 y 41

Se crea el arcivo Accountdemo.groovy y se crea la clase segun las indicaciones:

    @groovy.transform.ToString

    class Account {

        BigDecimal balance = 0.0
        String Type // checking or savings

        BigDecimal deposit(BigDecimal amount){
            balance += amount 
        }
        
        BigDecimal withdraw(BigDecimal amount){
            balance -= amount 
        }
        
        BigDecimal plus(Account account){
        this.balance + account.balance
        }
    }


    Account checking = new Account(type:"Checking")
    checking.deposit(100.00)

    Account savings = new Account(type:"Savings")
    savings.deposit(50.00)

    println checking  // Account(100.00, Checking)
    println savings   // Account(50.00, Savings)

    BigDecimal total = checking + savings  //Aca se usa el metodo plus. sino no se puede hacerla suma directamente
    println total  // 150.00

 /************************************************/

## SECCION 4 - 39
Operator overloading
en la pagina de documentaciond e gorrovy groovy-lang.org/index.html ir a la seccion de documentation > operators > operator overloading


        Operator	Method			Operator	Method
        +			a.plus(b)		a[b]		a.getAt(b)
        -			a.minus(b)		a[b] = c	a.putAt(b, c)
        *			a.multiply(b)	a in b		b.isCase(a)
        /			a.div(b)		<<			a.leftShift(b)
        %			a.mod(b)		>>			a.rightShift(b)
        **			a.power(b)		>>>			a.rightShiftUnsigned(b)
        |			a.or(b)			++			a.next()
        &			a.and(b)		--			a.previous()
        ^			a.xor(b)		+a			a.positive()
        as			a.asType(b)		-a			a.negative()
        a()			a.call()		~a			a.bitwiseNegate()



Ejemplos:

def a = 1
def b = 2

        println a + b  // 3 . sub clases of Number class
        println a.plus(b)


        def s1 = "Hello"
        def s2 = ", wold!"
        println s1+s2  // Hello, wold!
        println s1.plus(s2)

 - Ejemplo de sobrecarga en clases  
 Crear el archivo accounts.groovy

        class Account{
            BigDecimal balance
            Account plus (Account other){
                new Account (balance:this.balance + other.balance)
            }
            String toString(){
                "Account Balance : $balance"
            }
        }

        Account savings = new Account (balance: 100.00)
        Account checking = new Account(balance:500.00)

        println savings  // Account Balance : 100.00
        println checking // Account Balance : 500.00
        println savings + checking // Account Balance : 600.00

 /************************************************/

## SECCION 4 - 38

*Working with numbers*

--Groovy numbers default

        def number=10
        println number.class   // class java.lang.Integer

        def decimal=5.5
        println decimal.class   // class java.math.BigDecimal

- Converiting data types
- Explicit - casting

        def myFloat = (float) 1.0
        println myFloat.class  //class java.lang.Float

- Implicit - coercion

Rules for +,-,*

- if eigther operand is a float or a double the result is a double
- In Java only floats are involved the result is a float

        Float f =5.25
        Double d= 10.50
        def result = d/f
        println result  //2.0
        println result.class  //class java.lang.Double

        Float a =10.75
        Float b= 53.75
        def result2 = b / a
        println result2  //5.0
        println result2.class  //class java.lang.Double

- If eigther iperand is a big decimal

        def x = 34.5  //bigdecimal
        def y = 15
        def bigResult = x / y
        println bigResult  //2.3
        println bigResult.class //class java.math.BigDecimal

- If eigther iperand is a BigInteger the result is a BigInteger
- If eigther iperand is a Long the result is a Long
- If eigther iperand is a Integer the result is an Integer


- Double Division

        println 5.0d - 4.1d  //0.9000000000000004
        println 5 - 4.1  //0.9
   
- Integer Division

        def intDiv = 1 / 2
        println intDiv  //0.5 this is much different the Java where we wold get 0
        println intDiv.getClass().getName() //java.math.BigDecimal
        println 1.intdiv(2)  //0


- GDK Methods

        assert 2 == 2.5.toInteger() // Conversion
        assert 2 == 2.5 as Integer // Enforced coercion
        assert 2 == (int)2.5  // cast

        assert '5.50'.isNumber()
        assert 5 == '5'.toInteger()


- times | upto | downto | step

        20.times {  //Allows loops over
            print '_'
        }

        1.upto(10){ num -> // Goes from 1 to 10
            println num
        }

        10.downto(1){ num -> // Goes from 10 to 1
            println num
        }

        0.step(1,0.1){ num -> // Goes from 0 to 1, by decimal increment in 0.1 //1 not included
            println num
        }

 /************************************************/

## SECCION 4 - 37:
Obtener el tipo de datos

        byte b= 10
        b.getClass().getName()

        short s= 1000
        b.class

        float f=1.23
        f.class

        65454654654654654654654543.class

        4.50.class

Si sabes que el tipo de dato de la variable no va a cambiar es bueno definirlo con el tipo de dato desde el principio.

        def x = 10
        x.getClass().getName()

        x= "Dan"
        x.getClass().getName()

 /************************************************/

## SECCION 4 - 36:

Tipos de Datos (Data Type)

*Nota:* Las variables deben ser declaradas antes de ser usadas en  Groovy Type y Name

* Tipos de datos primitivos:
        byte   java.lang.Byte   
        short   java.lang.Short  
        int   java.lang.Int  
        long   java.lang.Long  
        float   java.lang.Float  
        double   java.lang.Float  
        char   java.lang.Char  
        boolean  java.lang.Boolean  

En un archivo de groovy trabajamos los distintos tipos de datos:  

        /*
        * Primitive Data Types Demo
        */
        public class DataTypes {
        public static void main(String[] args) {
                // byte:
                // Min Value: -128
                // Max Value: 127
                byte b = 127  // al salirse del rango, aparece un error.
                println( b.class.getName() + " = " + b) //resultado java.lang.Byte = 127

                // short:
                // Min Value: -32,768
                // Max Value: 32,767
                short s = 10000
                println( s.class.getName() + " = " + s)  // Resultado java.lang.Short = 10000
                
                // int:
                // Min Value: -2,147,483,648 (-2^31)
                // Max Value 2,147,483,647 (2^311)
                int i = 324561789
                println( i.class.getName() + " = " + i) // resultado: java.lang.Integer = 324561789  

                int i = 2_147_483_647
                println( i.class.getName() + " = " + i) // resultado: java.lang.Integer = 2147483647

                // long:
                // Min Value: -9,223,372,036,854,775,808 (2^63)
                // Max Value: 9,223,372,036,854,775,807 (2^631)
                long l = Long.MAX_VALUE
                System.out.println(l.class.getName() + " = " + l) //resultado: java.lang.Long = 9223372036854775807

                // float: 32-bits IEEE floating points (single precision)
                // Min Value: 1.4E-45
                // Max Value: 3.4028235E38
                float f = 1.25F // float f = 1.25
                println( f.class.getName() + " = " + f) //resultado: java.lang.Float = 1.25

                // double:64-bit IEEE floating points (double precision)
                // Min Value: 4.9E-324
                // Max Value: 1.7976931348623157E308
                double d = 1.05798202483D
                println( d.class.getName() + " = " + d) // resultado: java.lang.Double = 1.05798202483

                // char: character or unicode
                char c = 'c'
                println( c.class.getName() + " = " + c) //resultado: java.lang.Character = c

                // boolean: true or false
                boolean bool = true
                println( bool.class.getName() + " = " + bool) //resultado: java.lang.Boolean = true
            }
        }

 /************************************************/
 
  ## SECCION 3 - 34:
Grape is a JAR dependency manager embedded into Groovy

http://docs.groovy-lang.org/latest/html/documentation/grape.html  
https://commons.apache.org/proper/commons-lang/javadocs/api-release/org/apache/commons/lang3/text/package-summary.html  
https://central.sonatype.com/?smo=true

- Creo el archivo `app.groovy` con el codigo.

        @Grapes(
            @Grab( group='org.apache.commons',module='commons-lang3',version='3.14.0')
            //@Grab(group='org.netbeans.external', module='org-apache-commons-lang3', version='RELEASE130')
        )

        import org.apache.commons.lang3.text.WordUtils

        String name = "Liliam Paola Bolanos"
        WordUtils wordUtils= new WordUtils()

        println wordUtils.initials(name)

- El resultado de esta ejecucion es `LPB`


 /************************************************/
 
 ## SECCION 3 - 33:

Operators: https://groovy-lang.org/operators.html
 
- En una nueva carpeta (31-32-33), creo el archivo `Operators.groovy`.
   > Operator	Purpose	Remarks  
   > `+` addition  
   > `-` subtraction  
   > `*` multiplication  
   > `/` division  
   > `%` remainder  
   > `**` power  

- Arithmetic operators  
   >    assert  1  + 2 == 3  
        assert  4  - 3 == 1  
        assert  3  * 5 == 15  
        assert  3  / 2 == 1.5  
        assert 10  % 3 == 1  
        assert  2 ** 3 == 8  

- The binary arithmetic operators we have seen above are also available in an assigment form  
`+=  -=  *=  /=  %=  **=`
  >    def a = 10  
       a += 5  // a= a +5  
       assert a == 15

- Relational operators
   >    assert 1 + 2 == 3 
        assert 3 != 4  
        assert -2 < 3  
        assert 2 <= 2  
        assert 3 <= 4  

- Logical Operators  
   >    assert !false  
        assert true && true  
        assert true || false

- Conditional Operators

            // ternary operators
            String s = ""
            if (s != null && s.lenght()>0){
                result ='Found'
            } else {
                result = 'Not foun'
            }
            
            String s = ""
            result =(s != null & s.lenght()>0)? 'Found' : 'Not Found'
            
            //Elvis operator
            displayName = user.name ? user.name : 'Anonymus'
            displayName = user.name ?: 'Anonymus'
    
- Object operators

            // Safe Navigation operator
            // Java
            Person p = new Person()
            if (p.address != null){
                Address address = p.address
            }
            
            //Groovy
            def address = p?.address
            assert address == null        

- So much more  
`println "http://groovy-lang.org/operators.html"`



 /************************************************/
 
 ## SECCION 3 - 31 y 32:

 Ejercicio  

 - En una nueva carpeta (31-32-33), creo el archivo `CanonicalDemo.groovy`.
 - Luego en la consola `groovyConsole CanonicalDemo.groovy`.
 - Pegamos el ejemplo de la página:
    
        import groovy.transform.Canonical
        @Canonical class Customer {
            String first, last
            int age
            Date since
            Collection favItems = ['Food']
            def object
        }
        def d = new Date()
        def anyObject = new Object()
        def c1 = new Customer(first:'Tom', last:'Jones', age:21, since:d, favItems:['Books', 'Games'], object: anyObject)
        def c2 = new Customer('Tom', 'Jones', 21, d, ['Books', 'Games'], anyObject)
        assert c1 == c2

Se ha realizado la creacion de nuevos clientes.  

 - En la misma carpeta  se crea el archivo `SortableDemo.groovy`.
 - Luego en la consola `groovyConsole SortableDemo.groovy`.
 - y se pega el codigo:

        import groovy.transform.*

        @Sortable
        @ToString
        class Person {
            String first
            String last
        }


        def p1 = new Person(first:"Joe",last:"Vega")
        def p2 = new Person(first:"Dan",last:"Vega")

        def people = [p1,p2]
        println people

        def sorted = people.sort(false/*do not mutate original collection*/)
        println sorted

- Ejecutamos el Script y el resultado una lista con los valores de P1 y P2  

        [Person(Joe, Vega), Person(Dan, Vega)]
        [Person(Dan, Vega), Person(Joe, Vega)]

 /************************************************/

 ## SECCION 3 - 30:
 *Anotaciones y transformaciones AST*  
https://groovy-lang.org/objectorientation.html#_annotation  
https://docs.groovy-lang.org/next/html/gapi/groovy/transform/package-summary.html  

En groovyConsole: 

- Crear la carpeta para el ejercicio 30.  
- Crear el archivo Customer.groovy.
- Escribbir las siguientes lineas de codigo 
   > import  groovy.transform.Immutable // importación de una transformación:Immutable  
   
   >@Immutable //Annotation  
      
      class Customer {  
          String first, last  
          int age  
          Date since  
          Collection favItems  
      }  
      
      def d = new Date()
      def anyObject = new Object()
      def c1 = new Customer(first:'Tom', last:'Jones', age:21, since:d, favItems:['Books', 'Games'], object: anyObject)
      def c2 = new Customer('Tom', 'Jones', 21, d, ['Books', 'Games'], anyObject)
      assert c1 == c2

En  el menu  `menuScript > inspect AST` para ver los constructores y metodos ademas de trasnformaciones creadas automaticamente.

- creamos el archivo `app.groovy` en la misma carpeta  
 
    > // testing our customer class

    def d= new Date()
    def c1 = new Customer (first:'Tom', last:'Jones', age:21, since:d, favItems:['Books','Games'])
    def c2 = new Customer ('Tom', 'Jones', 21, d, ['Books','Games'])
    assert c1 == c2

- Ejecutar  el script
- Añadr la linea al final

    >c1.first="Dan" 
 
- Ejecutar  el script y debe aparecer una excepcion.



 /************************************************/
 
  ## SECCION 3 - 29:

  *Estructuras de control*  
Bloque de programacion que analiza algunas variables, y toma desiciones basado en parametros dados.  
https://groovy-lang.org/semantics.html#_control_structures

Crear un archivo Groovye `29-start.groovy`  
Abrir groovyConsole

Ejemplos de las estructuras de control  

>//if
if (true)  
    println "value is true"  

>// false | null | empty string | empty collection      
if (true)  
    println "value is false"  
 
>String name = "Liliam"  
if (name)  
    println "name has a value"  

>String last = ""  
if (name)  
    

>//if/else  
def x = 5  
if (x==10){  
    println "X is 10"  
}else{  
    println "X is NOT 10"  
}  

>// classic while  
def i =1  
while (i <= 10){  
    println i  
    i++  
}

>//for in list  
def list = [1,2,3,4]  
for (num in list){  
    println num  
}

>// closure  
def list2 = [1,2,3,4]  
list2.each { println it }  

>//switch  
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

 /************************************************/
 
 ## SECCION 3 - 28:
*Numbers*

Crear un archivo Groovye `28-numbers.groovy`  
Abrir groovyConsole

Al escribir y ejecutar cada uno de los siguientes comandos se obtiene el tipo de dato de cada uno:

`123456789.getClass().getName()`, obtengo esta respuesta: `Result: java.lang.Integer`.
`134556232434345.getClass().getName()` //Result: java.lang.Long

`int x = 1`   
`x.class`  //Result: java.lang.Integer

`def y = 2`
`y.class`  //Result: java.lang.Integer

`5.5.class` //Result: java.lang.BigDecimal

`5.5d.class`  //Result: java.lang.Double

`def z = 5.5.class` //Result: java.lang.BigDecimal

 /************************************************/
 
## SECCION 3 - 26-27:
Ejercicio
 
> Create a class called `Tweet`  
	`touch Tweet.groovy`  
	`touch Twitter.groovy`  
	`groovyConsole Tweet.groovy`  
Add properties to this class.  
What properties would be present in a class that holds information about a twee.  
Think about what their data types would be.  
What methods would go in this class?  
How about a constructor to create a new tweet.  
How about methods to change some of your properties?  
How about a toString method (or AST Transformation)  
Create a script called Twitter.  
In this script create one or more Tweets.  
print the Tweet instances to the console (and have their string representations shown)  

Bonus  

> Create a file called Tweet.groovy.  
Inside this file create a class called Tweet (the one you created above)  
Then in the same file outside of the class declaration try to create a new tweet.  
What is the error you get and why is this happening?


Nota: No se puede tener en el mismo archivo una clase y un script de groovy, si el archivo es de clase, pero si el nombre del archivo es distinto si funciona

*Tweet.groovy*


> @groovy.transform.ToString  
class Tweet{  
    String username  
    String text  
    Integer retweets  
    Integer favorites  
    Date createdOn
    
    public Tweet(String user, String tweet){
        username = user
        text = tweet
        retweets = 0
        favorites = 0
        createdOn = new Date()
    }
    
    void addToRetweets(){
        retweets += 1
    }
    
    void addToFavorites(){
        favorites += 1
    }
}

*Twitter.groovy*
>def tweet = new Tweet("lbolanos", "Hello, Twitter")  
tweet.addToFavorites()  
tweet.addToFavorites()  
tweet.addToRetweets()  
println tweet

 /************************************************/
 
## SECCION 3 - 25:
*Clases*  
En java se necesita quel el archivo tenga el mismo nombre de la clase. Sin embargo, en Groovy no es necesario, pero por convenciones se recomienda que si se haga de laz mima manera.

 `touch AngryBirds.groovy`  
 `groovyConsole AngryBirds.groovy`  
 `groovyc AngryBirds.groovy` Crea los archivos `.class` de las clases de la carpeta
 
 Todas las clases por defecto son publicas, asi que se puede poner o no la declaracion de la misma.

 /************************************************/
 
## SECCION 3 - 24:
Scripts  
`Inspect AST.`

 /************************************************/
 
## SECCION 3 - 23:
*Aserciones*  
`https://groovy-lang.org/semantics.html#_power_assertion`

Groovy power assert

/************************************************/
 
## SECCION 3 - 22:
*Comments*  
`https://groovy-lang.org/syntax.html#_single_line_comment`  
`https://medium.com/@webseanhickey/the-evolution-of-a-software-engineer-db854689243#.5zm1hn71e`

Archivo Shebang  
* Crear un archivo `shebang.groovy`  
* Colocarle la linea `println "Hello from the shebang line"`  
En consola:   
`less shebang.groovy` Abre el contenido del archivo en linea de comando  
`chmod +x shebang.groovy` Vuelve el archivo ejecutable  
`./shebang.groovy` Ejecuta el comando imprimiendo el mensaje (no me funciono)

 /************************************************/
 
## SECCION 3 - 21:
*Keywords*  
`https://docs.oracle.com/javase/tutorial/java/nutsandbolts/_keywords.html`  
`https://groovy-lang.org/syntax.html#_keywords`

 /************************************************/

## SECCION 3-20:
`https://groovy-lang.org/structure.html#_default_imports`  
Grovy importa clases de forma similar a Java, ejemplo `import groovy.xml.MarkupBuilder`

Uso de paquetes e importaciones

1. Abrir la terminal (CMD o GitBash) en la carpeta donde se esta trabajando
2. Ejecute  `touch ImportDemo.groovy` para crear un archivo de trabajando
3. Ejecute el comando `groovyConsole ImportDemo.groovy`. para abrir el archivo en la consola de Groovy.
4. Escribir y ejecutar `def xml = new MarkupBuilder()`.  
Aparece el error `unable to resolve class MarkupBuilder`.  
El error se soliciona al hacer la importación del paquete `import groovy.xml.MarkupBuilder` y ejecuta.  
El resultado sale ya sin error. (Paquete completo: `import groovy.xml.*`)  

 /************************************************/
 
## SECCION 2 - 17:
 Ejercicios:
 
 *Por editor:*
 
* Se abre en la carpeta donde se esta trabajando un Git Bash
* Escribir
>  
  `touch HelloWorld.groovy` Para crear el archivo  
  `code HelloWorld.groovy` Para editar el archivo  
  `groovyc HelloWorld.groovy` para compilar el archivo, crando el .class  
  `ls`  listar los archivos creados  
  `HelloWorld/  HelloWorld.class  HelloWorld.groovy`  
>
En una consola de CMD sobre la misma carpeta ejecutar `groovy HelloWorld`, para hacer el "Run" del archivo  

Por Consola de Groovy
 * Escribir en CMD o GitBash  
 	`groovyconsole HelloWorld.groovy`  
 * Se ejecuta con Menu Script > Run  (Ctrl+Run / Cmd+R) 
 
 En Intelij tambien se puede crear un nuevo proyecto de groovy.
 en la carpeta SRC crear un archivo `HelloWorld.groovy`  con el texto:   
 	`println ("Hello world!")`  
 * Crear nuevo Proyecto  
 * Seleccionar `New Project`  
 * Seleccionar `Groovy`  
 * Seleccionar la version de java instalada   
 * Seleccionamos la version de groovy  instalada   
   ** Info: ruta reporosiorio (`C:\groovy\CursoGroovy`).  
 * Nombre del proyecto:HelloIntellij  
 * Crear proyecto.  
 * Crear un nuevo Groovy Script en SRC HelloWorld.groovy  
 * Escribir println("Hello, world") y ejecutar  
      Esto crea el archivo .class y ejecuta el comando en la consola interna.
 
 
 /************************************************/
## SECCION 2 - 15:
  
 Intellij IDEA
 `https://www.jetbrains.com/idea/`  
 Instalar y abrir segun las indicaciones del proyecto para groovy. 
 
 * Crear nuevo Proyecto  
 * Seleccionar `New Project`  
 * Seleccionar `Groovy`  
 * Seleccionar la version de java instalada   
 * Seleccionamos la version de groovy  instalada   
  ** Info: ruta reporosiorio (`C:\groovy\CursoGroovy`).  
 * Nombre del proyecto:`HelloWorld`  
 * Crear proyecto.  
 * Crear un nuevo Groovy Script en SRC yo lo deje con Main  
 * Escribir `println("Hello, world")` y ejecutar  
 	> Esto crea el archivo `.class` y ejecuta el comando en la consola interna.
 
 /************************************************/
 SECCION 2 - 14:
 
 Consola de Groovy  
 En CMD, carpeta de groovy: `groovyConsole`. Abre el modo de consola. 
 
 Escribir:  1+1  
 Ejecutar  
  Menu > Script > Run  (Ctrl+Run / Cmd+R)   
  Da como resultado 2
  
 Info: `https://groovy-lang.org/groovyconsole.html` 
 
 /************************************************/
## SECCION 2 - 13: 
 
 Groovy compliler groovyc  
 `https://groovy-lang.org/groovyc.html`
 
 En la carpeta `c:/groovy`
 Crear el archivo `Person.groovy` con lo siguiente:  
> class Person {  
 		String first  
 		String last
  	
 	public Person( String first, String last){
 		this.first = first
 		this.last = last
 	}
 	
 	public String toString(){
 		"Person: $first $last"
 	}
 }
 Ejecutar el comando  
 `groovyc Person.groovy`   
 Esto crea el archivo `Person.class` en la misma carpeta 
 
 >`dir` Para ver los archivos en windows (ls en linux)  
 `groovyc *.groovy` compila todos los archivos groovy de la carpeta  
 `groovyc -d classes *.groovy` compila todos los archivos groovy de la carpeta origen y crea los .class en la carpeta classes  
 `del -r *.class`  borrar archivos (rm en linux)
 
 
 /************************************************/
## SECCION 2 - 11:
 
 *Editor  “groovysh”*  
 Abrir CMD  e ir a la carpeta donde esta Groovy  
 `C:\groovy`  
 Escribir el comando en CMD:  
 `groovysh`  
 
 >C:\groovy>groovysh  
 Groovy Shell (4.0.23, JVM: 11.0.1)  
 Type ':help' or ':h' for help.  
 -------------------------------------------------------------------------------
 > groovy:000> 1+1  
 ===> 2  
 groovy:000> "hello world"  
 ===> hello world  
 groovy:000> class Person{  
 groovy:001> def sayHello(){ printli "Hello" }  
 groovy:002> }  
 ===> true  
 groovy:000> person = new Person()  
 ===> Person@73c3cd09  
 groovy:000> person.sayHello()  
 Hello  
 
 `:h (para ayuda)`  
 `quit (para salir del editor)`

 /************************************************/
## SECCION 2 - 10:
 * Instalar Groovy
 * Descargar la versión: `https://groovy-lang.org/download.html`  
 * Un-zip en una carpeta en `C:/groovy` 
 * Crear la variable de entorno `GROOVY_HOME` con la carpeta creada  
 	`C:\groovy\groovy-4.0.23`  
 * Añadir a la variable de entorno path  
 	`%GROOVY_HOME%\bin`  
 * Comprobar en una CMD la variable de entorno. En la carpeta dentro de un CMD o GitBash escribir:  
 	`groovy -variable`
