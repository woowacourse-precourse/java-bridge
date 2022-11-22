package bridge;

public class ExceptionCase {

    static OutputView display = new OutputView();

    static public void isInputUpOrDown(String input) {
        if (!(input.equals("U") || input.equals("D"))) {
            throw new IllegalArgumentException(OutputView.getErrorMessageUpOrDown());
        }
    }

    static public void isInputBound(int input) {

        if (!(input >= 3 && input <= 20)) {
            throw new IllegalArgumentException("다리의 길이는 3부터 20사이의 숫자여야 합니다.");
        }
    }

    static public void isInputTry(String input) {
        if (!(input.equals("R") || input.equals("Q"))) {
            throw new IllegalArgumentException(OutputView.getErrorMessageInputTry());
        }
    }

    static public int isInputAllNumber(String input) {
        try {
            int inputNumber = Integer.parseInt(input);
            if (!(inputNumber >= 3 && inputNumber <= 20)) {
                throw new IllegalArgumentException();
            }
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(OutputView.getErrorMessageAllNumber());
        }
    }
}
