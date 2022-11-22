package bridge.exception;

import bridge.constant.message.ErrorMessage;

public class ExceptionInput {

    private static StringBuilder sb = new StringBuilder(ErrorMessage.NOTICE.getMessage());

    public static int validateInputLength(int size) {
        if( !(3 <= size && size <= 20)) {
            sb.append(ErrorMessage.ERROR_INPUT_LENGTH_RANGE.getMessage());
            throw new IllegalArgumentException(sb.toString());
        }
        return size;
    }
}
