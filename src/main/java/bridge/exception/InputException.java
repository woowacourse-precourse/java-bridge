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
}
