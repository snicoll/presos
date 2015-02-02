package demo.web;

import demo.ConferenceProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Stephane Nicoll
 */
@RestController
public class HomeController {

	private final ConferenceProperties conferenceProperties;

	@Autowired
	public HomeController(ConferenceProperties conferenceProperties) {
		this.conferenceProperties = conferenceProperties;
	}

	@RequestMapping("/")
	@Secured("ROLE_HERO")
	public String home() {
		return "Hello " + this.conferenceProperties.getName();
	}
}
