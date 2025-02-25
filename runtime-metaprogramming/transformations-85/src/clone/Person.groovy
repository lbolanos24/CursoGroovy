package clone

import groovy.transform.AutoClone

@AutoClone
class Person {
    String first, last
    List favItems
    Date since
}