package uk.ac.york.eng2.bookscli.cli.commands;

import picocli.CommandLine.Command;
import uk.ac.york.eng2.bookscli.cli.UserClient;
import uk.ac.york.eng2.bookscli.domain.User;

@Command(name = "get-users", description = "Get a list of all users")
public class GetUsersCommand implements Runnable {

    @jakarta.inject.Inject
    private UserClient client;

    @Override
    public void run() {
        Iterable<User> out = client.list();
        for (var user : out) {
            System.out.println(user);
        }
    }
}