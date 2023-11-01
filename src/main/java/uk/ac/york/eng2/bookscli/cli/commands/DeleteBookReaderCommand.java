package uk.ac.york.eng2.bookscli.cli.commands;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import uk.ac.york.eng2.bookscli.cli.BookClient;
import uk.ac.york.eng2.bookscli.domain.Book;

@Command(name = "delete-book-reader", description = "Delete a book reader by ID")
public class DeleteBookReaderCommand implements Runnable {

    @jakarta.inject.Inject
    private BookClient client;

    @Parameters(index = "0", description = "The ID of the book")
    private Long bookId;

    @Parameters(index = "1", description = "The ID of the reader")
    private Long readerId;

    @Override
    public void run() {
        Book book = client.getBook(bookId);
        if (book == null) {
            System.out.println("Book not found");
            System.exit(1);
            return;
        }
        
        client.deleteBookReader(bookId, readerId);
    }

}