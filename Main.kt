fun main() {
   val test = Person("Tristan",21) 
   print("Nom : ${test.name}\nAge : ${test.age}")
   }
   
   class Person(val name : String, val age : Int)