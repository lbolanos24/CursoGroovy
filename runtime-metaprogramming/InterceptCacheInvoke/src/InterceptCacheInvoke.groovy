// Intercept - Cache - Invoke pattern

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

//La primera vez se llama el metodo Missing, pero una vez ya se ha llamado lo ejecuta como si existiera. y solo vuelve a llamarlo cuando cambia el llamado a otro valor
