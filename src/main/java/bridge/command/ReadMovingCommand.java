package bridge.command;

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
