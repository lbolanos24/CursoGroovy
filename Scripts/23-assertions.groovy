//you must provide an assertion an expression that evalues to true
assert true
//we can provide a full expression on the right hand side
//note that unlike Java and more Ruby or Scala == is equality
assert 1==1

//like the example above we are evaluating an expression
def x = 1
assert x==1

// what happens when the expression doesn't evaluate to true
assert false

// the power assertion output shows evaluations results from the outer to the inner expression
assert 1==2

//complex debug output
assert 1==(3 + 10) * 100 / 5 * 20

//The powe assertion statements true power unleashes in complex boolean statements
//or statements with collections or other toString-enabled classes:
def x=[1,2,3,4,5]
assert (x << 6) == [6,7,8,9,10]