import  groovy.transform.Immutable

@Immutable //Annotation
class Customer {
    String first, last
    int age
    Date since
    Collection favItems
}