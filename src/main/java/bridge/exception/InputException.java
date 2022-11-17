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
                throw new IllegalArgumentException("[ERROR] Input is Not Number");
            }
        }
    }

    public void inputNoRangeException(int input) throws IllegalArgumentException {
        if (input < 3 || 20 < input) {
            throw new IllegalArgumentException("[ERROR] Input is Not 3 to 20");
        }
    }

    public void inputNoOneCharException(String input) throws IllegalArgumentException {
        if (input.length() != 1) {
            throw new IllegalArgumentException("[ERROR] Input is Not One Character");
        }
    }

    public void inputInvalidCharException(String input, String terms1, String terms2)
            throws IllegalArgumentException {
        if (!(input.equals(terms1) || input.equals(terms2))) {
            throw new IllegalArgumentException("[ERROR] Input is Not " + terms1 + " or " + terms2);
        }
    }
}
