class ScopeDemo {
    def outerClosure = {
        println this.class.name  // ScopeDemo
        println owner.class.name  // ScopeDemo
        println delegate.class.name  // ScopeDemo la clase delegada suele ser el Owner a menos que se cambie
        def nestedClosure = {
            println this.class.name  // ScopeDemo - apunta a la clase principal, la clase ScopeDemo
            println owner.class.name  // ScopeDemo$_closure1 la clase propietaria es outerClosure
            println delegate.class.name  //ScopeDemo$_closure1 la clase propietaria es outerClosure
        }
        nestedClosure()
    }
}

def demo = new ScopeDemo()
demo.outerClosure()