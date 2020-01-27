package news.project.news.dto;

import java.util.UUID;

public class ArticleResponseDTO {
    private UUID articleId;

    private String title;

    private String content;

public ArticleResponseDTO(UUID articleId, String title, String content){
    this.articleId = articleId;
    this.content = content;
    this.title = title;

}

    public ArticleResponseDTO() {
    }

    public UUID getArticleId() {
        return articleId;
    }

    public void setArticleId(UUID articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
