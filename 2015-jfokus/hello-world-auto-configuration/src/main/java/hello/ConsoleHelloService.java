package hello;

/**
 *
 * @author Stephane Nicoll
 */
public class ConsoleHelloService implements HelloService {

	@Override
	public void sayHello() {
		System.out.println("Hello World!");
	}

}
