package bridge.validation;

import java.util.List;

public class BridgeGameValidation {
    private static final String UNEXPECTED_WHEN_EQUAL = "X";
    private static final String UNEXPECTED_WHEN_UNEQUAL = "O";

    public void validateMoveWhenAvailable(String movingCommand, List<String> bridge, List<String> bridgeCurrStatus) {
        int lastIdx = bridge.size() - 1;

        if (movingCommand.equals(bridge.get(lastIdx))) {
            if (bridgeCurrStatus.get(lastIdx).equals(UNEXPECTED_WHEN_EQUAL)) {
                throw new IllegalArgumentException("[ERROR] 이동 가능한 칸이지만 이동하지 않았습니다.");
            }
        }
    }

    public void validateNotMoveWhenUnavailable(String movingCommand, List<String> bridge, List<String> bridgeCurrStatus) {
        int lastIdx = bridge.size() - 1;

        if (! movingCommand.equals(bridge.get(lastIdx))) {
            if (bridgeCurrStatus.get(lastIdx).equals(UNEXPECTED_WHEN_UNEQUAL)) {
                throw new IllegalArgumentException("[ERROR] 이동할 수 없는 칸으로 이동했습니다.");
            }
        }
    }
}
