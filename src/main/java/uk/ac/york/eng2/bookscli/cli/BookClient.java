package uk.ac.york.eng2.bookscli.cli;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.annotation.Client;

import uk.ac.york.eng2.bookscli.domain.Book;
import uk.ac.york.eng2.bookscli.dto.BookDTO;

@Client("${books.url:`http://localhost:8080/books`}")
public interface BookClient {

    @Get("/")
    public Iterable<Book> list();

    @Post("/")
    public HttpResponse<Void> add(@Body BookDTO bookDetails);
    
}