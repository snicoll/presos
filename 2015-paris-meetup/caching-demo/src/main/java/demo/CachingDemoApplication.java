package demo;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class CachingDemoApplication {

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
