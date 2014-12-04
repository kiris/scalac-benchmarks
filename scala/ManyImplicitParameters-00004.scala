
class ManyImplicitParameters4 {
implicit val v1 = new Class1
implicit val v2 = new Class2
implicit val v3 = new Class3
implicit val v4 = new Class4

def method(implicit imp1:Class1,imp2:Class2,imp3:Class3,imp4:Class4) = println(imp1)
}
class Class1
class Class2
class Class3
class Class4
