package demo;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableCaching
public class CachingDemoApplication {

    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("books");
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                new AnnotationConfigApplicationContext(CachingDemoApplication.class);

        BookRepository bookRepository = context.getBean(BookRepository.class);

        findBook(bookRepository, 0L);
        findBook(bookRepository, 1L);
        findBook(bookRepository, 0L);
        findBook(bookRepository, 0L);
        findBook(bookRepository, 0L);

        System.out.println("Bye bye");
        context.close();
    }

    private static Book findBook(BookRepository repository, long id) {
        long startTime = System.currentTimeMillis();
        Book book = repository.findBook(id);
        System.out.println("Found " + book + " - took " + (System.currentTimeMillis() - startTime) + "ms");
        return book;
    }

}
