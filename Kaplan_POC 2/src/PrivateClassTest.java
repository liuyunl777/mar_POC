import java.lang.reflect.Constructor;

public class PrivateClassTest {

	public static void main(String[] args) {
		try {
			Class class1= Class.forName("PrivateClass");
			Constructor constructor= class1.getConstructor();
			System.out.println(constructor.isAccessible());
			PrivateClass privateClass= (PrivateClass) class1.newInstance();
			privateClass.say();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
