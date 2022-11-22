package bridge.exception;

public class CheckingException {
    public void isNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public void isInputUorD(String moveSpaceAnswer) {
        if (!moveSpaceAnswer.equals("U") && !moveSpaceAnswer.equals("D")) {
            throw new IllegalArgumentException();
        }
    }

    public void isInputRorQ(String retryAnswer) {
        if (!retryAnswer.equals("R") && !retryAnswer.equals("Q")) {
            throw new IllegalArgumentException();
        }
    }
}
