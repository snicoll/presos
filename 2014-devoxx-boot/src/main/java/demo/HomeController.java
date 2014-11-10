package demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Stephane Nicoll
 */
@RestController
public class HomeController {

    @Value("${hello.target:Devoxx}")
    private String conference;

    @RequestMapping("/")
    public String home() {
        return "Hello " + conference;
    }
}
