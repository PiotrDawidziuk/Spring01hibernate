package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.model.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b WHERE b.title = :title")
    public List<Book> findAllByTitle(@Param("title")String title);

    //public List<Book> findAllByPropostion(Boolean proposition);
    //public List<Book> findAllByPublisherId(Long id);

    @Query("SELECT b FROM Book b WHERE b.author= :author")
    public List<Book> findAllByAuthor(@Param("author") String lastName);
    //public List<Book> findAllByPublisher(String name);
  //  public List<Book> findAllByRating(String rating);

    @Query("SELECT b FROM Book b WHERE b.rating BETWEEN :min     AND :max")
    public List <Book> findAllByRating(@Param("min")String min, @Param("max") String max);

    @Query("SELECT b FROM Book b WHERE b.publisher= :publisher")
    public List <Book> findAllByPublisher(@Param("publisher")String publisher);


}
