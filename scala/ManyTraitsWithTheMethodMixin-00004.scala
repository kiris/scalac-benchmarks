class ManyTraitsWithTheMethodMixin4 extends Trait1 with Trait2 with Trait3 with Trait4
trait Trait1 { def method1 = println("1") }
trait Trait2 { def method2 = println("2") }
trait Trait3 { def method3 = println("3") }
trait Trait4 { def method4 = println("4") }
