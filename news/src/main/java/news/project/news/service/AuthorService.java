package news.project.news.service;

import news.project.news.dto.ArticleResponseDTO;
import news.project.news.dto.AuthorResponseDTO;
import news.project.news.dto.CreateArticleDTO;
import news.project.news.dto.CreateAuthorAccountDTO;
import news.project.news.model.Article;
import news.project.news.model.Author;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

import java.util.List;
import java.util.UUID;

public interface AuthorService {
    Author createAuthorAccount(CreateAuthorAccountDTO authorAccountDTO);
    ResponseEntity<List<AuthorResponseDTO>> fetchAuthors(Pageable pageable);
    Article createArticle(CreateArticleDTO articleDTO, final OAuth2Authentication authentication);
    ResponseEntity<List<ArticleResponseDTO>> fetchArticles(Pageable pageable, UUID authorId);
    ResponseEntity<List<ArticleResponseDTO>> getAllArticles(Pageable pageable);
    ResponseEntity<Article> updateArticle(UUID articleId, CreateArticleDTO createArticleDTO);
    ResponseEntity<Article> deleteArticle(UUID articleId);
}
