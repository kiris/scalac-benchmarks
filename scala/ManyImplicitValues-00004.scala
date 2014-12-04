class ManyImplicitValuesClass4 {
implicit val v1 = new Class1
implicit val v2 = new Class2
implicit val v3 = new Class3
implicit val v4 = new Class4

def method(implicit imp:Class4) = println(imp)
}
class Class1
class Class2
class Class3
class Class4
