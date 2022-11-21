package bridge.domain;

import bridge.constant.ErrorMessage;

public class UserBridge {
    private final String userInput;

    public UserBridge(String userInput) {
        validateType(userInput);
        this.userInput = userInput;
    }

    private void validateType(String userInput) {
        if (!userInput.matches("[UD]")) {
            throw new IllegalArgumentException(ErrorMessage.SPACE_TYPE.getMessage());
        }
    }

    public String getUserInput() {
        return userInput;
    }
}
