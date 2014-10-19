package demo.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "users")
public interface UserAccountRepository extends CrudRepository<UserAccount, Long> {

    @RestResource(path = "username")
    UserAccount findByUsername(@Param("name") String username);
}
