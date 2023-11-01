package uk.ac.york.eng2.bookscli.cli.commands;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import uk.ac.york.eng2.bookscli.cli.UserClient;
import uk.ac.york.eng2.bookscli.dto.UserDTO;

@Command(name = "add-user", description = "Add a user")
public class AddUserCommand implements Runnable {

    @jakarta.inject.Inject
    private UserClient client;

    @Parameters(index = "0", description = "The name of the user")
    private String title;

    @Parameters(index = "1", description = "The age of the user")
    private Integer year;

    @Override
    public void run() {
        UserDTO userDetails = new UserDTO(title, year);
        client.add(userDetails);
    }
}