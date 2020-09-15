package quarkus.hackfest.model;

import java.util.Objects;
import java.util.Set;

import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;

public class Book {
    private Integer id;
    private String title;
    private String description;
    private Integer publicationYear;
    private Set<Author> authors;

    public Book() {
    }

    @ProtoFactory
    public Book(Integer id, String title, String description, Integer publicationYear, Set<Author> authors) {
        this.title = Objects.requireNonNull(title);
        this.description = Objects.requireNonNull(description);
        this.publicationYear = publicationYear;
        this.authors = Objects.requireNonNull(authors);
    }

    public void setId(Integer id) {
        this.id = Objects.requireNonNull(id);
    }

    @ProtoField(number = 1)
    public Integer getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = Objects.requireNonNull(title);
    }

    @ProtoField(number = 2)
    public String getTitle() {
        return title;
    }

    public void setDescription(String description) {
        this.description = Objects.requireNonNull(description);
    }

    @ProtoField(number = 3)
    public String getDescription() {
        return description;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = Objects.requireNonNull(publicationYear);
    }

    @ProtoField(number = 4)
    public Integer getPublicationYear() {
        return publicationYear;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = Objects.requireNonNull(authors);
    }

    @ProtoField(number = 5)
    public Set<Author> getAuthors() {
        return authors;
    }

}
