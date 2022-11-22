package bridge.Validator;

import bridge.Enum.BridgeGameInfo;

import java.util.List;

public interface UpDownValidator {
    default boolean isCorrectMove(String input) {
        return List.of(BridgeGameInfo.UP.getWord(), BridgeGameInfo.DOWN.getWord()).contains(input);
    }
}
