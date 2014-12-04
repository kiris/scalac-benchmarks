class ManyAnonymousClasses8 {
val anonymousClass1 = new Base { def x = println("1") }
val anonymousClass2 = new Base { def x = println("2") }
val anonymousClass3 = new Base { def x = println("3") }
val anonymousClass4 = new Base { def x = println("4") }
val anonymousClass5 = new Base { def x = println("5") }
val anonymousClass6 = new Base { def x = println("6") }
val anonymousClass7 = new Base { def x = println("7") }
val anonymousClass8 = new Base { def x = println("8") }
}
trait Base { def x:Unit }
