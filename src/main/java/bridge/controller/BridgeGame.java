package bridge.controller;

import bridge.model.User;

public class BridgeGame {

    public void move(final User user, final String choice) {
        user.addChoice(choice);
    }

    public void retry(final User user) {
        user.resetChoices();
        user.addTryCount();
    }

}