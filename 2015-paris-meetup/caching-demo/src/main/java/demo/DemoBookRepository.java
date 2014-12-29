package demo;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
class DemoBookRepository implements BookRepository {

    @Override
    @Cacheable("books")
    public Book findBook(Long id) {
        sleep(1000);
        return new Book(id, "Demo book");
    }

    @Override
    public Book updateBook(Long id, Book book) {
        sleep(5000);
        return book;
    }

    @Override
    public boolean removeBook(Long id) {
        return false;
    }

    @Override
    public void removeAll() {
        sleep(10000);
    }

    // Don't do this at home
    private void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException o_O) {
            throw new IllegalStateException("Ooops", o_O);
        }
    }

}
