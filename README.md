# The Complete Apache Groovy Developer Course
>https://perficient.udemy.com/course/apache-groovy/
 
 En este archivo ire llenando las notas que considero relevantes colocando las secciones abordadas de la mas nueva a la mas antigua.

 /************************************************/

 /************************************************/

 /************************************************/
 
 /************************************************/
 
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
