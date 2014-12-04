class ManyImplicitValuesClass2 {
implicit val v1 = new Class1
implicit val v2 = new Class2

def method(implicit imp:Class2) = println(imp)
}
class Class1
class Class2
