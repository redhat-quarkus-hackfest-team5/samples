package quarkus.hackfest.model;

import java.util.Objects;

import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;

public class Author {
    private String name;
    private String surname;

    public Author() {
    }
    
    @ProtoFactory
    public Author(String name, String surname) {
        this.name = Objects.requireNonNull(name);
        this.surname = Objects.requireNonNull(surname);
    }

    public void setName(String name) {
        this.name = Objects.requireNonNull(name);
    }

    @ProtoField(number = 1)
    public String getName() {
        return name;
    }

    public void setSurname(String surname) {
        this.surname = Objects.requireNonNull(surname);
    }

    @ProtoField(number = 2)
    public String getSurname() {
        return surname;
    }
    
}