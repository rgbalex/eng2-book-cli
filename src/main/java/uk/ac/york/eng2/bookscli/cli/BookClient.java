package uk.ac.york.eng2.bookscli.cli;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import io.micronaut.http.client.annotation.Client;

import uk.ac.york.eng2.bookscli.domain.Book;
import uk.ac.york.eng2.bookscli.domain.User;
import uk.ac.york.eng2.bookscli.dto.BookDTO;

@Client("${books.url:`http://localhost:8080/books`}")
public interface BookClient {

    @Get("/")
    Iterable<Book> list();

    @Get("/{id}/readers")
    Iterable<User> listReaders(long id);

    @Put("/{bookId}/readers/{readerId}")
    HttpResponse<Void> updateBookReaders(long bookId, long readerId);

    @Post("/")
    HttpResponse<Void> add(@Body BookDTO bookDetails);

    @Get("/{id}")
    Book getBook(long id);
    
    @Put("/{id}")
    HttpResponse<Void> updateBook(long id, @Body BookDTO book);

    @Delete("/{id}")
    HttpResponse<Void> deleteBook(long id);

    @Delete("/{bookId}/readers/{readerId}")
    HttpResponse<Void> deleteBookReader(long bookId, long readerId);
}
