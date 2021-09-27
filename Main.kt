fun main() {
   val Item1 = Product("Iphone",800.0)
   val Item2 = Product("MacBook",1200.0)
   val ListProduit = listOf(Item1,Item2)
   val command = listOf(Order(ListProduit,false),Order(ListProduit,false))
   val Lyon = City("Lyon")
   val Grenoble = City("Grenoble")
   val customer1 = Customer("Tristan",Lyon,command)
   val customer2 = Customer("Customer2",Grenoble,command)
   val customer3 = Customer("Customer3",Lyon,command)
   val ListCustomer = listOf(customer1,customer2,customer3)
   val shop = Shop("Apple Store",ListCustomer)
   
   shop.getCitiesCustomersAreFrom()
   shop.getCustomersFrom(City("Lyon"))
   println(shop.checkAllCustomersAreFrom(City("Lyon")))
   println(shop.hasCustomerFrom(City("Grenoble")))
   println(shop.hasCustomerFrom(City("Paris")))
   println(shop.countCustomersFrom(City("Paris")))
   println(shop.countCustomersFrom(City("Lyon")))
   println(shop.findAnyCustomerFrom(City("Lyon")))
   println(shop.findAnyCustomerFrom(City("Paris")))
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
         fun checkAllCustomersAreFrom(city: City) : Boolean = customers.all{it.city != city}
   
         fun hasCustomerFrom(city: City) : Boolean = customers.any{it.city == city}
         
         fun countCustomersFrom(city: City) : Int = customers.count{it.city == city}
         
         fun findAnyCustomerFrom(city: City) : Customer? = customers.find{it.city == city}
   
   
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