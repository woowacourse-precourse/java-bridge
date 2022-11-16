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
}
