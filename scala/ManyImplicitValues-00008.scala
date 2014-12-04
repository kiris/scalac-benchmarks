class ManyImplicitValuesClass8 {
implicit val v1 = new Class1
implicit val v2 = new Class2
implicit val v3 = new Class3
implicit val v4 = new Class4
implicit val v5 = new Class5
implicit val v6 = new Class6
implicit val v7 = new Class7
implicit val v8 = new Class8

def method(implicit imp:Class8) = println(imp)
}
class Class1
class Class2
class Class3
class Class4
class Class5
class Class6
class Class7
class Class8
