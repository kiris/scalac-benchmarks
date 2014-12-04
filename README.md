# Scala Compiler Benchmarks #


## 環境 ##

### ハードウェア ###

* MacBook Pro Retina, 15-inch, Mid 2014
* 2.8 GHz Intel Core i7
* 16 GB 1600 MHz DDR3

### ソフトウェア ###

* Mac OS X 10.9.5（13F34）
* Java v1.7.0_67 HotSpot(TM) 64-Bit Server VM
* Scala v2.11.4(v2.10.4, v2.9.3, v2.8.2 final)
  * fscはJITコンパイルがかかるのでやめた

## ツール ##

* svm / 複数のScalaのバージョン切り替え
  * https://github.com/yuroyoro/svm
* avgtime / D言語で書かれたシンプルなベンチマークツール
  * https://github.com/jmcabo/avgtime
* ruby / Scalaのコードジェネレータとして


## ソースコードパターン ##

### ManyClasses ###

```scala
class Class1
class Class2
class Class3
class Class4
```

### ManyClasses ###

```scala
object Object1
object Object2
object Object3
object Object4
```

### ManyMethods ###

```scala
class ManyMethods4 {
def method1 = println("1")
def method2 = println("2")
def method3 = println("3")
def method4 = println("4")
}
```

### ManyTypeParams ###

```scala
class ManyTypeParams4[T1,T2,T3,T4]
```

### ManyAnonymousClasses ###

```scala
class ManyAnonymousClasses4 {
  val anonymousClass1 = new Base { def x = println("1") }
  val anonymousClass2 = new Base { def x = println("2") }
  val anonymousClass3 = new Base { def x = println("3") }
  val anonymousClass4 = new Base { def x = println("4") }
}
trait Base { def x:Unit }
```

### ManyTraitsMixin ###

```scala
class ManyTraitsMixin4 extends Trait1 with Trait2 with Trait3 with Trait4
trait Trait1
trait Trait2
trait Trait3
trait Trait4
```


### ManyTraitsWithTheMethodMixin ###

```scala
class ManyTraitsWithTheMethodMixin4 extends Trait1 with Trait2 with Trait3 with Trait4
trait Trait1 { def method1 = println("1") }
trait Trait2 { def method2 = println("2") }
trait Trait3 { def method3 = println("3") }
trait Trait4 { def method4 = println("4") }
```


### ManyImplicitConversions ###

```scala
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
```

### ManyImplicitValues ###

```scala
class ManyImplicitValues4 {
  implicit val v1 = new Class1
  implicit val v2 = new Class2
  implicit val v3 = new Class3
  implicit val v4 = new Class4

  def method(implicit imp:Class4) = println(imp)
  method
}
class Class1
class Class2
class Class3
class Class4
```

### ManyImplicitParameters ###

```scala
class ManyImplicitParameters4 {
  implicit val v1 = new Class1
  implicit val v2 = new Class2
  implicit val v3 = new Class3
  implicit val v4 = new Class4

  def method(implicit imp1:Class1,imp2:Class2,imp3:Class3,imp4:Class4) = println(imp1)
  method
}
class Class1
class Class2
class Class3
class Class4
```


### ManyWhiteBoxMacros(scala 2.11 only) ###

```scala
import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context

object ManyWhiteBoxMacros {
def method1: Class1 = macro macro1
def method2: Class2 = macro macro2
def method3: Class3 = macro macro3
def method4: Class4 = macro macro4
def macro1(c: Context): c.Expr[Class1] = c.Expr[Class1](c.universe.reify(new Class1).tree)
def macro2(c: Context): c.Expr[Class2] = c.Expr[Class2](c.universe.reify(new Class2).tree)
def macro3(c: Context): c.Expr[Class3] = c.Expr[Class3](c.universe.reify(new Class3).tree)
def macro4(c: Context): c.Expr[Class4] = c.Expr[Class4](c.universe.reify(new Class4).tree)
}

class Class1
class Class2
class Class3
class Class4
```

### ManyBlackBoxMacros(scala 2.11 only) ###

```scala
import scala.language.experimental.macros
import scala.reflect.macros.blackbox.Context

object ManyBlackBoxMacros {
def method1: Class1 = macro macro1
def method2: Class2 = macro macro2
def method3: Class3 = macro macro3
def method4: Class4 = macro macro4
def macro1(c: Context): c.Expr[Class1] = c.Expr[Class1](c.universe.reify(new Class1).tree)
def macro2(c: Context): c.Expr[Class2] = c.Expr[Class2](c.universe.reify(new Class2).tree)
def macro3(c: Context): c.Expr[Class3] = c.Expr[Class3](c.universe.reify(new Class3).tree)
def macro4(c: Context): c.Expr[Class4] = c.Expr[Class4](c.universe.reify(new Class4).tree)
}

class Class1
class Class2
class Class3
class Class4
```
