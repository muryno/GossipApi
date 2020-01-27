package news.project.news.repository;

import news.project.news.model.Author;
import news.project.news.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AuthorRepository extends CrudRepository<Author, UUID> {
    @Query("SELECT u.author FROM User u WHERE u.email = :principal")
    Optional<Author> getAuthor(@Param("principal") String principal);

    List<Author>  findAll();
}
