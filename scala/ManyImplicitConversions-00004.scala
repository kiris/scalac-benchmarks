class ManyImplicitConversions4 {
implicit def toImplicitClass1(cls: ImplicitClass0) = new ImplicitClass1(cls)
implicit def toImplicitClass2(cls: ImplicitClass1) = new ImplicitClass2(cls)
implicit def toImplicitClass3(cls: ImplicitClass2) = new ImplicitClass3(cls)
implicit def toImplicitClass4(cls: ImplicitClass3) = new ImplicitClass4(cls)

  def m:ImplicitClass4 = {
    val x0:ImplicitClass0 = new ImplicitClass0
    val x1:ImplicitClass1 = x0
val x2:ImplicitClass2 = x1
val x3:ImplicitClass3 = x2
val x4:ImplicitClass4 = x3
    x4
  }
}
class ImplicitClass0
class ImplicitClass1(val cls: ImplicitClass0)
class ImplicitClass2(val cls: ImplicitClass1)
class ImplicitClass3(val cls: ImplicitClass2)
class ImplicitClass4(val cls: ImplicitClass3)
