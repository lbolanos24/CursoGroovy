/* 
if(true) {
    println "true"
}*/
//boolean				Boolean value es verdadero
assert true
assert !false

//Matcher				Matcher tiene Match (expresiones regulares)
assert ('a' =~/a/)
assert !('a' =~/b/)

//Collection			Coleccion no vacia
assert [1]
assert ![]

//Map					Mapa no vacio
assert [1:'one']
assert ![:]

//String 				Cadena no vacia
assert 'a'
assert !''

//Number, Character	Numero no cero
assert 1
assert 3.5
assert !0

//Non of the above	Objeto referencia que no es null
assert new Object()
assert !null

Es importante entender como groovy evalua diferentes items, para el uso de los operadores condicionales