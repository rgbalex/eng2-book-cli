package uk.ac.york.eng2.books.cli;

import picocli.CommandLine.Command;
import uk.ac.york.eng2.books.domain.Book;

@Command(name = "get-books", description = "Get a list of all books")
public class GetBooksCommand implements Runnable {

    @jakarta.inject.Inject
    private BookClient client;

    @Override
    public void run() {
        Iterable<Book> out = client.list();
        for (var book : out) {
            System.out.println(book);
        }
    }
}
