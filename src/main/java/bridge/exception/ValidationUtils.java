package bridge.exception;

import bridge.constant.GameMessage;

import static bridge.model.Column.BY_CAPITAL_LETTER;

public class ValidationUtils {
    private enum ExceptionMsg {
        Numeric("[ERROR] 다리의 길이는 숫자여야 합니다."),
        END_LETTER("[ERROR] 문자가 올바르지 않습니다."),
        SIZE("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
        LETTER("[ERROR] 문자가 올바르지 않습니다.");
        private final String msg;

        ExceptionMsg(String msg) {
            this.msg = msg;
        }
    }

    public static void numeric(String input){
        if (!input.matches("^[0-9]+")) {
            throw new IllegalArgumentException(ExceptionMsg.Numeric.msg);
        }
    }
    public static void endLetter(String input){
        if(!input.equals(GameMessage.RETRY) && !input.equals(GameMessage.CLOSE)){
            throw new IllegalArgumentException(ExceptionMsg.END_LETTER.msg);
        }
    }
    public static void size(int size) {
        if (size < 3 || 20 < size) {
            throw new IllegalArgumentException(ExceptionMsg.SIZE.msg);
        }
    }
    public static void validateLetter(String input) {
        if(!(BY_CAPITAL_LETTER.containsKey(input)) || input.equals("")){
            throw new IllegalArgumentException(ExceptionMsg.LETTER.msg);
        }
    }
}
