class ManyTraitsWithTheMethodMixin2 extends Trait1 with Trait2
trait Trait1 { def method1 = println("1") }
trait Trait2 { def method2 = println("2") }
