class ManyImplicitConversions1 {
implicit def toImplicitClass1(cls: ImplicitClass0) = new ImplicitClass1(cls)

  def m:ImplicitClass1 = {
    val x0:ImplicitClass0 = new ImplicitClass0
    val x1:ImplicitClass1 = x0
    x1
  }
}
class ImplicitClass0
class ImplicitClass1(val cls: ImplicitClass0)
