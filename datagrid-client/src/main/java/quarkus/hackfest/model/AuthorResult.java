package quarkus.hackfest.model;

public class AuthorResult {
    private String uuid;
    private Author author;

    public AuthorResult() {
    }

    public AuthorResult(String uuid, Author author) {
        this.uuid = uuid;
        this.author = author;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "AuthorResult [author=" + author + ", uuid=" + uuid + "]";
    }

}
