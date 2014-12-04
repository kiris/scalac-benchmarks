import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context

object ManyWhiteBoxMacros {
def method1: Class1 = macro macro1
def method2: Class2 = macro macro2
def macro1(c: Context): c.Expr[Class1] = c.Expr[Class1](c.universe.reify(new Class1).tree)
def macro2(c: Context): c.Expr[Class2] = c.Expr[Class2](c.universe.reify(new Class2).tree)
}

class Class1
class Class2
