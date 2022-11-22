package bridge.command;

/**
 * 다음 움직일 장소를 받는 커맨드 객체입니다
 */
public class ReadMovingCommand {
    private static final String NULL_MESSAGE = "입력에 null 이 들어왔습니다";
    private final String moving;

    public ReadMovingCommand(final String moving) {
        this.moving = moving;
        validate();
    }

    private void validate() {
        if (isNull()) {
            throw new IllegalArgumentException(NULL_MESSAGE);
        }
    }

    private boolean isNull() {
        return moving == null;
    }

    public String getMoving() {
        return moving;
    }
}
