package bridge.validation;

public class ReadMovingValidation {
    private static final String DOWN_MOVING_COMMAND = "D";
    private static final String UP_MOVING_COMMAND = "U";

    public void validateInputFormat(String movingCommand) {
        if ((! movingCommand.equals(DOWN_MOVING_COMMAND)) && (! movingCommand.equals(UP_MOVING_COMMAND))) {
            throw new IllegalArgumentException("[ERROR] 이동할 칸을 D 또는 U로 입력해주세요.");
        }
    }
}
