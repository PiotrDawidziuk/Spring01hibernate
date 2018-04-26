package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
    public Publisher getPublisherByNip(String nip);
    public Publisher getPublisherByRegon(String regon);
}
