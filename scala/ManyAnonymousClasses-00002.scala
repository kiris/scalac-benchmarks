class ManyAnonymousClasses2 {
val anonymousClass1 = new Base { def x = println("1") }
val anonymousClass2 = new Base { def x = println("2") }
}
trait Base { def x:Unit }
