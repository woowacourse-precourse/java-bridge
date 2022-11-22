package bridge.exception;

public class CommandInputWrongException extends IllegalArgumentException{
    private static final String WRONG_COMMAND_MESSAGE = "[ERROR] 게임 재시작 여부는 R 또는 Q만 입력할 수 있습니다.";

    public CommandInputWrongException() {
        super(WRONG_COMMAND_MESSAGE);
    }
}
