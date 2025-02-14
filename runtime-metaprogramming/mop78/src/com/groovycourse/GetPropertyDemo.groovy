package com.groovycourse

// cada lectura de acceso a una propiedad puede ser interceptada por sobreescritura del metodo getproperty() del objeto actual.
class PropertyDemo {
    def prop1 = "prop1"
    def prop2 = "prop2"
    def prop3 = "prop3"

    def getProperty (String name){
        println "getProperty() called with argument $name"

        if(metaClass.hasProperty(this,name)){
            metaClass.hasProperty(this,name)
        }else{
            println "lets do something fun with this property"
            return "party time..."
        }
        // return
        //metaClass.getProperty(this,name)
    }
}

def pd = new PropertyDemo()
//get property
println pd.prop1
println pd.prop2
println pd.prop3
//property missing
println pd.prop4
