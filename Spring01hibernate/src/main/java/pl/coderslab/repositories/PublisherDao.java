package pl.coderslab.repositories;

import org.springframework.stereotype.Component;
import pl.coderslab.model.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class PublisherDao {
    @PersistenceContext
    EntityManager entityManager;

    public void savePublisher(Publisher entity) {
        entityManager.persist(entity);
    }

    public Publisher findById(long id) {
        return entityManager.find(Publisher.class, id);
    }

    public void update(Publisher entity) {
        entityManager.merge(entity);
    }

    public void delete(Publisher entity) {
        entityManager.remove(entityManager.contains(entity) ?
                entity : entityManager.merge(entity));
    }

    public List<Publisher> getPublishers() {
        Query query = entityManager.createQuery("SELECT p from Publisher p");
        List <Publisher> publishers= query.getResultList();
        return publishers;
    }
}