import groovy.xml.XmlSlurper

//Ejemplo 1
//def xml ='''
//    <sports>
//        <sport>
//            <name>Football</name>
//        </sport>
//    </sports>
//'''
//
//def sports = new XmlSlurper().parseText(xml)
//
//println( sports.getClass().getName() )
//println( sports.sport.name )

//Ejemplo 2
def sports = new XmlSlurper().parse('data/sports.xml')

println( sports )
println( sports.sport[2].name )