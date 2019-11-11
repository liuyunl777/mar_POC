import java.util.Collection;

public class GenericsWrapper {
static public<T extends BaseA> void printGeneric(T instance) { 
instance.printinstanceNamet();
}
public static void main(String[] aurgs) {
	Collection<E>
BaseA baseA = new BaseA("BasaA-1");
ParentA parentA = new ParentA("ParentA-5");

printGeneric(parentA);

printGeneric(baseA);
}
}