import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context

object ManyWhiteBoxMacros {
def method1: Class1 = macro macro1
def method2: Class2 = macro macro2
def method3: Class3 = macro macro3
def method4: Class4 = macro macro4
def method5: Class5 = macro macro5
def method6: Class6 = macro macro6
def method7: Class7 = macro macro7
def method8: Class8 = macro macro8
def macro1(c: Context): c.Expr[Class1] = c.Expr[Class1](c.universe.reify(new Class1).tree)
def macro2(c: Context): c.Expr[Class2] = c.Expr[Class2](c.universe.reify(new Class2).tree)
def macro3(c: Context): c.Expr[Class3] = c.Expr[Class3](c.universe.reify(new Class3).tree)
def macro4(c: Context): c.Expr[Class4] = c.Expr[Class4](c.universe.reify(new Class4).tree)
def macro5(c: Context): c.Expr[Class5] = c.Expr[Class5](c.universe.reify(new Class5).tree)
def macro6(c: Context): c.Expr[Class6] = c.Expr[Class6](c.universe.reify(new Class6).tree)
def macro7(c: Context): c.Expr[Class7] = c.Expr[Class7](c.universe.reify(new Class7).tree)
def macro8(c: Context): c.Expr[Class8] = c.Expr[Class8](c.universe.reify(new Class8).tree)
}

class Class1
class Class2
class Class3
class Class4
class Class5
class Class6
class Class7
class Class8
