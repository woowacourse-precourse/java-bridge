package bridge.model.valid;

import camp.nextstep.edu.missionutils.Console;

public interface InputValidator {
    void validateInput(String input) throws IllegalArgumentException;

    default String getValidInput() {
        try {
            String input = Console.readLine();
            validateInput(input);
            return input;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getValidInput();
        }
    }
}
