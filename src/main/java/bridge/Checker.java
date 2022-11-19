package bridge;

public class Checker {
    public int checkValidate(String input) throws IllegalArgumentException {
        return checkNumeric(input);
    }

    public int checkNumeric(String input) throws IllegalArgumentException {
        int inputNumber;
        try {
            inputNumber = Integer.parseInt(input);
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException();
        }
        return checkNegative(inputNumber);
    }

    public int checkNegative(int input) throws IllegalArgumentException {
        if (input < 0) {
            throw new IllegalArgumentException();
        }
        return checkBoundary(input);
    }

    public int checkBoundary(int input) throws IllegalArgumentException {
        if (input < 3 || input > 20) {
            throw new IllegalArgumentException();
        }
        return input;
    }

    public String checkMoveValidate(String move) throws IllegalArgumentException {
        if(!(move.equals("U")|move.equals("D"))) {
            throw new IllegalArgumentException();
        }
        return move;
    }
}
