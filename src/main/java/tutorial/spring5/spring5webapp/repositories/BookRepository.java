package tutorial.spring5.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import tutorial.spring5.spring5webapp.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
