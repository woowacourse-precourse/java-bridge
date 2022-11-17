package bridge.exception;

public class LogicException {

    public static void verifyBridgeSize(String size) {
        if (!size.matches("^\\d*")) {
            throw new IllegalArgumentException(ExceptionCode.SIZE_ERROR.getMessage());
        }
        int sizeIntValue = Integer.parseInt(size);
        if(sizeIntValue < 3 || sizeIntValue > 20) {
            throw new IllegalArgumentException(ExceptionCode.SIZE_ERROR.getMessage());
        }
    }

    public static void verifyUserInput(String input) {
        if(!input.equals("U") && !input.equals("D")) {
            throw  new IllegalArgumentException(ExceptionCode.INPUT_ERROR.getMessage());
        }
    }

    public static void verifyRetryOrQuit(String input) {
        if(!input.equals("R") && !input.equals("Q")) {
            throw new IllegalArgumentException(ExceptionCode.INPUT_TRY_ERROR.getMessage());
        }
    }
}
