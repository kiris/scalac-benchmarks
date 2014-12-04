class ManyImplicitConversions8 {
implicit def toImplicitClass1(cls: ImplicitClass0) = new ImplicitClass1(cls)
implicit def toImplicitClass2(cls: ImplicitClass1) = new ImplicitClass2(cls)
implicit def toImplicitClass3(cls: ImplicitClass2) = new ImplicitClass3(cls)
implicit def toImplicitClass4(cls: ImplicitClass3) = new ImplicitClass4(cls)
implicit def toImplicitClass5(cls: ImplicitClass4) = new ImplicitClass5(cls)
implicit def toImplicitClass6(cls: ImplicitClass5) = new ImplicitClass6(cls)
implicit def toImplicitClass7(cls: ImplicitClass6) = new ImplicitClass7(cls)
implicit def toImplicitClass8(cls: ImplicitClass7) = new ImplicitClass8(cls)

  def m:ImplicitClass8 = {
    val x0:ImplicitClass0 = new ImplicitClass0
    val x1:ImplicitClass1 = x0
val x2:ImplicitClass2 = x1
val x3:ImplicitClass3 = x2
val x4:ImplicitClass4 = x3
val x5:ImplicitClass5 = x4
val x6:ImplicitClass6 = x5
val x7:ImplicitClass7 = x6
val x8:ImplicitClass8 = x7
    x8
  }
}
class ImplicitClass0
class ImplicitClass1(val cls: ImplicitClass0)
class ImplicitClass2(val cls: ImplicitClass1)
class ImplicitClass3(val cls: ImplicitClass2)
class ImplicitClass4(val cls: ImplicitClass3)
class ImplicitClass5(val cls: ImplicitClass4)
class ImplicitClass6(val cls: ImplicitClass5)
class ImplicitClass7(val cls: ImplicitClass6)
class ImplicitClass8(val cls: ImplicitClass7)
