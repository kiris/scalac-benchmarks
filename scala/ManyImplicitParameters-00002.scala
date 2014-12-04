
class ManyImplicitParameters2 {
implicit val v1 = new Class1
implicit val v2 = new Class2

def method(implicit imp1:Class1,imp2:Class2) = println(imp1)
}
class Class1
class Class2
