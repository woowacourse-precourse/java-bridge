package bridge.controller;

public class ValidateInput {
    private enum ExceptionMsg {
        Numeric("[ERROR] 다리의 길이는 숫자여야 합니다."),
        END_LETTER("[ERROR] 문자가 올바르지 않습니다.");
        private final String msg;

        ExceptionMsg(String msg) {
            this.msg = msg;
        }
    }

    protected int numeric(String input){
        if (!input.matches("^[0-9]+")) {
            throw new IllegalArgumentException(ExceptionMsg.Numeric.msg);
        }
        return Integer.parseInt(input);
    }
    protected void endLetter(String input){
        if(!input.equals(GameMessage.RETRY) && !input.equals(GameMessage.CLOSE)){
            throw new IllegalArgumentException(ExceptionMsg.END_LETTER.msg);
        }
    }
}
