package demo.web;

import demo.domain.Speaker;
import demo.domain.SpeakerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Stephane Nicoll
 */
@Controller
public class SpeakerController {

	private final SpeakerRepository speakerRepository;

	@Autowired
	public SpeakerController(SpeakerRepository speakerRepository) {
		this.speakerRepository = speakerRepository;
	}

	@RequestMapping("/ui/speakers/{id}")
	public String show(@PathVariable Long id, ModelMap model) {
		Speaker speaker = speakerRepository.findOne(id);
		if (speaker == null) {
			throw new SpeakerNotFoundException();
		}
		model.put("speaker", speaker);
		return "speakers/show";

	}


	@ResponseStatus(HttpStatus.NOT_FOUND)
	static class SpeakerNotFoundException extends RuntimeException {
	}

}
