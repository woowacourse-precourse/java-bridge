package model;

import bridge.BridgeMaker;
import java.util.ArrayList;
import java.util.List;
import util.ErrorMessage;

public class User {
    private List<String> userInputs;

    public User() {
        userInputs = new ArrayList<>();
    }

    public static void validateUserInput(String userInput) {
        if (!isCorrectInput(userInput)) {
            throw new IllegalArgumentException(ErrorMessage.STAIRS_U_OR_D);
        }
    }

    private static boolean isCorrectInput(String userInput) {
        if (userInput.equals(BridgeMaker.UP_STAIRS) || userInput.equals(BridgeMaker.DOWN_STAIRS)) {
            return true;
        }
        return false;
    }
}
