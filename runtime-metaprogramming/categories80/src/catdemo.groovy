/*String.metaClass.shout = { -> toUpperCase()}

println "Hello, World!".shout()
 */

// La manera en que se usa la clase categoria es el use
// lo llamado dentro de esa clase categoria es como un metodo nativo
use (StringCategory) {
    println "Hello, World!".shout()
}