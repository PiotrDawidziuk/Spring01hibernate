package pl.coderslab.repositories;

import org.springframework.stereotype.Component;
import pl.coderslab.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
@Transactional
public class PersonDao {
    @PersistenceContext
    EntityManager entityManager;

    public void savePerson(Person entity) {
        entityManager.persist(entity);
    }

    public Person findById(long id) {
        return entityManager.find(Person.class, id);
    }

    public void update(Person entity) {
        entityManager.merge(entity);
    }

    public void delete(Person entity) {
        entityManager.remove(entityManager.contains(entity) ?
                entity : entityManager.merge(entity));
    }
}