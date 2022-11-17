package bridge.exception;

public class InputException {

    public void inputNullException(String input) throws IllegalArgumentException {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] input is null");
        }
    }

    public void inputNoNumberException(String input) throws IllegalArgumentException {
        for (int index = 0; index < input.length(); index++) {
            char oneCharacter = input.charAt(index);
            if (!Character.isDigit(oneCharacter)) {
                throw new IllegalArgumentException("[ERROR] input is not Number");
            }
        }
    }

    public void inputNoRangeException(int input) throws IllegalArgumentException {
        if (input < 3 || 20 < input) {
            throw new IllegalArgumentException("[ERROR] input is not 3 to 20");
        }
    }
}
