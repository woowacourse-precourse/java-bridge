package bridge.validation;

import java.util.List;

public class BridgeGameValidation {
    public void validateMoveWhenAvailable(String movingCommand, List<String> bridge, List<String> bridgeCurrStatus) {
        int lastIdx = bridge.size() - 1;

        if (movingCommand.equals(bridge.get(lastIdx))) {
            if (bridgeCurrStatus.get(lastIdx).equals("X")) {
                throw new IllegalArgumentException("[ERROR] 이동 가능한 칸이지만 이동하지 않았습니다.");
            }
        }
    }
}
