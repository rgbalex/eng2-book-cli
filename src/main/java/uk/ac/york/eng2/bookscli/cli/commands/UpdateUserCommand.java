package uk.ac.york.eng2.bookscli.cli.commands;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import uk.ac.york.eng2.bookscli.cli.UserClient;
import uk.ac.york.eng2.bookscli.domain.User;
import uk.ac.york.eng2.bookscli.dto.UserDTO;

@Command(name = "update-user", description = "Update a users details")
public class UpdateUserCommand implements Runnable {

    @jakarta.inject.Inject
    private UserClient client;

    @Parameters(index = "0", description = "The ID of the user")
    private Long id;

    @Option(names={"-n", "--name"}, description = "The name of the user")
    private String title;

    @Option(names={"-a", "--age"}, description = "The age of the user")
    private Integer year;

    @Override
    public void run() {
        // Why get a user object here and not use the DTO?
        User user = client.getUser(id);
        if (user == null) {
            System.out.println("User not found");
            System.exit(1);
            return;
        }

        if (title != null) {
            user.setName(title);
        }

        if (year != null) {
            user.setAge(year);
        }

        // Making this the same as the above would cut down on operations.
        UserDTO userDetails = new UserDTO(user.getName(), user.getAge());
        client.updateUser(id, userDetails);
    }
}
