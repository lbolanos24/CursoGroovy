class Person {
    //fields
    String firstName, lastName
    def dob
    // private | protected | public
    protected String f1, f2, f3
    private Date createdOn = new Date()
    
    static welcomeMsg = 'HELLO'  
    //Constante: en java y Groovy se ven en mayúsculas
    public static final String WELCOME_MSG = 'Hello' 
    
    //Local variables: declaradas al interior del metodo, por tanto son locales a ese metodo unicamernte
    // las variables locales a metodo no se confunden con las declase aun cuando tienen el mismo nombre
    def foo(){
        String msg = "Hello you"
        String firstName = "Liliam"
        println "$msg, $firstName"
    }
}

// Prueba de fields
// En la manera normal, Cuando se necesita acceder a la clase se debe crear una instancia
Person p = new Person()

// con un campo elastico se puede acceder a la clase sin necesidad de instanciarla
println Person.welcomeMsg  // HELLO
println Person.WELCOME_MSG  // Hello

// Prueba de local variables

def person = new Person()
person.foo()  //  Hello you, Liliam
