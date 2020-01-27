package news.project.news.util;

import news.project.news.model.Author;
import news.project.news.repository.AuthorRepository;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

import java.util.Optional;

public class PrincipalInfoUtil {
    public static Author getCurrentLoggedInAuthor(final OAuth2Authentication authentication, final AuthorRepository authorRepository) {

        final String principal = (String) authentication.getUserAuthentication().getPrincipal();
        Optional<Author> authorOpt = authorRepository.getAuthor(principal);

        if (authorOpt.isPresent()) {

            return authorOpt.get();

        } else {
            return null;
        }
    }
}
