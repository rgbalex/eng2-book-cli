package uk.ac.york.eng2.bookscli.cli;

import io.micronaut.configuration.picocli.PicocliRunner;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import uk.ac.york.eng2.bookscli.cli.commands.AddUserCommand;
import uk.ac.york.eng2.bookscli.cli.commands.DeleteUserCommand;
import uk.ac.york.eng2.bookscli.cli.commands.GetUserCommand;
import uk.ac.york.eng2.bookscli.cli.commands.GetUsersCommand;
import uk.ac.york.eng2.bookscli.cli.commands.UpdateUserCommand;

@Command(name = "user-cli", description = "...",
        mixinStandardHelpOptions = true, 
        subcommands = 
        { 
            AddUserCommand.class,
            GetUserCommand.class, 
            GetUsersCommand.class, 
            UpdateUserCommand.class,
            DeleteUserCommand.class, 
        }
    )
public class UserCliCommand implements Runnable {

    @Option(names = {"-v", "--verbose"}, description = "...")
    boolean verbose;

    public static void main(String[] args) throws Exception {
        PicocliRunner.run(UserCliCommand.class, args);
    }

    public void run() {
        // business logic here
        if (verbose) {
            System.out.println("Hi!");
        }
    }
}
