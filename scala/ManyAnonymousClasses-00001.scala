class ManyAnonymousClasses1 {
val anonymousClass1 = new Base { def x = println("1") }
}
trait Base { def x:Unit }
