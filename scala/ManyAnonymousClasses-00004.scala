class ManyAnonymousClasses4 {
val anonymousClass1 = new Base { def x = println("1") }
val anonymousClass2 = new Base { def x = println("2") }
val anonymousClass3 = new Base { def x = println("3") }
val anonymousClass4 = new Base { def x = println("4") }
}
trait Base { def x:Unit }
