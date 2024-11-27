//Arithmetic operators
assert  1  + 2 == 3
assert  4  - 3 == 1
assert  3  * 5 == 15
assert  3  / 2 == 1.5
assert 10  % 3 == 1
assert  2 ** 3 == 8

//The binary arithmetic operators we have seen above are also available in an assigment form
//+=  -=  *=  /=  %=  **=

def a = 10
a += 5  // a= a +5
assert a == 15

// relational operators
assert 1 + 2 == 3
assert 3 != 4

assert -2 < 3
assert 2 <= 2
assert 3 <= 4

// Logical Operators

assert !false
assert true && true
assert true || false

// conditional Operators

    // ternary operators
    String s = ""
    if (s != null && s.lenght()>0){
        result ='Found'
    } else {
        result = 'Not foun'
    }
    
    String s = ""
    result =(s != null & s.lenght()>0)? 'Found' : 'Not Found'
    
    //Elvis operator
    displayName = user.name ? user.name : 'Anonymus'
    displayName = user.name ?: 'Anonymus'
    
// Object operators

    // Safe Navigation operator
    // Java
    Person p = new Person()
    if (p.address != null){
        Address address = p.address
        address.first = "1234 Main"
    }
    
    //Groovy
    def address = p?.address
    assert address == null
    
// So much more
println "http://groovy-lang.org/operators.html"