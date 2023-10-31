package uk.ac.york.eng2.bookscli.cli.commands;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import uk.ac.york.eng2.bookscli.cli.BookClient;
import uk.ac.york.eng2.bookscli.domain.Book;

@Command(name = "delete-book", description = "Delete a book by ID")
public class DeleteBookCommand implements Runnable {

    @jakarta.inject.Inject
    private BookClient client;

    @Parameters(index = "0", description = "The ID of the book")
    private Long id;

    @Override
    public void run() {
        Book book = client.getBook(id);
        if (book == null) {
            System.out.println("Book not found");
            System.exit(1);
            return;
        }
        
        client.deleteBook(id);
    }

}
