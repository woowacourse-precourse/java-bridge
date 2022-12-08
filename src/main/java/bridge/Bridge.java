package bridge;

import java.util.List;
import java.util.Objects;

public class Bridge {
    private final static int MIN_RANGE = 3;
    private final static int MAX_RANGE = 20;
    private final static String OUT_RANGE_ERROR_MESSAGE = "[ERROR] 3부터 20 사이의 숫자여야 합니다.";
    private final static String INVALID_COMMAND_ERROR_MESSAGE = "[ERROR] U또는 D로 이루어진 리스트여야합니다.";

    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        validateSize(bridge);
        validateInvalidCommand(bridge);
        this.bridge = bridge;
    }

    public boolean isCorrect(int idx, String command) {
        return Objects.equals(bridge.get(idx), command);
    }

    private void validateSize(List<String> bridge) {
        if (bridge.size() < MIN_RANGE || bridge.size() > MAX_RANGE) {
            throw new IllegalArgumentException(OUT_RANGE_ERROR_MESSAGE);
        }
    }

    private void validateInvalidCommand(List<String> bridge) {
        for (String command : bridge) {
            if (!MoveCommand.getMoveCommands().contains(command)) {
                throw new IllegalArgumentException(INVALID_COMMAND_ERROR_MESSAGE);
            }
        }
    }
}