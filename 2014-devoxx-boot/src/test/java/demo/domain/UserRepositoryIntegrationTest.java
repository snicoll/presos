package demo.domain;

import demo.Application;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class UserRepositoryIntegrationTest {

    @Autowired
    private UserRepository repository;

    @Before
    @After
    public void clearStore() {
          repository.deleteAll();
    }

    @Test
    public void testFindByUsername() throws Exception {
        User dsyer = repository.save(new User("Dave", "Syer"));
        assertThat(repository.findByUsername("dave.syer").getId(), is(dsyer.getId()));

    }
}