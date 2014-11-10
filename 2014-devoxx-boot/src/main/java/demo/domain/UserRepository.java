package demo.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Collection;

/**
 * @author Stephane Nicoll
 */
public interface UserRepository extends CrudRepository<User, String> {

    @RestResource(path = "by-username")
    User findByUsername(@Param("name")String username);

    Collection<User> findByFamilyName(@Param("name") String familyName);
}
