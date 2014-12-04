
FACT = 12

def loop_str(str, loop)
  (1..loop).map { |i|
    sprintf(str, i, i-1)
  }
end

def nested_str(str, loop, i = 0)
  if i == loop
    ""
  else
    sprintf(str, nested_str(str, loop, i + 1),  i, i-1)
  end
end

def fact_gen(filename, loop)
  for i in 0..loop
    f = 2 ** i
    yield sprintf(filename, f), f
  end
end

def loop_gen(filename, loop)
  for i in 0..loop
    yield sprintf(filename, i), i
  end

end

fact_gen("scala/ManyClasses-%05d.scala", FACT) { |filename, loop|
  classes = loop_str("class Class%1$d", loop).join("\n")

  File.write(filename, classes)
}

fact_gen("scala/ManyObjects-%05d.scala", FACT) { |filename, loop|
  objects = loop_str("object Object%1$d", loop).join("\n")

  File.write(filename, objects)
}

fact_gen("scala/ManyMethods-%05d.scala", FACT) { |filename, loop|
  methods = loop_str("def method%1$d = println(\"%1$d\")", loop).join("\n")
  str     = <<EOS
class ManyMethods#{loop} {
#{methods}
}
EOS

  File.write(filename, str)
}

fact_gen("scala/ManyTypeParams-%05d.scala", FACT) { |filename, loop|
  params = loop_str("T%d", loop).join(',')
  str    = "class ManyTypeParams#{loop}[#{params}]"

  File.write(filename, str)
}

fact_gen("scala/ManyTraitsMixin-%05d.scala", FACT) { |filename, loop|
  traits = loop_str("trait Trait%1$d", loop).join("\n")
  mixin  = loop_str("Trait%d", loop).join(' with ')
  str    = <<EOS
class ManyTraitsMixin#{loop} extends #{mixin}
#{traits}
EOS

  File.write(filename, str)
}

fact_gen("scala/ManyTraitsWithTheMethodMixin-%05d.scala", FACT) { |filename, loop|
  traits = loop_str("trait Trait%1$d { def method%1$d = println(\"%1$d\") }", loop).join("\n")
  mixin  = loop_str("Trait%d", loop).join(' with ')
  str    = <<EOS
class ManyTraitsWithTheMethodMixin#{loop} extends #{mixin}
#{traits}
EOS

  File.write(filename, str)
}

fact_gen("scala/ManyAnonymousClasses-%05d.scala", FACT) { |filename, loop|
  anonymousClasses = loop_str("val anonymousClass%1$d = new Base { def x = println(\"%1$d\") }", loop).join("\n")
  trait = "trait Base { def x:Unit }"
  str   = <<EOS
class ManyAnonymousClasses#{loop} {
#{anonymousClasses}
}
#{trait}
EOS

  File.write(filename, str)
}

fact_gen("scala/ManyImplicitConversions-%05d.scala", FACT) { |filename, loop|
  classes = ["class ImplicitClass0"].concat(loop_str("class ImplicitClass%1$d(val cls: ImplicitClass%2$d)", loop)).join("\n")
  body    = loop_str("val x%1$d:ImplicitClass%1$d = x%2$d", loop).join("\n")
  methods = loop_str("implicit def toImplicitClass%1$d(cls: ImplicitClass%2$d) = new ImplicitClass%1$d(cls)", loop).join("\n")

  str    = <<EOS
class ManyImplicitConversions#{loop} {
#{methods}

  def m:ImplicitClass#{loop} = {
    val x0:ImplicitClass0 = new ImplicitClass0
    #{body}
    x#{loop}
  }
}
#{classes}
EOS

  File.write(filename, str)
}

fact_gen("scala/ManyImplicitValues-%05d.scala", FACT) { |filename, loop|
  values  = loop_str("implicit val v%1$d = new Class%1$d", loop).join("\n")
  classes = loop_str("class Class%1$d", loop).join("\n")
  str     = <<EOS
class ManyImplicitValuesClass#{loop} {
#{values}

def method(implicit imp:Class#{loop}) = println(imp)
}
#{classes}
EOS

  File.write(filename, str)
}

fact_gen("scala/ManyImplicitParameters-%05d.scala", FACT) { |filename, loop|
  values  = loop_str("implicit val v%1$d = new Class%1$d", loop).join("\n")
  params  = loop_str("imp%1$d:Class%1$d", loop).join(',')
  classes = loop_str("class Class%1$d", loop).join("\n")
  str     = <<EOS

class ManyImplicitParameters#{loop} {
#{values}

def method(implicit #{params}) = println(imp1)
}
#{classes}
EOS

  File.write(filename, str)
}

