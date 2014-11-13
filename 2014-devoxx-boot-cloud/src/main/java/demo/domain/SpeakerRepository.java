package demo.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Collection;

/**
 * @author Stephane Nicoll
 */
public interface SpeakerRepository extends PagingAndSortingRepository<Speaker, Long> {

    @RestResource(path = "by-twitter")
    Speaker findByTwitter(@Param("id") String twitter);

    Collection<Speaker> findByLastName(@Param("name") String lastName);

}
