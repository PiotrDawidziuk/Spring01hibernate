package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    public Author getAuthorByEmail(String email);
    public Author getAuthorByPesel(String pesel);
    public List<Author> getAllByLastName (String lastName);

}
