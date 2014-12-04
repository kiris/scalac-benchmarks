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
