package bridge.Validator;

import bridge.Enum.BridgeGameInfo;

import java.util.List;

public interface RestartValidator {
    default boolean isCorrectDecision(String input) {
        return List.of(BridgeGameInfo.RESTART.getWord(),BridgeGameInfo.QUIT.getWord()).contains(input);
    }
}
