# The Complete Apache Groovy Developer Course
>https://perficient.udemy.com/course/apache-groovy/
 
 En este archivo ire llenando las notas que considero relevantes colocando las secciones abordadas de la mas nueva a la mas antigua.
 
 /************************************************/
 /************************************************/
 
## SECCION 2 - 17:
 Ejercicios:
 
 Por editor:
 
>* Se abre en la carpeta donde se esta trabajando un Git Bash
>* Escribir
>  
>> `touch HelloWorld.groovy` Para crear el archivo
>
>>`code HelloWorld.groovy` Para editar el archivo
> 
>>`groovyc HelloWorld.groovy` para compilar el archivo, crando el .class
>
>>`ls`  listar los archivos creados
>>`HelloWorld/  HelloWorld.class  HelloWorld.groovy`
>
>En una consola de CMD sobre la misma carpeta ejecutar `groovy HelloWorld`, para hacer el "Run" del archivo
 
 
 Por Consola de Groovy
 Escribir en CMD o GitBash
 	groovyconsole HelloWorld.groovy
 Se ejecuta con Menu Script > Run  (Ctrl+Run / Cmd+R) 
 
 En Intelij tambien se puede crear un nuevo proyecto de groovy.
 en la carpeta SRC crear un archivo HelloWorld.groovy  con el texto 
 	println ("Hello world!")
 Crear nuevo Proyecto
 Seleccionar "New Project"
 Seleccionar "Groovy"
 Seleccionar la version de java instalada 
 Seleccionamos la version de groovy  instalada 
 Info: ruta reporosiorio (C:\groovy\CursoGroovy).
 Nombre del proyecto:HelloIntellij
 Crear proyecto.
 Crear un nuevo Groovy Script en SRC HelloWorld.groovy
 Escribir println("Hello, world") y ejecutar
      Esto crea el archivo .class y ejecuta el comando en la consola interna.
 
 
 /************************************************/
## SECCION 2 - 15:
  
 Intellij IDEA
 https://www.jetbrains.com/idea/
 Instalar y abrir segun las indicaciones del proyecto para groovy. 
 
 Crear nuevo Proyecto
 Seleccionar "New Project"
 Seleccionar "Groovy"
 Seleccionar la version de java instalada 
 Seleccionamos la version de groovy  instalada 
 Info: ruta reporosiorio (C:\groovy\CursoGroovy).
 Nombre del proyecto:HelloWorld
 Crear proyecto.
 Crear un nuevo Groovy Script en SRC yo lo deje con Main
 Escribir println("Hello, world") y ejecutar
      Esto crea el archivo .class y ejecuta el comando en la consola interna.
 
 /************************************************/
 SECCION 2 - 14:
 
 Consola de Groovy
 
 En CMD, carpeta de groovy:
 	groovyConsole 
      Abre el modo de consola
 
 Escribir:  1+1
 Ejecutar
  - Menu Script > Run  (Ctrl+Run / Cmd+R) 
  Da como resultado 2
  
 Info: https://groovy-lang.org/groovyconsole.html 
 
 /************************************************/
## SECCION 2 - 13: 
 
 Groovy compliler groovyc
 https://groovy-lang.org/groovyc.html
 
 En la carpeta c:/groovy
 Crear el archivo Person.groovy con lo siguiente:
 class Person { 
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
 Ejecuto el comando 
 groovyc Person.groovy 
 	Esto crea el archivo Person.class en la misma carpeta 
 
 dir para ver los archivos en windows (ls en linux)
 groovyc *.groovy compila todos los archivos groovy de la carpeta
 groovyc -d classes *.groovy compila todos los archivos groovy de la carpeta origen y crea los .class en la carpeta classes
 del -r *.class  borrar archivos (rm en linux)
 
 
 /************************************************/
## SECCION 2 - 11:
 
 Editor  “groovysh”
 Abrir CMD  e ir a la carpeta donde esta Groovy
 C:\groovy
 Escribir el comando en CMD:
 groovysh  
 
 C:\groovy>groovysh
 Groovy Shell (4.0.23, JVM: 11.0.1)
 Type ':help' or ':h' for help.
 -------------------------------------------------------------------------------
 groovy:000> 1+1
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
 
 :h (para ayuda)
 quit (para salir del editor)

 /************************************************/
## SECCION 2 - 10:
 Instalar Groovy
 Descargar la versión: https://groovy-lang.org/download.html
 Un-zip en una carpeta en 
 	C:/groovy
 Crear la variable de entorno GROOVY_HOME con la carpeta creada 
 	C:\groovy\groovy-4.0.23
 Añadir a la variable de entorno path 
 	%GROOVY_HOME%\bin
 Comprobar en una CMD la variable de entorno. En la carpeta dentro de un CMD o GitBash escribir:
 	groovy -variable
