package news.project.news.repository;

import news.project.news.model.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ArticleRepository extends CrudRepository<Article, UUID> {
    Optional<Article> findById(UUID id);
    List<Article> findByAuthorId(UUID authorId);
    List<Article> findByPublish(Boolean publish);
}
