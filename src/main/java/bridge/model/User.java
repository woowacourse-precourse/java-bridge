package bridge.model;

import bridge.ValidationException;
import bridge.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<String> userCommand = new ArrayList<>();

    public List<String> addUserCommand(String command) {
        userCommand.add(command);

        return userCommand;
    }

    public List<String> cleanUserCommand() {
        userCommand.clear();

        return userCommand;
    }

    public List<String> getUserCommand() {
        return userCommand;
    }
}
