package news.project.news.controller;


import news.project.news.dto.ArticleResponseDTO;
import news.project.news.dto.AuthorResponseDTO;
import news.project.news.dto.CreateArticleDTO;
import news.project.news.dto.CreateAuthorAccountDTO;
import news.project.news.model.Article;
import news.project.news.model.Author;
import news.project.news.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1")
public class AuthorManagement {
    @Autowired
    private AuthorService authorService;



    @RequestMapping(value = "/createauthoraccount", method = RequestMethod.POST, produces = {"application/json", "application/xml"})
    public Author createAuthorAccount(@Valid @RequestBody CreateAuthorAccountDTO authorAccountDTO) {
        Author createAuthorAccount = authorService.createAuthorAccount(authorAccountDTO);
        return createAuthorAccount;
    }

    @RequestMapping(value = "/authors", method = RequestMethod.GET, produces = {"application/json", "application/xml"})
    public ResponseEntity<List<AuthorResponseDTO>> fetchAuthors(@PageableDefault(value = 20) Pageable pageable) {
        ResponseEntity<List<AuthorResponseDTO>> fetchAuthors = authorService.fetchAuthors(pageable);
        return fetchAuthors;
    }

    @RequestMapping(value = "/createarticle", method = RequestMethod.POST, produces = {"application/json", "application/xml"})
    @PreAuthorize("hasAuthority('AUTHOR')")
    public Article createNewArticle(@Valid @RequestBody CreateArticleDTO articleDTO, final OAuth2Authentication authentication) {
        Article createArticle = authorService.createArticle(articleDTO, authentication);
        return createArticle;
    }
    @GetMapping("/articles")
    @RequestMapping(value = "/articles", method = RequestMethod.GET, produces = {"application/json", "application/xml"})
    public ResponseEntity<List<ArticleResponseDTO>> getAllArticles(@PageableDefault(value = 20) Pageable pageable) {
        ResponseEntity<List<ArticleResponseDTO>> getAllArticles = authorService.getAllArticles(pageable);
        return getAllArticles;
    }


    @RequestMapping(value = "/articles/{authorId}", method = RequestMethod.GET, produces = {"application/json", "application/xml"})
    @PreAuthorize("hasAuthority('AUTHOR')")
    public ResponseEntity<List<ArticleResponseDTO>> fetchArticles(@PageableDefault(value = 20) Pageable pageable, @PathVariable(value = "authorId") UUID authorId) {
        ResponseEntity<List<ArticleResponseDTO>> fetchArticles = authorService.fetchArticles(pageable, authorId);
        return fetchArticles;
    }


    @RequestMapping(value = "/authors", method = RequestMethod.PUT, produces = {"application/json", "application/xml"})
    @PreAuthorize("hasAuthority('AUTHOR')")
    public ResponseEntity<Article> updateArticle(@PathVariable(value = "id") UUID articleId,
                                         @RequestBody CreateArticleDTO createArticleDTO) {
        ResponseEntity<Article> updateArticle = authorService.updateArticle(articleId, createArticleDTO);
        return updateArticle;

    }


    @RequestMapping(value = "/deletearticle/{id}", method = RequestMethod.DELETE, produces = {"application/json", "application/xml"})
    @PreAuthorize("hasAuthority('AUTHOR')")
    public ResponseEntity<Article> deleteArticle(@PathVariable(value = "id") UUID articleId){
        ResponseEntity<Article> deletedArticle =authorService.deleteArticle(articleId);
        return deletedArticle;
    }
}
