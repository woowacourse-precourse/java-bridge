package bridge;

public class ExceptionCase {

    private static final int LOW_NUMBER = 3;
    private static final int HIGH_NUMBER = 20;

    static OutputView display = new OutputView();
    static public void isInputUpOrDown(String input) {
        if (!(input.equals("U") || input.equals("D"))) {
            throw new IllegalArgumentException(OutputView.getErrorMessageUpOrDown());
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
            if (!(inputNumber >= LOW_NUMBER && inputNumber <= HIGH_NUMBER)) {
                throw new IllegalArgumentException();
            }
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(OutputView.getErrorMessageAllNumber());
        }
    }
}
