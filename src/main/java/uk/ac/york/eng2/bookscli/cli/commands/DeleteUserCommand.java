package uk.ac.york.eng2.bookscli.cli.commands;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import uk.ac.york.eng2.bookscli.cli.UserClient;
import uk.ac.york.eng2.bookscli.domain.User;

@Command(name = "delete-user", description = "Delete a user by ID")
public class DeleteUserCommand implements Runnable {

    @jakarta.inject.Inject
    private UserClient client;

    @Parameters(index = "0", description = "The ID of the user")
    private Long id;

    @Override
    public void run() {
        User user = client.getUser(id);
        if (user == null) {
            System.out.println("User not found");
            System.exit(1);
            return;
        }
        
        client.deleteUser(id);
    }

}
