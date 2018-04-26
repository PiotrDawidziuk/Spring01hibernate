package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    public List<Book> findAllByTitle(String title);
    //public List<Book> findAllByPropostion(Boolean proposition);
    //public List<Book> findAllByPublisherId(Long id);

    public List<Book> findAllByAuthorId(Long id);
    public List<Book> findAllByPublisherId(Long id);
    public List<Book> findAllByRating(String rating);

}
