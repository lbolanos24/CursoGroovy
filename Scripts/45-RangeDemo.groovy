/* Examples

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
*/

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

