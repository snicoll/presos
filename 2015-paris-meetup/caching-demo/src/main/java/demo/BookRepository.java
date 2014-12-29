package demo;

public interface BookRepository {

    Book findBook(Long id);

    Book updateBook(Long id, Book book);

    boolean removeBook(Long id);

    void removeAll();

}
