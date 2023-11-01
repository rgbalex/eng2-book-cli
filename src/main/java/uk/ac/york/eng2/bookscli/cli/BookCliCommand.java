package uk.ac.york.eng2.bookscli.cli;

import io.micronaut.configuration.picocli.PicocliRunner;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import uk.ac.york.eng2.bookscli.cli.commands.AddBookCommand;
import uk.ac.york.eng2.bookscli.cli.commands.AddBookReaderCommand;
import uk.ac.york.eng2.bookscli.cli.commands.AddUserCommand;
import uk.ac.york.eng2.bookscli.cli.commands.DeleteBookCommand;
import uk.ac.york.eng2.bookscli.cli.commands.DeleteUserCommand;
import uk.ac.york.eng2.bookscli.cli.commands.GetBookCommand;
import uk.ac.york.eng2.bookscli.cli.commands.GetBookReadersCommand;
import uk.ac.york.eng2.bookscli.cli.commands.GetBooksCommand;
import uk.ac.york.eng2.bookscli.cli.commands.GetUserCommand;
import uk.ac.york.eng2.bookscli.cli.commands.GetUsersCommand;
import uk.ac.york.eng2.bookscli.cli.commands.UpdateBookCommand;
import uk.ac.york.eng2.bookscli.cli.commands.UpdateUserCommand;

@Command(name = "user-cli", description = "...",
        mixinStandardHelpOptions = true, 
        subcommands = 
        { 
            //Book Commands
            AddBookCommand.class,
            GetBookCommand.class, 
            GetBooksCommand.class, 
            UpdateBookCommand.class,
            DeleteBookCommand.class, 
            // User Commands
            AddUserCommand.class,
            GetUserCommand.class, 
            GetUsersCommand.class, 
            UpdateUserCommand.class,
            DeleteUserCommand.class,
            // Many to Many Commands
            GetBookReadersCommand.class, 
            AddBookReaderCommand.class,
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
