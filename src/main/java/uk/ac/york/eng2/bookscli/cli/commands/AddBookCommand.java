package uk.ac.york.eng2.bookscli.cli.commands;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import uk.ac.york.eng2.bookscli.cli.BookClient;
import uk.ac.york.eng2.bookscli.dto.BookDTO;

@Command(name = "add-book", description = "Add a book")
public class AddBookCommand implements Runnable {

    @jakarta.inject.Inject
    private BookClient client;

    @Parameters(index = "0", description = "The title of the book")
    private String title;

    @Parameters(index = "1", description = "The year of the book")
    private Integer year;

    @Override
    public void run() {
        BookDTO bookDetails = new BookDTO(title, year);
        client.add(bookDetails);
    }
}