class ManyImplicitConversions2 {
implicit def toImplicitClass1(cls: ImplicitClass0) = new ImplicitClass1(cls)
implicit def toImplicitClass2(cls: ImplicitClass1) = new ImplicitClass2(cls)

  def m:ImplicitClass2 = {
    val x0:ImplicitClass0 = new ImplicitClass0
    val x1:ImplicitClass1 = x0
val x2:ImplicitClass2 = x1
    x2
  }
}
class ImplicitClass0
class ImplicitClass1(val cls: ImplicitClass0)
class ImplicitClass2(val cls: ImplicitClass1)
