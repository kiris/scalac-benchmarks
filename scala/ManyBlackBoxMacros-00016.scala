import scala.language.experimental.macros
import scala.reflect.macros.blackbox.Context

object ManyBlackBoxMacros {
def method1: Class1 = macro macro1
def method2: Class2 = macro macro2
def method3: Class3 = macro macro3
def method4: Class4 = macro macro4
def method5: Class5 = macro macro5
def method6: Class6 = macro macro6
def method7: Class7 = macro macro7
def method8: Class8 = macro macro8
def method9: Class9 = macro macro9
def method10: Class10 = macro macro10
def method11: Class11 = macro macro11
def method12: Class12 = macro macro12
def method13: Class13 = macro macro13
def method14: Class14 = macro macro14
def method15: Class15 = macro macro15
def method16: Class16 = macro macro16
def macro1(c: Context): c.Expr[Class1] = c.Expr[Class1](c.universe.reify(new Class1).tree)
def macro2(c: Context): c.Expr[Class2] = c.Expr[Class2](c.universe.reify(new Class2).tree)
def macro3(c: Context): c.Expr[Class3] = c.Expr[Class3](c.universe.reify(new Class3).tree)
def macro4(c: Context): c.Expr[Class4] = c.Expr[Class4](c.universe.reify(new Class4).tree)
def macro5(c: Context): c.Expr[Class5] = c.Expr[Class5](c.universe.reify(new Class5).tree)
def macro6(c: Context): c.Expr[Class6] = c.Expr[Class6](c.universe.reify(new Class6).tree)
def macro7(c: Context): c.Expr[Class7] = c.Expr[Class7](c.universe.reify(new Class7).tree)
def macro8(c: Context): c.Expr[Class8] = c.Expr[Class8](c.universe.reify(new Class8).tree)
def macro9(c: Context): c.Expr[Class9] = c.Expr[Class9](c.universe.reify(new Class9).tree)
def macro10(c: Context): c.Expr[Class10] = c.Expr[Class10](c.universe.reify(new Class10).tree)
def macro11(c: Context): c.Expr[Class11] = c.Expr[Class11](c.universe.reify(new Class11).tree)
def macro12(c: Context): c.Expr[Class12] = c.Expr[Class12](c.universe.reify(new Class12).tree)
def macro13(c: Context): c.Expr[Class13] = c.Expr[Class13](c.universe.reify(new Class13).tree)
def macro14(c: Context): c.Expr[Class14] = c.Expr[Class14](c.universe.reify(new Class14).tree)
def macro15(c: Context): c.Expr[Class15] = c.Expr[Class15](c.universe.reify(new Class15).tree)
def macro16(c: Context): c.Expr[Class16] = c.Expr[Class16](c.universe.reify(new Class16).tree)
}

class Class1
class Class2
class Class3
class Class4
class Class5
class Class6
class Class7
class Class8
class Class9
class Class10
class Class11
class Class12
class Class13
class Class14
class Class15
class Class16
