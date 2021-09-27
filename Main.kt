fun main() {
   val Item1 = Product("Iphone",800.0)
   val Item2 = Product("MacBook",1200.0)
   val ListProduit = listOf(Item1,Item2)
   val command = listOf(Order(ListProduit,false),Order(ListProduit,false))
   val Lyon = City("Lyon")
   val Grenoble = City("Grenoble")
   val customer1 = Customer("Tristan",Lyon,command)
   val customer2 = Customer("Customer2",Grenoble,command)
   val ListCustomer = listOf(customer1,customer2)
   val shop = Shop("Apple Store",ListCustomer)
   
   shop.getCitiesCustomersAreFrom()
   shop.getCustomersFrom(City("Lyon"))
      }
   
      data class Shop(val name: String, val customers: List<Customer>){
         fun getCitiesCustomersAreFrom(){
            customers.forEach {
              println(it.city)
          }
         }
         fun getCustomersFrom(city : City){
             customers.filter{it.city == city}.forEach {
               println(it.name)
          }
         }
      }
   
      data class Customer(val name: String, val city: City, val orders: List<Order>) {
       override fun toString() = "$name from ${city.name}"
      }
   
      data class Order(val products: List<Product>, val isDelivered: Boolean)
   
      data class Product(val name: String, val price: Double) {
       override fun toString() = "'$name' for $price"
      }
   
      data class City(val name: String) {
       override fun toString() = name
      }