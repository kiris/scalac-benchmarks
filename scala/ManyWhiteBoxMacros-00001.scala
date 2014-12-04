import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context

object ManyWhiteBoxMacros {
def method1: Class1 = macro macro1
def macro1(c: Context): c.Expr[Class1] = c.Expr[Class1](c.universe.reify(new Class1).tree)
}

class Class1
