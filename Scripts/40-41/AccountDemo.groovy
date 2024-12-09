@groovy.transform.ToString

class Account {

    BigDecimal balance = 0.0
    String Type // checking or savings

    BigDecimal deposit(BigDecimal amount){
        balance += amount 
    }
    
    BigDecimal withdraw(BigDecimal amount){
        balance -= amount 
    }
    
    BigDecimal plus(Account account){
       this.balance + account.balance
    }
}

Account checking = new Account(type:"Checking")
checking.deposit(100.00)

Account savings = new Account(type:"Savings")
savings.deposit(50.00)

println checking  // Account(100.00, Checking)
println savings   // Account(50.00, Savings)

BigDecimal total = checking + savings
println total  // 150.00