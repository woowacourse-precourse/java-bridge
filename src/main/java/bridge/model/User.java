package bridge.model;

import bridge.ValidationException;
import bridge.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<String> userCommand = new ArrayList<>();

    public void addUserCommand() {
        InputView inputView = new InputView(new ValidationException());

        userCommand.add(inputView.readMoving());
    }

    public void cleanUserCommand() {
        userCommand.clear();
    }

    public List<String> getUserCommand() {
        return userCommand;
    }
}
