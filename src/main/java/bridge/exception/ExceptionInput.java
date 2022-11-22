package bridge.exception;

import bridge.constant.message.ErrorMessage;

public class ExceptionInput {

    private static StringBuilder sb;

    public static int validateInputLength(int size) {
        sb = new StringBuilder(ErrorMessage.NOTICE.getMessage());
        if( !(3 <= size && size <= 20)) {
            sb.append(ErrorMessage.ERROR_INPUT_LENGTH_RANGE.getMessage());
            throw new IllegalArgumentException(sb.toString());
        }
        return size;
    }
}
