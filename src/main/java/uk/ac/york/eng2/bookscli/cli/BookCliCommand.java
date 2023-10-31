package uk.ac.york.eng2.bookscli.cli;

import io.micronaut.configuration.picocli.PicocliRunner;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import uk.ac.york.eng2.bookscli.cli.commands.AddBookCommand;
import uk.ac.york.eng2.bookscli.cli.commands.DeleteBookCommand;
import uk.ac.york.eng2.bookscli.cli.commands.GetBookCommand;
import uk.ac.york.eng2.bookscli.cli.commands.GetBooksCommand;
import uk.ac.york.eng2.bookscli.cli.commands.UpdateBookCommand;

@Command(name = "book-cli", description = "...",
        mixinStandardHelpOptions = true, 
        subcommands = 
        { 
            AddBookCommand.class,
            GetBookCommand.class, 
            GetBooksCommand.class, 
            UpdateBookCommand.class,
            DeleteBookCommand.class, 
        }
    )
public class BookCliCommand implements Runnable {

    @Option(names = {"-v", "--verbose"}, description = "...")
    boolean verbose;

    public static void main(String[] args) throws Exception {
        PicocliRunner.run(BookCliCommand.class, args);
    }

    public void run() {
        // business logic here
        if (verbose) {
            System.out.println("Hi!");
        }
    }
}
