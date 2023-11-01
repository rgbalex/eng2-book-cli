package uk.ac.york.eng2.bookscli.cli.commands;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import uk.ac.york.eng2.bookscli.cli.BookClient;
import uk.ac.york.eng2.bookscli.domain.Book;
import uk.ac.york.eng2.bookscli.dto.BookDTO;

@Command(name = "update-book", description = "Update a books details")
public class UpdateBookCommand implements Runnable {

    @jakarta.inject.Inject
    private BookClient client;

    @Parameters(index = "0", description = "The ID of the book")
    private Long id;

    @Option(names={"-t", "--title"}, description = "The title of the book")
    private String title;

    @Option(names={"-y", "--year"}, description = "The year of the book")
    private Integer year;

    @Override
    public void run() {
        // Why get a book object here and not use the DTO?
        Book book = client.getBook(id);
        if (book == null) {
            System.out.println("Book not found");
            System.exit(1);
            return;
        }

        if (title != null) {
            book.setTitle(title);
        }

        if (year != null) {
            book.setYear(year);
        }

        // Making this the same as the above would cut down on operations.
        BookDTO bookDetails = new BookDTO(book.getTitle(), book.getYear());
        client.updateBook(id, bookDetails);
    }
}
