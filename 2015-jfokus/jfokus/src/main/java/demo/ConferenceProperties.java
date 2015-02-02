package demo;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 *
 * @author Stephane Nicoll
 */
@ConfigurationProperties(prefix = "conference", ignoreUnknownFields = false)
public class ConferenceProperties {

	/**
	 * Bla bla bla bla.
	 */
	private String name = "Jfokus";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
