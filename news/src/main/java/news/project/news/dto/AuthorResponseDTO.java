package news.project.news.dto;

import java.util.UUID;

public class AuthorResponseDTO {

    private UUID authorId;

    private String firstName;

    private String lastName;


    public AuthorResponseDTO(UUID authorId, String firstName, String lastName) {
        this.authorId = authorId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public AuthorResponseDTO() {
    }

    public UUID getAuthorId() {
        return authorId;
    }

    public void setAuthorId(UUID authorId) {
        this.authorId = authorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
