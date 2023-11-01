package uk.ac.york.eng2.bookscli.cli.commands;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import uk.ac.york.eng2.bookscli.cli.BookClient;
import uk.ac.york.eng2.bookscli.domain.User;

@Command(name = "get-book-readers", description = "Gets the readers of a book by ID")
public class GetBookReadersCommand implements Runnable {
    
    @jakarta.inject.Inject
    private BookClient client;

    @Parameters(index = "0", description = "The ID of the book")
    private Long id;

    @Override
    public void run() {
        Iterable<User> readers = client.listReaders(id);
        if (readers == null) {
            System.out.println("An error has occured");
            System.exit(1);
            return;
        } else if (!readers.iterator().hasNext()) {
            System.out.println("No readers found");
            return;
        }

        for (User reader : readers) {
            System.out.println(reader);
        }
    }
}