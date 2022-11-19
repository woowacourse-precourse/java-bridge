package bridge.Service;

public class InputValidator {

    private static int MIN_SIZE = 3;
    private static int MAX_SIZE = 20;

    public void validateSize(int size) {
        if (size < MIN_SIZE || size > MAX_SIZE) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    public void validateDigit(String input) {
        boolean result = input.chars()
                .allMatch(Character::isDigit);

        if (result == false) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

}