fact_gen("scala/ManyWhiteBoxMacros-%05d.scala", FACT) { |filename, loop|
  methods = loop_str("def method%1$d: Class%1$d = macro macro%1$d", loop).join("\n")
  macros  = loop_str("def macro%1$d(c: Context): c.Expr[Class%1$d] = c.Expr[Class%1$d](c.universe.reify(new Class%1$d).tree)", loop).join("\n")
  classes = loop_str("class Class%1$d", loop).join("\n")
  str     = <<EOS
import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context

object ManyWhiteBoxMacros {
#{methods}
#{macros}
}

#{classes}
EOS

  File.write(filename, str)
}

fact_gen("scala/ManyBlackBoxMacros-%05d.scala", FACT) { |filename, loop|
  methods = loop_str("def method%1$d: Class%1$d = macro macro%1$d", loop).join("\n")
  macros  = loop_str("def macro%1$d(c: Context): c.Expr[Class%1$d] = c.Expr[Class%1$d](c.universe.reify(new Class%1$d).tree)", loop).join("\n")
  classes = loop_str("class Class%1$d", loop).join("\n")
  str     = <<EOS
import scala.language.experimental.macros
import scala.reflect.macros.blackbox.Context

object ManyBlackBoxMacros {
#{methods}
#{macros}
}

#{classes}
EOS

  File.write(filename, str)
}

fact_gen("scala/DeeplyNestedClass-%05d.scala", FACT) { |filename, loop|
  nested_class = nested_str("class NestedClass%2$d {\n%1$s\n}", loop, 0)
  str     = <<EOS
class DeeplyNestedClass {
#{nested_class}
}
EOS

  File.write(filename, str)
}

fact_gen("scala/DeeplyNestedForeach-%05d.scala", FACT) { |filename, loop|
  nested_foreach = nested_str("List(1, 2, 3).foreach { x$2$d => %1$s }", loop, 0)
  str     = <<EOS
class DeeplyNestedForeach {
#{nested_foreach}
}
EOS

  File.write(filename, str)
}

fact_gen("scala/DeeplyNestedMap-%05d.scala", FACT) { |filename, loop|
  nested_map = nested_str("List(1, 2, 3).map { x$2$d => %1$s }", loop, 0)
  str     = <<EOS
class DeeplyNestedMap {
#{nested_map}
}
EOS

  File.write(filename, str)
}

fact_gen("scala/ManyMaps-%05d.scala", FACT) { |filename, loop|
  maps = loop_str("List(1, 2, 3).map { x => x }", loop).join("\n")
  str     = <<EOS
class ManyMaps {
#{maps}
}
EOS

  File.write(filename, str)
}

# fact_gen("scala/ManyImplicitParameters-%05d.scala", FACT) { |filename, loop|
#   classes = loop_str("class ImplicitParameters%1$d", loop).join("\n")
#   methods = loop_str("implicit def toImplicitClasses%1$d(cls: ImplicitClasses%2$d) = new ImplicitClasses%1$d()", loop).drop(1).join("\n")
#   body    = loop_str("val x%1$d:ImplicitClasses%1$d = x%2$d", loop).drop(1).join("\n")
#   str = "class ManyImplicitConversions#{loop} { \n#{methods}\ndef m:ImplicitClasses#{loop} = { val x1:ImplicitClasses1 = new ImplicitClasses1()\n#{body}\n x#{loop} } }\n#{classes}"

#   File.write(filename, str)
# }

# fact_gen("scala/ManyAnonymousImplicitConversions-%05d.scala", FACT) { |filename, loop|
#   classes = ["class ImplicitClasses0"].concat(loop_str("class ImplicitClasses%1$d(val cls: ImplicitClasses%2$d)", loop)).join("\n")
#   methods = loop_str("implicit def toImplicitClasses%1$d(cls: ImplicitClasses%2$d) = new ImplicitClasses%1$d(cls)", loop).join("\n")
#   body    = loop_str("val x%1$d:ImplicitClasses%1$d = x%2$d", loop).join("\n")
#   str = "class ManyImplicitConversions#{loop} { \n#{methods}\ndef m:ImplicitClasses#{loop} = { val x0:ImplicitClasses0 = new ImplicitClasses\n#{body}\n x#{loop} } }\n#{classes}"

#   File.write(filename, str)
# }

