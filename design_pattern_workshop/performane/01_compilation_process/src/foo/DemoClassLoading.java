package foo;
import java.lang.reflect.Method;

class Foo{
	static int a=5;
	static {
		//a=100;
		System.out.println("foo static block is called");
	}
	void foof() {
		System.out.println("foof method");
	}
}
public class DemoClassLoading {
	
	public static void main(String[] args) throws ClassNotFoundException {
		Class<?> c=Class.forName("foo.Foo");  //Foo.class;
		
		Method []methods=c.getDeclaredMethods();
		for(Method m: methods) {
			System.out.println(m.getName());
		}
		
		/*
		 * System.out.println(String.class.getClassLoader());
		 * System.out.println(Foo.class.getClassLoader());
		 */
		
		//Class<?> c=Foo.class;
		//System.out.println(Foo.a);
		
	//	Class<?> c=Class.forName("foo.Foo1");
//		Class<?> c2=Class.forName("foo.Foo");
		
		
//		Method []methods=c.getMethods();
//		for(Method m: methods) {
//			System.out.println(m.getName());
//		}
//		
//		System.out.println("hello");
		
	}

}
