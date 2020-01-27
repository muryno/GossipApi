package news.project.news.service;

import news.project.news.dto.ArticleResponseDTO;
import news.project.news.dto.AuthorResponseDTO;
import news.project.news.dto.CreateArticleDTO;
import news.project.news.dto.CreateAuthorAccountDTO;
import news.project.news.enums.UserType;
import news.project.news.model.Article;
import news.project.news.model.Author;
import news.project.news.model.Role;
import news.project.news.model.User;
import news.project.news.repository.ArticleRepository;
import news.project.news.repository.AuthorRepository;
import news.project.news.repository.UserRepository;
import news.project.news.util.PrincipalInfoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public Author createAuthorAccount(CreateAuthorAccountDTO authorAccountDTO) {
        try {

            Author newAuthor = createNewAuthorAccount(authorAccountDTO);
            User user = authorAccountDTO.getUser();
            newAuthor.setUser(null);
            newAuthor = authorRepository.save(newAuthor);
            List<Role> roles = new ArrayList();
            Role r = new Role();
            r.setRoleName("AUTHOR");
            r.setDescription("Author Details");
            roles.add(r);
            user.setRoles(roles);
            user.setAuthor(newAuthor);
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            user.setUserType(UserType.AUTHOR);
            authorAccountDTO.setUser(user);
            userRepository.save(user);


            return authorRepository.save(newAuthor);

        } catch (Exception exc) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Author not created successfully", exc);
        }
    }
    @Override
    public ResponseEntity<List<AuthorResponseDTO>> fetchAuthors(Pageable pageable) {
        List<AuthorResponseDTO> authorList = new ArrayList<>();
        authorRepository.findAll().forEach(author -> {

            authorList.add(new AuthorResponseDTO(author.getId(), author.getFirstName(), author.getLastName()));

        });
        return new ResponseEntity<>(authorList, HttpStatus.OK);

    }
    @Override
    public Article createArticle(CreateArticleDTO articleDTO, final OAuth2Authentication authentication) {
        try {

            Article newArticle = createNewArticle(articleDTO);
            final Author author = PrincipalInfoUtil.getCurrentLoggedInAuthor(authentication, authorRepository);
            newArticle.setAuthor(author);

            return articleRepository.save(newArticle);

        } catch (Exception exc) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Article not created successfully", exc);
        }
    }
    @Override
    public ResponseEntity<List<ArticleResponseDTO>> fetchArticles(Pageable pageable, UUID authorId) {
        List<ArticleResponseDTO> articleList = new ArrayList<>();
        articleRepository.findByAuthorId(authorId).forEach(article -> {

            articleList.add(new ArticleResponseDTO(article.getId(), article.getTitle(), article.getContent()));

        });
        return new ResponseEntity<>(articleList, HttpStatus.OK);

    }
    @Override
    public ResponseEntity<List<ArticleResponseDTO>> getAllArticles(Pageable pageable) {
        List<ArticleResponseDTO> articleList = new ArrayList<>();
        articleRepository.findByPublish(true).forEach(article -> {

            articleList.add(new ArticleResponseDTO(article.getId(), article.getTitle(), article.getContent()));

        });
        return new ResponseEntity<>(articleList, HttpStatus.OK);

    }
    @Override
    public ResponseEntity<Article> updateArticle(UUID articleId, CreateArticleDTO createArticleDTO) {
        Optional<Article> article = articleRepository.findById(articleId);
        if (article == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        Article existingArticle = article.get();
        if (createArticleDTO.getTitle() != null) {
            existingArticle.setTitle(createArticleDTO.getTitle());
        }
        if (createArticleDTO.getContent() != null) {
            existingArticle.setContent(createArticleDTO.getContent());
        }

        Article updatedArticle = articleRepository.save(existingArticle);

        return new ResponseEntity<Article>(updatedArticle, HttpStatus.OK);

    }
    @Override
    public ResponseEntity<Article> deleteArticle(UUID articleId) {
        Optional<Article> article = articleRepository.findById(articleId);
        if (article == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        Article article1 = article.get();
        articleRepository.delete(article1);

        return ResponseEntity.ok().build();
    }
    private Author createNewAuthorAccount(CreateAuthorAccountDTO authorAccountDTO) {
        return new Author(authorAccountDTO.getBio(), authorAccountDTO.getFirstName(), authorAccountDTO.getLastName(), authorAccountDTO.getUser());
    }
    private Article createNewArticle(CreateArticleDTO articleDTO) {
        return new Article(articleDTO.getTitle(), articleDTO.getContent(), articleDTO.isPublish());
    }
}
