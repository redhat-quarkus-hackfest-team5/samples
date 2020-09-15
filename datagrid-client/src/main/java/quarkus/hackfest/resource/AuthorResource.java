package quarkus.hackfest.resource;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.infinispan.client.hotrod.RemoteCache;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.quarkus.infinispan.client.Remote;
import quarkus.hackfest.model.Author;
import quarkus.hackfest.model.AuthorResult;

@Path("/author")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthorResource {
    private static Logger log = LoggerFactory.getLogger(AuthorResource.class);
    
    @Inject 
    @Remote("authors")
    RemoteCache<String, Author> authors;

    @GET
    public Response list() {
        log.info("authors: {}", authors);

        Collection<String> existing = authors.keySet();

        if (existing != null && !existing.isEmpty()) {
            Set<AuthorResult> results = new HashSet<>();

            for (String key : existing) {
                results.add(new AuthorResult(key, authors.get(key)));
            }
            
            return Response.ok(results).build();
        } else {
            return Response.ok(new Author[]{}).build();
        }
    }

    @POST
    public Response add(Author author) {
        authors.put(UUID.randomUUID().toString(), author);
        return Response.accepted().build();
    }

    @GET
    @Path("/{uuid}")
    public Response get(@PathParam String uuid) {
        Author author = authors.get(uuid);
        if (author != null) {
            return Response.ok(author).build();
        }
        return Response.status(Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/{uuid}")
    public Response delete(@PathParam String uuid) {
        Author existing = authors.get(uuid);
        if (existing != null) {
            authors.remove(uuid);
            return Response.accepted().build();
        }
        return Response.status(Status.NOT_FOUND).build();
    }
}
