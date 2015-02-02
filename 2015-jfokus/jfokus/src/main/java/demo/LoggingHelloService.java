package demo;

import hello.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Stephane Nicoll
 */
// Uncomment to ask boot to back off
//@Component
public class LoggingHelloService implements HelloService {

	private static final Logger logger = LoggerFactory.getLogger(LoggingHelloService.class);

	@Override
	public void sayHello() {
		logger.error("HELLO WORLD!");
	}

}
