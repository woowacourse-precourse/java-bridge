package bridge.Service;

public class InputValidator {

    private static int MIN_SIZE = 3;
    private static int MAX_SIZE = 20;

    public void validateSize(String input) {
        int size = getValidatedSingleNumber(input);

        if (size < MIN_SIZE || size > MAX_SIZE) {
            throw new IllegalArgumentException("");
        }
    }

    public int getValidatedSingleNumber(String input) {
        int number = 0;

        try {
            number = Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("");
        }

        return number;
    }

}
