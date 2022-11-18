package bridge;

public class Validator {
    private final int SHORTEST_LEGNTH = 3;
    private final int LONGEST_LENGTH = 20;

    public Validator() {
    }

    public void bridgeLengthValidate(String length) {
        if (!(isNotWrongLength(length) && isOnlyContainDigit(length) && isNotWrongRange(length))) {
            throw new IllegalArgumentException(WRONG_INPUT);
        }
    }

    private boolean isNotWrongLength(String input) {
        return input.length() == 1 || input.length() == 2;
    }

    private boolean isOnlyContainDigit(String input) {
        for (int i = 0; i < input.length(); i++) {
            char character = input.charAt(i);

            if (!Character.isDigit(character)) {
                return false;
            }
        }

        return true;
    }

    private boolean isNotWrongRange(String input) {
        int bridgeLength = Integer.parseInt(input);

        return SHORTEST_LEGNTH <= bridgeLength && bridgeLength <= LONGEST_LENGTH;
    }
}
