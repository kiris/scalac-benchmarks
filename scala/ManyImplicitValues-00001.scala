class ManyImplicitValuesClass1 {
implicit val v1 = new Class1

def method(implicit imp:Class1) = println(imp)
}
class Class1
