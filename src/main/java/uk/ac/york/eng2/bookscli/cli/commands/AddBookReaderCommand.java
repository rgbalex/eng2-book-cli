package uk.ac.york.eng2.bookscli.cli.commands;

import io.micronaut.http.HttpResponse;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import uk.ac.york.eng2.bookscli.cli.BookClient;

@Command(name = "add-book-reader", description = "Add a reader to a book")
public class AddBookReaderCommand implements Runnable {

    @jakarta.inject.Inject
    private BookClient client;

    @Parameters(index = "0", description = "The ID of the book")
    private Long bookId;

    @Parameters(index = "1", description = "The ID of the user")
    private Long userId;

    @Override
    public void run() {
        HttpResponse<Void> response = client.updateBookReaders(bookId, userId);
        System.out.println("Server responded with:" + response.getStatus());
    }
}