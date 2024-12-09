//Groovy numbers default
def number=10
println number.class   // class java.lang.Integer

def decimal=5.5
println decimal.class   // class java.math.BigDecimal

// Converiting data types
// Explicit - casting
def myFloat = (float) 1.0
println myFloat.class  //class java.lang.Float

// Implicit - coercion

//Rules for +,-,*

// if eigther operand is a float or a double the result is a double
// In Java only floats are involved the result is a float
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

//If eigther iperand is a big decimal

def x = 34.5  //bigdecimal
def y = 15
def bigResult = x / y
println bigResult  //2.3
println bigResult.class //class java.math.BigDecimal

//If eigther iperand is a BigInteger the result is a BigInteger
//If eigther iperand is a Long the result is a Long
//If eigther iperand is a Integer the result is an Integer


// Double Division
 println 5.0d - 4.1d  //0.9000000000000004
 println 5 - 4.1  //0.9
   
// Integer Division
def intDiv = 1 / 2
println intDiv  //0.5 this is much different the Java where we wold get 0
println intDiv.getClass().getName() //java.math.BigDecimal
println 1.intdiv(2)  //0


// GDK Methods

assert 2 == 2.5.toInteger() // Conversion
assert 2 == 2.5 as Integer // Enforced coercion
assert 2 == (int)2.5  // cast

assert '5.50'.isNumber()
assert 5 == '5'.toInteger()


// times | upto | downto | step

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