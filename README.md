# The Complete Apache Groovy Developer Course
>https://perficient.udemy.com/course/apache-groovy/
 
 En este archivo ire llenando las notas que considero relevantes colocando las secciones abordadas de la mas nueva a la mas antigua.


 /************************************************/

 /************************************************/

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
