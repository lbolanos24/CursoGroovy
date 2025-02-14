class Developer {
    String first
    String last
    String email
    List languajes

    Developer(){}

    def invokeMethod (String name, Object args){
        println("invokeMethod() called with args $args")
    }

    def getProperty (String property){
        println("getProperty method called...")
        metaClass.getProperty(this,property)
    }
    void setProperty (String property, Object newValue){
        println("setProperty() called with name $property and newValue $newValue")
        metaClass.setProperty(this,property,newValue)
    }
}
