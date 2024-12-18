def map =[:]  // ladiferencia con listas es que se usa :
println map   // [:]
println map.getClass().getName()   // implementacion default java.util.LinkedHashMap

def person =[first:"Liliam", last:"Bolanos", email:"lbolanos@gmail.com"]  // ladiferencia con listas es que se usa :
println person   // [first:Liliam, last:Bolanos, email:lbolanos@gmail.com
println person.first  // Liliam

//Add. añadir algo nuevo
person.twitter ="@liliambolanos"
println person // [first:Liliam, last:Bolanos, email:lbolanos@gmail.com, twitter:@liliambolanos]

//
def twitter = [username:"@liliamb",'Email Address':"lbolanos1984@gmail.com"]  // String como llave debe ir entre comillas simples''
println twitter  // [username:@liliamb, Email Address:lbolanos1984@gmail.com]

def emailKey = "Email Address"
def twitter2 = [username:"@liliamb",(emailKey):"lbolanos84@gmail.com"]  // Variable como llave debe ir entre parentesis ()
println twitter2  // [username:@liliamb, Email Address:lbolanos84@gmail.com]

println person.size() // tamaño del mapa : 4

//No hay un ordenamiento directo del mapa pero igual se puede hacer con ordenamiento alfabetico de las llaves
println person.sort()  // [email:lbolanos@gmail.com, first:Liliam, last:Bolanos, twitter:@liliambolanos]

// looping through a person
for (entry in person){
    println entry  // Imprime cada uno de los elementos del mapa en cada iteacion llave=contenido (first=Liliam)
}

for (key in person.keySet() ){
    println "$key:${person[key]}"  // Imprime cada ino de los elementos del mapa en cada iteacion llave:contenido (last:Bolanos)
}


