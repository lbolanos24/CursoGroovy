import groovy.time.TimeCategory

use(TimeCategory){
    println 1.minute.from.now  //  Wed Feb 12 18:32:48 COT 2025
    println 10.hours.ago   //  Wed Feb 12 08:31:48 COT 2025

    def someDate = new Date()
    println someDate - 3.months  // Tue Nov 12 18:31:48 COT 2024
}