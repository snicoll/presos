package demo.domain;

import demo.DemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
public class SpeakerRepositoryTest {

	@Autowired
	private SpeakerRepository speakerRepository;

	@Test
	public void testFindByTwitter() throws Exception {
		Speaker dave = speakerRepository.save(
				new Speaker("Dave", "Syer", "david_syer"));
		assertThat(speakerRepository
				.findByTwitter("david_syer").getId(), is(dave.getId()));
	}
}