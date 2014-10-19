package demo.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = UserAccountRepositoryTest.SimpleApplication.class)
public class UserAccountRepositoryTest {

    @Autowired
    private UserAccountRepository repository;

    @Before
    public void before() {
        repository.deleteAll();

        repository.save(Arrays.asList(
                new UserAccount(0L, "Dave", "Syer"),
                new UserAccount(1L, "Phil", "Web"),
                new UserAccount(2L, "Brol", "Brol")
        ));
    }

    @Test
    public void findByUsername() {
        assertThat(repository.findByUsername("dave.syer").getId(), is(0L));
    }


    @Configuration
    @EnableAutoConfiguration
    static class SimpleApplication {

    }

}