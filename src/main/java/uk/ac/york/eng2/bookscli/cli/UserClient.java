package uk.ac.york.eng2.bookscli.cli;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import io.micronaut.http.client.annotation.Client;
import uk.ac.york.eng2.bookscli.domain.User;
import uk.ac.york.eng2.bookscli.dto.UserDTO;

@Client("${users.url:`http://localhost:8080/users`}")
public interface UserClient {

    @Get("/")
    public Iterable<User> list();

    @Post("/")
    public HttpResponse<Void> add(@Body UserDTO userDetails);

    @Get("/{id}")
    public User getUser(long id);
    
    @Put("/{id}")
    public HttpResponse<Void> updateUser(long id, @Body UserDTO user);

    @Delete("/{id}")
    public HttpResponse<Void> deleteUser(long id);
}
