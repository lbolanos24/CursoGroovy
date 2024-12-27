
def log = {String type,Date createdOn, String msg ->
    println "$createdOn [$type] - $msg"
}
log("DEBUG", new Date(), "This is my first debug statement")
// imprime al llamar al metodo: Tue Dec 24 16:35:07 COT 2024 [DEBUG] - This is my first debug statement

// Reusar un closure reusando el ya existente
def debugLog = log.curry("DEBUG")
debugLog(new Date(),"This is the second debug statement")  // Tue Dec 24 16:41:46 COT 2024 [DEBUG] - This is the second debug statement
debugLog(new Date(),"This is the third debug statement")  // Tue Dec 24 16:41:46 COT 2024 [DEBUG] - This is the third debug statement

def todayDebugLog = log.curry("DEBUG", new Date())
todayDebugLog("This is the today's debug msg") // Tue Dec 24 16:44:46 COT 2024 [DEBUG] - This is the today's debug msg

// Right curry
def crazyPersonLog = log.rcurry("Why am I loggin this way.")
crazyPersonLog("ERROR",new Date()) // Tue Dec 24 16:49:14 COT 2024 [ERROR] - Why am I loggin this way.

//Index based currying
def typeMsgLog = log.ncurry(1,new Date()) // reemplaza la fecha con la variable en particular
typeMsgLog("ERROR","This is using ncurry") // Tue Dec 24 16:52:50 COT 2024 [ERROR] - This is using ncurry
