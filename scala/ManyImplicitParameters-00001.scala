
class ManyImplicitParameters1 {
implicit val v1 = new Class1

def method(implicit imp1:Class1) = println(imp1)
}
class Class1
